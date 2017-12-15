function addAnswer(questionId) {
    var divAnswersFg = document.getElementById(questionId);
    var cloned = divAnswersFg.children[0].cloneNode(true);

    var id = divAnswersFg.childElementCount + 1;
    cloned.id = 'answer' + id;
    cloned.innerHTML = "Answer " + id + ": " +
        "<input type='text' name='answer" + id + "-" + questionId.substr(8) + "' />" +
        "<input type='checkbox' name='checkbox" + id + "-" + questionId.substr(8) + "' />";

    divAnswersFg.appendChild(cloned);
}

function addQuestion(){
    var formGroups = document.getElementById('form-groups');
    var id = formGroups.childElementCount + 1;

    var newFormGroup = formGroups.children[0].cloneNode(true);
    newFormGroup.id = 'formgroup-' + id;
    newFormGroup.innerHTML = "Question: <input type='text' name='question-fg" + id + "' /><br>" +
        "<div id='answers-fg" + id + "'>" +
            "<div id='answer1'>" +
                "Answer 1: <input type='text' name='answer1-fg"+id+"' />" +
                "<input type='checkbox' name='checkbox1-fg"+id+"' /><br> " +
            "</div> " +
        "</div>" +
        "<button onclick=\"addAnswer('answers-fg" + id + "')\" type='button'>Add Answer</button>";
    formGroups.appendChild(newFormGroup);
}