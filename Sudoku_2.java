import java.awt.Color;
import static java.awt.Color.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HARISH KUMAR
 */
public class Sudoku_2 extends javax.swing.JFrame {

    /**
     * Creates new form Sudoku_2
     */
    private JButton prev = null;
    private String turn = "";
    private boolean easy_flag,med_flag,hard_flag;
    private boolean easy_sol_flag,med_sol_flag,hard_sol_flag;
    private int checkno = 3;
    private String easy1[][] = {{"1","","","","","7","8","3",""},
                               {"","8","7","","3","9","","","2"},
                               {"","","","1","","","","","9"},
                               {"","6","2","","","","","1",""},
                               {"5","","3","4","","2","9","","6"},
                               {"","1","","","","","2","7",""},
                               {"6","","","","","4","","",""},
                               {"7","","","6","2","","4","9",""},
                               {"","4","9","7","","","","","8"}};
    
    private String easysol[][] = {{"1","9","6","2","4","7","8","3","5"},
                                  {"4","8","7","5","3","9","1","6","2"},
                                  {"2","3","5","1","8","6","7","4","9"},
                                  {"9","6","2","3","7","8","5","1","4"},
                                  {"5","7","3","4","1","2","9","8","6"},
                                  {"8","1","4","9","6","5","2","7","3"},
                                  {"6","2","1","8","9","4","3","5","7"},
                                  {"7","5","8","6","2","3","4","9","1"},
                                  {"3","4","9","7","5","1","6","2","8"}};
    
    private String hard1[][] = {{"8","","","6","","","7","1","2"},
                                 {"","3","","","","1","","",""},
                                 {"6","","","","2","","","",""},
                                 {"","","8","","","","5","",""},
                                 {"","","","3","","8","","",""},
                                 {"","","1","","","","3","",""},
                                 {"","","","","9","","","","6"},
                                 {"","","","8","","","","5",""},
                                 {"5","8","4","","","3","","","7"}};
    
    private String hardsol[][] = {{"8","4","9","6","3","5","7","1","2"},
                                  {"2","3","7","9","8","1","4","6","5"},
                                  {"6","1","5","4","2","7","9","3","8"},
                                  {"3","6","8","7","1","9","5","2","4"},
                                  {"4","9","2","3","5","8","6","7","1"},
                                  {"7","5","1","2","4","6","3","8","9"},
                                  {"1","7","3","5","9","2","8","4","6"},
                                  {"9","2","6","8","7","4","1","5","3"},
                                  {"5","8","4","1","6","3","2","9","7"}};
    
    private String medium1[][] = {{"8","","6","","","","","","9"},
                                 {"","","9","6","","","","5","4"},
                                 {"","","","","","8","3","7",""},
                                 {"1","","2","9","","","","",""},
                                 {"4","","","","5","","","","1"},
                                 {"","","","","","3","5","","2"},
                                 {"","3","8","7","","","","",""},
                                 {"5","6","","","","9","4","",""},
                                 {"7","","","","","","9","","8"}};
    
