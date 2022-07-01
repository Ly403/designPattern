package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Mul extends Composite_2 {
    public Mul(){
        super();
    }

    public Mul(Component left, Component right) {
        super(left,right);
    }

    @Override
    public double interpret() throws ArithmeticException{
        return left.interpret() * right.interpret();
    }
}
