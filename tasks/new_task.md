**Task Description: Create a Simple Game Application with Player Movement, Scoring System, and Enemy Interactions**

### Overview:
In this task, you will design and implement a simple 2D game application using Java. The game will include basic player movement, a scoring system, and interactions with enemies. The challenge involves reading data from files to instantiate game objects, designing cohesive and reusable classes, and applying creative thinking to build an engaging game experience.

This task is designed to integrate three key learning objectives:
1. **Using Data from Files to Instantiate Objects**: Learn how to read game data (e.g., enemy positions, player stats) from external files and use it to create objects dynamically.
2. **Designing Classes**: Apply object-oriented principles to design structured, maintainable, and scalable classes for the game.
3. **Programming Creatively**: Explore creative solutions for game mechanics, player interactions, and visual representation to make the game enjoyable.

By the end of this task, you will have a deeper understanding of file handling, class design, and creative problem-solving in programming.

---

### Task Requirements:
1. **Game Description**:
   - The game should feature a 2D grid or console-based environment.
   - A player character moves around the grid, collects points (e.g., coins), and avoids enemies.
   - A scoring system tracks the player’s performance.
   - Enemy behavior should be dynamic (e.g., moving in random or predefined patterns).

2. **Core Functionalities to Implement**:
   - **Player Movement**: Use the keyboard (e.g., W/A/S/D keys) to move the player around the grid.
   - **Scoring System**: Collect items (e.g., coins) to increase the player’s score.
   - **Enemy Interactions**: If the player collides with an enemy, the game ends or the player loses points.

3. **Data Handling**:
   - Use external files to define game data, such as:
     - Initial player position.
     - Enemy positions and movement patterns.
     - Scoring item positions.
   - Load this data into the game by reading and parsing the files.

4. **Class Design**:
   - Design classes for the main components of the game, such as `Player`, `Enemy`, `Game`, `Grid`, and `Item`.
   - Use appropriate fields and methods to encapsulate functionality and ensure code is reusable and maintainable.

5. **Creative Elements**:
   - Add at least one unique feature to the game. For example:
     - A power-up that temporarily disables enemies.
     - A timer-based challenge.
     - A special scoring mechanism.

---

### Step-by-Step Guide:

#### Step 1: Plan Your Classes
Start by identifying the responsibilities of each class. Here's an example structure to guide you:
- **`Player`**: Represents the player character. Includes fields for position, score, and methods for movement.
- **`Enemy`**: Represents an enemy. Includes fields for position and movement behavior.
- **`Item`**: Represents a collectible item (e.g., coins). Includes fields for position and point value.
- **`Game`**: Manages the game loop, interactions, and overall logic.
- **`Grid`**: Represents the game grid. Handles rendering and updates.

```java
// Example for the Player class
public class Player {
    private int x; // X-coordinate
    private int y; // Y-coordinate
    private int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public void move(String direction) {
        switch (direction) {
            case "W": y--; break; // Up
            case "S": y++; break; // Down
            case "A": x--; break; // Left
            case "D": x++; break; // Right
        }
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    // Additional getters and setters for position
}
```

#### Step 2: Read Data from Files to Instantiate Objects
Create a file (e.g., `game_data.txt`) to store initial positions for the player, enemies, and items:
```
Player: 0,0
Enemy: 3,4
Enemy: 5,2
Item: 2,2,10
Item: 4,3,20
```

Write code to read this file and create objects:

```java
import java.io.*;
import java.util.*;

public class GameDataLoader {
    public static List<Object> loadGameData(String fileName) {
        List<Object> gameObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(": ");
                String type = parts[0];
                String[] data = parts[1].split(",");
                switch (type) {
                    case "Player":
                        gameObjects.add(new Player(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                        break;
                    case "Enemy":
                        gameObjects.add(new Enemy(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                        break;
                    case "Item":
                        gameObjects.add(new Item(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameObjects;
    }
}
```

#### Step 3: Implement the Game Loop
The `Game` class should manage the game loop, rendering the grid, and checking for interactions between the player, enemies, and items.

```java
public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;

    public Game(Player player, List<Enemy> enemies, List<Item> items) {
        this.player = player;
        this.enemies = enemies;
        this.items = items;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            renderGrid();
            System.out.println("Score: " + player.getScore());
            System.out.println("Enter move (W/A/S/D): ");
            String move = scanner.nextLine();
            player.move(move);
            checkCollisions();
        }
    }

    private void renderGrid() {
        // Display the grid and positions of the player, items, and enemies.
    }

    private void checkCollisions() {
        // Check if the player collects an item or collides with an enemy.
    }
}
```

