package ba.unsa.etf.rpr;

public class NastavnikOsnovneSkole extends Nastavnik {
    public NastavnikOsnovneSkole(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String rez = "Nastavnik osnovne škole "+getImePrezime();
        return rez;
    }
}
