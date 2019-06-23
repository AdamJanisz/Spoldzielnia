<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>AppUserRole</title>
</head>
<body>
<div class="content">

    <div class="img-circular">
        <div class="content">
            <div class="img-circular1">
                <div class="content">

                    <form:form method="post" action="addAddress.html" modelAttribute="Address">
                        <table>
                            <tr>
                                <td><form:hidden path="id"/>
                            </tr>
                            <tr>
                                <td><form:label path="city"><spring:message code="label.role"/></form:label></td>
                                <td><form:input path="city" /></td>
                                <td><form:errors path="city"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="street"><spring:message code="label.role"/></form:label></td>
                                <td><form:input path="street" /></td>
                                <td><form:errors path="street"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="apartmentNumber"><spring:message code="label.role"/></form:label></td>
                                <td><form:input path="apartmentNumber" /></td>
                                <td><form:errors path="apartmentNumber"/></td>
                            </tr>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="<spring:message code="label.addBuilding"/>"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

