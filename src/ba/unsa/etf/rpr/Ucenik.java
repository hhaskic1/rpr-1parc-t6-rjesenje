package ba.unsa.etf.rpr;

public class Ucenik extends Osoba implements Comparable<Ucenik> {
    private String brojKnjizice = "";
    private int[] ocjene = new int[100];
    private int brojOcjena = 0;

    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    public int getBrojOcjena() { return brojOcjena; }

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
        if (ocjena < 1 || ocjena > 5) throw new IlegalnaOcjena("Ilegalna ocjena " + Integer.toString(ocjena));
        if (brojOcjena >= 100)
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        ocjene[brojOcjena++] = ocjena;
    }

    public double prosjek() {
        if (brojOcjena == 0) return 0;
        double suma = 0;
        for (int i=0; i < brojOcjena; i++)
            suma += ocjene[i];
        return suma / brojOcjena;
    }

    @Override
    public int compareTo(Ucenik ucenik) {
        if (prosjek() > ucenik.prosjek()) return -1;
        if (prosjek() < ucenik.prosjek()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        String rez = getImePrezime()+" ("+ getBrojKnjizice()+"), prosjek ocjena: ";
        double zaokruzen = Math.round(prosjek() * 10);
        zaokruzen /= 10;
        rez += zaokruzen;
        return rez;
    }
}
