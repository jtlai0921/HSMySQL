<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HS 員工簽到表</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">

    </head>
    <body style="padding: 50px">
    <center>
        <h1>HS 員工簽到表</h1>

        <table>
            <tr>
                <td valign="top" style="padding: 30px">
                    <video id="player" width="320" height="240" controls autoplay></video>
                </td>
                <td valign="top" style="padding: 30px">
                    <form:form id="signInForm" class="pure-form" modelAttribute="clockOn" method="post" action="${pageContext.servletContext.contextPath}/mvc/clock_on/in">
                        <fieldset>
                            <legend>簽到時段</legend>
                            <form:radiobuttons path="statusId" 
                                               items="${list_status}" 
                                               itemLabel="statusName" 
                                               itemValue="statusId"
                                               element="span style='padding: 5px'/"/>
                            <p />
                            <legend>員工編號</legend>
                            <form:input path="empNo" placeholder="請輸入員工編號" /><p />
                            <form:hidden path="image" />
                            <button id="signInBtn" type="button" class="pure-button pure-button-primary">Sign in</button>
                        </fieldset>
                    </form:form>
                </td>
            </tr>
            <tr>
                <td colspan="2">

            <legend><h2 class="content-subhead">${empName}</h2></legend>
            <table class="pure-table pure-table-bordered" width="100%">
                <thead>
                    <tr>
                        <th>ID序號</th>
                        <th>員工編號</th>
                        <th>簽到時段</th>
                        <th>簽到時間</th>
                        <th width="200">簽到影像</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="item" items="${list_clockon}">
                        <tr>
                            <td>${item.clockId}</td>
                            <td>${item.empNo}</td>
                            <td>${item.statusId}</td>
                            <td>${item.clockOn}</td>
                            <td><img src="${item.image}" width="50" onclick="this.style.width = '200px'" ondblclick="this.style.width = '50px'"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> 

            </td>
            </tr>

        </table>
    </center>
    <button id="capture" style="visibility: hidden">Capture</button>
    <canvas id="snapshot" style="visibility: hidden" width="320" height="240"></canvas>

    <script>
        var player = document.getElementById('player');
        var captureButton = document.getElementById('capture');
        var snapshotCanvas = document.getElementById('snapshot');
        var signInBtn = document.getElementById('signInBtn');

        var handleSuccess = function (stream) {
            // Attach the video stream to the video element and autoplay.
            player.srcObject = stream;
        };

        captureButton.addEventListener('click', function () {
            var context = snapshot.getContext('2d');
            // Draw the video frame to the canvas.
            context.drawImage(player, 0, 0, snapshotCanvas.width,
                    snapshotCanvas.height);
            var base64 = snapshotCanvas.toDataURL();
            console.log(base64);
            document.getElementById("image").value = base64;
        });

        signInBtn.addEventListener('click', function () {
            var context = snapshot.getContext('2d');
            // Draw the video frame to the canvas.
            context.drawImage(player, 0, 0, snapshotCanvas.width,
                    snapshotCanvas.height);
            var base64 = snapshotCanvas.toDataURL();
            console.log(base64);
            document.getElementById("image").value = base64;
            document.getElementById("signInForm").submit();
        });

        navigator.mediaDevices.getUserMedia({video: true})
                .then(handleSuccess);
    </script>
</body>
</html>
