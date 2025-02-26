package com.sbs.java.board.boundedContext.member.service;

import com.sbs.java.board.boundedContext.member.dto.Member;
import com.sbs.java.board.boundedContext.member.repository.MemberRepository;
import com.sbs.java.board.container.Container;

import java.util.stream.IntStream;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;

    makeMemberTestData();
  }

  public void makeMemberTestData() {
    join("user1", "1234", "홍길동");
    join("love", "12345", "김철수");
    join("java", "1111", "제임스");
  }

  public void join(String username, String password, String name) {
    memberRepository.join(username, password, name);
  }

  public Member findByUsername(String username) {
    return memberRepository.findByUsername(username);
  }
}
