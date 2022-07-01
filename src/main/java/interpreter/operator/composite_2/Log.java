package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Log extends Composite_2{
    public Log(){
        super();
    }

    public Log(Component left, Component right){
        super(left,right);
    }
    @Override
    public double interpret() throws ArithmeticException {
        return Math.log(right.interpret()) / Math.log(left.interpret());//换底公式
    }
}
