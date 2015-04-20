import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class SecretCode 
{
  String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", " "};
  
  Scanner in;
  ArrayList<String> words = new ArrayList<String>();
  
  //im unclear what these actually do, but i believe that ArrayList sends creates a new arraylist for the words that will be imported from words.txt
  
  //since the phrase is already going to be jumbled up, i decided to add a space or ( " " ) to the "alphabet" array and include that in the shift process.
  //this will not only make the "phrase" a little more jumbled, but will also make the process of detecting spaces in the initial phrase a lot more simple.
  
  //for both the scrambler and descrambler, now that i've added a function that prints/adds "#" every time findIndex returns -1, but it still prints the letter value too
  
  private int findIndex(String phrase)
  {
    for (int i = 0; i < 27; i++)
    {
      if (phrase.equals(alphabet[i]))
      {  
        return i;
      }
    }
    return -1; // since the scrambler and decoder work with negative ints as well, if the scanner recieves a capital letter or a number, it returns
    // whatever index of the array is at -1 + shift turning all characters that arent lower case letters into the same letter.
  }
  
  public String scramble(String phrase)
  {
    String newphrase = "";
    int shift = (int)((Math.random()*26)+1);
    System.out.println("The phrase has been shifted by the value of " + shift + ".");
    int letter = 0;
    for (int phraseIndex = 0; phraseIndex < phrase.length(); phraseIndex++)
    {
      if (findIndex(phrase.substring(phraseIndex,phraseIndex+1)) == -1)
      {
        newphrase += "#";
      }
      int addletter = shift + findIndex(phrase.substring(phraseIndex,phraseIndex+1));
      int addletterindex = addletter;
      if (addletter > 27)
      {
        addletterindex = addletter % 27;
      }
      if (addletter == 27)
      {
        addletterindex += 0;
      }
      else addletterindex += 0;
      //System.out.println("changed to " + addletterindex);
      newphrase += alphabet[addletterindex];
    }
    return newphrase;
  }
  public String unscramble(String phrase)
    
    // initially, i wanted to use the words.txt file to search the "decoded phrase" for each shift until it finds a shift that contains real words
    // by using the .contains function (probably) but i feel i'm not fluent enough in java
    
  {
    String decodedphrase = "";
    for (int p = 0; p < phrase.length(); p++)
    {
      if (findIndex(phrase.substring(p,p+1)) == -1)
      {
        decodedphrase += "#"; // this is here to show whenever findIndex may return -1 as a value when i was testing it not working
      }
      int foundIndex = findIndex(phrase.substring(p,p+1));
      int subletter = foundIndex;// - shift;
      int subletterindex = subletter;
      if (subletter < 0)
        //christian helped me because i had 27 here instead of 0 meaning that it added an index of 27 regardless of what number it was, giving me an error every time
      {
        subletterindex = subletter + 27;
      }
      if (subletter == 0)
      {
        subletterindex += 0;
      }
      else subletterindex += 0;
      
      decodedphrase += alphabet[subletterindex];
    }
    return decodedphrase;
  }
  public boolean check(String decodedphrase)
  {
    for (int word = 0; word < words.size(); word++)
    {
      if (decodedphrase.contains(words.get(word)))
      {
        return true;
      }
    }
    else return false;
  }
} 





//