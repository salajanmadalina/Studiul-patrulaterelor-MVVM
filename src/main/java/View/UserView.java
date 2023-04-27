package View;


import ViewModel.UserVM;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private static JFrame frame;
    @Bind(value = "text", target = "textArea.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea textArea;
    private JButton btnTest;
    private JButton btnGenereazaPunctaj;
    @Bind(value = "text", target = "textAnswers.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea textAnswers;
    @Bind(value = "text", target = "textScore.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea textScore;
    @Bind(value = "text", target = "idTest.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea idTest;
    private JButton btnBack;
    private JScrollPane scrollBar;
    private UserVM userVM;

    public UserView() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1125, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(39, 65, 479, 345);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textArea.setEditable(false);
        frame.getContentPane().add(textArea);

        scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(39, 75, 479, 345);
        frame.getContentPane().add(scrollBar);

        JLabel lblNewLabel_1 = new JLabel("Intrebari test");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(39, 23, 260, 27);
        frame.getContentPane().add(lblNewLabel_1);

        btnTest = new JButton("Genereaza Test");
        btnTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnTest.setBounds(39, 441, 187, 46);
        frame.getContentPane().add(btnTest);

        textAnswers = new JTextArea();
        textAnswers.setEditable(true);
        textAnswers.setBounds(600, 65, 479, 345);
        textAnswers.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(textAnswers);

        idTest = new JTextArea();
        idTest.setEditable(true);
        idTest.setBounds(200, 23, 150, 30);
        idTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(idTest);

        JLabel lblNewLabel_1_1 = new JLabel("Raspunsurile tale");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(600, 23, 260, 27);
        frame.getContentPane().add(lblNewLabel_1_1);

        textScore = new JTextArea();
        textScore.setEditable(false);
        textScore.setBounds(923, 441, 156, 51);
        textScore.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        frame.getContentPane().add(textScore);

        JLabel lblNewLabel_1_1_1 = new JLabel("Punctajul obtinut ");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(704, 460, 248, 27);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        btnGenereazaPunctaj = new JButton("Genereaza punctaj");
        btnGenereazaPunctaj.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnGenereazaPunctaj.setBounds(236, 441, 217, 46);
        frame.getContentPane().add(btnGenereazaPunctaj);

        btnBack = new JButton("Inapoi");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnBack.setBounds(463, 441, 156, 46);
        frame.getContentPane().add(btnBack);


        frame.setVisible(true);

        userVM = new UserVM();
        try {
            Binder.bind(this, userVM);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        btnTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userVM.getGenerateQuiz().execute();
            }
        });

        btnGenereazaPunctaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userVM.getGenerateScore().execute();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userVM.getBack().execute();
                frame.dispose();
            }
        });
    }


}
