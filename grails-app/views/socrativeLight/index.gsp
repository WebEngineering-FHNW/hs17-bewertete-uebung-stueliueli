<html>
    <head>
        <meta name="layout" content="main">
    </head>
    <body>
        <g:form controller="socrativeLight" action="view">
            <input type="text" name="roomName" />
            <input type="submit" name="submit" />
        </g:form>

        <g:link controller="socrativeLight" action="create">
            Create your own questionaire!
        </g:link>
    </body>
</html>