#### Step 4: Add Creative Features
Think of a unique mechanic or feature to make your game stand out. For example:
- Add power-ups that temporarily disable enemies.
- Introduce a timer to create urgency.
- Implement a leaderboard to track high scores.

#### Step 5: Test and Refine
- Test the game thoroughly and handle edge cases (e.g., invalid input, moving out of bounds).
- Experiment with different gameplay

### Exercise 1: Understanding File Handling and Object Instantiation from External Data

**Objective:**  
To ensure students understand the core concepts of reading data from files and using that data to instantiate objects dynamically in Java.

---

#### **Part A: Theory Questions**

1. **File Formats and Parsing Techniques**  
   a. Explain the advantages and disadvantages of using plain text files (e.g., `.txt`) versus structured formats like `.csv` or `.json` for storing game data.  
   b. In the following example, what challenges might arise when parsing the data, and how would you handle them programmatically?

   ```
   Player: 0,0
   Enemy: 3,4
   Enemy: 5,2
   Item: 4,3,20
   Item: 2,2,10
   ```

2. **File I/O in Java**  
   a. Explain the purpose of the following Java classes: `FileReader`, `BufferedReader`, and `Scanner`.  
   b. What is the difference between reading a file line by line using `BufferedReader` versus reading tokens using `Scanner`?

3. **Error Handling**  
   a. Why is it important to handle exceptions when dealing with file I/O operations?  
   b. Identify potential exceptions that could occur in the following code snippet, and explain how you would handle them:

   ```java
   BufferedReader br = new BufferedReader(new FileReader("game_data.txt"));
   String line;
   while ((line = br.readLine()) != null) {
       String[] parts = line.split(":");
       // Further processing
   }
   ```

---

#### **Part B: Practical Exercise**

1. **Analyzing a File Loader Class**  
   Below is a partial implementation of a `GameDataLoader` class. Identify and explain the purpose of each part of the code. Additionally, suggest improvements or additional features that could enhance its functionality.

   ```java
   import java.io.*;
   import java.util.*;

   public class GameDataLoader {
       public static List<Object> loadGameData(String fileName) {
           List<Object> gameObjects = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(": ");
                   String type = parts[0];
                   String[] data = parts[1].split(",");
                   switch (type) {
                       case "Player":
                           gameObjects.add(new Player(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                           break;
                       case "Enemy":
                           gameObjects.add(new Enemy(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                           break;
                       case "Item":
                           gameObjects.add(new Item(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                           break;
                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
           return gameObjects;
       }
   }
   ```

2. **Hands-On Parsing**  
   Write a small program that reads the following data from a file (`example_data.txt`) and prints the details of each object to the console:

   ```
   Player: 1,1
   Enemy: 2,3
   Item: 4,5,50
   ```

   **Expected Output:**
   ```
   Player at (1, 1)
   Enemy at (2, 3)
   Item at (4, 5) with value 50
   ```

---

### Exercise 2: Designing Classes for a 2D Game

**Objective:**  
To ensure students understand the principles of class design, including identifying responsibilities, defining clear interfaces, and implementing cohesive class structures.

---

#### **Part A: Theory Questions**

1. **Class Responsibilities**  
   a. Why is it important to identify the responsibilities of a class before implementing it?  
   b. Consider the following game components: `Player`, `Enemy`, `Item`, `Game`, and `Grid`. For each class, list at least three responsibilities.

2. **Encapsulation and Reusability**  
   a. Define encapsulation in the context of object-oriented programming. Why is it considered a best practice?  
   b. How does designing reusable classes benefit software development in the long term? Provide an example scenario.

3. **Cohesion in Class Design**  
   a. What is cohesion in the context of class design?  
   b. Identify whether the following class is cohesive or not. Justify your reasoning.

   ```java
   public class GameEntity {
       private int x, y;
       private int health;
       private String name;
       private int score;

       public GameEntity(int x, int y, int health, String name) {
           this.x = x;
           this.y = y;
           this.health = health;
           this.name = name;
           this.score = 0;
       }

       public void move(int dx, int dy) {
           x += dx;
           y += dy;
       }

       public void attack(GameEntity target) {
           target.health -= 10;
       }

       public void increaseScore(int points) {
           score += points;
       }
   }
   ```

