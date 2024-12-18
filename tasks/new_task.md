![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-ewGsSGEv4fOHve0MuZXThfmk.png?st=2024-12-18T10%3A26%3A52Z&se=2024-12-18T12%3A26%3A52Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-12-18T00%3A41%3A47Z&ske=2024-12-19T00%3A41%3A47Z&sks=b&skv=2024-08-04&sig=V5aWLhYNZM81mCykptvtbhElcwbl%2BulSaIvsi/8ao6o%3D)

### 🎮 Programming Task: Build a Simple Game Application with File-based Object Creation, Class Design, and Creative Programming  

---

#### **Overview**

In this task, you will design and build a simple text-based game application where a player explores a world, interacts with enemies, and earns points by completing objectives. The game will support key mechanics such as **player movement**, **scoring**, and **enemy interactions**. You'll take inspiration from classic RPGs and creatively expand or tweak mechanics to reflect your own unique game design.

The project emphasizes the following learning goals:  

1. **Using Data from Files to Instantiate Objects**  
2. **Designing Classes**  
3. **Programming Creatively**  

The exercises are designed to give you hands-on experience with practical Java concepts such as file I/O, class design, object-oriented programming, and interface design, while encouraging creativity and problem-solving.

---

### 🧩 Learning Goals  

#### **1. Using Data from Files to Instantiate Objects**  
You will learn to leverage external data sources (e.g., files) to dynamically create and initialize game elements such as levels, enemies, and collectibles in your game.

- **Understand** different file formats (CSV, JSON, or custom text).  
- **Practice** parsing and extracting meaningful data.  
- **Safeguard** your program by using proper exception handling for file I/O.  

#### **2. Designing Classes**  
Develop skills to design cohesive, well-structured classes for the core components of your game. Learn to implement **fields**, **methods**, and **relationships** between classes, as well as apply good object-oriented design practices.

- **Identify** responsibilities within your game's structure and translate them into meaningful class designs.  
- **Create** reusable objects with aligned responsibilities, encapsulating and hiding unnecessary details.  
- **Explore** design patterns such as the Singleton Pattern or Factory Pattern for optimal solutions.  

#### **3. Programming Creatively**  
Programming isn't just problem-solving; it's a form of art. You'll stretch your creative problem-solving skills by brainstorming your own game idea and iteratively improving your implementation.  

- **Approach** challenges with varied, unconventional strategies.  
- **Experiment** with mechanics and features to personalize the game experience.  
- **Refine** your code by testing and integrating feedback from others.  

---

### 📋 Task Structure  

Below are the six exercises, organized into **theoretical foundations** and **practical implementations**, culminating in a polished project. Each exercise builds on the previous one, so complete them in order.

---

## **Exercise 1: Introduction to File-based Data & Game Scenarios**  
💡 **Goal**: Build an understanding of how files can store data for runtime object creation.  

#### 📝 **Instructions**  

1. **Research and Reflect**  
   Read about common file formats used to store structured and semi-structured data (e.g., `.csv` for tabular data, `.json` for hierarchical data). Answer the following:  
   - What is the difference between CSV and JSON in terms of structure and use cases?  
   - How would you structure data (like enemy attributes, levels, or player stats) in a file for your game? Provide an example layout in your answer.  

2. **Scenario Design**  
   Think about your game world:  
   - What is the game’s theme (fantasy, sci-fi, modern-day, etc.)?  
   - What objects (e.g., players, enemies, items, obstacles) will exist in your game?  

   Write a short, **half-a-page conceptual design** of your world that includes:
   - A brief description of the player’s mission.
   - Examples of objects (such as enemies) that **must be dynamically created from data files**.

---

## **Exercise 2: Class Design Blueprint 🏗️**  
💡 **Goal**: Develop your game's underlying object-oriented architecture.  

#### 📝 **Instructions**  

Design the class structure for your game. Some key game components are given below, but feel free to tweak, rename, or add your own:  

- **Player**: Represents the user, tracking position, inventory, and score.  
- **Enemy**: Represents AI characters with attributes like health, damage, and position.  
- **Item**: Represents collectibles (e.g., keys, points, or buffs).  
- **Room**: Represents individual game areas connected by exits.  
- **GameManager or GameEngine**: Coordinates game events like player actions, enemy behavior, scoring, and victory/loss conditions.  

1. **Write a Class Diagram (optional)**  
   - Map class relationships, identifying dependencies between objects.  
   - Indicate which classes will interact with one another.  

