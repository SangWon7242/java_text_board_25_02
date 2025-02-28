package com.sbs.java.board.boundedContext.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
  private int id;
  private String regDate;
  private String updateDate;
  private String name;
  private String code;
}
