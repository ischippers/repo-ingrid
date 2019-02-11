package nl.ganzenbord.week3;

public class Potje {
    int i = 1, j, worp , winnaar = 0, beurt = 1, potnr, tempPositie, beurtenWachten;
    int posities [] [] = new int [4] [100];

    public int spelen (int pot, int aantalSPelers){
        while (winnaar == 0){
            System.out.println("-");

            for (i = 1; i <= aantalSPelers; i++) {
                beurtenWachten = posities [i-1] [1];
                if (beurtenWachten > 0) {
                    System.out.print("speler ("+i+"): beurtenWachten " +  beurtenWachten);
                    beurtenWachten = beurtenWachten - 1;
                    posities [i-1] [1] = beurtenWachten;
                    System.out.println(" ==> nu nog " + beurtenWachten);
                    continue;
                }
                if (posities [i-1] [2] == 1) {
                    System.out.println("speler ("+i+"): zit in de put!!)");
                    continue;
                }
                worp =  (int)(Math.random() * 6) + 1 ;
                // worp van de beurt wegschrijven
                // posities [i-1] [beurt] = worp;
                // bepaal voorlopige positie
                tempPositie = posities[i - 1][0] + worp;

                if (tempPositie%10 == 0 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " 2* aantal ogen   ==>  ");
                    tempPositie = tempPositie + worp;
                }
                if (tempPositie == 63) {
                    System.out.print("Speler ("+i+") " );
                    winnaar = i;
                    break;
                }
                // positie 6 = brug
                if (tempPositie  == 6 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = brug, naar 12    ");
                    tempPositie = 12;
                }
                // positie 31 = de put !!!
                if (tempPositie  == 31 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = de put, ");
                    // als er een andere speler in de put zit, mag die er uit!!
                    for (j = 1; j <= aantalSPelers; j++) {
                        if (posities [j-1] [2] == 1) {
                            System.out.print ("speler ("+j+"): " + " mag uit de put!!!  ==>  ");
                            posities [j-1] [2] = 0;
                        }
                    }
                    // zet de array voor de huidige speler op 1
                    posities [i-1] [2] = 1;
                }

                // positie 42 = doolhof
                if (tempPositie  == 42 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = doolhof ==>  ");
                    tempPositie = 39;
                }
                // positie 19 = herberg
                if (tempPositie  == 19 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = herberg ==>  ");
                    // 1 beurt wachten
                    posities [i-1] [1] = 1;
                }
                // positie 52 = gevangenis
                if (tempPositie  == 52 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = Gevangenis!! ==>  ");
                    // aantal beurten wachten
                    posities [i-1] [1] = 3;
                }
                if (tempPositie > 63) {
                    System.out.print("speler ("+i+"): " + tempPositie + " > 63   ==> ");
                    tempPositie = 63 - (tempPositie - 63) ;
                }
                // positie 58 = dood
                if (tempPositie  == 58 ) {
                    System.out.print("speler ("+i+"): " + tempPositie + " = dood  ==> ");
                    tempPositie = 0;
                }
                posities[i - 1][0] = tempPositie;
                System.out.println("speler ("+i+") worp: "+ worp+ ", positie: "+ posities[i - 1][0]);
            }
            beurt++;
        }
        return winnaar;
    }
}