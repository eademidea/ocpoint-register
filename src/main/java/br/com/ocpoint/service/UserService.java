package br.com.ocpoint.service;

import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;

public interface UserService {
    public User createUser(UserRequest userRequest);
}
