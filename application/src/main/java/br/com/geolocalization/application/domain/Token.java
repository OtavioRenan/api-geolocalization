package br.com.geolocalization.application.domain;

import java.sql.Timestamp;

public class Token {
    String hash;

    long validity;

    public Token(String hash, long validity) {
        this.hash = hash;
        this.validity = validity;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getValidity() {
        return validity;
    }

    public void setValidity(long validity) {
        this.validity = validity;
    }
}