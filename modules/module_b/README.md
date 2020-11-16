## Gra we wzroce... tzn. w statki!

Mam nadzieję, że znasz grę w statki i zdażyło Ci się w nią nie raz zagrać. Gdyby jednak było inaczej lub ją zapomniałeś/aś, to poniżej zapisałem jej zasady.

1. W statki gra dwóch graczy. Każdy z nich ma swoją planszę do gry (o wymiarach 10 na 10). 
1. Na planszy gracz rozstawia statki. Każdy z graczy ma do dyspozycji 7 statków, zgodnie z poniższą listą:
   - 1 lotniskowiec (zajmuje 5 pól),
   - 1 statek wojenny (zajmuje 4 pola),
   - 1 krążownik (zajmuje 3 pola),
   - 2 niszczyciele (każdy zajmuje 2 pola),
   - 2 łódzie podwodne (każda zajmuje 1 pole).
   
1. W trakcie rozgrywki gracze na zmianę podają pole, w które chcą strzelić. Jeżeli przeciwny gracz ma tam statek to oznacza go jako trafiony.
1. Jeżeli statek został trafiony we wszystkie swoje pola, to jest zatopiony. 
1. Wygrywa ten gracz, który pierwszy zatopi wszystkie statki przeciwnika. Jeżeli w tej samej rundzie obaj gracze zatopią ostatni statek przeciwnika, to gra kończy się remisem.

