package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Sub extends Composite_2 {
    public Sub(){
        super();
    }

    public Sub(Component left, Component right){
        super(left,right);
    }
    @Override
    public double interpret() throws ArithmeticException{
        return left.interpret() - right.interpret();
    }
}
