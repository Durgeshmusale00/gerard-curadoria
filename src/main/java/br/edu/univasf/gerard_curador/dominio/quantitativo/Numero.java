package br.edu.univasf.gerard_curador.dominio.quantitativo;

public final class Numero {
    private final int valor;
    public Numero(int valor) { this.valor = valor; }
    public int getValor() { return valor; }
    public Numero somar(Numero outro) {
        return new Numero(valor + outro.valor);
    }
    public Numero subtrair(Numero outro) {
        return new Numero(valor - outro.valor);
    }
    public boolean ehNegativo() { return valor < 0; }
}
