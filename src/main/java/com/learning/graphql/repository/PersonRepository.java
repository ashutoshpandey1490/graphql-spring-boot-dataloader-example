package com.learning.graphql.repository;

import com.learning.graphql.model.Persons;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Persons, Integer> {
}
