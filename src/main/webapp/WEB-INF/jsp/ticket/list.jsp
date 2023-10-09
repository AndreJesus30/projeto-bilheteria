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
         <div class="row">
            <div class="col-md-6">
                <h3>Histórico de Ingressos Comprados</h3>
            </div>
            <div class="col-md-6">
                <h4 class="mt-3 mb-3"><a href="/short-film/register" class="btn btn-primary">Comprar Ingresso</a></h4>
            </div>
        </div>

               <table class="table table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Cliente</th>
                    <th>Sessão</th>
                    <th>Preço</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="t" items="${ticketsList}">
                  <tr>
                    <td>${t.id}</td>
                    <td>${t.film.title}</td>
                    <td>${t.user.name}</td>
                    <td>${t.sessionData}</td>
                    <td>${t.price}</td>
                    <td><a href="/ticket/${t.id}/delete">excluir</a></td>
                  </tr>
                 </c:forEach>
                </tbody>
              </table>
        </div>
    </body>
</html>