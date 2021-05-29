package sorteio_lvl_dois;

import java.util.*;

import java.io.*;

public class sorteio {
	
public static void main (String[] args) throws IOException {

		 Calendar mes  = Calendar.getInstance();
		 List<String[]> lista = new ArrayList<>(); 
	     FileReader fr = new FileReader("nomes/2021/abril.txt");
	    
	     BufferedReader br = new BufferedReader(fr);

	    String str;
	     while((str = br.readLine()) != null){
	         lista.add(str.split("\n"));
	     }   

	     String[] vencedor = lista.get(new Random().nextInt(lista.size()));

	     br.close();
	     
		 System.out.println("O Vencedor do mês " + mes.get(Calendar.MONTH) + " é "+ Arrays.toString(vencedor));
		 //Janeiro é considerado mês 0.
		}
}