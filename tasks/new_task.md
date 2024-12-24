![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-iAdgoE1zMT8QjM80Gmc2uKTt.png?st=2024-12-24T22%3A08%3A39Z&se=2024-12-25T00%3A08%3A39Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-12-24T08%3A34%3A09Z&ske=2024-12-25T08%3A34%3A09Z&sks=b&skv=2024-08-04&sig=jB2yPrk3CVrg8gw/bU5C/785bbfwxa31%2BH3BJ594Z%2Bk%3D)

# Task: Build a Simple Game Application in Java

In this task, you will design and implement a **simple game application**. The goal of the game is to control a player character who can move around the screen, avoid enemies, and collect points to increase the score. The game will also include dynamic enemy interactions based on data read from a file. This task will help you practice **using data from files to instantiate objects**, **designing classes**, and **programming creatively**.

You will spend this week working step by step through this challenge, and by the end, you will have a playable Java game that integrates these programming concepts.

---

## **Task Overview**

1. **Game Functionality**:
    - Implement **player movement** using keyboard inputs (e.g., arrow keys or WASD).
    - Introduce a **scoring system** that tracks points as the player collects "collectibles" on the screen.
    - Create **enemies** that move dynamically and interact with the player (e.g., reducing the score or ending the game upon collision).

2. **Key Integration**:
    - **Using Data from Files to Instantiate Objects**: Read enemy and collectible data (e.g., positions, movements, or characteristics) from a file and use it to dynamically create objects in the game.
    - **Designing Classes**: Build a well-structured class hierarchy for the game components (e.g., `Player`, `Enemy`, `GameObject`, `Game`).
    - **Programming Creatively**: Explore ideas to make your game unique, such as introducing power-ups, varying enemy behaviors, or adding difficulty levels.

3. **Development Requirements**:
    - Ensure modularity by dividing the code into classes with clear responsibilities.
    - Handle file input errors gracefully (e.g., missing or malformed data).
    - Use creative problem-solving to design the gameplay mechanics and polish the game.

---

## **Step-by-Step Instructions**

### **Step 1: Plan Your Classes**
Before starting to code, design the class structure for your game. Here's a suggested breakdown:

1. **`GameObject` (Superclass)**:
    - Fields: `x`, `y` (positions), `width`, `height` (size), `type` (e.g., "Player", "Enemy", "Collectible").
    - Methods: `move()`, `render()` (to be overridden by subclasses).

2. **`Player` (Subclass of `GameObject`)**:
    - Additional Fields: `score`.
    - Methods: `move()` (respond to user input).

3. **`Enemy` (Subclass of `GameObject`)**:
    - Additional Fields: `speed`, `direction`.
    - Methods: `move()` (e.g., move randomly or follow the player).

4. **`Game` (Main Class)**:
    - Fields: `List<GameObject> gameObjects`, `Player player`.
    - Methods: `start()`, `update()`, `render()`.

### **Step 2: Set Up the File Input**
Create a text file (e.g., `game_data.txt`) to store information about enemies and collectibles. Each line in the file should represent a game object in the following format:  
`type,x,y,speed,direction`  

Example content of `game_data.txt`:
```
Enemy,100,200,2,LEFT
Enemy,300,400,1,UP
Collectible,150,250,0,STATIC
```

Write a method in the `Game` class to **read this file and instantiate objects** dynamically.  
Here's a starting code snippet:

```java
import java.io.*;
import java.util.*;

public class Game {
    private List<GameObject> gameObjects = new ArrayList<>();
    
    public void loadGameData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                int speed = Integer.parseInt(parts[3]);
                String direction = parts[4];
                
                if ("Enemy".equals(type)) {
                    gameObjects.add(new Enemy(x, y, speed, direction));
                } else if ("Collectible".equals(type)) {
                    gameObjects.add(new Collectible(x, y));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading game data: " + e.getMessage());
        }
    }
}
```

### **Step 3: Implement Player Movement**
Use Java's `KeyListener` to capture keyboard inputs for player movement. Here's an example to get you started:

```java
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObject implements KeyListener {
    public Player(int x, int y) {
        super(x, y, 50, 50, "Player");
    }
    
    @Override
    public void move() {
        // Movement logic based on key presses
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                y -= 10; // Move up
                break;
            case KeyEvent.VK_DOWN:
                y += 10; // Move down
                break;
            case KeyEvent.VK_LEFT:
                x -= 10; // Move left
                break;
            case KeyEvent.VK_RIGHT:
                x += 10; // Move right
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
```

