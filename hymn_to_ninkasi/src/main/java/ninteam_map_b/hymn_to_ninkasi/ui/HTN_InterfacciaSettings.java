/**
 * HTN_InterfacciaSettings.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * Classe che rappresenta l'interfaccia delle impostazioni.
 * Gestisce le impostazioni di gioco come il volume e lo stato della musica.
 * 
 * @author francapali-NinTeam
 */
public class HTN_InterfacciaSettings extends javax.swing.JFrame {
    private final Color BLACK = new Color(32, 32, 35);
    private final Color WHITE = new Color(250, 249, 246);
    private final Color BACKGROUND_PINK = new Color(230, 170, 206);
    private final Color TEXT = new Color(79, 1, 71);
    private final Color RED = new Color(238, 75, 43);
    private final Color GREEN = new Color(9, 121, 105);

    private final JFrame parentFrame;

    /**
     * Crea una nuova versione di HTN_InterfacciaSettings
     * 
     * @param parentFrame Il frame principale dell'applicazione
     */
    public HTN_InterfacciaSettings(JFrame parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
        
        if(!((HTN_InterfacciaGioco) parentFrame).getMusica().isPlaying()){
            ((HTN_InterfacciaGioco) parentFrame).getMusica().pausaMusica();
            musicButton.setText("Play");
            musicButton.setForeground(GREEN);
        }
    }

    /**
     * Inizializza i componenti dell'interfaccia.
     */
    private void initComponents() {
        macroPanel = new javax.swing.JPanel();
        underPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        
        musicButton = new javax.swing.JButton();
        labVolume = new javax.swing.JLabel();
        volumeUp = new javax.swing.JButton();
        volumeDown = new javax.swing.JButton();
        
        testoPanel = new javax.swing.JPanel();

        setTitle("Impostazioni");
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(BLACK);

        macroPanel.setLayout(new java.awt.BorderLayout());
        macroPanel.setBackground(BLACK);

        /**
         * Gestione del pulsante musica
         */
        musicButton.setText("Mute");
        musicButton.setBackground(BACKGROUND_PINK);
        musicButton.setForeground(RED);
        musicButton.setPreferredSize(new java.awt.Dimension(72, 30));
        musicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked (java.awt.event.MouseEvent evt) {
                if (((HTN_InterfacciaGioco) parentFrame).getMusica().isPlaying()) {
                    ((HTN_InterfacciaGioco) parentFrame).getMusica().pausaMusica();
                    musicButton.setText("Play");
                    musicButton.setForeground(GREEN);
                } else {
                    ((HTN_InterfacciaGioco) parentFrame).getMusica().riprendiMusica();
                    musicButton.setText("Mute");
                    musicButton.setForeground(RED);
                }
            }
        });

        labVolume.setText("Volume");
        labVolume.setForeground(WHITE);
        labVolume.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        labVolume.setVerticalAlignment(javax.swing.JLabel.CENTER);

        volumeUp.setText("+");
        volumeUp.setBackground(BLACK);
        volumeUp.setForeground(WHITE);
        volumeUp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (((HTN_InterfacciaGioco) parentFrame).getMusica().isPlaying() && ((HTN_InterfacciaGioco) parentFrame).getMusica().getVolume() + 5f < 6f )
                    ((HTN_InterfacciaGioco) parentFrame).getMusica().setVolume(((HTN_InterfacciaGioco) parentFrame).getMusica().getVolume() + 5f);
            }
        });

        volumeDown.setText("-");
        volumeDown.setBackground(BLACK);
        volumeDown.setForeground(WHITE);
        volumeDown.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (((HTN_InterfacciaGioco) parentFrame).getMusica().isPlaying() && ((HTN_InterfacciaGioco) parentFrame).getMusica().getVolume() - 5f > -80f)
                    ((HTN_InterfacciaGioco) parentFrame).getMusica().setVolume(((HTN_InterfacciaGioco) parentFrame).getMusica().getVolume() - 5f);
            }
        });

        testoPanel.setLayout(new java.awt.BorderLayout());
        testoPanel.setBackground(BLACK);
        testoPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        macroPanel.add(volumeDown, java.awt.BorderLayout.WEST);
        macroPanel.add(volumeUp, java.awt.BorderLayout.EAST);
        macroPanel.add(musicButton, java.awt.BorderLayout.NORTH);
        macroPanel.add(labVolume, java.awt.BorderLayout.CENTER);

        macroPanel.add(testoPanel, java.awt.BorderLayout.SOUTH);

        closeButton.setBackground(BACKGROUND_PINK);
        closeButton.setForeground(TEXT);
        closeButton.setText("Chiudi");
        closeButton.setPreferredSize(new java.awt.Dimension(72, 40));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeButtonClose(evt);
            }
        });

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }

            @Override
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        underPanel.setBackground(WHITE);
        underPanel.add(closeButton, BorderLayout.CENTER);

        add(macroPanel, java.awt.BorderLayout.CENTER);
        add(underPanel, java.awt.BorderLayout.PAGE_END);
        pack();
    }

    /**
     * Gestisce l'evento di chiusura del pulsante Chiudi.
     * 
     * @param evt L'evento del mouse.
     */
    private void closeButtonClose (java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private javax.swing.JPanel macroPanel;
    private javax.swing.JPanel underPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton musicButton;
    private javax.swing.JLabel labVolume;
    private javax.swing.JButton volumeUp;
    private javax.swing.JButton volumeDown;
    private javax.swing.JPanel testoPanel;
}
