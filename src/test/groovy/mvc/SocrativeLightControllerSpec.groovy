package mvc

import grails.test.mixin.TestFor
import grails.web.servlet.mvc.GrailsParameterMap
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SocrativeLightController)
class SocrativeLightControllerSpec extends Specification {
    SocrativeLightController controller
    def setup() {
        controller = new SocrativeLightController()
    }

    def cleanup() {
    }

    void "test get intParam"(){
        when:
            params.put('intVal1', 5)
            params.put('intVal2', 4356731)
            params.put('intVal3', -234)
            params.put('nonIntVal1', "asdf")
            params.put('nonIntVal1', new ArrayList<String>())
            params.put('nonIntVal1', 4.5f)
        then:
            controller.intParam(params, 'intVal1') == 5
            controller.intParam(params, 'intVal2') == 4356731
            controller.intParam(params, 'intVal3') == -234
            shouldFail(IllegalArgumentException) {
                controller.intParam(params, 'nonIntVal1')
            }
            shouldFail(IllegalArgumentException) {
                controller.intParam(params, 'nonIntVal2')
            }
            shouldFail(IllegalArgumentException) {
                controller.intParam(params, 'nonIntVal3')
            }
    }
}
