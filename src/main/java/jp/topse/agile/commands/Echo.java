package jp.topse.agile.commands;

import jp.topse.agile.Shell;

public class Echo implements Base {

    @Override
    public void execute(String[] parameters, Shell.Output output) {
        for (int i = 1; i < parameters.length; ++i) {
            output.print(parameters[i]);
            if (i == parameters.length - 1) {
                output.print("\n");
            } else {
                output.print(" ");
            }
        }
    }
    
}
