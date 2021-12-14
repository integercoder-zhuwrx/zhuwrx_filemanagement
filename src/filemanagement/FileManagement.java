package filemanagement;

import java.io.*;

class FileManagement {
    public static void main(String[] args) throws IOException {
        String command = args[0];
        if (command.equals("read")) {
            String fileName = args[1];
            String inputText = readFromFile(fileName);
            System.out.println(inputText);
        } else if (command.equals("write")) {
            String inputText = args[1];
            String fileName = args[2];
            String outputText = writeToFile(inputText, fileName);
            System.out.println(outputText);
        }
    }

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

    public static String writeToFile(String text, String fileName) throws IOException {
        text = text.replace("\\n", "\n");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(text);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return text;
    }
}
