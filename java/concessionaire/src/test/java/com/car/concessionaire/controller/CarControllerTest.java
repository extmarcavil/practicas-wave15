package com.car.concessionaire.controller;

import com.car.concessionaire.adapter.LocalDateAdapter;
import com.car.concessionaire.dto.CarDto;
import com.car.concessionaire.exceptions.CarDoesNotExistException;
import com.car.concessionaire.model.Car;
import com.car.concessionaire.service.CarService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static com.car.concessionaire.utils.CarFixture.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CarControllerTest {

    private static final String PATH = "/v1/api/vehicles";
    private static final String GET_BY_PRICES = String.format(PATH+"/%s", "prices");
    private static final String GET_BY_DATES = String.format(PATH+"/%s", "dates");
    private static final String GET_BY_ID = PATH+"/{id}";

    @Mock
    private CarService carService;
    @Autowired
    private CarController controller;

    private MockMvc mockApiRest;
    private Gson mapper;
    private Car car;

    @BeforeEach
    void setUp() {
        controller = new CarController(carService);
        mapper = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        mockApiRest = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice().build();
        car = aCarComplete();
        when(carService.create(car)).thenReturn(car);
    }

    @ParameterizedTest
    @MethodSource("invalidRequestBody")
    void whenTheRequestBodyOfTheSaveIsInvalid_thenAnExceptionIsThrown(Car carInvalid, String errorMessage) throws Exception {
        mockApiRest.perform(post(PATH)
                .contentType(APPLICATION_JSON)
                .content(toJson(carInvalid)))
                .andExpect(status().isBadRequest())
                .andExpect(error -> {
                    Exception exception = error.getResolvedException();
                    assertThat(error.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
                    assertThat(exception instanceof MethodArgumentNotValidException).isTrue();
                    assertThat(exception).hasMessageContaining(errorMessage);
                });
    }

    private static Stream<Arguments> invalidRequestBody() {
        return Stream.of(
                Arguments.of(carWithLessThanOneDoor(), "The car must have doors"),
                Arguments.of(carPriceLessThanOne(), "The price must be greater than 0"),
                Arguments.of(carWithoutAnOwner(), "The car has to have an owner"),
                Arguments.of(carWithFieldsNull(), "must not be null")
        );
    }

    @Test
    void whenTheRequestBodyOfTheSaveIsCorrectly_thenItsSavedAndReturned() {
        ResponseEntity<Car> carExpected = controller.save(car);

        assertThat(carExpected.getBody()).usingRecursiveComparison().isEqualTo(car);
        assertThat(carExpected.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void whenTheRequestBodyOfTheSaveIsCorrectlyPostMethod_thenItsSavedAndReturned() throws Exception {
        when(carService.create(any())).thenReturn(car);

        String response = mockApiRest.perform(post(PATH)
                        .contentType(APPLICATION_JSON)
                        .content(toJson(car)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        Car carExpected = fromJson(response, Car.class);

        assertThat(carExpected).usingRecursiveComparison().isEqualTo(car);
    }

    @Test
    void whenAllCarsAreRequested_thenAreReturnedAsCarDto() {
        when(carService.getAll()).thenReturn(List.of(CarDto.from(car)));
        List<CarDto> carsDtoExpected = controller.getCarsDto();

        carsDtoExpected.forEach(dto -> {
            assertThat(dto.getManufacturingDate()).isEqualTo(car.getManufacturingDate());
            assertThat(dto.getBrand()).isEqualTo(car.getBrand());
            assertThat(dto.getCountOfOwners()).isEqualTo(car.getCountOfOwners());
            assertThat(dto.getCurrency()).isEqualTo(car.getCurrency());
            assertThat(dto.getDoors()).isEqualTo(car.getDoors());
            assertThat(dto.getModel()).isEqualTo(car.getModel());
            assertThat(dto.getNumberOfKilometers()).isEqualTo(car.getNumberOfKilometers());
            assertThat(dto.getPrice()).isEqualTo(car.getPrice());
        });
    }

    @Test
    void whenAllCarsAreRequestedGetMethod_thenAreReturnedAsCarDto() throws Exception {
        List<CarDto> carsDto = List.of(CarDto.from(car), CarDto.from(otherCarComplete()));
        when(carService.getAll()).thenReturn(carsDto);

        String response = mockApiRest.perform(get(PATH)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<CarDto> carsDtoExpected = jsonToArray(response, CarDto.class);

        assertThat(carsDtoExpected.size()).isEqualTo(2);
        assertThat(carsDtoExpected).usingRecursiveComparison().isEqualTo(carsDto);
    }

    @Test
    void whenACarIsRequestedByIdAndDoesNotExist_thenAnExceptionIsThrown() {
        Long nonExistingId = 1L;
        when(carService.findById(anyLong())).thenThrow(new CarDoesNotExistException(nonExistingId));

        assertThatThrownBy(() -> controller.getCarById(anyLong()))
                .isInstanceOf(CarDoesNotExistException.class)
                .hasMessage(String.format("Car with %s does not exist.", nonExistingId));
    }

    @Test
    void whenACarIsRequestedById_thenItsReturned() {
        when(carService.findById(car.getId())).thenReturn(car);

        assertThat(controller.getCarById(car.getId())).isNotNull();
    }

    @Test
    void whenACarIsRequestedByIdGetMethod_thenItsReturned() throws Exception {
        car.setId(10L);
        when(carService.findById(car.getId())).thenReturn(car);
        String idCar = String.valueOf(car.getId());

        String response = makeRequestWithIdAndExpectStatusOK(idCar);
        Car carExpected = fromJson(response, Car.class);

        assertThat(response).isNotNull();
        assertThat(carExpected).usingRecursiveComparison().isEqualTo(car);
    }

    @ParameterizedTest
    @MethodSource("pathsRequestParam")
    void whenTheRequestParamForSearchingAreEmpty_thenAnExceptionIsThrown(String path) throws Exception {
        mockApiRest.perform(get(path)
                        .contentType(APPLICATION_JSON)
                        .param("since", "")
                        .param("to", ""))
                .andExpect(status().isBadRequest())
                .andExpect(error -> {
                    Exception exception = error.getResolvedException();
                    assertThat(error.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
                    assertThat(exception instanceof MissingServletRequestParameterException).isTrue();
                });
    }

    public static Stream<String> pathsRequestParam() {
        return Stream.of(GET_BY_DATES, GET_BY_PRICES);
    }

    @Test
    void whenTheRequestParamsForSearchingByPricesAreCorrectly_thenAListOfCarsIsReturned() throws Exception {
        BigDecimal since = new BigDecimal("130000");
        BigDecimal to = new BigDecimal("115000");
        List<Car> cars = List.of(createCarWithPrice(since), createCarWithPrice(to));

        when(carService.filterByPrices(since, to)).thenReturn(cars);

        String response = makeRequestWithPathAndQueryFilter(GET_BY_PRICES, String.valueOf(since), String.valueOf(to));
        List<Car> carsFilteredExpected = fromJson(response);

        assertThat(carsFilteredExpected).isNotNull();
        assertThat(carsFilteredExpected.size()).isEqualTo(2);
    }

    @Test
    void whenTheRequestParamsForSearchingByDatesAreCorrectly_thenAListOfCarsIsReturned() throws Exception {
        LocalDate since = LocalDate.of(2021, 1, 1);
        LocalDate to = LocalDate.of(2022, 12, 31);
        List<Car> cars = List.of(createCarWithManufacturingDate(since), createCarWithManufacturingDate(to));

        when(carService.filterByDates(since, to)).thenReturn(cars);

        String response = makeRequestWithPathAndQueryFilter(GET_BY_DATES, String.valueOf(since), String.valueOf(to));
        List<Car> carsFilteredExpected = fromJson(response);

        assertThat(carsFilteredExpected).isNotNull();
        assertThat(carsFilteredExpected.size()).isEqualTo(2);
    }

    private String makeRequestWithPathAndQueryFilter(String PATH, String since, String to) throws Exception {
        return mockApiRest.perform(get(PATH)
                        .contentType(APPLICATION_JSON)
                        .param("since", since)
                        .param("to", to))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    private String makeRequestWithIdAndExpectStatusOK(String id) throws Exception {
        return mockApiRest.perform(get(GET_BY_ID, id)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    private <T> String toJson(T object) {
        return mapper.toJson(object);
    }

    private <T> T fromJson(String json, Class<T> clazz) {
        return mapper.fromJson(json, clazz);
    }

    private <T> List<T> fromJson(String response) {
        return mapper.fromJson(response, new TypeToken<List<T>>() {}.getType());
    }

    public <T> List<T> jsonToArray(String json, Class<T> clazz) {
        return mapper.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }
}