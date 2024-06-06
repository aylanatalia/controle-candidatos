import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try{
            contar(parametroUm, parametroDois);
        }catch(ParametrosInvalidos e){
            System.out.println("O segundo parâmetro deve ser maior do que o primeiro");
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidos{
        if (parametroUm < parametroDois) {
            int contagem = parametroDois - parametroUm;
            for(int i = parametroUm; i < parametroDois; i++){
                System.out.println("Imprimindo o número: " + i);
            }
        }else{
            throw new ParametrosInvalidos();
        }
    }
    
}