package interpreter.operator.composite_1;

import interpreter.operator.Component;

public class Tan extends Composite_1{
    public Tan(){
        super();
    }

    public Tan(Component value){
        super(value);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.tan(Math.toRadians(value.interpret()));
    }
}
