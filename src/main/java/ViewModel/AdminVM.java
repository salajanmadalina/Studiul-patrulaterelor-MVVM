package ViewModel;

import ViewModel.Commands.AdminCommands.*;
import ViewModel.Commands.ICommand;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class AdminVM {
    private Property<String> nameField;
    private Property<String> passwordField;
    private Property<String> rolField;
    private Property<String> idField;
    private Property<String> textArea;
    private ICommand insertUser;
    private ICommand deleteUser;
    private ICommand updateUser;
    private ICommand showAllUsers;
    private ICommand back;

    public AdminVM(){
        nameField = PropertyFactory.createProperty("nameField", this, String.class);
        passwordField = PropertyFactory.createProperty("passwordField", this, String.class);
        rolField = PropertyFactory.createProperty("rolField", this, String.class);
        idField = PropertyFactory.createProperty("idField", this, String.class);
        textArea = PropertyFactory.createProperty("textArea", this, String.class);
        deleteUser = new CommandDeleteUser(this);
        insertUser = new CommandInsertUser(this);
        updateUser = new CommandUpdateUser(this);
        showAllUsers = new CommandShowAllUsers(this);
        back = new CommandBack(this);
    }

    public String getNameField() {
        return nameField.get();
    }

    public String getPasswordField() {
        return passwordField.get();
    }

    public String getRolField() {
        return rolField.get();
    }

    public Integer getIdField() {
        return Integer.parseInt(idField.get());
    }

    public ICommand getInsertUser() {
        return insertUser;
    }

    public ICommand getDeleteUser() {
        return deleteUser;
    }

    public ICommand getUpdateUser() {
        return updateUser;
    }

    public ICommand getShowAllUsers() {
        return showAllUsers;
    }

    public ICommand getBack() {
        return back;
    }

    public void setTextArea(String textArea) {
        this.textArea.set(textArea);
    }
}
