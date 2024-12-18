### 🎮 Task: Build a Simple Game with Player Movement, Scoring, and Enemy Interactions

**Overview:**  
In this task, you'll design and implement a text-based game application with the following functionalities:
1. Player movement.
2. A scoring system.
3. Interactions with enemies.

But that's not all! You're also required to utilize **file I/O in Java** for dynamic generation of the game world, apply **object-oriented design principles** to structure your game, and inject **creativity** into the gameplay mechanics.

This fun and challenging hands-on project will cultivate your programming skills in **file manipulation**, **class design**, **exception handling**, and **creative problem-solving**.

---

## 📚 Learning Goals

1️⃣ **Using Data from Files to Instantiate Objects**  
- Learn how to read data from files and use it to create instances of your Java classes dynamically.
- Understand file formats (like CSV or TXT) and their parsing techniques.
- Handle exceptions to maintain data integrity and avoid crashes.

2️⃣ **Designing Classes**  
- Practice designing clean and cohesive Java classes.
- Explore key object-oriented programming principles like responsibility-driven design, separation of concerns, and encapsulation.
- Learn to refactor your program's structure using design patterns where applicable.

3️⃣ **Programming Creatively**  
- Unleash your creativity in designing gameplay mechanics, game flow, and user experiences.
- Experiment with problem-solving approaches and iterative solutions.
- Test, refine, and enhance your gameplay based on user feedback or your own ideas.

---

## ✨ Task Description

Your game will consist of:  
- A **player** who can move between rooms and interact with the environment.  
- **Enemies** placed in certain areas to make gameplay challenging.  
- A **score system** that tracks the player's progress.  

Much of the game world (e.g., rooms, enemies, etc.) will be generated from an external file. Beyond learning file handling, this makes the game design dynamic and reusable for different scenarios.

You will also design new Java classes to model core elements of your game, such as `Player`, `Enemy`, `Room`, `Item`, and more. You are free to expand and make the game as fun and creative as you'd like, but ensure all requirements described below are met.

---

## 🦾 Exercises  

Each exercise builds on the concepts you've learned and gradually develops your game. Work sequentially and avoid jumping ahead unless instructed.

---

### 📝 **Exercise 1: Understanding File-Based Object Creation**  

#### Objectives:
- Understand how to read and parse a text file with Java.
- Explore how files can be used to dynamically initialize game objects.

#### Instructions:
Answer the following theoretical questions. Write your answers in a document named `exercise1.md`.  

1. What are some common file formats for storing structured data, and why might we choose one format over another (e.g., CSV vs. JSON)?  
2. Outline the basic steps of reading a file in Java using the `Scanner` class. What are some exceptions you might encounter during this process?  
3. How can you use a file to initialize multiple Java objects? Keep your explanation general, but provide an example using a simple `Room` class (`Room` has attributes `id` and `description`).  

---

### 💡 **Exercise 2: Principles of Class Design**  

#### Objectives:
Learn good object-oriented design concepts to define and structure your game's classes.

#### Instructions:  
1. Consider the following entities in your game:
   - **Player**, **Room**, **Enemy**, and **Game**.
   Write down a brief description of the role and responsibilities of each class. For example, what fields and methods should each class have? Avoid writing code here; just focus on the design principles.  
   *(Hint: Think of good practices like the Single Responsibility Principle.)*
   
2. Some classes interact with others (e.g., `Player` moves within `Room`, or `Enemy` interacts with `Player`). How do constructors and method calls help you establish these relationships? Explain.

3. (Optional) Pick an **object-oriented design pattern** that you might use in your game (like `Singleton`, `Factory`, etc.). Briefly explain how you could apply it in your game.

Write your answers in a document named `exercise2.md`.

---

### 🛠️ **Exercise 3: Generating the Game World Dynamically**  

#### Objectives:
Learn how to dynamically create objects like rooms and enemies based on external file data.

#### Instructions:
Implement a method in your `Game` class to dynamically generate rooms using a configuration file. Follow these steps:

