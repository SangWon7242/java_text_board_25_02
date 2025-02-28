package com.sbs.java.board.boundedContext.article.controller;

import com.sbs.java.board.base.Rq;
import com.sbs.java.board.boundedContext.article.dto.Article;
import com.sbs.java.board.boundedContext.article.service.ArticleService;
import com.sbs.java.board.boundedContext.board.dto.Board;
import com.sbs.java.board.boundedContext.board.service.BoardService;
import com.sbs.java.board.boundedContext.member.dto.Member;
import com.sbs.java.board.container.Container;

import java.util.List;

public class ArticleController {
  private ArticleService articleService;
  private BoardService boardService;

  public ArticleController() {
    articleService = Container.articleService;
    boardService = Container.boardService;
  }

  public void doWrite(Rq rq) {
    int boardId = rq.getIntParam("boardId", 0);

    if(boardId == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Board board = boardService.findByBoardId(boardId);

    System.out.printf("== %s 게시물 작성 ==\n", board.getName());

    System.out.print("제목 : ");
    String subject = Container.sc.nextLine();

    System.out.print("내용 : ");
    String content = Container.sc.nextLine();

    Member member = (Member) rq.getSessionAttr("loginedMember");

    int id = articleService.write(subject, content, member.getUsername(), member.getId(), boardId);

    System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
  }

  public void showList(Rq rq) {
    String searchKeyword = rq.getParam("searchKeyword", "");
    String orderBy = rq.getParam("orderBy", "idDesc");

    List<Article> articles = articleService.findAll(searchKeyword, orderBy);

    if (articles.isEmpty()) {
      System.out.println("현재 게시물이 존재하지 않습니다.");
      return;
    }

    System.out.printf("== 게시물 리스트(%d개) ==\n", articles.size());
    System.out.println("번호 | 제목 | 작성자 | 게시판 이름");
    articles.forEach(
        article -> System.out.printf("%d | %s | %s | %d\n",
            article.getId(), article.getSubject(), article.getWriterName(), article.getBoardId())
    );
  }

  public void showDetail(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.println("== 게시물 상세보기 ==");
    System.out.printf("번호 : %d\n", article.getId());
    System.out.printf("제목 : %s\n", article.getSubject());
    System.out.printf("내용 : %s\n", article.getContent());
    System.out.printf("작성자 : %s\n", article.getWriterName());
  }

  public void doModify(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);
    Member member = (Member) rq.getSessionAttr("loginedMember");

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    if(!(article.getMemberId() == member.getId())) {
      System.out.println("게시물에 접근 권한이 없습니다.");
      return;
    }

    System.out.printf("== %d번 게시물 수정 ==\n", article.getId());
    System.out.print("제목 : ");
    String subject = Container.sc.nextLine();

    System.out.print("내용 : ");
    String content = Container.sc.nextLine();

    articleService.modify(id, subject, content);

    System.out.printf("%d번 게시물이 수정되었습니다.\n", article.getId());
  }

  public void doDelete(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);
    Member member = (Member) rq.getSessionAttr("loginedMember");

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    if(!(article.getMemberId() == member.getId())) {
      System.out.println("게시물에 접근 권한이 없습니다.");
      return;
    }

    articleService.delete(id);
    System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
  }
}
