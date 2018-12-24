import database.DBSingleton;
import org.junit.Test;

public class TestClass {
    @Test
    public void testFunction(){
        DBSingleton.getInstance().getConnection();
    }
}
