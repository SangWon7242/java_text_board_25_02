package com.sbs.java.board.boundedContext.member.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
  private final int id;
  private String regDate;
  private String updateDate;
  private final String username;
  private String password;
  private String name;
}
