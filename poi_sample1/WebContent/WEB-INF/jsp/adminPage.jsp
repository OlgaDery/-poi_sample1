<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <fmt:bundle basename="pages">
</fmt:bundle> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<div class="col-md-6" id="2">
<p></p>
 <div id="no_data_form" >       
<c:choose>
 <c:when  test="${empty requestScope.success_message}">
 <p></p>
 <span class="glyphicon glyphicon glyphicon-envelope" aria-hidden="true"></span>
 SEE YOUR MESSAGES THERE
 </c:when>
 <c:otherwise>
<span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
 ${requestScope.success_message}
 </c:otherwise>
 </c:choose>
  </div>
  
  <p></p> 
   <form method="post" action="${pageContext.request.requestURI}">
  <div class="panel panel-default" style="text-align:center">
      <!-- Default panel contents -->
     <div class="panel-heading" style="text-align:center" >ENTER THE PATH TO THE FILE WITH YOUR POINTS AND PRESS THE BUTTON:</div>
	  <table class="table table-hover table-condensed">
	    <tr>
	        <td>Path (like c:/opt/pois.txt):</td>
	        <td><input type="text" name="path" value="" required/></td>
	    </tr>
	    </table>
	    <input type="submit" name = "uploadPs" value = "Upload points" class = "input-t1 btn btn-success btn-sm"/> 
	    </div>
  
 		</form>
 		
  <div style="text-align:center">
  <b>SELECT THE OPERATION:</b> 
 		<p></p>
 	</div>
 		
 		<form method="get" action="${pageContext.request.requestURI}">
		<input type="submit" name = "select_pendCr" value = "Check created points out" class = "input-t1 btn btn-default btn-sm"/> - see the table with created points
 		</form>
  		<p></p>
   
  <c:choose>
 <c:when  test="${not empty sessionScope.showpendCr}">
  <div class="panel panel-default">
 <div class="panel-heading" style="text-align:center"> Pending created points</div>
	 <c:choose>
	 <c:when  test="${empty applicationScope.pendCr}">
	 <td><div style="text-align:center">List of pending created points is empty</div></td>
	 </c:when>
	 <c:otherwise>
	
	<form method="get" action="<%= request.getContextPath() %>/user/modify-p">
	<div id = "scroll_form1">
	<table class="table table-hover table-condensed">
	<tr>
	  <td>
	 
	  </td>
	  <td>
	 Name
	  </td>
	  <td>
	 Creator ID
	  </td>
	  <td>
	 Creation date
	  </td>
	   <td>
	   </td>
	   </tr>
	   
	 <c:forEach items="${applicationScope.pendCr}" var="poi">
	  <tr>
	  <td>
	 <input type="radio" name="pois_of_user" value="${poi.poi_id}">
	  </td>
	  <td>
	 ${poi.poi_name}
	  </td>
	  <td>
	 ${poi.creator_id}
	  </td>
	  <td>
	 ${poi.creation_date}
	  </td>
	   <td align="right">
	 <input type="submit" name = "check_out_Cr" value = "Edit" class="btn btn-default btn-xs">
	  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	   </td>
	   </tr>
	   </c:forEach>
	     </table>
	   </div>
	  </form>
	 </c:otherwise>
 	</c:choose>
 	 </div>
 	 <form method="get" action="${pageContext.request.requestURI}">
	  <input type="submit" name = "hide_pendCr" value = "Hide table" class="btn btn-warning btn-sm">
	 </form>
  </c:when>
  </c:choose> 
   
 </div>
</body>
</html>