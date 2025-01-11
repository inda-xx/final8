![Task Image](images/task_image_20250111_145736.png)

### Task: Create a Simple Game Application

#### **Overview**
Your task is to design and implement a simple game application using Java. The game should have three core functionalities: **player movement**, a **scoring system**, and **enemy interactions**. To make the game dynamic and reusable, you will load some of the game data (e.g., enemy positions, player starting point, or level layout) from an external file. This project will challenge your skills in class design, file handling, and creative programming.

This task will integrate several key learning goals:
1. **Using Data from Files to Instantiate Objects**: You will read game data from a file and use it to create and initialize objects in your game.
2. **Designing Classes**: You will design structured, reusable, and intuitive Java classes for key game components like `Player`, `Enemy`, and `Game`.
3. **Programming Creatively**: You will experiment with your game mechanics, implement creative solutions, and refine your program to make it fun and functional.

---

### **Requirements**
1. **Player Movement**:
   - Implement basic controls to allow the player to move up, down, left, and right on a 10x10 grid.
   - Prevent the player from moving out of bounds.
   
2. **Scoring System**:
   - Implement a scoring mechanism where the player earns points by collecting items.
   - Display the current score at the end of the game.

3. **Enemy Interactions**:
   - Enemies should move randomly on the grid.
   - If a player collides with an enemy, the game ends.

4. **Dynamic Data Loading**:
   - Load game setup data (e.g., initial player and enemy positions, grid size, or collectible item positions) from a text file.
   - Ensure proper error handling for file reading.

5. **Creative Enhancements**:
   - Add at least one creative feature of your choice (e.g., multiple levels, power-ups, or a timer).

---

### **Step-by-Step Instructions**

#### **Step 1: Design Your Classes**
Start by identifying the main components of your game. At a minimum, you should have the following classes:
1. **`Player`**:
   - Attributes: position (x, y), score.
   - Methods: move(), updateScore().

2. **`Enemy`**:
   - Attributes: position (x, y).
   - Methods: moveRandomly().

3. **`Game`**:
   - Attributes: grid size, player, list of enemies, list of items.
   - Methods: loadGameData(), startGame(), checkCollisions(), displayScore().

#### Example Skeleton Code
```java
public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(String direction) {
        switch (direction) {
            case "up": this.y--; break;
            case "down": this.y++; break;
            case "left": this.x--; break;
            case "right": this.x++; break;
        }
    }

    public void updateScore(int points) {
        this.score += points;
    }

    // Getters and other utility methods
}
```

#### **Step 2: Create a File to Load Game Data**
Create a text file (e.g., `gameData.txt`) that contains the initial positions of the player, enemies, and items. For example:
```
# Player position
Player: 1, 1

# Enemy positions
Enemy: 3, 5
Enemy: 7, 2

# Item positions
Item: 4, 4
Item: 6, 8
```

#### **Step 3: Implement File Reading**
Use Java's file I/O classes to read the game data and initialize the game objects. Handle invalid or missing data gracefully.

#### Example Code Snippet
```java
import java.io.*;
import java.util.*;

public class Game {
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<int[]> items = new ArrayList<>();

    public void loadGameData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Player")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    player = new Player(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                } else if (line.startsWith("Enemy")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    enemies.add(new Enemy(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                } else if (line.startsWith("Item")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    items.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading game data: " + e.getMessage());
        }
    }
}
```

---

#### **Step 4: Implement Game Logic**
- **Player Movement**: Use keyboard input to move the player on the grid. Prevent the player from moving outside the grid boundaries.
- **Enemy Movement**: Write a method to move enemies randomly after each player move.
- **Collision Detection**: Check if the player’s position collides with an enemy or item.
  - If the player collects an item, update their score and remove the item from the grid.
  - If the player collides with an enemy, end the game.

---

#### **Step 5: Add Creative Enhancements**
Use your creativity to make the game more engaging. Here are some ideas:
- Add a timer that counts down, requiring the player to collect items before time runs out.
- Introduce a "power-up" item that temporarily disables enemy movement.
- Create multiple levels, where each level has different enemy behaviors or grid sizes.

---

### **Deliverables**
1. **Source Code**:
   - Submit all your `.java` files.
   - Ensure your code is well-documented with comments explaining your logic.

