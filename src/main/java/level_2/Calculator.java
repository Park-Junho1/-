package level_2;
import java.util.*;

public class Calculator {
    private int Num1;
    private int Num2;
    private char Operator;
    private int result;
    private Queue<Integer> arr = new LinkedList<>();

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
            case '+' : result = Num1 + Num2; break;
            case '-' : result = Num1 - Num2; break;
            case '*' : result = Num1 * Num2; break;
            case '/' : result = (Num2 != 0) ? Num1 / Num2 : 0; break;
            default : throw new IllegalArgumentException("Operator not recognised");
        }
        arr.add(result);
        return result;
    }
    public void removeResult () {
        arr.poll();
    }

    private List<Integer> list = new LinkedList<>(arr);

    public int ListRetrieve (int k) {
        int value = 0;
        if (k >= 0 && k < list.size()) {
            value = list.get(k);
        }
        return value;
    }

    public void ListModify (int k, int value) {
        list.set(k, value);
    }
}

/*처음에 클래스 생성자를 통해서 연결시키려고 했더니 Getter과 Setter를 사용하여 연결하란다.
* 생성자를 통한 연결이 간접적이지 않아서 그런가 했는데, 그건 또 아닌 모양이네.
* 객체 자체를 초기화하냐(클래스 생성자 이용), 값 하나하나를 받아서 객체를 재활용하냐(get, set)*/
/* Queue나 Stack 같은 걸 넘길때는 Queue<Integer>같은 식으로 넘긴다.*/
/*또한, Getter와 Setter 역할에 대하여 이 코드에서 단순 조회가 아닌 가져오는 역할까지 Setter가 한다.
* Getter의 역할은 단지, 이 클래스에게서부터 어딘가가 값을 요구할 경우를 대비한 메서드에 불과하다.*/