import commands.*;
import java.util.Scanner;

public class CommandReader {
    History history;
    Shoot shoot;
    Help help;

    CommandReader(History history, Shoot shoot, Help help) {
        this.history = history;
        this.help = help;
        this.shoot = shoot;
    }

    public void start_reading() {
        System.out.println("Enter help to see the available list of commands :)");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().toLowerCase();
        String[] commandParts;
        commandParts = command.split(" ", 4);
        while (!commandParts[0].equals("exit")) {
            switch (commandParts[0]) {
                case "":
                    break;
                case "help":
                    help.run(commandParts);
                    break;
                case "shot":
                    shoot.shoot(history);
                    break;
                case "history":
                    history.show();
                    break;
                default:
                    System.out.println('"' + command + "\" is not a command. Use help for a list of available commands.");
                    break;
            }
            command = sc.nextLine().toLowerCase();
            commandParts = command.split(" ", 4);
        }
    }
}

