### Task Description: Create a Simple Game Application

In this task, you will design and implement a **simple 2D console-based game application** that includes **player movement, a scoring system, and enemy interactions**. The game will use **data from external files** to dynamically create game elements such as enemies, and it will be built using **well-designed classes**. You are encouraged to apply **creative solutions** to make your game engaging and interactive.

This task is designed to help you practice **object-oriented programming (OOP)** principles, **file handling**, and **creative problem-solving**. By the end of this task, you will have a functional game and a deeper understanding of how to build scalable, dynamic, and interactive applications.

---

### Game Overview:
- The player navigates a **2D grid** using keyboard inputs (e.g., `W`, `A`, `S`, `D` for up, left, down, right).
- Enemies move in the grid, and the player must avoid them.
- Players collect **points** by picking up items scattered around the grid.
- The game ends when the player collides with an enemy.

---

### Requirements:
1. **Player Movement**:
   - The player should be able to move within the boundaries of the grid.
   - Movement should be controlled using keyboard inputs.

2. **Scoring System**:
   - Points are awarded when the player collects items.
   - The score should update and display after each move.

3. **Enemy Interactions**:
   - Enemies move around the grid randomly.
   - If an enemy collides with the player, the game ends.

4. **Dynamic Content from Files**:
   - Enemy and item positions should be loaded dynamically from a file at the start of the game.
   - If the file contains invalid data, handle errors gracefully and ensure the program doesn’t crash.

5. **Well-Designed Classes**:
   - Use OOP principles to create classes for the **Player**, **Enemy**, **Item**, and **Game**.
   - Ensure that each class has clear responsibilities and well-defined interfaces.

6. **Creative Touch**:
   - Add a unique feature to your game, such as power-ups, a timer, or multiple levels.

---

### Step-by-Step Instructions:

#### Step 1: Define Classes
Design the following classes. Begin by creating skeleton code with fields and methods based on their responsibilities. Below are suggestions for each class:

1. **Player Class**:
   - Fields: `x`, `y` (player position), `score`.
   - Methods: `move(direction: String)`, `updateScore(points: int)`.

2. **Enemy Class**:
   - Fields: `x`, `y` (enemy position).
   - Methods: `moveRandomly()`.

3. **Item Class**:
   - Fields: `x`, `y` (item position), `points`.
   - Methods: `getPoints()`.

4. **Game Class**:
   - Fields: `player` (Player object), `enemies` (list of Enemy objects), `items` (list of Item objects), `gridSize`.
   - Methods: `loadGameData(fileName: String)`, `startGame()`, `checkCollisions()`.

**Example Skeleton Code**:

```java
public class Player {
    private int x, y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(String direction) {
        // Update x and y based on direction
    }

    public void updateScore(int points) {
        this.score += points;
    }

    // Getters and setters (optional)
}
```

---

#### Step 2: Load Data from Files
Create a file (e.g., `gameData.txt`) with the following format:
```
GridSize: 10
Enemies:
3,4
5,6
Items:
2,2,10  // x, y, points
4,3,20
```

Write a method in the `Game` class to parse this file and instantiate `Enemy` and `Item` objects. Handle errors such as invalid file formats or missing data.

**Example Snippet**:
```java
public void loadGameData(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("Enemies:")) {
                // Parse enemy positions
            } else if (line.startsWith("Items:")) {
                // Parse item positions and points
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
}
```

---

#### Step 3: Implement Game Logic
1. **Player Movement**:
   - Use `Scanner` to read user input.
   - Update the player's position based on the input.

2. **Enemy Movement**:
   - Write logic for enemies to move randomly.

3. **Collision Detection**:
   - Check if the player collides with an enemy or an item after each move.
   - If the player collects an item, update the score and remove the item from the grid.
   - If the player collides with an enemy, end the game.

---

#### Step 4: Add a Creative Feature
Add a feature that makes your game unique. For example:
- A **power-up** that makes the player temporarily immune to enemies.
- A **timer** that limits how long the player has to collect all items.
- **Multiple levels** with increasing difficulty.

---

### Deliverables:
1. **Source Code**: Submit all Java files with appropriate comments.
2. **Game Data File**: Submit the file (e.g., `gameData.txt`) used to load game elements.
3. **ReadMe**: Include a short description of your game, how to run it, and the creative feature you added.

---

### Evaluation Criteria:
1. **Correctness** (40%): Does the game work as expected? Are all functionalities implemented?
2. **Code Quality** (30%): Are classes well-designed? Is the code readable and modular?
3. **Creative Feature** (20%): How innovative and engaging is the additional feature?
4. **Error Handling** (10%): Does the program handle file errors and invalid inputs gracefully?

---

### Bonus Challenge:
For extra credit, implement a **graphical version** of your game using a Java GUI library like `Swing` or `JavaFX`.

