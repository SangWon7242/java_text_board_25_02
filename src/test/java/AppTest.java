import java.util.*;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String queryString = "/usr/article/write?id=1&subject=제목1&content=10+5=13&writerName=김철수&boardId=1";
    Map<String, String> params = Util.getParamsFromUrl(queryString);
    System.out.println(params);

    System.out.println(params.get("id")); // 1
    System.out.println(params.get("subject")); // 제목1
    System.out.println(params.get("content")); // 10+5=13
    System.out.println(params.get("writerName")); // 김철수
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
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
}