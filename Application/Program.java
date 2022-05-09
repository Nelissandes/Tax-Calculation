package Application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <TaxPayer> taxPayer = new ArrayList<>();
		
		System.out.print("Insira o numero de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Contribuinte " + "#" + i);
			System.out.print("Pessoa fisica ou empresa: ");
			char individualOfCompany = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Rendimento anual: ");
			double anualIncome = sc.nextDouble();
			if (individualOfCompany == 'f') {
				System.out.print("Gasto com saúde: ");
				double healthExpenditures = sc.nextDouble();
				taxPayer.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Quantidade de fucionarios: ");
				Integer employee = sc.nextInt();
				taxPayer.add(new Company(name, anualIncome, employee));
			}
		}
		
		System.out.println();
		System.out.println("Impostos pagos: ");
		for (TaxPayer c: taxPayer) {
			System.out.println(c.getName() + ": $" + String.format("%.2f", c.tax()));
		}
		double sum = 0.0;
		for (TaxPayer c: taxPayer) {
			sum += c.tax();
		}
		System.out.println();
		System.out.println("Taxa total: " + String.format("%.2f", sum));
		
	sc.close();	
	}

}
