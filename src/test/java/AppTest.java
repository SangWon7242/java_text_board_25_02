import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String queryString = "d=4&a=1&b=2&c=3&f=6";

    String[] queryStringBits = queryString.split("&");

    System.out.println(Arrays.toString(queryStringBits));

    List<String> paramsName = new ArrayList<>();
    List<Integer> paramsValue = new ArrayList<>();

    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      paramsName.add(bitBits[0]);
      paramsValue.add(Integer.parseInt(bitBits[1]));
    }

    for(int i = 0; i < paramsName.size(); i++) {
      String paramName = paramsName.get(i);
      int paramValue = paramsValue.get(i);

      System.out.printf("%s : %d\n", paramName, paramValue);
    }

  }
}
