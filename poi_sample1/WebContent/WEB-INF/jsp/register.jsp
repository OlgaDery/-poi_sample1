<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
        
<fmt:bundle basename="pages">

</fmt:bundle> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div class="col-md-6" id="2">
<c:choose>
 	    <c:when  test="${!empty requestScope.success_message}">
 	    <h3>CONGRADULATIONS! NOW YOU CAN LOG IN AND USE THE EXTEND FUNCTIONALITY.</h3>
 	    </c:when>
 	    <c:otherwise>
 	    
<form id="registrationForm" method="post" action="<%= request.getContextPath() %>/map/main">
<input type="hidden" name="entityType" value="User_entity" />
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style="text-align:center" >ENTER THE DATA:</div>
<table class="table table-hover table-condensed" style="text-align:center">
  <tr>
    <td>First Name:</td>
        <td><input type="text" id="firstName" name="firstName" value=" " /></td>
  </tr>
    <tr>
        <td>Last Name:</td>
        <td><input type="text" name="lastName" value=" " /></td>
    </tr>
    
    <tr>
        <td>Email:</td>
        <td><input type="text" name="email" value=" " /></td>
    </tr>
    
    <tr>
        <td>UserName:</td>
        <td><input type="text" name="userName" value=" " /></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="password" name="password" value="" /></td>
    </tr>
  </table>
   </div>
   <input type="submit" name = "Create user" value="Submit" class="input-t1 btn btn-primary btn-xs"/>


</form>
 	    </c:otherwise>
 </c:choose>


</div>
<body>