package filemanagement;

import java.io.*;

class FileManagement {
    public static String readFromFile(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            do {
                line = br.readLine();
                sb.append(line);
                sb.append("\n");
            } while (line != null);
            return sb.toString();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static String readFromFile2(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        do {
            line = br.readLine();
            sb.append(line);
            sb.append("\n");
        } while (line != null);
        br.close();
        return sb.toString();
    }

    public static void writeToFile(String text, String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write(text);
        writer.close();
    }
}
