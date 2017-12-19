<html>
    <head>
        <meta name="layout" content="main">
        <title>View</title>
        <script src="https://unpkg.com/sweetalert2@7.1.1/dist/sweetalert2.all.js" ></script>
        <asset:javascript src="jquery-2.2.0.min.js" />
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

            <g:if test="${qId != 1}">
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
        <h2>Quiz ${name}</h2>

        <h3>Question: ${question.question}</h3>
        <g:form controller="socrativeLight" action="view">
            <input type="hidden" value="${roomId}" name="roomId" />
            <input type="hidden" value="${qId}" name="questionId" />
            <input type="hidden" value="${numCorrect}" name="numCorrect" />
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