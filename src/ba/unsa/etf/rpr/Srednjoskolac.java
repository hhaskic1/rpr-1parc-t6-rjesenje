package ba.unsa.etf.rpr;

public class Srednjoskolac extends Ucenik implements Slavljenik {
    private int[] ocjene2 = new int[100];
    private int brojOcjena2 = 0;

    public Srednjoskolac(String imePrezime) {
        super(imePrezime);
    }

    public void dodajOcjenuSrednja(int ocjena) throws IlegalnaOcjena {
        if (ocjena < 1 || ocjena > 5) throw new IlegalnaOcjena("Ilegalna ocjena " + Integer.toString(ocjena));
        if (brojOcjena2 >= 100)
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        ocjene2[brojOcjena2++] = ocjena;
    }

    public double prosjekSrednja() {
        if (brojOcjena2 == 0) return 0;
        double suma = 0;
        for (int i=0; i < brojOcjena2; i++)
            suma += ocjene2[i];
        return suma / brojOcjena2;
    }

    @Override
    public double prosjek() {
        if (getBrojOcjena() == 0 && brojOcjena2 == 0) return 0;
        double suma = super.prosjek() * getBrojOcjena();
        for (int i=0; i < brojOcjena2; i++)
            suma += ocjene2[i];
        return suma / ( getBrojOcjena() + brojOcjena2 );
    }

    @Override
    public String toString() {
        String rez = "Učenik srednje škole " + super.toString();
        return rez;
    }
}
