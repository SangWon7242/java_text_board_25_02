package com.sbs.java.board;

import com.sbs.java.board.base.Rq;
import com.sbs.java.board.boundedContext.article.controller.ArticleController;
import com.sbs.java.board.boundedContext.member.controller.MemberController;
import com.sbs.java.board.boundedContext.member.dto.Member;
import com.sbs.java.board.container.Container;
import com.sbs.java.board.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class App {
  public MemberController memberController;
  public ArticleController articleController;

  public App() {
    memberController = Container.memberController;
    articleController = Container.articleController;
  }

  public void run() {
    System.out.println("== 자바 텍스트 게시판 시작 ==");

    // 프로그램 실행되자마자 1번회원이 로그인 될 수 있도록
    forTestLoginByMemberId(1);

    while (true) {
      Rq rq = new Rq();

      String promptName = "명령";

      if(rq.isLogined()) {
        Member member = rq.getLoginedMember();
        promptName = member.getUsername();
      }


      System.out.printf("%s) ", promptName);
      String cmd = Container.sc.nextLine();

      rq.setCommand(cmd);

      if (!runInterceptor(rq)) {
        continue;
      }

      if (rq.getUrlPath().equals("/usr/article/write")) {
        articleController.doWrite(rq);
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        articleController.showList(rq);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        articleController.showDetail(rq);
      } else if (rq.getUrlPath().equals("/usr/article/modify")) {
        articleController.doModify(rq);
      } else if (rq.getUrlPath().equals("/usr/article/delete")) {
        articleController.doDelete(rq);
      } else if (rq.getUrlPath().equals("/usr/member/join")) {
        memberController.doJoin(rq);
      } else if (rq.getUrlPath().equals("/usr/member/login")) {
        memberController.doLogin(rq);
      } else if (rq.getUrlPath().equals("/usr/member/logout")) {
        memberController.doLogout(rq);
      } else if (rq.getUrlPath().equals("/usr/member/mypage")) {
        memberController.showMyPage(rq);
      } else if (rq.getUrlPath().equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("잘못 된 명령어입니다.");
      }
    }

    System.out.println("== 자바 텍스트 게시판 끝 ==");
    Container.sc.close();
  }

  private void forTestLoginByMemberId(int id) {
    Member member = Container.memberService.findById(id);

    if(member == null) return;

    new Rq().login(member);
  }

  private boolean runInterceptor(Rq rq) {
    List<Interceptor> interceptors = new ArrayList<>();

    interceptors.add(Container.needLogoutInterceptor);
    interceptors.add(Container.needLoginInterceptor);

    for (Interceptor interceptor : interceptors) {
      if (!interceptor.run(rq)) {
        return false;
      }
    }

    return true;
  }
}
