package mvc

class Question {
    String question
    List<Answer> answers = new ArrayList()

    static constraints = {
        question blank: false
    }
}
