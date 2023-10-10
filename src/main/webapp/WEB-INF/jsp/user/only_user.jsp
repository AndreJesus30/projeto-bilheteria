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
          <h3>Informações de Usuário</h3>

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
              <tr>
                <td>${onlyUser.id}</td>
                <td>${onlyUser.name}</td>
                <td>${onlyUser.email}</td>
                <td>${onlyUser.password}</td>
                <td><a href="/user/${onlyUser.id}/delete">excluir</a></td>
              </tr>
            </tbody>
          </table>
        </div>
      </body>

      </html>