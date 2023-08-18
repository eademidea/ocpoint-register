package br.com.ocpoint.service;

import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.model.response.UserResponse;

public interface UserService {
    public UserResponse createUser(UserRequest userRequest);

    public String login(String username, String password);
}
