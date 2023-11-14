<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="utf-8">
        <title>Bilheteria</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      </head>

      <body>
        <c:import url="/WEB-INF/jsp/menu.jsp" />
        <div class="container mt-3">
          <div class="row">
            <div class="col-md-4">
              <h3>Informações de Usuário</h3>
            </div>
            <div class="col-md-8">
              <c:if test="${currentUser.name eq 'Administrador'}">
                <h4 class="mt-3 mb-3"><a href="/user/register" class="btn btn-primary">Cadastrar Novo</a></h4>
              </c:if>
            </div>
          </div>

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
                  <td><a href="/user/${u.id}/delete">excluir</a></td>
                  <td><a href="/user/${u.id}/edit">editar</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </body>

      </html>