<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

</head>
<body>
<div class="content">

    <div class="img-circular">
        <div class="content">
            <div class="img-circular1">
                <div class="content">

                    <form:form method="post" action="addBuilding.html" modelAttribute="address">
                        <table>
                            <tr>
                                <td><form:hidden path="id"/>
                            </tr>
                            <sec:authorize access="hasRole('ADMIN')">
                            <tr>
                                <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
                                <td><form:input path="city" /></td>
                                <td><form:errors path="city"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
                                <td><form:input path="street" /></td>
                                <td><form:errors path="street"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="buildingNumber">building number</form:label></td>
                                <td><form:input path="buildingNumber" /></td>
                                <td><form:errors path="buildingNumber"/></td>
                            </tr>
                            </sec:authorize>
                            <tr>
                                <td><form:label path="coldWaterPrice"> cold water price</form:label></td>
                                <td><form:input path="coldWaterPrice" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="hotWaterPrice">hot water price</form:label></td>
                                <td><form:input path="hotWaterPrice" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="electricityPrice">electricity price</form:label></td>
                                <td><form:input path="electricityPrice" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="sewagePrice">sewage fee</form:label></td>
                                <td><form:input path="sewagePrice" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="repairFundPrice">repair fund fee</form:label></td>
                                <td><form:input path="repairFundPrice" /></td>
                            </tr>


                            <tr>
                                <td colspan="2">
                                    <c:if test="${address.id==0}">
                                        <input type="submit" value="<spring:message code="label.addBuilding"/>"/>
                                    </c:if>
                                    <c:if test="${address.id!=0}">
                                        <input type="submit" value="edytuj"/>
                                    </c:if>
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
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${addressList}" var="address">
                <tr>
                    <td>${address.city}</td>
                    <td>${address.street} </td>
                    <td>${address.buildingNumber}</td>
                    <td><a href="buildings.html?addressId=${address.id}">edit</a></td>
                    <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="deleteAddress/${address.id}.html">delete</a></td>
                    <td><a href="buildingsManager.html?addressId=${address.id}">add owner</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>

