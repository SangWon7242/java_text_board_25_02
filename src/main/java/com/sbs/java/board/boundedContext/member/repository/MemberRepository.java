package com.sbs.java.board.boundedContext.member.repository;

import com.sbs.java.board.boundedContext.member.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
  private List<Member> members;
  private int lastId;

  public MemberRepository() {
    members = new ArrayList<>();
    lastId = 0;
  }

  public void join(String username, String password, String name) {
    int id = ++lastId;

    Member member = new Member(id, username, password, name);

    members.add(member);
  }

  public Member findByUsername(String username) {
    return members.stream()
        .filter(member -> member.getUsername().equals(username))
        .findFirst() // 찾은 것중에 처음 것을 리턴
        .orElse(null); // 찾지 못했다면 null을 리턴
  }
}
