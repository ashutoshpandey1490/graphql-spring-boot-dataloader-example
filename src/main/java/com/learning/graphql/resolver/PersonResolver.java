package com.learning.graphql.resolver;

import com.learning.graphql.datafetchers.PersonDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.stereotype.Component;

@Component
public class PersonResolver implements GraphQLResolver {

    private PersonDataFetcher personDataFetcher;

    public PersonResolver(final PersonDataFetcher personDataFetcher) {
        this.personDataFetcher = personDataFetcher;
    }

    @Override
    public void buildNewWiring(RuntimeWiring.Builder wiring) {
        wiring.type(TypeRuntimeWiring.newTypeWiring("Query")
                .dataFetcher("getPersons", personDataFetcher.getPersons()));
    }
}
