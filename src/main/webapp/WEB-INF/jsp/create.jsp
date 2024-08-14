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
                                            <span>Criar Projeto</span>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 pe-2">
                                    <div class="d-flex justify-content-end">
                                        <div class="d-flex">
                                            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary mx-1">Voltar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card my-2">
                        <div class="card-body">
                            <form class="row g-3">
                                <div class="col-md-6">
                                    <label for="name" class="form-label">Nome</label>
                                    <input type="text" class="form-control" id="name">
                                </div>
                                <div class="col-md-6">
                                    <label for="manager" class="form-label">Gerente responsável</label>
                                    <input type="text" class="form-control" id="manager">
                                </div>
                                <div class="col-md-4">
                                    <label for="start_date" class="form-label">Data de início</label>
                                    <input type="text" class="form-control" id="start_date">
                                </div>
                                <div class="col-md-4">
                                    <label for="expected_end_date" class="form-label">Previsão de término</label>
                                    <input type="text" class="form-control" id="expected_end_date">
                                </div>
                                <div class="col-md-4">
                                    <label for="actual_end_date" class="form-label">Data real de término</label>
                                    <input type="text" class="form-control" id="actual_end_date">
                                </div>
                                <div class="col-md-4">
                                    <label for="budget" class="form-label">Orçamento total</label>
                                    <input type="text" class="form-control" id="budget">
                                </div>
                                <div class="col-md-4">
                                    <label for="classification" class="form-label">Risco</label>
                                    <select id="classification" class="form-control">
                                        <option selected>Selecione a classificação</option>
                                        <option>Risco alto</option>
                                        <option>Risco médio</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="status" class="form-label">Status</label>
                                    <select id="status" class="form-control">
                                        <option selected>Selecione o status</option>
                                        <option>Em análise</option>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label for="description" class="form-label">Descrição</label>
                                    <textarea type="text" class="form-control" id="description"></textarea>
                                </div>
                                <div class="col-md-12 d-flex justify-content-end">
                                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>