Więcej informacji na temat gry można znaleźć [tutaj](https://pl.wikipedia.org/wiki/Okr%C4%99ty) albo [tutaj](https://en.wikipedia.org/wiki/Battleship_(game)), a [tutaj](https://upload.wikimedia.org/wikipedia/commons/e/e4/Battleships_Paper_Game.svg) jest dobra wizualizacja plansz do gry.

Zadania w tym module pozwolą Ci zaimplementować grę w statki, w wersji na konsolę. W trakcie tej implementacji będziemy wprowadzać kolejne wzorce projektowe, które nieco utrudnią nasze zadanie (ale czy nie o to chodzi?). Korzyści z ich wprowadzenia będziemy zbierać w przyszłości.

Jeżeli rozumiesz zasady gry w statki i jesteś gotowy/a podjąć wyzwanie, to do dzieła!

---

### 2.1. Klasy biorące udział w grzę

Na rozgrzewkę zapoznaj się z klasami, które biorą udział w grze w statki. Co ważne - kod gry nie jest jeszcze kompletny!

1. Zacznij od klasy `battleships.BattleshipsApp`. Jest to główna klasa aplikacji, którą należy uruchomić, aby rozpocząć rozgrywkę.
1. Następnie zapoznaj się z klasą `GameEngine` w pakiecie `battleships.game`. Jest to klasa silnika gry. Przedstawia ona logikę przebiegu gry.
1. Przejdź do klasy `Player`, czyli reprezentacji naszego gracza. Po analizie klasy `GameEngine` powinno być już jasne, że klasa ta posiada kilka kluczowych metod. Klasa `Player` jest dość ciekawa, bo faktyczną robotę przekazuje innej klasie - `PlayerLogic` (dokładniej to `PlayerLogic` jest interfejsem).
1. Teraz czas na klasę `Board`, reprezentująca planszę do gry, oraz klasę `Field`, reprezentująca pojedyncze pole tej planszy.
1. Na koniec statki - wszystko ogranicza się do pojedynczej klasy `Ship`.
1. Przegląd aplikacji masz już za sobą!

---

### 2.2. Identyfikacja pierwszych wzorców

1. Na podstawie wiedzy o wzorcach przyjrzyj się raz jeszcze całej aplikacji i spróbuj w niej zidentyfikować wzorce projektowe, które się pojawiły.
   > W ramach małej podpowiedzi: jedyne dwie klasy, które mają szanse być elementem jakiegoś wzorca to `GameEngine` oraz `Player` razem z interfejsem `PlayerLogic`.
   
1. Do odpowiednich klas dodaj komentarz w pierwszej linijce ich kodu z wyjaśnieniem jaki wzorzec występuje w tej klasie. Zapisz również swoje uzasadnienie dlaczego tak uważasz.

---

### 2.3. Tworzenie statków: Factory Method

Wprowadzanie wzorców zaczniemy od potrzeby sprawnego tworzenia statków. Oczywiście najpierw tą potrzebę należy sobie uświadomić...

1. Utwórz klasę `SimpleLogic` w pakiecie `battleships.players`. Klasa ta będzie reprezentować prostą logikę gracza i implementować interfejs `PlayerLogic`.
1. Dla wszystkich wymaganych metod dostarcz najprostsze implementacje - mogą zwracać jakieś wartości domyślne albo np. `null` (podobnie jak w klasie `StubPlayerLogic`). 

[Rozwiązanie](resolutions/2.1.1.md)

W dalszej części zadania skupimy się tylko na metodzie `prepareBoard`, która powinna rozmieścić statki na planszy.

1. W metodzie `prepareBoard` utwórz 3 dowolne statki. Pamiętaj, że każdy typ statku ma swoją nazwę (_dostępne w opisie sekcji_) oraz z góry ustalony rozmiar.

Powstały 3 statki, a już widać kilka problemów. W tym zadaniu zajmiemy się tylko dwoma, tzn.:
- tworzenie statków jest pracochłonne,
- można popełnić błąd tworząc statek o złym rozmiarze lub o złej nazwie.
   
1. W celu eliminacji tych problemów stwórz klasę `ShipsFactory` w pakiecie `ships`.
1. W klasie `ShipsFactory` utwórz 5 metod typu `public static` o nazwach:
   - carrier (_do tworzenia lotniskowców_),
   - warship (_do tworzenia statków wojennych_),
   - cruiser (_do tworzenia krążowników_),
   - destroyer (_do tworzenia niszczycieli_),
   - submarine (_do tworzenia łodzi podwodnych_),
   
1. Metody nie powinny przyjmować żadnych parametrów oraz powinny zwracać obiekt klasy `Ship`, który reprezentuje typ statku zgodny z nazwą metody.
1. Wróć do klasy `SimpleLogic`, usuń ręczne tworzenie statków i wszystkie statki stwórz z wykorzystaniem klasy `ShipsFactory`.

[Rozwiązanie](resolutions/2.1.2.md)

Oba wcześniej wskazane problemy zostały wyeliminowane, a w Twoim kodzie pojawił się wzorzec Factory Method.

---

### 2.4. Układanie statków na planszy: Builder

Mamy już możliwość tworzenia statków teraz pozostaje kwestia ich ułożenia. Ponownie zaczniemy od tego, aby zmusić się do narzekania.

W klasie `Board` do dyspozycji mamy pojedynczą metodę do ustawienia statku: `setShip(Ship, char, int)`. Metoda ta wymaga abyśmy podali obiekt klasy `Ship` oraz identyfikator wiersza (np. `A`) oraz kolumny (np. `3`). Wywołanie `board.setShip(someShip, 'B', 3)` będzie oznaczać umieszczenie statku ze zmiennej `someShip` na polu `B3`. Jeżeli statek ma rozmiar `1`, to to wystarczy, ale jeżeli jest większy (np. krążownik o 3 polach), to trzeba go umieścić na kolejnych polach. Sprawdźmy czy to rozumiesz :)

1. W metodzie `prepareBoard` klasy `SimpleLogic` umieść 3 dowolne statki na planszy z wykorzystaniem metody `setShip(Ship, char, int)`. 

   > Jako dowolne wybierz jeden statek o rozmiarze 1, jeden statek o rozmiarze 2 i jeden statek o rozmiarze 3. Pamiętaj, że statki stworzyłeś w poprzednim punkcie.
   
