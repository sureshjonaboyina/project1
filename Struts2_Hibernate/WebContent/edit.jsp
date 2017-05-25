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

<s:form action="UpdateRecordInDB" method="post" name="form">
<table>
<tr>
<td colspan="2">

<input type="button" value="DisplayRecords"onclick="display()">
</td>
</tr>

<tr>
<td>
<s:textfield label="Number"value="%{#application.x}" readonly="true"name="b.num"cssClass="bord"/>
<s:textfield label="Name"value="%{#application.y}" name="b.name"cssClass="bord"/>
<s:textfield label="Country"value="%{#application.z}" name="b.ct"cssClass="bord"/>

<s:submit value="Update"/>
</td>
</tr>

</table>
</s:form>

</body>
</html>