package battleship.model;
import battelship.model.Coordinate;
import battelship.model.Player;
import battelship.model.Event;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Shot_Test {
    @DataProvider
    public Object[][] compareTo() {
        return new Object[][]{
                {new Event(1, 1), new Event(1, 1)},
                {new Event(1, 0), new Event(1, 0)}

        };
    }

    @Test(dataProvider = "compareTo")
    public void compareTo(Event given, Event expected) {
        Assert.assertEquals(given.compareTo(), expected);
    }

/*

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
**/
}