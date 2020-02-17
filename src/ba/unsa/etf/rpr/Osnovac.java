package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {
    public Osnovac(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String rez = "Učenik osnovne škole " + super.toString();
        return rez;
    }
}
