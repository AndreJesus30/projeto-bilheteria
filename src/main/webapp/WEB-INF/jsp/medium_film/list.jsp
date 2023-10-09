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
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3>Filmes Média Metragem</h3>
                </div>
                <div class="col-md-8">
                    <h4 class="mt-3 mb-3"><a href="/medium-film/register" class="btn btn-primary">Cadastrar Novo</a></h4>
                </div>
            </div>
               <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Código</th>
                    <th>Título</th>
                    <th>Duração</th>
                    <th>Diretor</th>
                    <th>Gênero</th>
                    <th>Faixa Etária</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="f" items="${mediumList}">
                  <tr>
                    <td>${f.code}</td>
                    <td>${f.title}</td>
                    <td>${f.duration}</td>
                    <td>${f.director}</td>
                    <td>${f.gendersList}</td>
                    <td>${f.ageRating}</td>
                    <td><a href="/medium-film/${f.id}/delete">excluir</a></td>
                  </tr>
                 </c:forEach>
                </tbody>
              </table>
        </div>
    </body>
</html>