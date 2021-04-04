package src.Presentacion.Vistas;

import src.Negocio.SAFactory;
import src.Negocio.SAVideojuego;
import src.Negocio.TVideojuego;

import java.util.ArrayList;

public class ListaVideojuegosGUI extends javax.swing.JFrame {

    /**
     * Creates new form src.Vista.ListaVideoJuegos
     */
    public ListaVideojuegosGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Videojuegos");

        SAVideojuego saVideojuego = SAFactory.getInstance().crearSAVideojuego();
        ArrayList<TVideojuego> tVideojuegos;
        try {
            tVideojuegos = saVideojuego.listarVideojuegos();
            ModeloListaVideojuego model = new ModeloListaVideojuego(tVideojuegos);
            jList1.setModel(model);
        } catch (Exception e) {
            tVideojuegos = new ArrayList<TVideojuego>();
        }

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
