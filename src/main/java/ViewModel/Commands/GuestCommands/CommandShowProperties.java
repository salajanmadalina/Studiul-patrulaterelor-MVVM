package ViewModel.Commands.GuestCommands;

import Model.Patrulater;
import ViewModel.Commands.ICommand;
import ViewModel.GuestVM;

import java.util.ArrayList;

public class CommandShowProperties implements ICommand {
    private GuestVM guestVM;

    public CommandShowProperties(GuestVM guestVM) {
        this.guestVM = guestVM;
    }

    @Override
    public void execute() {
        String alX = guestVM.getMyX();
        String alY = guestVM.getMyY();
        String[] numbersX = alX.replaceAll("\\D+", " ").trim().split(" ");
        String[] numbersY = alY.replaceAll("\\D+", " ").trim().split(" ");
        ArrayList<Integer> coords = new ArrayList<>();

        for(int i = 0; i < 4; i ++){
            coords.add(Integer.valueOf(numbersX[i]));
            coords.add(Integer.valueOf(numbersY[i]));
        }

        Patrulater patrulater = new Patrulater(coords);

        guestVM.setTextArea(patrulater.toString());
        guestVM.setCerc(patrulater.cercuriStr());
        guestVM.setPMiguel(patrulater.punctMiguelStr());
        guestVM.setPNewton(patrulater.punctNewtonStr());
    }
}
