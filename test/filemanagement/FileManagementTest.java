package filemanagement;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagementTest {

    @Test
    void readFromFile() throws IOException {
        String text = FileManagement.readFromFile("Kurzer Text zum ggT.txt");
        assertEquals("""
                Der größte gemeinsame Teiler (ggT) ist die größte natürliche Zahl, durch die sich zwei ganze Zahlen ohne Rest teilen lassen.
                Eine Möglichkeit der Berechnung ist der moderne euklidische Algorithmus, bei welchem in aufeinanderfolgenden Schritten jeweils eine Division mit Rest durchgeführt, wobei der Rest im nächsten Schritt zum neuen Divisor wird. Der Divisor, bei dem sich Rest 0 ergibt, ist der größte gemeinsame Teiler der Ausgangszahlen.
                                
                3780 : 3528 = 1 Rest 252
                3518 : 252 = 14 Rest 0
                Somit wäre 252 der ggT von 3780 und 3528.""", text);
    }

    @Test
    void writeToFile() throws IOException {
        String inputText = "Eine Gleitkommazahl (auch Fließkommazahl genannt) ist eine angenäherte Darstellung einer reellen Zahl.\\n\\nDie Menge der Gleitkommazahlen ist eine Teilmenge der rationalen Zahlen. Zusammen mit den auf ihnen definierten Operationen (Gleitkommaarithmetik) bilden die Gleitkommazahlen eine endliche Arithmetik, die vor allem im Hinblick auf numerische Berechnungen mit (binären) Rechnern entwickelt wurde.\\n\\n(siehe Wikipedia)";
        FileManagement.writeToFile(inputText, "Text.txt");

        String expected = """
                Eine Gleitkommazahl (auch Fließkommazahl genannt) ist eine angenäherte Darstellung einer reellen Zahl.
                
                Die Menge der Gleitkommazahlen ist eine Teilmenge der rationalen Zahlen. Zusammen mit den auf ihnen definierten Operationen (Gleitkommaarithmetik) bilden die Gleitkommazahlen eine endliche Arithmetik, die vor allem im Hinblick auf numerische Berechnungen mit (binären) Rechnern entwickelt wurde.
                
                (siehe Wikipedia)""";
        String text = FileManagement.readFromFile("Text.txt");
        assertEquals(expected, text);
    }
}
