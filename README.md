# AdventureGame
* Adventure Game, created using Trees and Nodes
* Created June 11th, 2019

-------------------------------------------------------------------------------

## Overview
* Adventure Game is an RPG-like game where every choice you make has a path and consequence.
* In this game, you are walking through a maze. You will either escape or attacked by a minotaur.
* This game was created using generic queues and generic linked lists, as well as generic sets.
* Load the book1.csv file in Driver (the main file), in the play function.

-------------------------------------------------------------------------------

### Classes

1. Driver.java
 * Main file which serves as the program driver
 * Functions:
   * play()
     * This function launches the game
   * playFrom()
     * This function enables the ability to skip pages in game
   * showPath()
     * This function shows the path that the player has made at the end of the game
   * cheat(int desiredEnding)
     * This function allows the player to cheat on how to get to an ending of the game

2. PageNode.java
 * This class is the data structure for the "Node" class
 * Constructors:
   * PageNode(int pageNumber)
     * This constructor takes in a page number and sets pageNumber to the given value
   * PageNode(int pageNumber, String text)
     * This constructor takes in a page number and text and sets pageNumber and text to the given value
 * Functions:
   * getPageNumber()
     * This function returns the page number as an integer
   * getText()
     * This function returns the text as a string
   * setText(String text)
     * This function sets text to be the given text
   * isEnding()
     * This function checks whether the ending has been achieved
   * setEnding()
     * This function sets the ending to be isEnding() / true
   * getChildren()
     * This function returns the children of the node as a Set< PageNode >
   * setChildren(Set<PageNode> children)
     * This function sets the children in the set to be the given children
   * toString()
     * This function returns the data at the page number as a string


3. PageTree.java
 * This class is the data structure of the binary tree
 * Constructor: PageTree(PageNode root)
   * This constructor takes in a root of class PageNode and sets it as the field root
 * Functions:
   * setRoot(PageNode root)
     * This function sets the root to be the given root
   * getNode(int pageNumber)
     * This function returns the node at the given page number as a PageNode data type
   * getRoot()
     * This function returns the root of the tree as a PageNode data type
   * cheat(int desiredEnding)
     * This function is the recursive function for helper function
   * helper(LinkedList<PageNode> path, PageNode current, int desiredEnding, List<PageNode> result)
     * This function helps with the cheat functionality


4. ParseFile.java
 * This class reads the csv file for the game to run
 * Function: parseFile(String filePath) throws IOException
   * This function reads the given csv file and separates its contents to a set


5. Playthrough.java
 * This class handles the flow of the game
 * Constructor: Playthrough(PageTree book)
   * This constructor takes in a book of PageTree class and sets it to the field's book
 * Functions:
   * getChoices()
     * This function returns the choices in the story as a LinkedList< PageNode > data type
   * playGame()
     * This function is the recursive function for playGame(String option)
   * playGame(String option)
     * This function starts the game from the given option
   * truncateChoices(int pageNumber)
     * This function removes everything after the given page
   * getOption(PageNode input)
     * This function returns the option for the next path as a string







