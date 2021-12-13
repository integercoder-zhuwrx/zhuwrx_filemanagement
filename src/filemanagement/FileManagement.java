package filemanagement;

import java.io.*;

class FileManagement {
    public static String readFromFile(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                if (!sb.isEmpty()) {
                    sb.append("\n");
                }
                sb.append(line);
                line = reader.readLine();
            }
            return sb.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void writeToFile(String text, String name) throws IOException {
        text = text.replace("\\n", "\n");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(name));
            writer.write(text);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
