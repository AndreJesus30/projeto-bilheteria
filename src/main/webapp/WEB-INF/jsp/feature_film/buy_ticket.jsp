<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title> Pagina JSP Ola Mundo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
       <div class="container mt-3">
         <h2>Cadastro de Longa Metragem</h2>
         <form action="/short-film/add" method="post">

          <div class="mb-3 mt-3">
            <label for="code">Código:</label>
            <input type="text" class="form-control" id="code" placeholder="Digite o código" name="code">
          </div>

           <div class="mb-3 mt-3">
             <label for="title">Título:</label>
             <input type="text" class="form-control" id="title" placeholder="Digite o título" name="title">
           </div>

          <div class="mb-3 mt-3">
            <label for="duration">Duração:</label>
            <input type="text" class="form-control" id="duration" placeholder="Digite a duração" name="duration">
          </div>

            <div class="mb-3 mt-3">
             <label for="director">Diretor:</label>
             <input type="text" class="form-control" id="director" placeholder="Digite sua senha" name="director">
           </div>

            <div class="mb-3 mt-3">
             <label for="gendersList">Gêneros:</label>
             <input type="text" class="form-control" id="gendersList" placeholder="Digite os gêneros separados por vírgula" name="gendersList">
           </div>

           <div class="mb-3 mt-3">
             <label for="ageRating">Classificação:</label>
             <input type="text" class="form-control" id="ageRating" placeholder="Digite sua senha" name="ageRating">
           </div>

           <button type="submit" class="btn btn-primary">Cadastrar</button>
         </form>
       </div>
    </body>
</html>

