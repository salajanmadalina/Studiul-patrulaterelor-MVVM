package ViewModel.Commands.AdminCommands;

import Model.Dao.UserDAO;
import Model.User;
import ViewModel.AdminVM;
import ViewModel.Commands.ICommand;

import java.util.ArrayList;

public class CommandShowAllUsers implements ICommand {
    private AdminVM adminVM;

    public CommandShowAllUsers(AdminVM adminVM) {
        this.adminVM = adminVM;
    }

    @Override
    public void execute() {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = (ArrayList<User>)userDAO.findAll();
        String info = "";

        for(User u: users){
            info += u.toString();
        }

        adminVM.setTextArea(info);
    }
}
