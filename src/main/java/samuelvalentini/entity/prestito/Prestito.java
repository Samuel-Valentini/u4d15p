package samuelvalentini.entity.prestito;


import jakarta.persistence.*;
import samuelvalentini.entity.pubblicazione.Pubblicazione;
import samuelvalentini.entity.utente.Utente;

import java.time.LocalDate;
import java.util.UUID;

@Entity

@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_prestito")
    private UUID idPrestito;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_pubblicazione", nullable = false)
    private Pubblicazione pubblicazione;

    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate dataDiInizioPrestito;

    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataDiRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataDiRestituzioneEffettiva;

    public Prestito(Utente utente, Pubblicazione pubblicazione) {
        if (utente == null) throw new IllegalArgumentException("L'utente non può essere null");
        this.utente = utente;
        if (pubblicazione == null) throw new IllegalArgumentException("La pubblicazione non può essere null");
        this.pubblicazione = pubblicazione;
        this.dataDiInizioPrestito = LocalDate.now();
        this.dataDiRestituzionePrevista = LocalDate.now().plusDays(30);
    }

    protected Prestito() {
    }

    public UUID getIdPrestito() {
        return idPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public Pubblicazione getPubblicazione() {
        return pubblicazione;
    }

    public LocalDate getDataDiInizioPrestito() {
        return dataDiInizioPrestito;
    }

    public LocalDate getDataDiRestituzionePrevista() {
        return dataDiRestituzionePrevista;
    }

    public void setDataDiRestituzionePrevista(LocalDate dataDiRestituzionePrevista) {
        //lo lascio in caso di prolungamento del prestito
        this.dataDiRestituzionePrevista = dataDiRestituzionePrevista;
    }

    public LocalDate getDataDiRestituzioneEffettiva() {
        return dataDiRestituzioneEffettiva;
    }

    public void setDataDiRestituzioneEffettiva(LocalDate dataDiRestituzioneEffettiva) {
        this.dataDiRestituzioneEffettiva = dataDiRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "-- Prestito{" +
                "idPrestito=" + idPrestito +
                ", utente=" + utente +
                "Pubblicazione=" + pubblicazione +
                "DataDiInizioPrestito=" + dataDiInizioPrestito +
                ", dataDiRestituzionePrevista=" + dataDiRestituzionePrevista +
                ", dataDiRestituzioneEffettiva=" + dataDiRestituzioneEffettiva +
                "} \n";
    }
}
