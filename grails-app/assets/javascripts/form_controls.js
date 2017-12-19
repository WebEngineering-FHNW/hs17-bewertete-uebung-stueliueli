function addAnswer(questionId) {
    let divAnswersFg = document.getElementById(questionId);
    let cloned = document.createElement("tr");

let id = divAnswersFg.childElementCount + 1;
cloned.id = 'answer' + id;
let qId = questionId.substr(8);

//note: string templates are supported from ECMAScript 6 onwards.
//IntelliJ may give an error if the ECMAScript Version is configured wrongly.
// reconfigure it in intelliJ Settings -> Languages -> JavaScript
//Browser-Support is ok: https://kangax.github.io/compat-table/es6/#template_strings
cloned.innerHTML =
    `<td style="text-align: right; vertical-align: middle"><b>Answer ${id}:</b></td>
     <td><input type="text" name="answer${id}-${qId}" class="form-control" /></td>
     <td><input type="checkbox" name="checkbox${id}-${qId}" /></td>`;

divAnswersFg.appendChild(cloned);
}

function addQuestion(){
    let formGroups = document.getElementById('form-groups');
    let id = formGroups.childElementCount + 1;

    let newFormGroup = document.createElement("div");
    newFormGroup.id = 'formgroup-' + id;

    newFormGroup.innerHTML =
        `<hr />
         <div style="margin-bottom: 8px">
            <label for="questionName${id}">Question:</label><input id="questionName${id}" type="text" name="question-fg${id}" class="form-control" />
            <table>
                <thead>
                    <tr>
                        <th style="width: 10%"></th>
                        <th>Answer</th>
                        <th>Correct answer?</th>
                    </tr>
                </thead>
                <tbody id="answers-fg${id}">
                    <tr>
                        <td style="text-align: right; vertical-align: middle"><b>Answer 1:</b></td>
                        <td><input type="text" name="answer1-fg${id}" class="form-control" /></td>
                        <td><input type="checkbox" name="checkbox1-fg${id}" /></td>
                    </tr>
                    <tr>
                        <td style="text-align: right; vertical-align: middle"><b>Answer 2:</b></td>
                        <td><input type="text" name="answer2-fg${id}" class="form-control" /></td>
                        <td><input type="checkbox" name="checkbox2-fg${id}" /></td>
                    </tr>
                </tbody>
            </table>
            <button onclick="addAnswer('answers-fg${id}')" type="button" class="btn btn-default">Add Answer</button>
        </div>
        `;
    formGroups.appendChild(newFormGroup);
}