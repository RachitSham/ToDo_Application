# ToDo_Application

🚀 Fearures:-

🔹 Task Class – Represents a to-do item (ID + text) with equality checks (equals & hashCode).

🔹 TaskService – Handles:

🔹 Adding tasks with validation (no blank tasks).

🔹 Removing tasks by ID.

🔹 Returning an unmodifiable list of tasks.

🔹 ToDoFrame – GUI implementation:

🔹 Text field + “Add” button to create tasks.

🔹 Task list display in a scrollable area.

🔹 “Delete” button to remove selected tasks.

🔹 Validation messages via JOptionPane.

🔹 Main Class – Initializes TaskService & launches ToDoFrame on the Swing Event Dispatch Thread.

🚀 Functional Flow:-

🔹 User types task → clicks “Add” or presses Enter → TaskService.add() → Refresh task list.

🔹 User selects a task → clicks “Delete” → TaskService.removeById() → Refresh list.

🔹 Input validation prevents blank tasks and shows warning popups.

📌 References :-

🔹 I used ChatGPT to refine the grammar and structure of the key points explaining my code .

🔹 I have take the help of ChatGpt and GeeksforGeeks [https://www.geeksforgeeks.org] to explore the Java Swing .

🔹 For Code Review and for exception came in the application I Used ChatGpt.

🔹 Additionally, I referred to GeeksforGeeks [https://www.geeksforgeeks.org] for conceptual guidance and coding references to ensure clarity and correctness in my implementation.
