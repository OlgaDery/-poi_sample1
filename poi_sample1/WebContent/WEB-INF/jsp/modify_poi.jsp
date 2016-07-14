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
<!-- Default panel contents -->
<div class="panel-heading" style="text-align:center">MODIFY POINT:</div>
<c:choose>
	<c:when  test="${not empty requestScope.adminCheck}">
	<form id="poi_form" method="post" action="<%= request.getContextPath() %>/user/admin">
 <!--  <%//=request.getContextPath() %>/Servlet_user_page"> -->
<input type="hidden" name="pendStat" value="${requestScope.poi_to_update.pendStatus}" />
<input type="hidden" name="Poi_id" value="${requestScope.poi_to_update.poi_id}" />
<input type="hidden" name="Main_poi_id" value="0" />
<table class="table table-hover table-condensed">
<tr>
        <td>Poi_name:</td>
        <td><input type="text" name="Poi_name" value="${requestScope.poi_to_update.poi_name}" required /></td>
 <!--           <td><div id="error">${validationErrors['lastName'] }</div></td> --> 
    </tr>
    
<!--     <tr>
        <td>Main_poi_id:</td>
        <td><input type="text" name="Main_poi_id" value="${requestScope.poi_to_update.main_poi_id}"  required /></td>
   <td><div id="error">${validationErrors['email'] }</div></td> 
    </tr> --> 
   
    <tr>
        <td>Latitude:</td>
        <td><input type="text" name="Latitude" value="${requestScope.poi_to_update.poi_lat}" required /></td>
   <!--      <td><div id="error">${validationErrors['userName'] }</div></td> --> 
    </tr>
    <tr>
        <td>Longitude:</td>
        <td><input type="text" name="Longitude" value="${requestScope.poi_to_update.poi_lng}" required /></td>
   <!--   <td><div id="error">${validationErrors['password'] }</div></td> -->    
    </tr>
    <tr>
        <td>Town:</td>
        <td><input type="text" name="Town" value="${requestScope.poi_to_update.town}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Street:</td>
        <td><input type="text" name="Street" value="${requestScope.poi_to_update.street}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Building:</td>
        <td><input type="text" name="Building" value="${requestScope.poi_to_update.building}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Postal code:</td>
        <td><input type="text" name="Post_code" value="${requestScope.poi_to_update.post_code}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>District:</td>
        <td>
         <select name="Distr" class="input-t1">
         <option value="${requestScope.poi_to_update.single_district}" selected >${requestScope.poi_to_update.single_district}</option> 
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
	         <option value="${requestScope.poi_to_update.single_avail}" selected >${requestScope.poi_to_update.single_avail}</option> 
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
	        <option value="${requestScope.poi_to_update.single_status}" selected >${requestScope.poi_to_update.single_status}</option> 
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
	         <option value="${requestScope.poi_to_update.single_poi_main_cat}" selected >${requestScope.poi_to_update.single_poi_main_cat}</option> 
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
	        <option value="${requestScope.poi_to_update.single_poi_add_cat}" selected >${requestScope.poi_to_update.single_poi_add_cat}</option> 
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
	          <option value="${requestScope.poi_to_update.single_poi_sub1}" selected >${requestScope.poi_to_update.single_poi_sub1}</option> 
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
	         <option value="${requestScope.poi_to_update.single_poi_sub2}" selected >${requestScope.poi_to_update.single_poi_sub2}</option> 
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
	         <option value="${requestScope.poi_to_update.rating_index}" selected >${requestScope.poi_to_update.rating_index}</option> 
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
	        <option value="${requestScope.poi_to_update.single_poi_period}" selected >${requestScope.poi_to_update.single_poi_period}</option> 
	        <c:forEach items="${sessionScope. poi_period}" var="pp">
	         <option value="${pp}" >${pp}</option>
	         </c:forEach> 
	         </select>
	        </td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    
    <tr>
        <td>Description:</td>
        <td><input type="text" name="Description" value="${requestScope.poi_to_update.descript}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Weblink:</td>
        <td><input type="text" name="Weblink" value="${requestScope.poi_to_update.weblink}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
   </table>
		 
		 <p></p>
		<div align="left">
		  <input type="submit" name = "Delete_from_pend" value="Delete point" class="input-t1 btn btn-warning btn-sm"/>
		 </div>
		  <p></p>
		  <div align="left">
		  <input type="submit" name = "Approve_pend" value="Approve point" class="input-t1 btn btn-info btn-sm"/>
		 </div>
		  <p></p>
		  <div align="left">
          <input type="submit" name = "Back_to_adminPg" value="Back to admin page" class="input-t1 btn btn-success btn-sm"/>
		</div>
		 <p></p>
		 

        </form>
		 </c:when>
		 
		 <c:otherwise>
		 <form id="poi_form" method="post" action="<%= request.getContextPath() %>/user">
 <!--  <%//=request.getContextPath() %>/Servlet_user_page"> -->
