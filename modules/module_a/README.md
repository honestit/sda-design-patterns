## Moduł 1. Poznanie wybranych wzorców GoF

Wzorce projektowe są trudnym zagadnieniem. Ich zrozumienie i dostrzeżenie możliwości stosowania pojawia się wraz z doświadczeniem. Doświadczenie to, jest doświadczeniem projektanta. Nie opiera się na umiejętności pisania kodu, a na umiejętności projektowania kodu. Cennym krokiem w zbliżeniu się do tego doświadczenia jest poznanie w jaki sposób wzorce projektowe mogą być zaimplementowane (wdrożone w projekt) i praktyczne przekonanie się o ich działaniu.

**Zapraszam Cię do wykonania zadań**

---

### 1.1. Wzorzec Builder

:star: :star:

:watch: 45 minut

1. Zapoznaj się z klasami `City` oraz `Country` w pakiecie `gof.builder`.
1. Przy pomocy dostępnych konstruktorów tych klas oraz dostępnych metod `set/get`, w klasie `BuilderApp` utwórz 3 różne państwa, z których każde posiada:
   - nazwę,
   - populacje,
   - stolicę (ta ma tylko nazwę),
   - 2 miasta, z który każde niech posiada:
     - nazwę, 
     - populacje, 
     - państwo, do którego należy.
     
   > Obiekty utwórz i wypełnij polami w dowolny sposób. Nie musisz uzupełniać wartości w zgodzie z zaproponowaną listą.
   
[Rozwiązanie](resolutions/1.1.1.md) :watch: 15 minut

1. Zapoznaj się z klasą `CityBuilder` oraz `CountryBuilder` w pakiecie `gof.builder.simple`. Zwróć uwagę na kilka elementów:
   - sposób tworzenia obiektów (konstruktory),
   - metody i ich nazewnictwo,
   - typu zwracane przez metody i wartości zwracane przez metody,
   - metodę `build`.
   
1. Wykorzystaj klasy `CityBuilder` oraz `CountryBuilder` do stworzenia nowego państwa w klasie `BuilderApp`. Ponownie Państwo posiada:
   - nazwę,
   - populację,
   - stolicę (ta ma tylko nazwę),
   - 2 miasta, z których każde niech posiada:
     - nazwę,
     - populację
     - państwo, do którego należy
     
1. Zastanów się i opisz różnicę miedzy tworzeniem obiektów w pierwszy sposób oraz z wykorzystaniem podstawowych implementacji wzorca `Builder`. Różnice opisz w formie komentarza w klasie `BuilderApp`.

[Rozwiązanie](resolutions/1.1.2.md) :watch: 15 minut

1. Zapoznaj się teraz z klasą `AdvancedCountryBuilder` oraz `AdvancedCityBuilder` w pakiecie `gof.builder.advanced`. Zwróć uwagę na wykorzystanie w klasie `AdvancedCountryBuilder` klasy `AdvancedCityBuilder`.

1. Wykorzystaj obie klasy do utworzenia kolejny raz podobnej struktury 3 państw w klasie `BuilderApp`. Postaraj się, aby utworzenie jednego Państwa ze wszystkimi jego wartościami wymagało utworzenia tylko jeden zmiennej.

[Rozwiązanie](resolutions/1.1.3.md) :watch: 15 minut

Zapisz w klasie `BuilderApp` swoje obserwacje dotyczące wzorca `Builder`.

---

### 1.2. Wzorzec Factory Method

:star:

:watch: 30 minut

1. Zapoznaj się z klasami `Trainee`, `Coach` oraz `Manager` w pakiecie `gof.factory_method`.
1. Przy pomocy dostępnych konstruktorów oraz metod `set` w klasie `FactoryMethodApp` utwórz:
   - 1 menedżera posiadającego imię i nazwisko,
   - 2 trenerów posiadających imię, nazwisko oraz lata doświadczenia. 
   
     > Przyjmijmy, że 1. trener będzie miał doświadczenie regular'a czyli 2 lata, a 2. doświadczenie seniora czyli 5 lat.
     
   - 2 uczestników kursu posiadających imię, nazwisko, przypisanego menedżera (stworzonego wcześniej).
   
[Rozwiązanie](resolutions/1.2.1.md) :watch: 10 minut

1. Zapoznaj się z klasami `TraineeFactory`, `ManagerFactory`, `CoachFactory` w pakiecie `gof.factory_method.factories`. Zwróć uwagę na nazwy metod, ich parametry oraz sposób działania. Zastanów się również jakiego typu są to metody?
1. Przy użyciu klas fabryk utwórz w klasie `FactoryMethodApp` nowy zestaw obiektów, na tej samej zasadzie co poprzednio (1 menedżer, 2 trenerów, 2 uczestników kursu).

