package com.fengyi.javastream;

import com.fengyi.javastream.stream_operator.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamOperatorIntroduction {
  private List<Student> students = List.of(buildStudent("1", "John", "Steve", 13),
      buildStudent("2", "Bob", "Steve", 43),
      buildStudent("3", "John", "Smith", 23)
  );


  @Test
  void filter_operator() {
    List<Student> olderThan18 = new ArrayList<>();

    for (Student student : students) {
      if (student.getAge() > 18) {
        olderThan18.add(student);
      }
    }

    List<Student> alsoOlderThan18 = students.stream()
        .filter(student -> student.getAge() > 18)
        .collect(Collectors.toList());

    assertEquals(olderThan18, alsoOlderThan18);
  }

  @Test
  void map_operator() {
    List<String> firstNames = new ArrayList<>();

    for (Student student : students) {
      firstNames.add(student.getFirstName());
    }

    List<String> alsoFirstNames = students.stream()
        .map(student -> student.getFirstName())
        .collect(Collectors.toList());

    assertEquals(firstNames, alsoFirstNames);
  }

  @Test
  void flatMap_operator() {
    List<Student> class1 = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23)
    );

    List<Student> class2 = List.of(buildStudent("4", "Jamie", "Davis", 13),
        buildStudent("5", "Alice", "Miller", 43),
        buildStudent("6", "", "Smith", 23)
    );

    List<List<Student>> grade1 = List.of(class1, class2);

    List<Student> allStudent = new ArrayList<>();
    for (List<Student> klass : grade1) {
      for (Student student : klass)
        allStudent.add(student);
    }


    List<Student> alsoAllStudents = grade1.stream()
        .flatMap(list -> list.stream())
        .collect(Collectors.toList());

    assertEquals(allStudent, alsoAllStudents);
  }


  @Test
  void distinct_operator() {
    List<Student> students = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23),
        buildStudent("3", "John", "Smith", 23)
    );

    List<Student> distinctStudents = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23)
    );

    List<Student> actualStudents = students.stream().distinct()
        .collect(Collectors.toList());
    assertEquals(distinctStudents, actualStudents);

  }

  @Test
  void sorted_operator() {
    List<Student> students = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23)
    );

    List<Student> sortedStudents = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("3", "John", "Smith", 23),
        buildStudent("2", "Bob", "Steve", 43)
    );

    List<Student> actualStudents = students.stream()
        .sorted(Comparator.comparing(Student::getAge))
        .collect(Collectors.toList());

    assertEquals(sortedStudents, actualStudents);

  }

  @Test
  void min_operator() {
    Student youngestStudent = buildStudent("1", "John", "Steve", 13);
    List<Student> students = List.of(youngestStudent,
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23)
    );


    Optional<Student> expectedStudentUsingSorted = students.stream()
        .sorted(Comparator.comparing(Student::getAge))
        .findFirst();
    assertEquals(expectedStudentUsingSorted.get(), youngestStudent);

    Optional<Student> expectedStudentUsingMin = students.stream()
        .min(Comparator.comparing(Student::getAge));

    assertEquals(expectedStudentUsingMin.get(), youngestStudent);
  }


  @Test
  void xx_match_operator() {
    List<Student> students = List.of(buildStudent("1", "John", "Steve", 13),
        buildStudent("2", "Bob", "Steve", 43),
        buildStudent("3", "John", "Smith", 23)
    );

    boolean isAnyStudentOver50YearsOld = students.stream()
        .anyMatch(student -> student.getAge() > 50);
    assertFalse(isAnyStudentOver50YearsOld);

    boolean isNonStudentOver50YearsOld = students.stream()
        .noneMatch(student -> student.getAge() > 50);
    assertTrue(isNonStudentOver50YearsOld);


    boolean isAllStudentYoungerThan20YearsOld = students.stream()
        .allMatch(student -> student.getAge() > 20);
    assertFalse(isAllStudentYoungerThan20YearsOld);
  }

  private static Student buildStudent(String id, String firstName, String lastName, int age) {
    return Student.builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .age(age)
        .build();
  }
}
