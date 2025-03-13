# Finnbot User Guide


Finnbot is a Personal Assistant Chatbot that helps you keep track of various tasks, 
events, and deadlines. It’s designed to make organizing your life easier by providing
you with a simple way to create, manage, and track your tasks in real-time. 
Finnbot is named after my beloved 7-year-old Ragdoll cat.


# Features 

Notes about the command format:
- Words in `UPPER_CASE` are the parameters to be supplied by the user. 
eg. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be 
used as `todo watch clothes`



## Adding todo: `todo`
Adds a todo to the task list

Format: `todo DESCRIPTION`

* Todo description cannot be empty

Example: `todo wash clothes`

Expected output:

```
Added todo task:
[T][ ]  wash clothes
```

## Adding deadlines: `deadline`

Add a deadline to the task list

Format: `deadline DESCRIPTION /by TIME`

* Deadline description and time cannot be empty

Example: `deadline finish projects /by sunday`

Expected output:
```
Added deadline:
[D][ ]  finish projects (by: sunday)
```

## Adding event: `event`

Add an event to the task list

Format: `event DESCRIPTION /from STARTTIME /to ENDTIME`

* Description, start time and end time of the event cannot be empty

Example: `event gala dinner /from monday 6pm /to monday 9pm`

Expected output:
```
Added event:
[E][ ]  gala dinner (from: monday 6pm , to: monday 9pm)
```

## List out tasks: `list`

List out all the tasks that have been added to the task list

Format: `list`


## Mark tasks as done `mark`

Mark a task as done based on the given task index

Format: `mark INDEX`

Example: `mark 1`

Expected output:

```
Meow! I marked this task as done:
[D][X]  finish projects (by: sunday)
```
## Unmark tasks `unmark`

Unmark a task based on the given task index

Format: `unmark INDEX`

Example: `unmark 1`

Expected output:

```
Meow! You unmarked this task:
[D][ ]  finish projects (by: sunday)
```

## Delete task `task`

Delete a task based on the specified task index

Format: `delete INDEX`

Example: `delete 2`

Expected output:

```
Meow! I've removed this task for you:
[T][ ]  wash clothes
Now you have 2 tasks
```

## Find tasks using keyword `find`

Search through task list for tasks that contain the specified keyword

Format: `find KEYWORD`

* The search is case-insensitive, eg gala will match GALA
* Only full words will be matched
* Find can only handle one full keyword during each execution

Example: `find gala`

Expected output:

```
Meowzzers! Here are the matching tasks:
1. [E][ ]  gala dinner (from: monday 6pm , to: monday 9pm)
```

## Exit Finnbot `bye`

Exit the program 

Example: `bye`
