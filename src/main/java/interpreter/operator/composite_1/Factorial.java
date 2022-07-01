package interpreter.operator.composite_1;

import interpreter.operator.Component;

public class Factorial extends Composite_1{
    public Factorial(){
        super();
    }

    public Factorial(Component value){
        super(value);
    }

    private int getFactorial(int n) {
        if(n==1)
            return 1;
        else
           return n*getFactorial(n-1);
    }

    @Override
    public double interpret() throws ArithmeticException {
        Double doubleobject = value.interpret();
        return getFactorial(doubleobject.intValue());
    }
}
