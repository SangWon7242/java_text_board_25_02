import java.util.Arrays;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String queryString = "a=1&b=2&c=3";

    // a=1, b=2, c=3
    String[] queryStringBits = queryString.split("&");

    System.out.println(Arrays.toString(queryStringBits));

    /*
    for(String bit : queryStringBits) {
      System.out.println(bit);
    }
    */

    Arrays.stream(queryStringBits)
        .forEach(System.out::println);
  }
}
