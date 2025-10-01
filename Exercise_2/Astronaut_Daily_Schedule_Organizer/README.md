# Astronaut Daily Schedule Organizer  

## Use Case  
Astronauts on space missions must follow highly structured schedules with zero conflicts.  
This console-based application helps astronauts organize their daily tasks with descriptions, timings, and priorities.  
It ensures no overlapping tasks, supports rescheduling, and provides a clear summary of daily activities.  

## Functionalities  

### Mandatory  
- **Add Task** – Add a new task with description, start time, end time, and priority.  
- **Remove Task** – Delete a task by its description.  
- **View All Tasks (sorted by time)** – Display tasks in chronological order.  
- **Conflict Detection** – Prevents overlapping tasks.  
- **Error Handling** – Proper messages for invalid time, task not found, etc.  

### Optional (Implemented)  
- **Edit Task** – Update description, timings, or priority.  
- **Mark Task as Completed** – Track finished tasks.  
- **View Tasks by Priority** – Filter tasks by LOW, MEDIUM, or HIGH priority.  

## Additional Functionalities Implemented
- **Conflict Resolution Suggestion** – If a conflict occurs, system suggests the next available slot and asks the user whether to schedule automatically.  
- **Daily Summary Report** – Displays total tasks, completed vs pending, and breakdown by priority (with descriptions).  
- **Dynamic Rescheduling** – Tasks can be edited without restarting the program.  
- **Input Validation** – Handles invalid priorities and malformed times.  
- **Logging Utility** – Tracks application usage and errors.  

## Design Patterns Used  
- **Singleton Pattern** – ScheduleManager ensures only one instance manages all tasks.  
- **Factory Pattern** – TaskFactory centralizes creation of Task objects.  
- **Observer Pattern** – ConflictObserver alerts users when conflicts arise.  

## Output Screenshots  
### Positive cases
### Adding a Task 
![alt text](<screenshots/add Task.png>)
![alt text](<screenshots/add Task(1).png>)
![alt text](<screenshots/add Task(2).png>)

### View All Tasks – show tasks sorted by start time
![View Tasks Screenshot](<screenshots/view task.png>)

### Edit Task – show updating a task.
![Edit Task Screenshot](<screenshots/edit Task.png>)

### Mark Task Completed – show marking a task as completed.
![Mark Completed Screenshot](<screenshots/mark_as_complete.png>)

### Remove an existing task
![Mark Completed Screenshot](<screenshots/remove task.png>)

### View by priority-show filtering tasks by priority.
![View By Priority Screenshot](<screenshots/view as priority.png>)

### Daily Summary – show total, completed, pending tasks, and descriptions.
![Daily Summary Screenshot](<screenshots/Daily Summary.png>)

### Negative Cases

### Conflict/Error Handling – show task conflict error and suggested slot.
![Conflict Resolution Screenshot](<screenshots/task conflict and suggestion.png>)

### Remove Task - Task not found error
![Remove Screenshot](<screenshots/Task not found.png>)

### view Task-when no task exist
![alt text](<screenshots/view task error.png>)

### Invalid Time Task
![alt text](<screenshots/invalid time task.png>)





