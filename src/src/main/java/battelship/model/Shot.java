package battelship.model;

import java.util.UUID;

public class Shot extends Event{
    final Coordinate coordinate;
    final Player player;

    public Shot(Coordinate coordinate, Player player) {
        super();
        this.coordinate = coordinate;
        this.player = player;
    }

    @Override
    public boolean isShipPlacementEvent(Player player) {
        return false;
    }

    @Override
    public boolean isShotEvent(Player player) {
        return true;
    }
}
