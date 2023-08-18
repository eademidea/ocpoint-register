package br.com.ocpoint.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.ocpoint.exception.TechnicalException;
import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.Person;
import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.model.response.UserResponse;
import br.com.ocpoint.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PersonService personService;

    private GroupService groupService;

    public UserServiceImpl(UserRepository userRepository, PersonService personService, GroupService groupService) {
        this.userRepository = userRepository;
        this.personService = personService;
        this.groupService = groupService;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) throws TechnicalException {
        try {
            return new UserResponse(this.userRepository.save(getUser(userRequest, getPersonByDocument(userRequest),
                    getGroupById(userRequest))));
        } catch (Exception e) {
            throw new TechnicalException(e.getMessage());
        }

    }

    /* Criar método que retorna os parametros de conexão. */
    @Override
    public String login(String username, String password) {
        return null;
    }

    /* TODO: Será necessário melhorar aqui criando tratativas e regras... */
    private AccessGroup getGroupById(UserRequest userRequest) {
        return this.groupService.getGroupById(userRequest.getGroup());
    }

    /* TODO: Será necessário melhorar aqui criando tratativas e regras... */
    private Person getPersonByDocument(UserRequest userRequest) {
        return this.personService.getPersonByDocument(userRequest.getDocument());
    }

    private User getUser(UserRequest userRequest, Person person, AccessGroup group) {
        return User.builder()
                .password(userRequest.getPassword()) // TODO: Encriptar senha do usuário
                .username(userRequest.getUser())
                .person(person)
                .group(group)
                .creationDate(LocalDateTime.now())
                .build();
    }

}
