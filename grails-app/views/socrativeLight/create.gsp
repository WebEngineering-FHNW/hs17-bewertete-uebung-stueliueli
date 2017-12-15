<html>
    <head>
        <meta name="layout" content="main" />
        <asset:javascript src="form_controls.js"/>
    </head>
    <body>
        <g:form controller="socrativeLight" action="save">
            Name: <input type="text" name="name" /><br><br>
            <div id="form-groups">
                <div id="formgroup-1" class="form-group">
                    Question: <input type="text" name="question-fg1" /><br>
                    <div id="answers-fg1">
                        <div id="answer1">
                            Answer 1: <input type="text" name="answer1-fg1" /><input type="checkbox" name="checkbox1-fg1" /><br>
                        </div>
                    </div>
                    <button onclick="addAnswer('answers-fg1')" type="button">Add Answer</button>
                </div>
            </div>
            <button onclick="addQuestion()" type="button">Add Question</button>
        </g:form>
    </body>
</html>