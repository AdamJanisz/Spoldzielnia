<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 30.06.2019
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div class="content">

    <div class="img-circular">
        <div class="content">
            <div class="img-circular1">
                <div class="content">
<c:if  test="${bill.id>0}">
                    <form:form method="post" action="editBill.html" modelAttribute="bill">
                        <table>
                            <tr>
                                <td><form:hidden path="id"/>
                            </tr>
                            <tr>
                                <td><form:label path="electricity"><spring:message code="label.city"/></form:label></td>
                                <td><form:input path="electricity" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="hotWater"><spring:message code="label.street"/></form:label></td>
                                <td><form:input path="hotWater" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="coldWater"><spring:message code="label.telephone"/></form:label></td>
                                <td><form:input path="coldWater" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="sewage"><spring:message code="label.telephone"/></form:label></td>
                                <td><form:input path="sewage" /></td>
                            </tr>
                            <tr>
                                <input type="hidden" name="date" value="${serverTime}">
                            </tr>
                            <tr>
                                <td><form:label path="repairFund"><spring:message code="label.telephone"/></form:label></td>
                                <td><form:input path="repairFund" /></td>
                            </tr>
                            <c:if test="${currentUser.id!=0}">
                                <tr>
                                        <input type="hidden" id="appUser" name="appUser" value="${currentUser.id}">
                                </tr>
                            </c:if>
                        <%--<td><form:label path="appUser"><spring:message code="label.address" /></form:label> </td>
                      <td><form:select path="appUser">
                            <c:forEach items="${appUserList}" var="appUser">
                                <option value="${appUser.id}" }>${appUser.login}<a>    </a>${appUser.id}</option>
                            </c:forEach>
                        </form:select></td>--%>

                        <tr>
                            <td colspan="2">
                                <input type="submit" value="edit"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
</c:if>

            </div>
        </div>
    </div>
</div>
</div>

<div class="scroll">
<c:if  test="${!empty userBillsList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.city"/></th>
            <th><spring:message code="label.city"/></th>
            <th><spring:message code="label.street"/></th>
            <th><spring:message code="label.city"/></th>
            <th><spring:message code="label.street"/></th>
            <th><spring:message code="label.city"/></th>
            <th><spring:message code="label.street"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${userBillsList}" var="bill">
            <tr>
                <td>${bill.date}</td>
                <td>${bill.electricity}</td>
                <td>${bill.coldWater} </td>
                <td>${bill.hotWater}</td>
                <td>${bill.sewage}</td>
                <td>${bill.totalAmount} </td>
                <td><a href="bills.html?billsId=${bill.id}">edit</a></td>
                <td><a href="generatePdf-${bill.id}">pdf</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</div>
</body>
</html>

