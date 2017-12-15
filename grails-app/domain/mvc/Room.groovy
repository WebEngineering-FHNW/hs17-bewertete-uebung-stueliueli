package mvc

class Room {
    String name
    List<Question> questions = new ArrayList()

    static constraints = {
        name blank: false, unique: true
    }
}
