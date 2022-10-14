package controle;

/**
 * @author Pontes Neto
 * @version 1.0
 */

import Aulaa.ContaBancaria;
import Aulaa.ContaCorrente;
import Aulaa.ContaPoupanca;
import Aulaa.Imprimivel;
import Aulaa.ModeloTabela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Banco implements Imprimivel{
    private ArrayList<ContaBancaria> contas = new ArrayList<>();
    int totalContas = contas.size();

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public Banco() {
    }

    public void inserir(ContaBancaria cb){
        contas.add(cb);
        JOptionPane.showMessageDialog(null,"Conta adicionada com sucesso \n"+ "O seu número de conta é :"+(contas.size()-1));
    }

    public boolean remover(ContaBancaria cb){
        contas.remove(cb);
        return true;
    }


    public JTable listar(JTable table){
        String[] colunas = new String[]{
                "Número da conta","Tipo de conta","Saldo"
        };

        ArrayList aux =  new ArrayList<>();

        aux=dados(aux);

        ModeloTabela m = new ModeloTabela(aux, colunas);
        table.setModel(m);

        return table;
    }

    public ContaBancaria procuraConta(int numeroConta){

        for(int i=0; i< contas.size(); i++)
            if(contas.get(i).getNumeroDeConta()==numeroConta)
                return contas.get(i);

        return null;

    }

    @Override
    public void mostrarDados() {
        contas.forEach(n->{
            if(n instanceof ContaCorrente){
                ((ContaCorrente)n).mostrarDados();
            }else{
                ((ContaPoupanca)n).mostrarDados();
            }
        });

    }

    public ArrayList<Object> dados(ArrayList<Object> lista){
        for(int i=0 ; i<contas.size();i++){
            if(contas.get(i) instanceof ContaCorrente){
                lista.add(new Object[]{
                        contas.get(i).getNumeroDeConta(),
                        "Conta corrente",
                        contas.get(i).getSaldo()
                });
            }else{
                lista.add(new Object[]{
                        contas.get(i).getNumeroDeConta(),
                        "Conta poupanca",
                        contas.get(i).getSaldo()
                });
            }
        }

        return lista;
    }


}
