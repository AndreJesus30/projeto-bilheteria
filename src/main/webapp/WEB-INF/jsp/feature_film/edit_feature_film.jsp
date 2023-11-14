<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Editar Longa Metragem</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
      <div class="container mt-3">
        <h2>Editar Longa Metragem</h2>
        <form action="/feature-film/edited_feature" method="post">

          <input type="hidden" name="id" value="${featureFilm.id}">

          <div class="mb-3 mt-3">
            <label for="code">Código:</label>
            <input type="text" class="form-control" id="code" placeholder="Digite o código" value="${featureFilm.code}" name="code">
          </div>

          <div class="mb-3 mt-3">
            <label for="title">Título:</label>
            <input type="text" class="form-control" id="title" placeholder="Digite o título" value="${featureFilm.title}" name="title">
          </div>

          <div class="mb-3 mt-3">
            <label for="duration">Duração:</label>
            <input type="text" class="form-control" id="duration" placeholder="Digite a duração" value="${featureFilm.duration}" name="duration">
          </div>

          <div class="mb-3 mt-3">
            <label for="director">Diretor:</label>
            <input type="text" class="form-control" id="director" placeholder="Digite sua senha" value="${featureFilm.director}" name="director">
          </div>

          <div class="mb-3 mt-3">
            <label for="gendersList">Gêneros:</label>
            <input type="text" class="form-control" id="gendersList" placeholder="Digite os gêneros separados por vírgula" value="${featureFilm.gendersList}" name="gendersList">
          </div>

          <div class="mb-3 mt-3">
            <label for="ageRating">Classificação:</label>
            <input type="text" class="form-control" id="ageRating" placeholder="Digite sua senha" value="${featureFilm.ageRating}" name="ageRating">
          </div>

          <button type="submit" class="btn btn-primary">Editar Filme</button>
        </form>
      </div>
    </body>

    </html>