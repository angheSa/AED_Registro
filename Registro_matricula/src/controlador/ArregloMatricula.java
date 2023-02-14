package controlador;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidades.Matricula;

public class ArregloMatricula {
	// declarar arreglo
			private ArrayList<Matricula> listaMatriculas;
			
			// crear constructor
			public ArregloMatricula() {
				listaMatriculas = new ArrayList<Matricula>();
				importarMatriculas();
			}
			
			public void addMatriculas(Matricula c) {
				// agregar matricula
				listaMatriculas.add(c);

			}
			
			public int tamanoListaMatriculas() {
				// cantidad de matricula
				return listaMatriculas.size();
			}
			public void eliminarMatricula(Matricula m) {
				listaMatriculas.remove(m);
				exportarMatriculas();
			}
			
			public Matricula getMatriculas(int i) {
				// retornar un objeto matricula
				return listaMatriculas.get(i);
			}
	
			public Matricula buscarAlumno(int codAlumno) {
				for (int i=0; i<tamanoListaMatriculas(); i++)
					if (getMatriculas(i).getCodAlumno() == codAlumno)
						return getMatriculas(i);
				return null;
			}
			
			public Matricula buscarMatricula(int codMatri) {
				Matricula ma;
				for (int i=0; i<tamanoListaMatriculas(); i++){
					ma = getMatriculas(i);
					if (ma.getNumMatricula() == codMatri)
						return ma;
				}
				return null;
			}
			

			public int generarCodigo() {
				if(listaMatriculas.size()==0) {
					return 100001;
				}else {
					return listaMatriculas.get(listaMatriculas.size()-1).getNumMatricula()+1;
				}
			}
			// exportar matriculas a matriculas.txt
			public void exportarMatriculas() {
				
				PrintWriter pw;
				try {
					
					pw = new PrintWriter(new FileWriter("matricula.txt"));

					Matricula matri;
					int codCur, codAlum,num;
					String date, hrs;
				
					for (int i = 0; i < listaMatriculas.size(); i++) {
						
						matri= listaMatriculas.get(i);
						
						num = matri.getNumMatricula();
						codAlum = matri.getCodAlumno();
						codCur = matri.getCodCurso();
						date = matri.getFecha();
						hrs = matri.getHora();
						pw.println(num+","+codAlum+","+codCur+"," +date+","+hrs);
						
					}
					
					pw.close();
				}catch (IOException e) {
					
					e.printStackTrace();
				 }			
			}
			
			
			// importar 
			private void importarMatriculas() {

				try {
					
					Matricula matri;
					String linea, sep[];
					
					BufferedReader br = new BufferedReader(new FileReader("matricula.txt"));
					
					while ((linea = br.readLine()) != null) {					
						sep = linea.split(",");
						matri= new Matricula(Integer.parseInt(sep[0]), Integer.parseInt(sep[1]), Integer.parseInt(sep[2]),(sep[3]), sep[4]) ;		
						listaMatriculas.add(matri);
					}
					
					br.close();
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}

				
	
}
