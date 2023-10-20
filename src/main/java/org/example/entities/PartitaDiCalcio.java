package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
//@NamedQuery(name = "getGameWinsByOwner", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa")
//@NamedQuery(name = "getGameWinsByGuests", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
public class PartitaDiCalcio extends Evento{

    @Column(name = "squadra_di_casa", length = 3)
    private String squadraDiCasa;
    @Column(name = "squadra_ospite", length = 3)
    private String squadraOspite;
    @Column(name = "squadra_vincente", length = 3)
    private String squadraVincente;
    @Column(name = "n_gol_squadra_di_casa")
    private Integer nGolSquadraDiCasa;
    @Column(name = "n_gol_squadra_ospite")
    private Integer nGolSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, String descrizione, LocalDate dataEvento, Integer numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, Integer nGolSquadraDiCasa, Integer nGolSquadraOspite) {
        super(titolo, descrizione, dataEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.nGolSquadraDiCasa = nGolSquadraDiCasa;
        this.nGolSquadraOspite = nGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public Integer getnGolSquadraDiCasa() {
        return nGolSquadraDiCasa;
    }

    public void setnGolSquadraDiCasa(Integer nGolSquadraDiCasa) {
        this.nGolSquadraDiCasa = nGolSquadraDiCasa;
    }

    public Integer getnGolSquadraOspite() {
        return nGolSquadraOspite;
    }

    public void setnGolSquadraOspite(Integer nGolSquadraOspite) {
        this.nGolSquadraOspite = nGolSquadraOspite;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", nGolSquadraDiCasa=" + nGolSquadraDiCasa +
                ", nGolSquadraOspite=" + nGolSquadraOspite +
                '}';
    }
}
