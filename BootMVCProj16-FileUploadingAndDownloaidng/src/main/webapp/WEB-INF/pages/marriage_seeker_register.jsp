<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:red;text-align:center">Marriage Seeker Registration</h1>

<form:form  modelAttribute="profile"  enctype="multipart/form-data">
    <table align="center" bgcolor="cyan">
          <tr>
             <td>Marriage seeker name::  </td>
             <td><form:input path="profileName"/>  </td>
          </tr>
          <tr>
             <td>Marriage seeker gender::  </td>
             <td>
                   <form:radiobutton path="gender" value="male" />  Male &nbsp;&nbsp;
                   <form:radiobutton path="gender" value="female" /> FeMale
               </td>
          </tr>
            <tr>
             <td>Select Resume  </td>
             <td><form:input type="file"  path="resume"/>    </td>
          </tr>
          <tr>
             <td>Select Photo  </td>
             <td><form:input type="file"  path="photo"/>    </td>
          </tr>
           <tr>
             <td><input type="submit"  value="Register"> </td>
             <td><input type="reset"  value="Cancel"> </td>
          </tr>
    </table>
</form:form>