2. **Game Data File**:
   - Include the text file (`gameData.txt`) used to initialize your game.

3. **README**:
   - Write a brief description of your game.
   - Explain how to run the program and control the player.
   - Describe any creative features you added.

---

### **Evaluation Criteria**
1. **Correctness (40%)**:
   - The game functions as described (player movement, scoring system, and enemy interactions work correctly).
   - File data is correctly loaded, and objects are instantiated based on the file.

2. **Class Design (30%)**:
   - Classes are well-structured, cohesive, and follow object-oriented principles.
   - Methods and attributes are appropriately used.

3. **Creativity (20%)**:
   - Creative features are implemented and enhance

### Exercise 1: Understanding File I/O and Object Instantiation (Theoretical)

#### **Objective**  
This exercise will help you understand how data is read from a file, parsed, and used to create objects in Java. You will analyze a scenario and answer questions to demonstrate your grasp of file handling and object instantiation.

---

#### **Scenario**  
Imagine you are developing a game where the initial positions of the player, enemies, and collectible items are stored in a file. The file `gameData.txt` looks like this:

```
Player: 2, 3
Enemy: 4, 5
Enemy: 6, 7
Item: 3, 2
Item: 5, 5
```

The goal is to read this file, extract the data, and use it to create objects for the game. For example:
- A `Player` object is created with the position `(2, 3)`.
- Two `Enemy` objects are created with positions `(4, 5)` and `(6, 7)`.
- Two item positions `(3, 2)` and `(5, 5)` are stored in a list for later use.

---

#### **Questions**

1. **File Parsing**  
   The first step in handling `gameData.txt` is parsing its content.  
   a. What is the purpose of parsing in this context, and why do we need to split the lines of the file?  
   b. Write the pseudocode for how you would extract the coordinates (e.g., `(2, 3)`) from a line like `Player: 2, 3`.  
   c. Why is it important to handle errors (e.g., missing or malformed lines) when reading the file? What exception handling techniques would you use in Java?

2. **Object Instantiation**  
   After parsing the file, we use the extracted data to create objects.  
   a. Explain the process of instantiating a `Player` object with the position `(2, 3)`. What steps are involved in mapping the parsed data to an object?  
   b. Suppose the file contains two players instead of one. How would you modify your code to handle multiple `Player` objects? What data structure would you use to store them, and why?  

3. **Data Integrity**  
   a. Describe a situation where the data in `gameData.txt` might be invalid or incomplete. For example, what if one of the enemy lines is `Enemy: ,`?  
   b. How would you ensure the integrity of the data being read from the file? Suggest a strategy to validate the data before creating objects.  

4. **Design Considerations**  
   a. What are the advantages of storing game data in an external file rather than hardcoding it into your Java program?  
   b. If the grid size of the game changes (e.g., from 10x10 to 20x20), what changes would you need to make to your object instantiation process?  

---

**Deliverable**: Submit written answers to the questions. Your answers should demonstrate a clear understanding of file parsing, object instantiation, data validation, and design considerations.

---

### Exercise 2: Principles of Class Design (Theoretical)

#### **Objective**  
This exercise focuses on designing structured, reusable, and intuitive Java classes. You will analyze and critique class design, ensuring that you understand the principles of object-oriented programming (OOP) before implementing them in code.

---

#### **Scenario**  
You are tasked with designing the main components of a simple game. The game has the following requirements:  
- A **Player** class with attributes for position `(x, y)` and score.  
- An **Enemy** class with attributes for position `(x, y)`.  
- A **Game** class that manages the grid, player, enemies, and items.  

---

#### **Questions**

1. **Class Responsibilities**  
   a. What are the primary responsibilities of the `Player` class in the game? Which methods would you include, and why?  
   b. The `Enemy` class has a method `moveRandomly()`. What should this method do, and why is it important that this functionality is encapsulated within the `Enemy` class?  
   c. In a larger game, the `Game` class might become very complex. How would you decide which responsibilities belong in the `Game` class versus other classes?

2. **Cohesion and Coupling**  
   a. Define cohesion and coupling in the context of object-oriented design.  
   b. Evaluate the following design: The `Player` class has a method `updateGameState()` that changes the positions of all the enemies and items on the grid. Is this a good design? Why or why not?  

