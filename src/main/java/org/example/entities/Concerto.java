package org.example.entities;

import org.example.entities.enumeratori.Genere;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento{


    private Genere genere;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, String descrizione, LocalDate dataEvento, Integer numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, descrizione, dataEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
 }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
