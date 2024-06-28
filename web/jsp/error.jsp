<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>
<html>
    <body bgcolor="white">

        <c:set var="msg" value="${requestScope.result}" />
        <c:remove var="sessionScope" />

        <h3><c:out value="${msg}" /></h3>

    </body>
</html>