3. **Encapsulation and Access**  
   a. Why is it a good practice to declare class attributes as `private` and provide `getter` and `setter` methods?  
   b. For the `Enemy` class, should you provide a setter method for the position `(x, y)`? Why or why not?  

4. **Extensibility and Reusability**  
   a. Suppose you want to add a new type of enemy that moves diagonally instead of randomly. How would you modify your class design to accommodate this new enemy type without changing the existing `Enemy` class?  
   b. If you decide to reuse the `Player` class in another game that has no scoring system, how could you design the class to make it more reusable?

5. **Design Patterns**  
   a. The **Factory Pattern** is a common design pattern used to create objects. How might you use the Factory Pattern to instantiate game objects (e.g., `Player`, `Enemy`, `Item`) from the file data?  
   b. What are the advantages of using a Factory Pattern in this context?  

---

**Deliverable**: Submit written answers to the questions. Your answers should demonstrate a strong understanding of OOP principles, including cohesion, coupling, encapsulation, extensibility, and design patterns.

---

### **Notes for Students**
These exercises are designed to prepare you for the coding tasks in the subsequent exercises. By understanding the theoretical foundations of file handling, object instantiation, and class design, you will be better equipped to implement these concepts in your game application.

### Exercise 3: File Reading and Object Instantiation (Practical)

#### **Objective**
This exercise will solidify your understanding of file handling and object instantiation by implementing Java code to read data from a file and use it to create objects dynamically. You will write a small, focused program to practice file I/O and ensure proper data parsing and validation.

---

#### **Task**
You will create a Java program that reads game setup data from an external file (`gameData.txt`) and instantiates `Player`, `Enemy`, and `Item` objects based on the data. Your program should handle errors gracefully and validate the data before creating objects.

---

#### **Requirements**
1. **File Structure**:
   - Create a file named `gameData.txt` with the following structure:
     ```
     # Player position
     Player: 2, 3

     # Enemy positions
     Enemy: 4, 5
     Enemy: 6, 7

     # Item positions
     Item: 3, 2
     Item: 5, 5
     ```

2. **Create Classes**:
   - Implement the following classes:
     - `Player`: Attributes: `x`, `y`. Methods: Constructor, `toString()`.
     - `Enemy`: Attributes: `x`, `y`. Methods: Constructor, `toString()`.
     - `Item`: Attributes: `x`, `y`. Methods: Constructor, `toString()`.

3. **File Reading and Parsing**:
   - Write a method (`loadGameData`) in the `Game` class to:
     - Read and parse the file line by line.
     - Instantiate objects (`Player`, `Enemy`, `Item`) based on the parsed data.
     - Handle invalid data (e.g., malformed lines) gracefully by skipping those lines and printing an error message.

4. **Data Validation**:
   - Validate that the coordinates are within a valid range (e.g., 0 ≤ x, y < 10 for a 10x10 grid). Skip invalid entries and print an error message.

5. **Display Loaded Data**:
   - After reading the file, display the list of all instantiated objects (`Player`, `Enemy`, `Item`) using their `toString()` methods.

---

#### **Step-by-Step Instructions**

1. **Set Up the Classes**:
   - Implement the `Player`, `Enemy`, and `Item` classes with the following structure:
     ```java
     public class Player {
         private int x;
         private int y;

         public Player(int x, int y) {
             this.x = x;
             this.y = y;
         }

         @Override
         public String toString() {
             return "Player at (" + x + ", " + y + ")";
         }
     }

     public class Enemy {
         private int x;
         private int y;

         public Enemy(int x, int y) {
             this.x = x;
             this.y = y;
         }

         @Override
         public String toString() {
             return "Enemy at (" + x + ", " + y + ")";
         }
     }

     public class Item {
         private int x;
         private int y;

         public Item(int x, int y) {
             this.x = x;
             this.y = y;
         }

         @Override
         public String toString() {
             return "Item at (" + x + ", " + y + ")";
         }
     }
     ```

