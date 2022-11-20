import java.io.IOException;
/**
 * systemets huvudklass
 * @author WendiiAV
 */
public class MainMenu {
    public static void main(String[] args) throws IOException {
        int selectOptions = 0;


        while (selectOptions !=3) {
            selectOptions = MainDiary.mainMenu();

            switch (selectOptions) {

                case 1:
                    MainDiary.printTheContent();
                    break;

                case 2:
                    MainDiary.createNewEntry();
                    break;

                case 3:
                    System.out.println("Avsluta programmet..." +
                            "Välkommen åter!!");
                    break;


            }
        }
    }
}
