/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsuarioDAO;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Usuario;

/**
 *
 * @author VITOR
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
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

        jPanel1 = new javax.swing.JPanel();
        lbLogoCadastro = new javax.swing.JLabel();
        pnDados = new javax.swing.JPanel();
        lbNomeCadastro = new javax.swing.JLabel();
        lbSenhaCadastro = new javax.swing.JLabel();
        tfNomeCadastro = new javax.swing.JTextField();
        pfSenhaCadastro = new javax.swing.JPasswordField();
        tfEquipeCadastro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbTituloCadastro = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(190, 242, 191));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 10, true));

        lbLogoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logo.png"))); // NOI18N

        pnDados.setBackground(new java.awt.Color(0, 51, 51));

        lbNomeCadastro.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        lbNomeCadastro.setForeground(new java.awt.Color(255, 255, 255));
        lbNomeCadastro.setText("Nome:");

        lbSenhaCadastro.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        lbSenhaCadastro.setForeground(new java.awt.Color(255, 255, 255));
        lbSenhaCadastro.setText("Senha:");

        tfNomeCadastro.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        pfSenhaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaCadastroActionPerformed(evt);
            }
        });

        tfEquipeCadastro.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Número da Equipe:");

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEquipeCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(tfNomeCadastro)
                    .addComponent(pfSenhaCadastro))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                        .addComponent(lbNomeCadastro)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                        .addComponent(lbSenhaCadastro)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80))))
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfEquipeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbSenhaCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pfSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        lbTituloCadastro.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lbTituloCadastro.setForeground(new java.awt.Color(0, 51, 51));
        lbTituloCadastro.setText("Cadastre-se");

        btVoltar.setBackground(new java.awt.Color(0, 51, 51));
        btVoltar.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btCadastro.setBackground(new java.awt.Color(0, 51, 51));
        btCadastro.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btCadastro.setText("Cadastrar");
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTituloCadastro)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbLogoCadastro)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogoCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTituloCadastro)
                .addGap(18, 18, 18)
                .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfSenhaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSenhaCadastroActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        Usuario usuario = new Usuario(tfNomeCadastro.getText(), Integer.valueOf(tfEquipeCadastro.getText()), String.copyValueOf(pfSenhaCadastro.getPassword()));
        int criado = UsuarioDAO.getInstance().create(usuario);
        if(criado >0){
            showMessageDialog(null, "Usuário cadastrado", "", INFORMATION_MESSAGE);
        } else{
            showMessageDialog(null, "Usuário já é cadastrado", "", INFORMATION_MESSAGE);
        }
        limparCampos();
    }//GEN-LAST:event_btCadastroActionPerformed

    private void limparCampos(){
        tfNomeCadastro.setText("");
        tfEquipeCadastro.setText("");
        pfSenhaCadastro.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogoCadastro;
    private javax.swing.JLabel lbNomeCadastro;
    private javax.swing.JLabel lbSenhaCadastro;
    private javax.swing.JLabel lbTituloCadastro;
    private javax.swing.JPasswordField pfSenhaCadastro;
    private javax.swing.JPanel pnDados;
    private javax.swing.JTextField tfEquipeCadastro;
    private javax.swing.JTextField tfNomeCadastro;
    // End of variables declaration//GEN-END:variables
}
