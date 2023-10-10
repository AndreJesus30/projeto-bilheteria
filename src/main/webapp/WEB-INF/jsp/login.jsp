<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title> Pagina JSP Ola Mundo</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body>
            <div class="container mt-3">
                <h2>Login</h2>
                <form action="/valid" method="post">

                    <div class="mb-3 mt-3">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" value="admin@admin.com" placeholder="Digite seu email" name="email">
                    </div>

                    <div class="mb-3 mt-3">
                        <label for="password">Password:</label>
                        <input type="text" class="form-control" id="password" value="123" placeholder="Digite seu password" name="password">
                    </div>

                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
            </div>
        </body>

        </html>