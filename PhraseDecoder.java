import java.util.Scanner;

public class PhraseDecoder
{
    public static void main(String[] args){
      
      Scanner input = new Scanner(System.in);
      
      //System.out.println("Enter the shift of the phrase.");
      
      //String shiftparse = input.nextLine();
      //int shift = Integer.parseInt(shiftparse);
      
      System.out.println("Enter the phrase you want to decode.");
      
      String phrase = input.nextLine();
      
      SecretCode code = new SecretCode();
      String decodedPhrase = code.unscramble(phrase );
      System.out.println(decodedPhrase);
    }
}

      
      