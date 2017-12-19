package mvc

class Question {
    String question
    List<Answer> answers = new ArrayList()

    static constraints = {
        question blank: false
    }

    static mapping = {
        question type: "text"
    }

    int getSumChosen(){
        return answers.stream().mapToInt{c -> c.numChosen}.sum()
    }
}
