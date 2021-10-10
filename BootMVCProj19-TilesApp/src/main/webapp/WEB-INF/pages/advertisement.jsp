<%@ page language="java"  import="java.util.*" isELIgnored="false"%>
    
    <%
       String addImages[]=new String[]{"raymonds.jpeg","digjam.jpeg","ramraj.jpeg","siyarams.jpeg","fabindia.jpeg"};
         int addNumber=new Random().nextInt(5);
         response.setHeader("refresh","2");
    %>
       <img src="images/<%=addImages[addNumber]%>"  width="300" height="200">
    
