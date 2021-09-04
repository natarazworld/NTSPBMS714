<%@ page isELIgnored="false" %>

 <h1 style="color:green;text-align:center">Employee registration form</h1>
 
 <form   method="POST">
     <table align="center">
         <tr><td>Employee number::  </td> <td><input type="text" name="eno"> </td></tr>
         <tr><td>Employee name::  </td> <td><input type="text" name="ename"> </td></tr>
       <tr><td>Employee address::  </td> <td><input type="text" name="eadd"> </td></tr>
       <tr><td>Employee  salary::  </td> <td><input type="text" name="salary"> </td></tr>
       <tr><td colspan="2"><input type="submit"  value="register"> </td> </tr>
     </table>
 
 </form>