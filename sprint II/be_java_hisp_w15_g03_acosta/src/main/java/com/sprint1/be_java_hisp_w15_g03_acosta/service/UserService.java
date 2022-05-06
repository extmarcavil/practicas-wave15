package com.sprint1.be_java_hisp_w15_g03_acosta.service;

import com.sprint1.be_java_hisp_w15_g03_acosta.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IMeliRepository userRepository;
    private final ModelMapper mapper;

    public UserService(IMeliRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    /**
     * Método en el cual un usuario puede seguir a un vendedor.
     * @param userId Id que identifica al usuario.
     * @param sellerToFollow Id que identifica al vendor que sera seguido.
     * @throws PersonNotFoundException el userId y/o sellerToFollow no existen en la base de datos.
     */
    @Override
    public void followSeller(Integer userId, Integer sellerToFollow) {
        if (userRepository.hasUser(userId) && userRepository.hasSeller(sellerToFollow)) {
            if(!userRepository.following(userId, sellerToFollow)){
                userRepository.followSeller(userId, sellerToFollow);
            } else {
                throw new RelationConflictException("El usuario: " + userId + " ya sigue al vendedor: " + sellerToFollow);
            }

        } else {
            throw new PersonNotFoundException("El vendedor o el usuario no existen");
        }
    }

    /**
     * Método para obtener la cantidad de seguidores que tiene un vendedor específico.
     * @param sellerId Id que identifica al vendedor.
     * @return retorna un SellerCountDTO que contiene el nombre y id del vendedor como la cantidad de followers.
     * @throws PersonNotFoundException el sellerId no existe.
     */
    @Override
    public SellerCountDTO getFollowersCount(Integer sellerId) {
        if (userRepository.hasSeller(sellerId)) {
            Seller seller = userRepository.getSeller(sellerId);
            SellerCountDTO sellerCountDTO = mapper.map(seller, SellerCountDTO.class);
            sellerCountDTO.setFollowersCount(seller.getFollowers().size());
            return sellerCountDTO;
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }
    }

    /**
     * Método para obtener una lista de seguidores que tiene un vendedor específico
     * la misma puede estar ordenada alfabéticamente o no.
     * @param sellerId Id que identifica al vendedor.
     * @param order referente al orden que se quiere designar la lista recibida, puede ser asc o desc.
     * @return retorna un SellerFListDTO que contiene el nombre y id del vendedor como la lista de followers.
     * @throws PersonNotFoundException el sellerId no existe.
     */
    @Override
    public SellerFListDTO getFollowersList(Integer sellerId, String order) {
        if (userRepository.hasSeller(sellerId)) {
            Seller seller = userRepository.getSeller(sellerId);
            SellerFListDTO sellerFListDTO = new SellerFListDTO();

            List<PersonDTO> personList = seller.getFollowers().stream()
                    .map(f -> mapper.map(f, PersonDTO.class))
                    .collect(Collectors.toList());

            sellerFListDTO.setFollowers(orderByName(personList, order));
            sellerFListDTO.setUserId(sellerId);
            sellerFListDTO.setUserName(seller.getUserName());
            return sellerFListDTO;
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }
    }

    /**
     * Método para obtener una lista de vendedores que sigue un usuario específico
     * la misma puede estar ordenada alfabéticamente o no.
     * @param userId Id que identifica a un usuario.
     * @param order referente al orden que se quiere designar la lista recibida, puede ser asc o desc.
     * @return retorna un UserListDTO que contiene un usuario y id del usuario como también la lista de followed.
     * @throws PersonNotFoundException el userId no existe.
     */
    @Override
    public UserListDTO getFollowedList(Integer userId, String order) {
        if (userRepository.hasUser(userId)) {
            User user = userRepository.getUser(userId);
            UserListDTO userListDTO = new UserListDTO();

            List<PersonDTO> personList = user.getFollowed().stream()
                    .map(u -> mapper.map(u, PersonDTO.class))
                    .collect(Collectors.toList());

            userListDTO.setFollowed(orderByName(personList, order));
            userListDTO.setUserId(userId);
            userListDTO.setUserName(user.getUserName());
            return userListDTO;
        } else {
            throw new PersonNotFoundException("El usuario con el id: " + userId + " no existe");
        }
    }

    /**
     * Método en el cual un usuario puede dejar de seguir a un vendedor.
     * @param userId Id que identifica al usuario.
     * @param sellerToUnfollow Id que identifica al vendedor.
     */
    @Override
    public void unFollowSeller(Integer userId, Integer sellerToUnfollow) {
        if (userRepository.hasUser(userId) && userRepository.hasSeller(sellerToUnfollow)) {
            if(userRepository.following(userId, sellerToUnfollow)){
                userRepository.unFollowSeller(userId, sellerToUnfollow);
            } else {
                throw new RelationConflictException("El usuario: " + userId + " no sigue al vendedor: " + sellerToUnfollow);
            }
        } else {
            throw new PersonNotFoundException("El vendedor o el usuario no existen");
        }
    }

    /**
     * Método privado para ordenar una respectiva lista de personas por nombre en el orden solicitado.
     * @param personList lista de personas a ser ordenadas.
     * @param order referente al orden que se quiere designar la lista recibida, puede ser asc o desc.
     * @return retorna una List<PersonDTO> ya ordenada.
     */
    private List<PersonDTO> orderByName(List<PersonDTO> personList, String order){
        if(order != null){
            switch(order){
                case "name_asc":
                    personList.sort(Comparator.comparing(PersonDTO::getUserName));
                    break;
                case "name_desc":
                    personList.sort(Comparator.comparing(PersonDTO::getUserName).reversed());
                    break;
                default:
                    throw new OrderInvalidException("El orden solicitado no existe");
            }
        }
        return personList;
    }
}
