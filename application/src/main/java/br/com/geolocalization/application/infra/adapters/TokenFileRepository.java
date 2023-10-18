package br.com.geolocalization.application.infra.adapters;

import br.com.geolocalization.application.domain.Token;
import br.com.geolocalization.application.infra.interfaces.TokenFileRepositoryPort;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Component
public class TokenFileRepository implements TokenFileRepositoryPort {

    private static final Logger LOGGER = Logger.getLogger(TokenFileRepository.class.getName());
    @Override
    public void fileWriter(@Nonnull String path, @Nonnull String file, @Nonnull Token token) {
        String dir = path + file;

        verifyDirectory(dir);

        try {
            FileWriter doc = new FileWriter(dir);
            doc.write(token.getHash() + "," + token.getValidity());
            doc.close();
            LOGGER.info("File '" + file + "' created success.");
        } catch (IOException e) {
            LOGGER.warning("Error on create file '" + file + "': ========> " + e.getMessage());
        }
    }

    @Override
    public Token fileRead(@Nonnull String path, @Nonnull String file) {
        File doc = new File(path + file);

        String line = "";

        if (doc.exists()) {
            StringBuilder resultStringBuilder = new StringBuilder();
            try {
                Path p = Paths.get(path + file);

                BufferedReader reader = Files.newBufferedReader(p);

                line = reader.readLine();

            } catch (IOException e) {
                LOGGER.warning("Error on access file.");
            }
        } else {
            LOGGER.warning("The file does not exist.");
        }

        return getToken(line);
    }

    private void verifyDirectory(String dir) {
        File directory = new File(dir);

        if (Boolean.FALSE.equals(directory.exists())) {
            directory.mkdir();
        }
    }

    private Token getToken(String str) {
        String hash = str.substring(0, str.lastIndexOf(","));

        String validity = str.substring(str.lastIndexOf(",") + 1, str.length());

        return new Token(hash, Long.valueOf(validity));
    }
}