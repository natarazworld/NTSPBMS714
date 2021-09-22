
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<form:form action="customer_register"  modelAttribute="cust">
   <table align="center" bgcolor="cyan">
      <tr>
          <td>Customer name :: </td>
          <td> <form:input path="cname"/> </td> 
      </tr>
      <tr>
          <td>Select Country :: </td>
          <td> 
            <form:select path="country">
                <form:options items="${countriesInfo}"/>
            </form:select>
          </td> 
      </tr>
      <tr>
          <td>Select known languages :: </td>
          <td> 
            <form:select path="languages" multiple="multiple" size="5" >
                <form:options items="${languagesInfo}"/>
            </form:select>
          </td> 
      </tr>
      
      <tr>
          <td>Select hobbies :: </td>
          <td>
             <form:checkboxes items="${hobbiesInfo}" path="hb"/> 
          </td> 
      </tr>
      
      <tr>
         <td><input type="submit" value="Register">  </td>
         <td><input type="Reset" value="cancel"> </td>
      </tr>
   
   </table>

</form:form>