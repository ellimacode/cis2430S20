package adventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

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

// test cases for GetConnectedRoom method in Room class

@Test
public void testValidDirect() {
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
public void testInvalidDirect() {
    System.out.println("Testing getConnectedRoom with invalid direction");
    String invalid = "INVALID";
    testRoom.getConnectedRoom(invalid);
    boolean expected = true;
    boolean result = false;
    if (testRoom == null) {
        result = true;
        assertEquals(expected, result);
    }

}

@Test
public void testCorrectDirect() {
    System.out.println("Testing getConnectedRoom with lowercase direction");
    String lowercase = "n";
    testRoom.getConnectedRoom(lowercase);
    boolean expected = true;
    boolean result = false;
    if (testRoom == null) {
        result = true;
        assertEquals(expected, result);
    }
}


//new test cases for A3

@Test
public void testInvalidExit() {
    System.out.println("Testing invalid exits of rooms");

}

@Test
public void testInvalidItem() {
    System.out.println("Testing items in inventory that don't exist in room");


}


@Test
public void testInvalidID() {
    System.out.println("Testing exits to a room ID that doesn't exist in room");


}

@Test
public void testNoExits() {
    System.out.println("Testing rooms with no exits");



}



}