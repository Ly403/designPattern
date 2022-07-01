<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>计算器应用</title>
</head>
<style>
    html {
        height: 100%;
    }
    body {
        background-image: url("background.jpg");
        background-size: 100% 100%;
        padding: 0;
        margin: 0;
    }
    .input{
        display: flex;
        align-items: center;
        justify-content: space-around;
        flex-direction: column;
    }
    input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 3px;
        padding: 14px 14px;
        width: 620px;
        font-size: 24px;
        font-family: "Microsoft soft";
    }
    input:focus{
        border-color: #66afe9;
        outline: 0;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
    }
    .btn {
        background: #eb94d0;
        /* 创建渐变 */
        background-image: -webkit-linear-gradient(top, #eb94d0, #2079b0);
        background-image: -moz-linear-gradient(top, #eb94d0, #2079b0);
        background-image: -ms-linear-gradient(top, #eb94d0, #2079b0);
        background-image: -o-linear-gradient(top, #eb94d0, #2079b0);
        background-image: linear-gradient(to bottom, #eb94d0, #2079b0);
        /* 给按钮添加圆角 */
        -webkit-border-radius: 28px;
        -moz-border-radius: 28px;
        border-radius: 28px;
        text-shadow: 3px 2px 1px #9daef5;
        -webkit-box-shadow: 6px 5px 24px #666666;
        -moz-box-shadow: 6px 5px 24px #666666;
        box-shadow: 6px 5px 24px #666666;
        font-family: Arial;
        color: #fafafa;
        font-size: 27px;
        padding: 19px;
        text-decoration: none;
        text-align: center;
        width:100px;
        height:30px;
    }
    /* 悬停样式 */
    .btn:hover {
        background: #2079b0;
        background-image: -webkit-linear-gradient(top, #2079b0, #eb94d0);
        background-image: -moz-linear-gradient(top, #2079b0, #eb94d0);
        background-image: -ms-linear-gradient(top, #2079b0, #eb94d0);
        background-image: -o-linear-gradient(top, #2079b0, #eb94d0);
        background-image: linear-gradient(to bottom, #2079b0, #eb94d0);
        text-decoration: none;
    }
    .btn{
        position:absolute;
        left:0;
        top: 0;
        bottom: 0;
        right: 0;
        margin: auto;
    }
</style>
<body>
<%!
   String result = null;
   String error = null;
%>
<h1 style="text-align: center">
    简易计算器程序
</h1>
<form method="get" action="/designPattern_war_exploded/calculate" id="form" name="form">
    <div class="input" style="vertical-align: middle;text-align: center">
        <label>
            <input type="text" value="" id="expression" name="expression" placeholder="请输入计算表达式">
        </label>
    </div>

    <div class="btn" onclick="form.submit();">
        <label id="ok">计算</label>
    </div>
</form>
<%
    result = (String) request.getAttribute("result");
%>
<h1 style="text-align: center;vertical-align: center">计算结果：
<%if(result!=null)%>
<%=result%>
</h1>

<% error = (String) request.getAttribute("error");
    if(error != null){%>
<script type="text/javascript">
    <%System.out.println(error);%>
    window.alert("<%=error%>"+",请重新输入");
</script>
<%}%>
</body>
</html>