package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidades.Alumno;

public class ArregloAlumno {
		
		// declarar arreglo
		private ArrayList<Alumno> listaAlumnos;
		
		// crear constructor
		public ArregloAlumno() {
			listaAlumnos = new ArrayList<Alumno>();
			
			// insertando data de prueba
			/*listaAlumnos.add(new Alumno(202100001, "Juan", "Puchuri", "47988821", 29, 915359853, 0));
			listaAlumnos.add(new Alumno(202100002, "Angela", "Angela", "52416385", 28, 963528741, 1));
			listaAlumnos.add(new Alumno(202100003, "Grecia", "Huarote", "45678985", 27, 951753456, 2));
			*/
			importarAlumno();
		}
		
		// metodos necesarios
		
		// agregar alumno
		public void addAlumno(Alumno a) {
			// agregar alumno
			listaAlumnos.add(a);
		}
		
		
		// eliminar alumno
		public void delAlumno(int codigo) {
			for (int i = 0; i < tamanoListaAlumnos(); i++) {
				if(getAlumno(i).getCodAlumno() == codigo)
					listaAlumnos.remove(i);
			}
		}
		
		//tamaño de lista alumnos
		public int tamanoListaAlumnos() {
			// cantidad de alumnos
			return listaAlumnos.size();
		}
		
		//obtener alumno de lista		
		public Alumno getAlumno(int i) {
			// retornar un objeto alumnos
			return listaAlumnos.get(i);
		}
		
		// buscar alumno con el metodo getAlumno
		public Alumno buscarAlumno(int codAlumno) {
			for (int i=0; i<tamanoListaAlumnos(); i++)
				if (getAlumno(i).getCodAlumno() == codAlumno)
					return getAlumno(i);
			return null;
		}
		
		// retornar el mayor codigo de alumno registrado
		public int codMayor() {
			int codigo = 1000;
			for (int i = 0; i < tamanoListaAlumnos(); i++) {
				if(getAlumno(i).getCodAlumno() > codigo)
					codigo = getAlumno(i).getCodAlumno();
			}
			return codigo;
		}
		
		
		
		// exportar alumnos a alumnos.txt
		public void exportarAlumno() {
			
			PrintWriter pw;
			try {
				
				pw = new PrintWriter(new FileWriter("alumnos.txt"));

				Alumno alum;
				int cod,edad,cel,estado;
				String nom,apell,dni;
				
				for (int i = 0; i < listaAlumnos.size(); i++) {
					
					alum = listaAlumnos.get(i);
					
					cod = alum.getCodAlumno();
					nom = alum.getNombres();
					apell = alum.getApellidos();
					dni = alum.getDni();
					edad = alum.getEdad();
					cel = alum.getCelular();
					estado = alum.getEstado();
					
					
					pw.println(cod+","+nom+","+apell+","+dni+","+edad+","+cel+","+estado);
					
				}
				
				pw.close();
			}catch (IOException e) {
				
				e.printStackTrace();
			 }			
		}
		
		
		//importar alumnos de alumnos.txt
		private void importarAlumno() {
			
			try {
				
				Alumno alum;
				String linea, sep[];
				
				BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));
				
				while ((linea = br.readLine()) != null) {
					
					sep = linea.split(",");
					
					alum = new Alumno(Integer.parseInt(sep[0]), sep[1], sep[2], sep[3], Integer.parseInt(sep[4]), Integer.parseInt(sep[5]), Integer.parseInt(sep[6]));
				
					listaAlumnos.add(alum);
				}
				
				br.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	

}

