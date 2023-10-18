package br.com.geolocalization.application.domain.adapters;

import br.com.geolocalization.application.domain.Token;
import br.com.geolocalization.application.domain.ports.TokenFileServicePort;
import br.com.geolocalization.application.infra.interfaces.TokenFileRepositoryPort;

import java.sql.Timestamp;

public class TokenFileServiceImp implements TokenFileServicePort {
    private static final String PATH = "application/src/main/resources/tokens/";

    private static final String FILE_NAME = "geolocalization-token.txt";

    private static final long HOURS = (1000 * 60) * 60;

    private final TokenFileRepositoryPort repository;

    public TokenFileServiceImp(TokenFileRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void getToken() {
        Token token =  repository.fileRead(PATH, FILE_NAME);

        System.out.println("Hash ==========> " + token.getHash());
        System.out.println("Validity ==========> " + token.getValidity());
        System.out.println("checkItsValid ==========> " + checkItsValid(token.getValidity()));

        token = checkItsValidAndCreate(token);

        System.out.println("Hash ==========> " + token.getHash());
        System.out.println("Validity ==========> " + token.getValidity());
        System.out.println("checkItsValid ==========> " + checkItsValid(token.getValidity()));
    }

    private boolean checkItsValid(long valid) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        Timestamp time = new Timestamp(valid);

        return time.after(now);
    }

    private Token checkItsValidAndCreate(Token token) {
        Timestamp time = new Timestamp(System.currentTimeMillis() + HOURS);

        if(!checkItsValid(token.getValidity())) {
            token = new Token(time.toString(), time.getTime());

            repository.fileWriter(PATH, FILE_NAME, token);
        }

        return token;
    }
}