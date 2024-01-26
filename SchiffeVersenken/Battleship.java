package SchiffeVersenken;


import com.sun.source.tree.WhileLoopTree;

public class Battleship {
    public static int  SIZE = 10;
    public static void main(String args[]) {


    }

    static int distance(final Coordinate start, final Coordinate end) {
        return Math.abs(start.row() - end.row()) + Math.abs(start.column() - end.column());
    }

static Coordinate getRandomCoordinate(){
        return new Coordinate(Utility.getRandomInt(SIZE), Utility.getRandomInt(SIZE));
    }

    static boolean onOneLine(final Coordinate start, final Coordinate end) {
        if (start.row() == end.row() || start.column() == end.column()) {
            return true;
        } else {
            return false;
        }
    }


static void showSeparatorLine(){
        System.out.println("   +-+-+-+-+-+-+-+-+-+-+      +-+-+-+-+-+-+-+-+-+-+");
}


static int getMaxSurroundingColumn(final Coordinate start, final Coordinate end){
        if (end.column() >= start.column() && end.column() < SIZE) {
            return end.column() + 1;
        } else if (start.column() < SIZE) {
            return start.column() + 1;
        }
            return SIZE;
    }


    static int getMaxSurroundingRow(final Coordinate start, final Coordinate end){
      if(start.row() >= end.row() && start.row() < SIZE) {
          return (start.row() + 1);
      } else if (end.row() < SIZE) {
        return (end.row() + 1);
      }
       return (SIZE);
      }



    static int getMinSurroundingColumn(final Coordinate start, final Coordinate end) {
        if (start.column() <= end.column() && start.column()> 0) {
            return (start.column() - 1);
        } else if (end.column() > 0) {
            return (end.column()- 1);
        }
        return (0);
    }



    static int getMinSurroundingRow(final Coordinate start, final Coordinate end){
    if (start.row()<=end.row() && start.row() > 0){
        return(start.row()-1);
    }else if (end.row() > 0);
    return(0);
    }







}



