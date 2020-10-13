import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Questao 03 - Lista 04");
        printPath(System.getenv("USERPROFILE") + "\\Downloads", "");
        System.out.println("");
        System.out.println("Questão 02 - Lista 04");
        int[] vector = {6, 8, 10, 12, 20};
        Heap lista = new Heap(vector);
        System.out.println(lista);
        System.out.println("");
        System.out.println("Questao 01 - Lista 04");
        lista.add(15);
        System.out.println(lista);
        System.out.println(lista.remove());
        System.out.println(lista);
        lista.add(22);
        System.out.println(lista);
        lista.update(6, 26);
        System.out.println(lista);
        System.out.println();
    }

    //|----------------------------------------------------|
    //|  Q3 - Lista de Exercícios 04                       |
    //|  Desenvolva um algoritmo para listar os arquivos   |
    //|  de um diretório e seus subdiretórios.             |
    //|----------------------------------------------------|
    public static void printPath(String caminho, String prefix){
        File dir = new File(caminho);
		if(dir.exists()){
            System.out.println(prefix + dir.getName());
            if(dir.isDirectory()){
                String[] filhos = dir.list();
                for(String nome : filhos){
                    printPath(caminho + "\\" + nome, prefix + "-> ");
                }
            }
		}else{
            System.out.println("Arquivo não encontrado");
        }
    }
}
