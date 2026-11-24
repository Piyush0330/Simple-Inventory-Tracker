📦 SIMPLE INVENTORY TRACKER

📌 Project Overview

The Simple Inventory Tracker is a console-based Java application designed to manage inventory and stock information for a small shop. It allows users to add new items, display all available items, search items by name, sell items, generate low-stock reports, and sort items according to their quantity.

The application uses Java OOP concepts, ArrayList, searching, sorting, methods, and file handling to maintain inventory records.

🎯 Objectives
Add new items with unique item IDs.
Display all registered items.
Search items by name or item ID.
Sell items and update stock quantities.
Restock items when required.
Generate a low-stock report (quantity below 5).
Sort items by quantity (low to high).
Validate item information.
Store inventory records permanently using file handling.
🛠️ Technologies Used
Programming Language: Java
IDE: VS Code / IntelliJ IDEA / Eclipse
Data Structure: ArrayList
File Handling: FileReader, FileWriter, BufferedReader, PrintWriter
Algorithms: Linear Search and Bubble Sort
✨ Features
Add Item: Add new inventory items with item name, quantity, and price.
Display All Items: Display all available inventory records.
Search Item: Find items using their item ID or name.
Sell Item: Sell products and automatically decrease the available stock quantity.
Low Stock Report: Display items whose quantity is below 5.
Sort by Quantity: Arrange items from lowest quantity to highest quantity.
File Handling: Save and load inventory records using inventory.txt.
Input Validation:
Item name cannot be empty.
Quantity cannot be negative.
Price must be greater than 0.
Selling quantity must be greater than 0.
Selling quantity cannot exceed available stock.
🆔 Item ID Generation

Item IDs are automatically generated in sequence.

First item ID: I101
Second item ID: I102
Third item ID: I103

Item IDs continue from previously saved records when the application restarts.

📂 Project Structure

Simple-Inventory-Tracker/

├── SimpleInventoryTracker.java

├── inventory.txt

└── README.md

💻 How to Run the Project

Step 1: Install Java JDK.

Step 2: Open the project folder in VS Code or any Java IDE.

Step 3: Open the terminal and compile the program.

bash
javac SimpleInventoryTracker.java


Step 4: Run the application.

bash
java SimpleInventoryTracker

📋 Application Menu
text
===== SIMPLE INVENTORY TRACKER =====

1. Add Item
2. Display All Items
3. Search Item
4. Sell Item
5. Low Stock Report
6. Sort by Quantity
7. Exit

Enter your choice:

🧪 Sample Test Cases
Test Case	Input	Expected Result
Normal Input	Notebook, Quantity: 50, Price: 40	Item added. ID: I101
Minimum Input	I101, Sell Quantity: 5	Stock updated. Quantity: 0
Invalid Input	I101, Sell Quantity: 20 when stock is 10	Insufficient stock. Available: 10
Different Valid Scenario	Pen, Quantity: 3, Price: 10	Item added. ID: I102
Search	Search I102	I102 | Pen | Qty: 3
Low Stock	Quantity below 5	I102 | Pen | 3
Sorting	Sort by quantity	Items displayed from low to high
🧠 Concepts Implemented
Classes and Objects
Constructors
ArrayList
Methods
Linear Searching
Bubble Sorting
File Handling
Exception Handling
Loops and Conditional Statements
Input Validation
Automatic ID Generation
⏱️ Algorithm Complexity
Operation	Algorithm	Time Complexity
Add Item	ArrayList insertion	O(1) amortized
Display Items	Traversal	O(n)
Search Item	Linear Search	O(n)
Sell Item	Linear Search	O(n)
Low Stock Report	Traversal	O(n)
Sort by Quantity	Bubble Sort	O(n²)
💾 Data Storage

All inventory records are stored in a text file named inventory.txt.

Example:

text
I101 | NOTEBOOK | 50 | 40
I102 | PEN | 3 | 10
I103 | PENCIL | 20 | 5


The application loads existing inventory records when it starts and saves updated records when the user exits.

Output:
<img width="2940" height="1912" alt="38290B53-4056-4C46-BC0F-421BB55FE2B3" src="https://github.com/user-attachments/assets/45018327-d556-47fd-a0dc-52cbff1af77d" />

🚀 Future Enhancements
Update item details.
Delete inventory records.
Add product categories.
Add a separate restock option.
Generate total inventory value.
Add supplier management.
Introduce a graphical user interface (GUI).
Integrate a database such as MySQL.
Add administrator login and authentication.
🎓 Conclusion

The Simple Inventory Tracker demonstrates the practical implementation of Java programming concepts in a real-world inventory management scenario.

It provides basic inventory management through item registration, displaying, searching, selling, low-stock reporting, sorting, and file handling.

This project improves understanding of object-oriented programming, data structures, algorithms, exception handling, and file operations in Java.

📌 Project Details

Project Title: Simple Inventory Tracker

PS Number: 25

Programming Language: Java

Project Type: Console-Based Application

Data Structure: ArrayList

Storage File: inventory.txt

First Item ID: I101

Low Stock Limit: Below 5

Sorting Order: Quantity (Low to High)

Difficulty Level: Beginner
