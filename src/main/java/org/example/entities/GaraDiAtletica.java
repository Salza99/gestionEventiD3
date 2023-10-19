package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name = "gara_di_atletica")

public class GaraDiAtletica extends Evento {

    @Column(name = "set_atleti")
    @OneToMany(mappedBy = "partecipanteGara")
    private List<Persona> atleti;
    @OneToOne
    private Persona vincitore;


    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, String descrizione, LocalDate dataEvento, Integer numeroMassimoPartecipanti, Location location, List<Persona> atleti, Persona vincitore) {
        super(titolo, descrizione, dataEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }


}
