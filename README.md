# u4d15p

i diagrammi si trovano in:
./diagrams

Considerazioni sulla struttura del database

Prima di tutto analizziamo la triade pubblicazioni(superclasse) | libri | riviste:

• In questo caso escludiamo l'ereditarietà table per class, in quanto, dati i metodi richiesti, dobbiamo fare un numero
importante di interrogazioni a livello di pubblicazione.
• La strategia single table potrebbe essere utilizzata, in quanto il numero di attributi di differenza fra le due
sottoclassi è ridotto. Tuttavia la maggior velocità di questo sistema limita i controlli di validazione lato database su
quanto inserito. Considerando la natura di un catalogo bibliografico ci si aspetta che la coerenza dei dati sia
prioritaria rispetto alla velocità di estrazione.
• La strategia joined ci permette di garantire, anche lato database, che ogni libro abbia un autore e un genere e che
ogni rivista abbia una periodicità. Essendo molto rilevante nella catalogazione la correttezza dei dati si propende per
questo modello.
• Se questo esercizio venisse svolto per finalità professionali la considerazione che farei è che il libro può avere
molti autori e un autore può scrivere molti libri, allo stesso modo un libro può avere molti generi e un genere ha molti
libri. Pertanto modellerei le relazioni molti a molti (come indicato nel diagramma alternativo allegato in
diagrams/versione_alternativa_ vedi_README ). Tuttavia
considerato l’esercizio assegnato, per fedeltà alla consegna si procede a inserire i dati di un solo libro e un solo
genere direttamente nella sottoclasse.

Per quanto riguarda il prestito:

• Il prestito contiene un solo elemento, un elemento nel tempo può essere prestato molte volte.
• Un utente nel tempo può effettuare molti prestiti, ma il singolo prestito riguarda un solo utente.
