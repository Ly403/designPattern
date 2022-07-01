package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Pow extends Composite_2 {
    public Pow(){
        super();
    }

    public Pow(Component left, Component right) {
        super(left, right);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.pow(left.interpret(),right.interpret());
    }
}
