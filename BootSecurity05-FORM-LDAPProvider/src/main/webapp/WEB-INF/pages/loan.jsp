<%@ page  isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
           <h1 style="color:blue;text-align:center"> Loan Approval  Page  </h1>
                        <b> u  r approved for loan amount ::  <%=new Random().nextInt(1000000) %> <br>
            <a href="./">Home</a>
            <br>                       
          <!--   <a href="logout">logout</a>                        -->
           <a href="signout">logout</a>
</body>
</html>