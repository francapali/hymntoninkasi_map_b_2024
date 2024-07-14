/**
 * HTN_InterfacciaGioco.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import ninteam_map_b.hymn_to_ninkasi.Engine;
import ninteam_map_b.hymn_to_ninkasi.Hymn_To_Ninkasi;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.other.MusicHandler;
import ninteam_map_b.hymn_to_ninkasi.other.SaveManager;
import ninteam_map_b.hymn_to_ninkasi.parser.Parser;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.Utils;
import ninteam_map_b.hymn_to_ninkasi.other.TimeSpent;
import ninteam_map_b.hymn_to_ninkasi.type.Inventory;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;

/**
 * Interfaccia grafica principale del gioco "Hymn to Ninkasi".
 * Gestisce l'inizializzazione dei componenti e l'interazione utente.
 * 
 * @see javax.swing.JFrame
 * @see ninteam_map_b.hymn_to_ninkasi.Engine
 * @see ninteam_map_b.hymn_to_ninkasi.Hymn_To_Ninkasi
 * @see ninteam_map_b.hymn_to_ninkasi.other.MusicHandler
 * @see ninteam_map_b.hymn_to_ninkasi.parser.Parser
 * @see ninteam_map_b.hymn_to_ninkasi.type.Utils
 * @see ninteam_map_b.hymn_to_ninkasi.other.TimeSpent
 * 
 */
public class HTN_InterfacciaGioco extends JFrame {
    private static final Font FONT = new Font("Helvetica", Font.BOLD, 16);
    private static final Color BACKGROUND_PINK = new Color(230, 170, 206);
    private static final Color BACKGROUND_PURPLE = new Color(79, 1, 71);
    private static final Color TEXT = new Color(6, 6, 6);
    private static final Color RED = new Color(238, 75, 43);
    private static final Color GREEN = new Color(9, 121, 105);

    private final MusicHandler musicHTN = new MusicHandler();
    private Parser parser = null;
    private Engine engine;
    private GameDesc game;
    
    private final JFrame parentFrame;
    private JFrame confermaChiusura;
    private JTextPane textPane;
    private JScrollPane scrollPane;
    private JTextField textBox;
    private JButton musicButton;
    private JMenuBar menuBar;
    
    private JPanel macroPanel;
    private ImagePanel imageViewer; // Changed to ImagePanel
    private JLabel imageLabel;
    private JPanel underPanel;
    private JMenu tendina;
    private JMenuItem impostazioniItem;

    private HTN_Printer printer;

    /**
     * Costruttore della classe HTN_InterfacciaGioco.
     * 
     * @param parentFrame Finestra padre.
     * @throws Exception Se c'è un problema durante l'inizializzazione.
     */
    public HTN_InterfacciaGioco(JFrame parentFrame) throws Exception {
        initComponents();
        this.parentFrame = parentFrame;
        mainComponents(false, null);
    }

    /**
     * Costruttore della classe HTN_InterfacciaGioco con caricamento di un salvataggio.
     * 
     * @param parentFrame Finestra padre.
     * @param file File di salvataggio da caricare.
     * @throws Exception Se c'è un problema durante l'inizializzazione o il caricamento.
     */
    public HTN_InterfacciaGioco(JFrame parentFrame, File file) throws Exception {
        this.parentFrame = parentFrame;
        initComponents();
        mainComponents(true, file);
    }

    /**
     * Conclude la partita e mostra la finestra di fine gioco.
     */
    public void concludiPartita() {
        musicHTN.stopMusica();
        SwingUtilities.invokeLater(() -> {
            HTN_InterfacciaEnding endingFrame = new HTN_InterfacciaEnding(this);
            endingFrame.setVisible(true);
            this.setVisible(false);
        });
    }

    /**
     * Inizializza i componenti principali dell'interfaccia.
     * 
     * @param loadGame Indica se caricare un salvataggio.
     * @param file File di salvataggio da caricare, se presente.
     * @throws Exception Se c'è un problema durante l'inizializzazione o il caricamento.
     */
    private void mainComponents(boolean loadGame, File file) throws Exception {
        game = new Hymn_To_Ninkasi();
        
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File(".\\resources\\stopwords.txt"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            throw new IOException("Errore nel caricamento delle stopwords.");
        }
        
        if (!loadGame) {
            engine = new Engine(game);
        } else {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Hymn_To_Ninkasi temp = (Hymn_To_Ninkasi) ois.readObject();
                game = temp;
                engine = new Engine(game, true);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new IOException("Errore nel caricamento del gioco.");
            }
        }
        TimeSpent startTimeSpent = TimeSpent.getInstance();
        startTimeSpent.startTime();

