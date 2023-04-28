package ViewModel;

import ViewModel.Commands.GuestCommands.*;
import ViewModel.Commands.ICommand;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class GuestVM {
    private ICommand back;
    private ICommand createAccount;
    private ICommand showProperties;
    private ICommand loadXML;
    private ICommand saveXML;
    private Property<String> textArea;
    private Property<String> myX;
    private Property<String> myY;
    private Property<String> cerc;

    public GuestVM(){
        textArea = PropertyFactory.createProperty("textArea", this, String.class);
        myX = PropertyFactory.createProperty("myX", this, String.class);
        myY = PropertyFactory.createProperty("myY", this, String.class);
        cerc = PropertyFactory.createProperty("cerc", this, String.class);
        back = new CommandBack(this);
        createAccount = new CommandCreateAccount(this);
        showProperties = new CommandShowProperties(this);
        loadXML = new CommandLoadXML(this);
        saveXML = new CommandSaveXML(this);
    }

    public void setTextArea(String textArea){this.textArea.set(textArea);}

    public String getMyX(){return myX.get();}

    public String getMyY(){return myY.get();}

    public void setMyX(String myX) {
        this.myX.set(myX);
    }

    public void setMyY(String myY) {
        this.myY.set(myY);
    }

    public ICommand getBack() {
        return back;
    }

    public ICommand getCreateAccount() {
        return createAccount;
    }

    public ICommand getShowProperties() {
        return showProperties;
    }

    public ICommand getLoadXML() {
        return loadXML;
    }

    public ICommand getSaveXML() {
        return saveXML;
    }

    public void setCerc(String cerc) {
        this.cerc.set(cerc);
    }
}
