import java.util.Scanner;
public class TicTacToe
{
    public static void Main(String[] args)
    {
        // Create the board
        String[] spaces = new String[9];

        // Initialize all elements in spaces to " ", so no null issues
        for (int i = 0; i < spaces.length; i++)
        {
            spaces[i] = " ";
        }

        // Determine the winner, starts off with no one
        String winner = null;
        String letter = "X";
        Scanner scan = new Scanner(System.in);
        while (winner == null && !IsFull(spaces)) // As long as no one has won (and no ties), keep going
        {
            // Print board
            PrintSpaces(spaces);

            // Have the player input a space
            int space = scan.nextInt();
            boolean validSpace = spaces[space].equals(" "); // Check to see if that space is empty
            while (!validSpace) // Keep letting them try until the space is valid
            {
                space = scan.nextInt(); // Have the player input a space
                validSpace = spaces[space].equals(" "); // Check to see if that space is empty
            }

            // Put the letter in the specified space
            spaces[space] = letter;

            // Check for winner and switch letters if necessary
            if (FindWinner(spaces, letter))
            {
                // Setting the winner will break out of the loop
                winner = letter;
            }
            else
            {
                // If no one won, switch the letter to the next player
                if (letter.equals("X"))
                {
                    letter = "O";
                }
                else
                {
                    letter = "X";
                }
            }   

        }

        PrintSpaces(spaces);
        if (winner != null) // Make sure the loop quit for a win
        {
            System.out.println("Winner is: " + winner);
        }
        else // If loop quit for a tie
        {
            System.out.println("Draw.");
        }
    }

    public static boolean FindWinner(String[] spaces, String letter)
    {
        return
        (spaces[0].equals(letter) && spaces[1].equals(letter) && spaces[2].equals(letter)) || // First row
        (spaces[3].equals(letter) && spaces[4].equals(letter) && spaces[5].equals(letter)) || // Second row
        (spaces[6].equals(letter) && spaces[7].equals(letter) && spaces[8].equals(letter)) || // Third row
        (spaces[0].equals(letter) && spaces[3].equals(letter) && spaces[6].equals(letter)) || // First col
        (spaces[1].equals(letter) && spaces[4].equals(letter) && spaces[7].equals(letter)) || // Second col
        (spaces[2].equals(letter) && spaces[5].equals(letter) && spaces[8].equals(letter)) || // Third col
        (spaces[0].equals(letter) && spaces[4].equals(letter) && spaces[8].equals(letter)) || // Top-left to bottom-right
        (spaces[2].equals(letter) && spaces[4].equals(letter) && spaces[6].equals(letter)); // Top-right to bottom-left
    }

    public static void PrintSpaces(String[] spaces)
    {
        System.out.println(spaces[0] + " | " + spaces[1] + " | " + spaces[2]);
        System.out.println("_________");
        System.out.println(spaces[3] + " | " + spaces[4] + " | " + spaces[5]);
        System.out.println("_________");
        System.out.println(spaces[6] + " | " + spaces[7] + " | " + spaces[8]);
        System.out.println("\n\n");
    }

    public static boolean IsFull(String[] spaces)
    {
        for (int i = 0; i < spaces.length; i++)
        {
            if (spaces[i].equals(" "))
            {
                return false;
            }
        }

        return true;
    }

}