2. **Implement the `Game` Class**:
   - Add a `loadGameData` method to the `Game` class:
     ```java
     import java.io.*;
     import java.util.*;

     public class Game {
         private Player player;
         private List<Enemy> enemies = new ArrayList<>();
         private List<Item> items = new ArrayList<>();

         public void loadGameData(String fileName) {
             try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                 String line;
                 while ((line = br.readLine()) != null) {
                     line = line.trim();
                     if (line.startsWith("Player")) {
                         String[] parts = line.split(":")[1].trim().split(", ");
                         int x = Integer.parseInt(parts[0]);
                         int y = Integer.parseInt(parts[1]);
                         if (isValidPosition(x, y)) {
                             player = new Player(x, y);
                         } else {
                             System.out.println("Invalid Player position: " + line);
                         }
                     } else if (line.startsWith("Enemy")) {
                         String[] parts = line.split(":")[1].trim().split(", ");
                         int x = Integer.parseInt(parts[0]);
                         int y = Integer.parseInt(parts[1]);
                         if (isValidPosition(x, y)) {
                             enemies.add(new Enemy(x, y));
                         } else {
                             System.out.println("Invalid Enemy position: " + line);
                         }
                     } else if (line.startsWith("Item")) {
                         String[] parts = line.split(":")[1].trim().split(", ");
                         int x = Integer.parseInt(parts[0]);
                         int y = Integer.parseInt(parts[1]);
                         if (isValidPosition(x, y)) {
                             items.add(new Item(x, y));
                         } else {
                             System.out.println("Invalid Item position: " + line);
                         }
                     }
                 }
             } catch (IOException e) {
                 System.out.println("Error reading file: " + e.getMessage());
             }
         }

         private boolean isValidPosition(int x, int y) {
             return x >= 0 && x < 10 && y >= 0 && y < 10;
         }

         public void displayGameData() {
             System.out.println(player);
             for (Enemy enemy : enemies) {
                 System.out.println(enemy);
             }
             for (Item item : items) {
                 System.out.println(item);
             }
         }
     }
     ```

3. **Test the Program**:
   - Write a `Main` class to test the `loadGameData` and `displayGameData` methods:
     ```java
     public class Main {
         public static void main(String[] args) {
             Game game = new Game();
             game.loadGameData("gameData.txt");
             game.displayGameData();
         }
     }
     ```

4. **Run the Program**:
   - Create the `gameData.txt` file in the same directory as your Java program.
   - Run the `Main` class to test the output.

---

#### **Deliverable**
1. Submit your Java source files (`Player.java`, `Enemy.java`, `Item.java`, `Game.java`, `Main.java`).
2. Include the `gameData.txt` file used for testing.

---

---

### Exercise 4: Implementing Core Game Logic (Practical)

#### **Objective**
This exercise transitions you from file handling to basic game mechanics. You will write code to implement **player movement**, **scoring**, and **collision detection** using the objects instantiated in Exercise 3.

---

#### **Task**
Expand the `Game` class to implement player movement on a 10x10 grid, score tracking, and basic collision detection. You will allow the player

### Exercise 5: Adding Game Mechanics – Enemy Movement and Advanced Interactions (Practical)

#### **Objective**
Building on Exercise 4, this task focuses on implementing **enemy movement**, **collision detection**, and **enhanced interactions** between the player, enemies, and items. You will also add basic game state management, such as starting and ending the game based on player actions.

---

#### **Task**
Expand your game to include enemy movement and interactions. Implement game-ending conditions when the player collides with an enemy and ensure items are collectible. Use object-oriented principles and ensure your code is modular and well-structured.

---

#### **Requirements**

1. **Enemy Movement**:
   - Implement a method in the `Enemy` class to move enemies randomly on the 10x10 grid.
   - Ensure enemies do not move out of bounds.
   - After each player move, all enemies should move once.

2. **Collision Detection**:
   - Detect collisions between the player and enemies:
     - If the player’s position matches an enemy’s position, the game ends.
   - Detect collisions between the player and items:
     - If the player’s position matches an item’s position, the item is removed, and the player’s score increases.

3. **Game State**:
   - Add a `boolean` attribute `isGameOver` to the `Game` class to track whether the game is ongoing.
   - Display a message and the final score when the game ends.

4. **Input Handling**:
   - Allow the player to input movement commands (`up`, `down`, `left`, `right`) via the console.
   - After each move, update the game state (e.g., move enemies, check for collisions, and update the score).

---

