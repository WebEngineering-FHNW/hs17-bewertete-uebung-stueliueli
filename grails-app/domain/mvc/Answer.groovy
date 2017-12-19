package mvc

class Answer {
    String answer
    boolean isCorrect
    int numChosen

    static constraints = {
        answer blank: false
    }

    static mapping = {
        answer type: "text"
    }
}
