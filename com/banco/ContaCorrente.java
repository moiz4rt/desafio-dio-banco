package com.banco;

public class ContaCorrente extends Conta
{
    public ContaCorrente(Cliente cliente, int agencia)
    {
        super.agencia = agencia;
        super.cliente = cliente;
        super.tipo = "cc";
    }
    @Override
    public void imprimirExtrato()
    {
       imprimirInfo();
    }
}
