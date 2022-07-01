package com.fengyi.javastream.stream_operator;

import java.util.List;

public class Demo {
  public static void main(String[] args) {
    List<Student> students = List.of(buildStudent("1", "John", "Steve"),
        buildStudent("2", "Bob", "Steve"),
        buildStudent("3", "John", "Smith")
    );

    // stream pipeline = source + 0 or more intermediate operations + 1 terminal operations
    students.stream()
        .filter(student -> student.getFirstName().equals("John"))
        .map(student -> student.getId())
        .forEach(id -> System.out.println(id));

  }

  private static Student buildStudent(String id, String firstName, String lastName) {
    return Student.builder()
            .id(id)
            .firstName(firstName)
            .lastName(lastName)
        .build();
  }
}
