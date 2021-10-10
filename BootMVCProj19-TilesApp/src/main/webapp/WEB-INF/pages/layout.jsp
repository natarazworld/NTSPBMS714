<%@taglib uri="http://tiles.apache.org/tags-tiles"   prefix="tiles"%>

<head>
   <title><tiles:insertAttribute name="title"  ignore="true"/> </title>
</head>
<table border="0" height="100%"  width="100%"  rows="3" cols="3">
   <tr height="30%"  bgcolor="pink">
          <td colspan="3"><tiles:insertAttribute name="header"/>   </td>
   </tr>
 <tr height="60%">
   <td  width="20%" bgcolor="cyan"><tiles:insertAttribute name="menu"/>   </td>
 <td  width="60%" bgcolor="yellow"><tiles:insertAttribute name="body"/>   </td>
 <td  width="20%"><tiles:insertAttribute name="advertisement"/>   </td>
 </tr>

<tr height="10%" bgcolor="grey">
          <td colspan="3"><tiles:insertAttribute name="footer"/>   </td>
   </tr>

</table>