/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class OptionsPanelMarca extends javax.swing.JPanel {
    
   private  marcaCreate MC1 = new marcaCreate();

    /**
     * Creates new form OpcionesP
     */
    public OptionsPanelMarca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        O_PanelPrimario = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        CreateB = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        FindB = new javax.swing.JButton();
        FindAllB = new javax.swing.JButton();
        PanelSecundario = new javax.swing.JPanel();

        O_PanelPrimario.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        CreateB.setText("Crear");
        CreateB.setFocusable(false);
        CreateB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBActionPerformed(evt);
            }
        });
        jToolBar1.add(CreateB);

        UpdateB.setText("Modificar");
        UpdateB.setFocusable(false);
        UpdateB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UpdateB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(UpdateB);

        DeleteB.setText("Eliminar");
        DeleteB.setFocusable(false);
        DeleteB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(DeleteB);

        FindB.setText("Buscar");
        FindB.setFocusable(false);
        FindB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FindB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(FindB);

        FindAllB.setText("Listar");
        FindAllB.setFocusable(false);
        FindAllB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FindAllB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(FindAllB);

        O_PanelPrimario.add(jToolBar1, java.awt.BorderLayout.LINE_START);

        PanelSecundario.setLayout(new javax.swing.BoxLayout(PanelSecundario, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(O_PanelPrimario, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(O_PanelPrimario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBActionPerformed
        // TODO add your handling code here:
       
        PanelSecundario.setVisible(true);
        PanelSecundario.removeAll();
        PanelSecundario.add(MC1);
        PanelSecundario.setVisible(true);
    }//GEN-LAST:event_CreateBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateB;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton FindAllB;
    private javax.swing.JButton FindB;
    private javax.swing.JPanel O_PanelPrimario;
    private javax.swing.JPanel PanelSecundario;
    private javax.swing.JButton UpdateB;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}