### **Step 4: Add Enemy Movement and Interactions**
In the `Enemy` class, implement logic for enemy movement (e.g., moving in a random or fixed direction). Also, detect collisions with the player and update the game's state (e.g., reduce score or end the game).

```java
public class Enemy extends GameObject {
    private int speed;
    private String direction;

    public Enemy(int x, int y, int speed, String direction) {
        super(x, y, 40, 40, "Enemy");
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void move() {
        switch (direction) {
            case "LEFT":
                x -= speed;
                break;
            case "RIGHT":
                x += speed;
                break;
            case "UP":
                y -= speed;
                break;
            case "DOWN":
                y += speed;
                break;
        }
    }
}
```

### **Step 5: Scoring System**
Update the score when the player collects a collectible. Add logic in the main game loop to detect collisions between the player and collectibles.

```java
public void checkCollisions() {
    for (GameObject obj : gameObjects) {
        if (obj instanceof Collectible && player.collidesWith(obj)) {
            player.addScore(10);
            gameObjects.remove(obj);
            break;
        }
    }
}


### **Exercise 1: Understanding File Formats and Object Instantiation**

This first exercise is designed to prepare students for using data from files to instantiate objects. By focusing on the theoretical and conceptual aspects, students will develop a deeper understanding of how data parsing and file I/O work in Java.

#### **Objective**:
Understand the process of parsing file data, converting it into meaningful structures, and using it to dynamically instantiate objects in a program.

#### **Instructions**:
Answer the following conceptual questions:

1. **File Formats**:
   - (a) What are some common file formats used to store structured data? Briefly describe the advantages and disadvantages of using plain text files (e.g., `.txt`) compared to structured formats like JSON or XML.
   - (b) In the context of a game, why might a plain text format (e.g., `type,x,y,speed,direction`) be a good choice for storing game object data? What are the trade-offs?

2. **File I/O in Java**:
   - (a) What are the key Java classes used for reading data from files? Compare and contrast the use of `BufferedReader` versus `Scanner` for file input.
   - (b) Explain how you would handle a situation where the game data file is missing or contains malformed data. Why is it important to handle such exceptions gracefully?

3. **Data Parsing and Object Instantiation**:
   - (a) Imagine you are given a line of game data: `Enemy,100,200,2,LEFT`. Explain how you would break this line into components, interpret them, and use them to create an `Enemy` object in Java.
   - (b) Why is it important to validate the data before creating objects? Provide an example of what could go wrong if invalid or incomplete data is used.

4. **Dynamic Object Creation**:
   - (a) What is the benefit of reading data from a file to create game objects dynamically, rather than hardcoding the game objects in the program?
   - (b) Describe a scenario where dynamically creating game objects from a file could enhance the flexibility or scalability of a game.

#### **Expected Outcomes**:
- Students should be able to articulate the importance of file formats, file I/O, and parsing techniques in Java.
- They should demonstrate an understanding of the challenges and benefits of using file data to instantiate objects dynamically.
- They should begin thinking critically about error handling and data validation.

---

### **Exercise 2: Principles of Class Design**

This second exercise focuses on the theoretical foundations of designing classes. Students will explore the principles of object-oriented programming and practice designing class structures for a game.

#### **Objective**:
Understand the principles of designing well-structured classes, including identifying responsibilities, defining interfaces, and promoting cohesion and modularity.

#### **Instructions**:
Answer the following questions:

1. **Class Responsibilities**:
   - (a) What is meant by the "responsibility" of a class in object-oriented programming? Why is it important to define clear responsibilities for each class in a program?
   - (b) Consider a game with players, enemies, and collectibles. What would be the primary responsibilities of the `Player`, `Enemy`, and `Collectible` classes? 

2. **Cohesion and Modularity**:
   - (a) What does it mean for a class to have high cohesion? Why is this desirable in software design?
   - (b) How can modularity in class design make a program easier to maintain and extend? Provide an example of a poorly designed class that violates modularity and explain how it could be improved.

3. **Inheritance and Polymorphism**:
   - (a) Explain how inheritance can be used to reduce duplication in a class hierarchy. Use the example of a `Player` and an `Enemy` class that both share common properties (e.g., position, size).
   - (b) What is polymorphism? How does it allow for more flexible and reusable code? Provide an example using a `GameObject` superclass and its subclasses.

4. **Design Patterns**:
   - (a) What is a design pattern in software engineering? Why are design patterns useful when designing classes?
   - (b) Imagine you are designing a game. Which design pattern (e.g., Factory, Singleton, or Observer) might be useful for managing the creation of game objects? Explain your reasoning.

5. **Applying the Concepts**:
   - (a) Based on the task overview, propose a class hierarchy for the game (e.g., `GameObject`, `Player`, `Enemy`, `Collectible`). Identify the fields and methods for each class.
   - (b) How would you ensure that your class hierarchy is extensible? For example, how could you design it so that new types of enemies or collectibles could be added in the future?

#### **Expected Outcomes**:
- Students should demonstrate an understanding of class responsibilities, cohesion, modularity, inheritance, and polymorphism.
- They should be able to propose a logical and extensible class hierarchy for the game.
- They should begin thinking about how design patterns can aid in solving common problems in software development.

---

### **Reflection for Exercises 1 & 2**

These exercises serve as a foundation for the coding tasks that follow. By focusing on the theoretical aspects first, students will be better prepared to:
- Parse file data correctly and instantiate objects dynamically in the program (Exercise 1).
- Design a clear and maintainable class structure for their game (Exercise 2). 

Encourage students to ask questions during this phase and share their proposed solutions with peers to foster collaborative learning.

### **Exercise 3: Implementing File Parsing and Object Instantiation**

This exercise bridges the theoretical understanding of parsing file data and implementing it in code. Students will write Java methods to dynamically create game objects using data from a file, ensuring proper error handling and data validation.

---

#### **Objective**:
Write code to parse a file with game object data, validate the data, and dynamically instantiate objects based on the parsed data.

---

#### **Instructions**:

1. **Step 1: Create the Input File**  
   - Create a plain text file named `game_data.txt` with the following sample content:
     ```
     Enemy,100,200,2,LEFT
     Enemy,300,400,1,UP
     Collectible,150,250,0,STATIC
     Collectible,500,600,0,STATIC
     ```
   - Add at least one line of malformed data (e.g., missing a field or containing invalid data) to simulate real-world scenarios:
     ```
     Enemy,400,invalid,2,DOWN
     ```

2. **Step 2: Write the `Game` Class File-Parsing Method**  
   Write a method in the `Game` class that performs the following:
   - Reads the contents of the file line by line.
   - Parses each line into meaningful components (e.g., `type`, `x`, `y`, `speed`, `direction`) using `String.split(",")`.
   - Validates the data for correctness (e.g., checks that `x`, `y`, and `speed` are integers, and `type` is one of the allowed values like `Enemy` or `Collectible`).
   - Handles malformed data gracefully by printing an appropriate error message and skipping the invalid line.
   - Dynamically creates and adds objects (e.g., `Enemy` or `Collectible`) to a list based on the parsed data.

   **Starter Code**:
   ```java
   public void loadGameData(String fileName) {
       try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
           String line;
           while ((line = br.readLine()) != null) {
               try {
                   String[] parts = line.split(",");
                   String type = parts[0];
                   int x = Integer.parseInt(parts[1]);
                   int y = Integer.parseInt(parts[2]);
                   int speed = Integer.parseInt(parts[3]);
                   String direction = parts.length > 4 ? parts[4] : "STATIC";

                   if ("Enemy".equals(type)) {
                       gameObjects.add(new Enemy(x, y, speed, direction));
                   } else if ("Collectible".equals(type)) {
                       gameObjects.add(new Collectible(x, y));
                   } else {
                       throw new IllegalArgumentException("Unknown object type: " + type);
                   }
               } catch (Exception e) {
                   System.out.println("Malformed data: " + line + " (" + e.getMessage() + ")");
               }
           }
       } catch (IOException e) {
           System.out.println("Error reading game data: " + e.getMessage());
       }
   }
   ```

3. **Step 3: Test the Method**  
   - Write a simple `main` method in the `Game` class to test the `loadGameData` method. Load the `game_data.txt` file and print the list of game objects to ensure they are instantiated properly.

   **Example Output**:
   ```
   Loaded: Enemy at (100, 200) moving LEFT with speed 2
   Loaded: Enemy at (300, 400) moving UP with speed 1
   Loaded: Collectible at (150, 250)
   Loaded: Collectible at (500, 600)
   Malformed data: Enemy,400,invalid,2,DOWN (For input string: "invalid")
   ```

---

#### **Expected Outcomes**:
Students should successfully:
- Parse the input file and validate its data.
- Handle errors (e.g., malformed data) gracefully.
- Dynamically instantiate objects and store them in a list.

---

### **Exercise 4: Designing and Implementing Class Interactions**

This exercise focuses on integrating the class hierarchy designed earlier and implementing interactions between objects in the game. Students will write code to enable player movement, add collision detection, and update the game state dynamically.

---

#### **Objective**:
Implement interactions between game objects, such as player movement, collision detection, and score updates. This exercise transitions students from designing classes to writing methods that integrate these classes.

---

#### **Instructions**:

1. **Step 1: Implement Player Movement**  
   - Write a `move` method in the `Player` class that updates the player's position based on keyboard input.
   - Use Java's `KeyListener` interface to capture arrow key inputs (or WASD keys) and call the `move` method accordingly. For example:
     ```java
     @Override
     public void move() {
         if (direction.equals("UP")) y -= 10;
         if (direction.equals("DOWN")) y += 10;
         if (direction.equals("LEFT")) x -= 10;
         if (direction.equals("RIGHT")) x += 10;
     }
     ```

   - Test the player movement by printing the player's position after each move.

2. **Step 2: Implement Collision Detection**  
   - Write a method in the `Game` class to check for collisions between the `Player` and other game objects.
   - Use bounding box collision detection:
     ```java
     public boolean collidesWith(GameObject other) {
         return this.x < other.x + other.width &&
                this.x + this.width > other.x &&
                this.y < other.y + other.height &&
                this.y + this.height > other.y;
     }
     ```
   - If the player collides with an `Enemy`, print a message and end the game.
   - If the player collides with a `Collectible`, increase the player's score and remove the `Collectible` from the game.

3. **Step 3: Update the Game State**  
   - In the main game loop (e.g., `update` method in the `Game` class):
     - Call the `move` methods for all game objects.
     - Check for collisions and update the game state accordingly.
   - Example:
     ```java
     public void update() {
         player.move();
         for (GameObject obj : gameObjects) {
             obj.move();
         }
         checkCollisions();
     }
     ```

4. **Step 4: Display the Game State**  
   - Write a simple `render` method in the `Game` class to display the current game state (e.g., player position, score, and active game objects).
   - Example:
     ```
     Player: (x=200, y=300), Score: 20
     Enemies: 2 active
     Collectibles: 1 remaining
     ```

5. **Bonus Challenge: Add Enemy Movement**  
   - Implement the `move` method in the `Enemy` class to make enemies move in a random direction or follow the player.
   - Example of random movement:
     ```java
     Random rand =

