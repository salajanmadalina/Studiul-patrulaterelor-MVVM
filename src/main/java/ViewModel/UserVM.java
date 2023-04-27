package ViewModel;

import ViewModel.Commands.GuestCommands.CommandLoadXML;
import ViewModel.Commands.ICommand;
import ViewModel.Commands.UserCommands.CommandBack;
import ViewModel.Commands.UserCommands.CommandGenerateQuiz;
import ViewModel.Commands.UserCommands.CommandGenerateScore;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class UserVM {
    private Property<String> textArea;
    private Property<String> textAnswers;
    private Property<String> textScore;
    private Property<String> idTest;
    private ICommand generateQuiz;
    private ICommand generateScore;
    private ICommand back;

    public UserVM(){
        textArea = PropertyFactory.createProperty("textArea", this, String.class);
        textAnswers = PropertyFactory.createProperty("textAnswers", this, String.class);
        textScore = PropertyFactory.createProperty("textScore", this, String.class);
        idTest = PropertyFactory.createProperty("idTest", this, String.class);
        generateQuiz = new CommandGenerateQuiz(this);
        generateScore = new CommandGenerateScore(this);
        back = new CommandBack(this);
    }

    public ICommand getGenerateQuiz() {
        return generateQuiz;
    }

    public void setTextArea(String textArea) {
        this.textArea.set(textArea);
    }

    public void setIdTest(String idTest){this.idTest.set(idTest);}

    public String getIdTest(){return idTest.get();}

    public void setTextAnswers(String textAnswers) {
        this.textAnswers.set(textAnswers);
    }

    public void setTextScore(String textScore) {
        this.textScore.set(textScore);
    }

    public String getTextArea() {
        return textArea.get();
    }

    public String getTextAnswers() {
        return textAnswers.get();
    }

    public String getTextScore() {
        return textScore.get();
    }

    public ICommand getGenerateScore() {
        return generateScore;
    }

    public ICommand getBack() {
        return back;
    }
}
