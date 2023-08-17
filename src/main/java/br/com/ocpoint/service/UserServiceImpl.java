package br.com.ocpoint.service;

import org.springframework.stereotype.Service;

import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        return this.userRepository.save(getUser(userRequest));
    }

    //TODO: método ainda em construção...
    private User getUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .user(userRequest.getUser())
                .build();
    }

}
