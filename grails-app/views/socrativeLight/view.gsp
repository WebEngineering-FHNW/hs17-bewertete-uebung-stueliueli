<html>
    <head>
        <meta name="layout" content="main">
        <title>View</title>
        <script>
            function toggleMark(obj){
                let cb = $(obj).find(':checkbox')[0];
                if(cb.checked){
                    cb.checked = false;
                    obj.classList.remove('isChecked');
                }else{
                    cb.checked = true;
                    obj.classList.add('isChecked')
                }
            }
        </script>
    </head>
    <body>
        <h2>Quiz ${name}</h2>

        <h3>Question: ${question.question}</h3>
        <g:form controller="socrativeLight" action="view">
            <table>
                <thead>
                    <tr>
                        <th>Answer</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${question.answers}">
                        <tr onclick="toggleMark(this)">
                            <td>
                                ${it.answer}
                                <input type="hidden" name="answerId" value="${it.id}" />
                                <input type="checkbox" name="answer${it.id}" hidden/>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <button type="submit" class="btn btn-success" >Save</button>
        </g:form>
    </body>
</html>