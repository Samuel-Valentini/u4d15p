package samuelvalentini.entity.pubblicazione;


import jakarta.persistence.*;
import samuelvalentini.enumeration.PeriodicitaRivista;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazione {
    @Column(name = "periodicita", nullable = false)
    @Enumerated(EnumType.STRING)
    private PeriodicitaRivista periodicita;

    public Rivista(String codiceISBN, String titolo, short annoPubblicazione, int numeroPagine, PeriodicitaRivista periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        if (periodicita == null) throw new IllegalArgumentException("La periodicità non può essere vuota");
        this.periodicita = periodicita;
    }

    protected Rivista() {
    }

    public PeriodicitaRivista getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(PeriodicitaRivista periodicita) {
        if (periodicita == null) throw new IllegalArgumentException("La periodicità non può essere vuota");
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" + super.toString() + ", " +
                "periodicita=" + periodicita +
                "} ";
    }
}
