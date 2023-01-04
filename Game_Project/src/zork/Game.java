package zork;

import java.lang.Math;
/**
 * Class Game - the main class of the "Zork" game.
 *
 *
 * Author:  
 * Version: 
 * Date:    
 * 
 *  This class is the main class of the "Zork" application. Zork is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */

public class Game {
	//Attribute
	private Parser parser;
	private Room currentRoom;
	private Room erdgeschoss, level1, level2, level3, level4, schatzraum;
	private QuizMaster quma;


	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		
		parser = new Parser();


		// Alle Räumlichkeiten erstellen und verlinke alle Ausgänge
		erdgeschoss = new Room("\t # Du befindest dich im Erdgeschoss #\n \t # Geh nach unten(down) um den Magie-Transporter zu verwenden! #");
		level1 = new Room("\t # Du befindest dich im Level1 #");
		level2 = new Room("\t # Du befindest dich im Level2 #");
		level3 = new Room("\t # Du befindest dich im Level3 #");
		level4 = new Room("\t # Du befindest dich im Level4 #");
		schatzraum = new Room("\t # Du befindest dich im Schatzraum, der Schatz ist nahe! #");


		// initialisiere raum ausgänge
		erdgeschoss.setExits(level1, teleporter());
		level1.setExits(level2, erdgeschoss);
		level2.setExits(level3, level1);
		level3.setExits(level4, level2);
		level4.setExits(schatzraum, level3);
		schatzraum.setExits(erdgeschoss, erdgeschoss);

		currentRoom = erdgeschoss; // Beginn des Spiels
		
	}


	/**
	 *  Main play routine.  Loops until end of play.
	 */
	public void play() {
		printWelcome();

		quma = new QuizMaster();

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);

			if (currentRoom.equals(level1)) {
				quma.QuestionForLevel1();
				if (quma.getAnswer() == "a") {
					finished = false;
				}
			}

			if (currentRoom == level2){
				quma.QuestionForLevel2();
				if (quma.getAnswer() == "d") {
					finished = false;
				}
			}
			if (currentRoom.equals(level3)){
				quma.QuestionForLevel3();
				if (quma.getAnswer() == "c") {
					finished = false;
				}
			}
			if (currentRoom.equals(level4)){
				quma.QuestionForLevel4();
				if (quma.getAnswer() == "b") {
					finished = false;
				}
			}
			if (currentRoom.equals(schatzraum)) {
				//Prüfgebiet - Hat der Spieler bereits 5 Sterne?
				quma.QuestionFinal();
				quma.worthytest();
			}

		}
		System.out.println("\t # Vielen Dank fürs Spielen und Auf wiedersehen! # ");
	}

	/**
	 * Print out the opening message for the player.
	 */
	public void printWelcome() {
		System.out.println();
		System.out.println("Willkommen zum 'Turm der Quiz-Master'");
		System.out.println("Dieses Spiel ist ein simpler Quiz Spiel.");
		System.out.println("Dein Ziel? Der Schatz der am ende dieses Turm liegt und auf ein Champion wartet");
		System.out.println("Schreiben Sie 'help' falls Sie hilfe brauchen.");
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * If this command ends the game, true is returned, otherwise false is
	 * returned.
	 */
	public boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println("Ich verstehe nicht was sie meinen...");
			return true;//false gelöscht
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("stars")){
				quma.printSternen();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			if (command.hasSecondWord()) {
				System.out.println("Quit what?");
			} else {
					return true; // signal that we want to quit
			}
		}
		return false;
	}

	 /**
	 * Print out some help information.
	 * Here we print some stupid, cryptic message and a list of the 
	 * command words.
	 */
	public void printHelp() {
		System.out.print("Du bist ein Abenteurer auf der Suche nach dem legändern Schatz");
		System.out.println(", bist du bereit für die QuizMaster?");
		System.out.println();
		System.out.println("Deine Eingabebefehle lauten:");
		System.out.println(parser.showCommands());
	}

	/** 
	 * Try to go to one direction. If there is an exit, enter the new
	 * room, otherwise print an error message.
	 */
	public void goRoom(Command command) {
		// Ohne 2.Wort, weiss man nicht wohin
		if (!command.hasSecondWord()) {
			System.out.println("Wohin? Bitte schreibe 'go down' oder 'go up'");
		} else {
			
			String direction = command.getSecondWord();
	
			// Versuche Raum zu verlassen
			Room nextRoom = currentRoom.nextRoom(direction);
	
			if (nextRoom == null)
				System.out.println("Keine Tür!");
			else {
				currentRoom = nextRoom;
				System.out.println(currentRoom.longDescription());
			}
		}
	}

	public Room teleporter() {

		//Variablen für Begrenzungen 1-4
		int min = 1;
		int max = 4;

		//Generiere einen zufälligen int Wert von 1 bis 4
		int rand = (int) Math.floor(Math.random() * (max - min + 1) + min);

		//CurrentRomm einteilen mit dem zufälligen, generierten Wert
		switch (rand) {
			case 1:
				currentRoom = level1;
				break;
			case 2:
				currentRoom = level2;
				break;
			case 3:
				currentRoom = level3;
				break;
			case 4:
				currentRoom = level4;
				break;
		}
		return currentRoom;
	}

}