### **Exercise 5: Building the Full Game Loop and Adding Advanced Gameplay Features**

This exercise focuses on combining all the previously developed components and implementing a functional game loop. Students will integrate the player, enemies, collectibles, and interactions into a cohesive game, while adding advanced gameplay features like power-ups and multiple difficulty levels.

---

#### **Objective**:
Consolidate all previous work into a fully functioning game loop. Add advanced gameplay features to enhance creativity and polish the game's mechanics.

---

#### **Instructions**:

1. **Step 1: Implement the Game Loop**  
   - Write a `start` method in the `Game` class that runs the game loop. Use a `while` loop to continuously update the game state and render the game.
   - Example game loop:
     ```java
     public void start() {
         boolean isRunning = true;
         while (isRunning) {
             update();  // Update the game state
             render();  // Render the game state
             try {
                 Thread.sleep(50);  // Pause to control game speed
             } catch (InterruptedException e) {
                 System.out.println("Game interrupted: " + e.getMessage());
             }
         }
     }
     ```

2. **Step 2: Add Power-Ups**  
   - Introduce a new game object type `PowerUp` that temporarily enhances the player's abilities (e.g., increasing speed or making the player immune to enemies for a short time).
   - Add `PowerUp` objects to the `game_data.txt` file. Example:
     ```
     PowerUp,200,300,0,STATIC
     ```
   - Implement logic in the `Game` class to handle collisions between the player and `PowerUp` objects. Example effects:
     - Increase player speed for 5 seconds.
     - Make the player immune to enemy collisions for 5 seconds.

   **Hints**:
   - Use a `Timer` or `System.currentTimeMillis()` to track the duration of the power-up effect.
   - Add a `boolean isImmune` field to the `Player` class to represent immunity.

