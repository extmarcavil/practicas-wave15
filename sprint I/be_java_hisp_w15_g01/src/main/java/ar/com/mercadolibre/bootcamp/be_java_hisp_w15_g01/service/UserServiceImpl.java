package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.OwnFollowingException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.UserNotFoundException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public UserServiceImpl(UserRepository userRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    @Override
    public ResponseDTO follow(Long userId, long userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new OwnFollowingException();
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToFollow);
        this.followRepository.save(follower, followed);

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Followed!");
        return dto;
    }

    @Override
    public User findById(Long id) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            throw new UserNotFoundException();
        }
    }
}
