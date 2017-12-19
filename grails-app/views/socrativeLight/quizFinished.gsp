<html>
    <head>
        <meta name="layout" content="main">
        <asset:javascript src="jquery-2.2.0.min.js"/>
        <script src="https://unpkg.com/sweetalert2@7.1.1/dist/sweetalert2.all.js" ></script>
        <script>
            <g:if test="${lastCorrect != null}">
            $(document).ready(function(){
                <g:if test="${lastCorrect}">
                swal("Correct!",
                    "All your answers were correct!",
                    "success");
                </g:if>
                <g:else>
                swal("Wrong",
                    "Some or all of your answers were wrong!",
                    "error");
                </g:else>
            });
            </g:if>
        </script>
    </head>
    <body>
        <div style="padding: 2%;">
            <h1>You're done!</h1>
            <p>Your score: ${numCorrect}/${numQuestions}</p>
            <p>You may now return to the <g:link controller="socrativeLight" action="index">starting page</g:link></p>
            <p>You may also check the <g:link controller="socrativeLight" action="statistics" params="[roomId:roomId]">statistics</g:link> for this questionnaire.</p>
        </div>
    </body>
</html>