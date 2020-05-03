package com.learning.graphql.graphql;

import com.learning.graphql.common.GraphQlInvocation;
import com.learning.graphql.model.GraphQlRequestBody;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;

import java.util.concurrent.CompletableFuture;

public class PersonGraphQlInvocation implements GraphQlInvocation {

    private GraphQL graphQL;

    public PersonGraphQlInvocation(final GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @Override
    public CompletableFuture<ExecutionResult> execute(GraphQlRequestBody request) {
        final ExecutionInput executeInput = ExecutionInput.newExecutionInput().query(request.getQuery())
                .operationName(request.getOperationName()).build();
        return graphQL.executeAsync(executeInput);
    }
}
