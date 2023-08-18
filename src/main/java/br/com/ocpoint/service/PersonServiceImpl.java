package br.com.ocpoint.service;

import org.springframework.stereotype.Service;

import br.com.ocpoint.model.Person;
import br.com.ocpoint.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonByDocument(String document) {
        return personRepository.getPersonByDocument(document);
    }

}
