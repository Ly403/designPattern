package interpreter.operator.composite_1;

import interpreter.operator.Component;

public class Cos extends Composite_1{

    public Cos() {
        super();
    }

    public Cos(Component value) {
        super(value);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.cos(Math.toRadians(value.interpret()));
    }
}
