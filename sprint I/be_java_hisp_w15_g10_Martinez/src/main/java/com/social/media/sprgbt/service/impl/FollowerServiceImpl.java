package com.social.media.sprgbt.service.impl;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.entity.Follower;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.FollowerMapper;
import com.social.media.sprgbt.repository.IFollowerRepository;
import com.social.media.sprgbt.service.IFollowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FollowerServiceImpl implements IFollowerService {

    /**
     * Follower Repository instance.
     */
    private final IFollowerRepository followerRepository;

    /**
     * Follower Mapper instance.
     */
    private final FollowerMapper followerMapper;

    /**
     * Dependency injection
     *
     * @param followerRepository
     * @param followerMapper
     */
    public FollowerServiceImpl(IFollowerRepository followerRepository, FollowerMapper followerMapper) {
        this.followerRepository = followerRepository;
        this.followerMapper = followerMapper;
    }


    /**
     * Create Follower
     *
     * @param followerDto
     * @return {@link FollowerDto} obj
     * @throws ExistingException
     */
    @Override
    public FollowerDto createFollower(FollowerDto followerDto) throws ExistingException {

        Follower entityFollower = followerMapper.mapToEntity(followerDto);

        Follower existingFollower = followerRepository.getFollowerByUserIdAndUserIdToFollow(entityFollower.getUserId(), entityFollower.getUserIdToFollow());

        if (existingFollower != null) {
            throw new ExistingException(String.format("El Usuario con userId: %s ya es seguidor del Usuario con userId: %s.",
                    existingFollower.getUserId(), existingFollower.getUserIdToFollow()));
        }

        Follower newEntityFollower = followerRepository.createFollower(entityFollower);

        log.info("Follower: {}", newEntityFollower);

        return followerMapper.mapToDto(newEntityFollower);
    }

    /**
     * Get Count Followers By Seller.
     *
     * @param userIdToFollow
     * @return
     */
    @Override
    public Integer getCountFollowersBySeller(Integer userIdToFollow) {

        List<Follower> listFollowersBySeller = followerRepository.getListFollowersBySeller(userIdToFollow);

        return listFollowersBySeller.size();
    }

    /**
     * Get All Followers By Seller.
     *
     * @param userIdToFollow
     * @return
     */
    @Override
    public List<FollowerDto> getAllFollowersBySeller(Integer userIdToFollow) {

        List<Follower> listFollowersBySeller = followerRepository.getListFollowersBySeller(userIdToFollow);

        List<FollowerDto> listFollowersDtoBySeller = listFollowersBySeller.stream()
                .map(obj -> followerMapper.mapToDto(obj))
                .collect(Collectors.toList());

        return listFollowersDtoBySeller;
    }

    /**
     * Get All Followed By User.
     *
     * @param userId
     * @return
     */
    @Override
    public List<FollowerDto> getListFollowedByUser(Integer userId) {

        List<Follower> listFollowedByUser = followerRepository.getListFollowedByUser(userId);

        List<FollowerDto> listFollowersDtoByUser = listFollowedByUser.stream()
                .map(obj -> followerMapper.mapToDto(obj))
                .collect(Collectors.toList());

        return listFollowersDtoByUser;
    }

    /**
     * Unfollow A Seller
     *
     * @param userId
     * @param userIdToFollow
     * @return {@link FollowerDto} obj
     * @throws NotFoundException
     */
    @Override
    public FollowerDto unfollowASeller(Integer userId, Integer userIdToFollow) throws NotFoundException {

        Follower existingFollowerEntity = followerRepository.getFollowerByUserIdAndUserIdToFollow(userId, userIdToFollow);

        if (existingFollowerEntity == null) {
            throw new NotFoundException(String.format("El Usuario con userId: %s NO es un seguidor del Usuario con userId: %s.", userId, userIdToFollow));
        }

        followerRepository.deleteFollower(existingFollowerEntity);

        return followerMapper.mapToDto(existingFollowerEntity);
    }

}
