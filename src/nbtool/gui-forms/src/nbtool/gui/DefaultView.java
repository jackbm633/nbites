/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbtool.gui;

/**
 *
 * @author pkoch
 */
public class DefaultView extends javax.swing.JPanel {

    /**
     * Creates new form DefaultView
     */
    public DefaultView() {
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

        classAndHostLabel = new javax.swing.JLabel();
        whenBlocksAndBytesLabel = new javax.swing.JLabel();
        toolStuffLabel = new javax.swing.JLabel();
        referenceLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        blockList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jsonStringTextArea = new javax.swing.JTextArea();
        saveFile = new javax.swing.JButton();

        classAndHostLabel.setText("class, from name@addr (type)");

        whenBlocksAndBytesLabel.setText("made when, total blocks, total bytes");

        toolStuffLabel.setText("nbtool version, log uid");

        referenceLabel.setText("reference info and paths");

        blockList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "blocks"));
        blockList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(blockList);

        jsonStringTextArea.setEditable(false);
        jsonStringTextArea.setColumns(20);
        jsonStringTextArea.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jsonStringTextArea.setLineWrap(true);
        jsonStringTextArea.setRows(5);
        jsonStringTextArea.setWrapStyleWord(true);
        jsonStringTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("full json serialization"));
        jScrollPane2.setViewportView(jsonStringTextArea);

        saveFile.setText("save to file");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addComponent(classAndHostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(whenBlocksAndBytesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(referenceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toolStuffLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveFile)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classAndHostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whenBlocksAndBytesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolStuffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(referenceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveFile)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> blockList;
    private javax.swing.JLabel classAndHostLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jsonStringTextArea;
    private javax.swing.JLabel referenceLabel;
    private javax.swing.JButton saveFile;
    private javax.swing.JLabel toolStuffLabel;
    private javax.swing.JLabel whenBlocksAndBytesLabel;
    // End of variables declaration//GEN-END:variables
}
