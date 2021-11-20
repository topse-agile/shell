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
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            try {
                while (input.isEmpty()) {
                    output(" > ");
                    input = reader.readLine();
                    input = input.trim();
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            String[] parameters = input.split(" ");
            if ("exit".equals(parameters[0])) {
                break;
            } else if ("echo".equals(parameters[0])) {
                for (int i = 1; i < parameters.length; ++i) {
                    System.out.print(parameters[i]);
                    if (i == parameters.length - 1) {
                        System.out.print(("\n");
                    } else {
                        System.out.print((" ");
                    }
                }
            } else {
                System.out.print("Command Not Found.\n");
            }
        }
    }
}
