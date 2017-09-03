package app.datatypes

import groovy.transform.ToString

@ToString
class Todo {
    int userId
    String title
    boolean completed
}
