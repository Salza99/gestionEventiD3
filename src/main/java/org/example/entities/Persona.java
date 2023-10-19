package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 15)
    private String nome;
    @Column(length = 15)
    private String cognome;
    private String email;
    @Column(name = "data_di_nascità")
    private LocalDate dataDiNascita;

    private char sesso;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    @OrderBy("id ASC")
    private List<Partecipazione> listaPartecipazioni;
    @ManyToOne
    @JoinColumn(nullable = true)
    private GaraDiAtletica partecipanteGara;


    //costruttori
    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }
    //getter setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso='" + sesso + '\'' +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
