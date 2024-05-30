import java.util.Scanner;

public class ConversorMoedas {
    private final Cotacao Cotacao;

    public ConversorMoedas(String apiKey) {
        this.Cotacao = new Cotacao(apiKey);
    }

    public void converterMoeda(String moedaDe, String moedaPara) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o valor em " + moedaDe + ": ");
            double valor = Double.parseDouble(scanner.nextLine());

            double taxa = Cotacao.obterTaxaDeCambio(moedaDe, moedaPara);
            double resultado = valor * taxa;
            System.out.println("Valor em " + moedaPara + ": " + resultado + "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConversorMoedas conversor = new ConversorMoedas("277aefc9156b45815786670a");
        Menu menu = new Menu(conversor);
        menu.exibirMenu();
    }
}