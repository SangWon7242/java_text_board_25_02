package com.sbs.java.board.base;

import com.sbs.java.board.util.Util;
import lombok.Getter;

import java.util.Map;

public class Rq {
  private String url;

  @Getter
  private Map<String, String> params;
  @Getter
  private String urlPath;

  public Rq(String url) {
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

  public String getParam(String paramName, String defaultValue) {
    if (!params.containsKey(paramName)) return defaultValue;

    return params.get(paramName);
  }
}


