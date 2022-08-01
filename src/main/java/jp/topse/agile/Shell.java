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

    public String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            while (input.isEmpty()) {
                System.out.print(" > ");
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
                System.out.print("Command Not Found.\n");
            }
        }
    }

    public void echo(String[] parameters) {
        Echo echo = new Echo();
        echo.execute(parameters);
    }
}
