/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
public class Janela extends JFrame{
    public final JLabel txtValor = new JLabel("Valor em USD");
    public final JLabel txtCot = new JLabel("Cotação BRL/USD");
    public final JTextField valor = new JTextField(25);
    public final JTextField cotacao = new JTextField(25);
    private final JCheckBox icms = new JCheckBox("ICMS");;
    private final JCheckBox imposto = new JCheckBox("Tributo");
    private final JButton botao = new JButton("Calcular");
    public Janela() throws HeadlessException {
        super("Cálculos");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(txtValor);
        add(valor);
        add(txtCot);
        add(cotacao);
        add(imposto);  
        add(icms);
             
        add(botao);
        botao.addActionListener(new calculaImposto());
    }

    private class calculaImposto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double calculo = Double.parseDouble(valor.getText());
            
            calculo *= Double.parseDouble(cotacao.getText());
            if(imposto.isSelected()){
                calculo*=1.6;
            }
            if(icms.isSelected()){
                calculo*=1.18;
            }
            JOptionPane.showMessageDialog(null, "Resultado:"+calculo,"Calculo do Valor",1);
        }
    }
    
}
