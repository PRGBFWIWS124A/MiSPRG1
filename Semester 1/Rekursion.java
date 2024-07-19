import SchiffeVersenken.Utility;

import java.util.List;
import java.math.*;
public class Rekursion {

      /*  record ListNode(int value, ListNode next){

        }

        record SinglyLinkedList(ListNode root){}



        static SinglyLinkedList addFirst(final SinglyLinkedList list, final int value){
            return new SinglyLinkedList(new ListNode(value,list.root));

        }

        static String toString(final SinglyLinkedList list){
            if(list==null){
                return "";
            }


            return list.root.value+toString(list.root.next);


        }

        static String toString(final ListNode node){
           if(node==null){
               return "";
           }
            return ","+node.value+toString(node.next);
        }

        static SinglyLinkedList addLast(final SinglyLinkedList list, final int value){
                return new SinglyLinkedList(addLast(list.root,value));

        }
            static ListNode addLast(final ListNode node,final int value){
            if(node==null){
                return new ListNode(value,null);
            }

            return new ListNode(node.value,addLast(node.next,value));
        }


        static SinglyLinkedList remove(final SinglyLinkedList list, final int value){
        if(list==null){
            return list;
        }
         if(list.root.value==value){
             return new SinglyLinkedList(list.root().next);
         }
            return new SinglyLinkedList(remove(list.root,value));
        }

        static ListNode remove(final ListNode node,final int value){
           if(node.next==null){
               return node;
           }
            if(value==node.next().value()){
                return new ListNode(node.value,node.next.next);
            }
            return new ListNode(node.value,remove(node.next,value));
        }


record TournamentNode(TournamentNode left,TournamentNode right,String winner, int points){

}


static int getHeight(final TournamentNode node){
            if(node==null){
                return -1;
            }


            int left=getHeight(node.left);
            int right=getHeight(node.right);

        return Math.max(left,right)+1;
        }

        static int countName(final TournamentNode node){
            if(node==null){
                return 0;
            }
        int resoult= node.winner!=null ? 1:0;
            resoult=resoult+countName(node.left);
            resoult=resoult+countName(node.right());
            return resoult;
        }


        static int getNumberOfLeaves(final TournamentNode node){
            if(node==null){
                return 0;
            }
            if(node.left==null && node.right==null){
                return 1;}

            return getNumberOfLeaves(node.left)+getNumberOfLeaves(node.right);
        }



        static TournamentNode addParticipant(final String name,final TournamentNode node){
            if(node==null){
                return new TournamentNode(null,null,name,0);
            }

            if(node.left==null&&node.right==null){
                return new TournamentNode(node,new TournamentNode(null,null,name,0),node.winner,0);
            }

            if(getHeight(node.left)>getHeight(node.right)){
                return new TournamentNode(node.left,addParticipant(name,node.right),node.winner,node.points);
            }else{


                return new TournamentNode(addParticipant(name,node.left),node.winner,node.points);
            }
        }

            static int nameScoreSum(char[][] names){
               int ergebniss1=0;
                for(int i =0;i<names.length;i++){
                    for(int b=0;b<names[i].length;b++){
                        ergebniss1+=charValue(names[i][b]);
                    }
                   ergebniss1=ergebniss1*1+i;
                }
                return ergebniss1;
            }

            public record BinaryTree(Node root){}
            public record Node(int value,Node left,Node right){}

    static int sum(BinaryTree tree){
            return sum(tree.root);
    }

    static int sum(Node knoten){
            if(knoten==null){
                return 0;
            }
            int links=sum(knoten.left);
            int right= sum(knoten.right);
        return (knoten.value+links+right);
        }

static BinaryTree insert(BinaryTree tree,int value){
  if(tree.root==null){
      return new BinaryTree(new Node(value,null,null));
  }

    return new BinaryTree(insert(tree.root,value));
}

static Node insert(Node knoten, int value){
    if(knoten==null){
        return new Node(value,null,null);
    }



    if(knoten.right().value()<value){
        insert(knoten.right,value);
    }else{
    insert(knoten.left,value);}


return knoten;

}

static boolean equal(BinaryTree t1,BinaryTree t2){
            if(t1==null){
                return t2==null;
            }
            if(t2==null){
                return false;
            }
            return equal(t1.root,t2.root);
        }

        static boolean equal(Node t1,Node t2){
           if(t1==null){
               return t2==null;
           }
           if(t2=null||t1.value()!=t2.value()){
               return false;
           }




            return equal(t1.right,t2.right)&&equal(t1.left,t2.left);



        }
    public class FehlerhafterCode {
        public static void main(String[] args) {
            int zahl1 = 10;
            int zahl2 = 0;
            int ergebnis;
            if(zahl2==0){
                ergebnis=0;
            }else{
            int ergebnis = zahl1 / zahl2;}

            System.out.println("Das Ergebnis ist: " + ergebnis);
        }
    }
*/


