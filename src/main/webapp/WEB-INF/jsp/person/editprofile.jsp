<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Редактирование профиля</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
<!--   http://localhost:8080/addprofile/0  -->
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.2.min.js"></script>


    <script type="text/javascript">

        // bind the on-change event for the input element (triggered when a file
        // is chosen)
        $(document).ready(function() {
            $("#upload-file-input").on("change", uploadFileOnServer);
        });

        /**
         * Upload the file sending it via Ajax at the Spring Boot server.
         */
        function uploadFileOnServer() {
            $.ajax({
                url: "/uploadFile",
                type: "POST",
                data: new FormData($("#upload-file-form")[0]),
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                cache: false,
                success: function () {
                    // Handle upload success
                    $("#upload-file-message").text("File succesfully uploaded");
                },
                error: function () {
                    // Handle upload error
                    $("#upload-file-message").text(
                            "File not uploaded (perhaps it's too much big)");
                }
            });
        } // function uploadFile
    </script>

    <script type="text/javascript">
        function crunchifyAjax() {
            $.ajax({
                url : '/ajaxtest',
                success : function(data) {
                    $('#result').html(data);
                }
            });
        }
    </script>

</head>

<body>

<div align="center">

    <div id="result"></div>

</div>

<form id="upload-file-form" class="form-signin">
    <h2 class="form-signin-heading">Ваши персональные данные</h2>
    <label for="upload-file-input">Выберите вашу фотографию:</label>
    <input id="upload-file-input" type="file" name="uploadfile" accept="*" />
</form>

<%--
<div class="container">

    <form id="upload-file-form" class="form-signin">
        <h2 class="form-signin-heading">Ваши персональные данные</h2>
        <label for="upload-file-input">Выберите вашу фотографию:</label>
        <input id="upload-file-input" type="file" name="uploadfile" accept="*" />
    </form>

    <form:form method="POST" modelAttribute="userProfile" class="form-signin">
        &lt;%&ndash;<h2 class="form-signin-heading">Ваши персональные данные</h2>&ndash;%&gt;
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="middleName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="middleName" class="form-control" placeholder="Отчество"
                            autofocus="true"></form:input>
                <form:errors path="middleName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    </form:form>

</div>

<c:if test="${savefailed != null}">
    <div class="form-signin-error">
        <h2 class="has-error">${savefailed}</h2>
    </div>
</c:if>

<!-- /container -->




--%>
</body>
</html>