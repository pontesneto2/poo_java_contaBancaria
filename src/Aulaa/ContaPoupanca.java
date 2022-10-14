package Aulaa;

import javax.swing.JOptionPane;

/**
 * @author Pontes Neto
 * @version 1.0
 */

public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    //valor limite de saldo que pode ser atingido
    private final double limite = -100;


    @Override
    public void sacar(double valor){
        if( (super.getSaldo()-valor) >= limite){
            super.setSaldo(super.getSaldo()-valor);
            JOptionPane.showMessageDialog(null,"Levantamento efectuado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"O levantamento nao pode ser efectuado");
        }
    }

    @Override
    public void depositar(double valor){
        super.setSaldo(super.getSaldo()+valor);
        JOptionPane.showMessageDialog(null,"Deposito efectuado com sucesso");
    }

    @Override
    public void mostrarDados() {
        String dados="Numero da conta: "+super.getNumeroDeConta()+"\n"+
                "Saldo actual: "+super.getSaldo()+"\n"+
                "Limite: "+ this.limite;
        JOptionPane.showMessageDialog(null,dados);
    }

    public double getLimite() {
        return limite;
    }

}