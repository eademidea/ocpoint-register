package br.com.ocpoint.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ocpoint.model.User;
import br.com.ocpoint.repository.UserRepository;
import br.com.ocpoint.utils.TestUtils;

@RunWith(SpringRunner.class)
public class UserServiceImplTest extends TestUtils {

    private UserServiceImpl userService;

    @Mock
    private GroupService groupService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PersonService personService;

    @Before
    public void init() {
        this.userService = new UserServiceImpl(userRepository, personService, groupService);
    }

    @Test
    public void createUser() {
        when(groupService.getGroupById(any())).thenReturn(getAccessGroup());
        when(personService.getPersonByDocument(any())).thenReturn(getPerson());
        when(userRepository.save(any())).thenReturn(User.builder()
            .creationDate(LocalDateTime.now())
            .password("1234512")
            .nameuser("Teste")
            .person(getPerson())
            .group(getAccessGroup())
        .build());

        var response = this.userService.createUser(getUserRequest());
        Assert.assertTrue(response.getUser().equals("Teste"));
    }

}
