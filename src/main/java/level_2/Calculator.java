package level_2;
import java.util.*;

public class Calculator {
    private int Num1;
    private int Num2;
    private char Operator;

    public int GetNum1() {
        return Num1;
    }

    public void SetNum1 (int Num1) {
        this.Num1 = Num1;
    }

    public int GetNum2() {
        return Num2;
    }

    public void SetNum2 (int Num2) {
        this.Num2 = Num2;
    }

    public char GetOperator() {
        return Operator;
    }

    public void SetOperator (char Operator) {
        this.Operator = Operator;
    }

    public int calculate () {
        switch (Operator) {
            case '+' : return Num1 + Num2;
            case '-' : return Num1 - Num2;
            case '*' : return Num1 * Num2;
            case '/' : return (Num2 != 0) ? Num1 / Num2 : 0;
            default : throw new IllegalArgumentException("Operator not recognised");
        }
    }

    public void removeResult (Queue<Integer> arr) {
        arr.poll();
    }
}

/*처음에 클래스 생성자를 통해서 연결시키려고 했더니 Getter과 Setter를 사용하여 연결하란다.
* 생성자를 통한 연결이 간접적이지 않아서 그런가 했는데, 그건 또 아닌 모양이네.*/
/* Queue나 Stack 같은 걸 넘길때는 Queue<Integer>같은 식으로 넘긴다.*/