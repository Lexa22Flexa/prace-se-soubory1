import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EvidenceZakazniku evidenceZakazniku = new EvidenceZakazniku();
        evidenceZakazniku.pridejZakazniky(new Zakaznik("Jarda", LocalDate.of(2005, 2, 2), "Uherské Hradiště", 6));
        evidenceZakazniku.pridejZakazniky(new Zakaznik("Kovář", LocalDate.of(2006, 3,3), "Brno", 6));
        evidenceZakazniku.odeberZakaznika();
        evidenceZakazniku.nactiZakazniky("zakaznici.txt", ":");
        System.out.println(evidenceZakazniku.getEvidence().get(1).getMesto());
        System.out.println(evidenceZakazniku.prumernyPocetProdejuUH());
    }
}