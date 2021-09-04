<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
 <h1 style="color:green;text-align:center">Employee registration form</h1>
 
 <form:form  modelAttribute="emp">
     <table align="center" bgcolor="cyan">
         <tr><td>Employee number::  </td> <td><form:input path="eno"/> </td></tr>
         <tr><td>Employee name::  </td> <td><form:input path="ename"/> </td></tr>
       <tr><td>Employee address::  </td> <td><form:input path="eadd"/> </td></tr>
       <tr><td>Employee salary::  </td> <td><form:input path="esalary"/> </td></tr>
       <tr><td colspan="2"><input type="submit"  value="register"> </td> </tr>
     </table>
 </form:form>