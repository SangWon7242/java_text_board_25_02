package com.sbs.java.board.base;

import com.sbs.java.board.container.Container;
import com.sbs.java.board.session.Session;
import com.sbs.java.board.util.Util;
import lombok.Getter;

import java.util.Map;

public class Rq {
  private String url;

  @Getter
  private Map<String, String> params;
  @Getter
  private String urlPath;

  private Session session;
  private final String loginedMember;

  public Rq() {
    session = Container.session;
    loginedMember = "loginedMember";
  }

  public void setCommand(String url) {
    this.url = url;

    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getPathFromUrl(this.url);
  }

  public int getIntParam(String paramName, int defaultValue) {
    if (!params.containsKey(paramName)) return defaultValue;

    int id = 0;

    try {
      id = Integer.parseInt(params.get(paramName));
    } catch (NumberFormatException e) {
      return defaultValue;
    }

    return id;
  }

  public boolean isLogined() {
    return hasSessionAttr(loginedMember);
  }

  public boolean isLogout() {
    return !isLogined();
  }

  public String getParam(String paramName, String defaultValue) {
    if (!params.containsKey(paramName)) return defaultValue;

    return params.get(paramName);
  }

  public Object getSessionAttr(String attrName) {
    return session.getAttribute(attrName);
  }

  public void setSessionAttr(String attrName, Object value) {
    session.setAttribute(attrName, value);
  }

  public void removeSessionAttr(String attrName) {
    session.removeAttribute(attrName);
  }

  public boolean hasSessionAttr(String attrName) {
    return session.hasAttribute(attrName);
  }
}


