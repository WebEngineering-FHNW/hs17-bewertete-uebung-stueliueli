<html>
    <head>
        <title>View</title>
    </head>
    <body>
        <g:each in="${room.questions}">
            ${it.question}
        </g:each>
    </body>
</html>