import java.util.Scanner;

public class PhraseScrambler
{
    public static void main(String[] args){
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter the phrase you want to encode.");
      
      String phrase = input.nextLine();
      
      SecretCode message = new SecretCode();
      String encodedPhrase = message.scramble(phrase);
      System.out.println("The new phrase is:" + encodedPhrase + ".");
    }
}