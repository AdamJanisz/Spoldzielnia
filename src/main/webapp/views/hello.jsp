
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Bree Serif' rel='stylesheet'>
<head>

    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
</head>

<c:if test="${pageContext.request.userPrincipal.name == null}">
<body onload='document.loginForm.username.focus();'>



<div class="bg-img">
    <div class="content">
        <div class="img-circular"><div class="content">

            <div class="col_white">
                <div id="login-box">

                    <h3>Login with Username and Password</h3>

                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>
                </div>

                <form name='loginForm' action="<c:url value='/login'/>" method='POST'>

                    <table>
                        <tr>
                            <td>AppUser:</td>
                            <td><input type='text' name='login' value=''></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' name='password' /></td>
                        </tr>
                        <tr>
                            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                        </tr>
                    </table>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>

            </div>
        </div>       </div>
    </div>
</div>

</div>

</body>
</c:if>


</html>


