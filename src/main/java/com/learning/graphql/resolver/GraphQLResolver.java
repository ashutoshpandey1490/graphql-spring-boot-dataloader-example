package com.learning.graphql.resolver;

import graphql.schema.idl.RuntimeWiring;

public interface GraphQLResolver {

    void buildNewWiring(final RuntimeWiring.Builder wiring);
}
