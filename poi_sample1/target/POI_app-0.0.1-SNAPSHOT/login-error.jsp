<%@include file="/WEB-INF/jsp/header.jsp" %>

<div align="center" >
<strong><font color="red">Invalid Username/Password</font></strong>
<br />
<br />
<form method="POST" action="j_security_check" >
<table style="width:50%" border="1">
<tr>
    <td>Username:</td>
    <td><input type="text" id="j_username" name="j_username"></td>
</tr>
<tr>
    <td>Password:</td>
    <td><input type="password" name="j_password"></td>
</tr>
<tr>
    <td colspan="2" align="right"><input type="submit" /></td>
</tr>

</table>
</form>
</div>

<script type="text/javascript">
document.getElementById("j_username").focus();
</script>

<%@include file="/WEB-INF/jsp/footer.jsp" %>
