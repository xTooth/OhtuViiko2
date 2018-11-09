package ohtu.verkkokauppa;

public class Kauppa {

    private VarastoI varasto;
    private PankkiI pankki;
    private Ostoskori ostoskori;
    private ViitI viitegeneraattori;
    private String kaupanTili;

    public Kauppa(VarastoI x, PankkiI y, ViitI z) {
        varasto = x;
        pankki = y;
        viitegeneraattori = z;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