Good luck! Have fun coding your game!

### Exercise 1: Understanding File Handling and Object Instantiation

**Objective:**  
This exercise will help students understand how data can be extracted from files and used to instantiate objects. The goal is to solidify their conceptual knowledge of file handling and its application in dynamic object creation.

---

#### Part A: File Parsing Basics

**Question 1:**  
Consider the following content in a file named `gameData.txt`:
```
GridSize: 8
Enemies:
1,2
3,4
Items:
5,6,15
7,3,10
```
- What kind of data format is this?  
- How would you read this file line by line in Java?  
- How would you extract the enemy and item positions from the file?  

**Deliverable:**  
Write a short explanation describing:
1. Which Java classes and methods you would use to read such a file.  
2. How you would handle each line to extract relevant information for enemies and items.  
3. How you would handle errors such as missing or malformed data (e.g., a line like `Enemies: abc`).

---

#### Part B: Instantiating Objects from File Data

**Question 2:**  
Imagine you have the following classes:

```java
public class Enemy {
    private int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and other methods
}

public class Item {
    private int x, y, points;

    public Item(int x, int y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
    }

    // Getters and other methods
}
```

Given the same `gameData.txt` file, describe step-by-step how you would:
1. Parse the data for enemy positions (`1,2` and `3,4`) and item positions (`5,6,15` and `7,3,10`).
2. Instantiate `Enemy` and `Item` objects using the parsed data.  
3. Store these objects in appropriate collections (e.g., `ArrayList<Enemy>` and `ArrayList<Item>`).

---

#### Part C: Reflection Question

**Question 3:**  
Why is it important to handle file errors (e.g., missing file, incorrect format) gracefully in a program?  
Provide three specific examples of real-world consequences if file-related errors are not handled properly.

---

### Exercise 2: Designing Classes Using Object-Oriented Principles

**Objective:**  
This exercise focuses on the fundamental principles of designing well-structured classes. Students will analyze class responsibilities, define clear interfaces, and think critically about how to design cohesive systems.

---

#### Part A: Class Responsibilities

**Question 1:**  
Consider the following game scenario:  
- A **Player** moves around a grid, collects items, and avoids enemies.  
- Each **Enemy** moves randomly within the grid.  
- Each **Item** has a specific point value that increases the player’s score upon collection.  

For each of the following classes, describe:
1. What responsibilities the class should have.  
2. What fields and methods are necessary to fulfill those responsibilities.

- **Player**  
- **Enemy**  
- **Item**  
- **Game**

---

#### Part B: Interfaces and Methods

**Question 2:**  
For the `Player` class, you need to implement the following functionality:  
1. The player should move up, down, left, or right within the grid.  
2. The player’s position should not exceed the grid boundaries.  

Write pseudocode for the `move(String direction)` method that fulfills these requirements. Consider edge cases such as:
- The player trying to move outside the grid.  
- Invalid input for the `direction` parameter (e.g., passing `"UPWARD"` instead of `"W"`).

---

#### Part C: Cohesion and Coupling

**Question 3:**  
Read the following two design scenarios for the `Player` and `Game` classes:

- **Scenario 1:**  
  The `Player` class includes a method `checkCollisionWithEnemy(Enemy enemy)` that checks if the player has collided with a specific enemy.

- **Scenario 2:**  
  The `Game` class includes a method `checkCollisions()` that checks if the player has collided with any enemy or item in the game.

Which scenario represents better class design? Why?  
Explain your answer in terms of cohesion and coupling, and discuss the trade-offs of each approach.

---

#### Part D: Reflection Question

**Question 4:**  
Why is it important to design classes with clear responsibilities and boundaries?  
Provide a real-world analogy (e.g., designing roles in a team or parts in a machine) to support your explanation.

---

By completing these exercises, students will gain a solid theoretical foundation in file handling, object instantiation, and class design, which they will apply in the programming task.

### Exercise 3: Applying File Handling and Object-Oriented Design in Code

**Objective:**  
This exercise requires students to combine file handling and object-oriented principles by writing Java code to parse a file, instantiate objects, and use these objects to perform operations in a simulated game scenario. This exercise serves as a stepping stone to building the final game.

---

#### Part A: File Parsing and Object Instantiation in Code

**Instructions:**  
1. Create a Java class called `GameDataLoader` responsible for reading a configuration file and instantiating objects for the game.
2. The file format will look like this:
   ```
   GridSize: 10
   Enemies:
   2,3
   4,5
   Items:
   1,1,10
   6,7,20
   ```
3. Write a method in the `GameDataLoader` class called `loadGameData(String fileName)` that:
   - Reads the file line by line.
   - Parses the enemy positions and item data.
   - Instantiates `Enemy` and `Item` objects based on the parsed data.
   - Returns a `GameData` object containing the grid size, a list of enemies, and a list of items.

