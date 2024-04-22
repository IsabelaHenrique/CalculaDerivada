import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        System.out.println("Bem-vindo à Calculadora de Derivadas !");
        System.out.println("Digite a função no formato 'ax^n + bx + c':");
        String funcao = scanner.nextLine();

        String[] termos = funcao.split("\\+");

        double a = 0, b = 0, n = 0;
       
        for (String termo : termos) {
            if (termo.contains("x^")) {
                String[] partes = termo.split("\\^");
                n = Double.parseDouble(partes[1]);
                a = Double.parseDouble(partes[0].replace("x", "").trim());
            } else if (termo.contains("x")) {
                String coeficienteX = termo.replace("x", "").trim();
                if (coeficienteX.isEmpty()) {
                    b = 1;
                } else {
                    b = Double.parseDouble(coeficienteX);
                }
            }
        }

        double aDerivado = a * n;
        double nMenosUm = n - 1;
        double bDerivado = b;
       
        if (aDerivado != 0 || bDerivado != 0) {
            if (aDerivado != 0) {
                if (bDerivado != 0) {
                    if (nMenosUm != 1) {
                        System.out.printf("A derivada da função é: %.0fx^%.0f + %.0f%n", aDerivado, nMenosUm, bDerivado);
                    } else {
                        System.out.printf("A derivada da função é: %.0fx + %.0f%n", aDerivado, bDerivado);
                    }
                } else {
                    if (nMenosUm != 1) {
                        System.out.printf("A derivada da função é: %.0fx^%.0f%n", aDerivado, nMenosUm);
                    } else {
                        System.out.printf("A derivada da função é: %.0fx%n", aDerivado);
                    }
                }
            } else {
                if (bDerivado != 0) {
                    System.out.printf("A derivada da função é: %.0f%n", bDerivado);
                }
            }
        }
     
        scanner.close();
    }
}

