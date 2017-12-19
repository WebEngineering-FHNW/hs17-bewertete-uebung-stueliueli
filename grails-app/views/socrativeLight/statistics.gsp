<%@ page import="java.math.RoundingMode" %>
<html>
    <head>
        <meta name="layout" content="main" />
        <script>
            //enables tooltips, from https://www.w3schools.com/bootstrap/bootstrap_tooltip.asp
            $(document).ready(function(){
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <h1>Statistics for questionnaire ${room.name}</h1>
        <g:each var="q" in="${room.questions}">
            <h3>${q.question}</h3>
            <table>
                <thead>
                    <tr>
                        <th>Answer</th>
                        <th>Times chosen</th>
                        <th>Percent</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each var="ans" in="${q.answers}">
                        <tr>
                            <td>${ans.answer}</td>
                            <td>${ans.numChosen}</td>
                            <td><progress value="${ans.numChosen}" max="${q.getSumChosen()}" data-toggle="tooltip" title="${ans.numChosen}/${q.getSumChosen()}"></progress> </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:each>
    </body>
</html>