package br.com.geolocalization.application.infra.interfaces;

import br.com.geolocalization.application.domain.Token;
import jakarta.annotation.Nonnull;

public interface TokenFileRepositoryPort {
    void fileWriter(@Nonnull String path, @Nonnull String file, @Nonnull Token token);

    Token fileRead(@Nonnull String path, @Nonnull String file);
}