package ba.unsa.etf.rpr;

public class Ucitelj extends Nastavnik implements Slavljenik {
    public Ucitelj(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String rez = "Učitelj "+getImePrezime();
        return rez;
    }
}
