package View;

import ViewModel.GuestVM;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GuestView extends JFrame {
    private Color roz = new Color(204, 153, 153);
    private Color albastru = new Color(63, 127, 190);
    private Color verde = new Color(52, 136, 56);
    private static JFrame frame;
    @Bind(value = "text", target = "textArea.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea textArea;
    private JButton btnSolicitareCont;
    private JButton btnAfisareDate;
    private JPanel panelCircle;
    private JPanel panel;
    private JButton btnBack;
    private JComboBox comboBox;
    private JScrollPane scrollBar;
    private JButton btnSavePatrulater;
    private JButton btnLoadPatrulater;
    @Bind(value = "text", target = "myX.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea myX = new JTextArea();
    @Bind(value = "text", target = "myY.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea myY = new JTextArea();
    @Bind(value = "text", target = "cerc.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea cerc = new JTextArea();
    private ArrayList<Integer> alX = new ArrayList<>();
    private ArrayList<Integer> alY = new ArrayList<>();
    private int x, y;
    private GuestVM guestVM;
    private Graphics g;
    private Graphics g2;
    private MouseListener m2;
    @Bind(value = "text", target = "pMiguel.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea pMiguel = new JTextArea();
    @Bind(value = "text", target = "pNewton.value", type = BindingType.BI_DIRECTIONAL)
    private JTextArea pNewton = new JTextArea();

    public GuestView(){
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1125, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(538, 65, 260, 236);
        frame.getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Deseneaza un patrulater!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel.setBounds(538, 23, 260, 32);
        frame.getContentPane().add(lblNewLabel);

        textArea = new JTextArea();
        textArea.setBounds(39, 65, 479, 345);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textArea.setEditable(false);
        frame.getContentPane().add(textArea);

        scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(39, 75, 479, 345);
        frame.getContentPane().add(scrollBar);

        JLabel lblNewLabel_1 = new JLabel("Caracteristici patrulater");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(39, 23, 260, 27);
        frame.getContentPane().add(lblNewLabel_1);

        btnSolicitareCont = new JButton("Inregistreaza-te!");
        btnSolicitareCont.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnSolicitareCont.setBounds(866, 471, 213, 46);

        frame.getContentPane().add(btnSolicitareCont);

        btnAfisareDate = new JButton("Apasa aici!");
        btnAfisareDate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnAfisareDate.setBounds(636, 426, 149, 46);

        frame.getContentPane().add(btnAfisareDate);

        panelCircle = new JPanel();
        panelCircle.setBounds(819, 65, 260, 236);
        frame.getContentPane().add(panelCircle);

        JLabel lblNewLabel_2 = new JLabel("Cercuri speciale");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(819, 21, 170, 36);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("Nu ai un cont?");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(888, 434, 178, 27);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Doresti sa afli mai multe despre patrulaterul desenat?");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBounds(49, 434, 559, 27);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        btnBack = new JButton("Inapoi");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnBack.setBounds(636, 487, 149, 46);

        frame.getContentPane().add(btnBack);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"ROZ", "ALBASTRU", "VERDE"}));
        comboBox.setSelectedIndex(1);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox.setBounds(888, 311, 162, 32);
        frame.getContentPane().add(comboBox);

        JLabel lblSelecteazaCuloareaPentru = new JLabel("Selecteaza culoarea pentru desen:");
        lblSelecteazaCuloareaPentru.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblSelecteazaCuloareaPentru.setBounds(538, 311, 342, 32);
        frame.getContentPane().add(lblSelecteazaCuloareaPentru);

        btnSavePatrulater = new JButton("Salveaza patrulaterul");
        btnSavePatrulater.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnSavePatrulater.setBounds(330, 487, 260, 46);
        frame.getContentPane().add(btnSavePatrulater);

        btnLoadPatrulater = new JButton("Incarca patrulaterul");
        btnLoadPatrulater.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnLoadPatrulater.setBounds(60, 487, 260, 46);
        frame.getContentPane().add(btnLoadPatrulater);

        frame.setVisible(true);

        m2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                alX.add(x);
                alY.add(y);

                g = panel.getGraphics();
                if (comboBox.getSelectedItem().toString().equals("ROZ"))
                    g.setColor(roz);
                if (comboBox.getSelectedItem().toString().equals("ALBASTRU"))
                    g.setColor(albastru);
                if (comboBox.getSelectedItem().toString().equals("VERDE"))
                    g.setColor(verde);

                g.fillRect(x-3, y-3, 6, 6);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                alX.clear();
                alY.clear();
                panel.getGraphics().clearRect(0, 0, panel.getWidth(), panel.getHeight());
                panelCircle.getGraphics().clearRect(0, 0, panelCircle.getWidth(), panelCircle.getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int[] xArray = new int[5];
                int[] yArray = new int[5];
                int i;

                for(i = 0; i < alX.size(); i ++){
                    xArray[i] = alX.get(i);
                    yArray[i] = alY.get(i);
                }

                myX.setText(alX.toString());
                myY.setText(alY.toString());

                xArray[i] = xArray[0];
                yArray[i] = yArray[0];

                g2 = panel.getGraphics();
                if (comboBox.getSelectedItem().toString().equals("ROZ"))
                    g2.setColor(roz);
                if (comboBox.getSelectedItem().toString().equals("ALBASTRU"))
                    g2.setColor(albastru);
                if (comboBox.getSelectedItem().toString().equals("VERDE"))
                    g2.setColor(verde);

                g2.drawPolyline(xArray, yArray, alX.size()+1 );
            }
        };
        panel.addMouseListener(m2);

        frame.setVisible(true);

        guestVM = new GuestVM();
        try {
            Binder.bind(this, guestVM);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestVM.getBack().execute();
                frame.dispose();
            }
        });

        btnSolicitareCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestVM.getCreateAccount().execute();
                frame.dispose();
            }
        });

        btnAfisareDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestVM.getShowProperties().execute();
                Graphics g3 = panelCircle.getGraphics();
                String[] coords = cerc.getText().split(" ");
                String[] punctMiguel = pMiguel.getText().split(" ");
                String[] punctNewton = pNewton.getText().split(" ");
                g3.drawOval((Integer.parseInt(coords[0]) - Integer.parseInt(coords[2])), (Integer.parseInt(coords[1]) - Integer.parseInt(coords[2])), 2 * Integer.parseInt(coords[2]), 2 * Integer.parseInt(coords[2]));
                g3.drawOval((Integer.parseInt(coords[3]) - Integer.parseInt(coords[5])), (Integer.parseInt(coords[4]) - Integer.parseInt(coords[5])), 2 * Integer.parseInt(coords[5]), 2 * Integer.parseInt(coords[5]));
                if(punctMiguel.length == 2)
                    g3.fillRect(Integer.parseInt(punctMiguel[0]) - 3, Integer.parseInt(punctMiguel[1]) - 3, 8, 8);
                if(punctNewton.length == 2)
                    g3.fillRect(Integer.parseInt(punctNewton[0]) - 3, Integer.parseInt(punctNewton[1]) - 3, 8, 8);
            }
        });

        btnSavePatrulater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestVM.getSaveXML().execute();
            }
        });

        btnLoadPatrulater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestVM.getLoadXML().execute();

                String[] coordsX = myX.getText().split(" ");
                String[] coordsY = myY.getText().split(" ");
                int[] xArray = new int[5];
                int[] yArray = new int[5];

                for(int i = 0; i < 5; i ++){
                    xArray[i] = Integer.parseInt(coordsX[i]);
                    yArray[i] = Integer.parseInt(coordsY[i]);
                    g2.fillRect(xArray[i]-3, yArray[i]-3, 6, 6);
                }
                g2.drawPolyline(xArray, yArray, 5 );

            }
        });
    }

}
