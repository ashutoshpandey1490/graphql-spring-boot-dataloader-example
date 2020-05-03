package com.learning.graphql.common;

import com.learning.graphql.model.GraphQlRequestBody;
import graphql.ExecutionResult;

import java.util.concurrent.CompletableFuture;

public interface GraphQlInvocation {

    CompletableFuture<ExecutionResult> execute(final GraphQlRequestBody requestBody);
}
