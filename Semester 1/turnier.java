//import SchiffeVersenken.Utility;

import java.io.IOException;
import java.math.*;
public class turnier {
  /*  record TournamentNode(TournamentNode left, TournamentNode right, String winner, int points) {
    }


    static TournamentNode addParticipant(final String name, final TournamentNode node){
        if(node==null){
            return new TournamentNode(null,null,name,0);
        }
        if(node.winner()!=null){
            return new TournamentNode(node,new TournamentNode(null,null,name,0),null,0);
        }
        if(getHeight(node.left)>getHeight(node.right)){
            return new TournamentNode(node.left,addParticipant(name,node.right),null,null);
        }
        if(getHeight(node.left)<getHeight(node.right)){
            return new TournamentNode(addParticipant(name,node.left),null,null,0);
        }
    }



    static int getNumberofLeaves(final TournamentNode node){
        if(node==null){
            return -1;
        }

        if(node.left==null&&node.right==null){
            return 1;
        }
        int links=getNumberOfLeaves(node.left());
        int rechts=getNumberOfLeaves(node.right());
        return links+rechts;
    }



    static TournamentNode readParticipants() {
        TournamentNode baum = null;
        String eingabe;
        System.out.println("Bitte geben sie den Namen eines Knoten eins");
        eingabe = Utility.readStringFromConsole();

        while (!"".equals(eingabe)) {
            if (eingabe != null) {
                addParticipant(eingabe, baum);
            }

            try {
                System.out.println("Bitte geben sie den Namen eines Knoten eins");
                eingabe = Utility.readStringFromConsole();
            } catch (IOException e) {
                eingabe = "";
            }


        }
        return baum;
        }






    static boolean finished(final TournamentNode root) {
        if (root.winner != null) {
            return true;
        }
        return false;
        //return root.winner !=null
    }


    static int getHeight(final TournamentNode node){
        if(node.left== null && node.right==null){
            return 0;
        }
    int left=getHeight(node.left);
    int right= getHeight(node.right);
    return Math.max(left,right)+1;
    }


    static int countNames(final TournamentNode node){
        if(node==null){
            return 0;
        }
        int resoult= node.winner !=null? 1:0;
        resoult= countNames(node.left())+countNames(node.right());
        return resoult;
    }


    static int getNumberofLeaves(final TournamentNode node){
        if(node==null){
            return 0;
        }


        if(node.left==0&&node.right==0){
            return 1;
        }

        return getNumberOfLeaves(node.left)+getNumberOfLeaves(node.right);
    }



    static TournamentNode addParticipnts(final String name,final TournamentNode node){
        if(node==null){
            return new TournamentNode(null,null,name,0);
        }
    if(getHeight(node.left)>getHeight(node.right)){
        return new TournamentNode(node.left,addParticipant(name,node.right),name,0);
        }

        if(getHeight(node.left)<getHeight(node.right)){
            return new TournamentNode(addParticipant(name,node.left),node.right,name,0);
        }
    }


    static TournamentNode setPoints(final TournamentNode node, final int points) {
        return new TournamentNode(node.left, node.right, node.winner, points);
    }


    static int powerOfT2(final int nonNegativeNumber) {
        int ergebnis = 1;
        if (nonNegativeNumber != 0) {
            for (int i = 0; i < nonNegativeNumber; i++) {
                ergebnis = ergebnis * 2;
            }
            return ergebnis;
        }
        return 1;
    }


    static int rowOffeset(final int level, final int height) {
        int zahl1 = powerOfT2(level);
        int zahl2 = powerOfT2(height);
        return (zahl2 / zahl1);
    }


    static int getHeight(final TournamentNode node) {
        if (node == null) {
            //nicht vorhandener Knoiten hat minus 1(dann maxium von -1 und -1 +1 =0)
            return -1;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    static int countNames(final TournamentNode node) {
        if (node == null) {
            return 0;
        }
        //ternärer ausdruck wenn !=null 1 sonst 0

        int result = node.winner != null ? 1 : 0;
        //Ist das gleiche wie result= resoult+countNames(node.left());
        result += countNames(node.left());
        result += countNames(node.right());
        return result;

    }


    static int getNumberOfLeaves(final TournamentNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left() == null && node.right() == null) {
            return 1;
        }

        return getNumberOfLeaves(node.left) + getNumberOfLeaves(node.right);
    }


    static TournamentNode addParticipant(final String name, final TournamentNode node) {
        if (node == null) {
            //erzeugt ein Blatt
            return new TournamentNode(null, null, name, 0);
        }
        //Erzeugt den oberen Knoten
        if (node.winner != null) {
            return new TournamentNode(node, new TournamentNode(null, null, name, 0), null, 0);
        }

        int links = getNumberOfLeaves(node.left());
        int rechts = getNumberOfLeaves(node.right());

        if (links > rechts) {
            //Ersetzen den oberen Knoten und geben den den alten linken und erstellen einen neuen Rechten.
            return new TournamentNode(node.left(), addParticipant(name, node.right()), null, 0);
        }
        //erzeugt den Oberen
        return new TournamentNode(addParticipant(name, node.left()), node.right(), null, 0);
    }


    static TournamentNode readParticipants() {
        //Leere Baum Erzeugen
        TournamentNode result = null;
        //Eingabe Leer
        String input = null;
        //Solange unser Input nicht "" ist mache das:
        while (!("".equals(input))) {
            if (input != null) {
                result = addParticipant(input, result);
            }

            //Fehlerbehandlung eines IOException
            try {
                System.out.println("Geben sie den nächsten Teilnehmer ein(leere Eigabe zum Beenden)");
                input = Utility.readStringFromConsole();

            } catch (IOException e) {
                input = "";
            }

        }
        return result;
    }


    static TournamentNode test(final TournamentNode node){
        return test(node);
    }



    static TournamentNode readNextResult(final TournamentNode node) {
        if (node.left().winner() != null && node.right().winner() != null) {
            int leftPoints = readPoints(node.left().winner());
            int rightPoints = readPoints(node.right().winner());
            while (leftPoints == rightPoints) {
                System.out.println("Punktzahl darf nicht gleich sein.");
                leftPoints = readPoints(node.left().winner());
                rightPoints = readPoints(node.right().winner());
            }
            return new TournamentNode(
                    setPoints(node.left(), leftPoints),
                    setPoints(node.right(), rightPoints),
                    leftPoints > rightPoints ? node.left().winner() : node.right().winner(),
                    0
            );
        }

        if (node.left().winner() != null) {
            return new TournamentNode(node.left(), readNextResult(node.right()), null, 0);
        }

        if (node.right().winner() != null) {
            return new TournamentNode(readNextResult(node.left()), node.right(), null, 0);
        }

        int leftNames = countNames(node.left());
        int rightNames = countNames(node.right());
        return leftNames > rightNames ?
                new TournamentNode(node.left(), readNextResult(node.right()), null, 0) :
                new TournamentNode(readNextResult(node.left()), node.right(), null, 0);
    }


    static int readPoints(final String name) {
        int result = 0;
        boolean okay = false;
        while (okay == false) {
            System.out.println("Punktzahl " + name + ": ");


            //Fehlerbehandlung eines IOException
            try {
                result = Integer.parseInt(Utility.readStringFromConsole());
                okay = true;
            } catch (IOException | NumberFormatException e) {
                okay = false;
            }

        }
        return result;
    }
    //kriegen einen Turnierbaum ein. Wollen irgendwo Punkt einfügen, dafür müssen wir den Aktuellen Kopieren(und neu Erzuegen)




    static void fillDisplay (final TournamentNode node,final int level,final int row, final int columnLength, final int height, final char [] [] display) {
        if (node == null) {
            return;
        }
        if (node.winner() != null) {
            int startcolumn = (height - level) * (columnLength + 1);
            for (int i = 0; i < node.winner().length(); i++) {
                display[row][startcolumn + i] = node.winner().charAt(i);
            }
            if (level > 0) {
                String points = String.valueOf(node.points());
                display[row][startcolumn + node.winner().length() + 1] = '(';
                for (int i = 0; i < points.length(); i++) {
                    display[row][startcolumn + node.winner().length() + 1 + i] = points.charAt(i);
                }
                display[row][startcolumn + node.winner().length() + 2 + points.length()] = ')';
            }
            fillDisplay(node.left(), level + 1, row, columnLength, height, display);
            fillDisplay(node.right(), level + 1, rowOffeset(level, height) + row, columnLength, height, display);
        }
    }



        static int getLenghtOfLongestColumn(final TournamentNode node){
        if(node==null){
            return 0;
        }

        int max=Math.max(getLenghtOfLongestColumn(node.left),getLenghtOfLongestColumn(node.right));
        return Math.max(max,node.winner != null ? node.winner.length()+
                String.valueOf(node.points).length()+3: 0);


    }


//Projekt euler gut für Übungen

        public static void main (String args[]){

        } */
    }
