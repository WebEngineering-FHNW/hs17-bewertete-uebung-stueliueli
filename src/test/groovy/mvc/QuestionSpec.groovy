package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Question)
class QuestionSpec extends Specification {
    Question q1,q2,q3,q4
    def setup() {
        q1 = new Question(question: "Question1")
        q2 = new Question(question: "Question2")
        q3 = new Question(question: "Question3")
        q4 = new Question(question: "Question4")
    }

    def cleanup() {
    }

    void "test correct instantiation"() {
        expect:
            q1.question == "Question1"
            q2.question == "Question2"
            q3.question == "Question3"
            q4.question == "Question4"
            q1.question != q2.question
            q3.question != q4.question
            q1.question != q4.question
            q3.question != q2.question
    }

    void "test add answers"(){
        expect:
            q1.answers.size() == 0
        when:
            Answer a1 = new Answer(answer: "Answer1", isCorrect: true)
            Answer a2 = new Answer(answer: "Answer2", isCorrect: false)
            q1.answers.add(a1)
            q1.answers.add(a2)
        then:
            q1.answers.size() == 2
            q1.answers.get(0) == a1
            q1.answers.get(0).answer == a1.answer
            q1.answers.get(1) == a2
            q1.answers.get(1).answer == a2.answer
            q2.answers.size() == 0
        when:
            q1.answers.remove(a1)
        then:
            q1.answers.size() == 1
            q1.answers.get(0) == a2
            q1.answers.get(0).answer == a2.answer
        when:
            q1.answers.clear()
        then:
            q1.answers.size() == 0

    }
}
