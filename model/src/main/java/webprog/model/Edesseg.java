package webprog.model;

import org.springframework.format.annotation.DateTimeFormat;
import webprog.exceptions.InvalidGyartasEve;
import webprog.exceptions.InvalidTermekszamException;

import java.time.LocalDate;
import java.util.Collection;

public class Edesseg {
    private int gyartas_eve;
    private String termekszam;
    private String marka;
    private String ize;
    private Mennyiseg mennyiseg_tipus_szerint;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lejarat_datuma;
    private Collection<Tipus> tipus;


    public int getGyartas_eve() {
        return gyartas_eve;
    }

    public void setGyartas_eve(int gyartas_eve) throws InvalidGyartasEve {
        if (gyartas_eve > LocalDate.now().getYear()) {
            throw new InvalidGyartasEve(String.valueOf(gyartas_eve));
        }
        this.gyartas_eve = gyartas_eve;
    }

    public String getTermekszam() {
        return termekszam;
    }

    public void setTermekszam(String termekszam) throws InvalidTermekszamException {
        if (termekszam.matches("^[A-z]{3}|[0-9]-\\d\\d\\d$")) {
            this.termekszam = termekszam;
        } else {
            throw new InvalidTermekszamException(termekszam);
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getIze() {
        return ize;
    }

    public void setIze(String ize) {
        this.ize = ize;
    }

    public Mennyiseg getMennyiseg_tipus_szerint() {
        return mennyiseg_tipus_szerint;
    }

    public void setMennyiseg_tipus_szerint(Mennyiseg mennyiseg_tipus_szerint) {
        this.mennyiseg_tipus_szerint = mennyiseg_tipus_szerint;
    }

    public LocalDate getLejarat_datuma() {
        return lejarat_datuma;
    }

    public void setLejarat_datuma(LocalDate lejarat_datuma) {
        this.lejarat_datuma = lejarat_datuma;
    }

    public Collection<Tipus> getTipus() {
        return tipus;
    }

    public void setTipus(Collection<Tipus> tipus) {
        this.tipus = tipus;
    }

    public Edesseg(int gyartas_eve, String termekszam, String marka, String ize, Mennyiseg mennyiseg_tipus_szerint, LocalDate lejarat_datuma, Collection<Tipus> tipus) throws InvalidTermekszamException, InvalidGyartasEve {
        setGyartas_eve(gyartas_eve);
        setTermekszam(termekszam);
        this.setMarka(marka);
        this.setTipus(tipus);
        this.setIze(ize);
        this.setMennyiseg_tipus_szerint(mennyiseg_tipus_szerint);
        setLejarat_datuma(lejarat_datuma);
    }

    public Edesseg() {

    }

    @Override
    public String toString() {
        return "Edesseg{" +
                "gyartas_eve=" + getGyartas_eve() +
                ", termekszam='" + getTermekszam() + '\'' +
                ", marka='" + getMarka() + '\'' +
                ", ize='" + getIze() + '\'' +
                ", mennyiseg_tipus_szerint=" + getMennyiseg_tipus_szerint() +
                ", lejarat_datuma=" + getLejarat_datuma() +
                ", tipus=" + getTipus() +
                '}';
    }
}