package ViewModel;

import ViewModel.Commands.LogInCommands.CommandCreateAccount;
import ViewModel.Commands.LogInCommands.CommandLogIn;
import ViewModel.Commands.ICommand;
import ViewModel.Commands.LogInCommands.CommandLogInGuest;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class LogInVM {

    private Property<String> nameField;
    private Property<String> passwordField;
    private ICommand loginCommand;
    private ICommand logInGuestCommand;
    private ICommand createAccountCommand;

    public LogInVM(){
        nameField = PropertyFactory.createProperty("nameField", this, String.class);
        passwordField = PropertyFactory.createProperty("passwordField", this, String.class);
        loginCommand = new CommandLogIn(this);
        logInGuestCommand = new CommandLogInGuest(this);
        createAccountCommand = new CommandCreateAccount(this);
    }

    public String getUserField() {
        return nameField.get();
    }
    public String getPassField() {
        return passwordField.get();
    }
    public ICommand getLoginCommand() {
        return loginCommand;
    }
    public ICommand getLogInGuestCommand() {
        return logInGuestCommand;
    }
    public ICommand getCreateAccountCommand() {
        return createAccountCommand;
    }
}
