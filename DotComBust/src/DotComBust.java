import java.util.*;
public class DotComBust {
	// declare and initialize the variables we'll need
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	
private void setUpGame() {
	// first make some dot coms and give them locations
	// make three DotCom objects, give 'em names and stick 'em in the ArrayList
	DotCom one = new DotCom();
	one.setName("Pets.com");
	DotCom one = new DotCom();
	one.setName("eToys.com");
	DotCom one = new DotCom();
	one.setName("Go2.com");
	dotComsList.add(one);
	dotComsList.add(two);
	dotComsList.add(three);
	
	// print brief instructions for user
	System.out.println("Your goal is to sink three dot coms.");
	System.out.println("Pets.com, eTyos,com, Go2.com");
	System.out.println("Try to sink them all in the fewest number of guesses");
	
	for (DotCom dotComToSet : dotComsList) { // repeat with each DotCom in the list
		ArrayList<String> newLocation = helper.placeDotCom(3); // ask the helper for a DotCom location
		// get the setter method on this DotCom to give it the location you just got from the helper
		dotComToSet.setLocationCells(newLocation);
	} // close for loop
} // close setUpGame method


	private void startPlaying() {
		while(!dotComsList.isempty()) { // as long as the DotCom list is not empty
			String userGuess = helper.getUserInput("Enter a guess"); // get user input
			checkUserGuess(userGuess); // call our own checkUserGuess method
		} // close while
		finishGame();
	} // close startPlaying method
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++; //increment the number of guesses the user has made
		String result = "miss"; // assume it's a 'miss' unless told otherwise
		
		// ask the DotCom to check the user guess, looking for a hit (or kill)
		for (DotCom dotComToTest : dotComsList) { 
			result = dotComToTest.checkYourSelf(userGuess); //   
			if (result.equals("hit")) {
				break; // get out of the loop early, no point in testing the others
			}
		} // close for
		System.out.println(result);
	} // close method

	// print a message telling the user how she did in the game
    private void finishGame() {
    	System.out.println("All Dot Coms are dead! Your stock is now worthless.");
    	if (numOfGuesses <= 18) {
    		System.out.println("It only took you " + numOfGuesses + "guesses.");
    		System.out.println("You got out before your option sank");
    	} else {
    		System.out.println("Took you long enough." + numOfGuesses + "Guesses.");
    		System.out.println("Fish are dancing with your options.");
    	}
    } // close method
    
    public static void main (String[] args) {
    	DotComBust game = new DotComBust(); // create the game object
    	game.setUpGame(); // tell the game object to set up the game
    	// tell the game object to start the main game play loop (keep asking for user input
    	// and checking the guess)
    	game.startPlaying();
    } // close method

}
