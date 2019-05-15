<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <div class="img-circular1">
                    <div class="content">


                        <form method="post" action="/addAppUser" class="container">

                            <table>

                                <tr>
                                    <td><label path="firstName"><b><spring:message code="label.firstName"/></b></label>
                                    </td>
                                    <td><input name="firstName"/></td>
                                </tr>
                                <tr>
                                    <td><label path="lastName"><b><spring:message code="label.lastName"/></b></label>
                                    </td>
                                    <td><input name="lastName"/></td>
                                </tr>
                                <tr>
                                    <td><label path="email"><b><spring:message code="label.email"/></b></label></td>
                                    <td><input name="email"/></td>
                                </tr>
                                <tr>
                                    <td><label path="telephone"><b><spring:message code="label.telephone"/></b></label>
                                    </td>
                                    <td><input name="telephone"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button type="submit" class="btn">Confirm</button>
                                    </td>
                                </tr>

                            </table>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>

<body>



