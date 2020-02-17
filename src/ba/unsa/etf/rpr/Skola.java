package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Skola {
    private List<Osoba> lista = new ArrayList<>();

    public void dodajOsobu(Osoba o) {
        lista.add(o);
    }

    @Override
    public String toString() {
        String rez = "";
        for (Osoba o : lista)
            rez += o + "\n";
        return rez;
    }

    public Set<Ucenik> ucenici() {
        TreeSet<Ucenik> rez = new TreeSet<>();
        for (Osoba o : lista)
            if (o instanceof Ucenik)
                rez.add((Ucenik)o);
        return rez;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> f) {
        ArrayList<Osoba> rez = new ArrayList<>();
        for(Osoba o: lista)
            if (f.apply(o)) rez.add(o);
        return rez;
    }

    public List<Osnovac> topOsnovac() {
        List lista = filtriraj((Osoba o) -> { return (o instanceof Osnovac && ((Osnovac) o).prosjek() >= 4);});
        return lista;
    }

    public List<Slavljenik> slavljenici() {
        List<Slavljenik> rez = new ArrayList<>();
        for (Osoba o : lista)
            if (o instanceof Srednjoskolac || o instanceof Ucitelj)
                rez.add((Slavljenik)o);
        return rez;
    }
}
