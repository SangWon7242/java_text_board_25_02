package com.sbs.java.board.boundedContext.member.repository;

import com.sbs.java.board.boundedContext.member.dto.Member;
import com.sbs.java.board.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
  private List<Member> members;
  private int lastId;

  public MemberRepository() {
    members = new ArrayList<>();
    lastId = 0;

    makeMemberTestData();
  }

  public void makeMemberTestData() {
    join("user1", "1234", "홍길동");
    join("love", "12345", "김철수");
    join("java", "1111", "제임스");
  }

  public void join(String username, String password, String name) {
    int id = ++lastId;

    String regDate = Util.getNowDateStr();
    String updateDate = Util.getNowDateStr();

    Member member = new Member(id, regDate, updateDate, username, password, name);

    members.add(member);
  }

  public Member findByUsername(String username) {
    return members.stream()
        .filter(member -> member.getUsername().equals(username))
        .findFirst() // 찾은 것중에 처음 것을 리턴
        .orElse(null); // 찾지 못했다면 null을 리턴
  }

  public Member findById(int id) {
    return members.stream()
        .filter(member -> member.getId() == id)
        .findFirst()
        .orElse(null);
  }
}
