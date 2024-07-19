
package battleship.model;
import battelship.model.Coordinate;
import battelship.model.Direction;
import battelship.model.Player;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Coordinate_Test {
    @DataProvider
    public Object[][] testPlus(){
        return new Object[][]{
                {new Coordinate(0,0),new Coordinate(0,1), 1, Direction.EAST},
                {new Coordinate(0,1),new Coordinate(0,0), 1, Direction.WEST},
                {new Coordinate(0,0),new Coordinate(1,0), 1, Direction.NORTH},
                {new Coordinate(1,0),new Coordinate(0,0), 1, Direction.SOUTH},


        };
    }
//Name vom dataProvider in "TestRow"
    @Test(dataProvider = "testPlus")
    public void testPlus(Coordinate given, Coordinate expected, int lenght, Direction direction){
        Assert.assertEquals(given.plus(lenght,direction),expected);
    }
}
