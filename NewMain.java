import java.util.Scanner;

public class NewMain {

    public static void main (String [] args ){
        Scanner in = new Scanner (System.in);
        int op;
        
        do{
            System.out.println("Digite a sua opcao");
            exibirMenu();
            op = in.nextInt(); in.nextLine();
            
            switch (op){
                case 1: System.out.println("Inserir no inicio");
                        break;
                case 2: System.out.println("Inserir no final");
                        break;
                case 3: System.out.println("Remover o primeiro");
                        break;
                case 4: System.out.println("Remover o ultimo");
                        break;
                case 5: System.out.println("Exibir todos os produtos");
                        break;
                case 6: System.out.println("Exibir dados de um produto");
                        break;
                case 7: System.out.println("Alterar dados de um produto");
                        break;
                case 8: System.out.println("Remover um dado Produto");
                        break;
                case 0: System.out.println("Bye Bye !!");
                default: System.out.println("Voce digitou uma opcao errada");
                        break;
            }
        }while (op != 0);
        
    
    }
    public static void exibirMenu(){
        System.out.println("1 - Inserir no inicio da lista");
        System.out.println("2 - Inserir no final da lista");
        System.out.println("3 - Remover o primeiro da lista");
        System.out.println("4 - Remover o ultimo da lista");
        System.out.println("5 - Exibir todos os produtos da lista");
        System.out.println("6 - Exibir os dados de um produto da lista");
        System.out.println("7 - Alterar os dados de um produto da lista ");
        System.out.println("8 - Remover um dado produto");
        System.out.println("0 - Sair do programa");
    }
}
