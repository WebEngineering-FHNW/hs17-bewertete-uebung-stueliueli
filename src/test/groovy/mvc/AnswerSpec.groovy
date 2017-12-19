package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Answer)
class AnswerSpec extends Specification {
    Answer aFalse,aTrue,aTrue2
    def setup() {
        aFalse = new Answer(answer: "Answer1", isCorrect: false)
        aTrue = new Answer(answer: "Answer2", isCorrect: true)
        aTrue2 = new Answer(answer: "Answer3", isCorrect: true)
    }

    def cleanup() {
    }

    void "test correct instantiation"(){
        expect:
            !aFalse.isCorrect
            aTrue.isCorrect
            aTrue2.isCorrect
            aTrue.isCorrect == aTrue2.isCorrect
            aFalse.answer == "Answer1"
            aTrue.answer == "Answer2"
            aTrue2.answer == "Answer3"
    }
}
