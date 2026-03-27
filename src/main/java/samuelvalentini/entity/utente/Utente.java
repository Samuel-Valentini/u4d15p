package samuelvalentini.entity.utente;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    Random random = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_utente")
    private UUID idUtente;
    @Column(name = "nome_utente", nullable = false)
    private String nomeUtente;
    @Column(name = "cognome_utente", nullable = false)
    private String cognomeUtente;
    @Column(name = "data_di_nascita_utente", nullable = false)
    private LocalDate dataDiNascitaUtente;
    @Column(name = "numero_tessera_utente", nullable = false, unique = true)
    private Long numeroTesseraUtente;

    public Utente(String nomeUtente, String cognomeUtente, LocalDate dataDiNascitaUtente) {
        if (nomeUtente == null || nomeUtente.isBlank())
            throw new IllegalArgumentException("Il nome utente non può essere vuoto");
        this.nomeUtente = nomeUtente;
        if (cognomeUtente == null || cognomeUtente.isBlank())
            throw new IllegalArgumentException("Il cognome utente non può essere vuoto");
        this.cognomeUtente = cognomeUtente;
        if (dataDiNascitaUtente.isBefore(LocalDate.now().minusYears(150)) || dataDiNascitaUtente.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data di nascita errata");
        this.dataDiNascitaUtente = dataDiNascitaUtente;
        this.numeroTesseraUtente = Math.abs(random.nextLong());
    }

    protected Utente() {
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        if (nomeUtente == null || nomeUtente.isBlank())
            throw new IllegalArgumentException("Il nome utente non può essere vuoto");
        this.nomeUtente = nomeUtente;
    }

    public LocalDate getDataDiNascitaUtente() {
        return dataDiNascitaUtente;
    }

    public void setDataDiNascitaUtente(LocalDate dataDiNascitaUtente) {
        if (dataDiNascitaUtente.isBefore(LocalDate.now().minusYears(150)) || dataDiNascitaUtente.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data di nascita errata");
        this.dataDiNascitaUtente = dataDiNascitaUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        if (cognomeUtente == null || cognomeUtente.isBlank())
            throw new IllegalArgumentException("Il cognome utente non può essere vuoto");
        this.cognomeUtente = cognomeUtente;
    }

    public long getNumeroTesseraUtente() {
        return numeroTesseraUtente;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", nomeUtente='" + nomeUtente + '\'' +
                ", cognomeUtente='" + cognomeUtente + '\'' +
                ", dataDiNascitaUtente=" + dataDiNascitaUtente +
                ", numeroTesseraUtente=" + numeroTesseraUtente +
                '}';
    }
}
