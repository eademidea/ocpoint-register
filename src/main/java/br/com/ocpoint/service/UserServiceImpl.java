package br.com.ocpoint.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.Person;
import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
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

    /* TODO: Será necessário melhorar aqui criando tratativas e regras... */
    @Override
    public User createUser(UserRequest userRequest) {
        var person = this.personService.getPersonByDocument(userRequest.getDocument());
        var group = this.groupService.getGroupById(userRequest.getGroup());
        return this.userRepository.save(getUser(userRequest, person, group));
    }

    /* Criar método que retorna os parametros de conexão. */
    public String login() {
        return null;
    }

    private User getUser(UserRequest userRequest, Person person, AccessGroup group) {
        return User.builder()
                .password(userRequest.getPassword()) // TODO: Encriptar senha do usuário
                .user(userRequest.getUser())
                .person(person)
                .group(group)
                .creationDate(LocalDateTime.now())
                .build();
    }

}
