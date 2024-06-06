import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args){
       selecionarCandidato();
       imprimirSelecionados();

       String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
       for(String candidato: candidatos){
          ligar(candidato);
       }
       }

       static void ligar(String candidato){
            int tentativasRealiadas = 1;
            boolean continuartentando = true;
            boolean atendeu = false;
            do{
                //elas precisaram sofrer alterações
                atendeu = atender();
                continuartentando = !atendeu;
                if(continuartentando)
                    tentativasRealiadas++;
                else
                    System.out.println("Contato realiado com sucesso");

            }while(continuartentando && tentativasRealiadas < 3);
            if(atendeu)
                System.out.println("Conseguimos entrar em contato com " + candidato + " NA " + tentativasRealiadas);
            else
                System.out.println("Não conseguimos entrar em contato com o candidato " + candidato + ", número máximo de tentativas");
       }

       // métod auxiliar
       static boolean atender(){
        return new Random().nextInt(3)==1;
       }

    

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número " + (indice+1) + " é " +candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecionarCandidato(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase= 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
                analisarCandidato(salarioPretendido);
            }
            candidatoAtual++;
        }

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Liga para o candidato");
        }else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta");
        }else{
            System.out.println("Aguardando demais candidatos");
        }
    }
}
