package battelship.model;

public enum Player {
    FIRST,
    SECOND;

    public Player inverse() {
        if(this==FIRST){
            return SECOND;
        }
        return FIRST;
    }
}
