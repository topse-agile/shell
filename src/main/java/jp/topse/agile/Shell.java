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
            String input = "";
            try {
                while (input.isEmpty()) {
                    input = reader.readLine();
                    input = input.trim();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return input;
        }
    };

    private Output output = new Output() {
        @Override
        public void print(String s) {
            System.out.print(s);
        }
    };

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void run() {
        while (true) {
            output.print(prompt);
            String command = input.getLine();
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
