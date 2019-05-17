<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
<html>
<head>    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet"> </head>
<body>
<div class="topnav" id="myTopnav">


		<a href="/" class="active"><spring:message code="label.home"/></a>
	<a href="/appUsers.html">Login</a>
	<a href="#contact">Contact</a>
	<a href="/#about">About</a>
	<a href="javascript:void(0);" class="icon" onclick="myFunction()">
		<i class="fa fa-bars"></i>
	</a>
    	<a href="?lang=pl">pl</a> <a  href="?lang=en">en</a>  <a  href="?lang=it">it</a>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<!-- csrf for log out-->
	<form action="/login?logout" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<br/>
	<div>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<p>
				<spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name} |
				<a href="javascript:formSubmit()"> Logout</a>
			</p>
		</c:if>
	</div>
</div>

</body>
</html>