[Rozwiązanie](resolutions/1.2.2.md) :watch: 10 minut

1. Usuń z klasy `Trainee` pole `manager` oraz odpowiedni parametr z konstruktora. Jaki wpływ ta zmianę miała na kod w klasie `FactoryMethodApp`? Porównaj co stało się z kodem, w którym używałeś/aś konstruktora klasy `Trainee`, a co z kodem, w którym używałeś/aś metody z fabryki `TraineeFactory`.

1. Zmieńmy rynek IT i ustalmy teraz, że regular to 3 lata, a senior to 6 lat. Dostosuj fragmenty kodu, w których określasz doświadczenie trenerów. Jak ta zmiana wpłynęła na kod używający metod fabrykujących i nie używający tych metod?

Zapisz w klasie `FactoryMethodApp` swoje obserwacje dotyczące wzorca `FactoryMethod`.

---

### 1.3. Wzorzec Prototype

:star:

:watch: 30 minut

1. Zapoznaj się z klasą `Letter` w pakiecie `gof.prototype`.
1. Przy pomocy konstruktora oraz metod `set` klasy `Letter` utwórz w klasie `PrototypeApp` 3 obiekty typu `Letter`. Każdemu obiektowi przypisz:
   - tytuł "_Zaproszenie do konkursu_",
   - treść "_Zapraszamy Pana/Panią do wzięcia udziału w konkursie, w którym można wygrać dużo pieniędzy!_",
   - datę dzisiejszą,
   - przypisz innego adresata.
   
[Rozwiązanie](resolutions/1.3.1.md) :watch: 10 minut
   
1. Zapoznaj się z klasą `Template` w pakiecie `gof.prototype`. Zwróć uwagę na metodę `letter` oraz definicję klasy `Template`. Kto jest rodzicem klasy `Template` i jakie są tego konsekwencje?
1. Utwórz w klasie `PrototypeApp` nowy obiekt typu `Template` o wartościach zgodnych z wartościami wcześniej tworzonych listów. Przy pomocy tego obiektu utwórz 3 obiekty typu `Letter`. Pamiętaj, że każdy list ma mieć innego adresata.

[Rozwiązanie](resolutions/1.3.2.md) :watch: 10 minut

1. Dodaj do klasy `Template` metodę `letter(String receiver)`, w której stworzysz nowy obiekt typu `Letter` na podstawie pól z `this`, ale odbiorca zostanie ustawiony zgodnie z parametrem metody.
1. Wykorzystaj metodę z poprzedniego punktu do utworzenia w `PrototypeApp` kolejnych 3 obiektów typu `Letter`. Wartości pozostają bez zmian, ale pamiętaj, że każdy list ma mieć innego odbiorcę.

[Rozwiązanie](resolutions/1.3.3.md) :watch: 10 minut

Zapisz w klasie `PrototypeApp` swoje obserwacje dotyczące wzorca `Prototype`.

---

### 1.4. Wzorzec Abstract Factory

:star: :star:

:watch: 45 minut

1. Zapoznaj się z klasą `Car`, `Combi`, `SUV` oraz `Sedan` w pakiecie `gof.abstract_factory.cars`.
1. W klasie `AbstractFactoryApp` w pakiecie `gof.abstract_factory` utwórz teraz obiekty jak niżej:
   - 1 samochód marki Fiat i typu Combi, moc 140 KM, silnik 1.8, cena 50.000,00,
   - 1 samochód marki Fiat i typu SUV, moc 180 KM, silnik 2.0, cena 80.000,00,
   - 1 samochód marki Fiat i typu Sedan, moc 130 KM, silnik 1.4, cena 40.000.
   
[Rozwiązanie](resolutions/1.4.1.md) :watch: 10 minut

1. Zapoznaj się teraz z klasami `CarFactory`, `SkodaFactory` oraz `FiatFactory` w pakiecie `gof.abstract_factory.factories`. W klasie `CarFactory` zwróć uwagę na metody abstrakcyjne, które muszą zaimplementować konkretne fabryki. Spójrz na sposób dostarczania fabryk poprzez metodę `getFactory`. Warto abyś też zapoznał/a się z osadzoną klasą typu wyliczeniowego `Mark`.
1. W `AbstractFactoryApp` użyj wprost obiektu klasy `FiatFactory` stwórz nowe trzy pojazdy o wskazanej wcześniej specyfice.

