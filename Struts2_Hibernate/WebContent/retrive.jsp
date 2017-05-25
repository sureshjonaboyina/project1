<%@ taglib uri="/struts-tags" 
    prefix="s"%>
    <%@ page import="java.util.*,javaman.Mybean" %>
    <% Mybean b; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/javaman.css"/>
<script type="text/javascript">

function deleteRecord()
{
	document.form.action="delete.action";
	document.form.submit();
	}
	
function insertRecord()
{
	document.form.action="insertLink.action";
	document.form.submit();
	}
	
function editr(val)
{
	document.form.action="update.action?fid="+val;
	document.form.submit();
	}
</script>
</head>

<form method="post" name="form">
<table>
<tr>
<td colspan="5">
<font face="verdana" size="2">

<input type="button" value="insert" onclick="insertRecord()">
<input type="button" value="delete" onclick="deleteRecord()"><br><br>

</font>

</td>
</tr>

<tr>
<td><center>+</center></td>
<td><b>SNO</b></td>
<td><b>SNAME</b></td>
<td><b>COUNTRY</b></td>
</tr>

<%
List l=(List)request.getAttribute("rec");
if(l!=null)
{
	Iterator it=l.iterator();
	while(it.hasNext())
	{
		b=(javaman.Mybean)it.next();
	

%>
<tr>
<td><input type="checkbox" value="<%=b.getNum()%>"name="rdel"></td>
        <td><%= b.getNum()%></td>
        <td><%= b.getName()%></td>
        <td><%= b.getCt()%></td>
<td><a href="javascript:editr('<%=b.getNum()%>')">EDIT</a></td>
</tr>
	
	<%
	}
}
	%>
</table>
</form>

</html>