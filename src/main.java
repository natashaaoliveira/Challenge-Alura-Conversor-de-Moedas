import java.util.Scanner;

public class main {
    private static final String API_KEY = "277aefc9156b45815786670a";

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas(API_KEY);
        Menu menu = new Menu(conversor);


        try {
            while (true) {
                menu.exibirMenu();
                int opcode = Integer.parseInt(scanner.nextLine());
                if (opcode == 0) {
                    System.out.println("Encerrando conversão.");
                    return;
                }
                menu.processarOpcao(opcode);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}