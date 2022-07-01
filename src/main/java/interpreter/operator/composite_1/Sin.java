package interpreter.operator.composite_1;

import interpreter.operator.Component;

public class Sin extends Composite_1{
    public Sin(){
        super();
    }

    public Sin(Component value){
        super(value);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.sin(Math.toRadians(value.interpret()));
    }
}
