package com.meli.relaciones.service;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.entities.Cart;
import com.meli.relaciones.repository.CartRepository;
import com.meli.relaciones.repository.ItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService{

    CartRepository repoCart;
    ItemsRepository repoItems;

    public CartServiceImp(CartRepository repoCart, ItemsRepository repoItems){
        this.repoCart = repoCart;
        this.repoItems = repoItems;
    }

    @Override
    public CartDto saveCart(CartDto cartDto){
        ModelMapper model = new ModelMapper();

        Cart cart = model.map(cartDto,Cart.class);
        cart.getItems().forEach((i)-> i.setCart(cart));
        Cart cart2 = repoCart.save(cart);

        CartDto response= model.map(cart2,CartDto.class);
        return response;
    }

    @Override
    public List<CartDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<CartDto> carritosDto = new ArrayList<>();
        List<Cart> carritosEntidad = repoCart.findAll();

        carritosEntidad.forEach((carro)-> carritosDto.add(mapper.map(carro,CartDto.class)));

        return carritosDto;
    }

    @Override
    public void delete(Long id) {
        repoCart.deleteById(id);
    }
}
