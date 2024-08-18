import com.banco.Banco;
import com.banco.Cliente;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Banco java = new Banco("Java");
        String resposta = "";
        while(!resposta.equals("sair"))
        {
            System.out.println("Bem vindo ao Banco " + java);
            System.out.println("O que você gostaria de fazer?");
            System.out.println("[criar] conta");
            System.out.println("[depositar]");
            System.out.println("[sair]");
            System.out.print("Digite sua escolha: ");
            resposta = scanner.nextLine();
            System.out.println(resposta);
            if(resposta.equals("criar"))
            {
                System.out.print("Qual seu nome? ");
                String nome = scanner.nextLine();
                Cliente cliente = java.criarCliente(nome);
                System.out.println();
            }
        }
        scanner.close();
    }
}
