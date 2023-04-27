package ViewModel.Commands.AdminCommands;

import View.LogInView;
import ViewModel.AdminVM;
import ViewModel.Commands.ICommand;

public class CommandBack implements ICommand {
    private AdminVM adminVM;

    public CommandBack(AdminVM adminVM) {
        this.adminVM = adminVM;
    }

    @Override
    public void execute() {
        new LogInView();
    }
}
