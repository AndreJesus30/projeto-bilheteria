<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bilheteria</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link  rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
    <c:import url="/WEB-INF/jsp/menu.jsp"/>
        <div class="container mt-3">
        <h3>Histórico de Ingressos Comprados</h3>
        <h4><a href="#">Comprar Ingresso</a></h4>

               <table class="table table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="u" items="${usersList}">
                  <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.email}</td>
                    <td>${u.password}</td>
                    <td><a href="/user/${s.id}/delete">excluir</a></td>
                  </tr>
                 </c:forEach>
                </tbody>
              </table>
        </div>
    </body>
</html>