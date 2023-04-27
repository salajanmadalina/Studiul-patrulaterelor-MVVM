package ViewModel.Commands.AdminCommands;

import Model.Dao.UserDAO;
import Model.User;
import ViewModel.AdminVM;
import ViewModel.Commands.ICommand;

import javax.swing.*;

public class CommandDeleteUser implements ICommand {
    private AdminVM adminVM;

    public CommandDeleteUser(AdminVM adminVM) {
        this.adminVM = adminVM;
    }

    public CommandDeleteUser() {

    }

    @Override
    public void execute() {
       int id = adminVM.getIdField();
       UserDAO userDAO = new UserDAO();
       User user =  userDAO.findById(id);

       if(user != null){
           userDAO.delete(id);
       }
       else{
           showMessage("The user with this id doesn't exist!");
       }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

}
