package com.example.Assignment._3.service;

import com.example.Assignment._3.model.Person;
import com.example.Assignment._3.model.PersonShortModel;
import com.example.Assignment._3.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void personManagement() {
        fillDatabase();
        printData(findAllPeople());

        System.out.println("\n--------------- Update and Delete -------------------");
        deleteByID(1);
        update(2, "newPerson", "newPerson", 5);
        printData(findAllPeople());

        System.out.println("\n----------------- Persons By Age Using Page ----------------------");
        Page<Person> personsByAge = personRepository.findPersonByAge(20,
                PageRequest.of(
                        0, 3,
                        Sort.Direction.ASC, "age")
        );
        printData(personsByAge);

        System.out.println("\n------------------ Person By Age Using Projection --------------");
        List<PersonShortModel> people = personRepository.findPersonShortModel(20);
        printData(people);


    }

    // --------------------------------------- Helper Methods ------------------------------------
    // Fill DB
    public void fillDatabase() {
        List<String> firstName = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Harry", "Ivy", "Jack");
        List<String> lastName = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson");
        List<Integer> ages = Arrays.asList(11, 23, 45, 13, 16, 25, 46, 33, 22, 56);
        for (int i = 0; i < firstName.size(); i++) {
            savePerson(firstName.get(i), lastName.get(i), ages.get(i));
        }
    }

    // Saves Person
    public void savePerson(String name, String lastName, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);
        personRepository.save(person);
    }

    // Return All
    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    // Update Person
    public void update(Integer id, String name, String lastName, Integer age) {
        Person personToUpdate = personRepository.findById(id).orElseThrow();
        personToUpdate.setName(name);
        personToUpdate.setLastName(lastName);
        personToUpdate.setAge(age);
        personRepository.save(personToUpdate);
    }

    // Delete
    public void deleteByID(Integer id) {
        personRepository.deleteById(id);
    }

    public void printData(Object data) {
        System.out.println("\n---------------- Result -----------------");
        if (data instanceof List<?>) {
            for (Object item : (List<?>) data) {
                System.out.println(item);
            }
        } else if (data instanceof Page<?>) {
            for (Object item : ((Page<?>) data).getContent()) {
                System.out.println(item);
            }
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + data.getClass().getName());
        }
        System.out.println("-------------------------------------------");
    }
}
