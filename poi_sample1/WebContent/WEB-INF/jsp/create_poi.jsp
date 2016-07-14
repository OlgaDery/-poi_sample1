<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<fmt:bundle basename="pages">

</fmt:bundle> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/main.css">
</head>

<body>
<div class="col-md-3" id="1">
	 <form id="poi_create_form" method="post" action="<%= request.getContextPath() %>/user">
	 <!--  <%//=request.getContextPath() %>/Servlet_user_page"> -->
	<input type="hidden" name="entityType" value="poi" />
	<input type="hidden" name="Main_poi_id" value="0" />
	 <div class="panel panel-default">
      <!-- Default panel contents -->
     <div class="panel-heading">ENTER THE DATA:</div>
	  <table class="table table-hover table-condensed">
	    <tr>
	        <td>Name:</td>
	        <td><input type="text" name="Poi_name" value="" required class="input-t1"/></td>
	 <!--           <td><div id="error">${validationErrors['lastName'] }</div></td> --> 
	    </tr>
	    
<!--  	    <tr>
	        <td>Main poi id:</td>
	        <td><input type="text" name="Main_poi_id" value=""  required class="input-t1"/></td>
	           <td><div id="error">${validationErrors['email'] }</div></td>  
	    </tr>-->
	    
	    <tr>
	        <td>Latitude:</td>
	        <td><input type="text" name="Latitude" value="" onfocus="if (this.value == 'Latitude..') this.value=''" required class="input-t1"/></td>
	   <!--      <td><div id="error">${validationErrors['userName'] }</div></td> --> 
	    </tr>
	    <tr>
	        <td>Longitude:</td>
	        <td><input type="text" name="Longitude" value="" onfocus="if (this.value == 'Type..') this.value=''" required class="input-t1"/></td>
	   <!--   <td><div id="error">${validationErrors['password'] }</div></td> -->    
	    </tr>
	    <tr>
	        <td>Town:</td>
	        <td><input type="text" name="Town" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Street:</td>
	        <td><input type="text" name="Street" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Building:</td>
	        <td><input type="text" name="Building" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Postal code:</td>
	        <td><input type="text" name="Post_code" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>District:</td>
	        <td>
	        <select name="Distr" class="input-t1">
	        <c:forEach items="${sessionScope.poi_districts}" var="d">
	         <option value="${d}">${d}</option>
	         </c:forEach> 
	         </select>
	         </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	     <tr>
	        <td>Availability:</td>
	        <td>
	        <select name="Avail" class="input-t1">
	        <c:forEach items="${sessionScope.poi_avail}" var="a">
	         <option value="${a}">${a}</option>
	         </c:forEach> 
	         </select>
	         </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Status:</td>
	        <td>
	         <select name="Status" class="input-t1">
	        <c:forEach items="${sessionScope.poi_status}" var="s">
	         <option value="${s}" >${s}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Main category:</td>
	        <td>
	        <select name="Main_cat" class="input-t1">
	        <c:forEach items="${sessionScope.poi_main_cat}" var="m">
	         <option value="${m}">${m}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Additional category:</td>
	        <td>
	        <select name="Add_cat" class="input-t1">
	        <c:forEach items="${sessionScope.poi_add_cat}" var="ac">
	         <option value="${ac}">${ac}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Subcategory1:</td>
	        <td>
	        <select name="Sub_1" class="input-t1">
	        <c:forEach items="${sessionScope.poi_sub1}" var="s1">
	         <option value="${s1}">${s1}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Subcategory2:</td>
	        <td>
	        <select name="Sub_2" class="input-t1">
	        <c:forEach items="${sessionScope.poi_sub2}" var="s2">
	         <option value="${s2}">${s2}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Rating:</td>
	        <td>
	        <select name="Rating" class="input-t1">
	        <c:forEach items="${sessionScope.poi_rating}" var="r">
	         <option value="${r}">${r}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Historical period:</td>
	        <td>
	        <select name="Period" class="input-t1">
	        <c:forEach items="${sessionScope. poi_period}" var="pp">
	         <option value="${pp}" >${pp}</option>
	         </c:forEach> 
	         </select>
	        </td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    
	    <tr>
	        <td>Description:</td>
	        <td><input type="text" name="Description" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	    <tr>
	        <td>Weblink:</td>
	        <td><input type="text" name="Weblink" value="" required class="input-t1"/></td>
	        <td><!-- Error Message goes here --></td>
	    </tr>
	    
	</table>
	</div>
<div align="left">	    
<input type="submit" name = "Submit_poi" value="Submit point" class="input-t1 btn btn-default btn-info btn-sm"/>
</div>
</form>

<p></p>
	
<form method="get" action="<%= request.getContextPath() %>/user">  
<div align="left">
<input type="submit" name = "Back_to_collections" value="Back to collections" class="input-t1 btn btn-default btn-success btn-sm"/>
</div>
</form>

</div>

</body>
</html>