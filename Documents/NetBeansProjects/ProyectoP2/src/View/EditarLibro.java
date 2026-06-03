/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

public class EditarLibro extends javax.swing.JPanel {

    public EditarLibro(VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        campoBusqueda.setText("");  
        botonEditar.addActionListener(e -> botonEditarAction()); 
        cargarTabla();
    }

        void cargarTabla() {
            javax.swing.table.DefaultTableModel modelo =(javax.swing.table.DefaultTableModel) tablaLibro1.getTabla().getModel();
            modelo.setRowCount(0);
            for (Clases.Model.Libro l : Controller.ControladorView.obtenerLibros()) {
                modelo.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getEditorial(),
                    l.getAnhoDePublicacion(),
                    l.getAutor()
                });
            }
        }

        private void botonEditarAction() {
            String idStr = campoBusqueda.getText().trim();
            if (idStr.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingresá el ID del libro.");
                return;
            }
            Clases.Model.Libro libro = Controller.ControladorView.buscarLibro(idStr);
            if (libro == null) return; 

            CargarLibros formulario = new CargarLibros();
            formulario.precargarDatos(libro, this);
            ventanaPrincipal.mostrarEnCentro(formulario);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        botonEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLibro1 = new View.TablaLibro();

        jLabel1.setText("Ingrese el ID del Libro");

        campoBusqueda.setText("jTextField1");

        botonEditar.setText("Editar");

        jScrollPane2.setViewportView(tablaLibro1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(421, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private VentanaPrincipal ventanaPrincipal;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private View.TablaLibro tablaLibro1;
    // End of variables declaration//GEN-END:variables
}
