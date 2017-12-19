<html>
    <head>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div style="margin: 2%;">
            <h1>Socrative "Light"</h1>

            <p>Dieses Produkt wurde von 16-660-805 im Rahmen des Webec-Unterrichtes im Herbstsemester 2017 an der FHNW HT in Windisch erstellt.</p>
            <p>Das Produkt ist eine abgespeckte Version des Frage-Antwort-Tools "Socrative".</p>
            <h3>Bedienung</h3>
            <p>Auf der Startseite werden alle verfügbaren Fragenblöcke, "Questionnaires" genannt, aufgelistet. Hier kann man mittels "Start"
            das Quiz starten oder mittels "Stats" die Statistiken zu den Fragen anschauen. Ebenfalls kann man ein neues Questionnaire erstellen.</p>

            <h4>Neues Questionnaire erstellen</h4>
            <p>Auf der Seite <g:link controller="socrativeLight" action="create">/socrativeLight/create</g:link> kann man ein neues Questionnaire erstellen.
            Dabei kann man dem Questionnaire einen Namen geben und Fragen hinzufügen. Die Anzahl der Fragen sowie die Anzahl der jeweiligen Antworten kann
            dynamisch gewählt werden durch simples klicken der jeweiligen Buttons.
            Durch Anwählen der jeweiligen Checkboxen kann man markieren, dass eine bestimmte Antwort "richtig" ist.</p>

            <h4>Quiz durchführen</h4>
            <p>Wenn man über die Startseite das Quiz für ein Questionnaire startet, wird das Quiz mit der ersten Frage begonnen.
            Durch klicken auf die Antworten werden diese ausgewählt (grün markiert). Mehrfachauswahl ist möglich.
            Wenn man die Antworten absendet, wird die nächste Seite geladen, wo mittels SweetAlert gezeigt wird, ob man die letzte Frage
            richtig oder falsch beantwortet hat. Man bekommt aber explizit keine Informationen dazu, welches die richtige Antwort
            gewesen wäre, da man das Quiz nach erneutem Lernen des Stoffes nochmals durchführen können soll.</p>

            <h4>Statistiken ansehen</h4>
            <p>Wenn man die Statistiken für ein Questionnaire anschaut, sieht man alle Fragen und möglichen Antworten und wie oft diese
            jeweils ausgewählt wurden (als ganze Zahlen sowie als Progressbar).</p>
        </div>
    </body>
</html>