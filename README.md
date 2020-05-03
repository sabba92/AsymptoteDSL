# AsymptoteDSL
## Un DSL per creare immagini vettoriali tramite Asymptote

_Domain-specific language_ (DSL) in linguaggio Scala che consente la produzione di immagini vettoriali utilizzando Asymptote, ponendo particolare attenzione alla creazione di figure geometriche e diagrammi, come ad esempio reti di Petri e diagrammi UML.
Il codice produce in _output_ una rappresentazione dell’immagine desiderata, in diversi formati a scelta dell’utente, tramite la sola esecuzione del codice Scala.

La _directory_ `src` contiene:
- una _subdirectory_ `main` con il codice sorgente implementato
    - organizzata in sottocartelle in modo da suddivedere le interfacce (`traits`), le classi semplici (`atoms`) e quelle complesse (`complex`)
- una _subdirectory_ `test` con i relativi _tests_ sviluppati
    - organizzata come `main` e contenente una classe di _test_ per ogni classe sviluppata

Il progetto contiene oltre 60 _tests_ relativi ai diversi metodi delle classi implementate e oltre 20 esempi di immagini create tramite il DSL. Gli esempi sono contenuti in `test\scala\examples` e sono presenti sia i _files_ Asymptote (sottocartella `files`) che le immagini in formato PDF (sottocartella `images`) ottenute da essi. Tutti questi _files_ sono prodotti dalle classi presenti nella _directory_ `examples`; è consigliabile eseguire il codice di tali classi assieme alle altre classi di _test_, in modo da controllarne l'esito e ottenere contestualmente tutte le immagini di esempio.