[Rozwiązanie](resolutions/1.4.2.md) :watch: 10 minut

1. Teraz wykorzystaj klasę `CarFactory` do utworzenia dwóch zestawóq, po trzy samochody marki Fiat, zgodnie ze specyfikacjami. Dla utworzenia pierwszego zestawu wykorzystaj metodę `getFactory(Made)`, a dla utworzenia drugiego zestawu metodę `getDefaultFactory()`.

[Rozwiazanie](resolutions/1.4.3.md) :watch: 15 minut

1. Zmiana oczekiwań klientów spowodowała, że lepiej sprzedają się samochody marki Skoda niż Fiat. Dostosuj kod w klasie `AbstractFactoryApp`, aby **CAŁY** kod tworzący dotychczas samochody został zastąpiony tworzeniem aut zgodnie z poniższą specyfikacją:
   - 1 samochód marki Skoda i typu Combi, moc 180 KM, silnik 1.8, cena 75.000
   - 1 samochód marki Skoda i typu SUV, moc 210 KM, silnik 2.0, cena 110.000
   - 1 samochód marki Skoda i typu Sedan, moc 150 KM, silnik 1.5, cena 70.000
   
[Rozwiązanie](resolutions/1.4.4.md) :watch: 10 minut
   
Zapisz w klasie `AbstractFactoryApp` swoje obserwacje dotyczące wzorca `Abstract Factory`.

---

### 1.5. Wzorzec Singleton

:star:

:watch: 20 minut

1. Zapoznaj się z klasami w pakiecie `gof.singleton.cars` oraz `gof.singleton.factories`. Znajdują się tam analogiczne klasy samochodów i fabryk jak dla wzorca _Abstract Factory_. Również w kodzie klasy `SingletonApp` mamy końcowy kod z zadania 1.4. 

   > Zwróć uwagę na jedną zmianę - w naszych fabrykach pojawiły się obiekty prototypów. Każda fabryka w momencie utworzenia odzytuje konfiguracje prototypu i na podstawie prototypu tworzy samochody. Oszczędzamy w ten sposób duuuuużo pamięci w programie, ale kosztem czasu. Przygotowanie każdego prototypu wymaga czasu. Tworzenie obiektów fabryki stało się kosztowne!

1. Uruchom kod klasy `SingletonApp`, aby przekonać się, że nasze utworzenie kilkunastu samochodów zajmuje naprawdę dużo czasu.
1. Zapoznaj się teraz z kodem klas `SingletonFiatFactory`, `SingletonSkodaFactory` oraz `SingletonCarFactory` w pakiecie `gof.singleton.impl`. Zwróć szczególną uwagę na konstruktory oraz metody `getInstance` klas `SingletonSkodaFactory` i `SingletonFiatFactory`, a także na obiekty zwracane z metody `getFactory` klasy `SingletonCarFactory`.
1. Zamień w klasie `SingletonApp` użycie zwykłych fabryk na fabryki zgodne ze wzorcem Singleton i uruchom metodę `main` tej klasy.

[Rozwiązanie](resolutions/1.5.1.md) :watch: 20 minut

1. Porównaj kod klas `SingletonFiatFactory` i `SingletonSkodaFactory` pod względem sposobu implementowania wzorca Singleton. Czym różnią się metody `getInstance()` i sposób przechowywania pojedynczej instancji?
1. Zastanów się jak można zrealizować wzorzec Singleton nie wprowadzając klas `SingletonFiatFactory` i `SingletonSkodaFactory`, a bazując tylko na ich wersjach podstawowych: `FiatFatory` i `SkodaFactory`? (Poza zastanowieniem się możesz też spróbować to zrobić :) )
 
Zapisz w klasie `SingletonApp` swoje obserwacje dotyczące wzorca `Singleton`.

---

### Wzorzec Decorator

:star:

:watch: 40 minut

1. Zapoznaj się z interfejsem `BankAccount` oraz klasą `InMemoryBankAccount` w pakiecie `gof.decorator`. Zwróć uwagę na zastosowanie metody `requireOpen` w pozostałych metodach.
1. W klasie `DecoratorApp` (w metodzie `main`) wykonaj następujące operacje:
   - Utwórz dwa nowe obiekty kont bankowych,
   - Wpłać na każde z kont po 20.000,
   - Wykonaj przelew 10.000 z pierwszego konta na drugie,
   - Wykonaj przelew 5.000 z drugiego konta na pierwsze,
   - Zamknij oba konta.
   
   Po każdej operacji dodaj wyświetlenie tekstu na konsoli, który opisuje co się zdarzyło, np. `System.out.println("Otwarto konto: " + account1.getIBAN());`