#### **Step-by-Step Instructions**

1. **Enhance the `Enemy` Class**:
   - Add a `moveRandomly()` method to the `Enemy` class to move the enemy one step in a random direction (up, down, left, or right) while staying within the grid boundaries.
     ```java
     public void moveRandomly(int gridSize) {
         // Generate a random direction: 0 = up, 1 = down, 2 = left, 3 = right
         int direction = (int) (Math.random() * 4);
         switch (direction) {
             case 0: if (y > 0) y--; break; // Move up
             case 1: if (y < gridSize - 1) y++; break; // Move down
             case 2: if (x > 0) x--; break; // Move left
             case 3: if (x < gridSize - 1) x++; break; // Move right
         }
     }
     ```

2. **Update the `Game` Class**:
   - Add a method to check for collisions:
     ```java
     private void checkCollisions() {
         // Check for collision between player and enemies
         for (Enemy enemy : enemies) {
             if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                 isGameOver = true;
                 System.out.println("Game Over! You collided with an enemy.");
                 return;
             }
         }

         // Check for collision between player and items
         Iterator<Item> iterator = items.iterator();
         while (iterator.hasNext()) {
             Item item = iterator.next();
             if (player.getX() == item.getX() && player.getY() == item.getY()) {
                 iterator.remove(); // Remove the item
                 player.updateScore(10); // Increase score
                 System.out.println("Item collected! Score: " + player.getScore());
             }
         }
     }
     ```
   - Add a method to move all enemies:
     ```java
     private void moveEnemies() {
         for (Enemy enemy : enemies) {
             enemy.moveRandomly(10); // Assuming a 10x10 grid
         }
     }
     ```

3. **Game Loop**:
   - Implement a loop in the `Game` class to handle player input and update the game state:
     ```java
     public void startGame() {
         Scanner scanner = new Scanner(System.in);
         while (!isGameOver) {
             System.out.println("Enter move (up, down, left, right): ");
             String move = scanner.nextLine();
             player.move(move);

             // Ensure the player stays within bounds
             if (player.getX() < 0) player.setX(0);
             if (player.getX() >= 10) player.setX(9);
             if (player.getY() < 0) player.setY(0);
             if (player.getY() >= 10) player.setY(9);

             // Update game state
             moveEnemies();
             checkCollisions();

             if (isGameOver) {
                 System.out.println("Final Score: " + player.getScore());
                 break;
             }
         }
         scanner.close();
     }
     ```

4. **Test the Game**:
   - Run the `startGame()` method in the `Main` class to test the player and enemy interactions.

---

#### **Deliverable**
1. Submit your updated Java files (`Player.java`, `Enemy.java`, `Item.java`, `Game.java`, `Main.java`).
2. Include a brief explanation in your README file about the new features you implemented.

---

---

### Exercise 6: Adding Creative Enhancements and Finalizing the Game (Practical)

#### **Objective**
This final exercise encourages you to apply creative thinking to enhance the game. You will implement at least two creative features of your choice, improving gameplay and solidifying your understanding of the course concepts.

---

#### **Task**
Expand your game by adding **two creative features**. Examples include a timer, power-ups, multiple levels, or advanced enemy behaviors. You are encouraged to think creatively and design features that make your game enjoyable and unique.

---

#### **Requirements**

1. **Basic Enhancements**:
   - Add a timer or turn limit to the game:
     - The player must collect all items or survive for a specified number of turns.
     - Display a message when the time or turn limit runs out.
   - OR Add a power-up item:
     - When collected, the player gains a temporary ability (e.g., immunity to enemies for 3 turns, double score for items, or faster movement).

2. **Advanced Enhancements**:
   - Add multiple levels:
     - After collecting all items or surviving for a set number of turns, the player advances to the next level.
     - Increase difficulty in higher levels (e.g., more enemies, larger grid size, or faster enemy movement).
   - OR Add advanced enemy behaviors:
     - Create a new enemy type that chases the player.
     - Use simple pathfinding logic to move the enemy closer to the player’s position.

3. **Game Over Conditions**:
   - Ensure the game ends appropriately when the player either wins (e.g., all items collected or all levels completed) or loses (e.g., collides with an enemy or runs out of time/turns).

---

#### **Step-by-Step