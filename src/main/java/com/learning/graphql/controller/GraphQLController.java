package com.learning.graphql.controller;

import com.learning.graphql.common.GraphQlInvocation;
import com.learning.graphql.model.GraphQlRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {

    private final GraphQlInvocation graphQlInvocation;

    @Autowired
    public GraphQLController(final GraphQlInvocation graphQlInvocation) {
        this.graphQlInvocation = graphQlInvocation;
    }

    @RequestMapping(path = "/graphql", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getResult(@RequestBody GraphQlRequestBody requestBody ) {
        return graphQlInvocation.execute(requestBody);
    }
}
