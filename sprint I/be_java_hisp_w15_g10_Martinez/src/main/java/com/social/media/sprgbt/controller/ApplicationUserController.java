package com.social.media.sprgbt.controller;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.facade.IApplicationUserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

    /**
     * SocialService instance.
     */
    private final IApplicationUserFacade applicationUserFacade;


    /**
     * ApplicationUserController
     *
     * @param applicationUserFacade instance.
     */
    public ApplicationUserController(IApplicationUserFacade applicationUserFacade) {
        this.applicationUserFacade = applicationUserFacade;
    }

    /**
     * Create User.
     *
     * @param dto
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) throws ExistingException {

        UserDto newDto = applicationUserFacade.createUser(dto);

        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }

    /**
     * Get All Users.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> listUsersDto = applicationUserFacade.getAllUsers();

        return new ResponseEntity<>(listUsersDto, HttpStatus.OK);
    }

    /**
     * Get User By Username.
     *
     * @param username
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) throws NotFoundException {

        UserDto dto = applicationUserFacade.getUserByUsername(username);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Follow A Seller.
     *
     * @param userId
     * @param userIdToFollow
     * @return
     * @throws NotFoundException
     * @throws ExistingException
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followASeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws NotFoundException, ExistingException {

        String message = applicationUserFacade.followASeller(userId, userIdToFollow);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Get Count Followers By Seller.
     *
     * @param userId
     * @return {@link UserDto} obj
     * @throws NotFoundException
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDto> getCountFollowersBySeller(@PathVariable Integer userId) throws NotFoundException {

        UserDto dto = applicationUserFacade.getCountFollowersBySeller(userId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Get List Followers By Seller.
     *
     * @param userId
     * @return {@link UserDto} obj
     * @throws NotFoundException
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDto> getAllFollowersBySeller(@PathVariable Integer userId,
                                                           @RequestParam(defaultValue = "name_asc") String order) throws NotFoundException {

        UserDto dto = applicationUserFacade.getAllFollowersBySeller(userId, order);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Get List Followed By User.
     *
     * @param userId
     * @return {@link UserDto} obj
     * @throws NotFoundException
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDto> getListFollowedByUser(@PathVariable Integer userId,
                                                         @RequestParam(defaultValue = "name_asc") String order) throws NotFoundException {

        UserDto dto = applicationUserFacade.getListFollowedByUser(userId, order);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    /**
     * Stop Following a userIdToUnfollow
     *
     * @param userId
     * @return {@link String} obj
     * @throws NotFoundException, FollowerNotFoundException.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowASeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws NotFoundException {

        String message = applicationUserFacade.unfollowASeller(userId, userIdToUnfollow);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
