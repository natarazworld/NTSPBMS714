<%@ page  isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
           <h1 style="color:blue;text-align:center"> ShowBalance Page  </h1>
                       <b> balance ::  <%= new Random().nextInt(100000) %></b> <br>
            <a href="./">Home</a> 
            <br>                       
            <a href="signout">logout</a>
</body>
</html>