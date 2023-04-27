package View;

import ViewModel.LogInVM;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView extends JFrame{

    private static JFrame frame;
    @Bind(value = "text", target = "nameField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField nameField;
    @Bind(value = "text", target = "passwordField.value", type = BindingType.BI_DIRECTIONAL)
    private JPasswordField passwordField;
    private JButton guestMode;
    private JButton logIn;
    private JButton btnRegister;
    private LogInVM vm;

    public static void main(String[] args) {
        LogInView view = new LogInView();
    }

    public LogInView(){
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 934, 503);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        guestMode = new JButton("Mod invitat");
        guestMode.setFont(new Font("Times New Roman", Font.BOLD, 20));
        guestMode.setBounds(138, 209, 146, 50);
        frame.getContentPane().add(guestMode);

        logIn = new JButton("Conectare");
        logIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        logIn.setBounds(442, 386, 146, 50);
        frame.getContentPane().add(logIn);

        nameField = new JTextField();
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameField.setBounds(518, 176, 164, 50);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordField.setBounds(518, 243, 164, 50);
        frame.getContentPane().add(passwordField);

        JLabel lblUsername = new JLabel("Nume:");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblUsername.setBounds(414, 176, 94, 50);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Parola:");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPassword.setBounds(414, 241, 94, 50);
        frame.getContentPane().add(lblPassword);

        JLabel lblStudiulPatrulaterelor = new JLabel("STUDIUL PATRULATERELOR");
        lblStudiulPatrulaterelor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
        lblStudiulPatrulaterelor.setBounds(281, 31, 396, 80);
        frame.getContentPane().add(lblStudiulPatrulaterelor);

        btnRegister = new JButton("Inregistreaza-te");
        btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRegister.setBounds(628, 386, 171, 50);
        frame.getContentPane().add(btnRegister);

        frame.setVisible(true);

       vm = new LogInVM();
        try{
            Binder.bind(this, vm);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.getLoginCommand().execute();
                frame.dispose();
            }
        });

        guestMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.getLogInGuestCommand().execute();
                frame.dispose();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.getCreateAccountCommand().execute();
            }
        });
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(new JFrame(), message);
    }
}
