package interpreter.operator.composite_2;

import interpreter.operator.Component;
import interpreter.operator.Composite;

//双操作数的运算符的基类
public abstract class Composite_2 extends Composite {
    @Override
    public abstract double interpret() throws ArithmeticException;
    protected Component left;
    protected Component right;
    public Composite_2(){};
    public Composite_2(Component left, Component right){
        this.left = left;
        this.right = right;
    }

    public void setLeft(Component left){
        this.left = left;
    }

    public void setRight(Component right){
        this.right  = right;
    }
}
