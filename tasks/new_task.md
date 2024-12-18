![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-B3Sn9ZvAkzrpccwyPfTCzpKp.png?st=2024-12-18T12%3A29%3A41Z&se=2024-12-18T14%3A29%3A41Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-12-18T00%3A53%3A42Z&ske=2024-12-19T00%3A53%3A42Z&sks=b&skv=2024-08-04&sig=5hfjhaTykJTFv2lOhVs9kDF%2Bpj7OyrSkH7Aht6rc0PI%3D)

**Task Description: Build a Simple 2D Game Application in Java**

In this project, you will design and develop a simple 2D game application in Java. The game will include player movement, a scoring system, and interactions with enemies. The primary focus of this task is to integrate three key learning goals: **using data from files to instantiate objects**, **designing classes**, and **programming creatively**. By the end of this project, you will have created a functional game while mastering object-oriented programming concepts, file handling, and creative problem-solving.

---

### **Game Overview**
The game will feature:
1. A **player character** that can move around the screen using keyboard input.
2. **Enemies** that spawn based on data read from an external file.
3. A **scoring system** that increases the player's score when they successfully avoid collisions with enemies over time.
4. A simple **game-over condition** when the player collides with an enemy.

---

### **Task Breakdown**

#### **Step 1: Design the Game Classes**
Before diving into code, start by designing the core components of the game. Think about the responsibilities of each class and how they will interact. Here’s a suggested class structure:
- **`Player`**: Handles player attributes (e.g., position, movement) and keyboard input.
- **`Enemy`**: Represents enemy objects with attributes like position, speed, and direction.
- **`Game`**: Manages the game loop, collision detection, and scoring system.
- **`FileLoader`**: Reads enemy data from a file and creates `Enemy` objects.

Write down the fields and methods for each class. For example:
```java
// Example for Player class
public class Player {
    private int x, y; // Player position
    private int speed; // Movement speed

    public Player(int startX, int startY, int speed) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
```

**Learning Goal Integration:**
- **Designing Classes**: Identify clear responsibilities for each class, ensuring cohesion and maintainability.
- **Programming Creatively**: Consider how to enhance the player’s interactions with the game world.

---

#### **Step 2: Load Enemy Data from a File**
Enemies will be dynamically created based on data stored in a file (e.g., `enemies.txt`). Each line in the file will represent an enemy with attributes such as position, speed, and direction.

**Sample Input File (enemies.txt):**
```
100,200,2,DOWN
300,150,3,UP
50,400,1,RIGHT
```

- Each line contains: `x_position, y_position, speed, direction`.

Write a `FileLoader` class to read the file and create `Enemy` objects:
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<Enemy> loadEnemies(String filePath) throws IOException {
        List<Enemy> enemies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int speed = Integer.parseInt(parts[2]);
            String direction = parts[3];
            enemies.add(new Enemy(x, y, speed, direction));
        }

        reader.close();
        return enemies;
    }
}
```

**Learning Goal Integration:**
- **Using Data from Files to Instantiate Objects**: Practice file I/O, parsing data, and converting it into object attributes.
- **Handling Exceptions**: Add error handling to manage issues like file not found or invalid data.

---

#### **Step 3: Implement the Game Loop**
The `Game` class will manage the main game loop, player movement, enemy updates, and collision detection. Use a simple loop structure to continuously update the game state and redraw the screen.

```java
public class Game {
    private Player player;
    private List<Enemy> enemies;
    private boolean isRunning;
    private int score;

    public Game() {
        player = new Player(250, 250, 5); // Example starting position and speed
        try {
            enemies = FileLoader.loadEnemies("enemies.txt"); // Load enemies from file
        } catch (IOException e) {
            e.printStackTrace();
            enemies = new ArrayList<>();
        }
        isRunning = true;
        score = 0;
    }