3. **Step 3: Add Difficulty Levels**  
   - Modify the `Game` class to allow the player to select a difficulty level at the start (e.g., "Easy", "Medium", "Hard").
   - Adjust game parameters based on the selected difficulty:
     - **Easy**: Slower enemy speed, fewer enemies, more collectibles.
     - **Medium**: Default settings.
     - **Hard**: Faster enemy speed, more enemies, fewer collectibles.

   **Hints**:
   - Use a `Scanner` to prompt the player for input when the game starts.
   - Adjust game parameters dynamically based on the selected difficulty.

   **Example**:
   ```java
   public void setDifficulty(String level) {
       switch (level) {
           case "Easy":
               enemySpeed = 1;
               numEnemies = 3;
               numCollectibles = 5;
               break;
           case "Medium":
               enemySpeed = 2;
               numEnemies = 5;
               numCollectibles = 3;
               break;
           case "Hard":
               enemySpeed = 3;
               numEnemies = 7;
               numCollectibles = 2;
               break;
           default:
               System.out.println("Invalid difficulty. Defaulting to Medium.");
               setDifficulty("Medium");
               break;
       }
   }
   ```

4. **Step 4: Add Game Over and Victory Conditions**  
   - Implement a "Game Over" condition when the player collides with an enemy (if not immune).
   - Implement a "Victory" condition when the player collects all collectibles.
   - Display appropriate messages when the game ends and give the player an option to restart.

   **Example**:
   ```java
   public void checkGameOver() {
       if (playerLives <= 0) {
           System.out.println("Game Over! Your final score: " + player.getScore());
           isRunning = false;
       }
   }

   public void checkVictory() {
       if (gameObjects.stream().noneMatch(obj -> obj instanceof Collectible)) {
           System.out.println("Victory! You collected all items!");
           isRunning = false;
       }
   }
   ```

