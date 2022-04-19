<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Email</th>
            <th scope="col">Número</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="person" items="${people}">
            <tr>
                <td>${person.personId}</td>
                <td>${person.name}</td>
                <td>${person.surname}</td>
                <td>${person.email}</td>
                <td>${person.phone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/ServletController?action=edit&personId=${person.personId}" 
                       type="button" class="btn btn-secondary">
                        Editar
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page="/WEB-INF/components/people/createPerson.jsp" />