1. Zastanów się nad tym ile powtarzającego się kodu trzeba było zapisać?
   
[Rozwiązanie](resolutions/1.6.1.md) :watch: 10 minut

1. Zapoznaj się z teraz klasą `LoggableBankAccount` w pakiecie `gof.decorator.impl`. Zwróć uwagę na sposób tworzenia obiektu klasy `LoggableBankAccount` i rolę pola `decorated`. Czy klasa `LoggableBankAccount` zawiera kod świadczący faktyczną obsługę konta bankowego?
1. W klasie `DecoratorApp` zmodyfikuj kod, w którym tworzysz obiekty `BankAccount` i _udekoruj je_ jako obiekty klasy `LoggableBankAccount`.
1. Uruchom klasę `DecoratorApp`. Czy potrzebujemy dłużej wyświetlania informacji na konsoli w klasie `DecoratorApp`?

[Rozwiązanie](resolutions/1.6.2.md) :watch: 10 minut

1. Teraz przejdź do kodu klasy `AuditableBankAccount` w pakiecie `gof.decorator.impl`. Zwróć uwagę na sposób tworzenia obiektu klasy `AuditableBankAccount`, rolę pola `decorated` oraz sposób w jaki dekorujemy zewnętrzny obiekt typu `BankAccount`. Czy to podejście jest już Ci znane?
1. Dokończ implementację klasy `AuditableBankAccount`, tak, aby informacja o każdej operacji była zapisywana w historii. Jako historię operacji wybierz pole reprezentujące jakąś kolekcję, ale pamiętaj, że historia musi zachować swoją chronologię. Samą historię możesz przechowywać w postaci obiektów typu `String` lub dedykowanych obiektów typu `AuditLog` (do samodzielnego stworzenia).
1. Dodaj do klasy `AuditableBankAccount` metodę `getHistory`, która zwróci informację o historii operacji na koncie. Zadbaj o to, aby wartość zwracana z tej metody nie mogła być wykorzystana do modyfikacji zawartości historii (pola z historią operacji).
1. W klasie `DecoratorApp` stwórz dwa nowe konta bankowe. Pierwsze konto powinno być tylko _logowalne_, bo jest to zwyczajne konto. Drugie konto jest monitorowane przez Urząd Skarbowy, który poprosił nas, aby cała historia operacji była trwale zapamiętana. Tworzymy je więc jako konto _logowalne_ i _audytowalne_. Wykonaj dla nich analogiczny zestaw operacji jak dla wcześniej stworzonych kont.
1. Po zrealizowaniu wszystkich operacji na kontach i ich zamknięciu, wyświetl w metodzie `main` historię konta audytowanego.

[Rozwiązanie](resolutions/1.6.3.md) :watch: 20 minut

Zapisz w klasie `DecoratorApp` swoje obserwacje dotyczące wzorca `Decorator`.

---

### 1.7. Wzorzec Visitor

:star: :star:

:watch: 100 minut

1. Zapoznaj się z metodą `traverse` w klasie `VisitorApp` (pakiet `gof.visitor`). Metoda służy do przejścia po ścieżce katalogów. Metoda `travers` nie powoduje żadnego efektu. Jest tylko szablonowym kodem umożliwiającym rekurencyjne przejście po drzewie katalogów. Jej kod posłuży Ci do napisania kilku wariacji tej metody.

1. Na podstawie metody `travers` napisz nową metodę `printDirs`, której zadaniem będzie wyświetlenie wszystkich nazw katalogów. Po napisaniu metody wywołaj ją dla katalogu bieżącego oraz katalogu `Desktop` (lub `Pulpit`).

[Rozwiązanie](resolutions/1.7.1.md) :watch: 10 minut

1. Napisz teraz metodę `printJavas`, która wypisze wszystkie nazwy plików z kodem źródłowym Java (mających rozszerzenie `.java`) we wskazanym katalogu. Metodę wywołaj dla katalogu bieżącego oraz katalogu `Desktop` (lub `Pulpit`).

[Rozwiązanie](resolutions/1.7.2.md) :watch: 10 minut

1. Napisz już ostatnią metodę `countClassFile`, która zliczy skompilowane pliki `.class` w strukturze katalogów. Metoda powinna zwracać ilość zliczonych plików. Wywołaj metodę dla katalogu bieżącego oraz katalogu `Desktop` (lub `Pulpit`).

[Rozwiązanie](resolutions/1.7.3.md) :watch: 15 minut

Przyszedł czas na usprawnienia i wprowadzenie wzorców projektowych!

