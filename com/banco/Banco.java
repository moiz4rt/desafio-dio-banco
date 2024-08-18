package com.banco;

import java.util.List;
import java.util.ArrayList;

public class Banco
{
    private String nome;
    private List<Conta> contas = new ArrayList<>();;
    private static int SEQUENCIA = 1;
    private int agencia;

    public Banco(String nome)
    {
        this.nome = nome;
        this.agencia = Banco.SEQUENCIA++;
    }

    public Cliente criarCliente(String nome)
    {
        return new Cliente(nome);
    }

    public void criarConta(Cliente cliente, String tipoConta)
    {
        if(cliente == null || !(tipoConta == "cc" || tipoConta == "cp")) return;
        Conta conta;
        if(tipoConta == "cc")
        {
           conta = new ContaCorrente(cliente, this.agencia);
           contas.add(conta);
        }
        else
        {
            conta = new ContaPoupanca(cliente, this.agencia);
            contas.add(conta);
        }
    }

    public Conta getConta(Cliente cliente)
    {
        for(Conta conta : contas)
        {
            if(conta.getCliente().equals(cliente))
                return conta;
        }
        return null;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void listarContas()
    {
        System.out.println("*** LISTA DE CLIENTES - BANCO " + this.toString().toUpperCase() + " ***");
        System.out.println("AGENCIA    |   NUMERO  |   CLIENTE |   TIPO");
        for(Conta conta : contas)
        {
            System.out.println(conta.getAgencia() + " " + conta.getNumero() + " " + conta.cliente + " " + conta.tipo);
        }
    }

    @Override
    public String toString()
    {
        return nome;
    }
}
