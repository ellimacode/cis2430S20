| method sig | responsibility | instance vars used | other class methods called | objects used with method calls | lines of code |
|:----------:|:--------------:|:------------------:|:--------------------------:|:------------------------------:|:-------------:|
|Player()| initialize arraylist of items (inventory) |ArrayList<Item> inventory|- |-| 1|
|Player(String player)| initialize arraylist of items (inventory) and the name of player |ArrayList<Item> inventory, String name|- |-| 2|
|setName(String playerName)| setter/mutator method, sets the name of player |String name|- |-| 1|
|getName()| getter/accessor method, returns the name of player |String name|- |-| 1|
|addInventory(Item item)| populates the arraylist of items, checks for repeats |ArrayList<Item> inventory|- |-| 3|
|getInventory| getter/accessor method, returns the arraylist of items |ArrayList<Item> inventory|- |-| 1|
|removeItem(Item item)| remove an element from arraylist |ArrayList<Item> inventory|- |-| 1|
|setLocation(String place)| setter/mutator method, sets the location of player |String location|- |-| 1|
|getLocation()| getter/accessor method, returns location of player |String location|- |-| 1|
|setCurrentRoom(Room room)| setter/mutator method, sets the player's current room |Room currentRoom|- |-| 1|
|getCurrentRoom()| getter/accessor method, returns the player's current room |Room currentRoom|- |-| 1|
|setSaveName(String save)| setter/mutator method, sets the player's name to save game |String saveName|- |-| 1|
|getSaveName()| getter/accessor method, returns the player's saved name |String saveName|- |-| 1|
|numItems()| returns the number of elements in arraylist |ArrayList<Item> inventory|- |-| 1|