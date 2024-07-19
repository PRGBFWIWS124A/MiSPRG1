package battleship.model;
import battelship.model.Coordinate;
import battelship.model.Player;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class plusCollumnRowTest {
    @DataProvider
    public Object[][] ColumnTest() {
        return new Object[][]{
                {new Coordinate(10, 10), new Coordinate(11, 10)},
                {new Coordinate(11, 10), new Coordinate(12, 10)}

        };
    }
    @Test(dataProvider = "ColumnTest")
    public void ColumnTest(Coordinate given, Coordinate expected){
        Assert.assertEquals(given.plusColumn(1),expected);
    }



    @DataProvider
    public Object[][] RowTest() {
        return new Object[][]{
                {new Coordinate(10, 10), new Coordinate(10, 11)},
                {new Coordinate(12, 15), new Coordinate(12, 16)}

        };
    }
    @Test(dataProvider = "RowTest")
    public void RowTest(Coordinate given, Coordinate expected){
        Assert.assertEquals(given.plusRow(1),expected);
    }
}
