package level_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator <T extends Number> { //지시에 따른 제너릭 T타입 처리, 숫자로 제한하기 위한 상속
    private T Num1;
    private T Num2;
    private OperatorType operator;
    private Queue<T> arr = new LinkedList<>(); //선입선출 규칙
    private List<T> history = new LinkedList<>(arr); //Queue로는 맨 앞과 끝을 제외한 특정 인덱스값 조회가 불가능

    public void SetNum1 (T Num1) {
        this.Num1 = Num1;
    }

    public void SetNum2 (T Num2) {
        this.Num2 = Num2;
    }

    public void setOperator(OperatorType op) {
        this.operator = op;
    } //메인으로부터 받은 연산자를 enum으로 전달해주기 위함.

    public void removeResult () { arr.poll();} //맨 앞에 저장된 계산값 삭제

    public T calculate () {
        if (operator == null) {
            throw new IllegalStateException("operator is null");
        }
        Double result = operator.calculate(Num1.doubleValue(), Num2.doubleValue()); //doubleValue값으로 enum클래스에게 값 전달.
        arr.add((T) result);
        history.add((T) result);
        return (T) result; //반환 타입이 T타입이므로 타입에 맞춰 캐스팅.
    }

    public T ListRetrieve (int k) {
        if (k >= 0 && k < history.size()) {
            return history.get(k);
        } //특정 인덱스값 조회
        throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
    }

    public void ListModify (int k, T value) {
        if (k >= 0 && k < history.size()) {
            history.set(k, value);
        } else { //특정 인덱스값 변경
            throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
        }

    }
}
