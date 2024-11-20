package level_3;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS ("+", "Addition", (a, b) -> a + b),
    MINUS ("-", "Subtraction", (a, b) -> a - b),
    MULTI ("*", "Multiplication", (a, b) -> a * b),
    DIVIDE ("/", "Division", (a, b) -> {
        if (b == 0) throw new ArithmeticException("Division by Zero");
        return a / b;
    });

    private final String symbol;
    private final String description;
    private final BiFunction<Double, Double, Double> operation;

    OperatorType(String symbol, String description, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.description = description;
        this.operation = operation;
    }

    public Double calculate(Double Num1, Double Num2) {
        return operation.apply(Num1, Num2);
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.getSymbol().equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown operator type: " + symbol);
    }
}
