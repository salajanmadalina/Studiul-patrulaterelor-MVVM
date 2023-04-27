package ViewModel.Commands.UserCommands;

import Model.Dao.IntrebareDAO;
import Model.Dao.TestDAO;
import Model.Test;
import ViewModel.Commands.ICommand;
import ViewModel.UserVM;

import java.util.ArrayList;

public class CommandGenerateScore implements ICommand {
    private UserVM userVM;

    public CommandGenerateScore(UserVM userVM) {
        this.userVM = userVM;
    }

    @Override
    public void execute() {
        int id = Integer.parseInt(userVM.getIdTest());
        String answers = userVM.getTextAnswers();

        IntrebareDAO intrebareDAO = new IntrebareDAO();
        TestDAO testDAO = new TestDAO();
        Test test = testDAO.findById(id);
        String questions = test.getIntrebari();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        String[] tokens = questions.split(", ");
        for(String token: tokens){
            numbers.add(Integer.parseInt(token));
        }

        String correctAnswers = "";
        for(int i = 0; i < 10; i ++) {
            correctAnswers += intrebareDAO.findById(numbers.get(i)).getRaspuns() + "\n";
        }

        String[] strValues = answers.split("\n");
        String[] raspunsuriCorecte = correctAnswers.split("\n");

        int score = 0;
        for(int i = 0; i < strValues.length; i ++){
            if(strValues[i].equals(raspunsuriCorecte[i])){
                score++;
            }
        }

        testDAO.update("punctaj", String.valueOf(score), id);
        userVM.setTextScore(String.valueOf(score));
    }
}
