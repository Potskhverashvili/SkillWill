package com.example.Assignment._3.repository;

import com.example.Assignment._3.model.Person;
import com.example.Assignment._3.model.PersonShortModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(""" 
            select new com.example.Assignment._3.model.PersonShortModel(p.name, p.lastName) from Person p
            where p.age > :PersonAge
            """)
    List<PersonShortModel> findPersonShortModel(Integer PersonAge);

    @Query("""
            select p from Person p
            where p.age > :personAge
            """)
    Page<Person> findPersonByAge(Integer personAge, Pageable pageable);
}