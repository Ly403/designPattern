package interpreter;

import interpreter.operator.Component;
import interpreter.operator.Composite;
import interpreter.operator.OperationFactory;

import java.util.ArrayList;
import java.util.Stack;

public class Context {
    private Stack<Component> numbers = new Stack<>();
    private Stack<String> operations = new Stack<>();
    private final ArrayList<String> input = new ArrayList<>();
    private String expresstion = new String();

    public Context(String expresstion) throws Exception{
        this.expresstion = expresstion;
        this.expresstion.replaceAll(" ","");
        split();
        calculate();
    }

    private void split(){//切割字符串
        if(expresstion == null)
            return ;
        int i,j;
        for(i=0,j=0;j<expresstion.length();j++){
            for(int k=j+1;k<=expresstion.length();k++){
                String temp = expresstion.substring(j,k);
                if((new OperatorClass(temp)).judgeOperator() > 0){
                    temp = expresstion.substring(i,j);
                    if(!temp.equals(""))
                        input.add(temp);
                    temp = expresstion.substring(j,k);
                    if(!temp.equals(""))
                        input.add(temp);
                    i = k;
                    break;
                }
            };
        }
        String t = expresstion.substring(i,expresstion.length());
        if(!t.equals(""))
            input.add(expresstion.substring(i,expresstion.length()));
    }

    private Composite getComposite() throws Exception{
        String flag = operations.pop();
        if(OperatorClass.getParameterNum(flag) == 2) {
            Component right = numbers.pop();
            Component left = numbers.pop();
            return OperationFactory.creatComposite(flag, left, right);
        }
        else if(OperatorClass.getParameterNum(flag) == 1){
            Component value = numbers.pop();
            return OperationFactory.creatComposite(flag,value);
        }
        return null;//到不了这，防止它报错
    }

    private void calculate() throws Exception{
        for(String s: input) {
            if ((new OperatorClass(s)).judgeOperator() > 0) {
                if (OperatorClass.getPriority(s) == -1) {//左括号
                    operations.push(s);//左括号直接入栈
                } else if (OperatorClass.getPriority(s) == 18) {//右括号
                    while (OperatorClass.getPriority(operations.peek()) != -1 && !operations.empty()) {
                        numbers.push(getComposite());
                    }
                    operations.pop();//去除最后一个左括号
                }
                else {
                    while (!operations.empty() && !operations.peek().equals("(")
                            && (OperatorClass.compare(s, operations.peek()) < 0 || (
                            OperatorClass.compare(s, operations.peek()) == 0 && OperatorClass.getCombination(s) == -1))) {
                        numbers.push(getComposite());
                    }
                    operations.push(s);
                }
            } else {//到数字
                numbers.push(OperationFactory.creatLeaf(s));
            }
        }
        while (!operations.empty()){
            numbers.push(getComposite());
        }
    }

    public double getResult(){
        return numbers.peek().interpret();
    }
}

