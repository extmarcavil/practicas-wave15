package com.social.media.sprgbt.facade.impl;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.facade.IApplicationUserFacade;
import com.social.media.sprgbt.service.IFollowerService;
import com.social.media.sprgbt.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ApplicationUserFacadeImpl implements IApplicationUserFacade {

    /**
     * User Service instance.
     */
    private final IUserService userService;

    /**
     * Folllower Service instance.
     */
    private final IFollowerService followerService;

    /**
     * Dependency Injection.
     *
     * @param userService     instance
     * @param followerService instance
     */
    public ApplicationUserFacadeImpl(IUserService userService, IFollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }

    /**
     * Create User.
     *
     * @param dto param
     * @return {@link UserDto} obj
     * @throws ExistingException expection
     */
    @Override
    public UserDto createUser(UserDto dto) throws ExistingException {
        return userService.createUser(dto);
    }

    /**
     * Get All Users.
     *
     * @return {@link UserDto} list
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get User By Username.
     *
     * @param username param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getUserByUsername(String username) throws NotFoundException {
        return userService.getUserByUsername(username);
    }

    /**
     * Follow A Seller.
     *
     * @param userId         param
     * @param userIdToFollow param
     * @return message
     * @throws NotFoundException exception
     * @throws ExistingException exception
     */
    @Override
    public String followASeller(Integer userId, Integer userIdToFollow) throws NotFoundException, ExistingException {

        // Comprobamos si los usuarios existen
        UserDto followerUserDto = userService.getUserById(userId);
        UserDto followingUserDto = userService.getUserById(userIdToFollow);

        FollowerDto followerDto = FollowerDto.builder()
                .userId(followerUserDto.getUserId())
                .userIdToFollow(followingUserDto.getUserId())
                .build();

        FollowerDto newFollowerDto = followerService.createFollower(followerDto);
        log.info("FollowerDto: {}", newFollowerDto);

        return String.format("El Usuario: %s ahora sigue al Vendedor: %s", followerUserDto.getUserName(), followingUserDto.getUserName());
    }

    /**
     * Get Count Followers By Seller.
     *
     * @param userIdToFollow param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getCountFollowersBySeller(Integer userIdToFollow) throws NotFoundException {

        UserDto userDto = userService.getUserById(userIdToFollow);
        userDto.setFollowersCount(followerService.getCountFollowersBySeller(userIdToFollow));

        return userDto;
    }

    /**
     * Get List Followers By Seller.
     *
     * @param userIdToFollow param
     * @param order          param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getAllFollowersBySeller(Integer userIdToFollow, String order) throws NotFoundException {

        UserDto userDto = userService.getUserById(userIdToFollow);

        List<FollowerDto> listFollowersDtoBySeller = followerService.getAllFollowersBySeller(userIdToFollow);

        List<UserDto> listUsersDtoBySeller = listFollowersDtoBySeller.stream()
                .map(objFollowerDto -> userService.getUserById(objFollowerDto.getUserId()))
                .collect(Collectors.toList());

        //Orden Ascendente por default
        listUsersDtoBySeller = listUsersDtoBySeller.stream()
                .sorted()
                .collect(Collectors.toList());

        // Orden Descendente
        if ("name_desc".equals(order)) {
            listUsersDtoBySeller = listUsersDtoBySeller.stream().sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        }

        userDto.setFollowers(listUsersDtoBySeller);

        return userDto;
    }

    /**
     * Get List Followed By User.
     *
     * @param userId param
     * @param order  param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getListFollowedByUser(Integer userId, String order) throws NotFoundException {

        UserDto userDto = userService.getUserById(userId);

        List<FollowerDto> listFollowersDtoByUser = followerService.getListFollowedByUser(userId);

        List<UserDto> listUsersDtoByUser = listFollowersDtoByUser.stream()
                .map(objFollowerDto -> userService.getUserById(objFollowerDto.getUserIdToFollow()))
                .collect(Collectors.toList());

        //Orden Ascendente por default
        listUsersDtoByUser = listUsersDtoByUser.stream()
                .sorted()
                .collect(Collectors.toList());

        // Orden Descendente
        if ("name_desc".equals(order)) {
            listUsersDtoByUser = listUsersDtoByUser.stream().sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        }
        userDto.setFollowed(listUsersDtoByUser);

        return userDto;
    }

    /**
     * Unfollow A Seller
     *
     * @param userId         param
     * @param userIdToFollow param
     * @return message
     * @throws NotFoundException exception
     */
    @Override
    public String unfollowASeller(Integer userId, Integer userIdToFollow) throws NotFoundException {

        // Comprobamos si los usuarios existen
        userService.getUserById(userId);
        userService.getUserById(userIdToFollow);

        FollowerDto followerDto = followerService.unfollowASeller(userId, userIdToFollow);

        return String.format("El Usuario: %s ahora dejo de seguir al Vendedor: %s", followerDto.getUserId(), followerDto.getUserIdToFollow());
    }

}
