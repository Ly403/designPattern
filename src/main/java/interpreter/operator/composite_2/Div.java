package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Div extends Composite_2 {
    public Div(){
        super();
    }

    public Div(Component left, Component right){
        super(left,right);
    }
    @Override
    public double interpret() throws ArithmeticException {
        return left.interpret() / right.interpret();
    }
}
