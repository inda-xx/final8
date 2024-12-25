![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-EF8cAEcZfiEbq1VRMORvF224.png?st=2024-12-25T12%3A29%3A42Z&se=2024-12-25T14%3A29%3A42Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-12-24T20%3A14%3A31Z&ske=2024-12-25T20%3A14%3A31Z&sks=b&skv=2024-08-04&sig=jHL7RChAH5bIAe7J806PzpaXz9CqBC931DieChOmuvg%3D)

# Task Description: Create a Simple Game Application with Player Movement, Scoring System, and Enemy Interactions

## Objective
In this task, you will design and implement a **simple text-based game** in Java that includes player movement, a scoring system, and interactions with dynamically loaded enemies. The goal is to integrate key programming concepts, such as **using data from files to instantiate objects**, **designing well-structured classes**, and **programming creatively**, into a functioning game application. By the end of the task, you will have developed a small, interactive game where a player can collect points and avoid or interact with enemies.

---

## Game Overview
The game is played on a grid (e.g., 5x5 grid). The player moves using keyboard inputs (e.g., `w` for up, `a` for left, `s` for down, `d` for right). The grid contains:
1. **The Player**: Represented by `P` on the grid.
2. **Enemies**: Represented by `E`. Enemies are dynamically loaded into the game from an external file.
3. **Collectibles**: Represented by `C`. These increase the player’s score when collected.

The player wins the game by reaching a specific score or loses if they come into contact with an enemy. You will design and implement this game step by step.

---

## Task Breakdown and Scaffolding

### Step 1: **Designing Classes**
You will design the core classes for the game. Consider the following key components:
1. **Player**: Represents the player’s position, score, and actions.
2. **Enemy**: Represents enemies on the grid and their positions.
3. **GameGrid**: Represents the game board, handles rendering the grid and updating the positions of the player, enemies, and collectibles.
4. **GameController**: Manages the overall game logic, such as processing user inputs and determining win/lose conditions.

#### Example Code Snippet: Class Skeletons
```java
// Player class
public class Player {
    private int x; // Player's current row position
    private int y; // Player's current column position
    private int score; // Player's score

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(String direction) {
        // Logic to update x and y based on input direction
    }

    public void addScore(int points) {
        this.score += points;
    }

    // Getters and setters
}

// Enemy class
public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
}
```

**To Do**: Implement the methods within these classes. Ensure the classes are cohesive and have clearly defined responsibilities.

---

### Step 2: **Using Data from Files to Instantiate Enemies**
Enemies should be dynamically loaded from a text file named `enemies.txt`. Each line in the file will contain the coordinates of an enemy, e.g.:
```
1,3
2,4
4,2
```

You will read this file, parse the data, and use it to create `Enemy` objects. Handle potential exceptions (e.g., file not found or invalid file format) to ensure the game doesn’t crash.

#### Example Code Snippet: File Reading
```java
import java.io.*;
import java.util.ArrayList;

public class EnemyLoader {
    public static ArrayList<Enemy> loadEnemies(String fileName) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                enemies.add(new Enemy(x, y));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: Invalid file format");
        }
        return enemies;
    }
}
```

**To Do**:
1. Create the `enemies.txt` file with sample enemy positions.
2. Use the `EnemyLoader` class to load the file and instantiate enemy objects. Verify that the enemies appear in the correct positions on the grid.

---

### Step 3: **Programming Creatively**
Introduce game mechanics to make the game more engaging and interactive. For example:
1. **Enemy Movement**: Make enemies move randomly after each player move.
2. **Winning and Losing Conditions**:
   - The player wins when they collect 3 collectibles.
   - The player loses if they collide with an enemy.
3. **Score System**: Increase the player’s score when they collect a collectible.

#### Example Code Snippet: Grid Rendering and Movement
```java
public class GameGrid {
    private char[][] grid; // 2D array representing the grid
    private Player player;
    private ArrayList<Enemy> enemies;

    public GameGrid(int rows, int cols, Player player, ArrayList<Enemy> enemies) {
        this.grid = new char[rows][cols];
        this.player = player;
        this.enemies = enemies;
        initializeGrid();
    }

    private void initializeGrid() {
        // Fill the grid with empty spaces
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '.';
            }
        }
        // Place player, enemies, and collectibles
        grid[player.getX()][player.getY()] = 'P';
        for (Enemy enemy : enemies) {
            grid[enemy.getX()][enemy.getY()] = 'E';
        }
        // Add random collectibles
        grid[2][2] = 'C';
        grid[3][4] = 'C';
    }

    public void render() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Additional methods to update grid based on player and enemy movements
}
```

