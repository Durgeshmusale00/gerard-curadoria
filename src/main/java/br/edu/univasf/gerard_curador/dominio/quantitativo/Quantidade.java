package br.edu.univasf.gerard_curador.dominio.quantitativo;

public final class Quantidade {
    private final Numero numero;
    private final ObjetoContado objeto;
    private final GrandezaQuantitativa grandeza;
    private final UnidadeMedida unidade;
    public Quantidade subtrair(Quantidade outra) {
        exigirCompatibilidadeCom(outra);
        Numero resultado = numero.subtrair(outra.numero);
        if (resultado.ehNegativo()) {
            throw new IllegalArgumentException("quantidade negativa");
        }
        return new Quantidade(resultado, objeto, grandeza, unidade);
    }
}