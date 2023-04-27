package ViewModel.Commands.GuestCommands;

import Model.Patrulater;
import ViewModel.Commands.ICommand;
import ViewModel.GuestVM;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import java.io.FileReader;
import java.io.IOException;

public class CommandLoadXML implements ICommand {
    private GuestVM guestVM;

    public CommandLoadXML(GuestVM guestVM) {
        this.guestVM = guestVM;
    }

    @Override
    public void execute() {
        Patrulater patrulater = new Patrulater();

        XStream xstream = new XStream();
        xstream.alias("patrulater", Patrulater.class);

        XStream.setupDefaultSecurity(xstream);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.addPermission(new ExplicitTypePermission(new Class[] { Patrulater.class }));

        try {
            FileReader reader = new FileReader("D:\\UTCN\\ANUL 3\\SEM 2\\PS\\proiect2\\src\\main\\java\\patrulater.xml");
            patrulater = (Patrulater) xstream.fromXML(reader);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String textX = patrulater.getP1().getX() + " " + patrulater.getP2().getX() + " " + patrulater.getP3().getX() + " " + patrulater.getP4().getX() + " " + patrulater.getP1().getX();
        String textY = patrulater.getP1().getY() + " " + patrulater.getP2().getY() + " " + patrulater.getP3().getY() + " " + patrulater.getP4().getY() + " " + patrulater.getP1().getY();

        guestVM.setMyX(textX);
        guestVM.setMyY(textY);

    }
}
