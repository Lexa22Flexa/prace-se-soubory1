import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceZakazniku {
    private List<Zakaznik> evidence = new ArrayList<>();

    public List<Zakaznik> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<Zakaznik> evidence) {
        this.evidence = evidence;
    }

    public void pridejZakazniky(Zakaznik zakaznik) {
        evidence.add(zakaznik);
    }

    public void odeberZakaznika() {
        evidence.removeLast();
    }

    public void nactiZakazniky(String nazevSouboru, String oddelovac) throws EvidenceException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("resources/" + nazevSouboru)))) {
            while(scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                pridejZakazniky(parseZakaznik(radek, oddelovac));
            }
        } catch (FileNotFoundException ex) {
            throw new EvidenceException("Soubor" + nazevSouboru + "nebyl nalezen: " + ex.getLocalizedMessage());
        }
    }

    private Zakaznik parseZakaznik(String radek, String oddelovac) {
        String [] polozky = radek.split(oddelovac);
        if (polozky.length != 4) {
            throw new EvidenceException("Chybný počet položek!");
        }
        String jmeno = polozky[0].trim();
        LocalDate datumNarozeni = LocalDate.parse(polozky[1].trim());
        String mesto = polozky[2].trim();
        int pocetProdeju = Integer.parseInt(polozky[3].trim());
        return new Zakaznik(jmeno, datumNarozeni, mesto, pocetProdeju);
    }

    private void zapisDoKolekce(String nazevSouboru, String oddelovac) throws EvidenceException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("resources/" + nazevSouboru)))) {
            //DODĚLAT
        } catch (IOException e) {
            throw new EvidenceException("DOPSAT");
        }
    }

    public void analyzaDat() {
        int limit = 20;
        for (Zakaznik zakaznik : evidence) {
            if (zakaznik.getPocetProdeju() < limit) {
                evidence.remove(zakaznik);
            }
        }
    }

    public int prumernyPocetProdejuUH() {
        int celkem = 0;
        int pocetUH = 0;
        for (Zakaznik zakaznik : evidence) {
            if (zakaznik.getMesto().equals("Uherské Hradiště")) {
                celkem += zakaznik.getPocetProdeju();
                pocetUH += 1;
            }
        }
        int prumerUH = 0;

        if (pocetUH != 0) {
            prumerUH = celkem/pocetUH;
        }
        return prumerUH;
    }




}
