package com.sbs.java.board.boundedContext.board.repository;

import com.sbs.java.board.boundedContext.board.dto.Board;
import com.sbs.java.board.util.Util;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
  private List<Board> boardList;

  public BoardRepository() {
    boardList = new ArrayList<>();

    makeBoardTestData();
  }

  public void makeBoardTestData() {
    String regDate = Util.getNowDateStr();
    String updateDate = Util.getNowDateStr();

    boardList.add(new Board(1, regDate, updateDate, "공지사항", "1"));
    boardList.add(new Board(2, regDate, updateDate, "자유", "2"));
  }

  public Board findByBoardId(int boardId) {
    return boardList.stream()
        .filter(board -> board.getId() == boardId)
        .findFirst()
        .orElse(null);
  }
}
