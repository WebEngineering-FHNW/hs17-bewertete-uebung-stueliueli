package mvc

class SocrativeLightController {

    def index() {
        List<Room> availableRooms = Room.all
        render view:"index",model: [rooms:availableRooms]
    }

    def view(){
        String roomName = params.get('roomName')
        Room room = Room.findByName(roomName)
        render view:"view", model:[room:room]
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
    }
}
