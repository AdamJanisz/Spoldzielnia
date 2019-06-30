<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 30.06.2019
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Bree Serif' rel='stylesheet'>
<head>
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

</head>

<body>

<div class="bg-img">

    <div class="content">

        <div class="img-circular">
            <div class="content">

                <c:if test="${not empty deleteError}">
                    <div class="error">${deleteError}</div>
                </c:if>
            </div>
        </div>
    </div>

</div>
</body>
</html>