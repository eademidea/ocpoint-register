package br.com.ocpoint.service;

import org.springframework.stereotype.Service;

import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public User createUser(UserRequest userRequest) {
        return this.personRepository.save(getUser(userRequest));
    }

    // TODO: método ainda em construção...
    private User getUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .user(userRequest.getUser())
                .build();
    }

}
