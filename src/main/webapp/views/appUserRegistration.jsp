<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<%-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Bree Serif' rel='stylesheet'>--%>
<head>
    <%-- <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">--%>
        <script src="http://www.google.com/recaptcha/api.js"></script>
</head>

<body>

<div class="content">

    <div class="img-circular1">
        <div class="content">



             <form:form method="post" action="registerAppUser.html " modelAttribute="appUser">

            <table>
                <tr>
                    <td><form:hidden path="id"/>
                </tr>
                <tr>
                    <td><form:label path="login"><spring:message code="label.login"/></form:label></td>
                    <td><form:input path="login" /></td>
                </tr>
                <tr>
                    <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                    <td><form:input type="password"  path="password" /></td>
                </tr>
                <tr>
                    <td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
                    <td><form:checkbox path="enabled" /></td>

                </tr>
                <tr>
                    <td><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
                    <td><form:input path="firstName" /></td>
                    <td><form:errors path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName"><spring:message code="label.lastName"/></form:label></td>
                    <td><form:input path="lastName" /></td>
                    <td><form:errors path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
                    <td><form:input path="email" /></td>
                    <td><form:errors path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
                    <td><form:input path="telephone" /></td>
                    <td><form:errors path="telephone"/></td>
                </tr>

                <td><form:label path="appartment"><spring:message code="label.address" /></form:label> </td>
                <td><form:select path="appartment">
                    <c:forEach items="${appartmentList}" var="appartment">
                        <option value="${appartment.id}" ${appartment.id == selectedAppartment ? 'selected="selected"' : ''}>${appartment.appartmentAddress.city}<a>    </a>${appartment.appartmentAddress.street}<a>    </a>${appartment.appartmentAddress.buildingNumber}<a> / </a>${appartment.appartmentNumber}</option>
                    </c:forEach>
                </form:select></td>

                <tr>
                    <td colspan="3">
                        <div class="g-recaptcha" data-sitekey="6LfP_qsUAAAAAHauI7TMQrAuvSl1hxhMn1dOKshE"></div>
                    </td>
                </tr>



                <tr>
                    <td colspan="2">

                        <c:if test="${appUser.id!=0}">
                            <input type="submit" value="<spring:message code="label.editAppUser"/>"/>
                        </c:if>

                        <c:if test="${appUser.id==0}">
                            <input type="submit" value="<spring:message code="label.signup"/>"/>
                        </c:if>
                    </td>
                </tr>




            </table>
        </form:form>
        </div>
    </div>
</div>







</body>
</html>