package filemanagement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SystemOutRedirector implements java.io.Closeable {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public SystemOutRedirector() {
        System.setOut(new PrintStream(baos));
    }

    public String getOutputText() {
        return baos.toString();
    }

    @Override
    public void close() throws IOException {
        baos.close();
        System.setOut(originalOut);
    }
}
