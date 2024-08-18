package com.banco;

abstract class Conta implements IConta
{

    private static int SEQUENCIA = 1;

    protected int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;
    protected String tipo;

    public Conta()
    {
        this.numero = Conta.SEQUENCIA++;
    }

    @Override
    public void sacar(double valor)
    {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor)
    {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino)
    {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfo()
    {
        System.out.println("*** EXTRATO CONTA " + this.tipo.toUpperCase() + " ***");
        System.out.println("CLIENTE: " + this.cliente);
        System.out.println("AGENCIA: " + this.agencia);
        System.out.println("NUMERO: " + this.numero);
        System.out.println("SALDO: " + this.saldo);
    }

    public int getAgencia()
    {
        return agencia;
    }

    public int getNumero()
    {
        return numero;
    }

    public double getSaldo()
    {
        return saldo;
    }
}
