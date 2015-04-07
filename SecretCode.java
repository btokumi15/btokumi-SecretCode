public class SecretCode
{
  String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", " "};
  
  //since the phrase is already going to be jumbled up, i decided to add a space or ( " " ) to the "alphabet" array and include that in the shift process.
  //this will not only make the "phrase" a little more jumbled, but will also make the process of detecting spaces in the initial phrase a lot more simple.
  
  private int findIndex(String phrase)
  {
    for (int i = 0; i < 27; i++)
    {
      if (phrase.equals(alphabet[i]))
      {  
        return i;
        //System.out.println("The letter " + alphabet[i]);
      }
    }
    return -1;
  }
  
  public String scramble(String phrase)
  {
    String newphrase = "";
    int shift = (int)((Math.random()*6)+1);
    //int shift = 12; // this is a temporary shift because im trying to get it to at least work with a designated shift before I try to make another method...
    // to use scanner to input the shift
    System.out.println("The phrase has been shifted by the value of " + shift + ".");
    int letter = 0;
    for (int phraseIndex = 0; phraseIndex < phrase.length(); phraseIndex++)
    {
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
  public String unscramble( int shift, String phrase)
  {
    String decodedphrase = "";
    //int shift = 12; // *see scrambler method*
    for (int p = 0; p < phrase.length(); p++)
    {
      int foundIndex = findIndex(phrase.substring(p,p+1));
      int subletter = foundIndex - shift;
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
}