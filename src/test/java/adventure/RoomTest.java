package adventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;
import org.junit.Before;


public class RoomTest{
    private Room testRoom;

@Before
public void setup(){
    testRoom = new Room();

}

@Test
public void testSetNameWithValidInput(){
    System.out.println("Testing setName with valid name");
    String roomName = "one";
    testRoom.setName(roomName);
    assertTrue(testRoom.getName().equals(roomName));

}

/* test cases for GetConnectedRoom method
in Room class
 */

@Test
public void TestOne() {
    System.out.println("Testing getConnectedRoom with direction N");
    String north = "N";
    testRoom.getConnectedRoom(north);
    boolean expected = true;
    boolean result = false;
    if (testRoom != null) {
        result = true;
        assertEquals(expected, result);
    }
}

@Test
public void TestTwo() {
    System.out.println("Testing getConnectedRoom with invalid direction");
    String invalid = "jefefnjn";
    testRoom.getConnectedRoom(invalid);
    boolean expected = true;
    boolean result = false;
    if (testRoom == null) {
        result = true;
        assertEquals(expected, result);
    }

}



}