    private String mediumsol[][] = {{"8","4","6","3","7","5","1","2","9"},
                                     {"3","7","9","6","1","2","8","5","4"},
                                     {"2","1","5","4","9","8","3","7","6"},
                                     {"1","5","2","9","6","4","7","8","3"},
                                     {"4","8","3","2","5","7","6","9","1"},
                                     {"6","9","7","1","8","3","5","4","2"},
                                     {"9","3","8","7","4","1","2","6","5"},
                                     {"5","6","1","8","2","9","4","3","7"},
                                     {"7","2","4","5","3","6","9","1","8"}};
    public Sudoku_2() {
        initComponents();
    }
    private boolean compare(String[][] arr){
        JButton btns[][] =     {{b11,b12,b13,b14,b15,b16,b17,b18,b19},
                                {b21,b22,b23,b24,b25,b26,b27,b28,b29},
                                {b31,b32,b33,b34,b35,b36,b37,b38,b39},
                                {b41,b42,b43,b44,b45,b46,b47,b48,b49},
                                {b51,b52,b53,b54,b55,b56,b57,b58,b59},
                                {b61,b62,b63,b64,b65,b66,b67,b68,b69},
                                {b71,b72,b73,b74,b75,b76,b77,b78,b79},
                                {b81,b82,b83,b84,b85,b86,b87,b88,b89},
                                {b91,b92,b93,b94,b95,b96,b97,b98,b99}};
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9;j++){
                if(!btns[i][j].getText().equals(arr[i][j])) return false;
            }
        }
        return true;
    }
    private void checkfun(String[][] arr){
        JButton btns[][] =     {{b11,b12,b13,b14,b15,b16,b17,b18,b19},
                                {b21,b22,b23,b24,b25,b26,b27,b28,b29},
                                {b31,b32,b33,b34,b35,b36,b37,b38,b39},
                                {b41,b42,b43,b44,b45,b46,b47,b48,b49},
                                {b51,b52,b53,b54,b55,b56,b57,b58,b59},
                                {b61,b62,b63,b64,b65,b66,b67,b68,b69},
                                {b71,b72,b73,b74,b75,b76,b77,b78,b79},
                                {b81,b82,b83,b84,b85,b86,b87,b88,b89},
                                {b91,b92,b93,b94,b95,b96,b97,b98,b99}};
        for(int i = 0 ; i < 9;i++){
            for(int j = 0; j < 9;j++){
                if(btns[i][j].getText().equals("")||(btns[i][j].getBackground().equals(black))) continue;
                if(btns[i][j].getText().equals(arr[i][j])){
                    btns[i][j].setBackground(green);
                }
            }
        }
    }
    private void change(String[][] arr){
        JButton btns[][] =     {{b11,b12,b13,b14,b15,b16,b17,b18,b19},
                                {b21,b22,b23,b24,b25,b26,b27,b28,b29},
                                {b31,b32,b33,b34,b35,b36,b37,b38,b39},
                                {b41,b42,b43,b44,b45,b46,b47,b48,b49},
                                {b51,b52,b53,b54,b55,b56,b57,b58,b59},
                                {b61,b62,b63,b64,b65,b66,b67,b68,b69},
                                {b71,b72,b73,b74,b75,b76,b77,b78,b79},
                                {b81,b82,b83,b84,b85,b86,b87,b88,b89},
                                {b91,b92,b93,b94,b95,b96,b97,b98,b99}};
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j] != ""){
                    String s = arr[i][j];
                    btns[i][j].setText(s);
                    btns[i][j].setBackground(black);
                    btns[i][j].setForeground(white);
                }
                else{
                    btns[i][j].setBackground(null);
                    btns[i][j].setText("");
                }
            }
        }
    }
    private void change1(String[][] arr){
        JButton btns[][] =     {{b11,b12,b13,b14,b15,b16,b17,b18,b19},
                                {b21,b22,b23,b24,b25,b26,b27,b28,b29},
                                {b31,b32,b33,b34,b35,b36,b37,b38,b39},
                                {b41,b42,b43,b44,b45,b46,b47,b48,b49},
                                {b51,b52,b53,b54,b55,b56,b57,b58,b59},
                                {b61,b62,b63,b64,b65,b66,b67,b68,b69},
                                {b71,b72,b73,b74,b75,b76,b77,b78,b79},
                                {b81,b82,b83,b84,b85,b86,b87,b88,b89},
                                {b91,b92,b93,b94,b95,b96,b97,b98,b99}};
        for(int i = 0; i< 9;i++){
            for(int j = 0;j < 9;j++){
                if(btns[i][j].getBackground().equals(black)) continue;
                else {
                    String s = arr[i][j];
                    btns[i][j].setText(s);
                    btns[i][j].setBackground(yellow);
                    btns[i][j].setForeground(black);
                }
            }
        }
    }
    
    private void Select(JButton btn){
        prev.setBackground(black);
        prev.setForeground(white);
        btn.setBackground(gray);
        btn.setForeground(black);
        prev = btn;
        turn = btn.getText();
    }
    
    private void text(JButton btn){
        if((easy_flag == easy_sol_flag)&&(easy_flag == true) || (med_flag == med_sol_flag)&&(med_flag == true) || (hard_flag == hard_sol_flag)&&(hard_flag == true))
            return;
        if((easy_flag == true)&& (easy.getBackground().equals(green)) || (med_flag == true)&& medium.getBackground().equals(green)||(hard_flag == true)&& hard.getBackground().equals(green))
            return;
        if((easy_flag == true)&& (easy.getBackground().equals(red)) || (med_flag == true)&& medium.getBackground().equals(red)||(hard_flag == true)&& hard.getBackground().equals(red))
            return;
        if(btn.getBackground().equals(black)|| turn == "") return;
        if(easy_flag == med_flag && med_flag == hard_flag && easy_flag == false)return;
        btn.setText(turn);
        btn.setBackground( yellow);
        btn.setForeground(black);
    }
    
    private void subcheck(){
        if(easy_flag){
            if(compare(easysol) == true){
                JOptionPane.showMessageDialog(this,"Hurray! You won.");
                easy.setBackground(green);
            }else{
                JOptionPane.showMessageDialog(this,"Not correct!\nTry again");
                change(easy1);
            }
        }else if(med_flag){
            if(compare(mediumsol) == true){
                JOptionPane.showMessageDialog(this,"Hurray! You won.");
                medium.setBackground(green);
            }else{
                JOptionPane.showMessageDialog(this,"Not correct!\nTry again");
                change(medium1);
            }
        }else if(hard_flag){
            if(compare(hardsol) == true){
                JOptionPane.showMessageDialog(this,"Hurray! You won.");
                hard.setBackground(green);
            }else{
                JOptionPane.showMessageDialog(this,"Not correct!\nTry again");
                change(hard1);
            }
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

        jPanel1 = new javax.swing.JPanel();
        b12 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b22 = new javax.swing.JButton();
        b23 = new javax.swing.JButton();
        b31 = new javax.swing.JButton();
        b32 = new javax.swing.JButton();
        b33 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        b15 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b24 = new javax.swing.JButton();
        b25 = new javax.swing.JButton();
        b26 = new javax.swing.JButton();
        b34 = new javax.swing.JButton();
        b35 = new javax.swing.JButton();
        b36 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        b27 = new javax.swing.JButton();
        b28 = new javax.swing.JButton();
        b29 = new javax.swing.JButton();
        b37 = new javax.swing.JButton();
        b38 = new javax.swing.JButton();
        b39 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        b48 = new javax.swing.JButton();
        b49 = new javax.swing.JButton();
        b47 = new javax.swing.JButton();
        b57 = new javax.swing.JButton();
        b58 = new javax.swing.JButton();
        b59 = new javax.swing.JButton();
        b67 = new javax.swing.JButton();
        b68 = new javax.swing.JButton();
        b69 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        b45 = new javax.swing.JButton();
        b46 = new javax.swing.JButton();
        b44 = new javax.swing.JButton();
        b54 = new javax.swing.JButton();
        b55 = new javax.swing.JButton();
        b56 = new javax.swing.JButton();
        b64 = new javax.swing.JButton();
        b65 = new javax.swing.JButton();
        b66 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        b42 = new javax.swing.JButton();
        b43 = new javax.swing.JButton();
        b41 = new javax.swing.JButton();
        b51 = new javax.swing.JButton();
        b52 = new javax.swing.JButton();
        b53 = new javax.swing.JButton();
        b61 = new javax.swing.JButton();
        b62 = new javax.swing.JButton();
        b63 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        b72 = new javax.swing.JButton();
        b73 = new javax.swing.JButton();
        b71 = new javax.swing.JButton();
        b81 = new javax.swing.JButton();
        b82 = new javax.swing.JButton();
        b83 = new javax.swing.JButton();
        b91 = new javax.swing.JButton();
        b92 = new javax.swing.JButton();
        b93 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        b75 = new javax.swing.JButton();
        b76 = new javax.swing.JButton();
        b74 = new javax.swing.JButton();
        b84 = new javax.swing.JButton();
        b85 = new javax.swing.JButton();
        b86 = new javax.swing.JButton();
        b94 = new javax.swing.JButton();
        b95 = new javax.swing.JButton();
        b96 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        b78 = new javax.swing.JButton();
        b79 = new javax.swing.JButton();
        b77 = new javax.swing.JButton();
        b87 = new javax.swing.JButton();
        b88 = new javax.swing.JButton();
        b89 = new javax.swing.JButton();
        b97 = new javax.swing.JButton();
        b98 = new javax.swing.JButton();
        b99 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        easy = new javax.swing.JButton();
        hard = new javax.swing.JButton();
        medium = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        solution = new javax.swing.JButton();
        check = new javax.swing.JButton();
        s1 = new javax.swing.JButton();
        s2 = new javax.swing.JButton();
        s3 = new javax.swing.JButton();
        s7 = new javax.swing.JButton();
        s6 = new javax.swing.JButton();
        s4 = new javax.swing.JButton();
        s5 = new javax.swing.JButton();
        s8 = new javax.swing.JButton();
        s9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setBackground(new java.awt.Color(164, 129, 145));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });

        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });

        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });

        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });

        b22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22ActionPerformed(evt);
            }
        });

        b23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b23ActionPerformed(evt);
            }
        });

        b31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b31ActionPerformed(evt);
            }
        });

        b32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b32ActionPerformed(evt);
            }
        });

        b33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });

        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });

        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        b24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24ActionPerformed(evt);
            }
        });

        b25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b25ActionPerformed(evt);
            }
        });

        b26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b26ActionPerformed(evt);
            }
        });

        b34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b34ActionPerformed(evt);
            }
        });

        b35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b35ActionPerformed(evt);
            }
        });

        b36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });

        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });

        b27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b27ActionPerformed(evt);
            }
        });

        b28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b28ActionPerformed(evt);
            }
        });

        b29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b29ActionPerformed(evt);
            }
        });

        b37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b37ActionPerformed(evt);
            }
        });

        b38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b38ActionPerformed(evt);
            }
        });

        b39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(b27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(b37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b48ActionPerformed(evt);
            }
        });

        b49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b49ActionPerformed(evt);
            }
        });

        b47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b47ActionPerformed(evt);
            }
        });

        b57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b57ActionPerformed(evt);
            }
        });

        b58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b58ActionPerformed(evt);
            }
        });

        b59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b59ActionPerformed(evt);
            }
        });

        b67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b67ActionPerformed(evt);
            }
        });

        b68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b68ActionPerformed(evt);
            }
        });

        b69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b69ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(b47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(b57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(b67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b68, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b69, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b68, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b69, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b45ActionPerformed(evt);
            }
        });

        b46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b46ActionPerformed(evt);
            }
        });

        b44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b44ActionPerformed(evt);
            }
        });

        b54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b54ActionPerformed(evt);
            }
        });

        b55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b55ActionPerformed(evt);
            }
        });

        b56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b56ActionPerformed(evt);
            }
        });

        b64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b64ActionPerformed(evt);
            }
        });

        b65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b65ActionPerformed(evt);
            }
        });

        b66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b66ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(b44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(b54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(b64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b42ActionPerformed(evt);
            }
        });

        b43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b43ActionPerformed(evt);
            }
        });

        b41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b41ActionPerformed(evt);
            }
        });

        b51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b51ActionPerformed(evt);
            }
        });

        b52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b52ActionPerformed(evt);
            }
        });

        b53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b53ActionPerformed(evt);
            }
        });

        b61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b61ActionPerformed(evt);
            }
        });

        b62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b62ActionPerformed(evt);
            }
        });

        b63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b63ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(b41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(b51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(b61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b72ActionPerformed(evt);
            }
        });

        b73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b73ActionPerformed(evt);
            }
        });

        b71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b71ActionPerformed(evt);
            }
        });

        b81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b81ActionPerformed(evt);
            }
        });

        b82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b82ActionPerformed(evt);
            }
        });

        b83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b83ActionPerformed(evt);
            }
        });

        b91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b91ActionPerformed(evt);
            }
        });

        b92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b92ActionPerformed(evt);
            }
        });

        b93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b93ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(b71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(b81, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b82, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b83, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(b91, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b92, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b93, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b81, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b82, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b83, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b91, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b92, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b93, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b75ActionPerformed(evt);
            }
        });

        b76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b76ActionPerformed(evt);
            }
        });

        b74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b74ActionPerformed(evt);
            }
        });

        b84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b84ActionPerformed(evt);
            }
        });

        b85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b85ActionPerformed(evt);
            }
        });

        b86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b86ActionPerformed(evt);
            }
        });

        b94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b94ActionPerformed(evt);
            }
        });

        b95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b95ActionPerformed(evt);
            }
        });

        b96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b96ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(b74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(b84, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b85, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b86, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(b94, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b95, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b96, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b84, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b85, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b86, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b94, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b95, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b96, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b78ActionPerformed(evt);
            }
        });

        b79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b79ActionPerformed(evt);
            }
        });

        b77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b77ActionPerformed(evt);
            }
        });

        b87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b87ActionPerformed(evt);
            }
        });

        b88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b88ActionPerformed(evt);
            }
        });

        b89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b89ActionPerformed(evt);
            }
        });

        b97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b97ActionPerformed(evt);
            }
        });

        b98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b98ActionPerformed(evt);
            }
        });

        b99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b99ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(b77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b78, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b79, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(b87, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b88, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b89, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(b97, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b98, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b99, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b78, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b79, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b87, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b88, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b89, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b97, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b98, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b99, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(164, 129, 145));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("MV Boli", 3, 36)); // NOI18N
        jLabel1.setText("Sudoku");

        easy.setBackground(new java.awt.Color(255, 255, 102));
        easy.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        easy.setText("EASY");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });

        hard.setBackground(new java.awt.Color(255, 255, 102));
        hard.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        hard.setText("HARD");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });

        medium.setBackground(new java.awt.Color(255, 255, 102));
        medium.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        medium.setText("MEDIUM");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(102, 255, 51));
        submit.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(medium)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submit)
                            .addComponent(hard))))
                .addGap(54, 54, 54))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submit))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(easy)
                            .addComponent(medium)
                            .addComponent(hard))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(164, 129, 145));

        reset.setBackground(new java.awt.Color(102, 255, 51));
        reset.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 51, 51));
        exit.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        solution.setBackground(new java.awt.Color(51, 153, 255));
        solution.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        solution.setForeground(new java.awt.Color(255, 255, 255));
        solution.setText("SOLUTION");
        solution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(153, 153, 0));
        check.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setText("CHECK");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        s1.setBackground(new java.awt.Color(0, 0, 0));
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setText("1");
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });

        s2.setBackground(new java.awt.Color(0, 0, 0));
        s2.setForeground(new java.awt.Color(255, 255, 255));
        s2.setText("2");
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });

        s3.setBackground(new java.awt.Color(0, 0, 0));
        s3.setForeground(new java.awt.Color(255, 255, 255));
        s3.setText("3");
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });

        s7.setBackground(new java.awt.Color(0, 0, 0));
        s7.setForeground(new java.awt.Color(255, 255, 255));
        s7.setText("7");
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });

        s6.setBackground(new java.awt.Color(0, 0, 0));
        s6.setForeground(new java.awt.Color(255, 255, 255));
        s6.setText("6");
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });

        s4.setBackground(new java.awt.Color(0, 0, 0));
        s4.setForeground(new java.awt.Color(255, 255, 255));
        s4.setText("4");
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });

        s5.setBackground(new java.awt.Color(0, 0, 0));
        s5.setForeground(new java.awt.Color(255, 255, 255));
        s5.setText("5");
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });

        s8.setBackground(new java.awt.Color(0, 0, 0));
        s8.setForeground(new java.awt.Color(255, 255, 255));
        s8.setText("8");
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });

        s9.setBackground(new java.awt.Color(0, 0, 0));
        s9.setForeground(new java.awt.Color(255, 255, 255));
        s9.setText("9");
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(solution)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(exit)
                    .addComponent(solution)
                    .addComponent(check))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardActionPerformed
        // TODO add your handling code here:
        if(hard_sol_flag){
            JOptionPane.showMessageDialog(this, "You have seen the solution.\nYou lost!","SUSOKU PUZZLE",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Do you want to switch level?\n All your progress will be lost.", "SUDOKU PUZZLE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            hard_flag = true;
            easy_flag = med_flag = false;
            change(hard1);
        }
        checkno = 3;
    }//GEN-LAST:event_hardActionPerformed

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumActionPerformed
        // TODO add your handling code here:
        if(med_sol_flag){
            JOptionPane.showMessageDialog(this, "You have seen the solution.\nYou lost!","SUSOKU PUZZLE",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Do you want to switch level? \n All your progress will be lost.", "SUDOKU PUZZLE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            med_flag = true;
            easy_flag = hard_flag = false;
            change(medium1);
        }
        checkno = 3;
    }//GEN-LAST:event_mediumActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Do you want to reset?\nAll your progress will be lost", "SUDOKU PUZZLE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            if(easy_flag) change(easy1);
            else if(med_flag) change(medium1);
            else if(hard_flag) change(hard1);
        }
    }//GEN-LAST:event_resetActionPerformed

    private void easyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyActionPerformed
        // TODO add your handling code here:
        if(easy_sol_flag){
            JOptionPane.showMessageDialog(this, "You have seen the solution.\nYou lost!","SUSOKU PUZZLE",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Do you want to switch level?\n All your progress will be lost.", "SUDOKU PUZZLE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            easy_flag = true;
            med_flag = hard_flag = false;
            change(easy1);
        }
        checkno = 3;
    }//GEN-LAST:event_easyActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Confirm if you want to exit?", "SUDOKU PUZZle", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s8);
        }
        else{
            prev = s8;
            s8.setBackground(gray);
            s8.setForeground(black);
            turn = s8.getText();
        }    
    }//GEN-LAST:event_s8ActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s1);
        }
        else{
            prev = s1;
            s1.setBackground(gray);
            s1.setForeground(black);
            turn = s1.getText();
        }                    
    }//GEN-LAST:event_s1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s2);
        }
        else{
            prev = s2;
            s2.setBackground(gray);
            s2.setForeground(black);
            turn = s2.getText();
        }    
    }//GEN-LAST:event_s2ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s3);
        }
        else{
            prev = s3;
            s3.setBackground(gray);
            s3.setForeground(black);
            turn = s3.getText();
        }    
    }//GEN-LAST:event_s3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s4);
        }
        else{
            prev = s4;
            s4.setBackground(gray);
            s4.setForeground(black);
            turn = s4.getText();
        }    
    }//GEN-LAST:event_s4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s5);
        }
        else{
            prev = s5;
            s5.setBackground(gray);
            s5.setForeground(black);
            turn = s5.getText();
        }    
    }//GEN-LAST:event_s5ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s6);
        }
        else{
            prev = s6;
            s6.setBackground(gray);
            s6.setForeground(black);
            turn = s6.getText();
        }    
    }//GEN-LAST:event_s6ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s7);
        }
        else{
            prev = s7;
            s7.setBackground(gray);
            s7.setForeground(black);
            turn = s7.getText();
        }    
    }//GEN-LAST:event_s7ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
        if(prev != null){
            Select(s9);
        }
        else{
            prev = s9;
            s9.setBackground(gray);
            s9.setForeground(black);
            turn = s9.getText();
        }    
    }//GEN-LAST:event_s9ActionPerformed

    private void solutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "If you see the solution you will loose!", "SUDOKU PUZZLE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            if(easy_flag){
                change1(easysol);
                easy_sol_flag = true;
                easy.setBackground(red);
                easy.setForeground(white);
            }else if(med_flag){
                change1(mediumsol);
                med_sol_flag = true;
                medium.setBackground(red);
                medium.setForeground(white);
            }
            else if(hard_flag){
                change1(hardsol);
                hard_sol_flag = true;
                hard.setBackground(red);
                hard.setForeground(white);
            }
        }
    }//GEN-LAST:event_solutionActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
        // TODO add your handling code here:
        text(b11);
    }//GEN-LAST:event_b11ActionPerformed

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
        // TODO add your handling code here:
        text(b12);
    }//GEN-LAST:event_b12ActionPerformed

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13ActionPerformed
        // TODO add your handling code here:
        text(b13);
    }//GEN-LAST:event_b13ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
        // TODO add your handling code here:
        text(b14);
    }//GEN-LAST:event_b14ActionPerformed

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15ActionPerformed
        // TODO add your handling code here:
        text(b15);
    }//GEN-LAST:event_b15ActionPerformed

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16ActionPerformed
        // TODO add your handling code here:
        text(b16);
    }//GEN-LAST:event_b16ActionPerformed

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b17ActionPerformed
        // TODO add your handling code here:
        text(b17);
    }//GEN-LAST:event_b17ActionPerformed

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
        // TODO add your handling code here:
        text(b18);
    }//GEN-LAST:event_b18ActionPerformed

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19ActionPerformed
        // TODO add your handling code here:
        text(b19);
    }//GEN-LAST:event_b19ActionPerformed

    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21ActionPerformed
        // TODO add your handling code here:
        text(b21);
    }//GEN-LAST:event_b21ActionPerformed

    private void b22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b22ActionPerformed
        // TODO add your handling code here:
        text(b22);
    }//GEN-LAST:event_b22ActionPerformed

    private void b23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b23ActionPerformed
        // TODO add your handling code here:
        text(b23);
    }//GEN-LAST:event_b23ActionPerformed

    private void b24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b24ActionPerformed
        // TODO add your handling code here:
        text(b24);
    }//GEN-LAST:event_b24ActionPerformed

    private void b25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b25ActionPerformed
        // TODO add your handling code here:
        text(b25);
    }//GEN-LAST:event_b25ActionPerformed

    private void b26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b26ActionPerformed
        // TODO add your handling code here:
        text(b26);
    }//GEN-LAST:event_b26ActionPerformed

    private void b27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b27ActionPerformed
        // TODO add your handling code here:
        text(b27);
    }//GEN-LAST:event_b27ActionPerformed

    private void b28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b28ActionPerformed
        // TODO add your handling code here:
        text(b28);
    }//GEN-LAST:event_b28ActionPerformed

    private void b29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b29ActionPerformed
        // TODO add your handling code here:
        text(b29);
    }//GEN-LAST:event_b29ActionPerformed

    private void b31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b31ActionPerformed
        // TODO add your handling code here:
        text(b31);
    }//GEN-LAST:event_b31ActionPerformed

    private void b32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b32ActionPerformed
        // TODO add your handling code here:
        text(b32);
    }//GEN-LAST:event_b32ActionPerformed

    private void b33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b33ActionPerformed
        // TODO add your handling code here:
        text(b33);
    }//GEN-LAST:event_b33ActionPerformed

    private void b34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b34ActionPerformed
        // TODO add your handling code here:
        text(b34);
    }//GEN-LAST:event_b34ActionPerformed

    private void b35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b35ActionPerformed
        // TODO add your handling code here:
        text(b35);
    }//GEN-LAST:event_b35ActionPerformed

    private void b36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b36ActionPerformed
        // TODO add your handling code here:
        text(b36);
    }//GEN-LAST:event_b36ActionPerformed

    private void b37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b37ActionPerformed
        // TODO add your handling code here:
        text(b37);
    }//GEN-LAST:event_b37ActionPerformed

    private void b38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b38ActionPerformed
        // TODO add your handling code here:
        text(b38);
    }//GEN-LAST:event_b38ActionPerformed

    private void b39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b39ActionPerformed
        // TODO add your handling code here:
        text(b39);
    }//GEN-LAST:event_b39ActionPerformed

    private void b41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b41ActionPerformed
        // TODO add your handling code here:
        text(b41);
    }//GEN-LAST:event_b41ActionPerformed

    private void b42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b42ActionPerformed
        // TODO add your handling code here:
        text(b42);
    }//GEN-LAST:event_b42ActionPerformed

    private void b43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b43ActionPerformed
        // TODO add your handling code here;
        text(b43);
    }//GEN-LAST:event_b43ActionPerformed

    private void b44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b44ActionPerformed
        // TODO add your handling code here:
        text(b44);
    }//GEN-LAST:event_b44ActionPerformed

    private void b45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b45ActionPerformed
        // TODO add your handling code here:
        text(b45);
    }//GEN-LAST:event_b45ActionPerformed

    private void b46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b46ActionPerformed
        // TODO add your handling code here:
        text(b46);
    }//GEN-LAST:event_b46ActionPerformed

    private void b47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b47ActionPerformed
        // TODO add your handling code here:
        text(b47);
    }//GEN-LAST:event_b47ActionPerformed

    private void b48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b48ActionPerformed
        // TODO add your handling code here:
        text(b48);
    }//GEN-LAST:event_b48ActionPerformed

    private void b49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b49ActionPerformed
        // TODO add your handling code here:
        text(b49);
    }//GEN-LAST:event_b49ActionPerformed

    private void b51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b51ActionPerformed
        // TODO add your handling code here:
        text(b51);
    }//GEN-LAST:event_b51ActionPerformed

    private void b52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b52ActionPerformed
        // TODO add your handling code here:
        text(b52);
    }//GEN-LAST:event_b52ActionPerformed

    private void b53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b53ActionPerformed
        // TODO add your handling code here
        text(b53);
    }//GEN-LAST:event_b53ActionPerformed

    private void b54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b54ActionPerformed
        // TODO add your handling code here:
        text(b54);
    }//GEN-LAST:event_b54ActionPerformed

    private void b55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b55ActionPerformed
        // TODO add your handling code here:
        text(b55);
    }//GEN-LAST:event_b55ActionPerformed

    private void b56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b56ActionPerformed
        // TODO add your handling code here:
        text(b56);
    }//GEN-LAST:event_b56ActionPerformed

    private void b57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b57ActionPerformed
        // TODO add your handling code here:
        text(b57);
    }//GEN-LAST:event_b57ActionPerformed

    private void b58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b58ActionPerformed
        // TODO add your handling code here:
        text(b58);
    }//GEN-LAST:event_b58ActionPerformed

    private void b59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b59ActionPerformed
        // TODO add your handling code here:
        text(b59);
    }//GEN-LAST:event_b59ActionPerformed

    private void b61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b61ActionPerformed
        // TODO add your handling code here:
        text(b61);
    }//GEN-LAST:event_b61ActionPerformed

    private void b62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b62ActionPerformed
        // TODO add your handling code here:
        text(b62);
    }//GEN-LAST:event_b62ActionPerformed

    private void b63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b63ActionPerformed
        // TODO add your handling code here:
        text(b63);
    }//GEN-LAST:event_b63ActionPerformed

    private void b64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b64ActionPerformed
        // TODO add your handling code here:
        text(b64);
    }//GEN-LAST:event_b64ActionPerformed

    private void b65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b65ActionPerformed
        // TODO add your handling code here:
        text(b65);
    }//GEN-LAST:event_b65ActionPerformed

    private void b66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b66ActionPerformed
        // TODO add your handling code here:
        text(b66);
    }//GEN-LAST:event_b66ActionPerformed

    private void b67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b67ActionPerformed
        // TODO add your handling code here:
        text(b67);
    }//GEN-LAST:event_b67ActionPerformed

    private void b68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b68ActionPerformed
        // TODO add your handling code here:
        text(b68);
    }//GEN-LAST:event_b68ActionPerformed

    private void b69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b69ActionPerformed
        // TODO add your handling code here:
        text(b69);
    }//GEN-LAST:event_b69ActionPerformed

    private void b71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b71ActionPerformed
        // TODO add your handling code here:
        text(b71);
    }//GEN-LAST:event_b71ActionPerformed

    private void b72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b72ActionPerformed
        // TODO add your handling code here:
        text(b72);
    }//GEN-LAST:event_b72ActionPerformed

    private void b73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b73ActionPerformed
        // TODO add your handling code here:
        text(b73);
    }//GEN-LAST:event_b73ActionPerformed

    private void b74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b74ActionPerformed
        // TODO add your handling code here:
        text(b74);
    }//GEN-LAST:event_b74ActionPerformed

    private void b75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b75ActionPerformed
        // TODO add your handling code here:
        text(b75);
    }//GEN-LAST:event_b75ActionPerformed

    private void b76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b76ActionPerformed
        // TODO add your handling code here:
        text(b76);
    }//GEN-LAST:event_b76ActionPerformed

    private void b77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b77ActionPerformed
        // TODO add your handling code here:
        text(b77);
    }//GEN-LAST:event_b77ActionPerformed

    private void b78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b78ActionPerformed
        // TODO add your handling code here:
        text(b78);
    }//GEN-LAST:event_b78ActionPerformed

    private void b79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b79ActionPerformed
        // TODO add your handling code here:
        text(b79);
    }//GEN-LAST:event_b79ActionPerformed

    private void b81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b81ActionPerformed
        // TODO add your handling code here:
        text(b81);
    }//GEN-LAST:event_b81ActionPerformed

    private void b82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b82ActionPerformed
        // TODO add your handling code here:
        text(b82);
    }//GEN-LAST:event_b82ActionPerformed

    private void b83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b83ActionPerformed
        // TODO add your handling code here:
        text(b83);
    }//GEN-LAST:event_b83ActionPerformed

    private void b84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b84ActionPerformed
        // TODO add your handling code here:
        text(b84);
    }//GEN-LAST:event_b84ActionPerformed

    private void b85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b85ActionPerformed
        // TODO add your handling code here:
        text(b85);
    }//GEN-LAST:event_b85ActionPerformed

    private void b86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b86ActionPerformed
        // TODO add your handling code here:
        text(b86);
    }//GEN-LAST:event_b86ActionPerformed

    private void b87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b87ActionPerformed
        // TODO add your handling code here:
        text(b87);
    }//GEN-LAST:event_b87ActionPerformed

    private void b88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b88ActionPerformed
        // TODO add your handling code here:
        text(b88);
    }//GEN-LAST:event_b88ActionPerformed

    private void b89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b89ActionPerformed
        // TODO add your handling code here:
        text(b89);
    }//GEN-LAST:event_b89ActionPerformed

    private void b91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b91ActionPerformed
        // TODO add your handling code here:
        text(b91);
    }//GEN-LAST:event_b91ActionPerformed

    private void b92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b92ActionPerformed
        // TODO add your handling code here:
        text(b92);
    }//GEN-LAST:event_b92ActionPerformed

    private void b93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b93ActionPerformed
        // TODO add your handling code here:
        text(b93);
    }//GEN-LAST:event_b93ActionPerformed

    private void b94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b94ActionPerformed
        // TODO add your handling code here:
        text(b94);
    }//GEN-LAST:event_b94ActionPerformed

    private void b95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b95ActionPerformed
        // TODO add your handling code here:
        text(b95);
    }//GEN-LAST:event_b95ActionPerformed

    private void b96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b96ActionPerformed
        // TODO add your handling code here:
        text(b96);
    }//GEN-LAST:event_b96ActionPerformed

    private void b97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b97ActionPerformed
        // TODO add your handling code here:
        text(b97);
    }//GEN-LAST:event_b97ActionPerformed

    private void b98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b98ActionPerformed
        // TODO add your handling code here:
        text(b98);
    }//GEN-LAST:event_b98ActionPerformed

    private void b99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b99ActionPerformed
        // TODO add your handling code here:
        text(b99);
    }//GEN-LAST:event_b99ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        subcheck();
    }//GEN-LAST:event_submitActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "You have "+checkno+" check moves left","Sudoku Puzzle",JOptionPane.INFORMATION_MESSAGE);
        if(checkno > 0){
            if(easy_flag) checkfun(easysol);
            else if(med_flag) checkfun(mediumsol);
            else if(hard_flag) checkfun(hardsol);
            checkno--;
        }
    }//GEN-LAST:event_checkActionPerformed

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
            java.util.logging.Logger.getLogger(Sudoku_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sudoku_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b13;
    private javax.swing.JButton b14;
    private javax.swing.JButton b15;
    private javax.swing.JButton b16;
    private javax.swing.JButton b17;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b21;
    private javax.swing.JButton b22;
    private javax.swing.JButton b23;
    private javax.swing.JButton b24;
    private javax.swing.JButton b25;
    private javax.swing.JButton b26;
    private javax.swing.JButton b27;
    private javax.swing.JButton b28;
    private javax.swing.JButton b29;
    private javax.swing.JButton b31;
    private javax.swing.JButton b32;
    private javax.swing.JButton b33;
    private javax.swing.JButton b34;
    private javax.swing.JButton b35;
    private javax.swing.JButton b36;
    private javax.swing.JButton b37;
    private javax.swing.JButton b38;
    private javax.swing.JButton b39;
    private javax.swing.JButton b41;
    private javax.swing.JButton b42;
    private javax.swing.JButton b43;
    private javax.swing.JButton b44;
    private javax.swing.JButton b45;
    private javax.swing.JButton b46;
    private javax.swing.JButton b47;
    private javax.swing.JButton b48;
    private javax.swing.JButton b49;
    private javax.swing.JButton b51;
    private javax.swing.JButton b52;
    private javax.swing.JButton b53;
    private javax.swing.JButton b54;
    private javax.swing.JButton b55;
    private javax.swing.JButton b56;
    private javax.swing.JButton b57;
    private javax.swing.JButton b58;
    private javax.swing.JButton b59;
    private javax.swing.JButton b61;
    private javax.swing.JButton b62;
    private javax.swing.JButton b63;
    private javax.swing.JButton b64;
    private javax.swing.JButton b65;
    private javax.swing.JButton b66;
    private javax.swing.JButton b67;
    private javax.swing.JButton b68;
    private javax.swing.JButton b69;
    private javax.swing.JButton b71;
    private javax.swing.JButton b72;
    private javax.swing.JButton b73;
    private javax.swing.JButton b74;
    private javax.swing.JButton b75;
    private javax.swing.JButton b76;
    private javax.swing.JButton b77;
    private javax.swing.JButton b78;
    private javax.swing.JButton b79;
    private javax.swing.JButton b81;
    private javax.swing.JButton b82;
    private javax.swing.JButton b83;
    private javax.swing.JButton b84;
    private javax.swing.JButton b85;
    private javax.swing.JButton b86;
    private javax.swing.JButton b87;
    private javax.swing.JButton b88;
    private javax.swing.JButton b89;
    private javax.swing.JButton b91;
    private javax.swing.JButton b92;
    private javax.swing.JButton b93;
    private javax.swing.JButton b94;
    private javax.swing.JButton b95;
    private javax.swing.JButton b96;
    private javax.swing.JButton b97;
    private javax.swing.JButton b98;
    private javax.swing.JButton b99;
    private javax.swing.JButton check;
    private javax.swing.JButton easy;
    private javax.swing.JButton exit;
    private javax.swing.JButton hard;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton medium;
    private javax.swing.JButton reset;
    private javax.swing.JButton s1;
    private javax.swing.JButton s2;
    private javax.swing.JButton s3;
    private javax.swing.JButton s4;
    private javax.swing.JButton s5;
    private javax.swing.JButton s6;
    private javax.swing.JButton s7;
    private javax.swing.JButton s8;
    private javax.swing.JButton s9;
    private javax.swing.JButton solution;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
