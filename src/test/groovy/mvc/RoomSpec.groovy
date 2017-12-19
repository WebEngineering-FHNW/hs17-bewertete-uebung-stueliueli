package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Room)
class RoomSpec extends Specification {
    Room r1,r2,r3,r4
    def setup() {
        r1 = new Room(name: "Room1")
        r2 = new Room(name: "Room2")
        r3 = new Room(name: "Room3")
        r4 = new Room(name: "Room4")
    }

    def cleanup() {
    }

    void "test correct instantiation"() {
        expect:
            r1.name == "Room1"
            r2.name == "Room2"
            r3.name == "Room3"
            r4.name == "Room4"
            r1.name != r2.name
            r1.name != r3.name
            r1.name != r4.name
            r2.name != r3.name
            r2.name != r4.name
            r3.name != r4.name
    }

    void "test add question correct"(){
        expect:
            r1.questions.size() == 0
        when:
            Question q1 = new Question(question: "Question1")
            Question q2 = new Question(question: "Question2")
            r1.questions.add(q1)
            r1.questions.add(q2)
        then:
            r1.questions.size() == 2
            r1.questions.get(0) == q1
            r1.questions.get(1) == q2
        when:
            r1.questions.remove(q1)
        then:
            r1.questions.size() == 1
            r1.questions.get(0) == q2
        when:
            r1.questions.clear()
        then:
            r1.questions.size() == 0
    }

    void "test add answers correctly"(){
        expect:
            r2.questions.size() == 0
        when:
            Question q1 = new Question(question: "Question4")
            Question q2 = new Question(question: "Question5")
            r2.questions.add(q1)
            r2.questions.add(q2)
        then:
            r2.questions.size() == 2
            r2.questions.get(0).answers.size() == 0
        when:
            Answer a1 = new Answer(answer: "Answer1", isCorrect: true)
            Answer a2 = new Answer(answer: "Answer2", isCorrect: false)
            r2.questions.get(0).answers.add(a1)
            r2.questions.get(0).answers.add(a2)
        then:
            r2.questions.size() == 2
            r2.questions.get(0).answers.size() == 2
            r2.questions.get(1).answers.size() == 0
        when:
            r2.questions.remove(q2)
        then:
            r2.questions.size() == 1
            r2.questions.get(0).answers.size() == 2
        when:
            r2.questions.get(0).answers.remove(a1)
        then:
            r2.questions.size() == 1
            r2.questions.get(0).answers.size() == 1
            r2.questions.get(0).answers.get(0) == a2
        when:
            r2.questions.get(0).answers.clear()
        then:
            r2.questions.get(0).answers.size() == 0
        when:
            r2.questions.clear()
        then:
            r2.questions.size() == 0

    }
}
