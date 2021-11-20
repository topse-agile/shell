package jp.topse.agile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.topse.agile.commands.Echo;

import java.io.InputStream;

public class Shell {

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.run();
    }

    public static interface Output {
        public void print(String s);
    }

    public static class DefaultOutput implements Output {
        public void print(String s) {
            System.out.print(s);
        }
    }

    private InputStream inputStream = System.in;

    private Output output = new DefaultOutput();

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String input = "";
        try {
            while (input.isEmpty()) {
                output.print(" > ");
                input = reader.readLine();
                input = input.trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return input;
    }

    public void run() {
        while (true) {
            String input = getInput();
            String[] parameters = input.split(" ");
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