    public void start() {
        while (isRunning) {
            update();
            render();
            checkCollision();
            try {
                Thread.sleep(16); // Roughly 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        // Update player and enemy positions
        // TODO: Implement enemy movement logic
    }

    private void render() {
        // TODO: Render the game screen (use a library like JavaFX or Swing)
    }

    private void checkCollision() {
        for (Enemy enemy : enemies) {
            if (Math.abs(player.getX() - enemy.getX()) < 10 && 
                Math.abs(player.getY() - enemy.getY()) < 10) {
                isRunning = false; // End game on collision
                System.out.println("Game Over! Final Score: " + score);
            }
        }
    }
}
```

**Learning Goal Integration:**
- **Programming Creatively**: Experiment with game mechanics like enemy movement patterns or power-ups.
- **Designing Classes**: Ensure the game logic is distributed between classes appropriately.

---

#### **Step 4: Add Scoring and Feedback**
Enhance the game by incrementing the score each second the player avoids enemies. Display the score on the screen and provide feedback when the game ends.

**Sample Scoring System:**
```java
private void update() {
    score++;
    // Update player and enemy positions
}
```

---

### **Optional Enhancements (For Extra Creativity)**
- Add different types of enemies with unique behaviors.
- Introduce power-ups that give the player temporary advantages (e.g., invincibility or increased speed).
- Create a main menu or difficulty levels.

---

### **Submission Requirements**
1. Submit your Java project as a ZIP file containing all source code and the input file (`enemies.txt`).
2. Your submission should include a `README` file explaining:
   - How to run the game.
   - The class structure and their responsibilities.
   - Any creative additions or challenges faced.

---

### **Assessment Criteria**
1. **Code Quality (30%)**: Proper class design

### **Exercise 1: Class Design and Object-Oriented Principles**  
This exercise focuses on the theoretical understanding of class design and object-oriented programming (OOP). Students will analyze the responsibilities of classes and their relationships within the context of the 2D game.  

---

#### **Task Description**
You have been introduced to the idea of designing a 2D game application with the following classes: `Player`, `Enemy`, `Game`, and `FileLoader`. In this exercise, you will analyze and refine the design of these classes. Your goal is to demonstrate your understanding of OOP principles such as **encapsulation**, **abstraction**, **inheritance**, and **polymorphism**.

---

#### **Questions**

1. **Encapsulation and Responsibilities**
   - For each of the classes (`Player`, `Enemy`, `Game`, and `FileLoader`), identify and describe the following:
     - The **core responsibility** of the class in the game.
     - The **fields** (attributes) the class is likely to have.
     - The **methods** that would be appropriate for the class to fulfill its responsibilities.
     - How the class ensures **encapsulation** and why encapsulation is important in this context.

   **Example Answer Template**:
   - Class: `Player`
     - Core Responsibility: Handles player-related operations, such as movement and tracking position.
     - Fields: `x`, `y`, `speed` (all private).
     - Methods: `moveUp()`, `moveDown()`, `getX()`, `getY()`, `setSpeed()`.
     - Encapsulation: All fields are private to prevent direct modification and are accessed/modified through getter and setter methods. This ensures the player’s attributes are controlled and maintained properly.

2. **Abstraction**
   - Discuss how the `Game` class uses abstraction to manage the overall game structure. Specifically:
     - Why does the `Game` class not directly handle player movement or enemy behavior?
     - How does this abstraction improve the maintainability and scalability of the code?

3. **Inheritance and Polymorphism**
   - Imagine you want to introduce two types of enemies: **StandardEnemy** and **FastEnemy**, where `FastEnemy` moves twice as fast as `StandardEnemy`.  
     - Propose a modified design that uses inheritance and polymorphism to handle this scenario.
     - Write out the relationships between the `Enemy` class and its subclasses.  
     - Suggest a method in the `Enemy` class that could be overridden by its subclasses to account for their unique behavior (e.g., movement speed).

4. **Class Interactions**
   - Describe how the `Game`, `Player`, and `Enemy` classes interact with each other.  
     - Why is it important for `Game` to manage the interactions between `Player` and `Enemy` rather than having these classes interact directly?
     - What potential issues (e.g., code duplication or tight coupling) could arise if interaction responsibilities were distributed differently?

5. **Practical Design Choices**
   - The `FileLoader` class is responsible for reading enemy data from a file.  
     - Why is it beneficial to separate file-handling logic into its own class rather than embedding it directly in the `Game` class?  
     - Describe how the `FileLoader` class achieves **modularity** in the overall program design.

6. **Reflection**
   - Based on the proposed class structure, suggest one additional class that could improve the design of the game (e.g., `PowerUp`, `Obstacle`, `GameUI`). Explain its responsibilities and how it would interact with other classes.

---

#### **Expected Learning Outcome**
By completing this exercise, students will:  
- Demonstrate a clear understanding of class responsibilities and their design.  
- Apply OOP principles to analyze and improve the architecture of a program.  
- Appreciate the importance of abstraction, encapsulation, modularity, and separation of concerns.

---

---

### **Exercise 2: File Handling and Data-Driven Design**  
This exercise emphasizes the theoretical concepts of file handling and how to design systems that use external data to create objects dynamically.

---

#### **Task Description**
The game requires enemies to be dynamically created based on data stored in an external file (`enemies.txt`). In this exercise, you will analyze the structure of file handling and discuss potential challenges and solutions when integrating external data into a program.

---

#### **Questions**

1. **Understanding the Input File**
   - Consider the example `enemies.txt` file containing the following data:
     ```
     100,200,2,DOWN
     300,150,3,UP
     50,400,1,RIGHT
     ```
     - What information does each line represent, and how is it used to instantiate an `Enemy` object?
     - If the file contained an additional attribute (e.g., `type` to indicate the enemy type), how would you modify the `FileLoader` class to handle this new data?

2. **File Parsing Logic**
   - The `FileLoader` class parses the input file line by line.  
     - Why is it important to validate the data (e.g., checking if each line is properly formatted) before creating an `Enemy` object?  
     - What kind of exceptions might occur during file parsing, and how should they be handled?

3. **Dynamic Object Creation**
   - Explain the process of dynamically creating objects from external data.  
     - Why is this approach more flexible than hardcoding enemy data in the program?  
     - How does this approach make the game more extensible (e.g., adding new enemy types or behaviors)?

4. **Error Handling**
   - Imagine the `enemies.txt` file contains the following problematic input:
     ```
     100,200,2,DOWN
     300,,3,UP
     INVALID_LINE
     ```
     - Identify the issues in the input and explain how the `FileLoader` class should handle these scenarios to avoid crashing the game.
     - Propose a robust error-handling strategy for the `FileLoader` class that ensures invalid data is skipped but valid data is still processed.

5. **Alternative Data Formats**
   - The current implementation uses a plain text file (CSV-like) to store enemy data.  
     - What are some limitations of this format?  
     - Suggest an alternative format (e.g., JSON or XML) and describe how it could improve the flexibility and readability of the data.  
     - How would using a more complex data format impact the design of the `FileLoader` class?

6. **Reflection**
   - File handling introduces external dependencies (e.g., the presence of the file or its correctness).  
     - What advantages and challenges arise when a program relies on external files for data?  
     - Suggest strategies to minimize the risks associated with these dependencies.

---

#### **Expected Learning Outcome**
By completing this exercise, students will:  
- Gain a deeper understanding of file handling and parsing logic.  
- Appreciate the importance of validating external data to ensure program robustness.  
- Explore the trade-offs between different data formats and their impact on program design.  

---

These exercises encourage students to think critically about the theoretical underpinnings of software design and file handling, laying a strong foundation for the

### **Exercise 3: Implementing the Core Game Mechanics**

This exercise focuses on implementing and integrating the core mechanics of the game, including player movement, enemy behavior, and collision detection. The goal is to provide students with hands-on experience in coding a functional game loop while applying object-oriented programming principles and handling dynamic data from external files.

---

#### **Task Description**
In this exercise, you will implement the following features of the game:
1. **Player Movement**: Allow the player to move using keyboard inputs (e.g., arrow keys or WASD).
2. **Enemy Behavior**: Implement basic movement for enemies based on their direction and speed.
3. **Collision Detection**: Add collision detection logic to check if the player collides with an enemy.
4. **Game Loop**: Integrate the player and enemy logic into a continuous game loop that updates the game state and checks for collisions.

---

#### **Step-by-Step Instructions**

1. **Player Movement**
   - Write code to handle keyboard inputs for moving the player character. Use a library like **JavaFX** or **Swing** for rendering and input handling.
   - Ensure that the player cannot move outside the boundaries of the game screen. For example:
     ```java
     public void moveUp() {
         if (y > 0) {
             y -= speed;
         }
     }
     ```

2. **Enemy Movement**
   - Implement a method in the `Enemy` class to update the enemy's position based on its speed and direction. For example:
     ```java
     public void move() {
         switch (direction) {
             case "UP": y -= speed; break;
             case "DOWN": y += speed; break;
             case "LEFT": x -= speed; break;
             case "RIGHT": x += speed; break;
         }
     }
     ```
   - Ensure that enemies wrap around the screen if they move outside the boundaries.

3. **Collision Detection**
   - Add a method in the `Game` class to check for collisions between the player and enemies. Use a simple bounding box collision detection algorithm:
     ```java
     private boolean isColliding(Player player, Enemy enemy) {
         return Math.abs(player.getX() - enemy.getX()) < 10 &&
                Math.abs(player.getY() - enemy.getY()) < 10;
     }
     ```
   - End the game if a collision is detected.

4. **Game Loop**
   - Implement the main game loop in the `Game` class. The loop should:
     - Continuously update the state of the player and enemies.
     - Check for collisions and end the game if necessary.
     - Redraw the game screen at regular intervals (e.g., 60 FPS).

---

#### **Coding Tasks**

1. **Implement Player Movement**
   - Write a method to process keyboard input and update the player’s position.
   - Add boundary checks to prevent the player from moving off-screen.

2. **Implement Enemy Movement**
   - Write a method to update the position of all enemies based on their speed and direction.
   - Test the enemy movement logic to ensure it behaves as expected.

3. **Implement Collision Detection**
   - Write a method to check for collisions between the player and each enemy.
   - Test the collision detection logic with various player and enemy positions.

4. **Integrate into the Game Loop**
   - Write a game loop that updates the player and enemy positions, checks for collisions, and redraws the screen.
   - Add a scoring mechanism that increments the score every second the player avoids collisions.

---

#### **Expected Output**
- A functional game where the player can move using keyboard inputs and avoid moving enemies.
- The game ends and displays the final score when the player collides with an enemy.

---

### **Exercise 4: Extending the Game with Advanced Features**

This exercise challenges students to extend the basic game by adding advanced features. The goal is to encourage creativity, problem-solving, and deeper understanding of object-oriented design.

---

#### **Task Description**
Enhance the game by implementing **at least two** of the following advanced features:
1. **Different Enemy Types**: Add new enemy types with unique behaviors (using inheritance and polymorphism).
2. **Power-Ups**: Introduce items that the player can collect to gain temporary advantages (e.g., increased speed or invincibility).
3. **Game Over Screen**: Create a screen that displays the final score and allows the player to restart the game.
4. **Dynamic Difficulty**: Gradually increase the game’s difficulty over time by spawning more enemies or increasing their speed.

---

#### **Step-by-Step Instructions**

1. **Different Enemy Types**
   - Create subclasses of the `Enemy` class, such as `FastEnemy` and `ZigZagEnemy`.
   - Override methods in these subclasses to implement unique behaviors. For example:
     ```java
     public class FastEnemy extends Enemy {
         public FastEnemy(int x, int y, int speed, String direction) {
             super(x, y, speed * 2, direction); // Double the speed
         }

         @Override
         public void move() {
             // Custom movement logic for FastEnemy
             super.move();
         }
     }
     ```

2. **Power-Ups**
   - Create a new `PowerUp` class with attributes like position and type (e.g., "SpeedBoost", "Shield").
   - Add logic to randomly spawn power-ups on the game screen.
   - Implement collision detection between the player and power-ups. When the player collects a power-up, apply its effect and remove it from the screen.

3. **Game Over Screen**
   - After the game ends, display a screen with the player’s final score and an option to restart.
   - Use a library like JavaFX to create a user interface for the game over screen.

4. **Dynamic Difficulty**
   - Gradually increase the difficulty of the game over time. For example:
     - Spawn additional enemies every 10 seconds.
     - Increase the speed of existing enemies after a certain score threshold.
   - Implement logic to ensure the game remains challenging but fair.

---

#### **Coding Tasks**

1. **Implement Subclassing for Enemies**
   - Create at least one new enemy type that overrides the behavior of the base `Enemy` class.
   - Test the new enemy type to ensure it behaves as expected.

2. **Implement Power-Up Logic**
   - Write a method to spawn power-ups at random intervals.
   - Add collision detection logic to apply the power-up effects when collected by the player.

3. **Create a Game Over Screen**
   - Write code to display a game over screen with the final score and a restart button.
   - Add logic to reset the game state when the player chooses to restart.

4. **Implement Dynamic Difficulty**
   - Write logic to adjust the game’s difficulty over time by spawning more enemies or increasing their speed.
   - Test the difficulty scaling to ensure it provides a balanced challenge.

---

#### **Expected Output**
- A more complex and engaging game with additional features like unique enemy behaviors, collectible power-ups, or dynamic difficulty scaling.
- A polished game over screen that enhances the player’s experience.

---

### **Reflection Questions for Exercises 3 & 4**



### **Exercise 5: Building a Robust Game UI and UX**

This exercise focuses on enhancing the user interface (UI) and user experience (UX) of the game. The goal is to create a visually appealing application that provides meaningful feedback to the player. Students will leverage libraries like **JavaFX** or **Swing** to design the game interface and improve player interaction.

---

#### **Task Description**
In this exercise, you will design and implement a functional game interface that includes a **menu screen**, **in-game HUD (Heads-Up Display)**, and a **game-over screen**. These UI components should enhance the overall player experience by providing clear navigation, game state information, and visual feedback.

---

#### **Step-by-Step Instructions**

1. **Main Menu Screen**
   - Create a main menu screen with the following options:
     - **Start Game**: Launches the game.
     - **Instructions**: Displays a screen with instructions on how to play the game (e.g., controls, objectives).
     - **Exit**: Closes the application.
   - Use JavaFX or Swing components (e.g., buttons, labels) to design the menu.
   
   **Sample Code Snippet**:
   ```java
   import javafx.application.Application;
   import javafx.scene.Scene;
   import javafx.scene.control.Button;
   import javafx.scene.layout.VBox;
   import javafx.stage.Stage;

   public class MainMenu extends Application {
       @Override
       public void start(Stage stage) {
           VBox menu = new VBox(10);
           Button startButton = new Button("Start Game");
           Button instructionsButton = new Button("Instructions");
           Button exitButton = new Button("Exit");

           startButton.setOnAction(e -> startGame());
           instructionsButton.setOnAction(e -> showInstructions());
           exitButton.setOnAction(e -> stage.close());

           menu.getChildren().addAll(startButton, instructionsButton, exitButton);
           Scene scene = new Scene(menu, 400, 300);
           stage.setScene(scene);
           stage.setTitle("Main Menu");
           stage.show();
       }

       private void startGame() {
           // TODO: Launch the game
       }

       private void showInstructions() {
           // TODO: Display instructions
       }

       public static void main(String[] args) {
           launch(args);
       }
   }
   ```

2. **In-Game HUD**
   - Add an on-screen HUD that displays:
     - The **current score**.
     - The **time elapsed** since the game started.
     - The **player’s remaining lives** (if you choose to implement a life system).
   - Update the HUD dynamically during the game.

   **Sample Tasks**:
   - Use a `Label` or `Text` component in JavaFX to display the score.
   - Update the score in real-time within the game loop.

3. **Game Over Screen**
   - After the game ends, display a game-over screen with:
     - The **final score**.
     - A **Restart** button to reset the game and return to the main menu.
     - An **Exit** button to close the application.
   - Add animations or visual effects (e.g., fade-in text).

4. **Polish the UX**
   - Add visual feedback for player actions:
     - Highlight buttons when hovered.
     - Display a brief message (e.g., “Power-Up Collected!”) when the player picks up a power-up.
   - Use colors, fonts, and layout designs to make the interface visually appealing.

---

#### **Coding Tasks**

1. **Create the Main Menu**
   - Design and implement the main menu screen with interactive buttons.
   - Add navigation logic to transition between the menu, game, and instructions screens.

2. **Implement the In-Game HUD**
   - Write code to display and update the score, elapsed time, and any other relevant information on the game screen.
   - Test the HUD to ensure it updates correctly as the game progresses.

3. **Design the Game Over Screen**
   - Implement a visually appealing game-over screen with the final score and options to restart or exit.
   - Ensure the game resets properly when the player chooses to restart.

4. **Enhance UX**
   - Add animations or visual effects to make the UI more engaging.
   - Test the UI for usability and responsiveness.

---

#### **Expected Output**
- A polished game interface with an interactive main menu, in-game HUD, and game-over screen.
- A visually appealing and user-friendly experience that keeps the player engaged.

---

#### **Reflection Questions**
1. How does separating the UI logic (e.g., main menu, HUD) from the game logic improve code maintainability?
2. What challenges did you face when designing the UI, and how did you address them?
3. Suggest one additional feature (e.g., pause menu, settings screen) that could further improve the game's UX.

---

---

### **Exercise 6: Multiplayer Mode with Networking**

This exercise introduces students to the basics of networking in Java by implementing a **multiplayer mode** for the game. The goal is to create a client-server architecture where two players can play the game simultaneously, with their movements and interactions synchronized over a network.

---

#### **Task Description**
In this exercise, you will develop a multiplayer version of the 2D game. One player will act as the **host** (server), and the other will join as a **client**. Both players will control their own characters and avoid enemies in a shared game world.

---

#### **Step-by-Step Instructions**

1. **Set Up the Server**
   - Create a `GameServer` class that listens for incoming client connections.
   - Use Java’s `ServerSocket` class to handle networking.
   - Once a client connects, the server should:
     - Send the initial game state (e.g., player positions, enemy positions) to the client.
     - Continuously receive player inputs from the client and update the game state.

   **Sample Code Snippet**:
   ```java
   import java.io.*;
   import java.net.*;

   public class GameServer {
       public static void main(String[] args) throws IOException {
           ServerSocket serverSocket = new ServerSocket(12345);
           System.out.println("Server is running... Waiting for a client to connect...");
           Socket clientSocket = serverSocket.accept();
           System.out.println("Client connected!");

           // TODO: Handle game state synchronization
           BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

           // Example: Send initial game state
           out.println("Welcome to the game!");

           // Close connections
           clientSocket.close();
           serverSocket.close();
       }
   }
   ```

2. **Set Up the Client**
   - Create a `GameClient` class that connects to a server using `Socket`.
   - The client should:
     - Receive the initial game state from the server.
     - Send player inputs (e.g., movement commands) to the server.
     - Continuously receive updates from the server to synchronize the game state.

3. **Synchronize Player Movements**
   - Implement logic on the server to handle input from both the host and client players.
  