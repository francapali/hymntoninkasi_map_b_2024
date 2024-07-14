INSERT INTO NinCharactersTable(id, name, bio) VALUES
(1, 'gin', 'Dal carattere forte e determinato, e'' amica di Wine, 
Margarita e Martini dai tempi del college, non sono mai piu'' state in grado di separarsi. 
Vive una vita agiata e privilegiata, ha trent''anni, e'' un''architetta specializzata in design di interni. 
Adorna sfoggiare le case che ristruttura da cima a fondo come se stesse mettedo in vetrina la sua migliore versione di se''. 
Motivo per il quale il suo nuovo loft nel cuore di New York City, 
fresco fresco di ristrutturazione e'' il luogo piu'' adatto per ospitare la festa piu'' attesa dell''anno.');

INSERT INTO NinCharactersTable(id, name, bio) VALUES
(2, 'martini', 'Martini non ha ancora deciso cosa fara'' da grande, ha concluso gli studi in legge ma non e'' un''avvocata, 
amava le passerelle ma mai da intraprendere la carriera da stilista. 
Ma di una cosa era consapevole: non avrebbe mai scambiato la sua vita con quella di nessun altro al mondo.
Il lusso, le serate di gala, i suoi abiti firmati e suo padre, cui e'' molto legata. Ritrovare se stessi nelle 
lande desolate del Colorado era troppo radical chic anche per lei, e che caldo poi!');

INSERT INTO NinCharactersTable(id, name, bio) VALUES
(3, 'margarita', 'Donna semplice e genuina. Cuoca di successo in uno dei ristoranti italiani piu'' in della contea. 
La sua love-language non e'' altro che cucinare per chi ama. Sempre pronta all''avventura, e'' da poco tornata dall''Europa con una ventata di sapori mediterranei da far girare la testa agli invitati della padrona di casa.');

INSERT INTO NinCharactersTable(id, name, bio) VALUES
(4, 'wine', 'Sviluppatrice software, appassionata all''arte e al buon vino. 
Ama trascorrere le serate nelle case di Gin, ogni volta in attesa di un nuovo pezzo in aggiunta alla sua collezione di design. 
Testarda e irremovibile nelle sue scelte, desidera avere l''ultima parola su tutto. Vive in un mondo di uomini, imprigionata negli stereotipi di genere che fin troppo spesso danno il potere alla sua testa di autosabotarla. 
Al college le ragazze hanno rappresentato per lei un''ancora di salvezza e una fonte inesauribile d''ispirazione nella vita di 
tutti i giorni come esempio lampante di donne forti.');

INSERT INTO NinCharactersTable(id, name, bio) VALUES
(5, 'mojito', 'Venditore di prodotti di cancelleria, Mojito e'' appassionato di quiz e sfide intellettuali. Lavora come Assistant to the Regional Manager in un''azienda specializzata nella vendita di carta, dove si distingue per la sua dedizione e precisione.
Ama trascorrere le serate a inventare nuovi quiz e domande, sempre alla ricerca di nuove curiosita'' da aggiungere al suo repertorio. Testardo e appassionato, non perde occasione per condividere la sua passione con chiunque incroci il suo sguardo.');

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(11, 'lettera', 'Una lettera scritta con una penna gel nera su un foglio a righe: e'' la tua grafia.', 'foglio', FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, FALSE, NULL);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(12, 'lip-gloss', 'Un Lip-gloss trasparente dal valore di 70$, rende le labbra tanto lucide quanto appiccicose, da rendere impossibile anche parlare.', 'lucidalabbra', FALSE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE, 6);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(13, 'chiave del bagno', 'Una chiave universale che permette di aprire dall''esterno la porta del bagno. E'' impreziosita da un portachiavi con un pompon rosa.', 'chiave', TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE, 5);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(14, 'polaroid', 'Una polaroid scattata il 28 Maggio 1990, in occasione del Memorial Day, siete tutte sorridenti e felici, in fondo eravate in pausa dalle lezioni!
Il ricordo di una bella giornata insieme e di anni spensierati della vostra amicizia.', 'foto', TRUE, TRUE, FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, NULL);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(15, 'porta del bagno', 'Questa porta del bagno e'' in legno bianco con serratura e pomello rosa.
Sembra essere chiusa a chiave, impedendo l''accesso.
Dall''interno senti dei singhiozzi familiari che ti ricordano la tua amica Martini.
Dalla fessura sotto la porta filtra una luce blu. Chissa'' cosa stara'' succedendo.
Potresti chiedere alla padrona di casa una chiave passpourtout.
Non potendo entrare, quel che puoi fare e'' dirigerti verso ovest, ritornando nel salotto animato dalla festa.', 'porta', FALSE, FALSE, FALSE, TRUE, TRUE, FALSE, FALSE, FALSE, 3);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(16, 'specchio del bagno', 'Non hai mai visto il tuo viso riflettersi cosi'' nitidamente su uno specchio.
Una luce blu irradia la sua circonferenza illuminandoti il viso. Tra una discoteca e uno schiaffo alla classe operaia', 'specchio', FALSE, FALSE, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE, 2);

INSERT INTO NinObjectTable (id, name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES
(17, 'collana di perle', 'La fantomatica collana di perle di Martini.
Oggetto di discordia capace di ridurre in frantumi un''amicizia nascondendosi nello scarico della toilette per tutta la notte.', 'collana', FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, NULL);

INSERT INTO NinRoomTable (id, name, description, north, look_north, south, look_south, east, look_east, west, look_west) VALUES
(50, 'Terrazzo', 'Che eleganza!
Tutti gli invitati sbrilluccicano e sono coperti da un sottile strato di neve e una tiepida nuvola di fumo.

Nonostante il freddo riesci a percepire il calore delle festivita'' invernali, forse basta poco per dimenticarsi dei problemi.
Prova a guardarti intorno e scegli come trascorrere questa serata indimenticabile.',
0 /*(DA SOSTITUIRE) codice dialogo Ci hai provato, ma pare non essere la serata adatta per superare le proprie paure. La luna e'' bellissima oggi.*/, 'Davanti a te, verso nord, puoi ammirare parzialmente il panorama degli altissimi palazzi illuminati per le festivita'' natalizie. Potresti guardare meglio la vista se ti avvicinassi, soffri di vertigini, dovresti pensarci bene prima, non vorrai cadere!',
51, 'Alle tue spalle, una porta vetrata conduce al salotto.

Vedi del movimento, si stanno formando delle coppie per una partita di beer-pong, potrebbe rivelarsi interessante visitare una zona diversa della casa.',
0, 'Alla tua destra, non molto distante da te, puoi osservare Margarita.

Sembra essere sulle sue, potrebbe non voler scambiare due chiacchiere, allo stesso tempo se non le parli potresti non scoprirlo mai, tentar non nuoce.',
0, 'Non vedi nulla di interessante qui. Che ne diresti di guardare altrove?');

INSERT INTO NinRoomTable (id, name, description, north, look_north, south, look_south, east, look_east, west, look_west) VALUES
(51, 'Salotto', 'Una stanza moderna e accogliente.
Il pavimento e'' rivestito con un elegante parquet chiaro, riflette la luce calda delle lampade a sospensione in stile industriale.

Il centro del salotto e'' dominato da un ampio divano ad angolo in velluto grigio, circondato da una serie di tavolini bassi in vetro e metallo.
Alle pareti, mensole eleganti ospitano libri e oggetti decorativi, mentre un grande tappeto geometrico aggiunge un tocco di colore e comfort.

Si respira un clima vivace e festoso, con musica e risate che riempiono la stanza, e diversi ospiti intenti a formare coppie per una partita di beer-pong.
In un angolo, vedi un ragazzo dall''aria stravagante. Potrebbe valerne la pena parlarci due minuti.',
50, 'Alle tue spalle, grandi finestre a tutta parete, dotate di tende leggere, si affacciano a nord sul terrazzo, creando un collegamento visivo con l''esterno.',
54, 'Davanti a te, l''ingresso principale del loft accoglie gli ospiti con un piccolo corridoio ornato da alcune delle fotografie di viaggio di Gin, incorniciate con gusto.',
53, 'Sulla tua destra vedi una imponente porta bianca, dallo stile discutibile per un bagno dal momento che e'' adornata da un pomello rosa.',
52, 'Sulla tua sinistra si trova un passaggio che da'' accesso alla cucina, da cui proviene un irresistibile profumo di stuzzichini preparati per la festa.');

INSERT INTO NinRoomTable (id, name, description, north, look_north, south, look_south, east, look_east, west, look_west) VALUES
(52, 'Cucina', 'Un capolavoro di design contemporaneo, perfettamente ottimizzata per sfruttare al meglio ogni centimetro di spazio.
Verso sud, un tavolo attaccato al muro.
Sulla parete ovest, un''isola con piano cottura rappresenta il cuore della stanza.

La cucina e'' arredata con pensili minimalisti in legno chiaro e maniglie discrete, mentre il paraschizzi in piastrelle di ceramica bianca aggiunge un tocco di luminosita''.
L''illuminazione a LED sotto i pensili fornisce una luce diretta e funzionale sulle superfici di lavoro.

L''atmosfera e'' animata, con ospiti che si affollano intorno all''isola, chiacchierando e gustando gli stuzzichini preparati per la festa.',
0, 'Davanti a te, un elegante frigorifero in acciaio inossidabile attira l''attenzione, decorato con una collezione di polaroid che catturano momenti speciali della vita di Gin, una foto in particolare cattura la tua attenzione: prova a prenderla.',
0, 'Ti soffermi in questa parte della stanza, il tavolo offre una soluzione pratica per i pasti informali.
Realizzato in legno chiaro, e'' accompagnato da sgabelli alti un ottimo punto d''appoggio per snack e Aperol Spritz. Senti un forte odore di arancia.',
51, 'Alla tua destra, un arco collega la cucina al salotto, permettendo una continuita'' visiva e facilitando la socializzazione tra gli spazi.',
0, 'Sei rimasta incantata come una persona casalinga dal piano cottura a induzione, moderno ed efficiente, circondato da ampi piani di lavoro in quarzo bianco, ideali per la preparazione dei cibi.
Sopra l''isola, un''elegante cappa aspirante in acciaio garantisce un ambiente privo di odori sgradevoli.');

INSERT INTO NinRoomTable (id, name, description, north, look_north, south, look_south, east, look_east, west, look_west) VALUES
(53, 'Bagno', 'Un bagno elegante e moderno, progettato per offrire un''esperienza di comfort e relax.
Le pareti sono rivestite di piastrelle in marmo bianco, che conferiscono un aspetto pulito e sofisticato.

Verso nord, una vasca da bagno bianca, intravedi fiocamente illuminato, il volto di Martini, seduta a terra.
Piange a dirotto, potresti provare a parlarle per capire cosa sta succedendo, oppure evitare il dialogo.

A est, un ampio specchio con luci LED integrate illumina lo spazio, rendendo la preparazione mattutina un piacere.
Sul lato ovest, un mobile lavabo sospeso, realizzato in legno chiaro, aggiunge calore e funzionalita'' alla stanza.

La stanza e'' completata da dettagli cromati e accessori di design che enfatizzano l''estetica moderna del bagno.',
0, 'Di fronte a te c''e'' una vasca da bagno. Martini subito a destra e'' seduta a terra e sta continuando a singhiozzare, potresti parlarle o decidere di evitare il dialogo.',
0, 'A sud, un piccolo tappeto morbido in cotone assorbe l''umidita'' e aggiunge un tocco di comfort ai tuoi piedi quando esci dalla doccia.',
0, 'Sulla parete orientale, un mobile lavabo sospeso, in legno chiaro, offre ampio spazio per riporre gli articoli da toeletta e aggiunge un tocco di eleganza naturale al bagno.',
51, 'Verso ovest, un ampio specchio tondo emana una luce blu: sarebbe l''ideale sistemare un po'' il trucco, che ne pensi?');

INSERT INTO NinRoomTable (id, name, description, north, look_north, south, look_south, east, look_east, west, look_west) VALUES
(54, 'Ingresso', 'Un''accogliente area che introduce al cuore della casa.
A est, una porta conduce all''esterno, permettendo di uscire dall''appartamento.
A ovest, vedi Gin, la padrona di casa, che chiacchiera animatamente con alcuni ospiti.
Verso sud, non c e'' nulla di particolare da segnalare, lasciando l''ingresso libero e spazioso.',
51, 'Davanti a te, un arco che conduce direttamente in salotto, da cui senti provenire il vivace rumore della festa.',
0, 'Non vedi nulla di interessante qui, che ne diresti di guardare altrove?',
0, 'Andare via? Davvero?',
0, 'Alla tua sinistra, Gin sta intrattenendosi con i suoi ospiti, potresti intrometterti per parlare e chiederle come sta andando la festa.');

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(100, 'Margarita', 'Prima ancora di parlare, Margarita ti porge un calice di rosso. Vuole metterti a tuo agio.

Marg:-"Ho il sentore che stia per nevicare, non fa leggermente troppo freddo qui fuori secondo te? Sono uscita per prendere aria ma penso sia il caso di rientrare"',
'"Sara'' come dici tu."', '"Hai speso piu'' di 2.000 dollari per quella ecopelliccia che ti ostini a non usare per scaldarti."', 
101, 101);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(101, 'Margarita', 'Marg:-"Come siamo polemiche stasera! Spero tu non stia rispondendo cosi'' a causa del tuo battibecco con Martini! Sai benissimo quel che penso su quel tubino bianco! Ti stava una favola!"',
'"Non riusciva a chiudersi la zip! Avrei finito con il rovinarlo!"',
'"Martini sognava di abbinarci quel collier, non potevo farle questo!"',
102, 103);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(102, 'Margarita', 'Marg:-"Si'' lo so, ti sei ripetuta cosi'' tante volte che, a questo punto, non penso sarebbe stato realmente un problema. Mi preoccuperei piuttosto della percezione che hai del tuo corpo. Mi auguro che il 2000 porti con se'' un briciolo amore nei confronti di te stessa."',
'"..."', '"Mi auguro lo stesso."',
104, 104);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(103, 'Margarita', 'Marg:-"Ad essere onesta non capisco cosa ci veda in quella stupida collana di perle. Sembra ossessionata al punto tale da basarci la sua personalita''. Mi auguro che il nuovo millennio suoni per lei come una sveglia di consapevolezza."',
'"..."', '"Mi auguro lo stesso."',
104, 104);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(104, 'Margarita', 'Marg:-"Non pensarci adesso, sei incantevole anche con questo tailleur grigio, mai un capello fuori posto con te! Per non parlare di quella borsetta: avrei giurato non fosse cosi'' capiente, eppure ti ho vista tirar fuori anche l''ombrello di Mary Poppins!"

Vi osservate per un paio di secondi senza che nessuna delle due dica niente.
Le sorridi, ricambia affrettandosi a riporre il suo cerca-persone nella sua borsa.

Marg:-"Beh, a questo punto ci si vede dentro! Chissa'' se nevica anche li''!"

Vedi Margarita allontanarsi con passo svelto dal terrazzo e dirigersi verso il salotto. La tua conversazione con lei e'' stata particolare al punto tale da lasciarti perplessa.
Torni al centro del terrazzo.',
NULL, NULL, 
0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(150, 'La Polaroid', 'Sono tanti i ricordi che riaffiorano alla vista di questa istantanea datata 28 Maggio 1990. Era il Memorial Day, quasi dieci anni fa, tutte e quattro sorridenti, ingenue e pronte all''avventura. Forse quello del college e'' stato l''unico periodo in cui siete state realmente felici insieme.
Eravate in pausa dalle lezioni, i problemi piu'' grandi erano i capelli in un''umida giornata estiva e gli inviti che non arrivavano dalle congregazioni piu'' in voga del campus, eravate spensierate e non lo credevate.
Provi un senso di nostalgia, dove sono finiti quei giorni? Quelle ragazze dove si sono perse?
Non ricordi di avere rullini ancora da sviluppare eppure non hai neanche una foto a casa che vi ritragga al completo come in questo caso.
Sei sempre stata il collante delle ragazze e ne sei consapevole.',
NULL, NULL, 0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(200, 'Martini senza Polaroid', 'Decidi di sederti a terra, abbastanza vicino da poter sentire le vostre braccia sfiorarsi.',
'"Perche'' ci disperiamo qui in bagno?"', '"Che succede Martini? Ti fa male qualcosa?"', 201, 201);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(201, 'Martini senza Polaroid', 'Mart:-"Lasciamo stare Wine, serata pessima."',
'"Perche'', cosa sta succedendo???"', '"A chi lo dici, vorrei che tutto questo finisse il prima possibile."', 202, 202);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(202, 'Martini senza Polaroid', 'Mart:-"Io te lo giuro, ti prego di aiutarmi, non riesco a ricordare con nitidezza, so solo che..."', '"Che?"', '"CHEEE?"', 203, 203);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(203, 'Martini senza Polaroid', 'Mart:-"Che non ho piu'' le perle al collo, io lo giuro su Chiffon e Bijoux, io non lo so dove sono."
Martini continua a piangere e a singhiozzare, giura sui suoi cagnolini Chiffon e Bijoux come quando ti giuro'' nell''estate del diploma che non avrebbe permesso ad un ragazzo di frapporsi nella vostra amicizia.
Bijoux e Chiffon son morti entrambi e, con loro, anche quella promessa.

Non sai cosa pensare, se non che e'' al capolinea.

Mart:-"Penso che qualcuno mi abbia voluto giocare un brutto scherzo. Le perle di Nonna Paloma.
Io me lo sento, mi togliera'' dal testamento! La mia vita e'' finita, ma chi, chi puo'' essere stato?
Perche'' sicuro un ladro c''e''! Io onestamente sono sicura di una cosa sola: se mi fosse caduta per sbaglio e qualcuno l''avesse trovata, me l''avrebbe sicuramente riportata, ero uno schianto da paura con il vestito impreziosito da quella collier! Cosa faro''? La mia vita e'' rovinata!"

Sorridi al pensiero che Martini a 30 anni non abbia ancora perso dal suo dizionario la locuzione -SCHIANTO DA PAURA-
Ti chiedi se anche tu saresti stata in grado di autoriferirti in questo modo, credendoci ciecamente.

Mart:-"Sto provando a ricordare, ma davvero non ci riesco! Sono stata accolta da Gin all''ingresso, ricordo che mi ha messo il braccio attorno alle spalle e mi ha presentato due giovani giornalisti europei. Le ho chiesto se potessi usufruire della toilette, avevo necessita'' di incipriarmi il naso, ero arrossita davvero tanto, mi avevano dato della ventiduenne, capisci??"

Mart:-"Uscita dal bagno... Hai visto che bel pomello rosa???"

Mart:-"Ho trovato Margarita, ricordo di aver ricevuto un caloroso abbraccio, mi ha cinto le braccia attorno al collo, onestamente non me lo aspettavo, sai, ultimamente mi e'' parsa scontrosa piu'' del solito!"

Mart:-"Ad ogni modo sono ritornata in salotto, e da li'' ho raggiunto di nuovo i ragazzi, mi hanno davvero corteggiata! Ho bevuto con loro prima un Americano, un Negroni, forse un altro e un altro ancora."

Mart:-"Cavoli che bei ragazzi erano! Dovevi proprio vederli, ti sarebbero piaciuti! Hanno rovinato tutto quando sono usciti in terrazzo a fumare!"

Mart:-"Sai che odio quelle cose, potevano avere una notte con me ed hanno preferito rimanere al freddo e al gelo la notte del 31 Dicembre per una stupida sigaretta! Roba da matti dico io! Cosi'' mi sono allontanata ero furiosa, e forse era troppo tardi ed eccomi qui! Da sola in questo bagno, il mio stomaco non ha retto. Dopo essermi rinfrescata mi sono specchiata ma era troppo tardi:
il collier di nonna Paloma non era piu'' sul collo della sua nipotina preferita."',
'"Non trovi sospetto il fatto che Margarita si sia avvicinata cosi'' tanto a te? Potrebbe averti sfilato la collana senza che te ne accorgessi."',
'"Perche'' Gin avrebbe dovuto metterti il braccio attorno alle spalle? Pensavo che i rapporti tra di voi si fossero raffreddati."', 220, 240);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(220, 'Bad Ending: Incolpa Margarita',
'Martini sembra avere un sussulto, probabilmente non pensava che avresti puntato il dito contro qualcuno, figurarsi contro una delle sue migliori amiche. Il suo volto si fa improvvisamente serio. Pensi davvero sia stata la scelta migliore?
Mart:-"Tu...dici che sarebbe davvero in grado di fare una cosa del genere? E perche'' dovrebbe?"', '...?', 'perche''...', 221, 221);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(221, 'Bad Ending: Incolpa Margarita', 'Gin:-"Perche'' e'' una vigliacca, incapace di assumersi le responsabilita'' delle sue azioni. Forse e'' il caso che lo sappiate anche voi, dal momento che l''ho scoperto anch''io per caso stasera."

Gin:-"Margarita ha un volo per le Hawaii domani, ma perche'' le Hawaii poi, perche'' cosi'' lontana, non mi sorprenderebbe sapere che ha rubato la collana di Martini, infondo mi pare che la persona che abbiamo davanti sia ben diversa da quella che amavamo."

Gin dall''uscio della porta vi guarda sedute per terra. Ha gli occhi pieni di lacrime, il respiro strozzato e il volume alto della musica rende tutto ancora piu'' surreale.
Le parole di Gin inevitabilmente ti risuonano pungenti, aspre e dolorose. Entra nella stanza per poi stendersi nella vasca da bagno.

Mart:-"E quindi e'' cosi'', ho sempre sospettato non si sentisse al nostro livello. Sicuramente saranno state le sue umili origini, il suo lavoro manuale, si sporca tutti i giorni le mani, non puo'' neanche farsi il semipermanente alle unghie capisci!?"

Mart:-"Credo dunque al fatto che fosse invidiosa, di noi e delle nostre vite. A pensarci e'' davvero imbarazzante, mi fa pena, se la tenesse pure la collana di nonna Paloma, ormai e'' stata macchiata di odio!"

Gin:-"Io invece no, non me lo sarei mai aspettato da lei, dico davvero. Ma adesso tutti i nodi stanno venendo al pettine, Margarita non e'' quella che pensavamo di conoscere."

Gin:-"Ve lo dico io cos''e'' successo, si e'' approfittata di noi finche'' ha potuto, ci ha fatto credere... si'', ecco, in un futuro insieme."

Vedi un''ombra dietro la porta.

Marg:-"macchiata di odio"?...un futuro insieme?"

Marg:-"Penso di aver sentito abbastanza. Se pensate che io abbia quello stupido collier di perle, non mi conoscete neanche un po''."

Marg:-"Che tristezza mi fate, anche tu Wine, che te ne stai zitta ad annuire a tutto quello che ti vien detto. Patetica."

Margarita va via, sentite la musica fermarsi e il suono di decine di calici frantumarsi in mille pezzi. Il vociare delle persone si amplifica,
eppure viene subito spezzato dallo sbattere della porta d''ingresso: Margarita e'' andata via. Sara'' stata davvero la scelta giusta? Avevano davvero
fatto andare via Margarita con la collana? Potevano delle perle distruggere un''amicizia basata sui segreti e i silenzi? A quanto pare si'', e questo
e'' stato il tuo percorso Wine, spero tu sia contenta adesso. Raccogli cio'' che semini."', 'FIN', 'FIN', 0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(240, 'Sad Ending: Incolpa Gin', 'Martini sembra avere un sussulto, probabilmente non pensava che avresti puntato il dito contro qualcuno, figurarsi contro una delle sue migliori amiche. Il suo volto si fa improvvisamente serio. Pensi davvero sia stata la scelta migliore?
Mart:-"Tu...dici che sarebbe davvero in grado di fare una cosa del genere? E perché dovrebbe?"', '"...?"', '"perche''..."', 241, 241);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(241, 'Sad Ending: Incolpa Gin', 'Marg:-"Mi pare ovvio! Gin e'' diventata un''altra persona negli ultimi mesi! Ostenta una vita godendosi l''apparenza. Non e'' nient''altro che circondata da falsita'', non mi stupirei nel pensare che possa aver fatto una cosa del genere, figurarsi poi, ad una delle sue amiche piu'' care!"

Margarita dall''uscio della porta vi guarda sedute per terra. Ha gli occhi pieni di lacrime, il respiro strozzato e il volume alto della musica rende tutto ancora piu'' surreale. Le parole di Margarita ti risuonano pungenti, aspre e dolorose. Entra nella stanza per poi stendersi nella vasca da bagno.

Mart:-"E quindi e'' cosi''. Non vi nego il fatto che da un po'' inizio a sospettare della sua lealta''. Sicuramente sara'' stata l''invidia: ha sempre desiderato una vita pettinata e ricche di serate di gala, come la mia capite???"

Mart:-"Credo dunque al fatto che fosse in cerca del suo momento di gloria come prima donna. Ma poi, che donna?? Cosa le ha fatto nonna Paloma??"

Mart:-"A pensarci e'' davvero imbarazzante, mi fa pena, se le tenesse pure quelle perle, ormai sono state macchiate di imbarazzo!"

Marg:-"Io invece no, non me lo sarei mai aspettato da lei, dico davvero. Ma adesso tutti i nodi stanno venendo al pettine, Gin non e'' quella che pensavamo di conoscere.
Ve lo dico io cos''e'' successo, si e'' approfittata di noi finché ha potuto, ci ha fatto credere... si'', ecco, in un futuro insieme."
Vedi un''ombra dietro la porta.

Gin:-"macchiata di imbarazzo?...un futuro insieme?"

Gin:-"Io organizzo una festa galattica nel mio nuovo loft, morivo dalla voglia di condividere con voi nell''ultima notte del millennio un''emozione per me cosi'' grande, per poi sentirmi puntare il dito contro a causa di una stupida collana?! Penso di aver sentito abbastanza."

Gin:-"Quelle imbarazzanti qui siete voi! Sono giorni che Wine piange per non aver avuto la possibilita'' di indossarla eppure i vostri sospetti sono contro di me?! Patetiche. Uscite immediatamente da casa mia, la festa e'' finita e devo svegliarmi immediatamente da questo incubo."

Uscite dal bagno frettolosamente dirigendovi in salotto: l''appartamento e'' vuoto. Le uniche persone rimaste siete tu, Margarita e Martini, i due giovani giornalisti. Non vedete Gin ma non sembra essere un problema. Uscite tutti e cinque dall''ingresso.
I due ragazzi vi dicono che Gin aveva alzato troppo la voce e l''avevano sentita tutti gli ospiti vicini a lei. Poi si sa, le storie girano veloci soprattutto in tempi cosi'' brevi. Tutti si erano fatti un''idea e volevano dissociarsi dalle azioni di Gin.

Davvero hai preferito chiudere alle tue spalle la storia della tuo legame con Gin per quella collana? Possono delle perle distruggere un''amicizia basata su invidie e gelosie?
A quanto pare si'', e questo e'' stato il tuo percorso Wine, spero tu sia contenta adesso. Raccogli cio'' che semini.', 'FIN', 'FIN', 0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(260, 'Martini con Polaroid', 'Decidi di sederti a terra, abbastanza vicino da poter sentire le vostre braccia sfiorarsi.',
'"Perche'' ci disperiamo qui in bagno?"', '"Che succede Martini? Ti fa male qualcosa?"', 261, 261);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(261, 'Martini con Polaroid', 'Mart:-"Lasciamo stare Wine, sembra impossibile sopravvivere a questa serata."',
'"Perche'', cosa sta succedendo???"', '"A chi lo dici, vorrei che tutto questo finisse il prima possibile."', 262, 262);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(262, 'Martini con Polaroid', 'Mart:-"Io te lo giuro, ti prego di aiutarmi, non riesco a ricordare con nitidezza, so solo che..."', 'Che?', 'kHeE?!?!', 263, 263);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(263, 'Martini con Polaroid', 'Mart:-"Che non ho piu'' le perle al collo, io lo giuro su Chiffon e Bijoux, io non lo so dove sono."
Martini continua a piangere e a singhiozzare, giura sui suoi cagnolini Chiffon e Bijoux come quando ti giuro'' nell''estate del diploma che non avrebbe permesso ad un ragazzo di frapporsi nella vostra amicizia.
Bijoux e Chiffon son morti entrambi e, con loro, anche quella promessa.

Non sai cosa pensare, se non che e'' al capolinea.

Mart:-"Penso che qualcuno mi abbia voluto giocare un brutto scherzo. Le perle di Nonna Paloma.
Io me lo sento, mi togliera'' dal testamento! La mia vita e'' finita, ma chi, chi, puo'' essere stato?
Perche'' sicuro un ladro c''e''! Io onestamente sono sicura di una cosa sola: se mi fosse caduta per sbaglio e qualcuno l''avesse trovata, me l''avrebbe sicuramente riportata, ero uno schianto da paura con il vestito impreziosito da quella collier! Cosa faro''? La mia vita e'' rovinata!"

Sorridi al pensiero che Martini a 30 anni non abbia ancora perso dal suo dizionario la locuzione -SCHIANTO DA PAURA-
Ti chiedi se anche tu saresti stata in grado di autoriferirti in questo modo, credendoci ciecamente.

Mart:-"Sto provando a ricordare, ma davvero non ci riesco! Sono stata accolta da Gin all''ingresso, ricordo che mi ha messo il braccio attorno alle spalle e mi ha presentato due giovani giornalisti europei. Le ho chiesto se potessi usufruire della toilette, avevo necessita'' di incipriarmi il naso, ero arrossita davvero tanto, mi avevano dato della ventiduenne, capisci??"

Mart:-"Uscita dal bagno... Hai visto che bel pomello rosa???"

Mart:-"Ho trovato Margarita, ricordo di aver ricevuto un caloroso abbraccio, mi ha cinto le braccia attorno al collo, onestamente non me lo aspettavo, sai, ultimamente mi e'' parsa scontrosa piu'' del solito!"

Mart:-"Ad ogni modo sono ritornata in salotto, e da li'' ho raggiunto di nuovo i ragazzi, mi hanno davvero corteggiata! Ho bevuto con loro prima un Americano, un Negroni, forse un altro e un altro ancora."

Mart:-"Cavoli che bei ragazzi erano! Dovevi proprio vederli, ti sarebbero piaciuti! Hanno rovinato tutto quando sono usciti in terrazzo a fumare!"

Mart:-"Sai che odio quelle cose, potevano avere una notte con me ed hanno preferito rimanere al freddo e al gelo la notte del 31 Dicembre per una stupida sigaretta! Roba da matti dico io! Cosi'' mi sono allontanata ero furiosa, e forse era troppo tardi ed eccomi qui! Da sola in questo bagno, il mio stomaco non ha retto. Dopo essermi rinfrescata mi sono specchiata ma era troppo tardi:
il collier di nonna Paloma non era piu'' sul collo della sua nipotina preferita."',
'"Scusami, e'' veramente troppo per me, non ce la faccio piu''"',
'Mostra la Polaroid', 280, 300);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(280, 'O''VER? ENDING', 'Un altro impiccio che non stavi assolutamente cercando. Esci dal bagno incurante dei singhiozzi di Martini, non hai bisogno dell''ennesimo dramma adolescenziale, o cosi'' pensi. Raccogli le tue cose e decidi che e'' tempo che questa notte di falsita'' continui nei suoi festeggiamenti senza di te.
In fondo sta a noi scegliere le persone di cui circondarci. Non eri piu'' entusiasta della loro compagnia gia'' da un po''.
Hai davvero preferito chiudere alle tue spalle la storia del tuo legame con Martini, Gin e Margarita per quella collana?

Possono delle perle distruggere un''amicizia basata su superficialita'' e ostentazione?
A quanto pare si'', e questo e'' stato il tuo percorso Wine, spero tu sia contenta adesso. Raccogli cio'' che semini.', 'FIN', 'FIN', 0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(300, 'Good Ending', 'Wine:-"Ti ricordi di noi? Di questa foto?"

Martini tira su con il naso, si asciuga le lacrime con un tovagliolo rosso preso dal tavolo della cucina.

Mart:-"Dove l''hai trovata??? Ma tu guarda che capelli avevo! E come eravamo piccole, avremmo fatto l''impossibile l''una per l''altra."

Vedi un''ombra dietro la porta.

Gin:-"E ora tutto questo non vale piu''?"

Martini stringe forte l''istantanea che hai staccato dal frigorifero. Gin entra nella stanza per poi stendersi nella vasca da bagno.

Marg:-"Io farei ancora tutto per voi. Pensavo di avervi perse. Il volo e'' pronto, le valigie anche. Ve l''ho nascosto e vi chiedo scusa, ero pronta a lasciarmi tutto alle spalle. Guardarvi qui ora insieme, mi ha riportato con i piedi per terra. Siete voi la mia casa."

Non sai piu cosa pensare, ora che anche Margarita aveva fatto capolino dalla porta, entrando e sedendosi sul lavandino, tutto aveva assunto un''aria cosi famigliare da aver risvegliato quella certezza dormiente di un''amicizia fondata sul bene e sull''amore reciproco nonostante tutto e tutti.

Prendi la lettera dalla borsetta e la strappi.

Wine:-"Ci sarebbero cosi'' tante cose da dire, ma l''unica cosa a cui riesco a pensare e'' che adesso siamo qui."

Mart:-"Ben detto! Nonna Paloma mi perdonera'' in fondo! Sono pur sempre la sua nipotina preferita???"

Marg:-"E anche l''unica, potrebbe anche decidere di intestare tutto al suo gatto!"

Gin:-"Sei senza cuore Marg, non cambiare mai."

Una risata piena di commozione riempie la stanza, vi abbracciate, e'' il nuovo millennio, e altre duemila storie racconterete insieme
Chissa'' cosa sarebbe successo se avessi parlato alle ragazze della lettera.
Chissa'' se ancora avresti di cui essere cosi'' grata.',
'FIN', 'FIN', 0, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(320, 'Gin std', 'Gin ti accoglie nella conversazione con un ampio sorriso.

Gin:-"Come siamo belle questa sera! Ti dona davvero questo outfit, quel tubino bianco pero''..."',
'"E invece ho messo il tailleur, torno a casa a cambiarmi??"', '"Lo so, ma ci saranno altre occasioni in fondo."', 321, 322);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(321, 'Gin std', 'Gin:-"Mi sembra un commento un po'' scortese soprattutto davanti ai miei ospiti, anzi, lascia che te li presenti, sono Will e Mike, due giovani giornalisti direttamente dalla Gran Bretagna."',
'"Lieta di conoscervi, come mai qui stasera?"', '"Buona serata allora."', 323, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(322, 'Gin std', 'Gin:-"Assolutamente si'', non valeva davvero la pena continuare con quella tiritera della settimana scorsa per quella collana del cavolo di Nonna Paloma, stava diventando davvero una bambinata."

Gin:-"Sono contenta che sia tutto finito ora. Lascia che ti presenti due dei miei ospiti, Will e Mike, due giovani giornalisti direttamente dalla Gran Bretagna"',
'"Lieta di conoscervi, come mai qui stasera?"', '"Lieta di fare la vostra conoscenza, ci si vede per la casa!"', 323, 0);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(323, 'Gin std', 'I ragazzi ti raccontano che scrivono per una rivista settimanale e che sono inviati negli Stati Uniti da due mesi. Scrivono degli usi e costumi degli americani e di come il capitalismo e l''individualismo stiano disgregando la societa'' verso un punto di non ritorno.
Non ti interessa piu'' di tanto, non inizierai ora ad intavolare un dialogo sui massimi sistemi. Gin ti dice che li ha conosciuti l''altro ieri, chissa'' che non siano qui solo per ficcanasare.

Saluti i tre e ti allontani, ritornando verso il centro dell''ingresso.', NULL, NULL, 0, 0);


INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(340, 'Gin per chiave', 'Vedi Gin intenta a salutare delle persone sulla porta d''ingresso. La fermi un attimo per parlare.

Gin:-"Dimmi tutto, posso esserti d''aiuto?"', '"Avrei bisogno della chiave del bagno...la natura chiama."', '"La porta del bagno e'' chiusa a chiave, se avessi un passpourtout mi aiuteresti tanto."', 341, 341);

INSERT INTO NinDialogueTable(id, title, text, choice1, choice2, user_choice1, user_choice2) VALUES
(341, 'Gin per chiave', 'Gin ti porge la chiave del bagno un po'' confusa.

Gin:-"Spero proprio non stiano facendo niente di lurido in quel bagno, bleah. Ci vediamo dopo."',
'"A dopo!"', '"Ti ringrazio, buona continuazione!"', 0, 0);
