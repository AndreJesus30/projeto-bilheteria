<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

          <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/sobre">BilheteriaApp</a>
                </div>

                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                         <li><a href="/users/list">Info Usuário</a></li>
                         <li><a href="/tickets/list">Tickets</a></li>
                         <li><a href="/short-film/list">Curta Metragem</a></li>
                         <li><a href="/medium-film/list">Media Metragem</a></li>
                         <li><a href="/feature-film/list">Longa Metragem</a></li>
                </ul>


                <ul class="nav navbar-nav navbar-right">
                        <li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login ${user}</a></li>

                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.email}</a></li>
                 </ul>
              </div>
            </nav>