import java.time.LocalDate;

public class Zakaznik {
    private String jmeno;
    private LocalDate datumNarozeni;
    private String mesto;
    private int pocetProdeju;

    public Zakaznik(String jmeno, LocalDate datumNarozeni, String mesto, int pocetProdeju) throws EvidenceException {
        this.jmeno = jmeno;
        this.datumNarozeni = datumNarozeni;
        this.mesto = mesto;
        zvysPocetProdeju(pocetProdeju);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getPocetProdeju() {
        return pocetProdeju;
    }

    public void setPocetProdeju(int pocetProdeju) {
        try {
            zvysPocetProdeju(pocetProdeju);
        } catch (EvidenceException e) {
            throw new RuntimeException(e);
        }
    }

    private void zvysPocetProdeju(int pocetProdeju) throws EvidenceException {
        if (pocetProdeju < 0) {
            throw new EvidenceException("Parametr nesmí být menší jak 0!");
        } else {
            this.pocetProdeju = pocetProdeju;
        }
    }
}
