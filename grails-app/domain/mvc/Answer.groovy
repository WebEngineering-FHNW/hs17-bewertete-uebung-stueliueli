package mvc

class Answer {
    String answer
    boolean isCorrect

    static constraints = {
        answer blank: false
    }

    static mapping = {
        answer type: "text"
    }
}
