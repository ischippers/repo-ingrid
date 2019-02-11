package nl.ganzenbord.week3;

public class Ganzenbord {

    public int test = 0;
    public static void main(String[] args) {

        int ret;
        String label = "winnaar";

        System.out.println("Start van een nieuw potje Ganzenbord");

        Speler s1 = new Speler(1, "Raymond");
        Speler s2 = new Speler(2, "Tessa");
        Speler s3 = new Speler(3, "Anne-Dirk");
        Speler s4 = new Speler(4, "Ingrid");

        Potje p1 = new Potje ();

        ret = p1.spelen(1, 4);

        if      (ret == 1)  { label = s1.naam;}
        else if (ret == 2)  { label = s2.naam;}
        else if (ret == 3)  { label = s3.naam;}
        else if (ret == 4)  { label = s4.naam; }

        System.out.println(label + " heeft gewonnen!!" );
    }
}