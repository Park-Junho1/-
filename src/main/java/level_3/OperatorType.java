package level_3;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS ("+", "Addition", (a, b) -> a + b),
    MINUS ("-", "Subtraction", (a, b) -> a - b),
    MULTI ("*", "Multiplication", (a, b) -> a * b),
    DIVIDE ("/", "Division", (a, b) -> {
        if (b == 0) throw new ArithmeticException("Division by Zero");
        return a / b;
    }); // PLUS, MINUS, MULTI, DIVIDE. 각 연산자에 맞는 심볼과 설명을 적은 후, 식을 람다식에 맞춰 작성. 분모가 0인 경우 판별.

    private final String symbol;
    private final String description;
    private final BiFunction<Double, Double, Double> operation;

    OperatorType(String symbol, String description, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.description = description;
        this.operation = operation; //fromSymbol에서 메인으로 리턴된 연산자타입이 Calculator 클래스를 거쳐 this.symbol을 통해 람다식에 전달.
    }//OperatorType의 enum 클래스 생성자.

    public Double calculate(Double Num1, Double Num2) {
        return operation.apply(Num1, Num2);
    }
    /*Calculator 클래스로부터 받은 숫자 두 개를 BiFunction으로 선언된 operation에 apply.
    * BiFunction은 Double, Double값을 받아 반환값이 Double값이 된다.*/

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType type : OperatorType.values()) {
            /*OperatorType인 이 클래스 객체 안에서 values()를 통해 연산자 별로 심볼을 체크.*/
            if (type.getSymbol().equals(symbol)) {
                return type;
            }// getSymbol로 이 클래스에서 조회한 것과 메인에서 가져온 symbol 연산자가 같다면 해당 연산자 타입을 리턴한다.
        }
        throw new IllegalArgumentException("Unknown operator type: " + symbol);
    }
}
