package View;

import ViewModel.AdminVM;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
    private static JFrame frame;
    @Bind(value = "text", target = "textArea.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea textArea;
    @Bind(value = "text", target = "idField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idField;
    @Bind(value = "text", target = "nameField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField nameField;
    @Bind(value = "text", target = "passwordField.value", type = BindingType.BI_DIRECTIONAL)
    private JPasswordField passwordField;
    @Bind(value = "text", target = "rolField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField rolField;
    private JButton btnBack;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnCreeaza;
    private JButton btnVizualizeazaListaUseri;
    private AdminVM adminVM;

    public AdminView(){
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1125, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(39, 65, 479, 345);
        textArea.setEditable(false);
        frame.getContentPane().add(textArea);

        JLabel lblNewLabel_1 = new JLabel("Lista utilizatori");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 33));
        lblNewLabel_1.setBounds(39, 23, 260, 27);
        frame.getContentPane().add(lblNewLabel_1);

        btnBack = new JButton("Inapoi");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnBack.setBounds(50, 452, 149, 46);
        frame.getContentPane().add(btnBack);

        btnVizualizeazaListaUseri = new JButton("Vizualizeaza lista useri");
        btnVizualizeazaListaUseri.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnVizualizeazaListaUseri.setBounds(763, 452, 290, 46);
        frame.getContentPane().add(btnVizualizeazaListaUseri);

        idField = new JTextField();
        idField.setBounds(823, 59, 143, 37);
        frame.getContentPane().add(idField);
        idField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("ID:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(721, 65, 70, 27);
        frame.getContentPane().add(lblNewLabel_1_1);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setBounds(823, 117, 143, 37);
        frame.getContentPane().add(nameField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Nume:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBounds(721, 118, 70, 27);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        btnDelete = new JButton("Sterge");
        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnDelete.setBounds(823, 245, 149, 46);
        frame.getContentPane().add(btnDelete);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(823, 175, 143, 37);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Parola:");
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1_1_1.setBounds(721, 176, 92, 27);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnUpdate.setBounds(823, 310, 149, 46);
        frame.getContentPane().add(btnUpdate);

        btnCreeaza = new JButton("Creeaza");
        btnCreeaza.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnCreeaza.setBounds(823, 378, 149, 46);
        frame.getContentPane().add(btnCreeaza);

        rolField = new JTextField();
        rolField.setColumns(10);
        rolField.setBounds(823, 10, 143, 37);
        frame.getContentPane().add(rolField);

        JLabel lblNewLabel_1_1_2 = new JLabel("Rol:");
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1_2.setBounds(721, 23, 70, 27);
        frame.getContentPane().add(lblNewLabel_1_1_2);

        frame.setVisible(true);

        adminVM = new AdminVM();
        try {
            Binder.bind(this, adminVM);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminVM.getDeleteUser().execute();
                adminVM.getShowAllUsers().execute();
            }
        });

        btnCreeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminVM.getInsertUser().execute();
                adminVM.getShowAllUsers().execute();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminVM.getUpdateUser().execute();
                adminVM.getShowAllUsers().execute();
            }
        });

        btnVizualizeazaListaUseri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminVM.getShowAllUsers().execute();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminVM.getBack().execute();
                frame.dispose();
            }
        });
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

}
