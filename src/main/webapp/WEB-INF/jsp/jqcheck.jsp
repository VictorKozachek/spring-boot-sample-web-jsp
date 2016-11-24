<%--
  Created by IntelliJ IDEA.
  User: victor
  Date: 23.11.16
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>jQuery File Upload Example</title>
</head>
<body>
<div>
    <input id="file1" type="file" name="file1" class="file">
</div>
<div>
    <input id="file2" type="file" name="file2" class="file">
</div>
<div>
    <input id="file3" type="file" name="file3" class="file">
</div>

<form>

    <input id="fileupload" type="file" name="files[]" hidden="hidden">

    <input type="button" value="Send" class="button">

</form>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="/resources/js/jquery.iframe-transport.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>
<script>
    $(function () {

        $('.button').click(function() {
            $('#fileupload').fileupload('send', {
                fileInput: $('.file')
            });
        });

        $('#fileupload').fileupload({
            url: 'file-upload',
            dataType: 'json'
        });
    });
</script>
</body>
</html>