4. **Relationships Between Classes**  
   a. Explain the difference between "has-a" and "is-a" relationships in class design.  
   b. For the following game classes, determine whether each should have a "has-a" or "is-a" relationship, and justify your answer:  
      - `Player` and `Grid`  
      - `Player` and `Enemy`  
      - `Game` and `Item`

---

#### **Part B: Practical Exercise**

1. **Design a Class**  
   Design a class for one of the game components (e.g., `Player`, `Enemy`, or `Item`) based on the principles discussed. Your design should include:  
   - At least two fields to represent the state of the object.  
   - At least two methods to define its behavior.  
   - Proper encapsulation (i.e., private fields with getters and setters).  

   Example Skeleton:

   ```java
   public class Player {
       private int x;
       private int y;
       private int score;

       public Player(int x, int y) {
           this.x = x;
           this.y = y;
           this.score = 0;
       }

       public void move(String direction) {
           // Implementation
       }

       public void increaseScore(int points) {
           // Implementation
       }

       // Additional getters and setters
   }
   ```

2. **Identify Class Dependencies**  
   After designing your class in the previous question, identify any dependencies it might have on other classes. For example, does the `Player` class depend on the `Grid` class to validate movements? If yes, how would you represent this dependency in code?

3. **Create a UML Diagram**  
   Create a simple UML diagram illustrating the relationships between the following classes in the game: `Player`, `Enemy`, `Item`, `Game`, and `Grid`. Use arrows to denote dependencies and

### Exercise 3: File-Driven Object Instantiation in a Game Context

**Objective:**  
To bridge the gap between understanding file handling and creating objects dynamically, and integrating it into a game application.

---

#### **Part A: Parsing and Instantiating Game Objects**

1. **Extend the File Parsing Logic**  
   Modify the `GameDataLoader` class to include additional functionality for parsing special game objects. Update the class to handle a new type of data, `PowerUp`, which provides temporary boosts to the player. The `PowerUp` objects have the following format in the file:

   ```
   PowerUp: 6,3,SpeedBoost
   ```

   - The first two numbers (`6,3`) represent the position of the power-up on the grid.
   - The third value (`SpeedBoost`) represents the type of power-up.

   **Implementation Requirements:**
   - Add a `PowerUp` class with the appropriate fields (`x`, `y`, and `type`).
   - Update the `GameDataLoader` class to parse `PowerUp` objects and include them in the list of game objects.

   **Code Skeleton for `PowerUp` Class:**

   ```java
   public class PowerUp {
       private int x;
       private int y;
       private String type;

       public PowerUp(int x, int y, String type) {
           this.x = x;
           this.y = y;
           this.type = type;
       }

       // Getters and toString method
       @Override
       public String toString() {
           return "PowerUp [type=" + type + ", position=(" + x + "," + y + ")]";
       }
   }
   ```

   **Example Output:**  
   If the file contains the following data:
   ```
   Player: 1,1
   PowerUp: 6,3,SpeedBoost
   ```
   The program should output:
   ```
   Player at (1,1)
   PowerUp [type=SpeedBoost, position=(6,3)]
   ```

2. **Validation and Error Handling**  
   Extend the `GameDataLoader` class to validate the input data. Implement checks to ensure:
   - Each line in the file follows the correct format.
   - Position values (e.g., `x` and `y`) are within the bounds of the game grid (e.g., 0 to 9 for a 10x10 grid).
   - Invalid lines should produce a warning message but not crash the program.

   **Example Warning:**  
   ```
   Warning: Invalid data format in line "PowerUp: 10,15,SpeedBoost". Skipping.
   ```

---

#### **Part B: Displaying Game Objects**

