package interpreter.operator.composite_2;


import interpreter.operator.Component;

public class Add extends Composite_2 {
    public Add(){
        super();
    }

    public Add(Component left, Component right){
        super(left,right);
    }
    @Override
    public double interpret() throws ArithmeticException{
        return left.interpret() + right.interpret();
    }
}
