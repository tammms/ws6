package cards;
public class cards {

/* should generate getters only, no setters - cannot change value of car - prevents cheating\

if no setter, will need a constructor
since cannot change the value, can assign value as final
- members that are final have to be initialised in the constructor
** Value object = design when you cannot change the value 

*/ 

private final String suits;
private final String name;
private final Integer value;

public cards(String suits, String name, Integer value){
   this.suits = suits;
   this.name = name;
   this.value = value;
}

public String getSuits() {
   return suits;}

public String getName() {
   return name;}

public Integer getValue() {
   return value;}


//when want to create a value object:

public record cards(String suits, String name, Integer value){}



}

/*
 * model:
 - want: shuffle and draw cards
 
 Attributes of a card:
 suits: DIAMOND, CLUB, HEARTS, SPADE
 Name: A-10, J, Q, K
 vakue: 1-10, 10, 10, 10

 many cards (a deck) - collection of cards:  List or Set
    - should not choose a Set - this model will limit to playing games with only 1 deck of cards
    - choose List - what type of list? - how you want to implement it (draw from top only or anywhere)
    - queue (first in, first out - add from back, draw from front) or stack (add on the top, draw from bottom)
    -- both are suitable

 */
