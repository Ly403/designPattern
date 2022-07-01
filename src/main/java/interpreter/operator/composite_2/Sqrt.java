package interpreter.operator.composite_2;

import interpreter.operator.Component;

public class Sqrt extends Composite_2 {
    public Sqrt(){
        super();
    };

    public Sqrt(Component left, Component right){
        super(left, right);
    }

    @Override
    public double interpret() throws ArithmeticException {
        return Math.pow(right.interpret(),1.0 / left.interpret());
    }
}
