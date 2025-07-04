package com.example.rediswithsql.service.impl;

import com.example.rediswithsql.model.User;
import com.example.rediswithsql.repository.UserRepository;
import com.example.rediswithsql.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Cacheable(value = "users", key = "#id")
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    @CachePut(value = "users", key = "#user.id")
    public User saveUser(User user) {
        User newUser = User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
        userRepository.save(newUser);
        return newUser;
    }

//    When this method runs, Redis will delete users::id from the cache
//    Always runs
    @Override
    @CacheEvict(value = "users", key = "#id")
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "Successfully deleted user";
    }

//    update the Redis cache for key users::user.id with the latest object(Update & Cache refresh)
//    CachePut always executes unlike Cacheable
    @Override
    @CachePut(value = "users", key = "#user.id")
    public User updateUser(String id, User user) {
        User fetchedUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        fetchedUser.setName(user.getName());
        fetchedUser.setEmail(user.getEmail());

        return userRepository.save(fetchedUser);
    }


}
