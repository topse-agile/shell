package jp.topse.agile.commands;

import jp.topse.agile.Shell;

public class Echo implements Base {

    @Override
    public void execute(String[] parameters) {
        for (int i = 1; i < parameters.length; ++i) {
            System.out.print(parameters[i]);
            if (i == parameters.length - 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }
    
}
