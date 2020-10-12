public class Main {
    public static void main(String[] args) {
        File dir = new File(".");
		if( dir.exists()){
			System.out.println(dir.getPath());
		}
    }
}
