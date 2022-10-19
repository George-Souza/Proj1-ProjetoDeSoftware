package Users;

import java.util.ArrayList;

import ProjetosAtividades.Atividades;
import ProjetosAtividades.Projetos;

public class Profissional extends Usuario{
    private double saldo;
    private ArrayList<Atividades> atividades;
    private Projetos pjVinculado;

    public void addAtividade(Atividades atv){
        this.atividades.add(atv);
    }

    public void addProjeto(Projetos pj){
        this.pjVinculado = pj;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void receber(double saldo){
        this.saldo += saldo;
    }
}
