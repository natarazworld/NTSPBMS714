<%@ page  isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<c:choose>
  <c:when test="${!empty  seekersInfo }">
      <table border="1"  align="center" bgcolor="pink">
           <tr  bgcolor="yellow">
             <th>ProfileId </th> <th>ProfileName  </th> <th>Gender  </th><th>Resume</th><th>Photo </th> 
           </tr>
           <c:forEach var="seeker" items="${seekersInfo}">
                 <tr>
                    <td>${seeker.profileId}  </td>
                    <td>${seeker.profileName}  </td>
                    <td>${seeker.gender}  </td>
                    <td><a href="download?file=${seeker.resumePath}">${seeker.resumePath} </a> </td>
                    <td><a href="download?file=${seeker.photoPath}">${seeker.photoPath}  </a></td>
                 </tr>
           </c:forEach>
      </table>
  </c:when>
  <c:otherwise>
            <h1 style="color:red;text-align:center"> Records not found </h1>
  </c:otherwise> 
</c:choose>
