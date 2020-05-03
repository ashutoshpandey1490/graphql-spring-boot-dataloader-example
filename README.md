## graphql-spring-boot-dataloader-example
Sample application for GraphQL, Spring boot and DataLoader.

This application is aimed to provide integration for GraphQL, Spring boot and Dataloader.

graphql-spring-boot-starter -> Including this deps brings graphql-java-servlet which has 
old method implementation for GraphQL invocation and it Playground doesn't work because 
of that. This deps also does many things behind the scenes (This is what SB does :P) so 
you don't get an understanding of how bits and pieces fit together in GraphQL which
is very important to understand if you are using it in a big project because with GraphQL
things get messy because of multithreading, caching and dataloaders.

This demo project does not use any GraphQL's java-tools,Spqr, kickstart
library which provides Resolver implementation as they are not
very configurable and comes with predefined notion. So, I created my own 
implementation of Resolver and Dataloader.

## Run the app
1) Run the application from Application.java. It will initialize the in-memory H2 DB
with all the values. Open Playground on http://localhost:8080/playground and send below query

``` 
query {
      getPersons{
        id
        firstName
        lastName
        email
        phoneNo
      }
    }
 ```
 

 
