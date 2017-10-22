<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/main.css">

</head>
<body>


 <div class="col-md-3" id="3"> 
 <div style="text-align:center"><h3>Filters for attractions:</h3></div>
 If you need more details about any shown point, click the marker on the map. 
  <c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
 	<p></p>
 		<form method="get" action="${pageContext.request.requestURI}">
		<input type="submit" name = "filter_pois_only" value="Enable filters for points" class = "input-t1 btn btn-success btn-sm"/>
 		</form>
 		<p></p>
 		</c:when>
 	</c:choose>
 		
<form method="get" action="${pageContext.request.requestURI}">
<p></p>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style="text-align:center">Select the district</div>
  <div class="panel-body">
    <div id="scroll_form">
 <c:forEach items="${applicationScope.districts}" var="d">

 <c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
	<input type="checkbox" name = "district" disabled="disabled" value="${d}">${d}<br>
	 </c:when>
	 <c:otherwise>
	 <c:if  test="${d eq 'Nizhnyaya Salda' or d eq 'Verkhne-saldinsky'}">
 	<input type="checkbox" name = "district" value="${d}">${d}<br>
 	</c:if>
 	</c:otherwise>
 	</c:choose>
   </c:forEach>
   </div>
  </div>
</div>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style="text-align:center">Select the category</div>
  <div class="panel-body">
  <div id="scroll_form">
 <c:forEach items="${applicationScope.poi_subcat1}" var="sub1">
 
	<c:if  test="${sub1 ne 'n/a'}">
 	<c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
	<input type="checkbox" name = "poi_subc1" disabled="disabled" value="${sub1}">${sub1}<br>
	 </c:when>
	 <c:otherwise>
		<input type="checkbox" name = "poi_subc1" value="${sub1}">${sub1}<br>
	</c:otherwise>
	</c:choose>
	</c:if>
 
   </c:forEach>
 
<c:forEach items="${applicationScope.poi_subcat2}" var="sub2">
 
	<c:if  test="${sub2 ne 'n/a'}">
	<c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
	<input type="checkbox" name = "poi_subc2" disabled="disabled" value="${sub2}">${sub2}<br>
	 </c:when>
	 <c:otherwise>
		<input type="checkbox" name = "poi_subc2" value="${sub2}">${sub2}<br>
		</c:otherwise>
		</c:choose>
		</c:if>
   </c:forEach>
   </div>
 </div>  
 </div>    
 
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style="text-align:center">Select the status</div>
  <div class="panel-body">
  <div id="scroll_form">
	<c:forEach items="${applicationScope.status}" var="st">
	<c:if  test="${st ne 'n/a'}">
	<c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
	<input type="checkbox" name = "status" disabled="disabled" value="${st}">${st}<br>
	 </c:when>
	 <c:otherwise>
	<input type="checkbox" name = "status" value="${st}">${st}<br>
	</c:otherwise>
	</c:choose>
	</c:if>
    </c:forEach>
   </div>
 </div> 
 </div>  
    
 <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style="text-align:center">Select visitors rating</div>
  <div class="panel-body">
  <div id="scroll_form">
<c:forEach items="${applicationScope.rating}" var="r">
<c:choose>
	 <c:when  test="${not empty sessionScope.show_collect}">
	<input type="checkbox" name = "rating" disabled="disabled" value="${r}">${r}<br>
	 </c:when>
	 <c:otherwise>
	<input type="checkbox" name = "rating" value="${r}">${r}<br>
	</c:otherwise>
	</c:choose>
    </c:forEach>
   </div>
 </div>
 </div>  
 <!--   <div id ="submit_butt">
   <input type="submit" name = "Select_poi_filters" value="Select" />
 </div> --> 
 </form>
  </div> 

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/google_api.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/google_listener.js"></script>
