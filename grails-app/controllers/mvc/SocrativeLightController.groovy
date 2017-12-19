package mvc

class SocrativeLightController {

    def index() {
        List<Room> availableRooms = Room.all
        render view:"index",model: [rooms:availableRooms]
    }

    def view(){

        int i = intParam(params, 'roomId')
        Room room = Room.get(i)
        int numCorrect = intParam(params, 'numCorrect')

        int qId = intParam(params, 'questionId')
        if(room){
            Question q = null
            if(qId - 1 >= 0)
                q = room.questions.get(qId - 1)
            boolean isCorrect = checkForCorrectInput(params, q)
            if(isCorrect)
                numCorrect++

            if(qId >= room.questions.size()){
                render view:"quizFinished",
                        model:[name:room.name,
                               numCorrect:numCorrect,
                               numQuestions:room.questions.size(),
                               lastCorrect: isCorrect]
            }else{
                render view:"view",
                        model:[name:room.name,
                               roomId:room.id,
                               question:room.questions.get(qId++),
                               qId:qId,
                               numCorrect: numCorrect,
                               lastCorrect: isCorrect]
            }
        }else{
            render view:"/error"
        }
    }

    def create(){
        render view:"create"
    }

    def save(){
        String roomName = params.get('name')
        Room room = new Room(name: roomName)
        int questionId = 1
        String question
        while(question = params.get('question-fg' + questionId)){
            Question q = new Question(question: question)
            int answerId = 1
            String answer
            while(answer = params.get('answer'+answerId+'-fg'+questionId)){
                boolean isCorrect = params.get('checkbox'+answerId+'-fg'+questionId)
                Answer a = new Answer(answer: answer,isCorrect: isCorrect)
                q.answers.add(a)
                answerId++
            }
            room.questions.add(q)
            questionId++
        }

        room.save(flush:true,failOnError:true)
        redirect(action: "index")
    }

    int intParam(param, String str){
        String s = param.get(str)
        if(s == null){
            println("Param " + str + " is null!")
            throw new IllegalArgumentException("Param " + str + " is null!")
        }
        try{
            int i = Integer.parseInt(s)
            return i
        }catch(NumberFormatException nfe){
            println(nfe)
            throw new IllegalArgumentException(nfe)
        }
    }

    boolean checkForCorrectInput(params, Question lastQuestion){
        if(lastQuestion == null)
            return false
        for(Answer a : lastQuestion.answers){
            if(Boolean.logicalXor((boolean)params.get("answer"+a.id), a.isCorrect)){
                return false
            }
        }
        return true
    }
}
