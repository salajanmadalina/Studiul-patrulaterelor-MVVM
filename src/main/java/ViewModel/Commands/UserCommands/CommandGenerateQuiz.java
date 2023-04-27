package ViewModel.Commands.UserCommands;

import Model.Dao.IntrebareDAO;
import Model.Dao.TestDAO;
import Model.Test;
import ViewModel.Commands.ICommand;
import ViewModel.UserVM;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class CommandGenerateQuiz implements ICommand {
    private UserVM userVM;

    public CommandGenerateQuiz(UserVM userVM) {
        this.userVM = userVM;
    }

    @Override
    public void execute() {
        ArrayList<Integer> intrebari = new ArrayList<Integer>();
        Random rand = new Random();
        int num;
        IntrebareDAO intrebareDAO = new IntrebareDAO();
        TestDAO testDAO = new TestDAO();

        for (int i = 0; i < 10; i++) {
            while(true){
                num = rand.nextInt((10 - 1) + 1) + 1;
                if(!intrebari.contains(num)){
                    intrebari.add(num);
                    break;
                }
            }
        }

        String intrebariText = intrebari.stream().map(Object::toString).collect(Collectors.joining(", "));

        String text = "";
        for(int i = 0; i < 10; i ++){
            text += intrebareDAO.findById(intrebari.get(i)).getIntrebare() + "\n";
        }

        int id = testDAO.findAll().size() + 1;
        testDAO.insert(new Test(id, 0, intrebariText));

        userVM.setTextArea(text);
        userVM.setIdTest(String.valueOf(id));
    }
}
