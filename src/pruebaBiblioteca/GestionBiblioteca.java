package pruebaBiblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;


public class GestionBiblioteca {
	
	private ArrayList<Libros> listaLibros;

	public ArrayList<Libros> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libros> listaLibros) {
		FileReader fr= null;
		BufferedReader br = null;
		String linea=" ";
	 try {
			fr=new FileReader("librosdos.csv");
			br=new BufferedReader(fr);
			br.readLine();
			while(br.ready()) {
				linea = br.readLine();
				
				listaLibros.add(new Libros(linea.split(";")));
			};

	
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println("Error de E/S");
		}
		
		finally {
			if(br != null) {
				try{
					br.close();
				}catch(IOException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		this.listaLibros = listaLibros;
	}

	public void imprimir(ArrayList<Libros> listaLib) {

			for(Libros lib: listaLib) {
				System.out.println( lib);
			
			}
		
	
	}

	public void addLibro(ArrayList<Libros> listaLib) {
		Scanner ent = new Scanner(System.in);
		Libros libroAd = new Libros();
		boolean correcto=true;
		while(correcto){
			try {
				System.out.println("Introduce el isbn del libro" );
				libroAd.setIsbn(Integer.parseInt(ent.nextLine()));
				System.out.println("Introduce el titulo del libro");
				libroAd.setTitulo(ent.nextLine());
				System.out.println("Introduce el stock del libro" );
				libroAd.setStock(Integer.parseInt(ent.nextLine()));
				System.out.println("Introduce el autor del libro" );
				libroAd.setAutor(ent.nextLine());
			
				listaLibros.add(libroAd);
				correcto=false;
			
			}catch(NumberFormatException ex) {
				System.out.println(ex.getMessage());
				correcto=true;
			}
		}
		
	}

	public void eliminar(ArrayList<Libros> listaLib) {
		Scanner consola = new Scanner(System.in);
		System.out.println("¿Qué libro quieres eleminar?");
		listaLibros.remove(Integer.parseInt(consola.nextLine())-1);
		imprimir(listaLibros);
		
	}

	public void buscar(ArrayList<Libros> listaLib) {
		Scanner ent = new Scanner(System.in);
		int busqID=0;
		char cont = ' ', seg=' ';
		int op=0;
		boolean salir= false;
		
		Libros libroAc = new Libros();
		System.out.println("Introduce el codigo del libro");
		busqID=Integer.parseInt(ent.nextLine());
		for(Libros lib: listaLib) {
			if(lib.getIsbn()==busqID) {
				System.out.println(lib);
				
				System.out.println("¿Quiere modificarlo? (S/N)");

				cont= ent.nextLine().toUpperCase().charAt(0);
				
				if(cont == 'S') {
					
					while(salir == false) {
						System.out.println("¿Qué desea modificar\n"
							+"1. Para cambiar el ISBN\n"
							+"2. Para cambiar el título\n"
							+"3. Para cambiar el autor\n"
							+"4. Para cambiar el stock\n"
							+"5. Para salir");
						op= ent.nextInt();
						ent.nextLine();
						switch(op) {
						case 1: 
							System.out.println("Introduce el nuevo ISBN");
							lib.setIsbn(Integer.parseInt(ent.nextLine()));
							
							break;
						case 2: 
							System.out.println("Introduce el nuevo título");
							lib.setTitulo(ent.nextLine());
							break;
						case 3: 
							System.out.println("Introduce el nuevo autor");
							lib.setAutor(ent.nextLine());
							break;
						case 4: 
							System.out.println("Introduce el nuevo Stock");
							lib.setStock(Integer.parseInt(ent.nextLine()));
							break;
						case 5: salir=true;
						System.out.println("Adios...");
						break;
							default:System.out.println("Opción no valida");
						}
						System.out.println("¿Desea modificar algo más del libro? (S/N)");

						cont= ent.nextLine().toUpperCase().charAt(0);
						if(cont=='N') {
							salir=true;
						}
					}	
				}
			}
		}
		
		
		
	}

	public void guardar(ArrayList<Libros> listaLib) {
		
		FileWriter fw=null;
		BufferedWriter bw =null;
		try {
			fw= new FileWriter("librosdos.csv");
			bw = new BufferedWriter(fw);
			for(Libros lib:listaLib) {
			 bw.write(lib.getIsbn()+";"+lib.getTitulo()+";"+lib.getAutor()+";"+lib.getStock());
			 bw.newLine();
		 }
		 }catch(IOException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try{
			if(bw !=null && fw !=null) {
				bw.close();
				fw.close();
			}
		}catch(Exception ex) {
			System.out.println("Error al cerrar" );
		}
	}

	}
}
