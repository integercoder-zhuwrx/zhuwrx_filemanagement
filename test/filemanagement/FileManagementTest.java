package filemanagement;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagementTest {
    // "Kurzer Text zum ggT.txt"
    final String derText = """
            Der größte gemeinsame Teiler (ggT) ist die größte natürliche Zahl, durch die sich zwei ganze Zahlen ohne Rest teilen lassen.
            Eine Möglichkeit der Berechnung ist der moderne euklidische Algorithmus, bei welchem in aufeinanderfolgenden Schritten jeweils eine Division mit Rest durchgeführt, wobei der Rest im nächsten Schritt zum neuen Divisor wird. Der Divisor, bei dem sich Rest 0 ergibt, ist der größte gemeinsame Teiler der Ausgangszahlen.
                            
            3780 : 3528 = 1 Rest 252
            3518 : 252 = 14 Rest 0
            Somit wäre 252 der ggT von 3780 und 3528.""";

    // "Text.txt"
    final String eineText = """
            Eine Gleitkommazahl (auch Fließkommazahl genannt) ist eine angenäherte Darstellung einer reellen Zahl.
                            
            Die Menge der Gleitkommazahlen ist eine Teilmenge der rationalen Zahlen. Zusammen mit den auf ihnen definierten Operationen (Gleitkommaarithmetik) bilden die Gleitkommazahlen eine endliche Arithmetik, die vor allem im Hinblick auf numerische Berechnungen mit (binären) Rechnern entwickelt wurde.
                            
            (siehe Wikipedia)""";

    final String eineInputText = "Eine Gleitkommazahl (auch Fließkommazahl genannt) ist eine angenäherte Darstellung einer reellen Zahl.\\n\\nDie Menge der Gleitkommazahlen ist eine Teilmenge der rationalen Zahlen. Zusammen mit den auf ihnen definierten Operationen (Gleitkommaarithmetik) bilden die Gleitkommazahlen eine endliche Arithmetik, die vor allem im Hinblick auf numerische Berechnungen mit (binären) Rechnern entwickelt wurde.\\n\\n(siehe Wikipedia)";

    @Test
    void readFromFile() throws IOException {
        String text = FileManagement.readFromFile("Kurzer Text zum ggT.txt");
        assertEquals(derText, text);
    }

    @Test
    void writeToFile() throws IOException {
        String textFromMethod = FileManagement.writeToFile(eineInputText, "Text.txt");
        String textFromFile = FileManagement.readFromFile("Text.txt");
        assertEquals(eineText, textFromMethod);
        assertEquals(eineText, textFromFile);
    }

    @Test
    void mainReadFromFile() throws IOException {
        try (SystemOutRedirector sor = new SystemOutRedirector()) {
            String[] args = new String[]{"read", "Kurzer Text zum ggT.txt" };
            FileManagement.main(args);
            String output = sor.getOutputText();
            assertThat(output).isEqualToNormalizingNewlines(derText + "\n");
        }
    }

    @Test
    void mainWriteToFile() throws IOException {
        try (SystemOutRedirector sor = new SystemOutRedirector()) {
            String[] args = new String[]{"write", eineInputText, "Text.txt" };
            FileManagement.main(args);
            String output = sor.getOutputText();
            assertThat(output).isEqualToNormalizingNewlines(eineText + "\n");
        }
    }
}