1. **Render Game Objects**  
   Write a `Grid` class that visualizes the game grid in the console. Use a 10x10 grid and display the positions of `Player`, `Enemy`, `Item`, and `PowerUp` objects. Use the following symbols:
   - `P` for the player.
   - `E` for enemies.
   - `$` for items.
   - `+` for power-ups.
   - `.` for empty spaces.

   **Code Skeleton for `Grid` Class:**

   ```java
   public class Grid {
       private int rows, cols;

       public Grid(int rows, int cols) {
           this.rows = rows;
           this.cols = cols;
       }

       public void render(Player player, List<Enemy> enemies, List<Item> items, List<PowerUp> powerUps) {
           char[][] grid = new char[rows][cols];
           // Initialize grid with empty spaces
           for (int i = 0; i < rows; i++) {
               for (int j = 0; j < cols; j++) {
                   grid[i][j] = '.';
               }
           }

           // Place objects on the grid
           grid[player.getY()][player.getX()] = 'P';
           for (Enemy enemy : enemies) {
               grid[enemy.getY()][enemy.getX()] = 'E';
           }
           for (Item item : items) {
               grid[item.getY()][item.getX()] = '$';
           }
           for (PowerUp powerUp : powerUps) {
               grid[powerUp.getY()][powerUp.getX()] = '+';
           }

           // Print the grid
           for (int i = 0; i < rows; i++) {
               for (int j = 0; j < cols; j++) {
                   System.out.print(grid[i][j] + " ");
               }
               System.out.println();
           }
       }
   }
   ```

   **Example Output for a 10x10 Grid:**
   ```
   . . . . . . . . . .
   P . . . . . . . . .
   . . . E . . . . . .
   . . . . . . . . . .
   . . $ . . . . . . .
   . . . . . + . . . .
   . . . . . . . . . .
   . . . . . . . . . .
   . . . . . . . . . .
   ```

---

### Exercise 4: Implementing Game Logic with Object Interactions

**Objective:**  
To integrate object design, file handling, and game mechanics into a cohesive interactive game system.

---

#### **Part A: Player Movement and Grid Updates**

1. **Interactive Player Movement**  
   Extend the `Game` class to support interactive player movement. The player should be able to move using keyboard input (`W`, `A`, `S`, `D`) while staying within the bounds of the grid.

   - If the player moves out of bounds, display a message and prevent the movement.
   - Update the grid and re-render it after each move.

   **Example Output:**
   ```
   Score: 0
   Enter move (W/A/S/D): W
   ```
   ```
   . . . . . . . . . .
   P . . . . . . . . .
   . . . E . . . . . .
   . . . . . . . . . .
   . . $ . . . . . . .
   . . . . . + . . . .
   . . . . . . . . . .
   . . . . . . . . . .
   . . . . . . . . . .
   ```

2. **Collecting Items**  
   Implement logic to detect when the player collects an `Item`. If the player moves to the same position as an item:
   - Increase the player’s score by the item’s point value.
   - Remove the item from the grid.
   - Display an updated score.

   **Example Output:**
   ```
   Score: 10
   ```

---

#### **Part B: Enemy Interactions**

1. **Enemy Movement**  
   Add simple movement logic to the `Enemy` class. Enemies should randomly move one step in any valid direction (up, down, left, or right) at each game loop iteration. Ensure enemies do not move

### Exercise 5: Adding Advanced Gameplay Features and Refining Game Mechanics

**Objective:**  
To consolidate the students' understanding of file handling, class design, and game logic by introducing advanced gameplay features. This exercise builds on previous steps and focuses on refining interactions, implementing a power-up system, and creating a user-friendly game loop.

---

#### **Part A: Implementing a Power-Up System**

1. **Power-Up Activation**  
   Extend the game logic to handle `PowerUp` objects. When the player moves to the position of a power-up:
   - Display a message indicating the type of power-up collected.
   - Apply the power-up effect for a limited number of turns (e.g., 5 turns).
   - Remove the power-up from the grid.

   **Power-Up Types and Effects:**
   - `SpeedBoost`: Allows the player to move two steps in a single turn.
   - `Invincibility`: Prevents the player from losing points or the game when colliding with an enemy.

   **Implementation Notes:**
   - Add a `currentPowerUp` field in the `Player` class to track active power-ups.
   - Use a counter to track the remaining turns for the active power-up.

   **Example Output:**
   ```
   You collected a SpeedBoost power-up! Move two steps per turn for 5 turns.
   ```

2. **Power-Up Expiration**  
   After the power-up duration expires:
   - Display a message indicating the effect is over.
   - Reset the player's abilities to default.

   **Example Output:**
   ```
   SpeedBoost power-up expired. Back to normal movement.
   ```

---

#### **Part B: Dynamic Enemy Behavior**

