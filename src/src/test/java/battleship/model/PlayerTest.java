package battleship.model;
import battelship.model.Player;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
    public class PlayerTest {

    @DataProvider
    public Object[][] inverseData(){
            return new Object[][]{
                    {Player.FIRST,Player.SECOND},
                    {Player.SECOND,Player.FIRST}

            };
    }

    @Test(dataProvider = "inverseData")
    public void invserseTest(Player given, Player expected){
        Assert.assertEquals(given.inverse(),expected);
    }

}
