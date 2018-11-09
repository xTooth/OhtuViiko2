package ohtu.verkkokauppa;

public class Pankki implements PankkiI{

    private KirjanpitoI kirjanpito;

    public Pankki(KirjanpitoI x) {

        kirjanpito = x;
    }
    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tililta + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
