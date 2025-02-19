import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String queryString = "id=1&subject=제목1&content=내용1&writerName=김철수&boardId=1";

    String[] queryStringBits = queryString.split("&");

    System.out.println(Arrays.toString(queryStringBits));

    List<String> paramsName = new ArrayList<>();
    List<String> paramsValue = new ArrayList<>();

    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      paramsName.add(bitBits[0]);
      paramsValue.add(bitBits[1]);
    }

    /*
    for(int i = 0; i < paramsName.size(); i++) {
      String paramName = paramsName.get(i);
      String paramValue = paramsValue.get(i);

      System.out.printf("%s : %s\n", paramName, paramValue);
    }
    */
    System.out.println(paramsName);
    System.out.println(paramsValue);

    int findIndex = paramsName.indexOf("subject");
    System.out.println(paramsValue.get(findIndex));
    
  }
}
