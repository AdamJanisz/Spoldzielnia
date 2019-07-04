<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 27.06.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div class="content">

    <div class="img-circular">
        <div class="content">
            <div class="img-circular1">
                <div class="content">

                    <form:form method="post" action="addAppartment.html" modelAttribute="appartment">
                        <table>
                            <c:if test="${not empty deleteError}">
                                <div class="error">${deleteError}</div>
                            </c:if>
                            <tr>
                                <td><form:hidden path="id"/>
                            </tr>
                            <td><form:label path="appartmentAddress"><spring:message code="label.address" /></form:label> </td>
                            <td><form:select path="appartmentAddress">
                                <c:forEach items="${addressList}" var="address">
                                    <option value="${address.id}" ${address.id == selectedAddress ? 'selected="selected"' : ''}>${address.city}<a>    </a>${address.street}<a>    </a>${address.buildingNumber}</option>
                                </c:forEach>
                            </form:select></td>
                                <%-- <td><form:label path="appUser"><spring:message code="label.appUser" /></form:label> </td>
                                 <td><form:select path="appUser">
                                     <c:forEach items="${appUserList}" var="appUser">
                                         <option value="${appUser.id}">${appUser.login}</option>
                                     </c:forEach>
                                 </form:select></td>--%>
                            <tr>
                                <td><form:label path="appartmentNumber">appartment number</form:label></td>
                                <td><form:input path="appartmentNumber" /></td>
                            </tr>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="add Appartment"/>
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
    <c:if  test="${!empty appartmentList}">
        <table class="data">
            <tr>
                <th>appartment No.</th>
                <th>city</th>
                <th>street</th>
                <th></th>
                <th></th>

            </tr>
            <c:forEach items="${appartmentList}" var="appartment">
                <tr>
                    <td>${appartment.appartmentNumber} </td>
                    <td>${appartment.appartmentAddress.city} </td>
                    <td>${appartment.appartmentAddress.street} </td>
                    <td><a href="deleteAppartment/${appartment.id}.html">delete</a></td>
                    <td><a href="safeDeleteAppartment/${appartment.id}.html">safe removal</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>
</html>
