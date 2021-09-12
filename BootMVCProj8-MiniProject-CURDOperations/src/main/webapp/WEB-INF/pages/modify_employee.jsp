<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:blue;text-align:center">Edit Employee </h1>

<form:form  modelAttribute="emp">
    <table border="0" bgcolor="cyan" align="center">
    <tr>
           <td>  Employee eno :: </td>
           <td>  <form:input path="empno"  readonly="true"/> </td>
        </tr>
        <tr>
           <td>  Employee name :: </td>
           <td>  <form:input path="ename"/> </td>
        </tr>
        <tr>
           <td>  Employee Desg :: </td>
           <td>  <form:input path="job"/> </td>
        </tr>
        <tr>
           <td>  Employee Salary :: </td>
           <td>  <form:input path="sal"/> </td>
        </tr>
        <tr>
           <td>  Employee Dept no :: </td>
           <td>  <form:input path="deptno"/> </td>
        </tr>
        <tr>
           <td> <input type="submit"  value="Edit Employee" > </td>
           <td> <button  type="reset" > Cancel</button>  </td>
        </tr>
    </table>
</form:form>