1. **File structure** (feel free to modify as needed):
   ```txt
   // Rooms: ROOM;room_id;room_name;description
   ROOM;1;Living Room;A spacious living room with a cozy couch.
   ROOM;2;Kitchen;You see a fridge and some cupboards.

   // Enemies: ENEMY;enemy_id;enemy_name;room_id
   ENEMY;1;Goblin;1
   ENEMY;2;Troll;2
   ```

2. Write a method in `Game`:
   ```java
   private void generateGameWorldFromFile(String filename);
   ```
   - Open the file using `File` or `Scanner`.
   - Parse each line into data fields using the `split(";")` method.
   - Create `Room` and `Enemy` objects based on the file’s content and instantiate them in your game.
   - Use a `HashMap<String, Room>` to store rooms and their IDs for easy reference.

3. Handle exceptions for invalid file formats, missing data, etc. Gracefully terminate with an error message if something goes wrong.

Deliverables: Commit your implementation to the file `Game.java`.

---

### 🔧 **Exercise 4: Implementing the Core Gameplay**  

#### Objectives:
Combine your class structures and file data into a functional game.

#### Instructions:
1. **Player Movement**: Add functionality to allow the player to move between rooms (e.g., `go north`, `go south`). Rooms should have directional exits (north, south, etc.).
2. **Enemy Interactions**: When a player enters a room with an enemy, the game should trigger an interaction. This can be:
   - A simple `attack` and `defend` mechanic.
   - Or any mechanic of your choice (be creative—but keep it simple for now).
3. **Scoring System**: Implement a scoring system. For example:
   - Gain points for defeating an enemy.
   - Lose points for taking too many actions.

Deliverables: Fully implement the core game functionality. Test it to ensure it’s playable.

---

### 🚀 **Exercise 5: Designing and Adding Advanced Features**  

#### Objectives:
Experiment with creativity by extending the basic game design.

#### Instructions:
Choose **two or more enhancements** from the list below—or design your own new features:
- Add **items** (e.g., potions, treasure, keys). Allow the player to pick them up and use them.
- Introduce a **victory condition** (e.g., find a specific item, defeat all enemies, escape through an exit).
- Include **locked rooms** that can only be accessed with specific keys.
- Add **NPCs** (non-playable characters) who can give hints or quests.
- Implement a **health system** for the player and enemies.

Write a brief description of the new mechanics in `docs/README.md`. Update your code with the features.

---

### 📝 **Exercise 6: Documenting Your Code**  

#### Objectives:
Write clear and precise documentation for your classes and code.

#### Instructions:
1. Add **Javadoc** comments to all your public classes, methods, and constructors.
   - Use `@param` to describe method inputs.
   - Use `@return` to describe outputs.
   - Use `@author` to give yourself credit!
2. Create a `README.md` file with:
   - A brief description of your game.
   - Instructions for how to play.
   - Known bugs (if any) or limitations.
3. Add a **game world map** using ASCII art or an external tool like [diagrams.net](https://diagrams.net). Ensure it aligns with the actual map your code uses.

Deliverables: Commit your updated code and documentation into the repository.

---

### ⚡ Submission Checklist

- [ ] Exercises 1 and 2 completed (`exercise1.md` and `exercise2.md`).
- [ ] Functional game implementing all core requirements.
- [ ] At least two advanced features.
- [ ] Fully documented code (`README.md` and Javadoc).
- [ ] Game map added in the `docs/` folder.

---

### 🌟 Bonus Challenge (Optional)

Push your creativity further by adding **randomized enemy spawns**, **time limits** for solving puzzles, or even **multiple endings**! 🎉

---

### 🎯 Grading Criteria

- **Completeness**: Did you meet the requirements for all exercises?  
- **Code Quality**: Are your classes cohesive? Is your code clean and well-documented?  
- **Functionality**: Does the game work as intended without errors?  
- **Creativity**: Is your game unique and engaging?  

---

Good luck, and have fun programming your game! 🚀