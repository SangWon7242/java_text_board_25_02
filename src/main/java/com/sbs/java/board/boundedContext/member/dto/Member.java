package com.sbs.java.board.boundedContext.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
  private int id;
  private String username;
  private String password;
  private String name;
}
