package grafica;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Calculadora;

public class ActionCalcular extends AbstractAction{
    private JTextField txtX, txtY;
    private JComboBox<String> cbxOperacao;
    public ActionCalcular(JTextField txtX, JTextField txtY, JComboBox<String> cbxOperacao){
        this.txtX = txtX;
        this.txtY = txtY;
        this.cbxOperacao = cbxOperacao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(txtX.getText());
            double y = Double.parseDouble(txtY.getText());
            Calculadora calc = new Calculadora(x, y);
            if (cbxOperacao.getSelectedItem().equals("Soma")) {
                JOptionPane.showMessageDialog(null, String.format("O resultado de %f + %f é %f", x, y, calc.somar()), "Calculadora Simples", JOptionPane.INFORMATION_MESSAGE);
            }
            if (cbxOperacao.getSelectedItem().equals("Subtração")) {
                JOptionPane.showMessageDialog(null, String.format("O resultado de %f - %f é %f", x, y, calc.subtrair()), "Calculadora Simples", JOptionPane.INFORMATION_MESSAGE);
            }
            if (cbxOperacao.getSelectedItem().equals("Multiplicação")) {
                JOptionPane.showMessageDialog(null, String.format("O resultado de %f * %f é %f", x, y, calc.multiplicar()), "Calculadora Simples", JOptionPane.INFORMATION_MESSAGE);
            } 
            if (cbxOperacao.getSelectedItem().equals("Divisão")) {
                JOptionPane.showMessageDialog(null, String.format("O resultado de %f / %f é %f", x, y, calc.dividir()), "Calculadora Simples", JOptionPane.INFORMATION_MESSAGE);
            }  
        } catch (NumberFormatException ex) {
            System.out.println("Numero digitado invalido.");
            JOptionPane.showMessageDialog(null, "Numero digitado invalido, tente novamente.", "Calculadora Simples", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
}
