import javax.swing.*;
import java.awt.*;

public class View
{
    //Vista: widget
    private JFrame myView;
    private JComboBox<String> cbAutori, cbGeneri;
    private JTextArea ta;
    private JScrollPane jsp;
    private JLabel lAutori, lGeneri;
    private JPanel pn;
    private Model modello; 

    View(String titolo, Model m){
        this.modello = m;
        myView = new JFrame(titolo);

        //Inizializza pannello superiore
        cbAutori = new JComboBox<String>();
        cbGeneri = new JComboBox<String>();
        lAutori = new JLabel("Autori: ");
        lGeneri = new JLabel("Generi: ");
        pn = new JPanel(new GridLayout(2,0));
        pn.add(lAutori);
        pn.add(cbAutori);
        pn.add(lGeneri);
        pn.add(cbGeneri);
        myView.add(pn, BorderLayout.NORTH);

        //Inizializza pannello centrale
        ta = new JTextArea();
        jsp = new JScrollPane();
        jsp.setViewportView(ta);
        myView.add(jsp);   
        //Operazioni finali
        myView.setSize(500,200);
        myView.setResizable(false);
        myView.setLocationRelativeTo(null);
        myView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aggiorna();
        myView.setVisible(true);
    }
    public JComboBox<String> getAutori(){
        return cbAutori;
    }
    public JComboBox<String> getGeneri(){
        return cbGeneri;
    }
    public void aggiorna(){
        for (String a : modello.getAutori())
            cbAutori.addItem(a);
        for (String g : modello.getGeneri())
            cbGeneri.addItem(g); 
        ta.setText("");
        for (String s : modello.getContent())
            ta.append(s);
    }
}