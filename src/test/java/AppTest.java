import java.util.Arrays;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String queryString = "a=1&b=2&c=3";

    String[] queryStringBits = queryString.split("&");

    System.out.println(Arrays.toString(queryStringBits));

    // a=1, b=2, c=3
    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      // System.out.println(Arrays.toString(bitBits));

      String paramName = bitBits[0];
      String paramValue = bitBits[1];

      System.out.printf("%s : %s\n", paramName, paramValue);
    }

  }
}
