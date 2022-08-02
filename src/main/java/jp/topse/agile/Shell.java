package jp.topse.agile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.topse.agile.commands.Echo;

import java.io.InputStream;

public class Shell {

    public static final String prompt = " > ";

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.run();
    }

    public static interface Input {
        public String getLine();
    }

    public static interface Output {
        public void print(String s);
    }

    private Input input = new Input() {
        @Override
        public String getLine() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = "";
            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return command;
        }
    };

    private Output output = new Output() {
        @Override
        public void print(String s) {
            System.out.print(s);
        }
    };

    private String readLine() {
        String command = "";
        while (command.isEmpty()) {
            output.print(prompt);
            command = input.getLine();
            command = command.trim();
        }
        return command;
    }

    public void run() {
        while (true) {
            String command = readLine();
            String[] parameters = command.split(" ");
            if ("exit".equals(parameters[0])) {
                break;
            } else if ("echo".equals(parameters[0])) {
                echo(parameters);
            } else {
                output.print("Command Not Found.\n");
            }
        }
    }

    public void echo(String[] parameters) {
        Echo echo = new Echo();
        echo.execute(parameters, output);
    }
}
