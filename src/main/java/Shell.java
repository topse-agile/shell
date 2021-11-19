import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.run();
    }

    public void run() {
        while (true) {
            String input = getInput();
            if (input == null) {
                continue;
            }
            String[] parameters = parseInput(input);
            if ("exit".equals(parameters[0])) {
                break;
            } else if ("echo".equals(parameters[0])) {
                echo(parameters);
            } else {
                output("Command Not Found.\n");
            }
        }
    }

    void echo (String[] parameters) {
        for (int i = 1; i < parameters.length; ++i) {
            output(parameters[i]);
            if (i == parameters.length - 1) {
                output("\n");
            } else {
                output(" ");
            }
        }
    }

    private String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while (line.isEmpty()) {
                output(" > ");
                line = reader.readLine();
                line = line.trim();
            }
        } catch (IOException e) {
            return null;
        }
        return line;
    }

    private String[] parseInput(String input) {
        return input.split(" ");
    }

    private void output(String str) {
        System.out.print(str);
    }

}
