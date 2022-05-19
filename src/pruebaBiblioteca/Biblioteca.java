package pruebaBiblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	public static void main(String[] args) {
		GestionBiblioteca listaLibros = new GestionBiblioteca();
		ArrayList<Libros> listaLib = new ArrayList<Libros>();
		
		listaLibros.setListaLibros(listaLib);
		
		
		Scanner consola = new Scanner(System.in);
		int op=0;
		boolean salir= false;
		char cont = ' ';
		while(salir == false) {
			System.out.println("�Qu� desea hacer? \n "
		
					+ "1 para a�adir libros \n" 
					+ " 2 para ver todos los libros \n"
					+ " 3 para buscar y actualizar un libro \n"
					+ " 4 para eliminar un libro \n"
					+ " 5 para salir");		
			
			op= consola.nextInt();
			consola.nextLine();
			
			
			switch(op) {
			case 1: 
			do{ 
				listaLibros.addLibro(listaLib);
				System.out.println("�Desea a�adir otro libro? (S/N)");

				cont= consola.nextLine().toUpperCase().charAt(0);			
			}while(cont == 'S');
				break;
			
			case 2: listaLibros.imprimir(listaLib);
				break;
			
			case 3: listaLibros.buscar(listaLib);
				break;
			
			
			case 4: if(listaLib.size() > 0) {listaLibros.eliminar(listaLib);}
			else {
				System.out.println("El carrito est� vacio");
			}
				break;
			case 5: listaLibros.guardar(listaLib);
				salir=true;
			System.out.println("Adios...");
				break;
			default: System.out.println("Opci�n no valida");
			}
		}

	}

}
