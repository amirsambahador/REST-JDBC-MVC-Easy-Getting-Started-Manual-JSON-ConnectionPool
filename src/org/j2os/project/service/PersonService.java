package org.j2os.project.service;

import org.j2os.project.entity.Person;
import org.j2os.project.repository.PersonRepository;

import java.util.List;

public class PersonService {
    private PersonService() {
    }
    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }
    public PersonService save(Person person) throws Exception {
        try (PersonRepository personRepository = new PersonRepository()) {
            person.setSalary(person.getSalary() - ((person.getSalary() * 10) / 100));
            personRepository.insert(person);
            personRepository.commit();
            return this;
        }
    }
    public PersonService update(Person person) throws Exception {
        try (PersonRepository personRepository = new PersonRepository()) {
            personRepository.update(person);
            personRepository.commit();
            return this;
        }
    }
    public PersonService remove(Person person) throws Exception {
        try (PersonRepository personRepository = new PersonRepository()) {
            personRepository.delete(person);
            personRepository.commit();
            return this;
        }
    }
    public List<Person> findAll() throws Exception {
        try (PersonRepository personRepository = new PersonRepository()) {
            return personRepository.selectAll();
        }
    }
    public Person findOne(Person person)throws Exception
    {
        try (PersonRepository personRepository = new PersonRepository()) {
            return personRepository.selectOne(person);
        }
    }
}
