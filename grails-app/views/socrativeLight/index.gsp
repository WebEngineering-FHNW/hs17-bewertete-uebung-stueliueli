<html>
    <head>
        <meta name="layout" content="main">
        <asset:javascript src="jquery-2.2.0.min.js"/>
        <script>
            function testCall(){
                $.get("/api/getStuff", function(data){
                    console.error(JSON.stringify(data));
                })
            }
        </script>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Quizname</th>
                    <th>Number of questions</th>
                    <th>Start</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${rooms}">
                    <tr>
                        <td>${it.name}</td>
                        <td>${it.questions.size()}</td>
                        <td><g:link controller="socrativeLight" action="view" params="[roomId:it.id, questionId:0]">Start</g:link></td>
                    </tr>
                </g:each>
            </tbody>
        </table>

        <g:link controller="socrativeLight" action="create" class="btn btn-danger" style="text-decoration: none; margin-top: 2em">
            Create your own questionaire!
        </g:link>
    </body>
</html>