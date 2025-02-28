package com.sbs.java.board.boundedContext.board.service;

import com.sbs.java.board.boundedContext.board.dto.Board;
import com.sbs.java.board.boundedContext.board.repository.BoardRepository;
import com.sbs.java.board.container.Container;

public class BoardService {
  private BoardRepository boardRepository;

  public BoardService() {
    boardRepository = Container.boardRepository;
  }

  public Board findByBoardId(int boardId) {
    return boardRepository.findByBoardId(boardId);
  }
}
