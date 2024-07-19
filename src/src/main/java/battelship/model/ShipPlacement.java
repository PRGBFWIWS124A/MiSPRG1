package battelship.model;
import battelship.model.Coordinate;
import jdk.jfr.Recording;
import battelship.model.ShipType;
import java.util.Optional;
import battelship.model.Direction;
public class ShipPlacement extends Event {
    final Direction direction;
    final Player player;
    final Coordinate start;
    final ShipType type;

    public ShipPlacement(Direction direction, Player player, Coordinate start, ShipType type) {
        super();
        this.direction = direction;
        this.start = start;
        this.player = player;
        this.type = type;

    }

    public static Optional<Direction> toDirection(
            final ShipType type,
            final Coordinate start,
            final Coordinate end
    ) {
        if (start.row() == end.row()) {
            int distanceColumn = (start.column() - end.column());
            if (distanceColumn == type.lenght - 1) {
                return Optional.of(start.column() < end.column() ? Direction.EAST : Direction.WEST);
            }
        }
        if (start.column() == end.column()) {
            int distanceRow = (start.row() - end.row());
            if (distanceRow == type.lenght - 1) {
                return Optional.of(start.row() < end.row() ? Direction.SOUTH : Direction.NORTH);
            }

        }
        return Optional.empty();

    }

    @Override
    public boolean isShipPlacementEvent(Player player) {
        return true;
    }

    @Override
    public boolean isShotEvent(Player player) {
        return false;
    }
}

