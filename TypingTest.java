//This is the utility that allow a user to have input functionality. 

import java.util.Scanner;


// Java starts with a class that has to be the file name. So this file is SpeedTypingTest.java
public class TypingTest {
    //This is another section that starts a java file. It is just like a __main__ for python. 
    public static void main(String[] args) {

        //sets up the scanner variable for the user input.
        Scanner scanner = new Scanner(System.in);

        // This is the words for the accuracy typing test. 
        String [] words = {"a", "at", "by", "go", "no", "on", "or", "it", "is", "to",
            "can", "one", "are", "all", "for", "but", "not", "now", "get", "out",
            "have", "like", "just", "from", "with", "this", "that", "will", "your", "make",
            "when", "time", "more", "what", "some", "there", "would", "could", "should", "them",
            "other", "about", "their", "these", "which", "after", "where", "then", "think", "because",
            "before", "could", "through", "should", "little", "people", "always", "without", "another", "between",
            "something", "everything", "everyone", "anything", "everyone", "everywhere", "everybody", "everyday", "together", "different",
            "understand", "information", "communication", "relationship", "development", "experience", "organization", "opportunity", "interesting", "environment",
            "unfortunately", "congratulations", "significance", "manufacturing", "responsibility", "consideration", "intelligence", "individual", "determination", "contribution",
            "congratulations", "communication", "organization", "opportunity", "development", "environment", "manufacturing", "responsibility", "consideration", "intelligence",
            "individual", "determination", "contribution", "significant", "unfortunately", "understanding", "information", "relationship", "experience", "interesting"};
        
        
        
        //Passage for the speed typing test.  "Im a little teapot."
        String passage = "I'm a little teapot, short and stout. Here is my handle, here is my spout. When I get all steamed up, hear me shout. Tip me over and pour me out.";
        //asks user to enter a 1 or 2 for a speed test or accuracy test. 
        System.out.println("Would you like to test for speed or accuracy? Type a 1 for speed test or a 2 for accuracy test.");

        int test = scanner.nextInt();

        if (test == 1) {
            //A message to display for the user benefit.
        System.out.println("Type the following passage:");  

        //prints out the passage to be typed (I'm a little teapot lyrics)
        System.out.println(passage);
        //Message displayed to user to press enter to start test and end test. The scanner.nextLine() is used to take the enter inputted by the user. 
        System.out.println("Press Enter when you are ready to start and enter when you are finished to end the test.");
        
        scanner.nextLine();
        scanner.nextLine();

        System.out.println("Started typing test. Type the passage now:");
        //After the enter is press a time stamp is taken for the current time. 
        long startTime = System.currentTimeMillis();
        //Takes the passage typed by the user to be compared to the original passage.
        String userInput = scanner.nextLine();
        //after the passage is finished then another time stamp is taken. 
        long endTime = System.currentTimeMillis();
        //The two time stamps are then subtracted form one another to get an elapsed time. 
        long elapsedTime = endTime - startTime;

        //Sets integer variables for the passage lengths and correctly typed characters.
        int passageLength = passage.length();
        int userInputLength = userInput.length();
        int correctChars = 0;
        //The for loop compares the users passage letter by letter against the original passage counting the correct letters. The Math.min function will set the loop for the smaller passage. So if one word was typed then it would just loop for the length of one word. 
        for (int i = 0; i < Math.min(passageLength, userInputLength); i++) {
            if (passage.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }

        // The double or decimals variables calculate the typing accuracy and words per minute. 
        double accuracy = (double) correctChars / passageLength * 100;
        double wordsPerMinute = (double) userInputLength / elapsedTime * 60000 / 5;


        //Then the user is given the results of their typing test.
        System.out.println("Test completed! Great Job");
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Words per minute: " + wordsPerMinute);

        } else if (test == 2) {
            int correctWords = 0;
            System.out.println("Welcome to the accuracy Typing Test!");
            System.out.println("Type the following words as correctly as you can:");

            // for (String word : words) {
            //     System.out.print(word + " ");
            // }
            System.out.println();
    
            System.out.println("Press Enter when you're ready to start.");
            scanner.nextLine();
    
            long startTime = System.currentTimeMillis();
    
            for (String word : words) {
                System.out.print(word);
                System.out.println();
                String typedWord = scanner.next();
                if (!word.equals(typedWord)) {
                    System.out.println("Incorrect word. Test terminated.");
                    long endTime = System.currentTimeMillis();
                    double totalTime = (endTime - startTime) / 1000;
    
                    System.out.println("Congratulations! You completed the test in " + totalTime + " seconds.");
                     System.out.println("With " + correctWords + " words typed correctly!!");
                    return;
                } else {
                    correctWords += 1;
                }
            }
    
            
             
        
        } else {
            System.out.println("Sorry invalid input.." + test);
        }   
        scanner.close();    
    }

}
