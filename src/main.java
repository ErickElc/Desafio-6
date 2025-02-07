import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    static public void ListarItens(LinkedList<Ninja> ninjas){
        for(Ninja ninja : ninjas){
            System.out.println(ninja.toString());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Ninja> ninjasList = new LinkedList<>();
        ninjasList.add(new Ninja("Naruto Uzumaki", 17, "Konoha"));
        ninjasList.add(new Ninja("Sasuke Uchiha", 17, "Konoha"));
        ninjasList.add(new Ninja("Sakura Haruno", 17, "Konoha"));
        ninjasList.add(new Ninja("Kakashi Hatake", 30, "Konoha"));
        ninjasList.add(new Ninja("Gaara", 19, "Sunagakure"));
        ninjasList.add(new Ninja("Hinata Hyuga", 17, "Konoha"));
        ninjasList.add(new Ninja("Rock Lee", 18, "Konoha"));

        System.out.println("Olá, Bem vindo ao cadastro de ninjas");
        menu();

        int selectedOption = Integer.parseInt(sc.nextLine());
        while( selectedOption != 6 ) {

            switch(selectedOption){
                case 1:
                    System.out.println("Listar todos os ninjas");
                    ListarItens(ninjasList);
                    break;
                case 2:
                    System.out.println("Removendo Ninja, siga os próximos passos");
                    Ninja novoNinja = createNinja(sc);
                    ninjasList.removeFirst();
                    ninjasList.addFirst(novoNinja);

                    break;
                case 3:
                    System.out.println("Digite a posição específica desse ninja");
                    int posicao = Integer.parseInt(sc.nextLine());
                    System.out.println(ninjasList.get(posicao));

                    break;

                case 4:
                    System.out.println("Digite a posição que vc quer adicionar o ninja");
                    int posicaoNinja = Integer.parseInt(sc.nextLine());
                    Ninja novoNinja2 = createNinja(sc);
                    ninjasList.removeFirst();
                    if(posicaoNinja < ninjasList.size()) {
                        ninjasList.add(posicaoNinja, novoNinja2);

                    } else {
                        ninjasList.add(novoNinja2);
                    }
                    break;
                case 5:
                    ordenarPorOpc(ninjasList, sc);
                    break;
                default:
                    break;
            }
            menu();
            selectedOption = Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }
    static void menu(){
        System.out.println(
            "Selecione um numero para começar!\n" +
            "1- Listar todos os Ninjas\n" +
            "2- Remover o primeiro ninja e adicionar outro no local\n" +
            "3- Listar ninja de uma posição específica\n" +
            "4- Adicionar um ninja em alguma posição\n" +
            "5- Ordenar por Idade, nome e vila\n" +
            "6- Sair"
        );
    }
    static Ninja createNinja(Scanner sc){
        System.out.println("Digite um nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite uma idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o nome da vila: ");
        String nomeVila = sc.nextLine();
        Ninja novoNinja = new Ninja(nome, idade, nomeVila);
        return novoNinja;
    }

    static void ordenarPorOpc(LinkedList<Ninja> ninjasList, Scanner sc){
        System.out.println("Selecione qual é o paramentro de ordenação");
        System.out.println("1 - nome\n 2- idade\n 3- Vila\n 4- Sair");
        int orderOption = Integer.parseInt(sc.nextLine());
        LinkedList<Ninja> ninjasList2 = new LinkedList<>(ninjasList);
        switch(orderOption){
            case 1:
                Collections.sort(ninjasList2, (n1, n2) -> n1.getNome().compareTo(n2.getNome()));
                ListarItens(ninjasList2);
                break;
            case 2:
                Collections.sort(ninjasList2,  (n1, n2) -> Integer.compare(n1.getIdade(), n2.getIdade()));
                ListarItens(ninjasList2);
                break;
            case 3:
                Collections.sort(ninjasList2,(n1, n2) -> n1.getVila().compareTo(n2.getVila()));
                ListarItens(ninjasList2);
                break;
            default:
                System.out.println("Opção invalida, tente novamente");
                ordenarPorOpc(ninjasList2, sc);
                break;
        }
    }
}