package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.RelationNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
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

    @Override
    public void followSeller(Integer userId, Integer sellerToFollow) {
        if (userRepository.hasUser(userId) && userRepository.hasSeller(sellerToFollow)) {
            if(!userRepository.following(userId, sellerToFollow)){
                userRepository.followSeller(userId, sellerToFollow);
            } else {
                throw new RelationNotFoundException("El usuario: " + userId + " ya sigue al vendedor: " + sellerToFollow);
            }

        } else {
            throw new PersonNotFoundException("El vendedor o el usuario no existen");
        }
    }

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

    @Override
    public void unFollowSeller(Integer userId, Integer sellerToUnfollow) {
        if (userRepository.hasUser(userId) && userRepository.hasSeller(sellerToUnfollow)) {
            if(userRepository.following(userId, sellerToUnfollow)){
                userRepository.unFollowSeller(userId, sellerToUnfollow);
            } else {
                throw new RelationNotFoundException("El usuario: " + userId + " no sigue al vendedor: " + sellerToUnfollow);
            }
        } else {
            throw new PersonNotFoundException("El vendedor o el usuario no existen");
        }
    }

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