<input type="hidden" name="entityType" value="poi" />
<input type="hidden" name="Poi_id" value="${requestScope.poi_to_update.poi_id}" />
<input type="hidden" name="Main_poi_id" value="0" />
<table class="table table-hover table-condensed">
    <tr>
        <td>Poi_name:</td>
        <td><input type="text" name="Poi_name" value="${requestScope.poi_to_update.poi_name}" required /></td>
 <!--           <td><div id="error">${validationErrors['lastName'] }</div></td> --> 
    </tr>
    
<!--     <tr>
        <td>Main_poi_id:</td>
        <td><input type="text" name="Main_poi_id" value="${requestScope.poi_to_update.main_poi_id}"  required /></td>
            <td><div id="error">${validationErrors['email'] }</div></td> 
    </tr>--> 
    
    <tr>
        <td>Latitude:</td>
        <td><input type="text" name="Latitude" value="${requestScope.poi_to_update.poi_lat}" required /></td>
   <!--      <td><div id="error">${validationErrors['userName'] }</div></td> --> 
    </tr>
    <tr>
        <td>Longitude:</td>
        <td><input type="text" name="Longitude" value="${requestScope.poi_to_update.poi_lng}" required /></td>
   <!--   <td><div id="error">${validationErrors['password'] }</div></td> -->    
    </tr>
    <tr>
        <td>Town:</td>
        <td><input type="text" name="Town" value="${requestScope.poi_to_update.town}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Street:</td>
        <td><input type="text" name="Street" value="${requestScope.poi_to_update.street}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Building:</td>
        <td><input type="text" name="Building" value="${requestScope.poi_to_update.building}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Postal code:</td>
        <td><input type="text" name="Post_code" value="${requestScope.poi_to_update.post_code}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>District:</td>
        <td>
         <select name="Distr" class="input-t1">
         <option value="${requestScope.poi_to_update.single_district}" selected >${requestScope.poi_to_update.single_district}</option> 
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
	         <option value="${requestScope.poi_to_update.single_avail}" selected >${requestScope.poi_to_update.single_avail}</option> 
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
	        <option value="${requestScope.poi_to_update.single_status}" selected >${requestScope.poi_to_update.single_status}</option> 
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
	         <option value="${requestScope.poi_to_update.single_poi_main_cat}" selected >${requestScope.poi_to_update.single_poi_main_cat}</option> 
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
	        <option value="${requestScope.poi_to_update.single_poi_add_cat}" selected >${requestScope.poi_to_update.single_poi_add_cat}</option> 
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
	          <option value="${requestScope.poi_to_update.single_poi_sub1}" selected >${requestScope.poi_to_update.single_poi_sub1}</option> 
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
	         <option value="${requestScope.poi_to_update.single_poi_sub2}" selected >${requestScope.poi_to_update.single_poi_sub2}</option> 
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
	         <option value="${requestScope.poi_to_update.rating_index}" selected >${requestScope.poi_to_update.rating_index}</option> 
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
	        <option value="${requestScope.poi_to_update.single_poi_period}" selected >${requestScope.poi_to_update.single_poi_period}</option> 
	        <c:forEach items="${sessionScope. poi_period}" var="pp">
	         <option value="${pp}" >${pp}</option>
	         </c:forEach> 
	         </select>
	        </td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    
    <tr>
        <td>Description:</td>
        <td><input type="text" name="Description" value="${requestScope.poi_to_update.descript}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
    
    <tr>
        <td>Weblink:</td>
        <td><input type="text" name="Weblink" value="${requestScope.poi_to_update.weblink}" required /></td>
        <td><!-- Error Message goes here --></td>
    </tr>
   </table>
   
      <c:choose>
		 <c:when  test="${not empty requestScope.newMod}">
		 <div align="left">
		 <input type="submit" name = "Update_poi" value="Update poi" class="input-t1 btn btn-default btn-sm" />
		 </div>
		  <p></p>
		  <div align="left">
		 <input type="submit" name = "Back_to_collections" value="Back to collections" class="input-t1 btn btn-success btn-sm"/>
		</div>
		 </c:when>
		  </c:choose>
		  <c:choose>
		 <c:when  test="${not empty requestScope.updateCR}">
		 
		 <p></p>
		<div align="left">
		  <input type="submit" name = "Update_pend" value="Update point" class="input-t1 btn btn-default btn-sm" />
		</div> 
		  <p></p>
		  <div align="left">
		  <input type="submit" name = "Delete_from_pend" value="Delete point" class="input-t1 btn btn-warning btn-sm"/>
		 </div>
<p></p>
<div align="left">
          <input type="submit" name = "Back_to_collections" value="Back to collections" class="input-t1 btn btn-success btn-sm"/>
		</div>
		 <p></p>
		 </c:when>
		 </c:choose>
		 

        </form>
	</c:otherwise>
</c:choose>

</div>


</body>
</html>