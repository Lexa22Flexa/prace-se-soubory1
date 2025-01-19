import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EvidenceZakazniku evidenceZakazniku = new EvidenceZakazniku();
        evidenceZakazniku.pridejZakazniky(new Zakaznik("Jarda", LocalDate.of(2005, 2, 2), "Uherské Hradiště", 2));
        evidenceZakazniku.pridejZakazniky(new Zakaznik("Kovář", LocalDate.of(2006, 3,3), "Brno", 6));
        evidenceZakazniku.odeberPoslednihoZakaznika();
        evidenceZakazniku.nactiZakazniky("zakaznici.txt", ":");

        evidenceZakazniku.vypisVsechnaData();
        evidenceZakazniku.zapisDoKolekce("kolekce.txt", ":");

        System.out.println(evidenceZakazniku.prumernyPocetProdejuUH());

        System.out.println(evidenceZakazniku.getZakazniciNadLimit().size());
    }
}