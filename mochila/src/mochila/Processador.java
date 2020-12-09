package mochila;

import java.util.ArrayList;
import java.util.Collections;

public class Processador {
	
	public Processador() {};
	
	public int it1 = 0;
	public int it2 = 0;
	public int it3 = 0;
	public int it4 = 0;
	
	
	public void problemaMochilaForçaBrutaGulosa(Item[] itens, int n, int c) {
		
		ArrayList<Integer> valoresMochila = new ArrayList<Integer>();
		
		int i;
		int aux;
		int todosItens = 0;
		int somaValores = 0;
		int somaPesos = 0;
		ArrayList<Integer> arValores = new ArrayList<Integer>();
		
		it1+=10;
		
		
		for(i = 0; i<itens.length; i++){
			it1+= 4;
			
			for(int j = 0; j<itens.length-1; j++){
				it1+= 5;
				if(itens[j].valor < itens[j + 1].valor){
					it1+=4;
					aux = itens[j].valor;
					itens[j].valor = itens[j+1].valor;
					itens[j+1].valor = aux;
					it1+=7;
					aux = itens[j].peso;
					itens[j].peso = itens[j+1].peso;
					itens[j+1].peso = aux;
					it1+=7;
					
				}
			}
		}
		
		
		
		while(todosItens < itens.length) {
			it1++;
			somaPesos = itens[todosItens].peso;
			somaValores =  itens[todosItens].valor;
			it1+=4;
			
			for(i=0; i<itens.length; i++) {
				it1+=4;
				if(i != todosItens ) {
					somaPesos += itens[i].peso; 
					it1+=4;
					if( somaPesos <= c) {
						somaValores+=itens[i].valor;
						it1+=4;
					}else {
						somaPesos-=itens[i].peso;
						it1+=3;
					}
					
				}
				
			}
			arValores.add(somaValores);
				
			somaPesos = 0;
			somaValores = 0;
			
			todosItens++;
			
			it1+=6;
		}
		
		int maior = 0;
		it1+=2;
		for (Integer integer : arValores) {
			it1+=3;
			if(integer > maior) {
				maior = integer;
				it1++;
			}
		}
		
		System.out.println("\nValor Máximo Força Bruta Gulosa -> " + maior);
		System.out.println("Iteracoes1 -> " + it1);
		
	}
	
	
	public void problemaMochilaDinamico(Item[] itens, int n, int c) {
		
		
		int[][] maxTab = new int[n+1][c+1];
		it2+=5;
		
		
		
		for(int i = 0; i<n; i++) {
			maxTab[i][0] = 0;
			it2+=7;
			
		}
		
		for (int k = 0; k<c ; k++) {
			maxTab[0][k] = 0;
			it2+=7;
			
		}
		
		for(int i = 1; i<n ;i++) {
			it2+=5;
			for(int j = 1; j<c; j++) {
				it2+=5;
				if(itens[i].peso <= j) {
					it2+=2;
					maxTab[i][j] = Math.max(maxTab[i-1][j], (itens[i].valor +
							maxTab[i-1][j - itens[i].peso]));
					it2+=9;
				}else {
					maxTab[i][j] = maxTab[i-1][j];
					it2+=4;
				}
			}
		
		}
		

		System.out.println("\nValor máximo dinâmico -> " + maxTab[n-1][c-1]);

		System.out.println("Iteracoes2 dinâmico -> " + it2);
		
	}
	
	public int distanciaRecursivo(String texto, String texto2, int i, int j) {
		
		int s,in,r,min;
	    
	    if (texto.length() == 0 && texto2.length() == 0)
	      return 0;
	    if (texto.length() == 0)
	      return j;
	    if (texto.length() == 0)
	      return i;
	    if (i == 0)
	      return j;
	    if (j == 0)
	      return i;

	    if (texto.charAt(i) == texto2.charAt(j)) {
	      it3++;
	      return distanciaRecursivo(texto, texto2, i - 1, j - 1);
	    }

	    
	    s = distanciaRecursivo(texto, texto2, i - 1, j - 1) + 1;
	    in = distanciaRecursivo(texto, texto2, i, j - 1) + 1;
	    r = distanciaRecursivo(texto, texto2, i - 1, j) + 1;
	    it3+=10;
	    
	    min = Math.min(s, (Math.min(in, r)));
	    

	    return min;

	  }
	
	
	  public int distanciaDinamico(String texto1, String texto2) {
		    int m = texto1.length();
		    int custoExtra = 0;
		    int n = texto2.length();
		    int matriz[][] = new int[m][n];

		    for (int i = 1; i < m; i++) {
		      
		      matriz[i][0] = (matriz[i - 1][0] + 1);
		      it4+=10;
		    }

		    for (int j = 1; j < n; j++) {
		      
		      matriz[0][j] = (matriz[0][j - 1] + 1);
		      it4+=10;
		    }

		    for (int i = 1; i < m; i++) {
		      it4+=5;
		      for (int j = 1; j < n; j++) {
		    	 it4+=5;
		        if (texto1.charAt(i) == texto2.charAt(j)) {
		          custoExtra = 0;
		        } else {
		          custoExtra = 1; 
		        }
		        it4+=5;
		        matriz[i][j] = Math.min((matriz[i - 1][j] + 1),
		            Math.min((matriz[i][j - 1] + 1), (matriz[i - 1][j - 1] + custoExtra)));
		        it4+=15;
		      }
		    }
		    it4++;
		    return matriz[m - 1][n - 1];
		  }
	

}
