/**
 * Hymn_To_Ninkasi.java
 */
package ninteam_map_b.hymn_to_ninkasi;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import ninteam_map_b.hymn_to_ninkasi.config.DatabaseConfig;
import ninteam_map_b.hymn_to_ninkasi.dao.NinObjectDAO;
import ninteam_map_b.hymn_to_ninkasi.dialogue.DialogGraph;
import ninteam_map_b.hymn_to_ninkasi.dialogue.NinDialogueNode;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObservable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.ExamineObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.InventoryObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.LookAtObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.MoveObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.OpenObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.PickUpObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.ReadObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.TalkToObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.HelpObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.ChoiceObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.PlayObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.SaveObserver;
import ninteam_map_b.hymn_to_ninkasi.impl.UseObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.restful.trivia.TriviaClient;
import ninteam_map_b.hymn_to_ninkasi.type.*;
import ninteam_map_b.hymn_to_ninkasi.ui.HTN_InterfacciaGioco;

/**
 * Classe principale per testare la connessione al database e la gestione degli oggetti.ù
 * 
 * @author francapali
 * @author michelet
 * @author WilliTini
 */
public class Hymn_To_Ninkasi extends GameDesc implements GameObservable, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<GameObserver> observer = new ArrayList<>();

    private final ChoiceObserver choiceObserver1 = new ChoiceObserver();

    private ParserOutput parserOutput;

    private final List<String> messages = new ArrayList<>();

    private final Set<Integer> questions = new HashSet<>();

    private transient Random random = new Random();

    private Inventory inventory = Inventory.getInstance();

    private HTN_InterfacciaGioco interfacciaGioco;

    public void setInterfacciaGioco(HTN_InterfacciaGioco interfacciaGioco) {
        this.interfacciaGioco = interfacciaGioco;
    }

    @Override
    public void init() throws Exception {
        try {
            DatabaseConfig.initializeDatabase();
            System.out.println("Avviso: Database inizializzato correttamente.");

            // Popola il database eseguendo il file SQL
            DatabaseConfig.populateDatabase();
            System.out.println("Avviso: Popolamento del database avvenuto con successo.");

            // Crea un'istanza del DAO
            NinObjectDAO dao = new NinObjectDAO();
            System.out.println("Avviso: Istanza del DAO creata correttamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        messages.clear();

        Command nord = new Command(CommandType.NORTH, "nord");
        nord.setAlias(new String[]{"n", "Nord"});
        getCommands().add(nord);
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "Sud"});
        getCommands().add(sud);
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "Est"});
        getCommands().add(est);
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "Ovest"});
        getCommands().add(ovest);
        Command inventoryCommand = new Command(CommandType.INVENTORY, "inventario");
        inventoryCommand.setAlias(new String[]{"inv", "borsa"});
        getCommands().add(inventoryCommand);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "exit", "basta", "muori"});
        getCommands().add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi", "afferra", "agguanta"});
        getCommands().add(pickup);
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Command use = new Command(CommandType.USE, "usa");
        use.setAlias(new String[]{"utilizza"});
        getCommands().add(use);
        Command examine = new Command(CommandType.EXAMINE, "esamina");
        examine.setAlias(new String[]{"analizza"});
        getCommands().add(examine);
        Command read = new Command(CommandType.READ, "leggi");
        read.setAlias(new String[]{});
        getCommands().add(read);
        Command turnOn = new Command(CommandType.TURN_ON, "accendi");
        turnOn.setAlias(new String[]{});
        getCommands().add(turnOn);
        Command turnOff = new Command(CommandType.TURN_OFF, "spegni");
        turnOff.setAlias(new String[]{"spengi"});
        getCommands().add(turnOff);
        Command talkTo = new Command(CommandType.TALK_TO, "parla");
        talkTo.setAlias(new String[]{"dialoga", "conversa", "chiacchiera", "interloquisci", "discuti", "spettegola"});
        getCommands().add(talkTo);
        Command save = new Command(CommandType.SAVE, "salva");
        save.setAlias(new String[]{"salvataggio"});
        getCommands().add(save);
        Command load = new Command(CommandType.LOAD, "carica");
        load.setAlias(new String[]{"caricamento"});
        getCommands().add(load);
        Command scelta1 = new Command(CommandType.UNO, "1");
        getCommands().add(scelta1);
        Command scelta2 = new Command(CommandType.DUE, "2");
        getCommands().add(scelta2);
        Command help = new Command(CommandType.HELP, "help");
        help.setAlias(new String[]{"aiuto", "comandi", "help"});
        getCommands().add(help);
        Command play = new Command(CommandType.PLAY, "gioca");
        getCommands().add(play);

        getLastCommand().add(CommandType.READ);

        NinObject letter = NinObjectDAO.getNinObject(11);
        inventory.add(letter);
        NinObject lipGloss = NinObjectDAO.getNinObject(12);
        inventory.add(lipGloss);
        NinObject bathroomKey = NinObjectDAO.getNinObject(13);
        NinObject photo = NinObjectDAO.getNinObject(14);
        NinObject bathroomDoor = NinObjectDAO.getNinObject(15);
        NinObject mirror = NinObjectDAO.getNinObject(16);
        NinObject necklace = NinObjectDAO.getNinObject(17);
        NinObject polaroid = NinObjectDAO.getNinObject(150);

        getListObj().add(letter);
        getListObj().add(lipGloss);
        getListObj().add(bathroomKey);
        getListObj().add(photo);
        getListObj().add(bathroomDoor);
        getListObj().add(mirror);
        getListObj().add(necklace);

        NinRoom balcony = NinObjectDAO.getNinRoom(50);
        NinRoom livingRoom = NinObjectDAO.getNinRoom(51);
        livingRoom.getObjects().add(bathroomDoor);
        NinRoom kitchen = NinObjectDAO.getNinRoom(52);
        kitchen.getObjects().add(photo);
        kitchen.getObjects().add(polaroid);
        NinRoom bathroom = NinObjectDAO.getNinRoom(53);
        bathroom.getObjects().add(mirror);
        NinRoom entrance = NinObjectDAO.getNinRoom(54);
        entrance.getObjects().add(bathroomKey);

        balcony.setSouth(livingRoom);
        livingRoom.setNorth(balcony);
        livingRoom.setEast(bathroom);
        livingRoom.setSouth(entrance);
        livingRoom.setWest(kitchen);
        kitchen.setEast(livingRoom);
        bathroom.setWest(livingRoom);
        entrance.setNorth(livingRoom);

        getRooms().add(balcony);
        getRooms().add(livingRoom);
        getRooms().add(kitchen);
        getRooms().add(bathroom);
        getRooms().add(entrance);

        Characters gin = NinObjectDAO.getNinCharacters(1);
        entrance.getCharacters().add(gin);
        Characters martini = NinObjectDAO.getNinCharacters(2);
        bathroom.getCharacters().add(martini);
        Characters margarita = NinObjectDAO.getNinCharacters(3);
        balcony.getCharacters().add(margarita);
        Characters martiniPola = NinObjectDAO.getNinCharacters(2);
        bathroom.getCharacters().add(martiniPola);
        Characters ginKey = NinObjectDAO.getNinCharacters(1);
        ginKey.setName("gin1");
        bathroom.getCharacters().add(ginKey);
        Characters mojito = NinObjectDAO.getNinCharacters(5);
        livingRoom.getCharacters().add(mojito);

        System.out.println("");
        while (questions.size() < 5) {
            int randomNumber = 1 + random.nextInt(30);
            questions.add(randomNumber);
        }
        System.out.println("ID DOMANDE TRIVIA: " + questions);
        mojito.setTriviaId(questions);
        System.out.println("");

        List<Trivia> tempTrivia = new ArrayList<>();
        for (int i : questions) {
            tempTrivia.add(TriviaClient.getTrivia(i));
        }
        mojito.setTrivia(tempTrivia);

        for (int i = 0; i < mojito.getTrivia().size(); i++) {
            System.out.println("");
            System.out.println(mojito.getTrivia().get(i));
            System.out.println("");
        }

        GameObserver moveObserver = new MoveObserver();
        this.attach(moveObserver);
        GameObserver invObserver = new InventoryObserver();
        this.attach(invObserver);
        GameObserver lookatObserver = new LookAtObserver();
        this.attach(lookatObserver);
        GameObserver examineObserver = new ExamineObserver();
        this.attach(examineObserver);
        GameObserver pickupObserver = new PickUpObserver();
        this.attach(pickupObserver);
        GameObserver openObserver = new OpenObserver();
        this.attach(openObserver);
        GameObserver talkToObserver = new TalkToObserver();
        this.attach(talkToObserver);
        GameObserver choiceObserver = new ChoiceObserver();
        this.attach(choiceObserver);
        GameObserver readObserver = new ReadObserver();
        this.attach(readObserver);
        GameObserver helpObserver = new HelpObserver();
        this.attach(helpObserver);
        GameObserver playObserver = new PlayObserver();
        this.attach(playObserver);
        GameObserver saveObserver = new SaveObserver();
        this.attach(saveObserver);
        GameObserver useObserver = new UseObserver();
        this.attach(useObserver);

        setCurrentRoom(balcony);

        DialogGraph margaritaGraph = new DialogGraph();
        DialogGraph martiniGraph = new DialogGraph();
        DialogGraph ginGraph = new DialogGraph();
        DialogGraph martiniPolaGraph = new DialogGraph();
        DialogGraph ginKeyGraph = new DialogGraph();

        NinDialogueNode margaritaNode1 = NinObjectDAO.getNinDialogue(100);
        NinDialogueNode margaritaNode2 = NinObjectDAO.getNinDialogue(101);
        NinDialogueNode margaritaNode3 = NinObjectDAO.getNinDialogue(102);
        NinDialogueNode margaritaNode4 = NinObjectDAO.getNinDialogue(103);
        NinDialogueNode margaritaNode5 = NinObjectDAO.getNinDialogue(104);

        NinDialogueNode martiniPola260 = NinObjectDAO.getNinDialogue(260);
        NinDialogueNode martiniPola261 = NinObjectDAO.getNinDialogue(261);
        NinDialogueNode martiniPola262 = NinObjectDAO.getNinDialogue(262);
        NinDialogueNode martiniPola263 = NinObjectDAO.getNinDialogue(263);
        NinDialogueNode martiniPola280 = NinObjectDAO.getNinDialogue(280);
        NinDialogueNode martiniPola300 = NinObjectDAO.getNinDialogue(300);

        NinDialogueNode martiniNode200 = NinObjectDAO.getNinDialogue(200);
        NinDialogueNode martiniNode201 = NinObjectDAO.getNinDialogue(201);
        NinDialogueNode martiniNode202 = NinObjectDAO.getNinDialogue(202);
        NinDialogueNode martiniNode203 = NinObjectDAO.getNinDialogue(203);
        NinDialogueNode martiniNode220 = NinObjectDAO.getNinDialogue(220);
        NinDialogueNode martiniNode221 = NinObjectDAO.getNinDialogue(221);
        NinDialogueNode martiniNode240 = NinObjectDAO.getNinDialogue(240);
        NinDialogueNode martiniNode241 = NinObjectDAO.getNinDialogue(241);

        NinDialogueNode ginNode320 = NinObjectDAO.getNinDialogue(320);
        NinDialogueNode ginNode321 = NinObjectDAO.getNinDialogue(321);
        NinDialogueNode ginNode322 = NinObjectDAO.getNinDialogue(322);
        NinDialogueNode ginNode323 = NinObjectDAO.getNinDialogue(323);
        NinDialogueNode ginKeyNode340 = NinObjectDAO.getNinDialogue(340);
        NinDialogueNode ginKeyNode341 = NinObjectDAO.getNinDialogue(341);
        NinDialogueNode ginKeyNodeNull = new NinDialogueNode(3, "null", null, null);

        margarita.getDialogue().add(margaritaGraph);
        martini.getDialogue().add(martiniGraph);
        gin.getDialogue().add(ginGraph);
        martiniPola.getDialogue().add(martiniPolaGraph);
        ginKey.getDialogue().add(ginKeyGraph);

        martiniPola260.addChoice(martiniPola260.getC1(), martiniPola261);
        martiniPola260.addChoice(martiniPola260.getC2(), martiniPola261);
        martiniPola261.addChoice(martiniPola261.getC1(), martiniPola262);
        martiniPola261.addChoice(martiniPola261.getC2(), martiniPola262);
        martiniPola262.addChoice(martiniPola262.getC1(), martiniPola263);
        martiniPola262.addChoice(martiniPola262.getC2(), martiniPola263);
        martiniPola263.addChoice(martiniPola263.getC1(), martiniPola280);
        martiniPola263.addChoice(martiniPola263.getC2(), martiniPola300);
        martiniPola280.addChoice(martiniPola280.getC1(), null);
        martiniPola280.addChoice(martiniPola280.getC2(), null);
        martiniPola300.addChoice(martiniPola300.getC1(), null);
        martiniPola300.addChoice(martiniPola300.getC2(), null);

        margaritaNode1.addChoice(margaritaNode1.getC1(), margaritaNode2);
        margaritaNode1.addChoice(margaritaNode1.getC2(), margaritaNode2);
        margaritaNode2.addChoice(margaritaNode2.getC1(), margaritaNode3);
        margaritaNode2.addChoice(margaritaNode2.getC2(), margaritaNode4);
        margaritaNode3.addChoice(margaritaNode3.getC1(), margaritaNode5);
        margaritaNode3.addChoice(margaritaNode3.getC2(), margaritaNode5);
        margaritaNode4.addChoice(margaritaNode4.getC1(), margaritaNode5);
        margaritaNode4.addChoice(margaritaNode4.getC2(), margaritaNode5);

        martiniNode200.addChoice(martiniNode200.getC1(), martiniNode201);
        martiniNode200.addChoice(martiniNode200.getC2(), martiniNode201);
        martiniNode201.addChoice(martiniNode201.getC1(), martiniNode202);
        martiniNode201.addChoice(martiniNode201.getC2(), martiniNode202);
        martiniNode202.addChoice(martiniNode202.getC1(), martiniNode203);
        martiniNode202.addChoice(martiniNode202.getC2(), martiniNode203);
        martiniNode203.addChoice(martiniNode203.getC1(), martiniNode220);
        martiniNode203.addChoice(martiniNode203.getC2(), martiniNode240);
        martiniNode220.addChoice(martiniNode220.getC1(), martiniNode221);
        martiniNode220.addChoice(martiniNode220.getC2(), martiniNode221);
        martiniNode221.addChoice(martiniNode221.getC1(), null);
        martiniNode221.addChoice(martiniNode221.getC2(), null);
        martiniNode240.addChoice(martiniNode240.getC1(), martiniNode241);
        martiniNode240.addChoice(martiniNode240.getC2(), martiniNode241);
        martiniNode241.addChoice(martiniNode241.getC1(), null);
        martiniNode241.addChoice(martiniNode241.getC2(), null);

        ginNode320.addChoice(ginNode320.getC1(), ginNode321);
        ginNode320.addChoice(ginNode320.getC2(), ginNode322);
        ginNode321.addChoice(ginNode321.getC1(), ginNode323);
        ginNode321.addChoice(ginNode321.getC2(), null);
        ginNode322.addChoice(ginNode322.getC1(), ginNode323);
        ginNode322.addChoice(ginNode322.getC2(), null);
        ginNode323.addChoice(ginNode323.getC1(), null);
        ginNode323.addChoice(ginNode323.getC2(), null);

        ginKeyNode340.addChoice(ginKeyNode340.getC1(), ginKeyNode341);
        ginKeyNode340.addChoice(ginKeyNode340.getC2(), ginKeyNode341);
        ginKeyNode341.addChoice(ginKeyNode341.getC1(), null);
        ginKeyNode341.addChoice(ginKeyNode341.getC2(), null);

        margaritaGraph.addNode(1, margaritaNode1);
        margaritaGraph.addNode(2, margaritaNode2);
        margaritaGraph.addNode(3, margaritaNode3);
        margaritaGraph.addNode(4, margaritaNode4);
        margaritaGraph.addNode(5, margaritaNode5);

        martiniGraph.addNode(1, martiniNode200);
        martiniGraph.addNode(2, martiniNode201);
        martiniGraph.addNode(3, martiniNode202);
        martiniGraph.addNode(4, martiniNode203);
        martiniGraph.addNode(5, martiniNode220);
        martiniGraph.addNode(6, martiniNode221);
        martiniGraph.addNode(7, martiniNode240);
        martiniGraph.addNode(8, martiniNode241);

        martiniPolaGraph.addNode(1, martiniPola260);
        martiniPolaGraph.addNode(2, martiniPola261);
        martiniPolaGraph.addNode(3, martiniPola262);
        martiniPolaGraph.addNode(4, martiniPola263);
        martiniPolaGraph.addNode(5, martiniPola280);
        martiniPolaGraph.addNode(6, martiniPola300);

        ginGraph.addNode(1, ginNode320);
        ginGraph.addNode(2, ginNode321);
        ginGraph.addNode(3, ginNode322);
        ginGraph.addNode(4, ginNode323);
        ginKeyGraph.addNode(1, ginKeyNode340);
        ginKeyGraph.addNode(2, ginKeyNode341);
        ginKeyGraph.addNode(3, ginKeyNodeNull);
    }

    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        parserOutput = p;
        messages.clear();
        if (p != null) {
            if (p.getCommand() == null) {
                out.println("Non e' chiaro quel che vuoi fare, ritenta!");
            } else if (getTalkTrigger()) {
                if (p.getCommand().getType() == CommandType.UNO || p.getCommand().getType() == CommandType.DUE) {
                    messages.add(choiceObserver1.update(p, this));
                    if (!messages.isEmpty()) {
                        for (String m : messages) {
                            if (m.length() > 0) {
                                out.println(m);
                            }
                        }
                    }
                } else {
                    messages.add("Mentre parli con qualcuno e' da maleducati fare altro...");
                    if (!messages.isEmpty()) {
                        for (String m : messages) {
                            if (m.length() > 0) {
                                out.println(m);
                            }
                        }
                    }
                }
            } else if (isTriviaStarted()) {
                if (p.getCommand().getType() == CommandType.UNO || p.getCommand().getType() == CommandType.DUE) {
                    messages.add(choiceObserver1.update(p, this));
                    if (!messages.isEmpty()) {
                        for (String m : messages) {
                            if (m.length() > 0) {
                                out.println(m);
                            }
                        }
                    }
                } else {
                    messages.add("Non e' una risposta valida! Vuoi farmi perdere tempo?!");
                    if (!messages.isEmpty()) {
                        for (String m : messages) {
                            if (m.length() > 0) {
                                out.println(m);
                            }
                        }
                    }
                }
            } else {
                notifyObservers();
                if (getCurrentRoom() != null) {
                    NinRoom cr = getCurrentRoom();
                    String namecr = cr.getName();
                    if (interfacciaGioco != null) {
                        interfacciaGioco.updateRoomImage(namecr);
                    }
                }
                if (!messages.isEmpty()) {
                    for (String m : messages) {
                        if (m.length() > 0) {
                            out.println(m);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getWelcomeMsg() {
        return "Ti trovi all'ultimo piano del grattacielo che ospita la festa di Gin, una tua cara amica.\n"
            + "Siete tutti in attesa della mezzanotte che segnerà la fine del ventesimo secolo e l'inizio del ventunesimo.\n"
            + "Sebben la musica sia ad un volume spropositatamente alto, il chiacchiericcio attorno sembra distrarti.\n\n" 
            + "Puoi spostarti da una stanza all'altra digitando 'NORD', 'SUD', 'EST' o 'OVEST'\n"
            + "Per aprire la tua borsetta, basta digitare 'Inventario' o 'Borsa'\n"
            + "Tutti gli altri comandi potresti volerli scoprire in solitaria, ma se hai bisogno\n"
            + "di un aiuto o ti sfugge qualcosa in particolare, digita 'HELP'\n"
            + "Buona serata e buon divertimento!\n";

    }

    @Override
    public void attach(GameObserver o) {
        if (!observer.contains(o)) {
            observer.add(o);
        }
    }

    @Override
    public void detach(GameObserver o) {
        observer.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (GameObserver o : observer) {
            messages.add(o.update(parserOutput, this));
        }
    }

    @Override
    public void playTrivia(int id) {
        if (isTriviaStarted()) {
            if (isCorrectTrivia()) {
                messages.add("Mojito:-'Risposta esatta!'");
                incrementCounter();
            } else {
                messages.add("Mojito:-'Risposta errata!'");
            }

            messages.add("Mojito:-'Prossima domanda!'");
            
            if (this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id) == null) {
                System.out.println("");
                System.out.println("TRIVIA NULLO");
                System.out.println("");
            }

            messages.add(id + 1 + ")" + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id).getQuestion() + "\n");
            setRandomNumber(1 + random.nextInt(2));
            System.out.println(getRandomNumber());
            if (getRandomNumber() == 1) {
                messages.add("1." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id).getAnswer1() + "\n"
                    + "2." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id).getAnswer2());
            } else {
                messages.add("1." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id).getAnswer2() + "\n"
                    + "2." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(id).getAnswer1());
            }
        } else {
            setTriviaStarted(true);
            messages.add("Mojito:-'Quindi hai deciso di metterti alla prova contro il maestro dei quiz! Vediamo come te la caverai!'\nMojito:-'Prima domanda!'");
            messages.add("1)" + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(0).getQuestion() + "\n");
            setRandomNumber(1 + random.nextInt(2));
            System.out.println(getRandomNumber());
            if (getRandomNumber() == 1) {
                messages.add("1." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(0).getAnswer1() + "\n"
                    + "2." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(0).getAnswer2());
            } else {
                messages.add("1." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(0).getAnswer2() + "\n"
                    + "2." + this.getCurrentRoom().getCharacters().get(0).getTrivia().get(0).getAnswer1());
            }
        }
    }
}