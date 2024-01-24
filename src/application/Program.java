package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Empregados;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Empregados> lista = new ArrayList<>();
		
		System.out.print("Quantidade empregados a serem registrados: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Empregado: #" + (i+1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			Empregados empregado = new Empregados(id, nome, salario);
			
			lista.add(empregado);
		}
		
		System.out.println("id do funcionário que receberá o aumento: ");
		int id = sc.nextInt();
		Integer posicao = idExiste(lista, id);
 		if (posicao!=null) {
 			System.out.print("Taxa de aumento: ");
 			double taxa = sc.nextDouble();
 			lista.get(posicao).aumento(taxa);
 			}
 		else {
 			System.out.print("id Não encontrado");
 		}
	
	
 		System.out.print("Lista de empregados: \n");
 		for (Empregados funcionarios : lista) {
 			System.out.println(funcionarios);
 			
 		}
 		
		sc.close();
	
	}
	
	public static Integer idExiste(List<Empregados> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}


}
