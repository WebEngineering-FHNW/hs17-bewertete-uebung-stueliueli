function addAnswer(questionId) {
    let divAnswersFg = document.getElementById(questionId);
    let cloned = document.createElement("div");

let id = divAnswersFg.childElementCount + 1;
cloned.id = 'answer' + id;
let qId = questionId.substr(8);

//note: string templates are supported from ECMAScript 6 onwards.
//IntelliJ may give a warning if the ECMAScript Version is configured wrongly.
//Browser-Support is ok: https://kangax.github.io/compat-table/es6/#template_strings
cloned.innerHTML =
    `<label for="answer${id}-${qId}">Answer: ${id}</label>
        <input type='checkbox' name='checkbox${id}-${qId}' class="form-control form-control-small"/>
        <input type='text' name='answer${id}-${qId}' id="answer${id}-${qId}" class="form-control form-control-wide"/>`;
cloned.classList.add('form-group');

divAnswersFg.appendChild(cloned);
}

function addQuestion(){
    let formGroups = document.getElementById('form-groups');
    let id = formGroups.childElementCount + 1;

    let newFormGroup = document.createElement("div");
    newFormGroup.id = 'formgroup-' + id;

    newFormGroup.innerHTML =
        `Question: <input type="text" name="question-fg${id}" /><br>
         <div id="answers-fg${id}">
            <div id='answer1'>
                Answer 1: <input type='text' name='answer1-fg${id}' />
                <input type="checkbox" name="checkbox1-fg${id}" /><br>
            </div>
            <div id='answer2'>
                Answer 2: <input type='text' name='answer2-fg${id}' />
                <input type="checkbox" name="checkbox2-fg${id}" /><br>
            </div>
         </div>
         <button onclick="addAnswer('answers-fg${id}')" type="button" class="btn btn-default">Add Answer</button> `;
    formGroups.appendChild(newFormGroup);
}