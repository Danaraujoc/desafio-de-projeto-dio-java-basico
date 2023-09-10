import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Random random = new Random();

        System.out.println("Vamos criar sua Conta");

        System.out.print("Digite a Agência (sem digíto): ");
        String agencia = scanner.next();
        int digitoAgencia = random.nextInt(10);

        System.out.print("Digite o número da Conta sem digito: ");
        int conta = 0;
        boolean entradaValida = false;
        while (!entradaValida) { // Criando uma exceção para tratar entradas que não são números
            try {
                conta = scanner.nextInt();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, digite um número de conta válido: ");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }

        System.out.print("Digite seu Nome e Sobrenome: ");
        scanner.nextLine();
        String nomeSobrenome = scanner.nextLine();

        System.out.print("Digite o valor do seu depósito: ");
        double valor = scanner.nextDouble();

        scanner.close();

        // Formantando Agência para receber digíto (xxxx-x)
        String agenciaFormatada = String.format("%s-%d", agencia, digitoAgencia);

        // Exibindo mensagem
        System.out.printf(
                "Olá " + nomeSobrenome + ", obrigado por criar uma conta em nosso banco, sua agência é "
                        + agenciaFormatada + ", conta "
                        + conta + " e seu saldo é " + " R$ " + valor + " já está disponível para saque.");
    }
}
