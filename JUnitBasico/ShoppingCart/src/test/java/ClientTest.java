import org.junit.Test;
import main.java.Model.Client;

import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {
    List
    private Client mario = new Client(99,"Mario","Rodriguez","dec", null);

    @Test
    public void getFirstName() {
        assertEquals("Mario", mario.getFirstName());
    }
}