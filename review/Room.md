| method sig | responsibility | instance vars used | other class methods called | objects used with method calls | lines of code |
|:----------:|:--------------:|:------------------:|:--------------------------:|:------------------------------:|:-------------:|
|Room(Integer tag, String name, String shortDesc, String longDesc)|initialize instance variables, based on parameters passed in|id, roomName, shortDescription, longDescription| - | - | 6 |
|Room(String name, String info)|initialize, set Room name and long description|roomName, longDescription| - | - | 4 |
|listItems()|accessor/getter, return arraylist of items|contents| - | - | 1 |
|setName(String name)|mutator/setter, set Room name| roomName | - | - | 1 |
|getName()|accessor/getter, return Room name| roomName | - | - | 1 |
|setId(Integer num)|mutator/setter, set Room Id| id | - | - | 1 |
|getId()|accessor/getter, return Room Id| id | - | - | 1 |
|setLongDescription(String info)|mutator/setter, set Room long description| longDescription | - | - | 1 |
|getLongDescription()|accessor/getter, return Room long description| longDescription | - | - | 1 |
|getConnectedRoom(String direction)|return Room based on direction, from arraylist of rooms|ArrayList<Room> rooms| - | - | 1 |
|addConnectedRoom(String direction, Integer tag)|populate hashmap, add Room to hashmap of rooms, based on JSON file|HashMap<String, Integer> jsonRooms| - | - | 1 |
|setExits(Room northExit, Room southExit, Room eastExit, Room westExit, Room upExit, Room downExit)|populate arraylist of rooms, based on direction|ArrayList<Room> rooms| - | - | 18 |
|addItem(Item item)|populate arraylist of items|ArrayList<Item> contents| - | - | 1 |
|getItem(int i)|return Item from arraylist, based on index|ArrayList<Item> contents| - | - | 1 |
|containsItem(Item item)|returns true if item is in arraylist, return false otherwise|ArrayList<Item> contents| - | - | 4 |
|toString()|format string for Room class, specifying name and description| roomName, longDescription | - | - | 1 |