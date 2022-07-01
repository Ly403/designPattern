package interpreter.operator;

import interpreter.operator.composite_1.Composite_1;
import interpreter.operator.composite_2.Composite_2;

import java.lang.reflect.InvocationTargetException;

public class OperationFactory {
    public static Leaf creatLeaf(String operation) throws ArithmeticException{
        Leaf oper = null;
        oper = new Leaf(operation);
        return oper;
    }

    private static Composite_2 innerCreatComposite(String operation, Component left, Component right)
            throws ArithmeticException,ClassNotFoundException,NoSuchMethodException,IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Composite_2 oper = null;
        oper = (Composite_2) (Class.forName(operation).getDeclaredConstructor().newInstance());
        oper.setLeft(left);
        oper.setRight(right);
        return oper;
    }

    private static Composite_1 innerCreatComposite(String operation, Component value)
            throws ArithmeticException,ClassNotFoundException,NoSuchMethodException,IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Composite_1 oper = null;
        oper = (Composite_1)(Class.forName(operation).getDeclaredConstructor().newInstance());
        oper.setValue(value);
        return oper;
    }
    public static Composite_2 creatComposite(String op, Component left, Component right)
            throws ArithmeticException,ClassNotFoundException,NoSuchMethodException,IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Composite_2 oper = null;
        String src = new String();
        switch (op){
            case "+":
                src = "interpreter.operator.composite_2.Add";
                break;
            case "-" :
                src = "interpreter.operator.composite_2.Sub";
                break;
            case "*" :
                src = "interpreter.operator.composite_2.Mul";
                break;
            case "/" :
                src = "interpreter.operator.composite_2.Div";
                break;
            case "^":
                src = "interpreter.operator.composite_2.Pow";
                break;
            case "√":
                src = "interpreter.operator.composite_2.Sqrt";
                break;
            case "log":
                src = "interpreter.operator.composite_2.Log";
                break;
        }
        oper = innerCreatComposite(src,left,right);
        return oper;
    }

    public static Composite_1 creatComposite(String op, Component value)
            throws ArithmeticException,ClassNotFoundException,NoSuchMethodException,IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Composite_1 oper = null;
        String src = new String();
        switch (op){
            case "ln":
                src = "interpreter.operator.composite_1.Ln";
                break;
            case "sin":
                src = "interpreter.operator.composite_1.Sin";
                break;
            case "cos":
                src = "interpreter.operator.composite_1.Cos";
                break;
            case "tan":
                src = "interpreter.operator.composite_1.Tan";
                break;
            case "!":
                src = "interpreter.operator.composite_1.Factorial";
                break;
        }
        oper = innerCreatComposite(src,value);
        return oper;
    }
}
