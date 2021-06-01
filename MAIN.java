import commands.*;

public class MAIN {
    public static void main(String[] args) {

        History history = new History();
        Shoot shoot = new Shoot();
        Help help = new Help();

        CommandReader dialog = new CommandReader(history, shoot, help);

        dialog.start_reading();
    }
}
