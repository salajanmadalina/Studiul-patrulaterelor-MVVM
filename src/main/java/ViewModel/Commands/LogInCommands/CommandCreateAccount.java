package ViewModel.Commands.LogInCommands;

import Model.Dao.UserDAO;
import Model.User;
import ViewModel.Commands.ICommand;
import ViewModel.LogInVM;

import javax.swing.*;

public class CommandCreateAccount implements ICommand {
    private LogInVM logInVM;

    public CommandCreateAccount(LogInVM logInVM) {
        this.logInVM = logInVM;
    }

    @Override
    public void execute() {
        String password = logInVM.getPassField();
        String username = logInVM.getUserField();

        UserDAO userDAO = new UserDAO();
        int id = userDAO.findAll().size() + 2;
        if(!username.isEmpty() && !password.isEmpty()) {
            User user = new User(username, password, "ELEV", id);
            userDAO.insert(user);
            showMessage("Registered succesfully!");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

}
