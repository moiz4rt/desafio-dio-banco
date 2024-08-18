import com.banco.Banco;
import com.banco.Cliente;
import com.banco.Conta;
import com.banco.ContaCorrente;
import com.banco.ContaPoupanca;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Banco java = new Banco("Java");
        Cliente cliente = null;

        String resposta = "";
        System.out.println("Bem vindo ao Banco " + java);
        while(!resposta.equals("sair"))
        {
            System.out.println("");
            System.out.println("O que você gostaria de fazer?");
            if(cliente == null)
                System.out.println("[criar] conta");
            System.out.println("[depositar]");
            System.out.println("ver [extrato]");
            System.out.println("[sair]");
            System.out.print("Digite sua escolha: ");
            resposta = scanner.nextLine();
            System.out.println(resposta);
            System.out.println("");
            if(resposta.equals("criar"))
            {
                System.out.print("Qual seu nome? ");
                String nome = scanner.nextLine();
                cliente = java.criarCliente(nome);
                System.out.print("Gostaria de abrir uma conta [corrente] ou [poupanca]? ");
                String tipo = scanner.nextLine();
                if(tipo.equals("corrente"))
                    java.criarConta(cliente, "cc");
                if(tipo.equals("poupanca"))
                    java.criarConta(cliente, "cp");
                System.out.println("Sua conta foi criada com sucesso!");
                System.out.println("");
                continue;
            }
            if(resposta.equals("depositar"))
            {
                if(cliente == null)
                {
                    System.out.println("Você não possui conta no momento!");
                    System.out.println("");
                    continue;
                }
                System.out.println("Qual valor gostaria de depositar?");
                double valor = scanner.nextDouble();
                java.getConta(cliente).depositar(valor);
                System.out.println("Valor depositado com sucesso!");
                System.out.println("");
                continue;
            }
            if(resposta.equals("extrato"))
            {
                if(cliente == null)
                {
                    System.out.println("Você não possui conta!");
                    System.out.println("");
                    continue;
                }
                java.getConta(cliente).imprimirExtrato();
                System.out.println("");
                continue;
            }
        }
        scanner.close();
    }
}
