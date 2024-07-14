package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import java.util.stream.IntStream;

public class ChoiceObserver implements GameObserver, Serializable {

    static int triviaCounter = 1;
    
    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        
        if (parserOutput.getCommand().getType() == CommandType.UNO || parserOutput.getCommand().getType() == CommandType.DUE) {
            if (game.getTalkTrigger()) {
                //msg.append(game.getLastCommand().getLast());
                if (!game.getCurrentRoom().getCharacters().isEmpty()) {
                    if (game.getCurrentRoom().getCharacters().get(0).getName().equals("margarita")) {
                        if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                            game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).setMarked(true);                     
                            msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getNpcDialogue() + "\n\n");
                            msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC1() + "\n");
                            msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC2());
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).isMarked()) {                                                     
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                //game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC2());
                                //IntStream.of(2,3).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            }   

                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).isMarked()) {
                            msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getNpcDialogue() + "\n\n");

                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).setMarked(true);
                                game.getCurrentRoom().getCharacters().remove(0);
                                game.setTalkTrigger(false);
                                game.getCurrentRoom().setLookEast("Alla tua destra non c'e' piu' nessuno. Margarita e' entrata in casa chissa' dove.");
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).setMarked(true);
                                game.getCurrentRoom().getCharacters().remove(0);
                                game.setTalkTrigger(false);
                                game.getCurrentRoom().setLookEast("Alla tua destra non c'e' piu' nessuno. Margarita e' entrata in casa chissa' dove.");

                            } 
                        }  
                    } else if (game.getCurrentRoom().getCharacters().get(0).getName().equals("martini") && game.getInventory().getSet().contains(game.getListObj().get(3))) { //con polaroid
                        if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                            game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).setMarked(true);
                            msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getNpcDialogue() + "\n\n");
                            msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC1() + "\n");
                            msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC2());
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC2());
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC2());
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getC2());
                                IntStream.range(4,5).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC2()); 
                                IntStream.range(4,5).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));                                
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).isMarked()) {
                            game.getCurrentRoom().getCharacters().remove(0);
                            game.setTalkTrigger(false);
                            game.setCurrentRoom(null);
                        }

                    } else if (game.getCurrentRoom().getCharacters().get(0).getName().equals("martini")) {
                        if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                            game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).setMarked(true);
                            msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getNpcDialogue() + "\n\n");
                            msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC1() + "\n");
                            msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC2());
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC2());;
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getC2());;
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).setMarked(true);
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).getC2());
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                IntStream.range(4,6).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(7).getNpcDialogue() + "\n\n"); 
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(7).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(7).getC2());
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(5).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC2());
                                IntStream.rangeClosed(5,6).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).getC2());
                                IntStream.rangeClosed(5,6).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(6).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getC2());
                                IntStream.range(6, 7).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                //game.setTalkTrigger(false);
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(8).getC2());
                                IntStream.range(6, 7 ).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                //game.setTalkTrigger(false);
                                
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(7).isMarked()) {
                            game.getCurrentRoom().getCharacters().remove(1);
                            game.getCurrentRoom().getCharacters().remove(0);
                            game.setCurrentRoom(null);
                            game.setTalkTrigger(false);

                        }
                    } else if (game.getCurrentRoom().getCharacters().get(0).getName().equals("gin")) {
                        if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                            if (parserOutput.getCommand().getType() == CommandType.UNO) { 
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC2());
                                IntStream.of(1,3).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getNpcDialogue() + "\n\n");
                                msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC1() + "\n");
                                msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).getC2());
                                IntStream.rangeClosed(1,2).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                            }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).isMarked()) {
                                if (parserOutput.getCommand().getType() == CommandType.UNO) { 
                                    msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                    IntStream.rangeClosed(2,4).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                    game.getCurrentRoom().getCharacters().remove(0);
                                    game.setTalkTrigger(false);
                                } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                    IntStream.rangeClosed(2,4).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                    game.getCurrentRoom().getCharacters().remove(0);
                                    game.setTalkTrigger(false);
                                    msg.append("Saluti i tre e ti allontani, ritornando verso il centro dell''ingresso.");
                                }
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).isMarked()) {
                            if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).isMarked()) {
                                if (parserOutput.getCommand().getType() == CommandType.UNO) {
                                    msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(4).getNpcDialogue() + "\n\n");
                                    game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(3).setMarked(true);
                                    game.getCurrentRoom().getCharacters().remove(0);
                                    game.setTalkTrigger(false);
                                    game.getCurrentRoom().setLookWest("Alla tua sinistra, Gin sta intrattenendosi con i suoi ospiti, Will e Mike." +
                                    "Li hai gia' importunati abbastanza, forse non vorranno parlarti...per ora.");

                                } else if (parserOutput.getCommand().getType() == CommandType.DUE) {
                                    IntStream.rangeClosed(3,4).forEach(i -> game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(i).setMarked(true));
                                    game.getCurrentRoom().getCharacters().remove(0);
                                    game.setTalkTrigger(false);
                                    msg.append("Saluti i tre e ti allontani, ritornando verso il centro dell''ingresso.");
                                    game.getCurrentRoom().setLookWest("Alla tua sinistra, Gin sta intrattenendosi con i suoi ospiti, Will e Mike." +
                                    "Li hai gia' importunati abbastanza, forse non vorranno parlarti...per ora.");
                                }
                            }
                        } 
                    } else if (game.getCurrentRoom().getCharacters().get(0).getName().equals("gin1")) {
                        if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                            game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).setMarked(true);
                            msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getNpcDialogue() + "\n\n");
                            msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC1() + "\n\n");
                            msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).getC2() + "\n");
                        } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).isMarked()) {
                            game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(2).setMarked(true);
                            msg.append("Ti allontani da Gin, con la chiave del bagno in mano. Ora dovresti andare ad aprire il bagno e scoprire cosa succede...oppure puoi andare in giro");
                            game.getInventory().add(game.getListObj().get(2));
                            game.getCurrentRoom().getCharacters().remove(0);
                            game.setTalkTrigger(false);
                        }
                    }
                }   
            } else if (game.isTriviaStarted()) {
                if (triviaCounter <= 5) {
                    if (parserOutput.getCommand().getType() == CommandType.UNO && game.getRandomNumber() == 1) {
                        game.setCorrectTrivia(true);
                        if (triviaCounter < 5) {
                            game.playTrivia(triviaCounter);
                        }
                        if (triviaCounter == 5) {
                            game.incrementCounter();
                            msg.append("Mojito:-'Risposta esatta!'\n");
                            msg.append("Mojito:-'Hai finito il mio gioco con un punteggio di " + game.getCorrectCounter() + "! Le mie domande non sono poi cosi' difficili!'\n");                                               msg.append("Ti lascio alla festa, buona continuazione in salotto!");
                            msg.append("Mojito:-'Ti lascio alla festa, buona continuazione in salotto!'");
                            game.setTriviaStarted(false);
                        }
                        //risposta giusta
                    } else if (parserOutput.getCommand().getType() == CommandType.DUE && game.getRandomNumber() == 2) {
                        game.setCorrectTrivia(true);
                        if (triviaCounter < 5) {
                            game.playTrivia(triviaCounter);
                        }
                        if (triviaCounter == 5) {
                            game.incrementCounter();
                            msg.append("Mojito:-'Risposta esatta!'\n");
                            msg.append("Mojito:-'Hai finito il mio gioco con un punteggio di " + game.getCorrectCounter() + "! Le mie domande non sono poi cosi' difficili!'\n");                                               msg.append("Ti lascio alla festa, buona continuazione in salotto!");
                            msg.append("Mojito:-'Ti lascio alla festa, buona continuazione in salotto!'");
                            game.setTriviaStarted(false);
                        }
                        //risposta giusta
                    } else {
                        game.setCorrectTrivia(false);
                        if (triviaCounter < 5) {
                            game.playTrivia(triviaCounter);
                        }
                        if (triviaCounter == 5) {
                            msg.append("Mojito:-'Risposta errata!'\n");
                            msg.append("Mojito:-'Hai finito il mio gioco con un punteggio di " + game.getCorrectCounter() + "! Le mie domande non sono poi cosi' difficili!'\n");
                            msg.append("Mojito:-'Ti lascio alla festa, buona continuazione in salotto!'");
                            game.setTriviaStarted(false);
                        }
                        //risposta sbagliata
                    }
                    triviaCounter++;
                }
            } else {
                    msg.append("Non puoi rispondere a qualcuno se non stai parlando con nessuno...");
            }   
        }
        return msg.toString();
    }
}
       