package com.spring.ejerciciocarritocomprasvivo.service;

import com.spring.ejerciciocarritocomprasvivo.dto.CartDTO;
import com.spring.ejerciciocarritocomprasvivo.entities.Cart;
import com.spring.ejerciciocarritocomprasvivo.repository.ICartRepository;
import com.spring.ejerciciocarritocomprasvivo.repository.IItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {

    private final ICartRepository cartRepository;
    private final IItemRepository itemRepository;

    public CartService(ICartRepository cartRepository, IItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }


    @Override
    public CartDTO saveCart(CartDTO cartDTO) {
        ModelMapper model = new ModelMapper();
        //Mapeo del CartDTO a Cart
        Cart cart = model.map(cartDTO, Cart.class);
        //Seteo del Cart de cada Item dentro del Cart
        cart.getItems().forEach(item -> item.setCart(cart));

        //Persistencia del Cart y mapeo de la respuesta a CartDTO
        CartDTO cartResponse = model.map(cartRepository.save(cart), CartDTO.class);
        return cartResponse;
    }

    @Override
    public List<CartDTO> listAll() {
        ModelMapper model = new ModelMapper();
        List<Cart> carritos = cartRepository.findAll();
        List<CartDTO> carritosDTO = new ArrayList<>();

        carritos.forEach(cart -> carritosDTO.add(
                model.map(cart, CartDTO.class)
        ));
        return carritosDTO;
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
