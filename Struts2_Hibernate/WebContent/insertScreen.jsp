<%@ taglib uri="/struts-tags" 
    prefix="s"%>
    <%@ page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/javaman.css"/>
<script type="text/javascript">

function display()
{
	document.form.action="verify.action";
	document.form.submit();
	}
</script>

</head>
<body>

<s:form action="insert" name="form">
<table>
<tr>
<td colspan="2">

<input type="button" value="displayRecords" onclick="display()">
</td>
</tr>

<tr>
<td>

<s:textfield label="Number"name="b.num"cssClass="bord"/>
<s:textfield label="Name"name="b.name"cssClass="bord"/>
<s:textfield label="Country"name="b.ct"cssClass="bord"/>

<s:submit value="Insert"/>
</td>
</tr>

</table>
</s:form>

</body>
</html>