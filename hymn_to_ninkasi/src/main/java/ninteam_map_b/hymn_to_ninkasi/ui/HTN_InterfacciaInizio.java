/**
 * HTN_InterfacciaInizio.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import ninteam_map_b.hymn_to_ninkasi.other.MusicHandler;
import ninteam_map_b.hymn_to_ninkasi.other.ProgressBarThread;
import ninteam_map_b.hymn_to_ninkasi.other.SaveManager;
import ninteam_map_b.hymn_to_ninkasi.other.StartGameThread;
import ninteam_map_b.hymn_to_ninkasi.restful.RESTServer;

/**
 * Interfaccia grafica iniziale del gioco "Hymn to Ninkasi".
 * Gestisce l'avvio del server, la selezione delle opzioni di gioco e la gestione del caricamento.
 * 
 * @see javax.swing.JFrame
 * @see ninteam_map_b.hymn_to_ninkasi.other.MusicHandler
 * @see ninteam_map_b.hymn_to_ninkasi.other.ProgressBarThread
 * @see ninteam_map_b.hymn_to_ninkasi.other.StartGameThread
 * @see ninteam_map_b.hymn_to_ninkasi.restful.RESTServer
 * 
 * @autor francapali-NinTeam
 */
public class HTN_InterfacciaInizio extends javax.swing.JFrame {
    private final Color BACKGROUND = new Color(230, 170, 206);
    private final Color TEXT = new Color(79, 1, 71);
    private final Color WHITE = new Color(250, 249, 246);
    private final MusicHandler musicHTN = new MusicHandler();
    private JProgressBar progressBar;
    private Thread serverThread;
    private static boolean serverOn = false;

    /**
     * Costruttore della classe HTN_InterfacciaInizio.
     * Inizializza il server e i componenti dell'interfaccia.
     * 
     * @throws InterruptedException Se c'è un problema durante l'inizializzazione.
     */
    public HTN_InterfacciaInizio() throws InterruptedException {
        if (!serverOn) {
            serverOn = true;
            startServer();
            Thread.sleep(1200);
        }
        initComponents();
    }
    
    /**
     * Avvia il server REST.
     */
    private void startServer() {
        serverThread = new Thread(new RESTServer());
        serverThread.start();
    }

    /**
     * Ferma il server REST.
     * 
     * @deprecated Lascia il server aperto.
     */
    private void stopServer() {
        RESTServer.stopServer();
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inizializza i componenti della GUI.
     * 
     * @throws InterruptedException Se c'è un problema durante l'inizializzazione.
     */
    private void initComponents() {
        musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                if (!musicHTN.isPlaying())
                    musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
            }
        });

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                if (!musicHTN.isPlaying()) 
                    musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
            }

            @Override
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                
            }
        });

        background = new javax.swing.JLabel();
        background.setIcon(new ImageIcon(new ImageIcon("src\\img\\HTN_Intro.png").getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT)));
        macroPanel = new javax.swing.JPanel(); 
        start = new javax.swing.JButton();
        load = new javax.swing.JButton();
        leaderboard = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();
        progressBar = new JProgressBar(0, 100);

        // Configura i colori direttamente sulla progress bar
        progressBar.setForeground(new Color(79, 1, 71)); // Colore del riempimento
        progressBar.setBackground(new Color(230, 170, 206)); // Colore dello sfondo

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hymn To Ninkasi - Menù Iniziale");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\HTN_Logo.png"));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setResizable(false);
        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        macroPanel.setBackground(BACKGROUND);

        start.setBackground(BACKGROUND);
        start.setForeground(TEXT);
        start.setText("Nuovo gioco");
        start.setPreferredSize(new java.awt.Dimension(140, 23));
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                try {
                    startGame(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HTN_InterfacciaInizio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        macroPanel.add(start);

        load.setBackground(BACKGROUND);
        load.setForeground(TEXT);
        load.setText("Continua");
        load.setPreferredSize(new java.awt.Dimension(140, 23));

        fileChooser.setDialogTitle("Recupero del salvataggio");
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Files .dat", "dat"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        load.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                int returnVal = fileChooser.showOpenDialog(HTN_InterfacciaInizio.this);
                if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                    try {
                        java.io.File file = fileChooser.getSelectedFile();
                        musicHTN.stopMusica();
                        HTN_InterfacciaGioco gioco = new HTN_InterfacciaGioco(HTN_InterfacciaInizio.this, file);
                        gioco.setVisible(true);
                        setVisible(false);
                    } catch (Exception e) {
                        musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
                        JOptionPane.showMessageDialog(HTN_InterfacciaInizio.this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        macroPanel.add(load);

        leaderboard.setBackground(BACKGROUND);
        leaderboard.setForeground(TEXT);
        leaderboard.setText("Scoreboard");
        leaderboard.setPreferredSize(new java.awt.Dimension(140, 23));
        leaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HTN_InterfacciaScoreboard scoreboard;
                try {
                    scoreboard = new HTN_InterfacciaScoreboard();
                    scoreboard.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(HTN_InterfacciaInizio.this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        macroPanel.add(leaderboard);

        exit.setBackground(BACKGROUND);
        exit.setForeground(TEXT);
        exit.setText("Esci");
        exit.setPreferredSize(new java.awt.Dimension(140, 23));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                musicHTN.stopMusica();
                closeWindow(evt);
            }
        });
        macroPanel.add(exit);
        macroPanel.setBackground(WHITE);

        getContentPane().add(macroPanel, java.awt.BorderLayout.PAGE_END);

        getAccessibleContext().setAccessibleName("Hymn To Ninkasi");

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Chiude la finestra del gioco.
     * 
     * @param evt Evento di clic del mouse.
     */
    private void closeWindow(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    /**
     * Avvia il gioco con una barra di progresso.
     * 
     * @param evt Evento di clic del mouse.
     * @throws InterruptedException Se c'è un problema durante l'avvio del gioco.
     */
    private void startGame(java.awt.event.MouseEvent evt) throws InterruptedException {
        macroPanel.removeAll();
        macroPanel.add(progressBar);
        macroPanel.revalidate();
        macroPanel.repaint();
        progressBar.setValue(0);

        StartGameThread startGameThread = new StartGameThread(progressBar, musicHTN, this);
        Thread startThread = new Thread(startGameThread);
        startThread.start();
        System.out.println("");
        System.out.println("GIOCO CARICATO CORRETTAMENTE");
        System.out.println("");
    }

    /**
     * Metodo chiamato dopo il completamento della barra di progresso per avviare il gioco.
     */
//    public void startGameAfterProgress() {
//        musicHTN.stopMusica(); // Stop the menu music before starting the game
//        HTN_InterfacciaGioco gioco;
//        try {
//            gioco = new HTN_InterfacciaGioco(this);
//            gioco.setVisible(true);
//            setVisible(false);
//        } catch (Exception ex) {
//            musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    /**
     * Metodo main per avviare l'interfaccia iniziale del gioco.
     * 
     * @param args Argomenti della riga di comando.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new HTN_InterfacciaInizio().setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(HTN_InterfacciaInizio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private javax.swing.JLabel background;
    private javax.swing.JButton exit;
    private javax.swing.JButton load;
    private javax.swing.JPanel macroPanel;
    private javax.swing.JButton start;
    private javax.swing.JButton leaderboard;
    private javax.swing.JFileChooser fileChooser;
}
