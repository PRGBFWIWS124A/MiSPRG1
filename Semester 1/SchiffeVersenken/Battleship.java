package SchiffeVersenken;


import com.sun.source.tree.WhileLoopTree;
import jdk.jshell.execution.Util;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Battleship {
    public static int SIZE = 10;
    private static final String ENTER_SHIP_COORDINATE_PROMPT = "Geben Sie die %skoordinaten für ein Schiff der länge %d ein";




    static int distance(final Coordinate start, final Coordinate end) {
        return Math.abs(start.column() - end.column()) + Math.abs(start.row() - end.row());
    }


    static Coordinate getRandomCoordinate() {
        return new Coordinate(Utility.getRandomInt(SIZE), Utility.getRandomInt(SIZE));
        //Size ist richtig weil 0 ist das kleinste 9 das größte was Geht das Spielfeld geht also,
        //von 0-9  die Porbleme sind off by one und Variablen namen
    }

    static boolean onOneLine(final Coordinate start, final Coordinate end) {
        return (start.column() == end.column() || start.row() == end.row());//bei booleaschen werten nicht mit If else verzweigung jeder Typ hat ein wert(außer Void)
    }


    static void showSeparatorLine() {
        System.out.println("   +-+-+-+-+-+-+-+-+-+-+      +-+-+-+-+-+-+-+-+-+-+");
    }


    static int getMaxSurroundingColumn(final Coordinate start, final Coordinate end) {
        return Math.min(Math.max(start.column(), end.column()) + 1, SIZE - 1);
    }


    static int getMaxSurroundingRow(final Coordinate start, final Coordinate end) {
        return Math.min(Math.max(start.row(), end.row()) + 1, SIZE - 1);
    }


    static int getMinSurroundingColumn(final Coordinate start, final Coordinate end) {
        return Math.max(Math.min(start.column(), end.column()) - 1, 0);
    }


    static int getMinSurroundingRow(final Coordinate start, final Coordinate end) {
        return Math.max(Math.min(start.row(), end.row()) - 1, 0);
    }

    static Coordinate toCoordinate(final String input) {
       //GIBT die EIngabe as groß EIngabe ab. Dann wird diese Eingabe an stelle 0 in int umgewandelt und -65(wegen asci code)
        int collumn = input.toUpperCase().charAt(0) - 65;
        //Für das Zweite Zeichen aus dem String(2 Ziffer vom Input)
        //wir Brauchen substring um dauch Potenziel A10 die 10 mit zu benutzen
        //substring Startet bei dem Index 1 vom String.
        int row = Integer.parseInt(input.substring(1)) -1;
       return new Coordinate(row,collumn);


       // int column = input.toLowerCase().charAt(0) - 'a';
        //int row = (Integer.parseInt(input.substring(1)) - 1);
           // return new Coordinate(column, row);
        }


    static boolean isValidCoordinate(final String input) {
        String regex = "[A-J]([1-9]|10)";
        boolean isValid = input.matches(regex);
        return (isValid);
    }


    static String getStartCoordinatePrompt(final int lenght) {
        return String.format(ENTER_SHIP_COORDINATE_PROMPT, "Start", lenght);

    }

    static String getEndCoordinatePrompt(final int lenght) {
        return String.format(ENTER_SHIP_COORDINATE_PROMPT, "End", lenght);
    }


    static void showRowNumber(final int row){
        if(row<9){
            System.out.print("");
            System.out.print(row+1);
        }
        System.out.println(SIZE);
    }

    static Coordinate getRandomEndCoordinate(final Coordinate start, final int distance) {
        int choices = 0; //so ne aufgabe nicht klausur


        if ((start.row() - distance) >= 0) {
            choices++;
        }

        if ((start.row() + distance) < SIZE) {
            choices++;
        }

        if ((start.column() - distance) >= 0) {
            choices++;
        }

        if ((start.column() - distance) < SIZE) {
            choices++;
        }


        //eine Random Choice von dem möglichen Anzahl von choices. Dadurch bekommen wir schon eine Zufällige Zahl die wir später wieder Abziehen.
        int choice = Utility.getRandomInt(choices);


//hier wird noch mal überprüft und choice abgezogen.wenn choice kleiner 0 ist, dann wird die Coordinate mit
//der Anweisung abgezogen
        if ((start.row() - distance) >= 0) {
            choice--;
            if (choice < 0) {
                return new Coordinate(start.column(), start.row() - distance);
            }
        }

        if ((start.row() + distance) < SIZE) {
            choice--;
            return new Coordinate(start.column(), start.row() + distance);
        }

        if ((start.column() - distance) >= 0) {
            choice--;
            return new Coordinate(start.column() - distance, start.row());
        }


        return new Coordinate(start.column() + distance, start.row());
    }


    static void showField(final Field field, final boolean showShips) {

        switch (field) {
            case Field.SHIP:
                System.out.print(showShips ? "O" : " ");
                break;
            //Das gilt für unser und gegnerisches Feld
            case Field.FREE:
                System.out.print(" ");
                break;
            case Field.WATER_HIT:
                System.out.print("X");
                break;
            case Field.SHIP_HIT:
                System.out.print("*");
                break;
        }
    }


    static void shot(final Coordinate shot, final Field[][] field) {

        switch (field[shot.row()][shot.column()]) {
            case Field.FREE:
                field[shot.row()][shot.column()] = Field.WATER_HIT;
                break;
            case Field.SHIP:
                field[shot.row()][shot.column()] = Field.SHIP_HIT;
                if (shipSunk(shot, field)) {
                    fillWaterHits(shot, field);
                }
                break;

        }
    }


    static void placeShip(final Coordinate start, final Coordinate end, final Field[][] field) {


        if (start.row() == end.row()) {
            for (
                    int i = Math.min(start.column(), end.column());
                    i < Math.max(start.column(), end.column());
                    i++) {
                field[start.row()][i] = Field.SHIP;
            }

        } else {

            for (
                    int i = Math.min(start.row(), end.row());
                    i < Math.max(start.row(), end.row());
                    i++) {
                field[i][start.column()] = Field.SHIP;
            }
        }
    }


    static void showRow(final int row, final Field[][] ownField, final Field[][] otherFiled) {

        showRowNumber(row);
        System.out.print("|");
        for (int i = 0; i < SIZE; i++) {
            showField(ownField[row][i], true);
            System.out.print("|");
        }
        System.out.print("   ");
        showRowNumber(row);
        System.out.print("|");

        for (int j = 0; j < SIZE; j++) {
            showField(otherFiled[row][j], false);
            System.out.print("|");
        }
        System.out.println();
    }


    static void showFields(final Field[][] ownField, final Field[][] otherField) {
        System.out.println("    A B C D E F G H I J         A B C D E F G H I J");
        for (int i = 0; i < SIZE; i++) {
            showSeparatorLine();
            showRow(i, ownField, otherField);
        }
        showSeparatorLine();
        System.out.println();
    }


    static boolean shipSunk(final Coordinate shot, final Field[][] field) {
        int row = shot.row();
        int column = shot.column();
        //Check nach oben ob das schiff getroffen wurde
        while (row > 0 && Field.SHIP_HIT == field[row][column]) {
            row--;
        }

        if (Field.SHIP == field[row][column]) {
            return false;
        }


        //check nach unten ob das schiff getroffen wurde

        while (row < SIZE - 1 && Field.SHIP_HIT == field[row][column]) {
            row++;
        }


        if (Field.SHIP == field[row][column]) {
            return false;
        }


        //check nach Rechts ob das schiff getroffen wurde

        while (column < SIZE - 1 && Field.SHIP_HIT == field[row][column]) {
            column++;
        }

        if (Field.SHIP == field[row][column]) {
            return false;
        }


        //check nach links ob das schiff getroffen wurde

        while (column > 0 && Field.SHIP_HIT == field[row][column]) {
            column--;
        }

        return Field.SHIP != field[row][column];
    }


    static void setAllFree(final Field[][] field) {
        //option 1
      /*  int i = 0;
        while (i < SIZE) {
            for (int b = 0; b < SIZE; b++) {
                field[i][b] = Field.FREE;
            }
            i++;
        }
*/


        //option 2
        for (int i = 0; i < SIZE; i++) {
            for (int b = 0; b < SIZE; b++) {
                field[i][b] = Field.FREE;
            }
        }

    }


    static int countHits(final Field[][] field) {
        int count = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++)

                if (field[row][column] == Field.SHIP_HIT) {
                    count++;
                }
        }
        return count;


    }

    static void fillWaterHits(final Coordinate shot, final Field[][] field) {
        int row = shot.row();
        int column = shot.column();


        while (row > 0 && Field.SHIP_HIT == field[row][column]) {
            row--;
        }
        int minRow = row;

        while (row < SIZE - 1 && Field.SHIP_HIT == field[row][column]) {
            row++;
        }
        int maxRow = row;


        while (column < SIZE - 1 && Field.SHIP_HIT == field[row][column]) {
            column++;
        }

        int minColumn = column;


        while (column > 0 && Field.SHIP_HIT == field[row][column]) {
            column--;
        }

        int maxColumn = column;


        for (row = minRow; row < maxRow; row++) {
            for (column = minColumn; column < maxColumn; row++) {
                if (field[row][column] == Field.FREE) {
                    field[row][column] = Field.WATER_HIT;

                }
            }
        }
    }


    static boolean noConflict(final Coordinate start, final Coordinate end, final Field[][] field) {


        for (int row = getMinSurroundingRow(start, end);
             row <= getMaxSurroundingRow(start, end);
             row++) {
            for (int column = getMinSurroundingColumn(start, end);
                 column <= getMaxSurroundingColumn(start, end);
                 column++) {
                if (field[row][column] != Field.FREE) {
                    return false;
                }

            }
        }
        return true;
    }


    static Coordinate readCoordinate(final String prompt) {//keine throws exception weil fehlerbehandlung und keine excpetion erzuegt wird
        //prompt ist eine Anfrage
        String eingabe = "";
        while (!isValidCoordinate(eingabe)) {//man könnte das ==false auch weg lassen und einfach davor ! werfen
            try {
                System.out.println(prompt);
                eingabe = Utility.readStringFromConsole();//wenn hier die IO Exception geworfen wird dann wird diese unten gefangen und schliefe wiederholt
                break;
            } catch (IOException e) {
                eingabe = "";
            }
        }

        return toCoordinate(eingabe);
    }


    static Coordinate getRandomUnshotCoordinate(final Field[][] field) {
        int chances = 0;
        for (int i = 0; i < field.length; i++) {
            for (int a = 0; a < SIZE; i++) {
                if (field[i][a] == Field.FREE || field[i][a] == Field.SHIP) {
                    chances++;
                }
            }
        }

        int random = Utility.getRandomInt(chances);
        for (int i = 0; i < field.length; i++) {
            for (int a = 0; a < SIZE; i++) {
                if (field[i][a] == Field.FREE || field[i][a] == Field.SHIP) {
                    random--;
                    if (random < 0) {
                        return new Coordinate(a, i);
                    }
                }
            }
        }

        throw new IllegalStateException();
    }


    static Coordinate readEndCoordinate(final int lenght) {
        return readCoordinate(getEndCoordinatePrompt(lenght));
    }


    static Coordinate readStartCoordinate(final int lenght) {
        return readCoordinate(getStartCoordinatePrompt(lenght));
    }

    public static int ALL_HIT = 14;

    static boolean allHit(final Field[][] field) {
        return (countHits(field) == ALL_HIT);
    }


    static boolean endCondition(final Field[][] ownField, final Field[][] otherField) {
        if (allHit(ownField) || allHit(otherField)) {
            return true;
        }
        return false;
    }

    static boolean validPostion(
            final Coordinate start,
            final Coordinate end,
            final int lenght,
            final Field[][] field
    ) {

        if (onOneLine(start, end) && (distance(start, end) == lenght) && noConflict(start, end, field)) {
            return true;
        }
        return false;
    }


    static void turn(final Field[][] ownField, final Field[][] otherField) {
        showFields(ownField, otherField);
        shot(readCoordinate("geben sie das Feld für einen Schuss ein"), otherField);
        shot(getRandomUnshotCoordinate(otherField), ownField);
    }


    static void outputWinner(final Field[][] ownField, final Field[][] otherField) {
       showFields(ownField,otherField);
        if (allHit(ownField)) {
            System.out.println("Der Computer hat gewonnen!");
        }
        System.out.println("Du hast gewonnen!");
    }


    static Field[][] initOtherField() {
        Field[][] neuesFeld = new Field[SIZE][SIZE];
        setAllFree(neuesFeld);

        for (int i = 1; i < 6; i++) {
            Coordinate a = getRandomCoordinate();
            Coordinate b = getRandomEndCoordinate(a, i-1);
            if(validPostion(a,b,i, neuesFeld)){
            placeShip(a, b, neuesFeld);
        }else{
                i--;
            }
        }

        return neuesFeld;
    }


    static Field[][] initOwnField(final Field[][] otherField) throws IOException {
        Field[][] ownField = new Field[SIZE][SIZE];
        setAllFree(ownField);




        for (int i = 5;0<i; i--) {
           final Coordinate start = readStartCoordinate(i);
           final Coordinate end= readEndCoordinate(i);
            showFields(ownField, otherField);
            if(validPostion(start,end,i,ownField)){
                placeShip(start,end,ownField);
            }else
                i++;

        }
        return ownField;
    }

    public static void main(String args[])throws IOException{
        System.out.println();
       Field[][] otherFieled = initOtherField();
       Field[][] ownField= initOwnField(otherFieled);

        while(!endCondition(ownField,otherFieled)){
            turn(ownField,otherFieled);
        }
        outputWinner(ownField,otherFieled);
    }



}