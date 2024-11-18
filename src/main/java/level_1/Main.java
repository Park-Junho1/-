package level_1;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.startsWith("e")) {
                break;
            }
            int Num1 = Integer.parseInt(s);
            char operator = st.nextToken().charAt(0);
            int Num2 = Integer.parseInt(st.nextToken());
            if (operator == '+') {
                result = Num1 + Num2;
            } else if (operator == '-') {
                result = Num1 - Num2;
            } else if (operator == '*') {
                result = Num1 * Num2;
            } else if (operator == '/') {
                result = Num1 / Num2;
            }
            System.out.println(result);
        }
        br.close();
    }
}
