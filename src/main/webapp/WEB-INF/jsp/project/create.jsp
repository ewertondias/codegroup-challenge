<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />

        <title>Code Group Challenge</title>

        <link href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/static/dist/css/custom.css" />" rel="stylesheet">

        <link href="https://fonts.googleapis.com" rel="preconnect">
        <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">

        <link href="<c:url value="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css" />" rel="stylesheet">

        <script src="<c:url value="https://code.jquery.com/jquery-3.7.1.min.js" />" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" />" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="<c:url value="https://cdn.jsdelivr.net/npm/flatpickr" />"></script>
        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/autonumeric/4.8.1/autoNumeric.min.js" />"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                loadFlatPickrCalendar();
                loadAutoNumeric();
                createNewProjectValidateFields();
                updateProject();
            });

            function loadFlatPickrCalendar() {
                $(".selector").flatpickr({
                    dateFormat: "d/m/Y"
                });
            }

            function loadAutoNumeric() {
                new AutoNumeric('#budget', {
                    currencySymbol: 'R$ ',
                    decimalCharacter: ',',
                    digitGroupSeparator: '.',
                    currencySymbolPlacement: 'p',
                    roundingMethod: 'U',
                    decimalPlaces: 2
                });
            }

            function createNewProjectValidateFields() {
                $('#new-project').on('submit', function(event) {
                    let formattedValue = AutoNumeric.getNumber('#budget');

                    $('#budget').val(formattedValue);

                    let risk = $('#risk');
                    if (risk.val() === "") {
                        risk.addClass('is-invalid');

                        event.preventDefault();
                    }

                    let status = $('#status');
                    if (status.val() === "") {
                        status.addClass('is-invalid');

                        event.preventDefault();
                    }
                });
            }

            function updateProject() {
                $('.btn-update').click(function() {
                    let id = $(this).attr('id');

                    let name = $('#name').val();
                    let manager = $('#manager').val();
                    let startDate = $('#start_date').val();
                    let estimatedEndDate = $('#estimated_end_date').val();
                    let actualEndDate = $('#actual_end_date').val();
                    let budget = AutoNumeric.getNumber('#budget');
                    let risk = $('#risk').val();
                    let status = $('#status').val();
                    let description = $('#description').val();

                    let data = {
                        name: name,
                        manager: manager,
                        startDate: startDate,
                        estimatedEndDate: estimatedEndDate,
                        actualEndDate: actualEndDate,
                        budget: budget,
                        risk: risk,
                        status: status,
                        description: description
                    };

                    $.ajax({
                        url: '/projects/' + id,
                        method: 'put',
                        data: data,
                        success: function() {
                            window.location = '/';
                        }
                    });
                });
            }
        </script>
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
                                            <h6 class="title my-0 py-2">${project.id == null ? 'Criar Projeto' : 'Alterar Projeto'}</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card my-2">
                        <div class="card-body">
                            <form id="new-project" action="${project.id == null ? '/projects/create' : '/projects/'}<c:out value='${project.id}' />" method="post" class="row g-3">
                                <div class="col-md-6">
                                    <label for="name" class="form-label">Nome</label>
                                    <input type="text" id="name" name="name" class="form-control ${empty errors['name'] ? '' : 'is-invalid'}" value="${project.name}" placeholder="Nome">
                                    <div class="invalid-feedback">
                                        ${errors['name']}
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <label for="manager" class="form-label">Gerente responsável</label>
                                    <input type="text" id="manager" name="manager" class="form-control ${empty errors['manager'] ? '' : 'is-invalid'}" value="${project.manager}" placeholder="Gerente responsável">
                                    <div class="invalid-feedback">
                                        ${errors['manager']}
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="start_date" class="form-label">Data de início</label>
                                    <input type="text" id="start_date" name="startDate" class="form-control selector" value="${project.startDate}" placeholder="Data de início">
                                </div>
                                <div class="col-md-4">
                                    <label for="estimated_end_date" class="form-label">Previsão de término</label>
                                    <input type="text" id="estimated_end_date" name="estimatedEndDate" class="form-control selector" value="${project.estimatedEndDate}" placeholder="Previsão de término">
                                </div>
                                <div class="col-md-4">
                                    <label for="actual_end_date" class="form-label">Data real de término</label>
                                    <input type="text" id="actual_end_date" name="actualEndDate" class="form-control selector" value="${project.actualEndDate}" placeholder="Data real de término">
                                </div>
                                <div class="col-md-4">
                                    <label for="budget" class="form-label">Orçamento total</label>
                                    <input type="text" id="budget" name="budget" class="form-control" value="${project.budget}" placeholder="Orçamento total">
                                </div>
                                <div class="col-md-4">
                                    <label for="risk" class="form-label">Risco</label>
                                    <select id="risk" name="risk" class="form-control ${empty errors['risk'] ? '' : 'is-invalid'}">
                                        <option selected value="">Selecione o risco</option>
                                        <c:forEach var="risk" items="${risks}">
                                            <option value="${risk}" ${risk == project.risk ? 'selected' : ''}>${risk}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="invalid-feedback">
                                        ${errors['risk']}
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="status" class="form-label">Status</label>
                                    <select id="status" name="status" class="form-control ${empty errors['status'] ? '' : 'is-invalid'}">
                                        <option selected value="">Selecione o status</option>
                                        <c:forEach var="s" items="${status}">
                                            <option value="${s}" ${s == project.status ? 'selected' : ''}>${s}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="invalid-feedback">
                                        ${errors['status']}
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <label for="description" class="form-label">Descrição</label>
                                    <textarea type="text" id="description" name="description" class="form-control ${empty errors['description'] ? '' : 'is-invalid'}" placeholder="Descrição">${project.description}</textarea>
                                    <div class="invalid-feedback">
                                        ${errors['description']}
                                    </div>
                                </div>
                                <div class="col-md-12 d-flex justify-content-end">
                                    <c:if test="${project.id == null}">
                                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                                    </c:if>

                                    <c:if test="${project.id != null}">
                                        <button type="button" id="${project.id}" class="btn btn-primary btn-update">Alterar</button>
                                    </c:if>
                                    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary mx-1">Voltar</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>