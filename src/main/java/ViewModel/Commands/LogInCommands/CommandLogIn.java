package ViewModel.Commands.LogInCommands;

import Model.Dao.UserDAO;
import Model.User;
import View.AdminView;
import View.GuestView;
import View.UserView;
import ViewModel.Commands.ICommand;
import ViewModel.LogInVM;
import java.util.ArrayList;

public class CommandLogIn implements ICommand {

    private LogInVM logInVM;

    public CommandLogIn() {
    }

    public CommandLogIn(LogInVM logInVM) {
        this.logInVM = logInVM;
    }

    @Override
    public void execute() {
        String userName = logInVM.getUserField();
        String password = logInVM.getPassField();

        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = (ArrayList<User>)userDAO.findAll();
        User user = getRegisteredUser(users, userName, password);
        if( user!= null){
            showUserInterface(user);
        }

    }

    private User getRegisteredUser( ArrayList<User> users, String userName, String password){
        for(User user: users){
            if(user.getNume().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    private void showUserInterface(User user){
        switch (user.getRol()){
            case "ADMIN":
                new AdminView();
                break;
            case "ELEV":
                new UserView();
                break;
        }
    }
}
