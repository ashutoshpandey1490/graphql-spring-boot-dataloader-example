package com.learning.graphql.model;

import lombok.Data;

import java.util.Map;

@Data
public class GraphQlRequestBody {
    // This is what Playground sends in header
    private String query;
    private Map<String, Object> variables;
    private String operationName;
}
