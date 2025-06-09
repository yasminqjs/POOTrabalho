package servicos;

import java.util.Comparator;
import entidades.Produto;
 
public class Sorts { //classe criada para deixar todos os sorts de produto em um mesmo lugar

			  
	  public class SortPreco implements Comparator<Produto> {
		   public int compare(Produto p1, Produto p2) {
			   if(p1.getPreco() > p2.getPreco()) return 1;
			   if(p1.getPreco() < p2.getPreco()) return -1;
			   return 0;
		   }
		}

	  public class SortQuantidade implements Comparator<Produto> {
		   public int compare(Produto p1, Produto p2) {
			   return p1.getQuantidade() - p2.getQuantidade();
		   }
	   }
	   
	  
	   
	   public class SortNome implements Comparator<Produto> {
		   public int compare(Produto p1, Produto p2) {
			   
			   return p1.getNome().compareToIgnoreCase(p2.getNome());
			   
		   }
	   }
	   

	   public class SortValidade implements Comparator<Produto> {
		   public int compare(Produto p1, Produto p2) {
			   return p1.getValidade().compareToIgnoreCase(p2.getValidade());
		   }
	   }
}
	


		   
