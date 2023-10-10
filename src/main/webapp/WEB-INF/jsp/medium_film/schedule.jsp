<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Bilheteria</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <div class="container">
        <h1>${fakeScheduleMediumFilm[0].film.title}</h1>
        <P>Diretor: "${fakeScheduleMediumFilm[0].film.director}"</P>
        <P>Gênero: "${fakeScheduleMediumFilm[0].film.gendersList}"</P>
        <P>Classificação: "${fakeScheduleMediumFilm[0].film.ageRating}" anos</P>
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Sessão</th>
              <th>Preço</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="fs" items="${fakeScheduleMediumFilm}">
              <tr>
                <td>${fs.sessionDate}</td>
                <td>${fs.price}</td>
                <td><a href="/medium-film/${fs.id}/buy">comprar</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </body>

    </html>