package br.com.ocpoint.utils;

import java.time.LocalDateTime;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.Person;
import br.com.ocpoint.model.request.UserRequest;

public class TestUtils {
    public UserRequest getUserRequest() {
        var userRequest = new UserRequest();
        userRequest.setDocument("12345678910");
        userRequest.setGroup(2);
        userRequest.setUser("Teste");
        userRequest.setPassword("1234512");
        return userRequest;
    }

    public Person getPerson() {
        var response = new Person();
        response.setAge(12);
        response.setCreationDate(LocalDateTime.now());
        response.setDocument("12345678910");
        response.setGender("M");
        response.setName("Teste");
        response.setUpdateDate(null);
        return response;
    }

    public AccessGroup getAccessGroup() {
        var response = new AccessGroup();
        response.setCreationDate(LocalDateTime.now());
        response.setId(2);
        response.setName("Teste");
        response.setUpdateDate(null);
        return response;
    }
}