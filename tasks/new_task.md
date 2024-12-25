![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-mMueWbvwcpraNYgCSV6KJ7cr.png?st=2024-12-25T15%3A56%3A52Z&se=2024-12-25T17%3A56%3A52Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-12-25T16%3A56%3A52Z&ske=2024-12-26T16%3A56%3A52Z&sks=b&skv=2024-08-04&sig=F%2BuApCjGF6DzmfcIrspDnfgC1e6jHjI/gSp22AVWSNE%3D)

**Task Description: Create a Simple Game Application**

### Overview:
In this task, you will design and implement a simple game application in Java. The game will include the following key features:
1. **Player Movement**: The player can move around the game world using keyboard controls.
2. **Scoring System**: The player earns points by interacting with game objects (e.g., collecting items, avoiding enemies).
3. **Enemy Interactions**: Enemies move in the game world and interact with the player (e.g., reducing the player's score or ending the game if they collide with the player).

This project will integrate the following learning goals:
- **Using Data from Files to Instantiate Objects**: Load game objects (e.g., enemies, items) from external data files to dynamically populate your game world.
- **Designing Classes**: Create a well-structured set of classes for game entities (e.g., Player, Enemy, Item) with clear responsibilities and interfaces.
- **Programming Creatively**: Use creative problem-solving and experimentation to design an engaging and functional game experience.

You are encouraged to be imaginative while implementing the game mechanics, but the focus should remain on writing clean, modular, and functional code.

---

### Step 1: **Design the Class Structure**
Start by designing the class hierarchy for your game. At a minimum, your game should include the following classes:
1. **Player**: Represents the player character in the game.
   - Fields: `position`, `score`, `lives`
   - Methods: `move(direction)`, `updateScore(points)`, `loseLife()`
2. **Enemy**: Represents enemies in the game.
   - Fields: `position`, `speed`
   - Methods: `move()`, `interactWithPlayer(Player player)`
3. **Item**: Represents collectible items in the game.
   - Fields: `position`, `points`
   - Methods: `interactWithPlayer(Player player)`
4. **Game**: Manages the game loop, player input, and interactions between objects.
   - Fields: `Player player`, `List<Enemy> enemies`, `List<Item> items`
   - Methods: `startGame()`, `updateGameState()`, `checkCollisions()`

**Scaffolding Snippet:**
```java
// Example of the Player class
public class Player {
    private int x, y; // Position
    private int score; 
    private int lives;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.lives = 3; // Default number of lives
    }

    public void move(String direction) {
        switch (direction) {
            case "UP": y--; break;
            case "DOWN": y++; break;
            case "LEFT": x--; break;
            case "RIGHT": x++; break;
        }
    }

    public void updateScore(int points) {
        score += points;
    }

    public void loseLife() {
        lives--;
    }

    // Getters for position, score, and lives
    ...
}
```

---

### Step 2: **Load Game Data from Files**
To make the game more dynamic, you will read data about enemies and items from external files. For example:
- **enemies.txt**:
  ```
  Enemy1,5,10,2
  Enemy2,15,20,3
  ```
  Each line specifies an enemy's name, starting x-coordinate, starting y-coordinate, and speed.

- **items.txt**:
  ```
  Item1,7,8,50
  Item2,12,5,100
  ```
  Each line specifies an item's name, x-coordinate, y-coordinate, and points value.

**Task:**
1. Use Java's `BufferedReader` or `Scanner` to read these files.
2. Parse each line and create objects (`Enemy` or `Item`) based on the data.
3. Handle potential exceptions (e.g., `FileNotFoundException`, `NumberFormatException`) to ensure the program doesn't crash if the file is missing or malformed.

**Scaffolding Snippet:**
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameDataLoader {
    public static List<Enemy> loadEnemies(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                int speed = Integer.parseInt(parts[3]);
                enemies.add(new Enemy(name, x, y, speed));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading enemies: " + e.getMessage());
        }
        return enemies;
    }
}
```

---

### Step 3: **Implement Player Movement and Interactions**
In the `Game` class, implement a method to handle player movement (e.g., using keyboard input) and update the game state. Use collision detection to check if the player interacts with an item or an enemy:
- If the player collects an item, update their score and remove the item from the game.
- If the player collides with an enemy, reduce their lives.

**Scaffolding Snippet:**
```java
public void checkCollisions() {
    for (Item item : items) {
        if (player.getX() == item.getX() && player.getY() == item.getY()) {
            player.updateScore(item.getPoints());
            items.remove(item);
            break;
        }
    }
    for (Enemy enemy : enemies) {
        if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
            player.loseLife();
            if (player.getLives() <= 0) {
                System.out.println("Game Over!");
                System.exit(0); // End the game
            }
        }
    }
}
```

---

### Step 4: **Enhance the Game Creatively**
Once the basic functionality is complete, experiment with creative additions:
1. Add animations or a graphical interface using a library like JavaFX or Swing.
2. Implement more complex enemy behavior (e.g., enemies that chase the player).
3. Introduce additional game mechanics such as power-ups or levels.

---

### Deliverables:
1. A fully functional Java game that integrates:
   - Player movement
   - A scoring system
   - Enemy interactions
2. External data files (`enemies.txt`, `items.txt`) for dynamic object creation.
3. A well-structured class hierarchy with clear responsibilities.
4. A short report (1-2 pages) explaining your design decisions, challenges faced, and creative enhancements.

---

### Assessment Criteria:
- **Code Quality**: Is your code modular, readable, and well-commented?
- **Correctness**: Does your game correctly load data, handle player movement, and manage interactions?
- **Creativity**

### Exercise 1: **Understanding File I/O and Object Instantiation**

#### Objective:
This exercise introduces students to the concept of using external data files to instantiate objects. It focuses on understanding file formats, file I/O operations, and their relevance in dynamic object creation.

---

#### Task:
Answer the following conceptual questions and write short code snippets where required. This will help you prepare for implementing file-based object instantiation in the game project.

1. **File Formats and Parsing**  
   (a) Why is it important to use structured file formats (e.g., CSV, JSON) for storing data?  
   (b) Compare and contrast the CSV and JSON formats. For which scenarios might one format be better than the other?  

2. **File I/O Basics**  
   (a) In Java, which classes are commonly used for reading data from files?  
   (b) What is the purpose of the `BufferedReader` class, and how does it differ from the `Scanner` class?  
   (c) Write a short code snippet to read a text file line by line and print each line to the console.  

3. **Dynamic Object Instantiation**  
   (a) Explain how reading data from a file is useful for dynamically instantiating objects in a program. Provide an example scenario where this approach would be beneficial.  
   (b) Imagine you have the following data about enemies in a file `enemies.txt`:
      ```
      Enemy1,5,10,2
      Enemy2,15,20,3
      ```
      Write a short pseudocode to describe the steps for reading this file and creating `Enemy` objects based on its content.

4. **Error Handling in File I/O**  
   (a) What are some common exceptions that might occur during file reading, and how can you handle these exceptions in your program?  
   (b) Why is it important to handle exceptions when working with external files?  

#### Deliverables:
- Written responses to the questions.
- A short code snippet for reading a file line by line.

#### Hint:
Think about how you would handle scenarios where the file is missing or contains malformed data. Consider the importance of maintaining data integrity when creating objects.

---

### Exercise 2: **Principles of Class Design**

#### Objective:
This exercise focuses on understanding the principles of class design and the importance of creating cohesive, reusable, and maintainable class structures. It will prepare you to design the classes for the game application.

---

#### Task:
Answer the following conceptual questions and analyze given examples to develop a deeper understanding of class design.

1. **Responsibilities of a Class**  
   (a) What does it mean for a class to have a "single responsibility"? Why is this principle important in software design?  
   (b) Consider the `Player` class in the game. What are its key responsibilities, and how would you ensure it adheres to the single responsibility principle?  

2. **Fields and Methods**  
   (a) Why is it important to carefully choose the fields (attributes) of a class?  
   (b) Explain the difference between "getter" and "setter" methods. Why are they commonly used in classes?  
   (c) For the `Enemy` class, suggest appropriate fields and methods, and explain your choices.  

3. **Encapsulation**  
   (a) What is encapsulation, and how does it help in designing robust classes?  
   (b) Consider the following code snippet:
      ```java
      public class Player {
          public int x, y;
          public int score;
      }
      ```
      Identify potential problems with making fields `public`. Rewrite the class to better adhere to the principles of encapsulation.

4. **Class Relationships**  
   (a) What are the different types of relationships that can exist between classes (e.g., association, aggregation, composition, inheritance)? Provide a brief explanation of each.  
   (b) For the game project, how would you describe the relationship between the `Game` class and the `Player`, `Enemy`, and `Item` classes?  

5. **Design Patterns**  
   (a) What are design patterns, and why are they useful in software development?  
   (b) The "Factory Method" pattern is often used to create objects. How might this pattern be applied in the context of creating game entities (e.g., `Player`, `Enemy`, `Item`) from file data?  

#### Deliverables:
- Written responses to the questions.
- A revised version of the `Player` class showcasing encapsulation.

#### Hint:
Think about why modularity and clear class responsibilities make your code easier to debug and extend. Use real-world analogies to explain the relationships between classes.

---

### Pedagogical Value:
- **Exercise 1** builds foundational knowledge of file handling and dynamic object creation, which is critical for implementing the game’s data-driven components.
- **Exercise 2** reinforces the principles of object-oriented programming (OOP), helping students design robust, reusable classes for the game project.

Both exercises will prepare students for the coding tasks in subsequent exercises by deepening their conceptual understanding of the key programming concepts.

### Exercise 3: **Bringing File I/O and Class Design Together**

#### Objective:
This exercise bridges the gap between theoretical understanding and practical application by requiring students to implement file-based object instantiation and integrate it with a well-designed class structure. Students will write code that combines file handling with object-oriented principles to create game entities dynamically.

---

#### Task:

1. **File-Based Instantiation of Game Entities**  
   Write methods to read data from external files (`enemies.txt` and `items.txt`) and create corresponding `Enemy` and `Item` objects. Use the scaffolding snippets from Exercise 1 as a starting point, and ensure the methods adhere to the principles of good class design.

   - Create a new helper class named `GameDataLoader` to encapsulate the functionality of loading data from files. This class should:
     - Contain two static methods: `loadEnemies(String filename)` and `loadItems(String filename)`.
     - Use proper exception handling to manage errors, such as a missing file or malformed data.
     - Return a `List<Enemy>` or `List<Item>` that can be used to populate the game world.

   **Starter Code for `GameDataLoader`:**
   ```java
   import java.io.*;
   import java.util.ArrayList;
   import java.util.List;

   public class GameDataLoader {
       public static List<Enemy> loadEnemies(String filename) {
           List<Enemy> enemies = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(",");
                   String name = parts[0];
                   int x = Integer.parseInt(parts[1]);
                   int y = Integer.parseInt(parts[2]);
                   int speed = Integer.parseInt(parts[3]);
                   enemies.add(new Enemy(name, x, y, speed));
               }
           } catch (IOException | NumberFormatException e) {
               System.out.println("Error loading enemies: " + e.getMessage());
           }
           return enemies;
       }

       public static List<Item> loadItems(String filename) {
           List<Item> items = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(",");
                   String name = parts[0];
                   int x = Integer.parseInt(parts[1]);
                   int y = Integer.parseInt(parts[2]);
                   int points = Integer.parseInt(parts[3]);
                   items.add(new Item(name, x, y, points));
               }
           } catch (IOException | NumberFormatException e) {
               System.out.println("Error loading items: " + e.getMessage());
           }
           return items;
       }
   }
   ```

   **Deliverables:**
   - A fully implemented `GameDataLoader` class.
   - Example `enemies.txt` and `items.txt` files for testing.
   - A main method to test loading data and printing the created objects to the console.

   **Questions to Answer After Implementing:**
   - How did you handle potential errors (e.g., missing file, malformed data)?
   - What are some advantages of using external files to define game entities?

---

2. **Testing and Debugging**  
   - Write a main method in a `GameTest` class to test your file-loading functionality.
   - Use the following example input files:
     - `enemies.txt`:
       ```
       Enemy1,2,3,1
       Enemy2,5,7,2
       ```
     - `items.txt`:
       ```
       Item1,1,1,50
       Item2,4,6,100
       ```
   - Print the loaded objects to the console to verify correctness.

   **Deliverables:**
   - A `GameTest` class with a main method for testing.
   - Console output showing that the enemies and items were loaded correctly.

   **Hints:**
   - Review how lists work in Java (e.g., `ArrayList`).
   - If errors occur, use `System.out.println` to debug by printing intermediate results.

---

3. **Refactor Classes for Dynamic Instantiation**  
   Modify your `Enemy` and `Item` classes to include constructors that take all required arguments (e.g., position, speed, points). Ensure that your classes are encapsulated and only expose necessary fields through getters.

   **Deliverables:**
   - Updated `Enemy` and `Item` classes with constructors and encapsulation.

   **Bonus Challenge:**
   - Use a `Factory Method` pattern in the `GameDataLoader` class to create `Enemy` and `Item` objects. This will make your code more modular and reusable.

---

### Exercise 4: **Integrating Movement and Interactions**

#### Objective:
This exercise transitions students into implementing the game's core functionality by focusing on player movement and interactions with game objects. Students will write code to handle player controls, update the game state, and detect interactions between entities.

---

#### Task:

1. **Player Movement**
   - Implement the `move(String direction)` method in the `Player` class to allow the player to move up, down, left, or right in the game world.
   - Write a simple text-based control system in the `Game` class that allows the player to input movement commands via the console. For example:
     ```
     Enter a direction (UP, DOWN, LEFT, RIGHT): UP
     ```

   **Deliverables:**
   - An updated `Player` class with the `move` method.
   - A `Game` class with a method to process user input and update the player's position.

   **Hints:**
   - Use a `Scanner` to read input from the console.
   - Use a loop to continuously accept movement commands until the user decides to quit.

---

2. **Collision Detection**
   - Implement the `checkCollisions()` method in the `Game` class to detect when the player interacts with an enemy or an item.
     - If the player’s position matches an item’s position, update the player’s score and remove the item from the game.
     - If the player’s position matches an enemy’s position, reduce the player’s lives.
   - Add logic to end the game if the player runs out of lives.

   **Starter Code:**
   ```java
   public void checkCollisions() {
       for (int i = 0; i < items.size(); i++) {
           Item item = items.get(i);
           if (player.getX() == item.getX() && player.getY() == item.getY()) {
               player.updateScore(item.getPoints());
               items.remove(i); // Remove the collected item
               System.out.println("Collected an item! Score: " + player.getScore());
           }
       }
       
       for (Enemy enemy : enemies) {
           if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
               player.loseLife();
               System.out.println("Hit an enemy! Lives left: " + player.getLives());
               if (player.getLives() <= 

### Exercise 5: **Building the Game Loop and Real-Time Updates**

#### Objective:
This exercise focuses on implementing the main game loop, which continuously updates the game state, processes user input, and checks interactions between game entities. Students will integrate the previously developed components into a functional game framework.

---

#### Task:

1. **Implement the Game Loop**
   - Create a `startGame()` method in the `Game` class that serves as the main game loop.
   - The loop should:
     - Continuously accept user input for player movement.
     - Update the positions of enemies in the game world.
     - Check for collisions between the player, enemies, and items.
     - End the game if the player runs out of lives or all items are collected.

   **Starter Code for the Game Loop:**
   ```java
   import java.util.Scanner;

   public void startGame() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Welcome to the game! Use UP, DOWN, LEFT, RIGHT to move. Type QUIT to exit.");

       while (true) {
           // Display the current game state
           System.out.println("Player position: (" + player.getX() + ", " + player.getY() + ")");
           System.out.println("Score: " + player.getScore() + " | Lives: " + player.getLives());
           System.out.print("Enter a direction (UP, DOWN, LEFT, RIGHT): ");

           // Get player input
           String input = scanner.nextLine().toUpperCase();
           if (input.equals("QUIT")) {
               System.out.println("Thanks for playing!");
               break;
           }

           // Move the player
           player.move(input);

           // Update the game state
           moveEnemies(); // Move enemies in the game world
           checkCollisions(); // Check for interactions

           // Check for game-ending conditions
           if (player.getLives() <= 0) {
               System.out.println("Game Over! You lost all your lives.");
               break;
           }
           if (items.isEmpty()) {
               System.out.println("Congratulations! You collected all items. Final Score: " + player.getScore());
               break;
           }
       }

       scanner.close();
   }
   ```

   **Deliverables:**
   - A `startGame()` method in the `Game` class that integrates player movement, enemy updates, and collision detection.
   - A functioning game loop that allows players to play the game until they win or lose.

   **Hints:**
   - Use a `while(true)` loop to continuously run the game until a quit condition is met.
   - Keep the game state persistent by updating objects (e.g., player, enemies, items) directly within the loop.

---

2. **Move Enemies Dynamically**
   - Implement the `move()` method in the `Enemy` class to allow enemies to move in the game world. Use a simple movement pattern, such as random movement or moving in a specific direction.
   - Update the `Game` class to call `move()` for each enemy during each iteration of the game loop.

   **Starter Code for Enemy Movement:**
   ```java
   import java.util.Random;

   public class Enemy {
       private int x, y;
       private int speed;
       private Random random = new Random();

       public Enemy(String name, int x, int y, int speed) {
           this.x = x;
           this.y = y;
           this.speed = speed;
       }

       public void move() {
           // Simple random movement
           int direction = random.nextInt(4); // 0 = UP, 1 = DOWN, 2 = LEFT, 3 = RIGHT
           switch (direction) {
               case 0: y -= speed; break; // Move up
               case 1: y += speed; break; // Move down
               case 2: x -= speed; break; // Move left
               case 3: x += speed; break; // Move right
           }
       }

       // Getters for position
       public int getX() { return x; }
       public int getY() { return y; }
   }
   ```

   **Deliverables:**
   - An updated `Enemy` class with a `move()` method.
   - An updated `Game` class that moves all enemies during each iteration of the game loop.

   **Questions to Answer After Implementation:**
   - How does the enemy movement affect the difficulty of the game?
   - What are some potential enhancements you could make to the enemy movement logic?

---

3. **Polish the Game Output**
   - Enhance the console output to make the game more engaging. For example:
     - Display the positions of enemies and items on each iteration.
     - Use ASCII symbols (e.g., `P` for player, `E` for enemy, `I` for item) to represent the game world in text form.

   **Starter Code for Displaying the Game World:**
   ```java
   public void displayGameWorld() {
       System.out.println("Game World:");
       System.out.println("Player: P | Enemies: E | Items: I");
       System.out.println("---------------------------------");
       System.out.println("Player is at (" + player.getX() + ", " + player.getY() + ")");
       for (Enemy enemy : enemies) {
           System.out.println("Enemy at (" + enemy.getX() + ", " + enemy.getY() + ")");
       }
       for (Item item : items) {
           System.out.println("Item at (" + item.getX() + ", " + item.getY() + ")");
       }
   }
   ```

   **Deliverables:**
   - A method in the `Game` class to display the current game state.
   - Enhanced console output that shows the positions of the player, enemies, and items.

---

### Exercise 6: **Introduce Advanced Mechanics and Finalize the Game**

#### Objective:
This exercise challenges students to creatively extend their game by introducing advanced mechanics and refining the overall design. Students will implement features that enhance gameplay and polish the final product.

---

#### Task:

1. **Add Power-Ups**
   - Introduce a new game object, `PowerUp`, that grants the player a temporary ability (e.g., increased speed, invincibility).
   - Create a `PowerUp` class with fields for `position`, `type` (e.g., "SpeedBoost", "Invincibility"), and `duration` (how long the effect lasts).
   - Modify the game loop to handle power-up interactions. For example:
     - If the player collects a "SpeedBoost" power-up, allow them to move two spaces per turn for 5 turns.
     - If the player collects an "Invincibility" power-up, prevent them from losing lives for 5 turns.

   **Starter Code for PowerUp Class:**
   ```java
   public class PowerUp {
       private int x, y;
       private String type;
       private int duration;

       public PowerUp(int x, int y, String type, int duration) {
           this.x = x;
           this.y = y;
           this.type = type;
           this.duration = duration;
       }

