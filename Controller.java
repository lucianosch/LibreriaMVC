import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller{
    Model m;
    View v;

    public Controller(Model m, View v){
        this.m = m;
        this.v = v;
        v.init();
        assegnaGestori();
    }
    private void assegnaGestori(){

        ActionListener gestoreAutori;
        ActionListener gestoreGeneri;

        gestoreAutori = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a = (String)v.getAutori().getSelectedItem();
                m.getLibri(a,null);
                v.aggiorna();
            }
        };
        v.getAutori().addActionListener(gestoreAutori);

        gestoreGeneri = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String g = (String)v.getGeneri().getSelectedItem();
                m.getLibri(null,g);
                v.aggiorna();
            }
        };
        v.getGeneri().addActionListener(gestoreGeneri);
    }
}