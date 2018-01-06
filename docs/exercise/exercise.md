# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 16-660-805

Project idea short description: Socrative Light, as described in [here](https://github.com/WebEngineering-FHNW/hs17-bewertete-uebung-stueliueli/blob/master/docs/exercise/socrative-light.md)


## Project confirmation

confirmed.


## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)
>Note: Usage of modern browsers required. This application uses ECMAScript Version 6, which is supported in all modern browsers (but not for example in MS Internet Explorer).

How to test the project:  `grailsw test-app`

Project description: to be found under index -> "Description of the project" or directly at `/socrativeLight/description`

External contributions: Thanks to [w3schools.com](https://www.w3schools.com), which helped me quite a lot (links in code). Other external contributions:
- [SweetAlert](https://limonte.github.io/sweetalert2/)
- [Twitter Bootstrap](https://getbootstrap.com/)
- [jQuery](https://jquery.com/)

Other comments: Really needs ECMAScript v6, because I used StringTemplates in `assets/javascripts/form_control.js`

I'm particular proud of: Being able to dynamically add more questions and answers, thanks to JS and jQuery.


## Project grading 

Description: given as part of the app, valid html.
The application works fine.

Validation occurs as part of saving to the database but not as part of the UI
such that e.g. trying to save without providing any content leads to ValidationException at
SocrativeLightController:77.
Functionality includes CRUD operations on the domain plus reporting.

Engineering:
Git log is a bit sparse (mostly committed the last day) but still ok.
Comments are almost entirely missing. 
Naming: the name "Room" is a bit surprising. A comment about it might have helped.
Good use of Web MVC. Very good testing.

Since we already hit the ceiling, I spare the effort of grading extra points.

Congratulations!
You created a really nice, distributed, multi-user, DB-backed web application all by yourself 
with dynamic behavior and some interesting use of JavaScript.
Many professional developers would have found it difficult 
to achieve the same in the given time frame.

Total grade: 6.0

