package br.com.ocpoint.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ocpoint.exception.BusinessException;
import br.com.ocpoint.exception.TechnicalException;
import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.Person;
import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.model.response.UserResponse;
import br.com.ocpoint.repository.UserRepository;
import br.com.ocpoint.utils.MessageUtils;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PersonService personService;

    private GroupService groupService;

    @Value("")
    private String teste;

    public UserServiceImpl(UserRepository userRepository, PersonService personService, GroupService groupService) {
        this.userRepository = userRepository;
        this.personService = personService;
        this.groupService = groupService;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) throws TechnicalException {
        try {
            var personByDocument = getPersonByDocument(userRequest);
            var groupById = getGroupById(userRequest);
            var recordedUser = this.userRepository.save(getUser(userRequest, personByDocument,
                    groupById));
            return new UserResponse(recordedUser);
        } catch (Exception e) {
            throw new TechnicalException(e.getMessage());
        }

    }

    @Override
    public User getUserByUsername(String nameUser) {
        return userRepository.findByNameuser(nameUser);
    }

    /* Criar método que retorna os parametros de conexão. */
    @Override
    public String login(String username, String password) {
        return null;
    }

    private AccessGroup getGroupById(UserRequest userRequest) {
        try {
            return this.groupService.getGroupById(userRequest.getGroup());
        } catch (Exception e) {
            throw new BusinessException(MessageUtils.COD_001);
        }

    }

    private Person getPersonByDocument(UserRequest userRequest) {
        try {
            return this.personService.getPersonByDocument(userRequest.getDocument());
        } catch (Exception e) {
            throw new BusinessException(MessageUtils.COD_002);
        }

    }

    private User getUser(UserRequest userRequest, Person person, AccessGroup group) {
        return User.builder()
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
                .nameuser(userRequest.getUser())
                .person(person)
                .group(group)
                .creationDate(LocalDateTime.now())
                .build();
    }

}
