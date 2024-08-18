package com.banco;

class ContaPoupanca extends Conta
{
    public ContaPoupanca(Cliente cliente, int agencia)
    {
        super.agencia = agencia;
       super.cliente = cliente;
       super.tipo = "cp";
    }
    @Override
    public void imprimirExtrato()
    {
        imprimirInfo();
    }
}
