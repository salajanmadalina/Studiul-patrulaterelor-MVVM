package ViewModel.Commands.AdminCommands;

import Model.Dao.UserDAO;
import ViewModel.AdminVM;
import ViewModel.Commands.ICommand;

public class CommandUpdateUser implements ICommand {
    private AdminVM adminVM;

    public CommandUpdateUser(AdminVM adminVM) {
        this.adminVM = adminVM;
    }

    @Override
    public void execute() {
        String username = adminVM.getNameField();
        String password = adminVM.getPasswordField();
        String rol = adminVM.getRolField();
        int id = adminVM.getIdField();
        UserDAO userDAO = new UserDAO();

        if(!username.isEmpty()){
            userDAO.update("nume", username, id);
        }
        if(!password.isEmpty()){
            userDAO.update("password", password, id);
        }
        if(!rol.isEmpty()){
            userDAO.update("rol", rol, id);
        }
    }
}