5. **Step 5: Test the Full Game**  
   - Run the game and test all features, including the game loop, collisions, power-ups, and difficulty levels.
   - Debug any issues and refine the gameplay mechanics for a smoother experience.

---

#### **Expected Outcomes**:
- Students should have a fully functional game with a player, enemies, collectibles, power-ups, and difficulty levels.
- They should demonstrate an understanding of integrating all game components into a cohesive system.
- They should creatively design and implement advanced gameplay features.

---

### **Exercise 6: Polishing and Enhancing the Game**

This exercise encourages students to go beyond the functional requirements and creatively enhance their game with additional features, user experience improvements, and code quality refinements.

---

#### **Objective**:
Polish the game by adding creative features, improving user experience, and ensuring code quality. Reflect on the development process and how the game could be extended in the future.

---

#### **Instructions**:

1. **Step 1: Add Visual and Audio Feedback**  
   - Use Java's `Swing` or `JavaFX` libraries to add a graphical user interface (GUI) for the game.
     - Display the player, enemies, and collectibles visually on the screen.
     - Update the score and remaining collectibles in real time.
   - Add sound effects for key events (e.g., collecting an item, colliding with an enemy, or activating a power-up).
     - Use the `javax.sound.sampled` package to play audio clips.

   **Hints**:
   - Use `JPanel` or `Canvas` to draw the game objects.
   - Load images for the player, enemies, and collectibles to make the game visually appealing.

2. **Step 2: Implement a Pause and Restart Feature**  
   - Add functionality to pause the game (e.g., by pressing the "P" key) and restart the game (e.g., by pressing the "R" key).
   - Modify the game loop to handle these states.

   **Example**:
   ```java
   boolean isPaused = false;

   public void togglePause() {
       isPaused = !isPaused;
   }

   public void restartGame() {
       // Reload game data and reset the game state
       loadGameData("game_data.txt");
       player.reset();
       isRunning = true;
   }
   ```

3. **Step 3: Add Customization Options**  
   - Allow the player to customize certain aspects of the game before starting (e.g., player speed, number of enemies, or collectible types).
   - Use a configuration file or a menu-based system to let the player adjust these settings.

4. **Step 4: Optimize and Refactor Code**  
   - Review the game's code and refactor it for clarity, efficiency, and maintainability.
   - Apply best practices, such as:
     - Using constants for fixed values (e.g., screen dimensions, default speeds).
     -