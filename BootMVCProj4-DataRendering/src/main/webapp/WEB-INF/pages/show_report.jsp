<%@ page isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%-- <h1 style="color:red;text-align:center">Reading simple vlaues</h1>
     <b> name :: ${name}</b> <br>
     <b> age :: ${age}</b> <br>
     <b> address :: ${addrs}</b> <br> --%>
     
     <%-- <h1 style="color:red;text-align:center">Reading Array,Collection  vlaues</h1>
     
      <b> nick names(array)::</b><br>
        <c:forEach var="name" items="${nickNames}">
                  ${name} <br>
        </c:forEach>
        <hr>
        <b> Phone number (set)::</b><br>
        <c:forEach var="ph" items="${phonesInfo}">
                  ${ph} <br>
        </c:forEach>
         <hr>
        <b> courses (List)::</b><br>
        <c:forEach var="course" items="${coursesInfo}">
                  ${course} <br>
        </c:forEach>
          <hr>
        <b> ids Info (Map)::</b><br>
        <c:forEach var="id" items="${idsInfo}">
                  ${id.key} ===> ${id.value} <br>
        </c:forEach> --%>
        
      <%--   <h1 style="color:red;text-align:center"> Reading List of Model objects</h1>
        
        <table  border="1" align="center">
            <tr>
               <th> eno </th> <th> ename</th> <th> desg </th> <th> salary </th>
            </tr>
         <c:forEach  var="emp"  items="${empsInfo}">
             <tr>
                <td>${emp.eno}  </td>
                <td>${emp.ename}  </td>
                <td>${emp.desg}  </td>
                <td>${emp.salary}  </td>
             </tr>
         </c:forEach>
         
         </table> --%>
        
     <h1 style="color:red;text-align:center"> Reading  Model object Data</h1>
          <b>emp no  :: ${empInfo.eno } </b> <br>
          <b>emp name  :: ${empInfo.ename } </b> <br>
          <b>emp desg  :: ${empInfo.desg } </b> <br>
          <b>emp salary  :: ${empInfo.salary } </b> <br>
     
     
     
     
     