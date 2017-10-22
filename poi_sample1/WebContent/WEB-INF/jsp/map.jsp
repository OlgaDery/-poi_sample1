<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<fmt:bundle basename="pages">
<!--  <h2><fmt:message key="page.map.header" /></h2>-->
</fmt:bundle> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.2.1/mustache.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Map</title>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/main.css">

</head>

<body>
 	
 <div class="col-md-6" id="2">
 <p></p>
 <div id="no_data_form" >    
<c:choose>
 <c:when  test="${empty requestScope.success_message}">
 <p></p>
 <span class="glyphicon glyphicon glyphicon-envelope" aria-hidden="true"></span>
 SEE YOUR MESSAGES HERE
 </c:when>
 <c:otherwise>
<span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
 ${requestScope.success_message}
 </c:otherwise>
 </c:choose>
  </div>
 <p></p>
  
 <c:choose>
  	<c:when  test="${not empty sessionScope.pois_for_vis and not empty requestScope.Add_selected}">
  	<div class="col-md-6" id="2-1">
  	<div style="text-align:right">
  		<form method="get" action="<%= request.getContextPath() %>/user">
  		<input type="submit" name = "Add_to_gr" value="Copy selected points to groups" class="input-t1 btn btn-default btn-sm"/>
  		</form>
  		</div>
  		
  		<div style="text-align:right">
  		<form method="get" action="<%= request.getContextPath() %>/user">
  		<input type="submit" name = "Add_to_r" value="Copy selected points to routes" class="input-t1 btn btn-default btn-sm"/>
  		</form>
  		</div>
  		</div>
  	
 	<div class="col-md-6" id="2-2">
 	<div style="text-align:left">
  		<form method="get" action="<%= request.getContextPath() %>/user">
   		<input type="submit" name = "Create_new_r" value="Create a route with the points" class="input-t1 btn btn-info btn-sm"/>
  		</form>
  		</div>
  	
  	<div style="text-align:left">
  		<form method="get" action="<%= request.getContextPath() %>/user/create-gr">
  		<input type="submit" name = "Create_new_g" value="Create a group with the points" class="input-t1 btn btn-info btn-sm"/>
  		</form>
  		</div>
  		</div>
  		<p></p>
 		</c:when>
 		</c:choose>
		
 <c:choose>
 		<c:when  test="${not empty requestScope.Add_to_gr and not empty requestScope.on_map}">
  		<div class="col-md-6" id="2-1">
  		<form method="get" action="<%= request.getContextPath() %>/user">
  			<div class="panel-heading" style="text-align:center"> GROUPS TO COPY TO:</div>
 	   		<div id="scroll_form" style="text-align:left">
 			<table class="table table-hover table-condensed" >
 			
 				<c:forEach items="${sessionScope.user.groups}" var="gr">
 				<tr>
 			    <td>
 				<input type="checkbox" name="group_to_copy_to" value="${gr.group_id}">
   				</td>
 				<td>
 				${gr.group_name}
 				</td>
 			     </tr>
   				</c:forEach>
   				</table>
   				</div>
   				<div style="text-align:left">
   			<input type="submit" name = "Select_g" value="Copy points to the groups" class="input-t1 btn btn-default btn-sm" />
  		</div>
  		</form>	
  		<p></p>
  		</div>
  		
  	 <div class="col-md-6" id="2-2">
  		<div class="panel-heading" style="text-align:center"> POINTS YOU HAVE SELECTED:</div>
 	   		<div id="scroll_form" style="text-align:left">
 			<table class="table table-hover table-condensed" >
 			
 				<c:forEach items="${sessionScope.pois_for_vis}" var="p">
 				<tr>
 			    <td>
 				*
   				</td>
 				<td>
 				${p.poi_name}
 				</td>
 			     </tr>
   				</c:forEach>
   				</table>
   				</div>
  		</div>
 		</c:when>
 	</c:choose>	 
<!-- </div> --> 
<p></p>
<!--  <div class="col-md-6" id="2"> -->

<c:choose>
  		 <c:when  test="${not empty requestScope.on_map and not empty sessionScope.user and empty sessionScope.pois_for_vis}">
  			<form method="get" action="${pageContext.request.requestURI}">
  			<input type="submit" name = "Add_selected" value="Copy filtered points" class="input-t1 btn btn-primary btn-xs" /> - save to you collection points you see on the map
  			</form>
  			<p></p>
  			<form method="get" action="${pageContext.request.requestURI}">
  			<input type="submit" name = "Add_selected_rt" value="Copy filtered routes" class="input-t1 btn btn-primary btn-xs" /> - save routes you see on the map to you collection
  			
  			</form>
  			<p></p>
			</c:when>
  </c:choose>
 
 <div class="col-md-12" id="2-3">		    
<div id="map" >
</div>
<p></p>
 </div> 
</div>

 	
<!--input id="111" name="selectedData" value=""  /-->

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/google_api.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/google_listener.js"></script>




