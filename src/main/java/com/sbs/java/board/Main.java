package com.sbs.java.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("== 자바 텍스트 게시판 시작 ==");
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

      System.out.printf("입력받은 명령어 : %s\n", cmd);
    }

    System.out.println("== 자바 텍스트 게시판 끝 ==");
    sc.close();
  }
}