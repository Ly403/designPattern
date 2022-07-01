import interpreter.Context;

import java.util.Scanner;

public class test {
    //命令行输出作为测试

    public static void demoTest(){
        try {
            System.out.println(new Context("sin10^2*ln2+(2√30/((6-4)*2-2))^3").getResult());
            System.out.println(new Context("sin30^2").getResult());
            System.out.println(new Context("cos60^2").getResult());
            System.out.println(new Context("4!").getResult());
            System.out.println(new Context("3.8*2.3+2.3^1.9").getResult());
            System.out.println(new Context("2log4*100").getResult());
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("数学错误");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("其他错误");
        }
    }

    public static void demo(){
        try {
            while (true){
                System.out.println("[请输入运算表达式](输入q结束)");
                Scanner s = new Scanner(System.in);
                String input = s.next();
                if(input.equals("q"))
                    break;
                System.out.println(new Context(input).getResult());
            }
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("数学错误");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("其他错误");
        }
    }

    public static void main(String []args)throws Exception{//测试类，异常全部抛出去
        demo();
    }
}