**Deliverable:**  
Write the `GameDataLoader` class and its `loadGameData` method. Additionally, write a test program to:
1. Create a `gameData.txt` file with sample data.
2. Use `GameDataLoader` to parse the file and print out the loaded enemies and items.

---

**Starter Code:**

```java
import java.io.*;
import java.util.*;

public class GameDataLoader {
    public GameData loadGameData(String fileName) {
        int gridSize = 0;
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("GridSize:")) {
                    gridSize = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("Enemies:")) {
                    while ((line = br.readLine()) != null && !line.startsWith("Items:")) {
                        String[] parts = line.split(",");
                        int x = Integer.parseInt(parts[0].trim());
                        int y = Integer.parseInt(parts[1].trim());
                        enemies.add(new Enemy(x, y));
                    }
                }

                if (line != null && line.startsWith("Items:")) {
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        int x = Integer.parseInt(parts[0].trim());
                        int y = Integer.parseInt(parts[1].trim());
                        int points = Integer.parseInt(parts[2].trim());
                        items.add(new Item(x, y, points));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return new GameData(gridSize, enemies, items);
    }
}

class GameData {
    private int gridSize;
    private List<Enemy> enemies;
    private List<Item> items;

    public GameData(int gridSize, List<Enemy> enemies, List<Item> items) {
        this.gridSize = gridSize;
        this.enemies = enemies;
        this.items = items;
    }

    public int getGridSize() {
        return gridSize;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }
}

// Enemy and Item classes
class Enemy {
    private int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Enemy at (" + x + ", " + y + ")";
    }
}

class Item {
    private int x, y, points;

    public Item(int x, int y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Item at (" + x + ", " + y + ") worth " + points + " points";
    }
}

// Test program
public class Main {
    public static void main(String[] args) {
        GameDataLoader loader = new GameDataLoader();
        GameData data = loader.loadGameData("gameData.txt");

        System.out.println("Grid Size: " + data.getGridSize());
        System.out.println("Enemies: " + data.getEnemies());
        System.out.println("Items: " + data.getItems());
    }
}
```

---

#### Part B: Error Handling

**Instructions:**  
Enhance the `GameDataLoader` class to handle the following errors gracefully:
1. Missing file: Print an error message and terminate the program.
2. Malformed data (e.g., invalid coordinates or missing points): Skip the invalid line and continue parsing the rest of the file.
3. Duplicate positions for enemies or items: Ignore duplicates and load only unique positions.

**Deliverable:**  
Update the `GameDataLoader` class with enhanced error handling and demonstrate its functionality using a test file with intentional errors.

---

#### Part C: Reflection Question

**Question:**  
What are the advantages of using a separate `GameDataLoader` class to handle file parsing and object instantiation? How does this approach contribute to better software design?

---

---

### Exercise 4: Building Game Logic

**Objective:**  
This exercise focuses on integrating the instantiated objects into a working game loop. Students will write code to simulate player movement, enemy interactions, and scoring in a simplified version of the final game.

---

#### Part A: Player Movement

**Instructions:**  
1. Implement the `Player` class with the following methods:
   - `move(String direction)`: Updates the player’s position based on the input (`W`, `A`, `S`, `D`).
   - Ensure the player does not move outside the grid boundaries.

2. Write a simple test program to:
   - Create a `Player` object at position `(0, 0)`.
   - Allow the user to input movement directions in a loop.
   - Print the player’s position after each move.

**Deliverable:**  
Submit the `Player` class and the test program.

---

#### Part B: Enemy Movement

**Instructions:**  
1. Update the `Enemy` class to include a `moveRandomly(int gridSize)` method that randomly updates the enemy’s position within the grid.
2. Write a test program to:
   - Create a list of `Enemy` objects.
   - Simulate enemy movement for 10 iterations, printing their positions after each move.

**Deliverable:**  
Submit the updated `Enemy` class and the test program.

---

#### Part C: Collision Detection and Scoring

**Instructions:**  
1. Write a method in the `Game` class to:
   - Detect if the player collides with an enemy

### Exercise 5: Integrating Game Components into a Functional Game Loop

**Objective:**  
This exercise focuses on combining all the components designed in previous exercises into a functional game loop. You will simulate player movement, enemy interactions, and scoring in a simplified version of the final game.

---

#### Part A: Game Initialization

**Instructions:**
1. Create a `Game` class that integrates the `Player`, `Enemy`, and `Item` classes along with the grid size and game state.
2. Write a `startGame()` method to:
   - Initialize the game elements (e.g., player, enemies, items).
   - Load the grid size, enemy positions, and item positions using the `GameDataLoader` class.

