/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 *
 * @author Kauê
 */
public class Quiz extends javax.swing.JFrame {
    private boolean encerra;



    /**
     * Creates new form Quiz
     */

     public Quiz() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        Questions(p);
        Pontuacao(pontostotal);
         LerNomeParticipante();
        
        
       
    }
     int valor = 0;
    int p = 0;
    String opc1;
    String opc2;
    String opc3;
    String opc4;
    String correto;
    int nPulos = 0;
    boolean nCartas = false;
    boolean nPlaca = false;
    boolean nConv = false;
    int pontostotal = 0;
    
   
       
    public void Pontuacao (int pontos){
        this.pontostotal = pontos;
        Pontuacao.setText(""+pontos);
        
    }
    public void Questions(int ask){
    
    String[] asks = new String[14];    
    String[][] answer = new String[14][4];
    String[] item = new String[14];
    Math.random();
    //Pergunta
    asks[0] = "HTML é uma linguagem de...?";
    //Items - Respostas - Matriz
    answer[0][0] = "Programação";    
    answer[0][1] = "Criação";
    answer[0][2] = "Marcação";
    answer[0][3] = "Informação";
    //Item correto da questão
    item[0] = "Marcação";
    
    
    asks[1] = "Qual a melhor curso da MC?";
    answer[1][0] = "Fruticultura";    
    answer[1][1] = "Informatica";
    answer[1][2] = "ADM";
    answer[1][3] = "Finanças";
    
    item[1] = "Informatica";
    
    asks[2] = "O que faz mais raiva na sala?";
    answer[2][0] = "Henrique";    
    answer[2][1] = "Kauê";
    answer[2][2] = "Vinicius lider";
    answer[2][3] = "Lucas";
    
    item[2] = "Henrique";
    
    asks[3] = "A mais inteligente da sala é?";
    answer[3][0] = "Alicia";    
    answer[3][1] = "Alice";
    answer[3][2] = "Mônica";
    answer[3][3] = "Karol";
    
    item[3] = "Alice";
    
    asks[4] = "O mais inteligente da sala é?";
    answer[4][0] = "Vinicius Araujo";    
    answer[4][1] = "Vinicius Lider";
    answer[4][2] = "Kauê kkkkk";
    answer[4][3] = "Pedro Lucas";
    
    item[4] = "Vinicius Lider";
    
    asks[5] = "Melhor professor(a)?";
    answer[5][0] = "Vanderli";    
    answer[5][1] = "Neo";
    answer[5][2] = "Walbênio";
    answer[5][3] = "Lucélia";
    
    item[5] = "Neo";
    
    asks[5] = "2x2x2x2 é igual a? (VITORIA)";
    answer[5][0] = "4";    
    answer[5][1] = "16";
    answer[5][2] = "44";
    answer[5][3] = "8";
    
    item[5] = "4";
    
    asks[6] = "Quem da sala esconde a cara quando rir";
    answer[6][0] = "Larissa";    
    answer[6][1] = "Pedro Lucas";
    answer[6][2] = "Alice";
    answer[6][3] = "MAria Clara";
    
    item[6] = "Larissa";
    
    asks[7] = "O mais debochado da sala";
    answer[7][0] = "Tauan";    
    answer[7][1] = "Vinicius Lider";
    answer[7][2] = "Pedro Lucas";
    answer[7][3] = "Lucas";
    
    item[7] = "Tauan";
    
    asks[8] = "Quebrou o cabo da vassoura na gincana?";
    answer[8][0] = "Etero";    
    answer[8][1] = "João Victor A.";
    answer[8][2] = "João Vitor";
    answer[8][3] = "Orlando";
    
    item[8] = "Etero";
    
    asks[9] = "Qual o melhor professor do curso?";
    answer[9][0] = "Walbênio";    
    answer[9][1] = "Felipe";
    answer[9][2] = "Neo";
    answer[9][3] = "Gadelha";
    
    item[9] = "Neo";
    
    asks[10] = "Qual aluno tem nome de cidade?";
    answer[10][0] = "Pereiro";    
    answer[10][1] = "Madrid";
    answer[10][2] = "Orlando";
    answer[10][3] = "Doutor Severiano";
    
    item[10] = "Orlando";
    
    asks[11] = "É o mais pescopata da sala?";
    answer[11][0] = "Kauê";    
    answer[11][1] = "Pedro Lucas";
    answer[11][2] = "Orlando";
    answer[11][3] = "Vinicius Lider";
    
    item[11] = "Pedro Lucas";
    
    asks[12] = "Se apagar a luz nunca mais vê?";
    answer[12][0] = "Kauê";    
    answer[12][1] = "Lucas";
    answer[12][2] = "Orlando";
    answer[12][3] = "Vinicius Lider";
    
    item[12] = "Kauê";
    
    asks[13] = "Programa em HTML";
    answer[13][0] = "Alerrandro";    
    answer[13][1] = "Pedro Lucas";
    answer[13][2] = "Henrique";
    answer[13][3] = "Emilly";
    
    item[13] = "Henrique";
    
    perg.setText(asks[ask]);
    
        
    jRadioButton1.setText(answer[ask][3]);
    jRadioButton2.setText(answer[ask][1]);
    jRadioButton3.setText(answer[ask][2]);
    jRadioButton4.setText(answer[ask][0]);
    
    correto = item[ask];
    
    }
    
    
    public void PremioSeAcerta() {
        //EDITAR DE 0 PARA 1
            String arq = "src/arquivo/Premio.txt";
            File p = new File(arq);

            String text = "Você fez 14000 pontos..." ;

            try {
                FileWriter fw = new FileWriter(p);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(""+text);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }
    
    public void LerNomeParticipante() {
        
        File arquivo = new File ("src/arquivo/NomeParticipante.txt");
        
        try {
            FileReader ler = new FileReader(arquivo);
            BufferedReader lerb = new BufferedReader(ler);
            String linha = lerb.readLine();
            while(linha != null) {
                
                nome.setText("Vamos " + linha + " você Ganhará esse jogo");
                linha = lerb.readLine();
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        perg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Pontuacao = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(perg, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(perg)
                .addGap(58, 58, 58))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("PERGUNTAS");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(153, 153, 153));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(153, 153, 153));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(153, 153, 153));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("CONFIRMAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("PONTUAÇÃO");

        Pontuacao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Pontuacao.setForeground(new java.awt.Color(102, 102, 102));
        Pontuacao.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Pontuacao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Pontuacao)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(86, 86, 86)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(30, 30, 30)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        
    int c = JOptionPane.showConfirmDialog(null,"TU VAI NESSA MESMO?");

    if(c == 0){
         
        if(jRadioButton1.isSelected()){
                if(jRadioButton1.getText().equals(correto)){
                    
                    if(p == 13){
                         Pontuacao(pontostotal+1000);
                    String arq = "src/arquivo/Premio.txt";
            File p = new File(arq);

            String text = "Você Ganhou 14000 pontos" ;

            try {
                FileWriter fw = new FileWriter(p);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(""+text);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                   
                    new Pont().setVisible(true);
                    
                    dispose();
                   }else{
                    JOptionPane.showMessageDialog(null,"Acertou mizeravi");
                    p++;
                    Questions(p);
                    Pontuacao(pontostotal+1000);
                   }
                } else{
                    
                    JOptionPane.showMessageDialog(null,"Errou kkkkk");
                    JOptionPane.showMessageDialog(null,"Pontuação: "+pontostotal);
                    dispose();
                    new game().setVisible(true);
                }
        }
        
        if(jRadioButton2.isSelected()){
                if(jRadioButton2.getText().equals(correto)){
                    if(p == 13){
                    Pontuacao(pontostotal+1000);
                    String arq = "src/arquivo/Premio.txt";
            File p = new File(arq);

            String text = "Você Ganhou 14000 pontos" ;

            try {
                FileWriter fw = new FileWriter(p);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(""+text);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                   new Pont().setVisible(true);
                    dispose();
                   }else{
                    JOptionPane.showMessageDialog(null,"Acertou mizeravi");
                    p++;
                    Questions(p);
                    Pontuacao(pontostotal+1000);
                   }
                } else{
                    
                    JOptionPane.showMessageDialog(null,"Errou kkkkkk");
                    JOptionPane.showMessageDialog(null,"Pontuação: "+pontostotal);
                    new game().setVisible(true);
                    dispose();
                }
        }
         
          if(jRadioButton3.isSelected()){
                if(jRadioButton3.getText().equals(correto)){
                    if(p == 13){
                     Pontuacao(pontostotal+1000);
                    String arq = "src/arquivo/Premio.txt";
            File p = new File(arq);

            String text = "Você Ganhou 14000 pontos" ;

            try {
                FileWriter fw = new FileWriter(p);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(""+text);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                    new Pont().setVisible(true);
                    dispose();
                   }else{
                    JOptionPane.showMessageDialog(null,"Acertou mizeravi");
                    p++;
                    Questions(p);
                    Pontuacao(pontostotal+1000);
                   }
                } else{
                    
                    JOptionPane.showMessageDialog(null,"Errou kkkkkkkkkk");
                    JOptionPane.showMessageDialog(null,"Pontuação: "+pontostotal);
                    new game().setVisible(true);
                    dispose();
                }
        }
          
           if(jRadioButton4.isSelected()){
                if(jRadioButton4.getText().equals(correto)){
                   if(p == 13){
                     Pontuacao(pontostotal+1000);
                    String arq = "src/arquivo/Premio.txt";
            File p = new File(arq);

            String text = "Você ganhou "+pontostotal ;

            try {
                FileWriter fw = new FileWriter(p);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(""+text);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                    new Pont().setVisible(true);
                    dispose();
                   }else{
                    JOptionPane.showMessageDialog(null,"Acertou mizeravi");
                    p++;
                    Questions(p);
                    Pontuacao(pontostotal+1000);
                   }
                   
                } else{
                  JOptionPane.showMessageDialog(null,"Errou kkkkkkkkkk");
                    JOptionPane.showMessageDialog(null,"Pontuação: "+pontostotal);
                    new game().setVisible(true);
                    dispose();
                    
          
           
       if (encerra){
          
       
       }
        
   }
           }
    }
    buttonGroup1.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pontuacao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel perg;
    // End of variables declaration//GEN-END:variables

    private void Errou() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Acertou() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Confirmar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pontuacao(int pontuacaototal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void JDialog(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
