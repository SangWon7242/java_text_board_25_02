package com.sbs.java.board.container;

import com.sbs.java.board.boundedContext.article.controller.ArticleController;
import com.sbs.java.board.boundedContext.article.repository.ArticleRepository;
import com.sbs.java.board.boundedContext.article.service.ArticleService;
import com.sbs.java.board.boundedContext.board.repository.BoardRepository;
import com.sbs.java.board.boundedContext.board.service.BoardService;
import com.sbs.java.board.boundedContext.member.controller.MemberController;
import com.sbs.java.board.boundedContext.member.repository.MemberRepository;
import com.sbs.java.board.boundedContext.member.service.MemberService;
import com.sbs.java.board.interceptor.NeedLoginInterceptor;
import com.sbs.java.board.interceptor.NeedLogoutInterceptor;
import com.sbs.java.board.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static NeedLogoutInterceptor needLogoutInterceptor;
  public static NeedLoginInterceptor needLoginInterceptor;

  public static BoardRepository boardRepository;
  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static BoardService boardService;
  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  // static 메서드는 프로그램 실행되자마자 실행
  static {
    sc = new Scanner(System.in);
    session = new Session();

    needLogoutInterceptor = new NeedLogoutInterceptor();
    needLoginInterceptor = new NeedLoginInterceptor();

    boardRepository = new BoardRepository();
    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    boardService = new BoardService();
    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
