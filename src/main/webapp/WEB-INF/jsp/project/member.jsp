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
        <link href="<c:url value="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" />" rel="stylesheet" />

        <script src="<c:url value="https://code.jquery.com/jquery-3.7.1.min.js" />" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" />" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="<c:url value="https://cdn.jsdelivr.net/npm/flatpickr" />"></script>
        <script src="<c:url value="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js" />"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                loadEMployeesMembers();
                addMember();
            });

            function loadEMployeesMembers() {
                $.ajax({
                    url: '/members/employees',
                    method: 'get',
                    success: function(response) {
                        let members = response.map(function(member) {
                            return {
                                id: member.id,
                                text: member.name
                            }
                        });

                        $('.select-member').select2({
                            data: members
                        });
                    }
                });
            }

            function addMember() {
                $('.btn-add-member').click(function() {
                    let projectId = $(this).attr('id');
                    let memberId = $('.select-member').val();

                    $.ajax({
                        url: '/projects/' + projectId + '/member/' + memberId,
                        method: 'put',
                        success: function() {
                            location.reload();
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
                                            <h6 class="title">Adicionar Membro</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="d-flex justify-content-end">
                                        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary mx-1">Voltar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card my-2">
                        <div class="card-body">
                            <form class="row g-3">
                                <div class="col-md-12">
                                    <h6>${project.name}</h6>
                                    <p>
                                        ${project.description}
                                    </p>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="card my-2">
                        <div class="card-body">
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-11">
                                        <label for="member" class="d-none">Membros</label>
                                        <select id="member" class="form-select select-member"></select>
                                    </div>
                                    <div class="col-1">
                                        <button type="submit" id="${project.id}" class="btn btn-primary btn-sm btn-add-member">Adicionar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <h6 class="title">Membros</h6>
                        </div>
                        <div class="table-responsive">
                            <ul class="list-group">
                                <c:forEach var="member" items="${project.members}">
                                    <li class="list-group-item list-group-item-action">${member.name}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>