1. **Enhanced Enemy Movement**  
   Extend the `Enemy` class to include more dynamic movement patterns:
   - **Random Movement**: Enemies move randomly in one of the four cardinal directions (up, down, left, right).
   - **Chasing Behavior**: If an enemy is within a certain range of the player (e.g., 3 grid spaces), it moves towards the player.

   **Implementation Suggestions:**
   - Add a method `moveTowards(Player player)` in the `Enemy` class to calculate and execute movement toward the player.
   - Use a simple distance formula (e.g., Manhattan distance) to determine if the enemy should switch to chasing behavior.

   **Code Skeleton for Chasing Behavior:**
   ```java
   public void moveTowards(Player player) {
       if (Math.abs(player.getX() - this.x) > Math.abs(player.getY() - this.y)) {
           // Move horizontally
           this.x += (player.getX() > this.x) ? 1 : -1;
       } else {
           // Move vertically
           this.y += (player.getY() > this.y) ? 1 : -1;
       }
   }
   ```

---

#### **Part C: Game Over Conditions**

1. **Player-Enemy Collision**  
   If the player collides with an enemy:
   - Display a game-over message and end the game if the player does not have an active `Invincibility` power-up.
   - If the player is invincible, display a message and allow the game to continue.

   **Example Output:**
   ```
   Game Over! You collided with an enemy.
   ```

2. **Winning the Game**  
   Add a winning condition: The player wins when all items on the grid are collected. Display a congratulatory message and the final score.

   **Example Output:**
   ```
   You collected all the items! Final Score: 100
   ```

---

#### **Part D: Improving the Game Loop**

1. **Display Turn Information**  
   At the start of each turn, display the current state of the game, including:
   - The player’s score.
   - The number of turns remaining for an active power-up.
   - The positions of enemies, items, and power-ups.

   **Example Output:**
   ```
   Turn: 5
   Score: 50
   Active Power-Up: SpeedBoost (3 turns remaining)
   ```

2. **User-Friendly Input Validation**  
   Improve the game loop by validating user input. If a user enters an invalid command, display an error message and prompt them to try again.

   **Example Output:**
   ```
   Invalid input. Please enter W/A/S/D for movement.
   ```

---

### Exercise 6: Final Game Feature - Adding Levels and Saving Progress

**Objective:**  
To integrate all the concepts learned throughout the previous exercises into a fully functional game with multiple levels and a save/load system. This exercise challenges students to think holistically about software design while staying within their current knowledge boundaries.

---

#### **Part A: Adding Levels to the Game**

1. **Level System**  
   Introduce multiple levels to the game. Each level should:
   - Have a larger grid (e.g., increase from 10x10 to 15x15).
   - Include more enemies, items, and power-ups.
   - Increase the speed or chasing behavior of enemies to raise the difficulty.

   **Implementation Steps:**
   - Create separate data files for each level (e.g., `level1.txt`, `level2.txt`) containing the initial positions of all game objects.
   - Modify the `Game` class to load the appropriate data file when advancing to the next level.

   **Example Level Transition:**
   ```
   Level 1 complete! Advancing to Level 2...
   ```

2. **Level Transition Logic**  
   Transition to the next level when the player collects all items on the current level. Reset the player’s position and carry over their score.

---

#### **Part B: Saving and Loading Game Progress**

1. **Save Progress**  
   Add functionality to save the current state of the game to a file (e.g., `save_game.txt`). The file should include:
   - The player’s position, score, and active power-up (if any).
   - The positions of all enemies, items, and power-ups.
   - The current level.

   **Example Save File Format:**
   ```
   Level: 2
   Player: 5,5,50,SpeedBoost,3
   Enemy: 3,4
   Enemy: 8,7
   Item: 2,6,20
   PowerUp: 4,5,Invincibility
   ```

   **Implementation Notes:**
   - Use `BufferedWriter` or `PrintWriter` to write the game state to a file.
   - Include error handling to ensure the save file is created successfully.

2. **Load Progress**  
   Add functionality to load a saved game from a file. When the game starts, prompt the user to choose between:
   - Starting a new game.
   - Loading a saved game.

   **Example Output:**
   ```
   Welcome to the Game!
   1. Start New Game
   2. Load Saved Game
   Enter your choice: 2
   ```

   **Implementation Notes:**
   - Use `BufferedReader` to read the saved game file and restore the game state.
   - Validate