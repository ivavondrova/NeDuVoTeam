# Zahraj si

### Základní informace o týmu a projektu

- **Název týmu**: NeDuVo
- **Název projektu**: Zahraj si
- **Členové týmu**:
  - Vladimír Dušek
  - Petr Netolický
  - Iva Vondrová
- **Stručný popis projektu**: 	Rezervační systém pro multifunkční sportoviště "Zahraj si"


### Popis aplikace 

Aplikace slouží jako rezervační systém pro multifunkční sportoviště. Zákazník sportovního centra si zde může zarezervovat/pronajmout sportoviště – a to na určitý den, určitý čas. Zákazník při rezervaci sportoviště uvést celé jméno a kontakt (telefonní číslo, emailovou adresu). Dále má možnosti si vybrat, o jaké sportoviště má zájem, v tu chvíli se mu zobrazí aktuální nabídka volných termínů – kalendáře se dny a posléze také přesná časová blokace. Některá sportoviště (např. vířivka či posilovna) jsou omezena svou kapacitou – pro to, také uvádí počet osob, pro které sportoviště rezervuje. Jestliže má zájem rezervovat si více sportovišť, může po uložení údajů pokračovat k rezervaci dalšího sportoviště. Postupně se mu ukládají a zobrazují údaje o jeho rezervaci, tzn. sportoviště, den, čas, počet lidí a cena. Zrušení rezervace je možné pouze zaměstnancem podniku na základě telefonické žádosti. Zaměstnanci podniku spravují systém rezervací a mohou si zobrazovat časové plány pro jednotlivá sportoviště. Celou aplikaci pak spravuje administrátor, který má na starosti správu sportovišť a zaměstnaneckých účtů.


### Úkoly členů týmu

- Název týmu, seznam členů týmu, zadání úlohy, seznam úkolů a jejich přiřazení členům týmu - Vladimír Dušek
- Use case diagram – Iva Vondrová
- Slovní popis včetně scénářů pro každý use case (dle šablony z metodiky MMSP) – Iva Vondrová
- Class diagram na designové úrovni vytvořený v CASE nástroji – oddělení tříd s uživatelským rozhraním a tříd logiky do balíčků – Petr Netolický 
- Struktura souborů nebo struktura databáze – Petr Netolický
- Návrh uživatelského rozhraní (prototyp obrazovky) – Iva Vondrová 
- Konvence, které si tým definoval pro svou práci – Tým se bude držet základních pravidel a konvencí pro psaní v objektově orientovaném jazyce Java. Bude dodržovat konvence pro psaní malých písmen u metod, velkých písmen u tříd. Využívají atributů protected, private, public.


- **Implementace tříd**:
	- Sportovní areál – Petr Netolický
	- Sportoviště -  Petr Netolický
	- Rezervace – Iva Vondrová
	- Zákazník – Vladimír Dušek
	- Osoba s přístupem – Vladimír Dušek

### Diagramy

1. Class Diagram:
![Class Diagram](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Diagramy/Class%20Diagram.png?raw=true)

2. UseCase Diagram:
![UseCase Diagram](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Diagramy/UseCase%20Diagram.png?raw=true)

Use Case Specifikaci můžete najít na následujícím odkazu: [Use Case Specifikace](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Use%20Cases%20specification.docx). (Dokument je nutné si stáhnout.)

### Návrhy obrazovek

**1. Návrh obrazovky *"Vytvoření rezervace"*:**
![Návrh obrazovky "vytvoření rezervace"](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Návrh%20obrazovek/Návrh1.png?raw=true)

**Popis**: Zákazník si vybere sportoviště, které chce rezervovat, podle dostupnosti se mu zobrazí možné dny a časy. V pravé horní části obrazovky se mu zobrazí shrnutí jeho objednávky. Pro dokončení rezervace vyplní své kontaktní údaje a klikne na tlačítko "Dokončit".

**2. Návrh obrazovky *"Hlavní menu"*:**
![Návrh obrazovky "hlavní menu"](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Návrh%20obrazovek/Návrh2.png?raw=true)

**Popis**: Zobrazení hlavního menu pro uživatele s administrátorskými právy.

**3. Návrh obrazovky *"Blokace sportoviště"*:**
![Návrh obrazovky "blokace sportoviště"](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Návrh%20obrazovek/Návrh3.png?raw=true)

**Popis**: Zablokování sportoviště (např. z důvodu technických problémů apod.) ze strany zaměstnance/administrátora. V levé části obrazovky vidí navigaci (strom aplikace). Dále vybere konkrétní sportoviště a vyplní příslušné informace.


### Databázová struktura

Příklad databázové struktury je dostupný na následujícím odkazu: [Databázová struktura](https://github.com/ivavondrova/NeDuVoTeam/blob/master/NeDuVoTeamProject/Navrh_reseni/Struktura-databáze.xlsx). (Dokument je nutné si stáhnout.)

### Úpravy při realizaci
Po domluvě s vyučujícím odebrána třída admin a tím pádem není nutná třída osoba s přístupem, blokace a spotovní areál. 
Důvody: Sportovní areál není potřeba, protože je aplikace pouze pro jeden sportovní areál "Zahrajsi"
Admin není potřeba, všechny privilegia admina mohou provádět pro snadnější práci s daty a zaměstnanci i sami zaměstnanci.
Blokace není potřeba, sportoviště se může odebrat, takže plní funkci třídy "blokace".
Osoba s přístupem není potřeba, jedná se nyní pouze o třídu zaměstnanec, která jediná má přístup.
Poslední úprava byla, že klient nemá dovoleno pouze vytvářet rezervace, nikoliv je vypisovat - kvůli ochraně osobních údajů dalších klientů. Nemůže je také svévolně mazat, aby se nerezervoval a pak to zase neodvolal.



