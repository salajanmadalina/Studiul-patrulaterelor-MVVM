package ViewModel.Commands.LogInCommands;

import View.GuestView;
import ViewModel.Commands.ICommand;
import ViewModel.LogInVM;

public class CommandLogInGuest implements ICommand {
    private LogInVM logInVM;

    public CommandLogInGuest(LogInVM logInVM) {
        this.logInVM = logInVM;
    }

    @Override
    public void execute() {
        new GuestView();
    }
}