**To Do**:
1. Implement player movement and grid updates.
2. Add random enemy movement and collectible behavior.

---

### Step 4: **Testing and Refinement**
1. Test your game for usability and correctness.
2. Experiment with creative features (e.g., add more collectibles, implement harder enemies, or allow the player to "fight" or avoid enemies).
3. Obtain feedback from a peer and refine your game based on their input.

---

### Deliverables
1. Java source files for your game (e.g., `Player.java`, `Enemy.java

### Exercise 1: **Understanding Class Design Principles**

**Objective**: Help students understand the theoretical principles of designing classes and their application in a game context.

---

#### **Instructions**

1. **Review the Following Scenario**:  
   In the game you will develop, there are three main classes: `Player`, `Enemy`, and `GameGrid`. Each class has specific responsibilities:
   - The `Player` class manages the player’s position and score.
   - The `Enemy` class represents enemies on the grid and encapsulates their positions.
   - The `GameGrid` class serves as the central representation of the game world, managing the grid’s state and rendering it.

2. **Answer the Conceptual Questions Below**:  

   #### **Part A: Class Design**
   a) What are the core principles of **Object-Oriented Programming (OOP)**, and how do they apply to designing the `Player`, `Enemy`, and `GameGrid` classes? Provide examples for **encapsulation** and **abstraction** in this context.  

   b) Why is it important to ensure that each class has a **clear responsibility**? How does this principle contribute to the **maintainability** and **scalability** of your code?  

   c) Consider the `Player` class. Discuss why it is better to use **private fields** (e.g., `private int x;`) with public methods (e.g., `public void move(String direction)`) instead of making fields directly accessible (e.g., `public int x;`).  

   #### **Part B: Grid Representation**
   a) The game is played on a 5x5 grid. Discuss the pros and cons of representing the grid as:
   - A 2D `char` array.
   - A collection of objects, such as a `List` of `Cell` objects, where each `Cell` has properties like `isPlayer`, `isEnemy`, and `isCollectible`.

   b) Which representation would you choose for this game, and why?

   #### **Part C: GameGrid Class**
   The `GameGrid` class is responsible for rendering the grid and updating the positions of the player, enemies, and collectibles.  
   a) What methods should the `GameGrid` class have? Write a list of at least **5 method names** and briefly describe their purpose.  

   b) Imagine the player moves to a position containing a collectible (represented by `C`). What steps should the `GameGrid` class take to handle this event? Write a **step-by-step plan** describing the logic.  

---

#### **Expected Outcomes**
Students should demonstrate a clear understanding of:
- OOP principles like encapsulation, abstraction, and separation of responsibilities.
- The importance of clean, modular design for maintainability and scalability.
- The trade-offs of different grid representations and the responsibilities of the `GameGrid` class.

---

---

### Exercise 2: **File I/O and Data Integrity**

**Objective**: Prepare students to use external data (e.g., enemy positions from a file) to instantiate objects while understanding the importance of parsing and error handling.

---

#### **Instructions**

1. **Read the Following Background**:  
   In the game, enemies are loaded dynamically from a file named `enemies.txt`. The file contains enemy positions on the grid, with each line formatted as `x,y` (e.g., `1,3` or `4,2`). This data is read and used to create `Enemy` objects. File input/output (I/O) is a common task in software development, but it comes with challenges such as handling invalid or missing data.

2. **Answer the Conceptual Questions Below**:  

   #### **Part A: File Parsing**
   a) What steps are involved in reading data from a file and converting it into objects (e.g., `Enemy` objects)? Provide a **step-by-step explanation**.

   b) Why is it important to **validate** the data read from the file? What problems might arise if the data is not validated (e.g., malformed lines, out-of-bounds coordinates)?  

   c) Given the following `enemies.txt` file, how would you process each line to create `Enemy` objects? Briefly describe the logic.  
   ```
   1,3
   2,4
   invalid_line
   5,6
   ```

   #### **Part B: Error Handling**
   a) Describe the role of **exception handling** in file I/O operations. Why is it important to handle exceptions such as `FileNotFoundException` and `NumberFormatException`?  

   b) Imagine the file `enemies.txt` is missing or cannot be opened. What should your program do in this situation? Propose a **user-friendly error-handling strategy**.

   c) Write pseudocode to show how you would load enemy data from a file while handling exceptions for the following scenarios:
   - The file is missing.
   - A line in the file is not formatted correctly (e.g., does not contain two numbers separated by a comma).

   #### **Part C: Data Integrity**
   a) The game grid is a 5x5 grid. If an enemy’s position in the file is outside this range (e.g., `7,3`), how should the program handle it? Discuss two possible strategies and their advantages/disadvantages.  

   b) Why is it important to ensure that the program continues to run smoothly even when some data in the file is invalid? How does this affect the user experience?

---

#### **Expected Outcomes**
Students should:
- Understand the process of reading, validating, and converting file data into objects.
- Recognize the importance of error handling and data integrity in robust programming.
- Be able to propose strategies to handle missing or invalid data gracefully.

---

### Summary of Exercises 1 & 2:
These exercises provide a theoretical foundation for the practical coding tasks in subsequent steps. Exercise 1 focuses on **class design principles**, emphasizing OOP concepts and modularity. Exercise 2 builds students’ understanding of **file I/O** and **data validation**, preparing them to dynamically load enemy objects into the game grid. After completing these exercises, students will be ready to start implementing their game in Java.

### Exercise 3: **Building and Integrating the Core Classes**

**Objective**: Transition from theoretical understanding to implementing practical code. Students will create the core classes (`Player`, `Enemy`, and `GameGrid`), test them for basic functionality, and begin integrating them into a simple interactive program.

---

#### **Instructions**

1. **Task 1: Implement the `Player` Class**
   The `Player` class is responsible for managing the player’s position (`x`, `y`) and score (`score`).

   a) Write code to implement the `Player` class based on the skeleton provided in the task description. Ensure the class includes:
   - Private fields for `x`, `y`, and `score`.
   - A constructor to initialize the player’s starting position and score.
   - A method `public void move(String direction)` that updates the player’s position (`x`, `y`) based on the direction (`"w"` for up, `"a"` for left, `"s"` for down, `"d"` for right). Ensure that the player does not move out of the grid boundaries.
   - A method `public void addScore(int points)` to increase the player’s score.
   - Getters for the player’s position and score.

   b) Write a **test class** (`PlayerTest`) to test the functionality of the `Player` class. Specifically:
   - Create a `Player` object starting at position `(2, 2)`.
   - Test moving the player in all four directions and ensure they stay within the grid (e.g., moving up at `(0, 2)` should not change the position).
   - Test increasing the player’s score and verify the result.

---

2. **Task 2: Implement the `Enemy` Class**
   The `Enemy` class represents an enemy’s position (`x`, `y`) on the grid.

   a) Write code to implement the `Enemy` class based on the skeleton provided. Ensure the class includes:
   - Private fields for `x` and `y`.
   - A constructor to initialize the enemy’s position.
   - Getters for the enemy’s position.

   b) Write a **test class** (`EnemyTest`) to test the functionality of the `Enemy` class. Specifically:
   - Create multiple `Enemy` objects at different positions (e.g., `(1, 3)`, `(4, 2)`) and verify their positions using the getter methods.

---

3. **Task 3: Implement the `GameGrid` Class**
   The `GameGrid` class represents the game board and manages the placement of the player, enemies, and collectibles.

   a) Write code to implement the `GameGrid` class based on the example snippet provided. Ensure the class includes:
   - A 2D `char` array (`grid`) to represent the grid.
   - A constructor to initialize the grid and place the player, enemies, and collectibles.
   - A method `public void render()` to display the grid in the console, as shown in the example.
   - A method `public void updatePlayerPosition(int x, int y)` to update the player’s position on the grid.
   - A method `public void placeCollectible(int x, int y)` to place a collectible (`C`) at a specific position.

   b) Write a **test class** (`GameGridTest`) to test the functionality of the `GameGrid` class. Specifically:
   - Create a 5x5 grid with a player at `(2, 2)` and enemies at `(1, 3)` and `(4, 2)`.
   - Render the grid and verify the positions of the player, enemies, and collectibles.
   - Update the player’s position to `(3, 3)` and verify that the grid updates correctly.

---

4. **Task 4: Basic Integration**
   Combine the `Player`, `Enemy`, and `GameGrid` classes into a simple interactive program.

   a) Create a new class `GameMain` with a `main` method. This program should:
   - Instantiate a `Player` object at `(2, 2)`.
   - Dynamically load enemy positions from the `enemies.txt` file using the `EnemyLoader` class (provided in the task description).
   - Instantiate a `GameGrid` object and render the initial grid.

   b) Allow the player to move around the grid by inputting commands (`w`, `a`, `s`, `d`) in the console. After each move:
   - Update the player’s position on the grid.
   - Render the updated grid.

   **Hint**: Use `Scanner` to read input from the console.

---

#### **Expected Outcomes**
Students should:
- Successfully implement and test the `Player`, `Enemy`, and `GameGrid` classes.
- Understand how to integrate these classes into a basic interactive program.
- Be able to render the grid, move the player, and dynamically load enemies from a file.

---

### Exercise 4: **Enhancing the Game with File I/O and Basic Mechanics**

**Objective**: Extend the functionality of the game by implementing dynamic enemy loading, player-enemy interactions, and a basic scoring system.

---

#### **Instructions**

1. **Task 1: Dynamically Load Enemies**
   Use the `EnemyLoader` class to read enemy positions from the `enemies.txt` file and instantiate `Enemy` objects.

   a) Create an `enemies.txt` file with sample data (e.g., `1,3`, `2,4`, `4,2`).
   b) Modify the `GameMain` class to:
   - Load enemy positions from the file.
   - Add the enemies to the `GameGrid`.

   **Hint**: Use the `GameGrid` method `render()` to verify that the enemies are loaded and placed correctly.

---

2. **Task 2: Detect Player-Enemy Collisions**
   Add logic to detect when the player moves to a position occupied by an enemy.

   a) Modify the `GameGrid` class to:
   - Check if the player’s new position matches the position of any enemy.
   - If a collision is detected, output a message (e.g., “Game Over: You collided with an enemy!”) and terminate the program.

   b) Test the collision detection by moving the player to a position occupied by an enemy.

---

3. **Task 3: Implement a Scoring System**
   Add collectibles (`C`) to the grid that increase the player’s score when collected.

   a) Modify the `GameGrid` class to:
   - Randomly place 2-3 collectibles on the grid during initialization.
   - Check if the player’s new position matches the position of a collectible. If so:
     - Increase the player’s score by 1.
     - Remove the collectible from the grid.

   b) Modify the `GameMain` class to:
   - Display the player’s current score after each move.
   - End the game when the player’s score reaches 3 (e.g., “Congratulations! You win!”).

---

4. **Task 4: Random Enemy Movement**
   Make the enemies move randomly after each player move.

   a) Modify

### Exercise 5: **Enhancing Gameplay with Advanced Features**

**Objective**: Expand the functionality of the game by introducing advanced features such as smarter enemy behavior, player boundaries, and additional game mechanics. This exercise will consolidate the students' understanding of object-oriented programming, file I/O, and dynamic gameplay.

---

#### **Instructions**

1. **Task 1: Smarter Enemy Movement**
   Enhance the enemies' movement logic to make the game more challenging. Instead of moving randomly, enemies should move **toward the player** if they are within a certain range (e.g., 2 grid cells).

   a) Modify the `Enemy` class to include a method:
   ```java
   public void moveTowardsPlayer(int playerX, int playerY, int gridWidth, int gridHeight)
   ```
   This method should:
   - Calculate the difference between the enemy's position and the player's position (`dx` and `dy`).
   - Move the enemy one step closer to the player, ensuring it stays within the grid boundaries.

   **Hint**: Check if `Math.abs(dx) <= 2 && Math.abs(dy) <= 2` before moving, to ensure that the enemy only moves if the player is within range.

   b) Modify the `GameGrid` class to:
   - Call the `moveTowardsPlayer` method for each enemy after each player move.
   - Update the grid to reflect the new enemy positions.

   c) Test the smarter enemy movement by placing the player and enemies on the grid and observing their behavior as the player moves.

---

2. **Task 2: Boundary Mechanic**
   Introduce a mechanic where the player loses the game if they move outside the grid boundaries.

   a) Modify the `Player` class's `move` method to:
   - Return a boolean indicating whether the move was successful (`true` if within boundaries, `false` otherwise).

   b) Modify the `GameMain` class to:
   - Check the result of the player's move. If the method returns `false`, display a message (e.g., "You fell off the grid! Game Over.") and terminate the program.

   **Hint**: Use the `GameGrid`'s dimensions to enforce boundaries.

---

3. **Task 3: Introducing Power-Ups**
   Add a new type of collectible called a **power-up** (represented by `P` on the grid). When the player collects a power-up, they gain temporary immunity from enemies for the next 3 moves.

   a) Modify the `GameGrid` class to:
   - Randomly place 1-2 power-ups on the grid during initialization.
   - Check if the player’s new position matches the position of a power-up. If so:
     - Activate immunity for the player.
     - Remove the power-up from the grid.

   b) Add a new field to the `Player` class:
   ```java
   private int immunityMoves; // Number of moves the player is immune
   ```
   - Decrease the `immunityMoves` counter after each player move.
   - Modify the collision logic in the `GameGrid` class to ignore collisions with enemies if the player is immune.

   c) Modify the `GameMain` class to:
   - Display a message when the player gains immunity (e.g., "You are now immune for 3 moves!").
   - Display the remaining immunity moves after each turn.

---

4. **Task 4: Dynamic Game Grid Resizing**
   Allow the game grid size to be configurable via a file (`config.txt`). The file should contain the grid dimensions in the following format:
   ```
   GRID_SIZE=7
   ```
   a) Modify the `GameMain` class to:
   - Read the grid size from `config.txt`.
   - Create a grid of the specified size.

   b) If the file is missing or the format is invalid, default to a 5x5 grid and display a warning message.

   **Hint**: Use exception handling to manage file parsing errors.

---

#### **Expected Outcomes**
Students should:
- Implement smarter enemy behavior using logic and math.
- Understand how to enforce boundaries and handle invalid player actions.
- Introduce new game mechanics (power-ups) to enhance gameplay while managing state using class fields.
- Dynamically configure the game grid size using file input.

---

### Exercise 6: **Finalizing the Game and Adding Creative Enhancements**

**Objective**: Consolidate all previous concepts into a fully functioning game and encourage creative thinking by allowing students to design and implement their own game enhancements.

---

#### **Instructions**

1. **Task 1: Implementing Multiple Levels**
   Add levels to the game to increase its complexity dynamically. After the player wins a level (e.g., by collecting 3 collectibles), they progress to the next level, which introduces more enemies and collectibles.

   a) Modify the `GameMain` class to:
   - Track the current level.
   - Reset the grid and add more enemies and collectibles after each level is completed.

   b) Increase the difficulty with each level:
   - Add 1 additional enemy for each new level.
   - Place the player at a new random starting position.

   c) Display a message when the player progresses to a new level (e.g., "Level Complete! Welcome to Level 2.").

---

2. **Task 2: Adding a High Score System**
   Introduce a high score system to track the player’s best performance.

   a) Modify the `GameMain` class to:
   - Write the player’s score to a file (`highscore.txt`) at the end of the game.
   - Read the high score from `highscore.txt` at the start of the game and display it.

   **Hint**: Use a simple text format, such as:
   ```
   High Score: 10
   ```

   b) If `highscore.txt` is missing, create it automatically when the game ends.

---

3. **Task 3: Customizing the Game Grid**
   Allow the player to customize the grid by placing enemies, collectibles, and power-ups manually before starting the game.

   a) Modify the `GameMain` class to:
   - Display an empty grid.
   - Prompt the player to specify the position of items (e.g., "Enter enemy position (x,y): ").
   - Update the grid based on the player’s input.

   b) Add an option to skip customization and start with a randomly generated grid.

---

4. **Task 4: Adding Creative Enhancements**
   Encourage students to come up with their own game enhancements. Examples include:
   - **New Items**: Add traps (`T`) that reduce the player’s score or teleport the player to a random position.
   - **Enemy AI**: Make enemies cooperate by moving together or avoiding certain areas.
   - **Player Abilities**: Introduce abilities like "jump" to move two cells at a time or "dash" to move in a straight line.
   - **Time Limit**: Add a countdown timer to make the game more challenging.

   **Hint**: Students should describe their enhancements in comments and implement them step-by-step.

---

5. **Task 5: Final Testing and Feedback**
