/**
 * klassen Entry representerar en allmän Dagbok
 * @author WendiiAV
 */
public class Entry {
    private String diaryTitle;
    private String diaryEntries;
    private String localDate;

    /**
     * Denna klass låter definiera de grundläggande metoderna för generatorn
     * Konstruktör
     */
    public Entry(String diaryTitle, String diaryEntries, String localDate) {
        this.diaryTitle = diaryTitle;
        this.diaryEntries = diaryEntries;
        this.localDate = localDate;
    }

    public Entry() {
    }

    /**
     * generator till getter och setter
     */

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryEntries() {
        return diaryEntries;
    }

    public void setDiaryEntries(String diaryEntries) {
        this.diaryEntries = diaryEntries;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
}
