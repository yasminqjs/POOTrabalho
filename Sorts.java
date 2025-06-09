package servicos;

import java.time.format.DateTimeFormatter;
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
	   

	   public class SortValidade implements Comparator<Produto> { //compara as datas como se fossem strings
		   DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		   
		   public int compare(Produto p1, Produto p2) {
			   
			   String d01 = p1.getValidade().format(fmt1);
			   String d02 = p2.getValidade().format(fmt1);
			   
			   return d01.compareTo(d02);
		   }
	   }
}
	


		   
