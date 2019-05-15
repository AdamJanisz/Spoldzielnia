<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
<html>
<head>    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet"> </head>
<body>
<div class="topnav" id="myTopnav">


		<a href="/" class="active">Home</a>
	<a href="/appUsers.html">Login</a>
	<a href="#contact">Contact</a>
	<a href="/#about">About</a>
	<a href="javascript:void(0);" class="icon" onclick="myFunction()">
		<i class="fa fa-bars"></i>
	</a>
    	<a href="?lang=pl">pl</a> <a  href="?lang=en">en</a>  <a  href="?lang=de">de</a>

	<br>

</div>







<script>
	function myFunction() {
		var x = document.getElementById("myTopnav");
		if (x.className === "topnav") {
			x.className += " responsive";
		} else {
			x.className = "topnav";
		}
	}
</script>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>


