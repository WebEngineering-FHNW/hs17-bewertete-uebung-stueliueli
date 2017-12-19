<html>
    <head>
        <meta name="layout" content="main" />
        <asset:javascript src="jquery-2.2.0.min.js" />
        <asset:javascript src="form_controls.js"/>
        <asset:stylesheet src="own.css" />
        <script>
            $(document).ready(function () {
                addQuestion();
            })
        </script>
    </head>
    <body>
        <div class="content">
            <g:form controller="socrativeLight" action="save" class="form-inline">
                <div class="form-group">
                    <label for="nameInput">Name:</label><input class="form-control form-control-small" type="text" name="name" id="nameInput"/>
                </div>
                <hr>
                <div id="form-groups"></div>
                <button onclick="addQuestion()" type="button" class="btn btn-default">Add Question</button>
                <button type="submit" name="submit" class="btn btn-success">Save</button>
            </g:form>
        </div>
    </body>
</html>