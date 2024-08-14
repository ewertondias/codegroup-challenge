<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />

        <title>Code Group Challenge</title>

        <link href="<c:url value="/static/dist/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/static/dist/css/custom.css" />" rel="stylesheet">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">

        <script src="<c:url value="/static/dist/js/bootstrap.bundle.min.js" />" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>

    <body>
        <main class="main">
            <div class="container">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-6">
                                    <div class="row">
                                        <div class="col-auto">
                                            <span>Projetos</span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="input-group">
                                                <input type="search" class="form-control"/>
                                                <button type="button" class="btn btn-outline-secondary">Pesquisar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 pe-2">
                                    <div class="d-flex justify-content-end">
                                        <div class="d-flex">
                                            <a href="${pageContext.request.contextPath}/projects/create" class="btn btn-secondary mx-1">Novo</a>
                                        </div>
                                        <div class="d-flex">
                                            <select class="form-select mx-1" aria-label="Risco">
                                                <option selected>Risco</option>
                                                <option value="1">Baixo</option>
                                                <option value="2">Médio</option>
                                                <option value="3">Alto</option>
                                            </select>
                                            <select class="form-select mx-1" aria-label="Status">
                                                <option selected>Status</option>
                                                <option value="1">Em análise</option>
                                                <option value="2">Iniciado</option>
                                                <option value="3">Encerrado</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Data de início</th>
                                            <th>Gerente</th>
                                            <th>Previsão de término</th>
                                            <th>Status</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <a href="#">Code Group</a>
                                            </td>
                                            <td>14/08/2024</td>
                                            <td>Ewerton Dias</td>
                                            <td>20/08/2024</td>
                                            <td>Iniciado</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/projects/member">ME</a>
                                                <a href="#">B</a>
                                                <a href="#">C</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">Code Group</a>
                                            </td>
                                            <td>14/08/2024</td>
                                            <td>Ewerton Dias</td>
                                            <td>20/08/2024</td>
                                            <td>Iniciado</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/projects/member">ME</a>
                                                <a href="#">B</a>
                                                <a href="#">C</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <nav aria-label="Paginacao">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <a href="#" class="page-link">Anterior</a>
                                        <li>
                                        <li class="page-item">
                                            <a href="#" class="page-link">1</a>
                                        <li>
                                        <li class="page-item">
                                            <a href="#" class="page-link">2</a>
                                        <li>
                                        <li class="page-item">
                                            <a href="#" class="page-link">3</a>
                                        <li>
                                        <li class="page-item">
                                            <a href="#" class="page-link">Próximo</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>