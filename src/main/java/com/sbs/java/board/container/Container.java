package com.sbs.java.board.container;

import com.sbs.java.board.boundedContext.article.controller.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;

  // static 메서드는 프로그램 실행되자마자 실행
  static {
    sc = new Scanner(System.in);

    articleController = new ArticleController();
  }
}
