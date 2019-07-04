<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 04.07.2019
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content">

    <div class="img-circular">
        <div class="content">
            <div class="img-circular1">
                <div class="content">

                    <form:form method="post" action="addManager.html" modelAttribute="address">
                        <table>
                            <tr>
                                <td><form:hidden path="id"/>
                            </tr>
                            <tr>
                                <td><form:hidden path="city"/>
                            </tr>
                            <tr>
                                <td><form:hidden path="street"/>
                            </tr>
                            <tr>
                                <td><form:hidden path="buildingNumber"/>
                            </tr>



                            <td><form:label path="owner">Select owner    </form:label> </td>
                            <td><form:select path="owner">
                                <c:forEach items="${appUserList}" var="appUser">
                                    <option value="${appUser.id}" >${appUser.login}</option>
                                </c:forEach>
                            </form:select></td>



                            <tr>
                                <td colspan="2">
                                        <input type="submit" value="add owner"/>
                                </td>
                            </tr>

                        </table>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="scroll">
    <c:if  test="${!empty addressList}">
        <table class="data">
            <tr>
                <th><spring:message code="label.city"/></th>
                <th><spring:message code="label.street"/></th>
                <th>building number</th>
                <th>owner</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${addressList}" var="address">
                <tr>
                    <td>${address.city}</td>
                    <td>${address.street} </td>
                    <td>${address.buildingNumber}</td>
                    <td>${address.owner.login}</td>
                    <td><a href="deleteAddress/${address.id}.html">delete</a></td>
                    <td><a href="buildings.html?addressId=${address.id}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
