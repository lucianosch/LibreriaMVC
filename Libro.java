public class Libro {
    private String autore;
    private String titolo;
    private String genere;
    private int annoPub;
    private double prezzo;

    public Libro(String dati[]){
        autore = dati[0];
        titolo = dati[1];
        genere = dati[2];
        annoPub = Integer.valueOf(dati[3]);
        prezzo = Double.valueOf(dati[4]);
    }

    public String getAutore(){
        return autore;
    }

    public String getGenere(){
        return genere;
    }

    public String toString(){
        return String.format("[%s, %s] - %d, %.2f\n",autore,titolo,annoPub,prezzo);
    }
}
