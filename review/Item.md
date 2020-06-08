| method sig | responsibility | instance vars used | other class methods called | objects used with method calls | lines of code |
|:----------:|:--------------:|:------------------:|:--------------------------:|:------------------------------:|:-------------:|
|Item(String name, String info)|initialize name and description of item|itemName, description| - | - | 2 |
|Item(Integer tag, String name, String info)|initialize id, namd description of item|itemName, description, id| - | - | 3 |
|setItemName(String name)|mutator/setter, set the item's name|itemName| - | - | 1 |
|getName()|accessor/getter, return the item's name|itemName| - | - | 1 |
|setId(Integer num)|mutator/setter, set the item's id| id | - | - | 1 |
|getId()|accessor/getter, return the item's id| id | - | - | 1 |
|setDescription(String info)|mutator/setter, set the item's description|description| - | - | 1 |
|getLongDescription()|accessor/getter, return the long description of item|description| - | - | 1 |
|getContainingRoom()|returns a reference to the room that contains the item| room | - | - | 1 |
|setContainingRoom(Room containedRoom)|mutator/setter, set the contained room with item|room| - | - |1|
|toString|format string for item, with name and description|itemName, description| - | - | 1 |
