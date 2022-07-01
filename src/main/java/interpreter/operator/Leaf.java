package interpreter.operator;

public class Leaf implements Component {
    private final String value;
    public Leaf(String value){
        this.value = value;
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Double.parseDouble(this.value);
    }
}
