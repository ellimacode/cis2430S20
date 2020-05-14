package adventure;
package org.json; 

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray; 
import org.json.JSONException;

public class Adventure{
    /* you will need to add some private member variables */
    private Room currentRoom = new Room();
    private String description;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private JSONArray jsonArray = new JSONArray();

    /* ======== Required public methods ========== */
        /* note,  you don't have to USE all of these
        methods but you do have to provide them.
        We will be using them to test your code */

    public ArrayList<Room> listAllRooms(){
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                rooms.add(jsonArray.get(i));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }

        return rooms; 
    }

    public ArrayList<Item> listAllItems(){
        try {
            for (int j = 0; j < jsonArray.length(); j++) {
                items.add(jsonArray.get(j));
            }
        } catch (JSONException e) {
                System.out.println(e);
            }

        return items; 
    }

    public String getCurrentRoomDescription(){
        return this.description;

    }

    /* you may wish to add additional methods*/ 
    public Room getCurrentRoom() {
        return this.currentRoom; 
    }
}