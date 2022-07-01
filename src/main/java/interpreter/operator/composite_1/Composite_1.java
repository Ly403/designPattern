package interpreter.operator.composite_1;

import interpreter.operator.Component;
import interpreter.operator.Composite;

//抽象类，单运算数的操作符的父类
public abstract class Composite_1 extends Composite {
    protected Component value;

    public Composite_1(){};

    public Composite_1(Component value){
        this.value = value;
    }

    public void setValue(Component value){
        this.value = value;
    }

    @Override
    public abstract double interpret() throws ArithmeticException ;//暂留

}
