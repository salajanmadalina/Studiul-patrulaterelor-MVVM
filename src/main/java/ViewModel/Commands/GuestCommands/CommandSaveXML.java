package ViewModel.Commands.GuestCommands;

import Model.Patrulater;
import ViewModel.Commands.ICommand;
import ViewModel.GuestVM;
import com.thoughtworks.xstream.XStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CommandSaveXML implements ICommand {
    private GuestVM guestVM;

    public CommandSaveXML(GuestVM guestVM) {
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

        XStream xstream = new XStream();
        xstream.alias("patrulater", Patrulater.class);

        String xml = xstream.toXML(patrulater);
        try {
            FileWriter writer = new FileWriter("D:\\UTCN\\ANUL 3\\SEM 2\\PS\\proiect2\\src\\main\\java\\patrulater.xml");

            writer.write(xml + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
