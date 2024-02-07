package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();
		System.out.println("Hoy many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Employe #"+ (i + 1)+ ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();
			
			Employee lista = new Employee(id, name, salary);
			list.add(lista);
		}
		
		System.out.print("Enter the employee id that will have salary increase :");
		int findId = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == findId).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This id does not exist!!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.IncreaseSalary(percent);
		}
	
		System.out.println("\nList of Employees: ");
		for ( Employee x : list) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> lista, int id) {
		Employee emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
		
	}

}
