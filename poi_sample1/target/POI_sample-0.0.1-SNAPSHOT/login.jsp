<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<title>Login</title>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<div align="center" >
<form name="loginForm" method="POST" action="j_security_check" >

    <p><input type="text" id="j_username" name="j_username" placeholder="Your name"></p>
   
   <p> <input type="password" name="j_password" placeholder="Password"> </p>
      
      <p></p>
<p><input type="submit" name = "Log in" value="Log in" /></p>
</form>
<script type="text/javascript">
document.getElementById("j_username").focus();
</script> 
</div>

<%@include file="/WEB-INF/jsp/footer.jsp" %>
