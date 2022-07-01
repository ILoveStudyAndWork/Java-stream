package com.fengyi.javastream.stream_operator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  private String id;

  private String firstName;

  private String lastName;

  private int age;
}
