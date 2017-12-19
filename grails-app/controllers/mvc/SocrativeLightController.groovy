package mvc

class SocrativeLightController {

    def index() {
        List<Room> availableRooms = Room.all
        render view:"index",model: [rooms:availableRooms]
    }

    def view(){
        String roomId = params.get('roomId')
        int i = Integer.parseInt(roomId)

        Room room = Room.get(i)
        int qId = Integer.parseInt(params.get('questionId')) + 1
        if(room){
            render view:"view", model:[name:room.name,question:room.questions.get(qId - 1),qId:qId]
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
}