2. **Document Key Class Responsibilities**  
   For each class, describe its purpose and key methods. Example:  
   
   ```
   Class: Enemy  
   Responsibility: Represents game enemies. Tracks position and damage dealt, with logic for interacting with the player.  
   Key Methods:  
   - move(direction): Moves the enemy in one direction.  
   - attack(): Engages with the player and reduces their health.  
   ```

---

## **Exercise 3: Parsing Files to Instantiate Game Objects 📂**  
💡 **Goal**: Learn how to load and parse external data to create in-game objects.  

#### 📝 **Instructions**  

1. Create a **data file** (e.g., `.txt`) containing the descriptions of multiple enemies, items, and rooms in your game.  
   Example (`game_data.txt`):  
   ```
   ROOM;Room1;A dark, creepy dungeon with stone walls.  
   ENEMY;Goblin;30;10;South  
   ITEM;Key;Opens the golden door;Room1  
   ROOM;Room2;A bright hall filled with gold.
   ENEMY;Skeleton;40;15;North  
   ```

2. Implement a `GameLoader` class using **Java File I/O** (`BufferedReader`, etc.) to read and interpret this data. Your program should:  
   - Read entries line by line.  
   - Instantiate corresponding objects (`Room`, `Enemy`, etc.) when parsing specific prefixes (e.g., `ROOM`, `ENEMY`).   
   - Store objects in appropriate collections for use by the game engine.  

3. Handle errors gracefully:  
   - If the file is missing, output a friendly error and terminate safely.  
   - Print a warning for any malformed data lines and skip them.

---

## **Exercise 4: Implementing Basic Game Mechanics 🎮**  
💡 **Goal**: Build and test core gameplay features.  

#### 📝 **Instructions**  

1. **Player Movement in Rooms**  
   Write logic for moving the player between rooms.  
   - Rooms must interconnect using valid exits (e.g., north, south, east, west).  
   - Update the player’s position when they enter a new room.  

2. **Interactive Enemy Behavior**  
   Add a method for interacting with enemies upon entering their room.  
   - If the player attacks, the enemy loses health (or dies if health reaches zero).  
   - If the player flees, log the event and move to the adjacent room.  

3. **Scoring Points System**  
   Create a simple scoring system:  
   - The player gains points for defeating enemies or picking up items.  
   - Total points are logged after the game ends.  

---

## **Exercise 5: Expanding Creativity 🌟**  
💡 **Goal**: Add at least **two creative, new features** to make the game unique.  

#### 📝 **Instructions**  

Here are some ideas:  
- **Complex Enemy AI**: Enemies could patrol between rooms or chase the player.  
- **Items with Effects**: Items could temporarily boost stats (e.g., a potion that increases health).  
- **Specialized Rooms**: Introduce bonus rooms, secret paths, or traps.  
- **Timed Events**: Implement a countdown timer for completing objectives to increase tension.  

---

## **Exercise 6: Integration & Polishing 🚀**  
💡 **Goal**: Finalize and playtest your game. Ensure it meets functionality, playability, and performance expectations.

#### 📝 **Instructions**  

1. **Write Documentation**  
   - Add **JavaDoc comments** to all classes and methods.  
   - Document the purpose of each file.  
   - Provide a README summarizing the game theme, how to win/lose, and special features.  

2. **Test Your Game**  
   Test for:  
   - Logical errors (broken exits, imbalance in difficulty).  
   - Smooth and intuitive gameplay.  
   - Edge cases (e.g., entering invalid directions).  

3. Submit:  
   - Your complete source code.  
   - Data files for the game's assets (rooms, enemies, items).  
   - A design document or game map (can be hand-drawn or using tools like [diagrams.net](https://app.diagrams.net)).  

---

### 🔗 Submission Checklist  

- [ ] Game objects instantiated from files.  
- [ ] Functional mechanics: player movement, scoring, and enemy interactions.  
- [ ] At least **five interconnected rooms**.  
- [ ] Minimum of one creative feature.  
- [ ] Properly tested and debugged gameplay.  
- [ ] Javadoc and README documentation.  

---

### ✨ Bonus Extend Your Game  

If time permits, consider expanding to include:  
- Multiplayer capabilities (turn-based).  
- Saving/loading progress using additional files.  
- Advanced enemy/player skill trees (RPG-style).

Enjoy building your game & flexing your creativity! Your hero’s journey awaits. 🌟