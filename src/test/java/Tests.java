import com.connection.ConnectionDB;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class Tests {
    @Test
    public void testExample(){
        ConnectionDB connectionDB = new ConnectionDB();
        Connection c = connectionDB.getConnection();
        Assert.assertNotNull(c);
    }
}
