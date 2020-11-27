import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GUI {
    public static JLabel Namelist;
    public static String Grade1, EN1, CN1, EM1, Grade2, EN2, CN2, EM2, Grade3, EN3, CN3, EM3, Grade4, EN4, CN4, EM4, Grade5, EN5, CN5, EM5;
    static Main mp;
    private static JLabel N1;
    private static JLabel N3;
    private static JLabel N2;
    private static JLabel N4;
    private static JLabel N5;
    public JLabel lblNewLabel;
    public JButton btnNewButton;
    private JFrame frame;
    private JButton Card5;
    private JButton Card4;
    private JButton Card3;
    private JButton Card2;
    private JButton Card1;
    private JPanel TopTopOverlay;

    public GUI() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        initialize();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void updateText() {
        String temp = Main.History.toString();
        temp = temp.replaceAll(",", "<br/>");
        temp = temp.substring(1, temp.length() - 1);
        Namelist.setText("<html>" + temp + "<html>");
    }

    public static void settext(String text1, String text2, String text3, String text4, String text5) {
        Grade1 = text1.substring(0, text1.indexOf(","));
        text1 = text1.substring(text1.indexOf(",") + 1);
        EN1 = text1.substring(0, text1.indexOf(","));
        text1 = text1.substring(text1.indexOf(",") + 1);
        CN1 = text1.substring(0, text1.indexOf(","));
        EM1 = text1.substring(text1.indexOf(",") + 1);

        Grade2 = text2.substring(0, text2.indexOf(","));
        text2 = text2.substring(text2.indexOf(",") + 1);
        EN2 = text2.substring(0, text2.indexOf(","));
        text2 = text2.substring(text2.indexOf(",") + 1);
        CN2 = text2.substring(0, text2.indexOf(","));
        EM2 = text2.substring(text2.indexOf(",") + 1);

        Grade3 = text3.substring(0, text3.indexOf(","));
        text3 = text3.substring(text3.indexOf(",") + 1);
        EN3 = text3.substring(0, text3.indexOf(","));
        text3 = text3.substring(text3.indexOf(",") + 1);
        CN3 = text3.substring(0, text3.indexOf(","));
        EM3 = text3.substring(text3.indexOf(",") + 1);

        Grade4 = text4.substring(0, text4.indexOf(","));
        text4 = text4.substring(text4.indexOf(",") + 1);
        EN4 = text4.substring(0, text4.indexOf(","));
        text4 = text4.substring(text4.indexOf(",") + 1);
        CN4 = text4.substring(0, text4.indexOf(","));
        EM4 = text4.substring(text4.indexOf(",") + 1);

        Grade5 = text5.substring(0, text5.indexOf(","));
        text5 = text5.substring(text5.indexOf(",") + 1);
        EN5 = text5.substring(0, text5.indexOf(","));
        text5 = text5.substring(text5.indexOf(",") + 1);
        CN5 = text5.substring(0, text5.indexOf(","));
        EM5 = text5.substring(text1.indexOf(",") + 1);

        N1.setText(Grade1);
        N2.setText(Grade2);
        N3.setText(Grade3);
        N4.setText(Grade4);
        N5.setText(Grade5);

        Main.History.add(EN1 + " " + CN1);
        Main.History.add(EN2 + " " + CN2);
        Main.History.add(EN3 + " " + CN3);
        Main.History.add(EN4 + " " + CN4);
        Main.History.add(EN5 + " " + CN5);
    }

    private void initialize() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        ImageIcon bg = new ImageIcon(getClass().getResource("resources/background.jpg"));
        ImageIcon button = new ImageIcon(getClass().getResource("resources/ButtonIcon.png"));
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.getContentPane().setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBounds(0, 0, 1280, 720);
        frame.setBackground(Color.BLACK);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 720);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(null);
        btnNewButton = new JButton(button);

        TopTopOverlay = new JPanel();
        layeredPane.setLayer(TopTopOverlay, 1);
        TopTopOverlay.setBounds(0, 0, 1280, 720);
        TopTopOverlay.setVisible(false);


        N3 = new JLabel("Loading...");
        layeredPane.setLayer(N3, 2);
        N3.setBounds(545, 300, 200, 58);
        N3.setHorizontalAlignment(SwingConstants.CENTER);
        N3.setForeground(Color.WHITE);
        N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
        layeredPane.add(N3);
        N3.setVisible(false);

        N5 = new JLabel("Loading...");
        layeredPane.setLayer(N5, 2);
        N5.setBounds(1025, 300, 200, 58);
        N5.setHorizontalAlignment(SwingConstants.CENTER);
        N5.setForeground(Color.WHITE);
        N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
        layeredPane.add(N5);
        N5.setVisible(false);

        N1 = new JLabel("Loading...");
        N1.setBounds(65, 300, 200, 58);
        layeredPane.setLayer(N1, 2);
        N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
        N1.setHorizontalAlignment(SwingConstants.CENTER);
        N1.setForeground(new Color(255, 255, 255));
        layeredPane.add(N1);

        N1.setVisible(false);


        N2 = new JLabel("Loading...");
        layeredPane.setLayer(N2, 2);
        N2.setBounds(300, 240, 200, 58);
        N2.setHorizontalAlignment(SwingConstants.CENTER);
        N2.setForeground(Color.WHITE);
        N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
        layeredPane.add(N2);
        N2.setVisible(false);

        N4 = new JLabel("Loading...");
        layeredPane.setLayer(N4, 2);
        N4.setBounds(785, 240, 200, 58);
        N4.setHorizontalAlignment(SwingConstants.CENTER);
        N4.setForeground(Color.WHITE);
        N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
        layeredPane.add(N4);
        N4.setVisible(false);

        TopTopOverlay.setBackground(new Color(0, 0, 0));
        TopTopOverlay.setLayout(new BoxLayout(TopTopOverlay, BoxLayout.X_AXIS));

        JPanel TopOverlay = new JPanel();
        TopTopOverlay.add(TopOverlay);
        TopOverlay.setBackground(new Color(0, 0, 0));

        Card1 = new JButton("1");
        Card1.setFont(new Font(".SF NS Text", Card1.getFont().getStyle(), 0));
        Card1.setIcon(new ImageIcon(getClass().getResource("resources/card.png")));
        Card1.setBounds(60, 172, 210, 309);

        Card2 = new JButton("2");
        Card2.setBounds(300, 111, 210, 309);
        Card2.setFont(new Font(".SF NS Text", Card2.getFont().getStyle(), 0));
        Card2.setIcon(new ImageIcon(getClass().getResource("resources/card.png")));

        Card3 = new JButton("3");
        Card3.setBounds(540, 170, 210, 309);
        Card3.setFont(new Font(".SF NS Text", Card3.getFont().getStyle(), 0));
        Card3.setIcon(new ImageIcon(getClass().getResource("resources/card.png")));

        Card4 = new JButton("4");
        Card4.setBounds(780, 111, 210, 309);
        Card4.setFont(new Font(".SF NS Text", Card4.getFont().getStyle(), 0));
        Card4.setIcon(new ImageIcon(getClass().getResource("resources/card.png")));

        Card5 = new JButton("5");
        Card5.setBounds(1020, 169, 210, 309);
        Card5.setFont(new Font(".SF NS Text", Card5.getFont().getStyle(), -1));
        Card5.setIcon(new ImageIcon(getClass().getResource("resources/card.png")));

        JButton Back = new JButton("Back");
        Back.setBounds(570, 608, 140, 74);
        Back.setFont(new Font("Libian TC", Font.PLAIN, 40));
        TopOverlay.setLayout(null);
        TopOverlay.add(Card1);
        TopOverlay.add(Card2);
        TopOverlay.add(Card3);
        TopOverlay.add(Card4);
        TopOverlay.add(Card5);
        TopOverlay.add(Back);
        layeredPane.add(TopTopOverlay);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    N1.setVisible(false);
                    N2.setVisible(false);
                    N3.setVisible(false);
                    N4.setVisible(false);
                    N5.setVisible(false);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    btnNewButton.setBackground(Color.white);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    btnNewButton.setVisible(true);
                                }
                            }
                        }, 350 - a * 50);
                    }
                }
            }
        });

        Card1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    Namelist.setVisible(false);
                    btnNewButton.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    btnNewButton.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }
            }
        });

        Card2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    Namelist.setVisible(false);
                    btnNewButton.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    btnNewButton.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }
            }
        });

        Card3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    Namelist.setVisible(false);
                    btnNewButton.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    btnNewButton.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }
            }
        });

        Card4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    Namelist.setVisible(false);
                    btnNewButton.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    btnNewButton.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }
            }
        });

        Card5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    Namelist.setVisible(false);
                    btnNewButton.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);
                                    btnNewButton.setVisible(true);
                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }
            }
        });

        Namelist = new JLabel("Click to Start");
        Namelist.setBounds(750, 100, 400, 380);
        Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 65));
        Namelist.setHorizontalAlignment(SwingConstants.CENTER);
        Namelist.setForeground(new Color(255, 255, 255));
        layeredPane.add(Namelist);

        btnNewButton.setBounds(860, 480, 200, 93);
        btnNewButton.setToolTipText("");
        btnNewButton.setFont(new Font("Apple Chancery", Font.PLAIN, 51));
        btnNewButton.setText("Start!");
        btnNewButton.setBackground(SystemColor.inactiveCaptionText);
        layeredPane.add(btnNewButton);

        JPanel BackgroundImage = new JPanel();
        BackgroundImage.setBounds(0, 0, 1280, 720);

        lblNewLabel = new JLabel(bg);
        lblNewLabel.setText("");
        BackgroundImage.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Nanum Pen Script", Font.PLAIN, 56));
        BackgroundImage.setBackground(Color.BLACK);
        layeredPane.add(BackgroundImage);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                if (choice == "Start!") {
                    btnNewButton.setVisible(false);
                    Namelist.setVisible(false);
                    for (int a = 1; a <= 7; a = a + 1) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 7) {
                                    lblNewLabel.setVisible(false);
                                    TopTopOverlay.setVisible(true);
                                    N1.setVisible(true);
                                    N2.setVisible(true);
                                    N3.setVisible(true);
                                    N4.setVisible(true);
                                    N5.setVisible(true);
                                    Card1.setText("1");
                                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card2.setText("2");
                                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card3.setText("3");
                                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card4.setText("4");
                                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Card5.setText("5");
                                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                                    Main.lottery();
                                }
                            }
                        }, a * 50);
                    }
                } else if (choice == "Back") {
                    TopTopOverlay.setVisible(false);
                    lblNewLabel.setVisible(true);
                    for (int a = 7; a >= 1; a--) {
                        int i = a;
                        new Timer("timer - " + i).schedule(new TimerTask() {
                            @Override
                            public void run() {
                                ImageIcon icon = new ImageIcon(getClass().getResource("resources/background" + i + ".jpg"));
                                lblNewLabel.setIcon(icon);
                                if (i == 1) {
                                    lblNewLabel.setIcon(bg);
                                    lblNewLabel.setVisible(true);
                                    Namelist.setVisible(true);

                                    TopTopOverlay.setVisible(false);
                                    N1.setVisible(false);
                                    N2.setVisible(false);
                                    N3.setVisible(false);
                                    N4.setVisible(false);
                                    N5.setVisible(false);
                                    Namelist.setFont(new Font("Marker Felt", Font.PLAIN, 30));
                                    Namelist.setText("<html>" + Main.History.toString() + "<html>");
                                    System.out.println(Main.History.toString());
                                }
                            }
                        }, 350 - a * 50);
                    }
                } else if (choice == "1") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EN1);
                    Card1.setText("1+");
                } else if (choice == "1+") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N1.setText(CN1);
                    Card1.setText("1++");
                } else if (choice == "1++") {
                    N1.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N1.setText(EM1.replace("@ncpachina.org", ""));
                } else if (choice == "2") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EN2);
                    Card2.setText("2+");
                } else if (choice == "2+") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N2.setText(CN2);
                    Card2.setText("2++");
                } else if (choice == "2++") {
                    N2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N2.setText(EM2.replace("@ncpachina.org", ""));
                } else if (choice == "3") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EN3);
                    Card3.setText("3+");
                } else if (choice == "3+") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N3.setText(CN3);
                    Card3.setText("3++");
                } else if (choice == "3++") {
                    N3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N3.setText(EM3.replace("@ncpachina.org", ""));
                } else if (choice == "4") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EN4);
                    Card4.setText("4+");
                } else if (choice == "4+") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N4.setText(CN4);
                    Card4.setText("4++");
                } else if (choice == "4++") {
                    N4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N4.setText(EM4.replace("@ncpachina.org", ""));
                } else if (choice == "5") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EN5);
                    Card5.setText("5+");
                } else if (choice == "5+") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 30));
                    N5.setText(CN5);
                    Card5.setText("5++");
                } else if (choice == "5++") {
                    N5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 50));
                    N5.setText(EM5.replace("@ncpachina.org", ""));
                } else {
                    System.out.println("Error001");
                }

            }
        });


    }
}


