/**
 * HTN_InterfacciaScoreboard.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ninteam_map_b.hymn_to_ninkasi.restful.scoreboard.ScoreClient;
import ninteam_map_b.hymn_to_ninkasi.type.Scoreboard;

/**
 * Classe per l'interfaccia della scoreboard del gioco.
 * Visualizza la classifica dei punteggi dei giocatori.
 * 
 * @see javax.swing.JFrame
 * @see ninteam_map_b.hymn_to_ninkasi.restful.scoreboard.ScoreClient
 * @see ninteam_map_b.hymn_to_ninkasi.type.Scoreboard
 * 
 * @author francapali-NinTeam
 */
public class HTN_InterfacciaScoreboard extends javax.swing.JFrame {
    private final Color BACKGROUND = new Color(237, 232, 208);
    private final Color BACKGROUND_BLACK = new Color(54, 69, 79);
    private final Color TEXT = new Color(06, 06, 06);
    private final Color WHITE = new Color(250, 249, 246);
    private final String[] column = { "Nome Giocatore", "Tempo", "Data" };
    private String[][] scores = new String[9][9];
    private JTable scoreboard;
    private DefaultTableModel nonEditableModel;

    /**
     * Costruttore della classe HTN_InterfacciaScoreboard.
     * Inizializza i componenti dell'interfaccia.
     */
    public HTN_InterfacciaScoreboard() {
        initComponents();
    }
    
    /**
     * Inizializza i dati della scoreboard.
     * 
     * @param id ID del punteggio da inizializzare.
     * @return Il punteggio inizializzato.
     */
    private Scoreboard initializeScore(int id) {
        Scoreboard score;
        try {
            score = ScoreClient.getScore(id);
            return score;
        } catch (Exception e) {
            System.out.println("Errore nel recupero del punteggio.");
            return null;
        }
    }
    
    /**
     * Inizializza i componenti della GUI.
     */
    private void initComponents() {
        macroPanel = new javax.swing.JPanel();
        underPanel = new javax.swing.JPanel();
        close = new javax.swing.JButton();

        setTitle("Hymn To Ninkasi - Scoreboard");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\HTN_Logo.png"));
        setPreferredSize(new Dimension(600, 550));
        getContentPane().setBackground(BACKGROUND_BLACK);
        setLocationRelativeTo(null);
        setResizable(false);

        // Creo un modello di tabella non editabile
        nonEditableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Inizializza i dati della scoreboard
        Scoreboard temp = new Scoreboard();
        for (int i = 1; i < 10; i++) {
            temp = initializeScore(i);
            if (temp != null) {
                scores[i - 1][0] = temp.getName();
                scores[i - 1][1] = temp.getTimeSpent();
                scores[i - 1][2] = temp.getDate();
            }
        }
        nonEditableModel.setDataVector(scores, column);
        scoreboard = new JTable();
        scoreboard.setModel(nonEditableModel);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(scoreboard.getModel());
        scoreboard.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        scoreboard.getTableHeader().setResizingAllowed(false); // Disabilito il ridimensionamento delle colonne
        scoreboard.getTableHeader().setReorderingAllowed(false); // Disabilito lo spostamento delle colonne

        scoreboard.setBackground(BACKGROUND);
        scoreboard.setForeground(TEXT);
        scoreboard.setRowHeight(30);
        scoreboard.setGridColor(WHITE);
        scoreboard.setShowGrid(true);
        scoreboard.setShowVerticalLines(true);
        scoreboard.setShowHorizontalLines(true);
        scoreboard.getColumnModel().getColumn(0).setPreferredWidth(280);
        scoreboard.getColumnModel().getColumn(1).setPreferredWidth(70);
        scoreboard.getColumnModel().getColumn(2).setPreferredWidth(100);
        scoreboard.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        macroPanel.setBackground(BACKGROUND_BLACK);
        macroPanel.add(new JScrollPane(scoreboard)); // Necessario aggiungerlo ad uno JScrollPane per visualizzare anche
                                                     // i nomi delle colonne

        close.setText("Chiudi");
        close.setBackground(BACKGROUND);
        close.setForeground(TEXT);
        close.setPreferredSize(new Dimension(72, 30));

        close.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dispose();
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

        underPanel.add(close, BorderLayout.CENTER);
        getContentPane().add(macroPanel, BorderLayout.NORTH);
        getContentPane().add(underPanel, BorderLayout.SOUTH);

        pack();
    }

    private javax.swing.JPanel macroPanel;
    private javax.swing.JPanel underPanel;
    private javax.swing.JButton close;
}
