package com.learning.graphql.datafetchers;

import com.learning.graphql.model.Persons;
import com.learning.graphql.repository.PersonRepository;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PersonDataFetcher {

    private PersonRepository personRepository;

    public PersonDataFetcher(final PersonRepository repository) {
       this.personRepository = repository;
    }

    public DataFetcher<DataFetcherResult<List<Persons>>> getPersons() {
        return dataFetchingEnvironment -> {
            Iterable<Persons> personItr = personRepository.findAll();
            List<Persons> personsList = StreamSupport.stream(personItr.spliterator(), false)
                    .collect(Collectors.toList());
            return DataFetcherResult.<List<Persons>>newResult().data(personsList).build();
        };
    }
}
