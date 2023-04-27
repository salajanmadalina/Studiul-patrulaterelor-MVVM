package ViewModel.Commands.AdminCommands;

import Model.Dao.UserDAO;
import Model.User;
import ViewModel.AdminVM;
import ViewModel.Commands.ICommand;

import java.util.ArrayList;

public class CommandInsertUser implements ICommand {
    private AdminVM adminVM;

    public CommandInsertUser(AdminVM adminVM) {
        this.adminVM = adminVM;
    }

    @Override
    public void execute() {
        String username = adminVM.getNameField();
        String password = adminVM.getPasswordField();
        String rol = adminVM.getRolField();

        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = (ArrayList<User>)userDAO.findAll();
        int id = users.size() + 2;

        if(!username.isEmpty() && !password.isEmpty() && !rol.isEmpty()) {
            User user = new User(username, password, rol, id);
            userDAO.insert(user);
        }
    }
}