1. Zapoznaj się z kodem klas `Traversal`, `Visitor` oraz `DirVisitor` w pakiecie `gof.visitor.impl`. Zwróc uwagę jak w klasie `Traversal` są wykorzystywane metody `accept` i `use` z interfejsu `Visitor`. Następnie zapoznaj się przykładową implementacją interfejsu `Visitor` w postaci klasy `DirectoryPrintingVisitor`.
1. W klasie `VisitorApp` wykorzystaj klasę `Traversal` oraz `DirectoryPrintingVisitor`, aby uzyskać ten sam efekt, co przy metodzie `printDirs` dla katalogu bieżącego lub katalogu `Desktop` (`Pulpit`).

[Rozwiązanie](resolutions/1.7.4.md) :watch: 10 minut

1. Utwórz teraz nową klasę `JavaFilesPrintingVisitor` która rozszerzy interfejs `Visitor` i będzie wyświetlała tylko pliki źródłowe języka Java. Po dostarczeniu implementacji użyj jej aby wyświetlić wszystkie pliki z kodem żródłowym z katalogu bieżącego lub katalogu `Desktop` (`Pulpit`).

[Rozwiązanie](resolutions/1.7.5.md) :watch: 15 minut

1. Zapoznaj się z kodem klasy `CountingVisitor`. Jakie pliki/katalogi zlicza kod tej klasy? Od czego zależy, które pliki/katalogi są zliczane?
1. Wykorzystaj klasę `CountingVisitor` w następujący sposób:
   - zlicz wszystkie pliki klas w katalogu bieżącym,
     
     > W celu realizacji tego punktu utwórz nową klasę `ClassFilePredicate`, która zaimplementuje interjfes `Predicate<File>`. Wykorzystaj jej obiekt do utworzenia instancji klasy `CountingVisitor`.
     
   - zlicz wszystkie pliki z kodem źródłowym w katalogu bieżącym,
   
     > W celu realizacji tego punktu utwórz obiekt nowej klasy anonimowej implementującej interfejs `Predicate<File>`. Wykorzystaj ten obiekt do utworzenia instancji klasy `CountingVisitor`.
     
   - zlicz wszystkie pliki w katalogu bieżącym,
   
     > W celu realizacji tego punktu wykorzystaj wyrażenie lambda do utworzenia nowej instancji klasy `CountingVisitor`.
     
   - zlicz wszystkie katalog w katalogu bieżącym,
   
     > W celu realizacji tego punktu wykorzystaj uchwyty do metod do utworzenia nowej instancji klasy `CountingVisitor`.
     
1. Porównaj sposoby dostarczania implementacji interfejsu `Predicate<File>` oraz możliwości zastosowania klasy `CountingVisitor` vs dedykowane metody.

[Rozwiązanie](resolutions/1.7.6.md) :watch: 20 minut

1. Na zakończenie zapoznaj się z metodą `walkFileTree` oraz `walk` z klasy `java.nio.file.Files`. Przy pomocy tych metod zrealizuj po jednym z dowolnych zadań wcześniej realizowanych z użyciem naszych klas typu `Visitor`.

Zapisz w klasie `VisitorApp` swoje obserwacje dotyczące wzorca `Visitor`.

---

### 1.8. Wybrane wzorce projektowe

:star:

:watch: 45 minut

W kolejnym module nie będziesz już pracował/a z jednostkowymi wzorcami, a z ich współdziałaniem w całej aplikacji. Warto jednak, abyś zapoznał/a się z większą ilością przykładów implementacji wzorców. Istnieje genialne opracowanie wzorców projektowych w postaci kodu język Java: [iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns)

Twoim zadaniem jest wybranie 3 dowolnych wzorców, które nie zostały zrealizowane w zadaniach. Odnajdź te wzorce w podłączonym repozytorium i zapoznaj się z ich implementacją lub działaniem. Przykłady implementacji tych wzorców możesz przepisać z repozytorium, skopiować albo po prostu całe repozytorium zforkować.

Powodzenia!

----

### Gratuluję!

Zakończyłeś/aś pracę z kiloma ważnymi wzorcami projektowyi! Ich świat jest jeszcze większy, ale tyle wystarczy. Najważniejsze, że nie tylko widzisz jak ich implementacja może wyglądać, ale również spotkałeś/aś się z problemami, które rozwiązują. Pamiętaj, że czym więcej kodu, czym większa aplikacja i czym więcej w niej zależności między klasami, tym większą wartość wnoszą wzorce projektowe.

[Należy Ci się](https://www.youtube.com/watch?v=S0UvJZmGTsk)