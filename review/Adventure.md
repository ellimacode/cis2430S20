| method sig | responsibility | instance vars used | other class methods called | objects used with method calls | lines of code |
|:----------:|:--------------:|:------------------:|:--------------------------:|:------------------------------:|:-------------:|
|Adventure(ArrayList<Room> listofRooms, ArrayList<Item> listofItems)| initialize the arraylists of rooms and items |ArrayList<Room> rooms, ArrayList<Item> items| - | - | 2 |
|listAllRooms()| getter/accessor method, returns the arraylist of rooms |ArrayList<Room> rooms | - | - | 1 |
|listAllItems()| getter/accessor method, returns the arraylist of items |ArrayList<Item> items| - | - | 1 |
|getCurrentRoomDescription()| getter/accessor method, returns the description of current room |description| - | - | 1 |
|getCurrentRoom()| getter/accessor method, returns object to room class (currentRoom) |Room currentRoom| - | - | 1 |
|setCurrentRoom()| setter/mutator method, sets the current room in game |Room currentRoom| - | - | 1 |
|quitPlayer()| print out message to user, quitting the game | - | - | - | 1 |
|helpPlayer()| print out valid commands to user (menu) | - | - | - | 7 |
|goPlayer(Command toGo)| moves the user based on direction specified |Room currentRoom| - | Room currentRoom | 15 |
|lookItem(Command lookThing)| allows the user to look at item(s) |Room currentRoom, Item currentItem| - | Room currentRoom, Item currentItem, Command lookThing | 11 |
|lookPlayer()| allows the user to look at room description |Room currentRoom| - | Room currentRoom | 1 |
|toString()| format the string of adventure class, with rooms and items |ArrayList<Room> rooms, ArrayList<Item> items| - | - | 2 |
