package battelship.model;

public enum Player {
    FIRST,
    SECOND;

    public Player inverse() {
        if(this == Player.FIRST){
            return Player.SECOND;
        }
        return Player.FIRST;
    }
}
