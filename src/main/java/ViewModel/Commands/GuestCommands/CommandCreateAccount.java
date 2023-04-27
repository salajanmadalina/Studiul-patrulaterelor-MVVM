package ViewModel.Commands.GuestCommands;

import View.LogInView;
import ViewModel.Commands.ICommand;
import ViewModel.GuestVM;

public class CommandCreateAccount implements ICommand {
    private GuestVM guestVM;

    public CommandCreateAccount(GuestVM guestVM) {
        this.guestVM = guestVM;
    }

    @Override
    public void execute() {
        new LogInView();
    }
}
