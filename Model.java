import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

class Model{
    private HashMap<String,LinkedList<Libro>> libriPerAutore, libriPerGenere;
    private LinkedList<String> content;
    private String nomeFile;

    public Model(String nFile){
        libriPerAutore = new HashMap<String,LinkedList<Libro>>();
        libriPerGenere = new HashMap<String,LinkedList<Libro>>();
        content = new LinkedList<String>();
        nomeFile = nFile;
        //Apre il file nFile (CSV) e carica l'elenco dei libri nelle due HashMap
        try{
            init();
        } catch(IOException ioe){System.out.println("Errore in lettura");}
    }

    private void addLibro(Libro a){
        if (!libriPerAutore.containsKey(a.getAutore())){
            libriPerAutore.put(a.getAutore(),new LinkedList<Libro>());
        }
        libriPerAutore.get(a.getAutore()).add(a); 
        if (!libriPerGenere.containsKey(a.getGenere())){
            libriPerGenere.put(a.getGenere(),new LinkedList<Libro>());
        }
        libriPerGenere.get(a.getGenere()).add(a);           
    }
    public LinkedList<String> getContent(){
        return content;
    }
    public Set<String> getAutori(){
        return libriPerAutore.keySet();
    }
    public Set<String> getGeneri(){
        return libriPerGenere.keySet();
    }
    private void aggiornaContent(LinkedList<Libro> t){
        content.clear();
        for (Libro l: t)
            content.add(l.toString());
    }
    public void getLibri(String a, String g){
        LinkedList<Libro> temp = new LinkedList<Libro>();
        if (a!=null){
            temp = libriPerAutore.get(a);
        }
        else if (g!=null){
            temp = libriPerGenere.get(g);
        }
        aggiornaContent(temp);
    }
    private void init() throws IOException{
        FileReader fr = null;
        BufferedReader br;
        try{
            fr = new FileReader(nomeFile);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line!=null){
                String dati[] = line.split(",");
                addLibro(new Libro(dati));
                line = br.readLine();
            }
            fr.close();
        } catch(FileNotFoundException fnfe){}
        finally{
            if (fr!=null)
                fr.close();
        }
    }
}