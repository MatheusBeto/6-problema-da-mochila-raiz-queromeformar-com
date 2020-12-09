package mochila;

public class Main {

	public static void main(String[] args) {
		
		int c = 7;
		int n = 4;
		
		Item[] itens = {new Item(5,2),new Item(2,4), new Item(2,2),new Item(1,3)};
		
		Processador proc = new Processador();
		
		proc.problemaMochilaForçaBrutaGulosa(itens, n, c);
		

		Item[] itens2 = {new Item(5,2),new Item(2,4), new Item(2,2),new Item(1,3)};

		proc.problemaMochilaDinamico(itens2, n, c);
		
		
//		String texto1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
//				"simplify the build processes in the Jakarta Turbine project. There were several" + 
//				" projects, each with their own Ant build files, that were all slightly different." +
//				"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
//				"definition of what the project consisted of, an easy way to publish project information" +
//				"and a way to share JARs across several projects. The result is a tool that can now be" +
//				"used for building and managing any Java-based project. We hope that we have created " +
//				"something that will make the day-to-day work of Java developers easier and generally help " +
//				"with the comprehension of any Java-based project.";		
//		
//		String texto2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
//				"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
//				"ask? I am going to try to answer this question in this article." + 
//			        "Go to the profile of Marin Vlastelica Pogančić" + 
//			        "Marin Vlastelica Pogančić Jun";
	
		String texto1 = "Cuppertino";
		String texto2 = "Silicon Valley";
		
		System.out.println("\nDistanciamento Recursivo-> "+ proc.distanciaRecursivo(texto1, texto2, texto1.length()-1, texto2.length()-1));

	    System.out.println("Iteracoes recursivo->"+ proc.it3);
		System.out.println("\nDistanciamento Dinamico-> "+ proc.distanciaDinamico(texto1, texto2));

	    System.out.println("Iteracoes dinâmico->"+ proc.it4);

	}

}