1. Jeżeli nie wybrałeś/aż lotniskowca w poprzednim punkcie, to zrób to teraz i umieść go na planszy ;)

[Rozwiązanie](resolutions/2.2.1.md)

Pojawiło się przynajmniej kilka problemów:
- ręczne umieszczanie statków jest pracochłonne,
- łatwo się pomylić i źle rozmieścić statek (np. po skosie: `A1` + `B2` +`C3`),
- nie ma kontroli nad tym jakie statki są ile razy umieszczane.

Wyeliminujemy wszystkie z tych problemów tworząc klasę `BoardBuilder` w pakiecie `game`. Tylko przygotuj się na długą drogę - proces układania statków na planszy jest jednym z najtrudniejszych do zaimplementowania (żmudnych) elementów tej aplikacji.

1. Utwórz klasę `BoardBuilder` w pakiecie `game`.
1. Utwórz w klasie `BoardBuilder` pojedyncze pole `private Board board`, które będzie reprezentowało tworzoną planszę do gry.
1. W konstruktorze klasy `BoardBuilder` zainicjalizuj pole `board` nowym obiektem klasy `Board`.
1. Utwórz metodę `public Board build()`. Metoda powinna zwracać pole `board`.

[Rozwiązanie](resolutions/2.2.2.md)

Powstał już szkielet budowniczego. Twoja dalsza implementacja powinna kontrolować dwa elementy, które nie były wcześniej kontrolowane: właściwe umieszczenie statku na sąsiadujących polach oraz poprawną ilość użytych statków. Można to
osiągnąć naprawdę wieloma sposobami. Poniżej jest pewna propozycja, ale jeżeli chcesz to zrobić po swojemu, to droga wolna.

Poniżej są konkretne punkty opisujące naszą metodę, ale ogólny scenariusz może być tak:
- sprawdź czy dany statek jest jeszcze dostępny do umieszczenia na planszy,
- przygotuj zbiór pól, które statek zajmie,
- sprawdź czy wszystkie pola ze zbioru są wolne,
- zajmij pola,
- przygotuj zbiór wszystkich pól, które są zajęte przez statek (jego pola i każde sąsiadujące) i usuń je ze zbioru ogólnie dostępnych pól dla kolejnych statków.

