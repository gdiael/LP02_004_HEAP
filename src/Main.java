import java.io.File;

public class Main {
    public static void main(String[] args) {
        printPath("C:\\Users\\x-cha\\Google Drive\\Downloads", "");
    }

    ///////////////////////////////////////////////////////
    // Q3 - Lista de Exercícios 04                       //
    // Desenvolva um algoritmo para listar os arquivos   //
    // de um diretório e seus subdiretórios.             //
    ///////////////////////////////////////////////////////
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
