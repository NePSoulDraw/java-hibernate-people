<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de personas</title>
    </head>
    
    <body>
        
        <h1>Lista de personas</h1>
        
        <hr/>
        
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
            <c:forEach var="person" items="${people}">
                <tr>
                    <td>${person.personId}</td>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td>${person.email}</td>
                    <td>${person.phone}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
