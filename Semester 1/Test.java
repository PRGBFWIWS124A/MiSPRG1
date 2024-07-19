import com.sun.source.tree.Tree;

import java.util.Scanner;

public class Test {
   /* static int multi(int x, int y) {
        return x * y;
    }

    static int square(int x, int y) {
        return x * x + y * y;
    }

    static void output(String content) {
        System.out.println(content);
    }


    //erstellt einen Block von einer Linked List
    record Listnode(int vlaue, Listnode next) {
    }


    record SinglyLinkedList(Listnode root) {
    }

    record knoten(knoten links, knoten rechts,int wert){

    }

    record baum(knoten wurzel){

    }



    static baum knotenHinzufügen(final baum wurzel,final int wert){
        if(wurzel==null){
            return new baum(new knoten(null,null,wert));
        }
    return new baum(knotenHinzufügen(wurzel.wurzel,wert));
    }

    static knoten knotenHinzufügen(knoten node, int wert){
        if(node==null){
            return new knoten(null,null,wert);
        }
        if(node.wert>wert){
            return new knoten(knotenHinzufügen(node.links,wert),node.rechts,node.wert);
        }
            if(node.wert<wert){
                return new knoten(node.links,knotenHinzufügen(node.rechts,wert),node.wert);
            }

            return knoten;
    }

    static baum KnotenLöschen(final baum wurzel,final int wert){
        if(wurzel.wurzel.wert==wert){
            return new baum(new knoten(wurzel.wurzel().links(),wurzel.wurzel().rechts().rechts(),wurzel.wurzel.rechts.wert));
        }
        return new baum(KnotenLöschen(wurzel.wurzel,wert));
    }

    static knoten KnotenLöschen(final knoten knoten, final int wert){
        if(knoten.rechts.wert>wert){
        if(knoten.links.wert==wert){
            return new knoten(knoten.links.links,knoten.rechts(),knoten.wert);
        }else {
            KnotenLöschen(knoten.links);
        }}
        if(knoten.rechts.wert==wert){
            return new knoten(knoten.links,knoten.rechts.rechts,knoten.wert);
        }else{
            KnotenLöschen(knoten.rechts);
        }

        return knoten;
    }


    static SinglyLinkedList addFirst(final SinglyLinkedList list, final int value) {
        return new SinglyLinkedList(new Listnode(value, list.root));
    }

    static String toString(final SinglyLinkedList list) {
        if (list.root == null) {
            return "";
        }
        //kann obwohl list.root.vlaue int wieder geben weil dies zu String konvertiert wird (weil hinter dem + ein String erkannt wird)
        return list.root.vlaue + toString(list.root.next);
    }                           //list.root.next ist ein Listnode typ

    static String toString(final Listnode current) {
        if (current == null) {
            return "";
        } else {
            return "," + current.vlaue + toString(current.next);
        }
    }

    static SinglyLinkedList addLast(final SinglyLinkedList list, final int value) {
        return new SinglyLinkedList(addLast(list.root, value));
    }


    static Listnode addLast(final Listnode current, final int value) {
        if (current == null) {
            return new Listnode(value, null);
        } else return new Listnode(current.vlaue, addLast(current.next, value));
    }


    static SinglyLinkedList remove(final SinglyLinkedList list, final int value) {
        if (list.root == null) {
            return list;
        }
        //wenn anegeschautes element das ist was wir löschen wollen
        if (list.root.vlaue == value) {
        return new SinglyLinkedList(list.root.next);
        }
        //wen angeschaute element nicht das ist was wir nicht löschen wollen
        return new SinglyLinkedList(remove(list.root, value));
    }



    static Listnode remove(final Listnode current, final int value) {
        if (current.next == null) {
            return current;
        }
        if (current.next.vlaue == value) {
            return new Listnode(current.vlaue, current.next.next);
        }
        return new Listnode(current.vlaue,remove(current.next,value));
    }





    public static int hochrechner(int x,int y){
        if(y==0){
            return 1;
        }

        return x*(hochrechner(x,y-1));

    }



















    public static void main (String args[]){

System.out.println(hochrechner(10,5));





        String regex="[A-Z]";

        if("A".matches(regex)){
            System.out.println("True");
        }

      /*  Scanner scanner = new Scanner(System.in);
        System.out.print("Geben sie eine Zahl ein:");
        int zahl1 = scanner.nextInt();

        if(zahl1==1) {
        System.out.println("Monatg");
        }else if(zahl1==2){
            System.out.println("Dienstag");
            }else if(zahl1==3) {
            System.out.println("Miitwoch");
                }else if(zahl1==4) {
                System.out.println("Donnertag");
                     }else if(zahl1==5) {
                    System.out.println("Freitag");
                        }else if(zahl1==6) {
                        System.out.println("Samstag");
                                 }else{
                                System.out.println("Sonntag");}

    switch (zahl1){
        case (1): System.out.println("Januar"); break;
        case (2): System.out.println("Februar"); break;
        case (3): System.out.println("März"); break;
        case (4): System.out.println("April"); break;
        case (5): System.out.println("Mai"); break;
        case (6): System.out.println("Juni"); break;
        case (7): System.out.println("Juli"); break;
        case (8): System.out.println("August"); break;
        case (9): System.out.println("September"); break;
        case (10): System.out.println("oktober"); break;
        case (11): System.out.println("November"); break;
        case (12): System.out.println("Dezember"); break;
        }

       String x1= gerade(66);
    System.out.println(x1);


    }
    static String gerade(final int points){

        if (points>100){
            return ("Ungültige Punktzahl");}
//man hätte auch ohne esle arbeiten können nur mit ifs
        if (points>=97){
            return("1,0");
        }if(points>=92){
            return ("1,3");
        }if(points>=89){
            return ("1,7");
        }if(points>=85){
            return ("2,0");
        }if(points>=81){
            return ("2,3");
        }if(points>=77){
            return ("2,7");
        }if(points>=72){
            return ("3,0");
        }if(points>=67){
            return ("3,3");
        }if(points>=59){
            return ("3,7");
        }if(points>=50){
            return ("4,0");
        }
            return ("5,0");
        }


//Durchschnittliche Klausuraufgabe
        static int max(final int[] array){//throws illegalArgumentException(würde nach dem Array stehen) -> bei chcked Exceptions immer mit Schreiben bei uncheckd nicht nötig
            int max=array[0];

                //wenn Array kleiner gleich Null oder nicht vorhanden ist
            if(array.length<=0 || array==null){
                throw new IllegalArgumentException();
            }
                //wir brauchen kein Else weil wenn die Expeption geworfen wird bricht das Porgramm ab (oder bis es gefangen wird)
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }


       return max; }


*/
    }
