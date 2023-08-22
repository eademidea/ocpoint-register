package br.com.ocpoint.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ocpoint.model.Person;
import br.com.ocpoint.repository.PersonRepository;

@RunWith(SpringRunner.class)
public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    private PersonServiceImpl service;

    @Before
    public void init() {
        service = new PersonServiceImpl(personRepository);
    }

    @Test
    public void personByDocumentReturnNull() {
        when(personRepository.getPersonByDocument(any())).thenReturn(null);
        Assert.assertNull(service.getPersonByDocument(null));
    }

    @Test
    public void getPersonByDocument() {
        when(personRepository.getPersonByDocument(any())).thenReturn(new Person());
        Assert.assertNotNull(service.getPersonByDocument("1234567810"));
    }
}
