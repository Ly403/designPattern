package interpreter;

import org.javatuples.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorClass {
    private static Map<String,Triplet<Integer,Integer,Integer>> record = new HashMap<>();

    static {
        record.put("+",new Triplet<Integer,Integer,Integer>(5,-1,2));
        record.put("-",new Triplet<Integer,Integer,Integer>(5,-1,2));
        record.put("*",new Triplet<Integer,Integer,Integer>(4,-1,2));
        record.put("/",new Triplet<Integer,Integer,Integer>(4,-1,2));
        record.put("^",new Triplet<Integer,Integer,Integer>(3,-1,2));
        record.put("√",new Triplet<Integer,Integer,Integer>(3,1,2));
        record.put("log",new Triplet<Integer,Integer,Integer>(3,1,2));
        record.put("(",new Triplet<Integer,Integer,Integer>(-1,1,2));
        record.put(")",new Triplet<Integer,Integer,Integer>(18,-1,2));
        record.put("ln",new Triplet<Integer,Integer,Integer>(3,1,1));
        record.put("sin",new Triplet<Integer,Integer,Integer>(2,1,1));
        record.put("cos",new Triplet<Integer,Integer,Integer>(2,1,1));
        record.put("tan",new Triplet<Integer,Integer,Integer>(2,1,1));
        record.put("!",new Triplet<Integer,Integer,Integer>(1,-1,1));
        /*
        priority.put("+",5);
        priority.put("-",5);
        priority.put("*",4);
        priority.put("/",4);
        priority.put("√",3);
        priority.put("^",3);
        priority.put("(",-1);//左括号最优先
        priority.put(")",18);//右括号最滞后
        priority.put("ln",3);
        combination.put("+",-1);
        combination.put("-",-1);
        combination.put("*",-1);
        combination.put("/",-1);
        combination.put("^",-1);
        combination.put("√",1);
        combination.put("(",1);
        combination.put(")",-1);
        combination.put("ln",1);
        */
    };
    private String operator;

    public OperatorClass(){};
    public OperatorClass(char c){
        this.operator = Character.toString(c);
    }
    public OperatorClass(String c){
        this.operator = c;
    }

    public String get(){
        return operator;
    }

    public int judgeOperator(){
        if(operator == null || operator.equals(""))
            return 0;
        if(record.containsKey(operator))
            return getParameterNum(operator);
        else
            return 0;
    }


    public static int getPriority(String c){
        return record.get(c).getValue0();
    }

    public static int getCombination(String c){
        return record.get(c).getValue1();
    }

    public static int getParameterNum(String c){
        return record.get(c).getValue2();//参数数目
    }

    public static int compare(String a,String b){
        int _a = record.get(a).getValue0();
        int _b = record.get(b).getValue0();
        return Integer.compare(_b,_a);
    }
}
