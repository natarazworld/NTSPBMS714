<%@ page isELIgnored="false"  import="org.springframework.security.core.context.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
          <h1 style="color:red;text-align:center"> Authorization failed  for <%=SecurityContextHolder.getContext().getAuthentication().getName() %> 
          
 
          
           </h1>
          <br>
          <a href="./">home</a>
</body>
</html>