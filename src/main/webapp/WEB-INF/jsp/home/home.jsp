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

        <script src="<c:url value="https://code.jquery.com/jquery-3.7.1.min.js" />" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="<c:url value="/static/dist/js/bootstrap.bundle.min.js" />" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('.btn-delete').click(function() {
                    let id = $(this).attr('id');

                    $.ajax({
                        url: '/projects/' + id,
                        method: 'delete',
                        success: function() {
                            location.reload();
                        }
                    });
                });
            });
        </script>
    </head>

    <body>
        <main class="main">
            <div class="container">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <form action="${pageContext.request.contextPath}/" method="get">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="row">
                                            <div class="col-auto">
                                                <span>Projetos</span>
                                            </div>
                                            <div class="col-auto">
                                                <div class="input-group">
                                                    <label for="search" class="d-none">Pesquisar</label>
                                                    <input type="search" id="search" name="search" class="form-control" value="${filter.search}" />
                                                    <button type="submit" class="btn btn-outline-secondary">Pesquisar</button>
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
                                                <select class="form-select mx-1" name="risk" aria-label="Risco">
                                                    <option value="" selected>Risco</option>
                                                    <c:forEach var="risk" items="${risks}">
                                                        <option value="${risk}" ${filter.risk == risk ? 'selected' : ''}>${risk}</option>
                                                    </c:forEach>
                                                </select>
                                                <select class="form-select mx-1" name="status" aria-label="Status">
                                                    <option value="" selected>Status</option>
                                                    <c:forEach var="s" items="${status}">
                                                        <option value="${s}" ${filter.status == s ? 'selected' : ''}>${s}</option>
                                                    </c:forEach>
                                                </select>
                                                <button type="submit" class="btn btn-secondary mx-1">Filtrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Gerente</th>
                                            <th>Data de início</th>
                                            <th>Previsão de término</th>
                                            <th>Orçamento</th>
                                            <th>Descrição</th>
                                            <th>Risco</th>
                                            <th>Status</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="project" items="${projects.content}">
                                            <tr>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/projects/${project.id}/detail">${project.name}</a>
                                                </td>
                                                <td>${project.manager}</td>
                                                <td>${project.startDate}</td>
                                                <td>${project.estimatedEndDate}</td>
                                                <td>${project.budget}</td>
                                                <td>${project.description}</td>
                                                <td>${project.risk}</td>
                                                <td>${project.status}</td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/projects/${project.id}/member">Add</a>
                                                    <a href="${pageContext.request.contextPath}/projects/${project.id}">Alterar</a>
                                                    <a href="#" id="${project.id}" class="btn-delete">Excluir</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <nav aria-label="Paginacao">
                                    <ul class="pagination">
                                        <li class="page-item ${!hasPrevious ? 'disabled' : ''}">
                                            <a href="${pageContext.request.contextPath}/?page=${pageNumber - 1}&search=${filter.search}&risk=${filter.risk}&status=${filter.status}" class="page-link">&laquo;</a>
                                        <li>

                                        <c:forEach var="i" begin="1" end="${(projects.totalPages + 1) - 1}">
                                            <li class="page-item ${pageNumber == i ? 'active' : ''}">
                                                <a href="${pageContext.request.contextPath}/?page=${i}&search=${filter.search}&risk=${filter.risk}&status=${filter.status}" class="page-link">${i}</a>
                                            <li>
                                        </c:forEach>

                                        <li class="page-item ${!hasNext ? 'disabled' : ''}">
                                            <a href="${pageContext.request.contextPath}/?page=${pageNumber + 1}&search=${filter.search}&risk=${filter.risk}&status=${filter.status}" class="page-link">&raquo;</a>
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