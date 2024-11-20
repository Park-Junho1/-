package level_3;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Calculator<Double> calculator = new Calculator<>(); //제너릭 T타입으로 <Double>
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            if (s.startsWith("e")) { //exit의 첫번째 글자.
                break;
            } else if (s.startsWith("p")) { //poll의 첫번째 글자.
                calculator.removeResult();
                continue;
            } else if (s.startsWith("i")) {//index의 첫번째 글자
                int k = Integer.parseInt(st.nextToken());
                try {
                    double index_value = calculator.ListRetrieve(k);
                    System.out.println(index_value);
                } catch (IndexOutOfBoundsException e) { //calculator.ListRetrieve에서 인덱스가 지정된 범위를 벗어났을 경우.
                    System.err.println(e.getMessage());
                }
                continue;
            } else if (s.startsWith("c")) { //change의 첫번째 글자
                int k = Integer.parseInt(st.nextToken());
                try {
                    double value = Double.parseDouble(st.nextToken());
                    calculator.ListModify(k, value);
                } catch (IndexOutOfBoundsException e) { //calculator.ListModify에서 인덱스가 지정된 범위를 벗어났을 경우.
                    System.err.println(e.getMessage());
                }
            }

            double Num1 = Double.parseDouble(s);
            String Symbol = st.nextToken();
            double Num2 = Double.parseDouble(st.nextToken());
            try {
                calculator.SetNum1(Num1);
                calculator.SetNum2(Num2);
                OperatorType operator = OperatorType.fromSymbol(Symbol);
                calculator.setOperator(operator); //Calculator클래스에게 연산자를 전달해주는 역할
                Double result = calculator.calculate();
                BigDecimal BigResult = BigDecimal.valueOf(result);
                BigDecimal ModifyResult = BigResult.setScale(5, RoundingMode.HALF_UP); // 소수점 스케일을 5로하여 그 이하는 반올림하는 방식.
                System.out.println(ModifyResult);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        br.close();
    }
}
