<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form  modelAttribute="cktr">
   <table border="0"  bgcolor="cyan" align="center">
   <p style="color:red">  
       <form:errors path="*"/>
     </p> 
       <tr>
         <td>CricketerName  </td>
         <td><form:input path="name"/>  </td>
       </tr>
       <tr>
         <td>Cricketer Type  </td>
         <td><form:input path="type"/>  </td>
       </tr>
       <tr>
         <td>Cricketer DOB  </td>
         <td><form:input path="dob" type="date"/>  </td>
       </tr>
       <tr>
         <td>Cricketer Time of Birth  </td>
         <td><form:input path="tob" type="time"/>  </td>
       </tr>
       <tr>
         <td>Cricketer DebueDate and Time  </td>
         <td><form:input path="doj" type="datetime-local"/>  </td>
       </tr>
       <tr>
         <td><input type="submit" value="register">  </td>
         <td><input type="reset" value="cancel"> </td>
       </tr>
   </table>

</form:form>
