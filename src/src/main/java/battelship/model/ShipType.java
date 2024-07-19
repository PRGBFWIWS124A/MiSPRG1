package battelship.model;

public enum ShipType {

    //ENUM konstanten sind Konstruktor-Aufrufe
        BATTLESHIP("Schlachtschiff",4),
        CRUISER("Kreuzer",3),
        CANNON_BOAT("Kanonenboot",1),
        CARRIER("Flugzeugträger",5),
        DESTROYER("Zerstörer",2),
        SUBMARINE("U-Boot",3);

        final int lenght;
        final String name;

        private ShipType(String name, int lenght) {
            this.name = name;
            this.lenght = lenght;

    }
}