 /*   public record Listnode(int value,Listnode next){

    }

    public record SinglyLinkedlist(Listnode root){

    }

    public static SinglyLinkedlist addFirst(final SinglyLinkedlist list,final int value){
        if(list==null){
            return new SinglyLinkedlist(new Listnode(value,null));
        }

        return new SinglyLinkedlist(new Listnode(value,list.root));

    }

    public static String toString(final SinglyLinkedlist list){
        if(list.root==null){
            return "";
        }

        return toString(list.root);
    }

    public static String toString(final Listnode node){
        if(node==null){
            return "";
        }
        return String.valueOf(node.value)+";"+toString(node.next);
    }



    public static SinglyLinkedlist addLast(final SinglyLinkedlist list,final int value){
        return new SinglyLinkedlist(addLast(list.root,value));
    }
public static Listnode addLast(final Listnode node,final int value){
        if(node==null){
            return new Listnode(value,null);
        }
        return new Listnode(node.value,addLast(node.next,value));
    }

    public static SinglyLinkedlist remove(final SinglyLinkedlist list,final int value){
      if(list==null){
          return list;
      }
        if(list.root.value==value){
            return new SinglyLinkedlist(list.root.next);
        }
        return new SinglyLinkedlist(remove(list.root,value));
    }

    public static Listnode remove(final Listnode node,final int value){
        if(node.value()==value){
            return new Listnode(node.next.value,node.next);
        }else{remove(node.next,value);}
        return node;


    }

    record TournamentNode(TournamentNode left,
                          TournamentNode right,
                          String winner,
                          int points){
    }


    static int getHeight(final TournamentNode node){
        if(node==null){
            return -1;
        }
        int left=getHeight(node.left);
        int right=getHeight(node.right);
        return Math.max(left,right)+1;
    }



    static int countNames(final TournamentNode node){
        if(node==null){
            return 0;
        }
        int resoult=node.winner != null ? 1:0;
        int left=countNames(node.left);
        int right=countNames(node.right);
        return left+right+resoult;
    }

    static int getNumberofLeaves(final TournamentNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }

        int links=getNumberofLeaves(node.left);
        int rechts=getNumberofLeaves(node.right());
        return links+rechts;}


       public static TournamentNode addParticipant(final String name,final TournamentNode node){
            if(node==null){
                return new TournamentNode(null,null,name,0);
            }
            if(node.winner()!=null){
                return new TournamentNode(node,new TournamentNode(null,null,name,0), null,0);
            }
            if(getHeight(node.left)=>getHeight(node.right)){
            return new TournamentNode(node.left,addParticipant(name,node.right),null,0);}
            return new TournamentNode(addParticipant(name,node.left),node.right,null,0);
        }








    public static void aufgabe1(){
      int[] array=new int[10];
       int summe=1;

       for(int i=0;i<10;i++){
           array[i]=summe;
           summe=summe*2;
        }
        for(int i=9;i>=0;i--){
            System.out.println(array[i]);
        }

    }


    public static int[] getZufallszahlen(){
        int[]array=new int[Utility.getRandomInt(2147483647)];
        for(int i=0;i<array.length;i++){
            array[i]=Utility.getRandomInt(2147483647);
        }
        return array;

    }

*/

public record BinaryTree(Node root){

}
public record Node (int value,Node left,Node right)   {

}
static int sum(BinaryTree tree){
    if(tree.root==null){
        return 0;
    }
    return sum(tree.root);
}

static int sum(Node node){
    if(node==null){
        return 0;
    }
    int links=sum(node.left);
    int rechts=sum(node.right);
    return (links+rechts)+node.value();
}

static BinaryTree insert(BinaryTree tree,int value){
    if(tree.root==null){
        return new BinaryTree(new Node(value,null,null));
    }
    return insert(tree.root,value);
}

static Node insert(Node node,int value){
    if(node==null){
        return new Node(value,null,null);
    }

    if(node.value<value){
        return new Node(node.value,node.left,insert(value,node.right));
    }else{
        return new Node(node.value,insert(node.left,value),node.right);
    }

}

static int factorialRecursive(int number){
    if(number<=1){
        return 1;
    }

return number*factorialRecursive(number-1);


}


public static void main (String args[]){




        }





    }




