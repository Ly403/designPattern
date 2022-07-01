package interpreter.operator.composite_1;

import interpreter.operator.Component;

public class Ln extends Composite_1 {
    public Ln(){
        super();
    }

    public Ln(Component value){
        super(value);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.log(value.interpret());
    }
}
