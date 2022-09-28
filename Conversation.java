import java.util.Scanner; /* importing the scanner to read input from user */
import java.util.ArrayList; /* importing lists method */
import java.util.List;
import java.util.Dictionary; /*importing dictionary method */
import java.util.Hashtable; /*importing Hashtable method */ 
import java.util.Set;/*importing methods for the string search  */
import java.io.*; /* importing methods for String Search */
import java.lang.*;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
    // Ask for desired number of rounds from user 
    System.out.println("How many rounds? Choose from 1 to 7. ");
    Scanner sc = new Scanner(System.in); /* create a new scanner */
    String rounds = sc.nextLine(); /*accept answer as number of rounds */
    int r = Integer.parseInt(rounds);

    //list with canned responses that are looped through if not doing mirrored version of previous statement
    List<String> canned_response_list = new ArrayList<String>();
       canned_response_list.add("What's on your mind today?");  
       canned_response_list.add("Interesting, tell me more.");
       canned_response_list.add("How does that make you feel?");
       canned_response_list.add("I understand. What's on the agenda for tomorrow then?");
       canned_response_list.add("Sounds like a good plan. How do you feel about it?");
       canned_response_list.add("What is your favorite show right now?");
       canned_response_list.add("I have heard about it, it is very good.");

    // Hashtable that has the words as keys and mirrored versions of words as a value 
      Hashtable <String, String > mirrorTerms= new Hashtable <String, String>();
        mirrorTerms.put("I", "You");
        mirrorTerms.put("me", "you");
        mirrorTerms.put("am", "are");
        mirrorTerms.put("you", "I");
        mirrorTerms.put("my", "your");
        mirrorTerms.put("your", "my");
        mirrorTerms.put("I'm", "You're");
        mirrorTerms.put(".", "?");


    //While loop that lasts as long as the number of rounds the person asks for 
    int count = 0;
    List<String> transcript = new ArrayList<String>();

    while (count <= r){
      System.out.println(canned_response_list.get(count));
      transcript.add(canned_response_list.get(count)); //saving to transcript
      String response = sc.nextLine();
      transcript.add(response);
      count++;

      // if the response contains any keys from the hashtable then we switch them out with the value to give our answer 
      // parse through all words in the sentence then compare them against the keys in hashtable
      // for each key in the hashtable search for it in the response 
      Set<String> keys = mirrorTerms.keySet();
      List<String> values_already_found = new ArrayList<String>();
      for(String key: keys){
        boolean contains_word = response.contains(key);
        boolean contains_value = values_already_found.contains(key.toLowerCase());
        //System.out.println(key + contains_word + contains_value);
        if (contains_word && !contains_value ){
            // replace key with value 
            response = response.replace(key,mirrorTerms.get(key));
            // reply with switched sentence
            values_already_found.add(mirrorTerms.get(key).toLowerCase()); 
          }
       
      }
      System.out.println(response);
      transcript.add(response);
    }

    System.out.println("Okay, Bye!");
    System.out.println("Transcript:"); 
    for (String sentence: transcript){
      System.out.println(sentence);
    }


  }
}
