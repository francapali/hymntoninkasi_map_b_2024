/**
 * HTN_InterfacciaEnding.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import ninteam_map_b.hymn_to_ninkasi.other.MusicHandler;
import ninteam_map_b.hymn_to_ninkasi.other.TimeSpent;
import ninteam_map_b.hymn_to_ninkasi.restful.scoreboard.ScoreClient;
import ninteam_map_b.hymn_to_ninkasi.type.Scoreboard;

/**
 * Classe per l'interfaccia di fine gioco.
 * Gestisce la visualizzazione del finale del gioco e la registrazione del punteggio del giocatore.
 * 
 * @author francapali-NinTeam
 */
public class HTN_InterfacciaEnding extends javax.swing.JFrame {
    private static final Color BACKGROUND_PINK = new Color(230, 170, 206);
    private static final Color BACKGROUND_PURPLE = new Color(79, 1, 71);
    private static final Color PLACEHOLDER_GRAY = new Color(150, 150, 150);
    private final MusicHandler musicHTN = new MusicHandler();

    private final JFrame parentFrame;
    private JTextField nameField;

    /**
     * Costruttore della classe HTN_InterfacciaEnding.
     * 
     * @param parentFrame il frame genitore dell'interfaccia di fine gioco.
     */
    public HTN_InterfacciaEnding(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();

        try {
            musicHTN.playMusic("src\\music\\HTN_endingtheme.wav");
        } catch (Exception e) {
            JButton okButton = new JButton("Ok");
            okButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    dispose();
                    musicHTN.playMusic("src\\music\\HTN_endingtheme.wav");
                }
            });
            JOptionPane info = new JOptionPane(e.getMessage(), JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION, null, new Object[] { okButton });
            info.createDialog(HTN_InterfacciaEnding.this, "Info").setVisible(true);
        }
    }

    /**
     * Metodo per inizializzare i componenti dell'interfaccia.
     */
    private void initComponents() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                parentFrame.setVisible(true);
                dispose();
            }
        });

        JPanel macroPanel = new JPanel();
        macroPanel.setLayout(new BoxLayout(macroPanel, BoxLayout.Y_AXIS));
        macroPanel.setBackground(BACKGROUND_PURPLE);

        JLabel labImage = new JLabel();
        labImage.setAlignmentX(CENTER_ALIGNMENT);
        labImage.setIcon(new ImageIcon(new ImageIcon("src\\img\\HTN_NinJournal.png").getImage()
                .getScaledInstance(680, 680, Image.SCALE_DEFAULT)));
        macroPanel.add(labImage);

        // Spazio tra l'immagine e la textbar
        macroPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Pannello per la textbar e il bottone
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBackground(BACKGROUND_PURPLE);

        nameField = new JTextField("inserisci nickname");
        nameField.setForeground(PLACEHOLDER_GRAY);
        nameField.setMaximumSize(new Dimension(300, 30));
        nameField.setPreferredSize(new Dimension(300, 30));

        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (nameField.getForeground().equals(PLACEHOLDER_GRAY)) {
                    nameField.setText("");
                    nameField.setForeground(Color.BLACK);
                    nameField.removeKeyListener(this);  // Rimuove il key listener dopo la prima pressione
                }
            }
        });

        inputPanel.add(nameField);

        // Spazio tra la textbar e il bottone 'Fine?'
        inputPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JButton theEnd = new JButton();
        theEnd.setBackground(BACKGROUND_PINK);
        theEnd.setForeground(BACKGROUND_PURPLE);
        theEnd.setText("FINE?");
        theEnd.setFocusPainted(false);
        theEnd.setPreferredSize(new Dimension(90, 30));
        theEnd.setMaximumSize(new Dimension(90, 30));
        theEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                musicHTN.stopMusica();
                try {
                    theEndClose(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HTN_InterfacciaEnding.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        inputPanel.add(theEnd);

        inputPanel.setAlignmentX(CENTER_ALIGNMENT);
        macroPanel.add(inputPanel);

        // Spazio sotto il bottone 'Fine?'
        macroPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hymn To Ninkasi - Il tuo finale");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\HTN_Logo.png"));
        setResizable(false);
        setSize(720, 720);
        setBackground(BACKGROUND_PURPLE);

        add(macroPanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(macroPanel, GroupLayout.Alignment.TRAILING,
                                GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(macroPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Metodo chiamato alla chiusura dell'interfaccia di fine gioco.
     * 
     * @param evt l'evento del mouse.
     * @throws InterruptedException se l'operazione viene interrotta.
     */
    private void theEndClose(java.awt.event.MouseEvent evt) throws InterruptedException {
        String nickname = nameField.getText().equals("inserisci nickname") ? "" : nameField.getText();

        TimeSpent finalTimeSpent = TimeSpent.getInstance();
        finalTimeSpent.updateFinalTime();
        Scoreboard scoreboard = finalTimeSpent.saveTimeSpent();
        scoreboard.setName(nickname);
        ScoreClient.setScore(scoreboard);

        dispose();
        new HTN_InterfacciaInizio().setVisible(true);
    }
}
