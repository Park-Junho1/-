package level_2;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        Queue<Integer> arr = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.startsWith("e")) {
                break;
            } else if (s.startsWith("p")) {
                calculator.removeResult(arr);
                continue;
            }
            int Num1 = Integer.parseInt(s);
            char Operator = st.nextToken().charAt(0);
            int Num2 = Integer.parseInt(st.nextToken());

            calculator.SetNum1(Num1);
            calculator.SetNum2(Num2);
            calculator.SetOperator(Operator);

            int result = calculator.calculate();
            arr.add(result);
            System.out.println(result);
        }
        br.close();
    }
}
