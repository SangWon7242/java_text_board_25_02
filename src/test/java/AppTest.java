import java.util.*;

public class AppTest {
  public static void main(String[] args) {
    Rq rq = new Rq("/usr/article/write?id=1&subject=제목1&content=10+5=13&writerName=김철수&boardId=1");
    Map<String, String> params = rq.getParams();
    System.out.println(params);
    System.out.println(rq.getParams());
    System.out.println(rq.getParams());

    String urlPath = rq.urlPath();
    System.out.println(urlPath);
    System.out.println(rq.urlPath());
    System.out.println(rq.urlPath());
  }
}

class Rq {
  String url;

  Rq(String url) {
    this.url = url;
  }

  Map<String, String> getParams() {
    return Util.getParamsFromUrl(url);
  }

  String urlPath() {
    return Util.getPathFromUrl(url);
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    System.out.println("getParamsFromUrl 실행됨");

    Map<String, String> params = new HashMap<>();
    String[] urlBits = url.split("\\?", 2);

    if(urlBits.length == 1) return params;

    String queryStr = urlBits[1];

    for(String bit : queryStr.split("&")) {
      String[] bitBits = bit.split("=", 2);

      if(bitBits.length == 1) {
        continue;
      }

      params.put(bitBits[0], bitBits[1]);
    }

    return params;
  }

  static String getPathFromUrl(String url) {
    System.out.println("getPathFromUrl 실행됨");

    return url.split("\\?", 2)[0];
  }
}