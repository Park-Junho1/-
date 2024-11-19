package level_2;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.startsWith("e")) {
                break;
            } else if (s.startsWith("p")) {
                calculator.removeResult();
                continue;
            } else if (s.startsWith("i")) {
                int k = Integer.parseInt(st.nextToken());
                int index_value = calculator.ListRetrieve(k);
                System.out.println(index_value);
                continue;
            } else if (s.startsWith("c")) {
                int k = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                calculator.ListModify(k, value);
            }
            int Num1 = Integer.parseInt(s);
            char Operator = st.nextToken().charAt(0);
            int Num2 = Integer.parseInt(st.nextToken());

            calculator.SetNum1(Num1);
            calculator.SetNum2(Num2);
            calculator.SetOperator(Operator);

            int result = calculator.calculate();
            System.out.println(result);
        }
        br.close();
    }
}