**Deliverable:**
Submit the `Game` class with the `startGame()` method implemented.

**Example Implementation:**
```java
public class Game {
    private int gridSize;
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;

    public Game(String dataFile) {
        GameDataLoader loader = new GameDataLoader();
        GameData data = loader.loadGameData(dataFile);

        this.gridSize = data.getGridSize();
        this.enemies = data.getEnemies();
        this.items = data.getItems();
        this.player = new Player(0, 0); // Start player at the top-left corner
    }

    public void startGame() {
        System.out.println("Game started!");
        System.out.println("Grid Size: " + gridSize);
        System.out.println("Enemies: " + enemies);
        System.out.println("Items: " + items);
    }
}
```

---

#### Part B: Game Loop Implementation

**Instructions:**
1. Add a `runGameLoop()` method to the `Game` class that:
   - Continuously prompts the player to enter movement directions (`W`, `A`, `S`, `D`).
   - Moves the player and updates the game state after each input.
   - Moves all enemies randomly after each player move.
   - Checks for collisions between the player and enemies or items.
   - Updates the score if the player collects an item.
   - Ends the game if the player collides with an enemy.

2. Write logic for the following:
   - **Player Movement**: Use the `Player.move()` method to update the player's position.
   - **Enemy Movement**: Use the `Enemy.moveRandomly()` method to update enemy positions.
   - **Collision Detection**: Check if the player’s position matches the position of any enemy or item.
   - **Game End Condition**: Stop the game loop if the player collides with an enemy.

**Deliverable:**
Submit the `Game` class with the `runGameLoop()` method implemented.

**Example Snippet:**
```java
import java.util.Scanner;

public class Game {
    // Fields and constructor...

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Display current game state
            System.out.println("Player position: (" + player.getX() + ", " + player.getY() + ")");
            System.out.println("Score: " + player.getScore());

            // Get player input
            System.out.print("Enter move (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();

            // Move player and enforce grid boundaries
            player.move(input, gridSize);

            // Move enemies
            for (Enemy enemy : enemies) {
                enemy.moveRandomly(gridSize);
            }

            // Check collisions
            if (checkCollisions()) {
                isRunning = false; // End game if player collides with an enemy
            }
        }

        System.out.println("Game Over! Final Score: " + player.getScore());
        scanner.close();
    }

    private boolean checkCollisions() {
        // Check collision with enemies
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                System.out.println("You collided with an enemy!");
                return true;
            }
        }

        // Check collision with items
        Item collectedItem = null;
        for (Item item : items) {
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                System.out.println("You collected an item worth " + item.getPoints() + " points!");
                player.updateScore(item.getPoints());
                collectedItem = item;
                break;
            }
        }

        // Remove collected item from the grid
        if (collectedItem != null) {
            items.remove(collectedItem);
        }

        return false;
    }
}
```

---

#### Part C: Testing the Game Loop

**Instructions:**
1. Write a test program to:
   - Create a `gameData.txt` file with sample data.
   - Instantiate a `Game` object using the file.
   - Run the game loop using the `runGameLoop()` method.

2. Play the game to ensure the following:
   - Player movement works correctly.
   - Enemy movement is random but stays within grid boundaries.
   - The score updates when items are collected.
   - The game ends when the player collides with an enemy.

**Deliverable:**
Submit the test program and a short report describing your observations (e.g., bugs, edge cases tested, and results).

---

#### Part D: Reflection Question

**Question:**
Explain how you simulated dynamic interactions between the player, enemies, and items in your game. What challenges did you face, and how did you address them?

---

---

### Exercise 6: Adding Creative Features and Enhancing Game Logic

**Objective:**  
This exercise pushes students to enhance their game with creative features and improve the overall design and functionality.

---

#### Part A: Adding a Power-Up Feature

**Instructions:**
1. Add a new class `PowerUp` with the following fields and methods:
   - Fields: `x`, `y` (position), `effect` (a String describing the power-up's effect, e.g., "immune").
   - Methods: `getEffect()` and any other necessary methods.

2. Enhance the `Game` class to:
   - Load power-up data from the `gameData.txt` file (e.g., `PowerUps: 3,3,immune`).
   - Place power-ups on the grid.
   - Activate a power-up when the player collides with it (e.g., make the player immune to enemies for 3 turns).

3. Adjust the game loop to handle active power-ups (e.g., track remaining turns of immunity).

**Deliverable:**
Submit the updated `Game` and `PowerUp` classes, along with a test program.

---

#### Part B: Adding a Timer or Level System

**Instructions:**
1. Add a timer to the game:
   - Track the number of turns the player takes.
   - End the game if the player does not collect all items within a certain number of turns.

2. Alternatively, add a multiple-level system:
   - Load different game data files for each level.
   -