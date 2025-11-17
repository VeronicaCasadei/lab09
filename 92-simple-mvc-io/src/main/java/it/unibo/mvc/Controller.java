package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + Controller.class.getSimpleName() + ".txt";
    private File currentFile = new File(PATH);

    public void setCurrentFile(final File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("Invalid file");
        }
        this.currentFile = file;
    }

    /**
     * Gets the current file.
     *
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getCurrentFilePath() {
    if (this.currentFile == null) {
        throw new IllegalStateException("No current file has been set");
    }
    return this.currentFile.getPath();
    }

    public void saveStringInFile(final String parola) throws IOException {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(parola);
        }
    }
}
