package Orochi.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileModifier {



    public void writeHighScore(String highScore) throws IOException {
        String lastHighScore = readHighScore();

        if (lastHighScore == null || lastHighScore.isEmpty()) {
            try (FileWriter writer = new FileWriter("highscore.txt")) {
                writer.write(highScore);
            }
        }
        else {
            int lastScore = Integer.parseInt(lastHighScore);
            int newScore = Integer.parseInt(highScore);
            if (newScore > lastScore) {
                try (FileWriter writer = new FileWriter("highscore.txt")) {
                    writer.write(highScore);
                }
            }
        }
    }

    public String readHighScore() throws IOException {
        File file = new File("highscore.txt");
        if (Files.exists(file.toPath())) {
            return Files.readString(file.toPath());
        }

        file.createNewFile();
        return null;

    }

}