1. Utwórz metodę `public BoardBuilder destroyer(char row, int col, boolean vertical)`. Metoda ta powinna wykorzystać klasę `ShipsFactory` do utworzenia statku typu Niszczyciel i umieszczać ten statek na polu o współrzędnych `row` i `col`. Następnie na podstawie informacji czy statek ma być położony pionowo (`vertical == true`) czy poziomo (`vertical == false`) powinna ustawiać statek na kolejnym polu.
1. Wcześniej utworzoną metodę rozwiń też o sprawdzenie czy nie została zużyta już
maksymalna ilość statków typu Niszczyciel oraz czy pola, na których ten statek ma być umieszczony są wolne i czy nie sąsiadują bezpośrednio z innym statkiem. 

   > Te informacje możesz za każdym razem próbować wyliczyć przeglądając wszystkie pola planszy (`board.getFields` i jazda...) lub dostarczyć w klasie `BoardBuilder` pola pomocnicze np. tablicę śledzącą ilość użyć każdego statku oraz zbiór (np. `HashSet') pól, które są dostępne do użycia.
   
1. Aby metoda `destroyer` była wygodna w użyciu, to na samym jej końcu skorzystaj z możliwości języka Java i zwróć obiekt samoreferencji (`return this`). W ten sposób będziemy mogli łączyć kolejne wywołania metod obiektu `BoardBuilder` w jeden łańcuch wywołań.
1. Metoda `destroyer` powinna również rzucać wyjątki w sytuacji gdy przekroczymy limit dostępnych Niszczycieli lub statek ma być położony w niewłaściwym miejscu. Najlepiej użyc `IllegalArgumentException` z odpowiednią informacją.

[Rozwiązanie](resolutions/2.2.3.md)

1. Na podstawie metody `destroyer` dostarcz analogiczne metody `carrier`, `cruiser`, `warship` oraz `submarine`.
1. W metodzie `build` dodaj kod, który zweryfikuje czy na planszy ustawiono wszystkie statki zgodnie z scenariuszem gry. Zwróć uwagę, że nie musisz sprawdzać, czy każdy statek jest ustawiony poprawnie, bo to sprawdzenie odbywało się na bieżąco przy dodawaniu statków. Jeżeli nie ustawiono wszystkich statków, to metoda powinna zwrócić wyjątek `IllegalStateException`, a gdy ustawiono, to zwrócić utworzoną planszę.

[Rozwiązanie](resolutions/2.2.4.md)

1. Mając pełną implementację budowniczego wykorzystaj go do utworzenia planszy gracza i tym samym zakończenia implementacji metody `prepareBoard` w klasie `SimpleLogic`. 

   > Jedna rzecz, która nie może nam umknąć: utworzony obiekt klasy `Board` powinniśmy zapisać w polu klasy `SimpleLogic`, będzie nam potrzebny w kolejnych metodach.
   
[Rozwiązanie](resolutions/2.2.5.md)

Pełny kod klasy [`BoardBuilder`](resolutions/2.2.6.md)
   
Wszystkie wskazane problemy zostały wyeliminowane, a w Twoim kodzie pojawił się wzorzec `Builder`. W tym przypadku implementacja tego wzorca nie była łatwa. Możesz się spotkać z prostszymi implementacjami ale też wielokrotnie bardziej skomplikowanymi.

---

### 2.5. Strzelanie

Dokończymy teraz naszą implementację `SimpleLogic`. Pokaże nam to możliwość wprowadzenia kolejnego wzorca projektowego

1. W klasie `SimpleLogic` uzupelnij metodę `salvo`. Możesz zaimplementować jedną z dwóch opcji:
   - strzelanie na oślep, a więc losowa wartość kolumny + losowa wartość wiersza (_oczywiście poprawne wartości_),
   - jak wyżej, ale bez strzelania dwa razy w to samo miejsce (zapamiętujemy strzały, aby ich nie powtarzać).
   
[Rozwiązanie](resolutions/2.3.1.md)

Mając już implementację spójrzmy na obiekt klasy `Field`, którego używamy w metodzie `salvo` oraz obiekt klasy `Field`, którego używamy przy budowaniu planszy (metoda `prepareBoard`). W drugim przypadku obiekt ten jest trwałą informacją o polu, na którym może być statek. Taki obiekt ma jakąś wartość i faktycznie coś reprezentuje. Jest nam potrzebny po jednym obiekcie do reprezentowania każdego pola. 

Jednak w metodzie `salvo` obiekt typu `Field` odgrywa tylko rolę nośnika informacji o kolumnie i wierszu. Jeżeli przyjęliśmy najprostszą implementację metody `salvo` (strzelanie na oślep), to takich nic nie znaczących obiektów możemy stworzyć w trakcie gry nieskończoną ilość. W tej bardziej skomplikowanej
implementacji (zapamiętywanie strzałów): do 100 obiektów (_dla planszy 10 x 10_). W dalszych krokach zadbamy aby nie marnotrawić tak pamięci.

1. Zacznij od stworzenia klasy `ShootingField` w pakiecie `battleships.game`. Niech klasa `ShootingField` rozszerza klasę `Field`.
1. W klasie `ShootingField` umieść dwa pola: `private char xRow` oraz `private int xCol`.
1. Stwórz konstruktor `public ShootingField(char, int)`, w którym podane parametry przekażesz do konstruktor nadklasy (`super`) oraz zainicjalizujesz nimi pola `xCol` oraz `xRow`.
1. Teraz napisz metody typu `set` dla pól `xCol` i `xRow`, ale niech się nazywają `setCol` i `setRow`.
1. Nadpisz metody `getCol` i `getRow` z nadklasy (z klasy `Field`), tak aby zwracały wartości pól `xCol` i `xRow`.

[Rozwiązanie](resolutions/2.3.2.md)

1. W klasie `SimpleLogic` stwórz pojedyncze pole `private ShootingField salvoTarget`. Przypisz do niego od razu obiekt np. z argumentami `'A'` oraz `1`.
1. Wróć do metody `salvo` - zamiast tworzyć nowe obiekty klasy `Field` o wylosowanych współrzędnych, to modyfikuj obiekt `salvoTarget` ustawiając mu odpowiednio wartość pola `xCol` i `xRow`. 
1. W metodzie `salvo` zwracaj teraz obiekt `salvoTarget` zamiast tworzenia nowego obiektu typu `Field`.

[Rozwiązanie](resolutions/2.3.3.md)

Udało Ci się w dużym stopniu ograniczyć niepotrzebne zużycie pamięci i procesora na tworzenie obiektów `Field`. Nasz obiekt typu `ShootingField` powstaje raz dla każdego obiektu klasy `SimpleLogic`. Przy każdym oddanym strzale jest modyfikowany i zwracany w zmodyfikowanej wersji. Całość działa, bo klasa `ShootingField` rozszerza klasę `Field`, więc można się pod nią podszywać (polimorfizm). Oszukaliśmy też modyfikator `final` dla pól `col` i `row` w klasie `Field` nadpisując metody typu `get` tych pól. Jednocześnie w projekcie pojawił się wzorzec ... `Singleton`, a po troszku `Flyweight`.

---

### 2.6. Trafianie i oznaczanie

Pozostały dwie metody z klasy `SimpleLogic`, które wciąż nie działają - `callOut(Field)` oraz `use(ShootResult, Field)`. Pierwsza metoda ma udzielać informacji o wyniku oddanego strzału przez przeciwnika, a druga w jakiś sposób wykorzystywać tą informację.

1. Zacznij od uzupełnienia implementacji metody `callOut(Field)` w klasie `SimpleLogic`.
1. Na podstawie kolumny (`getCol()`) i wiersza (`getRow()`) z parametru `field` wybierz odpowiednie pole na planszy gracza i 
   - jeżeli odnalezione pole nie posiada statku, to wynikiem będzie `ShootResult.MISS`,
   - jeżeli odnalezione pole posiada statek, to:
     - jeżeli statek jest zniczony (metoda `isDestroied()`), to zwróć wynik `ShootResult.MISS`,
     - jeżeli statek nie jest zniszczony (metoda `isDestroied()`), to oznacz jego trafienie (metoda `hit()`),
     - jeżeli po trafieniu statek został zniszczony, to zwróć wynik `ShootResult.HIT_AND_SINK`,
     - jeżeli po trafieniu statek nie został zniszczony, to zwróć wynik `ShootResult.HIT`.
     
   > Pamiętaj, aby po trafieniu usunąć statek z pola :)
   
[Rozwiązanie](resolutions/2.4.1.md)

Metodę `callOut(Field)` możemy uznać za gotową. W naszej grze nie pozwalamy na oszukiwanie, więc implementacja ta mówi prawdę, tylko prawdę i całą prawdę o rezultacie strzelenia do gracza.

Metody `use(ShootResult, Field)` nie będziemy implementować. Skorzystamy z implementacji metody domyślnej w interfejsie `PlayerLogic`, która nie robi nic.

> A co w takiej metodzie mogło by się stać? Np. moglibyśmy utrzymywać dodatkową planszę do gry z oddanymi strzałami i ich rezultatami. Byłoby to bardzo wartościowe rozwinięcie, ale przecież implementujemy `SimpleLogic` ;)

---

### 2.7. Decydowanie o końcu gry

Ostatnim brakującym elementem, aby logika gry działała, jest uzupełnienie metody `hasMoreShips` w klasie `Player`. Dostarzając implementację wprowadzimy kolejny wzorzec.

W metodzie `hasMoreShips` klasy `Player` potrzebujemy dostarczyć implementację, która sprawdzi czy gracz posiada jeszcze jakieś pływające statki. Nie chcemy jednak wprowadzać kodu, który babrze w szczegółach klasy `Board`, a więc analizuje tablicę `fields`. Informację o pływających statkach powinniśmy dostać od samej klasy `Board`. Postępuj zatem zgodnie z kolejnymi punktami, aby taką informację dostarczyć implementując wzorzec `Iterator`.

1. Utwórz klasę `AliveShipsIterator` w pakiecie `battleships.game`.
1. Niech klasa implementuje interfejs `Iterator<Ship>` i tym samym będzie musiała dostarczyć implementację metod `boolean hasNext` oraz `Ship next()`. 

   > Na razie niech te metody zwracają cokolwiek. W kolejnych krokach uzupełnisz ich implementację.
   
[Rozwiązanie](resolutions/2.5.1.md)
   
1. Klasa `AliveShipsIteator` powinna posiadać pole `private final Board board`, które będzie reprezentować plansze, po której odbywa się iteracja. Dostarcz tym samym konstruktor, który umożliwi przekazanie obiektu `Board` i ustawienie wartości pola `board`.
1. Metoda `hasNext()` powinna przejrzeć obiekt planszy w celu sprawdzenia czy istnieje pływający statek.
1. Metoda `next()` powinna przejrzeć obiekt planszy w celu odnalezienia pływającego statku i zwrócić ten statek. Jeżeli statku nie znaleziono metoda powinna zgłosić wyjątek `NoSuchElementException`. Należy pamiętać, że kolejne wywołania metody `next()` muszą zwracać kolejne statki. W tym celu klasa `AliveShipsIterator` musi w jakiś sposób monitorować gdzie skończyła, np. przechowywać obiekt klasy `Field` będący polem pod którym znaleziono ostatni statek.

[Rozwiązanie](resolutions/2.5.2.md)

Iterator mamy już przygotowany, więc teraz pozostaje go udostępniać i wykorzystywać metodę `hasMoreShips`.

Utwórz w klasie `Board` metodę `Iterator<Ship> aliveShips()`. Metoda powinna stworzyć nowy obiekt klasy `AliveShipsIterator` oraz zwrócić go.
1. W metodzie `hasMoreShips` klasy `Player` skorzystajmy z metody `aliveShips` na polu `board`. Wystarczy, że w tej metodzie zwrócimy wynik wywołania metody `hasNext()` na obiekcie iteratora.

[Rozwiązanie](resolutions/2.5.3.md)

Zakończyliśmy decydowanie o grze! Jednocześnie wprowadziliśmy wzorzec Iterator'a, który pozwolił nam ukryć logikę odnajdywania pływających statków przed klasą `Player`. Również klasa `Board` pozostała dzięki temu czysta i reprezentuje po prostu idea planszy. Wzorzez Iteratora pozwala nam teraz również pomyśleć o innej planszy (może 3D?), a klasa `Player` pozostanie na taką zmianę niewrażliwa i wciąż będzie potrafiła odpowiedzieć na pytanie `hasMoreShips()`.

---

### 2.8. Prezentacja przebiegu gry

Pod względem logiki gry nasza implementacja jest już gotowa. Mamy graczy z ich logiką, mamy statki, mamy plansze. Naszą grę można już nawet uruchomić. Jednego czego brakuje to śledzenia przebiegu gry. Rozszerzymy zatem mechanizm logiki gry, aby powiadamiał o jej przebiegu. Przygotuj się na dość długą drogę, ale maksymalnie ... **REUSABLE**

Zacznij od uruchomienia gry takiej jaka jest. Gra powinna zakończyć się wyświetleniem wyniku. Niestety nie dowiemy się nic o przebiegu gry. Uruchom grę jeszcze kilka razy, aby zyskać motywację do realizacji tego punktu :)

1. Utwórz pakiet `transmission` w `battleships`. Kolejne klasy będziemy tworzyć w tym pakiecie.
   
Najpierw określimy sobie samo wydarzenie i jego typy.

1. Utwórz klasę `GameEvent`. Klasa powinna mieć trzy pola:
  - `private final EventType type` określające typ wydarzenia (enum `EventType` stworzymy za chwilę),
  - `private final Player sourcePlayer` określające gracza będącego _źródłem_ wydarzeń (będzie to gracz, który w danym zdarzeniu wykonał akcję, np. strzelił, trafił, spudłował, zatopił),
  - `private final Player tragetPlayer` określającego gracza będącego _celem_ wydarzeń ()będzie to gracz, który z punktu widzenia zdarzenia nie podejmował decyzji).
1. W klasie `GameEvent` utwórz publiczny typ wyliczeniowy o nazwie `EventType`. Określ w nim następujące wartości (wyliczenia): 
   - `GAME_STARTED`,
   - `PLAYER_SHOOT`,
   - `PLAYER_MISS`,
   - `PLAYER_HIT_A_SHIP`,
   - `PLAYER_SANK_A_SHIP`,
   - `PLAYER_WIN`,
   - `DRAW`.
   
1. W klasie `GameEvent` stwórz **prywatny** konstruktor bezargumentowy, który przyjmie parametry dla każdego pola i je ustawi.
1. W enumie `EventType` utwórz publiczną metodę o nazwie `event`, która przyjmie dwa parametry reprezentujące obiekty gracza będącego źródłem zdarzenia i gracza będącego celem zdarzenia. Metoda powinna stworzyć nowy obiekt klasy `GameEvent` z wykorzystaniem dostępnego konstruktora z trzema parametrami i zwrócić ten obiekt.
1. Na koniec dorzuć jeszcze gettery do wszystkich pól, ale bez setterów. W końcu nie chcemy zmienic wartości po tym jak event został już wygenerowany!

[Rozwiązanie](resolutions/2.6.1.md)

Mamy gotowy mechanizm wydarzeń. Kolejnym krokiem będzie utworzenie naszego nadawcy i odbiorców tych zdarzeń.

1. Utwórz interfejs `Spectator`. Interfejs powinien posiadać pojedynczą metodę `void spectate(GameEvent)`.
1. Utwórz klasę `Announcer`, będzie ona reprezentować naszego komentatora gry.
1. W klasie `Announcer` utwórz pojedyncze pole typu `Set<Spectator` o nazwie `spectators`. Możesz to pole od razu zainicjalizować wartością, np. korzystając z implementacji `LinkedHashSet`. Samo pole będzie reprezentowało zbiór widzów, których komentator będzie powiadamiał.
1. W klasie `Announcer` dopisz metody, które:
  - pozwolą dodać nowy obiekt `Spectator` do zbioru `spectators`,
  - usuną wskazany obiekt `Specatator` ze zbioru `spectators`.
  
1. W klasie `Announcer` napisz metodę `void announce(GameEvent event)`, która powiadomi wszystkich widzów o wydarzeniu.

[Rozwiązanie](resolutions/2.6.2.md)

Stworzyliśmy mechanizm komentatora. Pozostało teraz go wykorzystać w silniku gry.

1. W klasie `GameEngine` dodaj pole typu `Announcer` oraz metody `set/get` dla tego pola.
1. W odpowiednich fragmentach kodu klasy `GameEngine` dodaj tworzenie obiektów typu `GameEvent`. Wykorzystaj w tym celu metodę `of` z klasy `GameEvent`. Utworzone obiekty przekazuj do komentatora z wykorzystaniem jego metody `announce`.
1. W klasie `BattleshipApp` stwórz nowy obiekt klasy `Announcer` i przekaż go do silnika gry zanim rogrywka się rozpocznie.

[Rozwiązanie](resolutions/2.6.3.md)

Prawie gotowe: mamy event'y, mamy komentatora, mamy rozgłaszanie, brakuje tylko ... widzów.

1. Utwórz klasę `ConsoleSpectator` (cały czas w pakiecie `battleships.transmission`). Klasa powinna implementować interfejs `Spectator`.
1. Dostarcz implementację metody `spectate`, która powinna wyświetlać na standardowej konsoli informacje o przebiegu gry. Skorzystaj z konstrukcji `switch` i w zależności od typu zdarzenia wyświetlaj zróżnicowaną, atrakcyjną i niesamowicie wciągającą treść!

   > Na początek dostarcz tylko najważniejsze informacje. Możesz np. pokazywać jak zmienia się plansza graczy po trafieniach. W klasie `BattleshipApp` dostępna jest metoda, która wyświetla planszę, więc może Ci się to przydać.
   
[Rozwiązanie](resolutions/2.6.4.md)
   
1. W klasie `BattleshipApp` utwórz nowy obiekt klasy `ConsoleSpectator` i dodaj go do listy widzów obiektu `Announcer`.
1. Możesz usunąć z klasy `BattleshipApp` wyświetlanie informacji na konsoli, bo w końcu mamy za to odpowiedzialną klasę `ConsoleSpectator`. Metoda `printBoard` możesz też przenieść do klasy `ConsoleSpectator` - jest dłużej nie potrzebna w klasie `BattleshipsApp`.

[Rozwiązanie](resolutions/2.6.5.md)

Gotowe! Pozostaje tylko uruchomić grę i cieszyć się jej przebiegiem... o ile nadążymy za graczami ;) Nasza implementacja `SimpleLogic` chociaż nie jest doskonała, to **baaaardzo** szybko podejmuje decyzje. 

1. Dodaj do metody `salvo` w klasie `SimpleLogic` jakieś losowe wstrzymanie aplikacji, np. między 0,05 do 0,2 sekundy. Będzie to symulowała proces myślenia użytkownika. W końcu musi się chociaż chwilę zastanowić!
 
   > Skorzystaj z klasy `TimeUnit`!

[Rozwiązanie](resolutions/2.6.6.md)

Skończone! Droga była niełatwa, ale udało się wprowadzić nie jeden, a dwa wzorce. Nasza klasy `Announcer` oraz `Spectator` realizują wzorzec Observer. Z kolei klasa `GameEvent` jest przykładem wzorca Command. To potężne wzorce, które mogą bardzo ewoluować. Możemy rozserzać klasę `GameEvent` o nowe wydarzenia nie wpływając w żaden sposób na już napisany kod. Podobnie, możemy dynamicznie dodawać widzów i ich usuwać. Najważniejsze! Możemy dostarczać nowe implementacje interfejsu `Spectator`, które będą na różne sposoby _oglądać_ rozgrywkę. Może rysyjąc ją w oknach albo wyświetlając w przeglądarce? Ale to nie koniec! Przecież każdy kolejny widz nie przeczy poprzedniemu! Rozszerzenia są niemal nieograniczone... **bez wpływu na kod samej rozgrywki**.

### Gratuluję!

Ukończyłeś/aś trudne i długie zadanie realizacji gry w statki z wykorzystaniem wzorców projektowych. Samodzielna realizacja takiego projektu może nie być łatwa. Może nawet nie być na tym etapie osiągalna. Decydowanie o użyciu wzorców jest zadaniem projektowym, a nie programistycznym. Opiera się na wiedzy i doświadczeniu. Doświadczenie musisz gromadzić, ale sporą część wiedzy właśnie zdobyłeś/aś. Raz jeszcze gratuluję!

[Należy Ci się jeszcze bardziej jak poprzednio!]([Należy Ci się](https://www.youtube.com/watch?v=S0UvJZmGTsk))