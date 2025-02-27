package com.sbs.java.board.interceptor;

import com.sbs.java.board.base.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
