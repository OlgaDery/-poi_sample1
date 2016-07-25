<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="pages" var="pages" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/bootstrap-3.3.6-dist/js/bootstrap.min.js">

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/styles/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message bundle="${pages}" key="${pageTitle}" /></title>
</head>

<body>
<div id="header">
 
    <div id="menu">
        <!-- Display the Navigation -->
        <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=" ">YourNAVIGUIDE </a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
            <ul class="nav navbar-nav">
               
               <c:forEach items="${applicationScope.webPages}" var="webPage">
               <c:if test="${webPage.value.displayInMenu == true }">
             	 <li> <a href="${webPage.value.uri}"><fmt:message key="${webPage.value.displayNameKey}" bundle="${pages}"/></a></li>
           		 </c:if>
              </c:forEach>
            </ul>
        </div>
    </div>
</div>
        
        </div>
       </div>
       
        <div class="container body-content">
         <div class="row">
         <div class="col-md-3" id="1"></div> 

	     <div class="col-md-6" id="2">
	     <div class="row">
	      	<div class="col-md-6" id="2-1"></div>
	        <div class="col-md-6" id="2-2"></div>
	        <div class="col-md-12" id="2-3"></div>
	     </div>
	     </div>
         <div class="col-md-3" id="3"></div>
         </div>
        
         </div>

   
</body>

