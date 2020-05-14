package adventure;
package org.json; 

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 
import java.io.IOException;
import java.io.FileNotFoundException; 

import java.util.Iterator; 
import java.util.Scanner;
import java.io.FileReader;


public class Game{

    /* this is the class that runs the game.
    You may need some member variables */
    private Adventure adv = new Adventure();

    public static void main(String args[]){

        /* You will need to instantiate an object of type
        game as we're going to avoid using static methods
        for this assignment */

        Game theGame = new Game();
        // 1. Print a welcome message to the user
        System.out.println("WELCOME TO COLOSSAL CASTLE ADVENTURE!");

        // 2. Ask the user if they want to load a json file.
        System.out.println("Would you like to load a json file? (Y or N ONLY");

        /* 3. Parse the file the user specified to create the
        adventure, or load your default adventure*/
        

        // 4. Print the beginning of the adventure

        // 5. Begin game loop here

        // 6. Get the user input. You'll need a Scanner
        Scanner scnr = new Scanner(System.in);
        String inputLine;

        while (true) {
            System.out.println("Would you like to load a json file? (yes or no)");
            inputLine = scnr.nextLine();

            switch(inputLine) {
                case "yes":
                break;

                case "no":
                break;

                default:
                System.out.println("Please enter again.");
                boolean repeat = true; 

                while (repeat) {
                    System.out.println("Would you like to load a json file? (yes or no)");
                    inputLine = scnr.nextLine();

                    switch (inputLine) {
                        case "yes":
                        break;

                        case "no":
                        break;

                        default:
                        repeat = true; 
                    }

                }
                break; 

            }
        }

        

        /* 7+. Use a game instance method to parse the user
        input to learn what the user wishes to do*/
        if (inputLine == "yes") {
            System.out.println("Enter filename:");
            inputLine = scnr.nextLine();

            theGame.loadAdventureJson(inputLine);
        }

        else if (inputLine == "no") {
            System.out.println("Default Adventure");

            theGame.generateAdventure(); //what JSONObject obj???
        }
        

        //use a game instance method to execute the users wishes*/
    

        /* if the user doesn't wish to quit,
        repeat the steps above*/
    }

    /* you must have these instance methods and may need more*/

    public JSONObject loadAdventureJson(String filename){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {
            //read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject mainObject = (JSONObject) obj;

            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return mainObject; 
 
    }
    public Adventure generateAdventure(JSONObject obj) {
        Adventure adv = new Adventure();

        return adv; 
    }

}