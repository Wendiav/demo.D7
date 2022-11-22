import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDiary {
    /**
     * I detta projekt har jag använt metoder som gör det möjligt att skriva publikationer och
     * även kunna spara dem för att läsa dem igen.
     */
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Entry> journalEntries = new ArrayList<>();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Path path = Paths.get("src/main/resources/diaryEntry.json");


    static {
        try {
            journalEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * metod för skapa anteckningar till min dagbok
     *
     * @return
     * @throws IOException användaren kan ange titel
     *                     användaren kan skriva inlägg till dagbok
     *                     det aktuella datumet skrivs automatiskt
     */
    public static Entry createNewEntry() throws IOException {
        Entry entry = new Entry();
        List<Entry> journalEntries = new ArrayList<>();


        System.out.println("Skriv in Title: ");
        String diaryTitle = scanner.nextLine();
        entry.setDiaryTitle(diaryTitle);

        System.out.println("Skriv in din Dagboks inlägg: ");
        String diaryEntries = scanner.nextLine();
        entry.setDiaryEntries(diaryEntries);

        LocalDateTime currentDateAndTime = LocalDateTime.now();
        System.out.println("Dagens datum och tid: " + currentDateAndTime);
        String localDate = LocalDate.now().toString();
        entry.setLocalDate(localDate);

        Entry newEntry = new Entry(diaryTitle, diaryEntries, localDate);

        journalEntries.add(newEntry);
        mapper.writeValue(path.toFile(), journalEntries);

        return entry;
    }


    /**
     * denna metod skriver ut innehållet som finns i Dagbooken
     * Med denna metod kan du hitta titeln, inlägg  och datumet när den skrevs.
     * lägger också till alternativet att skriva MENU för att återgå till huvudmenyn
     **/
    public static void printTheContent(){
        try{
            List<Entry> diaryEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));
            for (Entry entry : diaryEntries){
                System.out.println("Title: " + entry.getDiaryTitle());
                System.out.println("Inlägg: " + entry.getDiaryEntries());
                System.out.println("Datum: " + entry.getLocalDate());
            }
            System.out.println("skriv `MENU` för att återgå till huvudmenyn..");
            scanner.nextLine();

        }catch (IOException e){
            System.out.println(e);
            System.out.println("Dagbooken är tom!");
        }
    }

    /**
     * Denna metod kommer att spara publikationerna i JSON-fil
     * @throws IOException
     */
    public static void saveEntriesToJSON() throws IOException {
        journalEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));
        List<Entry> entries = new ArrayList<>(journalEntries);
        entries.add(createNewEntry());
        mapper.writeValue(path.toFile(), entries);
    }

    /**
     * Metoder för huvudmenyn:
     * på denna method specificerar jag hur ska utföras MAIN MENU
     * @return används för att beskriva ett returvärde
     */

    public static int mainMenu() {
        System.out.println("""
                    -----------------------------------
                     Välkomna till dagboken!
                          ---MAIN MENU---
                    ------------------------------------
                    1. Visa inlägg som finns i dagbok
                    2. Skapa en ny inlägg
                    3. avsluta programmer
                    ------------------------------------
                    """);
        System.out.println("Välja en alternativ:");


        return Integer.parseInt(scanner.nextLine());

    }
}
