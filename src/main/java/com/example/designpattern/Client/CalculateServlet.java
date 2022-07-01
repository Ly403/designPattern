package com.example.designpattern.Client;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import interpreter.*;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        double result;
        try{
            String exp = request.getParameter("expression");
            Context temp = new Context(exp);
            result = temp.getResult();
            request.setAttribute("result",Double.toString(result));
            System.out.println(result);
            String url="/index.jsp";
            RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        }
        catch (ArithmeticException e){
            try {
                e.printStackTrace();
                System.out.println("数学异常");
                request.setAttribute("error","数学错误" );
                String url = "/index.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
                requestDispatcher.forward(request, response);
            }catch (Exception t){
                t.printStackTrace();
                System.out.println("服务器异常");
            }
        } catch (ServletException e){
            try {
                e.printStackTrace();
                System.out.println("服务器异常");
                request.setAttribute("error","服务器异常" );
                String url = "/index.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
                requestDispatcher.forward(request, response);
            }catch (Exception t){
                t.printStackTrace();
                System.out.println("服务器异常");
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
                System.out.println("其他错误");
                request.setAttribute("error","其他错误" );
                String url = "/index.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
                requestDispatcher.forward(request, response);
            }catch (Exception t){
                t.printStackTrace();
                System.out.println("服务器异常");
            }
        }
    }

}