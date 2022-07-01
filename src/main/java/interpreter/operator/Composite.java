package interpreter.operator;

//该类的存在意义，是维护面向对象特征，是分类
public abstract class Composite implements Component{
    @Override
    public abstract double interpret() throws ArithmeticException;
}
