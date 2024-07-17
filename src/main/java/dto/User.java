package dto;

import lombok.Data;

@Data
public class User {
  private String name;
  private String course;
  private String email;
  private int age;
}