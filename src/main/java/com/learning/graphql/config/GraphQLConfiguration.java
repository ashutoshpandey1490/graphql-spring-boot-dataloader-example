package com.learning.graphql.config;

import com.google.common.io.Resources;
import com.learning.graphql.common.GraphQlInvocation;
import com.learning.graphql.graphql.PersonGraphQlInvocation;
import com.learning.graphql.resolver.GraphQLResolver;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class GraphQLConfiguration {

    // Prepare TypeDefinitionRegistry
    @Bean
    public TypeDefinitionRegistry typeDefinitionRegistry() throws IOException {
        final TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
        // TODO: Make it take multiple schema files
        final String path = "schema/schema.graphqls";
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final Resource[] resources = resourcePatternResolver.getResources(path);
        SchemaParser schemaParser = new SchemaParser();
        for(Resource resource: resources) {
            final String schema = Resources.toString(resource.getURL(), StandardCharsets.UTF_8);
            typeDefinitionRegistry.merge(schemaParser.parse(schema));
        }
        return typeDefinitionRegistry;
    }

    // prepare schema
    @Bean
    public GraphQLSchema graphQLSchema(final TypeDefinitionRegistry typeDefinitionRegistry,
                                       final RuntimeWiring runtimeWiring) {
        return new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    // Gather all the resolvers's runTimeWiring
    @Bean
    public RuntimeWiring runtimeWiring(final List<GraphQLResolver> resolverList) {
        final RuntimeWiring.Builder builder = RuntimeWiring.newRuntimeWiring();
        resolverList.forEach(resolver -> resolver.buildNewWiring(builder));
        return builder.build();
    }

    // prepare GraphQLObject
    @Bean
    public GraphQL graphQL(final GraphQLSchema schema) {
        return GraphQL.newGraphQL(schema).queryExecutionStrategy(new AsyncExecutionStrategy()).build();
    }

    // prepare runner
    @Bean
    public GraphQlInvocation graphQlInvocation(final GraphQL grapgQL) {
        return new PersonGraphQlInvocation(grapgQL);
    }

}
