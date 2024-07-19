package battelship.model;
public record Coordinate(int column, int row) {


    public Coordinate plus(final int lenght, final Direction direction) {
        switch (direction){
            case EAST -> plusColumn(lenght);
            case WEST -> plusColumn(-lenght);
            case NORTH -> plusRow(-lenght);
            case SOUTH -> plusRow(lenght);

            default -> throw new IllegalStateException("Unknown End");
        }
        return null;
    }

    public Coordinate plusColumn(final int column) {
        return new Coordinate(this.column+column,this.row);
    }

    public Coordinate plusRow(final int row) {
    return new Coordinate(this.column,this.row+row);
    }
}