        PrintStream ps = new PrintStream(new JTextPaneOutputStream(textPane), true, StandardCharsets.UTF_8) {
            @Override
            public void println(String x) {
                printer.print(x + "\n");
            }
        };
        engine.getGame().nextMove(null, ps); // Passa un PrintStream valido al gioco

        printer.print("""
                      ========================
                                Hymn to Ninkasi   
                                  developed by        
                                    NinTeam           
                      ========================
                      
                      """ + engine.getGame().getWelcomeMsg() + "\n"
                      + engine.getGame().getCurrentRoom().getDescription()
                      + "\n-> ");
    }

    /**
     * Inizializza i componenti della GUI.
     * 
     * @throws InterruptedException Se c'è un problema durante l'inizializzazione.
     */
    private void initComponents() throws InterruptedException {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                parentFrame.setVisible(true);
                dispose();
            }
        });

        confermaChiusura = new JFrame();         
        JPanel panel = new JPanel();
        JPanel buttonPanelExit = new JPanel();
        macroPanel = new JPanel();
        imageViewer = new ImagePanel(); // Changed to ImagePanel
        underPanel = new JPanel();
        JLabel jTextArea2 = new JLabel();
        textBox = new JTextField();
        scrollPane = new JScrollPane();
        textPane = new JTextPane();
        imageLabel = new JLabel();
        textBox = new JTextField();
        menuBar = new JMenuBar();
        
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        
        JButton inventarioButton = new JButton();
        JButton esciButton = new JButton();
        
        musicButton = new JButton();

        tendina = new JMenu();
        impostazioniItem = new JMenuItem();
        
        confermaChiusura.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\HTN_Logo.png"));
        confermaChiusura.setResizable(false);
        confermaChiusura.setSize(new Dimension(750, 480));
        confermaChiusura.setLocationRelativeTo(null);
        confermaChiusura.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        confermaChiusura.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                continueGame(evt);
            }
        });
        buttonPanelExit.setBackground(BACKGROUND_PINK);
        
        jButton1.setBackground(BACKGROUND_PINK);
        jButton1.setText("E-S-C-I");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                try {
                    jButton1goToMenu(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HTN_InterfacciaGioco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        buttonPanelExit.add(jButton1);

        jButton2.setBackground(BACKGROUND_PINK);
        jButton2.setText("ci ripenso");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2dontClose(evt);
            }
        });
        buttonPanelExit.add(jButton2);
        
        jTextArea2.setFont(FONT);
        jTextArea2.setText("SAY 'ESCI' ONE MORE TIME");
        jTextArea2.setBackground(BACKGROUND_PINK);
        jTextArea2.setHorizontalAlignment(SwingConstants.CENTER);
        jTextArea2.setVerticalAlignment(SwingConstants.CENTER);
        jTextArea2.setFocusable(false);
        jTextArea2.setBorder(null);

        imageLabel.setIcon(new ImageIcon("src\\img\\HTN_esci.png"));
        imageLabel.setPreferredSize(new Dimension(682, 384));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        panel.setBackground(BACKGROUND_PINK);
        panel.setLayout(new BorderLayout());

        panel.add(imageLabel, BorderLayout.NORTH);

        panel.add(jTextArea2, BorderLayout.CENTER);
        panel.add(buttonPanelExit, BorderLayout.SOUTH);
        
        confermaChiusura.getContentPane().add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hymn To Ninkasi");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\HTN_Logo.png"));
        setResizable(false);

        macroPanel.setBackground(BACKGROUND_PURPLE);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAutoscrolls(true);
        scrollPane.setPreferredSize(new Dimension(600, 300));

        DefaultCaret caret = (DefaultCaret) textPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(attrs, 0.40f);
        doc.setParagraphAttributes(0, doc.getLength() - 1, attrs, false);

        textPane.setEditable(true);
        textPane.setFocusable(false);
        textPane.setBackground(BACKGROUND_PINK);
        textPane.setForeground(BACKGROUND_PURPLE);
        textPane.setPreferredSize(new Dimension(100, 100));
        textPane.setBorder(null);
        textPane.setCaretPosition(textPane.getDocument().getLength());
        textPane.setFont(FONT);
        textPane.setBorder(BorderFactory.createLineBorder(BACKGROUND_PINK, 4));
        scrollPane.setViewportView(textPane);
        imageViewer = new ImagePanel(); // Changed to ImagePanel
        textPane.setFont(new Font("Helvetica", Font.PLAIN, 18));
        imageViewer.setImage("src//img//HTN_Load.png");
        imageViewer.setPreferredSize(new Dimension(480, 270));

        underPanel.setBackground(BACKGROUND_PINK);
        underPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

        textBox.setPreferredSize(new Dimension(800, 30));
        textBox.addActionListener(this::elaborateInput);
        underPanel.add(textBox);

        inventarioButton.setBackground(BACKGROUND_PINK);
        inventarioButton.setForeground(TEXT);
        inventarioButton.setText("Inventario");
        inventarioButton.setPreferredSize(new Dimension(0, 30));

        underPanel.add(inventarioButton);

        impostazioniItem.setBackground(BACKGROUND_PINK);
        impostazioniItem.setForeground(TEXT);
        impostazioniItem.setText("Impostazioni");
        impostazioniItem.setPreferredSize(new Dimension(105, 30));
        impostazioniItem.addActionListener(this::impostazioniMouseClicked);

        tendina.setText("Opzioni");
        tendina.setPreferredSize(new Dimension(90, 30));
        tendina.setBorder(new javax.swing.border.LineBorder(BACKGROUND_PINK, 4));
        tendina.setBackground(BACKGROUND_PINK);
        tendina.setForeground(TEXT);
        tendina.add(impostazioniItem);

        menuBar.add(tendina);
        menuBar.add(Box.createHorizontalGlue());
        
        menuBar.setBackground(BACKGROUND_PINK);
        menuBar.setForeground(TEXT);
        setJMenuBar(menuBar);

        musicHTN.playMusic("src\\music\\HTN_gameplaylist.wav");
        
        musicButton.setText("Mute");
        musicButton.setBackground(BACKGROUND_PINK);
        musicButton.setForeground(RED);
        musicButton.setPreferredSize(new Dimension(105, 30));

        musicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (musicHTN.isPlaying()) {
                    musicHTN.pausaMusica();
                    musicButton.setText("Play");
                    musicButton.setForeground(GREEN);
                } else {
                    musicHTN.riprendiMusica();
                    musicButton.setText("Mute");
                    musicButton.setForeground(RED);
                }
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                musicHTN.stopMusica();
                printer.shutdown();
            }
        });
        
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                if (musicHTN.isPlaying()) {
                    musicButton.setText("Mute");
                    musicButton.setForeground(RED);
                } else {
                    musicButton.setText("Play");
                    musicButton.setForeground(GREEN);
                }
            }

            @Override
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                // Niente da fare qui
            }
        });

        underPanel.add(musicButton);

        esciButton.setBackground(BACKGROUND_PINK);
        esciButton.setForeground(TEXT);
        esciButton.setText("Esci");
        esciButton.setPreferredSize(new Dimension(90, 30));
        esciButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esciButtonMouseClicked(evt);
            }
        });
        
        underPanel.add(esciButton);

        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src\\img\\HTN_Ninplaylist.png");
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        rightPanel.setBackground(BACKGROUND_PINK);
        rightPanel.setPreferredSize(new Dimension(200, 200));
        GroupLayout macroPanelLayout = new GroupLayout(macroPanel);
        macroPanel.setLayout(macroPanelLayout);
        macroPanelLayout.setHorizontalGroup(
                macroPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, macroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(macroPanelLayout
                                        .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(underPanel, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(macroPanelLayout.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 800,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rightPanel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addComponent(imageViewer, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        macroPanelLayout.setVerticalGroup(
                macroPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(macroPanelLayout.createSequentialGroup()
                                .addComponent(imageViewer, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(macroPanelLayout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrollPane)
                                        .addComponent(rightPanel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(underPanel, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        getContentPane().add(macroPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);

        printer = new HTN_Printer(textPane);
    }

    /**
     * Continua il gioco ripristinando lo stato precedente alla chiusura del menu di conferma uscita.
     * 
     * @param evt Evento di chiusura del componente.
     */
    private void continueGame(java.awt.event.ComponentEvent evt) {
        setEnabled(true);
        setVisible(true);
        confermaChiusura.setVisible(false);
    }

    /**
     * Elabora l'input dell'utente.
     * 
     * @param evt Evento di azione.
     */
    private void elaborateInput(ActionEvent evt) {
        String input = textBox.getText();
        if (!input.isBlank()) {
            printer.print("?> " + input + "\n\n");
            textBox.setText("");
            ParserOutput p = parser.parse(input.toLowerCase(), engine.getGame().getCommands(), engine.getGame().getListObj(), engine.getGame().getInventory(), engine.getGame().getRooms());
            PrintStream ps = new PrintStream(new JTextPaneOutputStream(textPane), true, StandardCharsets.UTF_8) {
                @Override
                public void println(String x) {
                    printer.print(x + "\n");
                }
            };
            engine.getGame().nextMove(p, ps);
            if (engine.getGame().getCurrentRoom() != null) {
                updateRoomImage(engine.getGame().getCurrentRoom().getName());
            }
            checkEndGame();
        }
    }

    /**
     * Mostra la finestra delle impostazioni.
     * 
     * @param evt Evento di azione.
     */
    private void impostazioniMouseClicked(ActionEvent evt) {
        HTN_InterfacciaSettings impostazioni = new HTN_InterfacciaSettings(HTN_InterfacciaGioco.this);
        impostazioni.setVisible(true);
    }

    /**
     * Gestisce l'evento di clic sul pulsante per tornare al menu principale.
     * 
     * @param evt Evento di clic del mouse.
     * @throws InterruptedException Se c'è un problema durante l'elaborazione.
     */
    private void jButton1goToMenu(java.awt.event.MouseEvent evt) throws InterruptedException {
        HTN_InterfacciaInizio start = new HTN_InterfacciaInizio();
        start.setVisible(true);
        confermaChiusura.dispose();
        dispose();
    }

    /**
     * Gestisce l'evento di clic sul pulsante per non chiudere il gioco.
     * 
     * @param evt Evento di clic del mouse.
     */
    private void jButton2dontClose(java.awt.event.MouseEvent evt) {
        setEnabled(true);
        confermaChiusura.setVisible(false);
    }

    /**
     * Gestisce l'evento di clic sul pulsante di uscita.
     * 
     * @param evt Evento di clic del mouse.
     */
    private void esciButtonMouseClicked(java.awt.event.MouseEvent evt) {
        setEnabled(false);
        confermaChiusura.setLocationRelativeTo(null);
        confermaChiusura.setTitle("Hymn To Ninkasi - Menù d'uscita");
        confermaChiusura.setVisible(true);
    }

    /**
     * Restituisce il gestore della musica.
     * 
     * @return Il gestore della musica.
     */
    public MusicHandler getMusica() {
        return musicHTN;
    }

    /**
     * Controlla se il gioco è terminato.
     */
    private void checkEndGame() {
        boolean isGameOver = false;
        
        if (engine.getGame().getCurrentRoom() == null) {
            isGameOver = true;
        }

        if (isGameOver) {
            concludiPartita();
        }
    }

    /**
     * Aggiorna l'immagine della stanza corrente.
     * 
     * @param roomName Nome della stanza.
     */
    public void updateRoomImage(String roomName) {
        String imagePath;
        switch (roomName) {
            case "Terrazzo":
                imagePath = "src/img/HTN_Terrazzo.png";
                break;
            case "Cucina":
                imagePath = "src/img/HTN_Cucina.png";
                break;
            case "Ingresso":
                imagePath = "src/img/HTN_Ingresso.png";
                break;
            case "Salotto":
                imagePath = "src/img/HTN_Salotto.png";
                break;
            case "Bagno":
                imagePath = "src/img/HTN_Bagno.png";
                break;
            default:
                imagePath = "src/img/HTN_Terrazzo.png";
                break;
        }
        updateImageViewer(imagePath);
    }

    /**
     * Aggiorna il visualizzatore di immagini con il percorso dell'immagine specificata.
     * 
     * @param imagePath Percorso dell'immagine.
     */
    private void updateImageViewer(String imagePath) {
        imageViewer.setImage(imagePath);
    }

    /**
     * Classe interna per gestire lo stream di output verso JTextPane.
     */
    private class JTextPaneOutputStream extends OutputStream {
        private final JTextPane textPane;

        public JTextPaneOutputStream(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void write(int b) throws IOException {
            SwingUtilities.invokeLater(() -> textPane.setText(textPane.getText() + (char) b));
        }
    }

    /**
     * Classe interna per gestire il pannello delle immagini.
     */
    private class ImagePanel extends JPanel {
        private Image image;

        public void setImage(String imagePath) {
            this.image = new ImageIcon(imagePath).getImage();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }
}
