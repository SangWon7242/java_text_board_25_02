package com.sbs.java.board.session;

import java.util.HashMap;
import java.util.Map;

public class Session {
  private Map<String, Object> store;

  public Session() {
    store = new HashMap<>();
  }

  // 읽기, 저장, 삭제, 존재여부
  public Object getAttribute(String attrName) {
    return store.get(attrName);
  }

  public void setAttribute(String attrName, Object value) {
    store.put(attrName, value);
  }

  public void removeAttribute(String attrName) {
    store.remove(attrName);
  }

  public boolean hasAttribute(String attrName) {
    return store.containsKey(attrName);
  }
}
