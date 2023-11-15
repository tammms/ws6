package cards;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    //create constructor- create 52 cards systematically -use loop
    private List<cards> deck;

    public Deck(){
        // Create the deck
        deck = new LinkedList<>();
        /*
         why use linkedlist?

         list = interface
         ArrayList, LinkedList = implementation of list

         when class implements the interface, will have to implement all the methods
          - so if class implemetns greetings, class will have all the methods that are definded in the interface
          ***if class implement interface, will have all the methods in the interface

          e.g.
          interface greetings{
            public String hello
          }

          why need an interface, when can implement hello in a class by itself?
          when class implement the interface, must have hello
          but class can implement hello, without the interface - so why still have an interface?
          -- because you want to have all the methods - MUST HAVE
          - if want class to confirm have the methods, create an interface and make the class implement it
          interface is not a class- its just a "contract"
           - implementation (arraylist and linkedlist) is different ways of fulfilling the contract (interface)

         */
        for (String s: Constants.SUITS){

            // this is not good
            //for (String n: Constants.NAMES){}

            for(int i=0; i<Constants.NAMES.length; i++){
                //suit, name, value
                cards card = new cards(suits, Constants.NAMES[i], Constants.VALUES[]);
                deck.add(card);
                /*  one value references another value- so create map
                 NAMES[i] - referes to an array
                 how are array and map the same?
                 - both uses something to access something else
                    --array use index, map use a name to access values

                how are they different?
                - an array uses integer as index, map uses string as index
                *** so array and map are exactly same thing, except for the things they use as key
                                */

            }
        }

    }
    

    public void shuffle(){

    }

    public cards take(){
        List<Card> cards = take(1);
        return cards.get(0);

    }
    


}
