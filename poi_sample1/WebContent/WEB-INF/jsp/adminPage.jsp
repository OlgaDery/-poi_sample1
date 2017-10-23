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
  <div align="center">
   <form method="post" action="${pageContext.request.requestURI}">
      <input type="submit" name = "uploadPs" value = "Upload points" class = "input-t1 btn btn-success btn-lg"/> 
  
  </form>
  </div>
</body>
</html>