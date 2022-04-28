package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.IUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IMeliRepository userRepository;
    private final IUtils utils;
    private final ModelMapper mapper;

    public UserService(IMeliRepository userRepository, IUtils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
        this.mapper = new ModelMapper();
    }

    /**
     * Se realiza el seguimiento de un usuario a un vendedor.
     * @param userId es el usuario
     * @param sellerToFollow es el vendedor
     */
    @Override
    public void followSeller(Integer userId, Integer sellerToFollow) {
        utils.existeSeller(sellerToFollow);
        utils.existeUser(userId);

        if(!userRepository.following(userId, sellerToFollow)){
            userRepository.followSeller(userId, sellerToFollow);
        } else {
            throw new RelationConflictException("El usuario: " + userId + " ya sigue al vendedor: " + sellerToFollow);
        }


    }

    /**
     * Se obtiene la cantidad de seguidores de un vendedor requerido.
     * @param sellerId id del vendedor
     * @return Se devuelven los datos del vendedor junto con la cantidad de seguidores
     */
    @Override
    public SellerCountDTO getFollowersCount(Integer sellerId) {
            utils.existeSeller(sellerId);
            Seller seller = userRepository.getSeller(sellerId);
            SellerCountDTO sellerCountDTO = mapper.map(seller, SellerCountDTO.class);
            sellerCountDTO.setFollowersCount(seller.getFollowers().size());
            return sellerCountDTO;

    }

    /**
     * Se obtienen la lista de seguidores para un vendedor
     * @param sellerId El vendedor que se desea saber quien lo sigue
     * @param order orden en que se muestran los seguidores (name_asc, name_desc)
     * @return devuelve los datos del vendedor con una lista de datos de los usuarios que lo siguen,
     * ordenada segun el filtro seleccionado
     */
    @Override
    public SellerFListDTO getFollowersList(Integer sellerId, String order) {
            utils.existeSeller(sellerId);

            Seller seller = userRepository.getSeller(sellerId);
            SellerFListDTO sellerFListDTO = new SellerFListDTO();

            List<PersonDTO> personList = seller.getFollowers().stream()
                    .map(f -> mapper.map(f, PersonDTO.class))
                    .collect(Collectors.toList());

            sellerFListDTO.setFollowers(orderByName(personList, order));
            sellerFListDTO.setUserId(sellerId);
            sellerFListDTO.setUserName(seller.getUserName());
            return sellerFListDTO;

    }

    /**
     * Se devuelve una lista de los vendedores seguidos por un usuario
     * @param userId id del usuario que queremos consultar sus seguidos
     * @param order orden deseado para devolverlo
     * @return devuelve los datos del usuario y una lista con los datos de los vendedores que sigue
     */
    @Override
    public UserListDTO getFollowedList(Integer userId, String order) {
            utils.existeUser(userId);
            User user = userRepository.getUser(userId);
            UserListDTO userListDTO = new UserListDTO();

            List<PersonDTO> personList = user.getFollowed().stream()
                    .map(u -> mapper.map(u, PersonDTO.class))
                    .collect(Collectors.toList());

            userListDTO.setFollowed(orderByName(personList, order));
            userListDTO.setUserId(userId);
            userListDTO.setUserName(user.getUserName());
            return userListDTO;

    }

    /**
     * Permite que un usuario deje de seguir a un vendedor
     * @param userId id del usuario que quiere dejar de seguir al vendedor
     * @param sellerToUnfollow id del vendedor al que dejar de seguir
     */
    @Override
    public void unFollowSeller(Integer userId, Integer sellerToUnfollow) {
            utils.existeSeller(sellerToUnfollow);
            utils.existeUser(userId);

            if(userRepository.following(userId, sellerToUnfollow)){
                userRepository.unFollowSeller(userId, sellerToUnfollow);
            } else {
                throw new RelationConflictException("El usuario: " + userId + " no sigue al vendedor: " + sellerToUnfollow);
            }

    }

    /**
     * Obtiene los vendedores que venden cierto producto
     * @param idProduct producto que interesa saber quien lo vende
     * @return Devuelve la lista de vendedores que venden el producto pedido
     */
    @Override
    public SellersPerProdListDTO getSellersProduct(Integer idProduct) {
        SellersPerProdListDTO sellersDto = new SellersPerProdListDTO();
        if (userRepository.hasProduct(idProduct)) {
            List<Seller> sellers = userRepository.getSellers();
            sellers = sellers.stream().filter(seller->hasProduct(seller,idProduct)).collect(Collectors.toList());
            sellersDto.setSellers(sellers.stream().map(u -> mapper.map(u, PersonDTO.class))
                    .collect(Collectors.toList()));
            sellersDto.setProductId(idProduct);
        }else{
            throw new ProductNotFoundException("El producto con el id: " + idProduct + " no fue ingresado.");
        }

        return sellersDto;
    }

    /**
     * obtiene todos los vendedores disponibles
     * @return devuelve una lista de vendedores
     */
    @Override
    public SellersListDTO getSellers() {
        List<Seller> sellers = userRepository.getSellers();
        List<PersonDTO> sellersDTO= sellers.stream().map(u-> mapper.map(u, PersonDTO.class)).collect(Collectors.toList());
        return new SellersListDTO(sellersDTO);
    }

    /**
     * Metodo creado para realizar el ordenamiento por nombre de la lista de personas
     * @param personList lista a ordenar
     * @param order metodo seleccionado (name_asc, name_desc)
     * @return devuelve la lista ordenada segun el metodo
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

    /**
     * Metodo llamado para ver si tiene determinado producto un vendedor
     * @param s vendedor
     * @param prodId id del producto a consultar
     * @return booleano indicando si lo tiene
     */
    private boolean hasProduct(Seller s, Integer prodId){
       return s.getPublications().stream().anyMatch(p->p.getDetail().getProductId().equals(prodId));

    }
}
