package ViewModel.Commands.UserCommands;

import View.LogInView;
import ViewModel.Commands.ICommand;
import ViewModel.UserVM;

public class CommandBack implements ICommand {
    private UserVM userVM;

    public CommandBack(UserVM userVM) {
        this.userVM = userVM;
    }

    @Override
    public void execute() {
        new LogInView();
    }
}
