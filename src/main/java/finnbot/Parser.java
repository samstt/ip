package finnbot;

import finnbot.command.*;
import finnbot.exceptions.EmptyInputException;
import finnbot.exceptions.InvalidCommandException;

public class Parser {


    public static Command parse(String input) throws InvalidCommandException, EmptyInputException {
        String[] words = input.split(" ", 2);
        String commandType = words[0].toLowerCase();

        switch (commandType) {

        case "list":
            return new ListCommand();

        case "mark":
            try {
                return new MarkCommand(Integer.parseInt(words[1]) - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new InvalidCommandException("HISSSS!! Provide a valid task number for me to mark");
            }

        case "unmark":
            try {
                return new UnmarkCommand(Integer.parseInt(words[1]) - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new InvalidCommandException("HISSSS! Provide a valid task number for me to unmark 3:");
            }

        case "delete":
            try {
                return new DeleteCommand(Integer.parseInt(words[1]) - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new InvalidCommandException("HISSSS! Provide a valid task number for me to delete 3:");
            }

        case "todo":
            if (words.length < 2 ) {
                throw new EmptyInputException("Todo format should be: todo [description]");
            } else if (words[1].trim().isEmpty()) {
                throw new EmptyInputException("HISSSS! Todo description cannot be empty!");
            }
            String todoDescription = words[1];
            return new ToDoCommand(todoDescription);

        case "event":
            input = input.replaceFirst("event", "");
            String[] parts = input.split("/from|/to");
            if (parts.length < 3 ) {
                throw new InvalidCommandException("Event format should be: event [description] /from [start] /to [end] , why don't you try again? :3");
            } else if (parts[0].trim().isEmpty()) {
                throw new InvalidCommandException("HISSSS! Event description cannot be empty");
            } else if (parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
                throw new InvalidCommandException("HISSSS! Start time or end time cannot be empty");
            }
            String eventDescription = parts[0];
            String start = parts[1];
            String end = parts[2];
            return new EventCommand(eventDescription, start, end);


        case "deadline":
            input = input.replaceFirst("deadline", "");
            String[] deadlineParts = input.split("/by");
            if (deadlineParts.length < 2) {
                throw new InvalidCommandException("Deadline format should be: deadline [description] /by [date], why don't you try it again?");
            } else if (deadlineParts[0].trim().isEmpty()) {
                throw new InvalidCommandException("HISSSS! Deadline description cannot be empty!!");
            } else if (deadlineParts[1].trim().isEmpty()) {
                throw new InvalidCommandException("HISSSS! Deadline date cannot be empty!!");
            }
            String deadlineDescription = deadlineParts[0];
            String by = deadlineParts[1];
            return new DeadlineCommand(deadlineDescription, by);

        case "bye":
            return new ExitCommand();

        default:
            throw new InvalidCommandException("Meoww, I'm not sure what you want me to do...");
        }

    }
}
