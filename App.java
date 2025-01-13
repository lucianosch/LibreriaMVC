public class App {
    public static void main(String[] args) throws Exception {
        Model myModel = new Model("elencoLibri.csv");
        View myView = new View("Libreria", myModel);
        new Controller(myModel,myView);
        myView.aggiorna();
    }
}
