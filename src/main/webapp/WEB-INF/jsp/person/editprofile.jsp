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
    <script type="text/javascript" src="/resources/js/form2js.js"></script>




</head>

<body>

<div align="center">

    <div id="result"></div>

</div>



<div class="container">

    <div class="form-signin" id="avatar-upload">
        <div class="text">Выберите аватар</div>
        <label for="avatar">
            <img src="http://www.ukm.my/portal/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png" id="imgupload">
        </label>
        <div class="upload">
            <input type="file" name="avatar" id="avatar">
        </div>
    </div>

    <form:form id="profileForm" name="profile" method="POST" modelAttribute="userProfile" class="form-signin" action="/addprofile">
        <!--<h2 class="form-signin-heading">Ваши персональные данные</h2>-->
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                            ></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="middleName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="middleName" class="form-control" placeholder="Отчество"
                           ></form:input>
                <form:errors path="middleName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
                            ></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit" id="save-button">Сохранить</button>
    </form:form>

</div>

<c:if test="${savefailed != null}">
    <div class="form-signin-error">
        <h2 class="has-error">${savefailed}</h2>
    </div>
</c:if>

<!-- /container -->

<script type="text/javascript" >
    function readFile() {
        if (this.files && this.files[0]) {
            var FR= new FileReader();
            FR.onload = function(e) {
                document.getElementById("imgupload").src = e.target.result;
                document.getElementById("imgupload").style.width = "150px";

            };
            FR.readAsDataURL( this.files[0] );
        }
    }

    document.getElementById("avatar").addEventListener("change", readFile, false);
</script>




</body>
</html>