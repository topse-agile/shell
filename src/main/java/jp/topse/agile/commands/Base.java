package jp.topse.agile.commands;

import jp.topse.agile.Shell;

public interface Base {
    void execute(String[] parameters, Shell.Output output);
}
