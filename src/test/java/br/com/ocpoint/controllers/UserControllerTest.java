package br.com.ocpoint.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ocpoint.repository.UserRepository;
import br.com.ocpoint.service.UserService;
import br.com.ocpoint.utils.TestUtils;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends TestUtils {

        @MockBean
        private UserService service;

        @Autowired
        private WebApplicationContext context;

        @MockBean
        private UserRepository userRepository;

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper mapper;

        @BeforeEach
        public void before() {
                mockMvc = MockMvcBuilders
                                .webAppContextSetup(context)
                                .apply(springSecurity())
                                .build();
        }

        /*TODO: Corrigir esse teste. */
        @Test
        public void signup() throws Exception {

                String json = mapper.writeValueAsString(getUserRequest());

                Mockito.when(service.createUser(any()))
                                .thenReturn(getUserResponse());


                // UserDetails details = Mockito.mock(UserDetails.class);

                this.mockMvc.perform(
                                MockMvcRequestBuilders.post("/sign-in")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(json)
                                                // .header("Authorization", details)
                                                .accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
                                // .andExpect(MockMvcResultMatchers.status().isOk())
                                // .andExpect(MockMvcResultMatchers.content().json(
                                //                 "{\"id\":null,\"name\":\"Teste\",\"user\":null,\"group\":\"Teste\"}"));

        }

}
