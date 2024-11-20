package level_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator <T extends Number> {
    private T Num1;
    private T Num2;
    private OperatorType operator;
    private Queue<T> arr = new LinkedList<>();
    private List<T> history = new LinkedList<>(arr);

    public void SetNum1 (T Num1) {
        this.Num1 = Num1;
    }

    public void SetNum2 (T Num2) {
        this.Num2 = Num2;
    }

    public void setOperator(OperatorType op) {
        this.operator = op;
    }

    public void removeResult () {
        arr.poll();
    }

    public T calculate () {
        if (operator == null) {
            throw new IllegalStateException("operator is null");
        }
        Double result = operator.calculate(Num1.doubleValue(), Num2.doubleValue());

        return (T) result;
    }

    public T ListRetrieve (int k) {
        if (k >= 0 && k < history.size()) {
            return history.get(k);
        }
        throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
    }

    public void ListModify (int k, T value) {
        if (k >= 0 && k < history.size()) {
            history.set(k, value);
        } else {
            throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
        }

    }
}
