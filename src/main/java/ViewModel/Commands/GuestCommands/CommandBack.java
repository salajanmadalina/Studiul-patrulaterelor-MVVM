package ViewModel.Commands.GuestCommands;

import View.LogInView;
import ViewModel.Commands.ICommand;
import ViewModel.GuestVM;

public class CommandBack implements ICommand {
    private GuestVM guestVM;

    public CommandBack(GuestVM guestVM) {
        this.guestVM = guestVM;
    }

    @Override
    public void execute() {
        new LogInView();
    }
}
