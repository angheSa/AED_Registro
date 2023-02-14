package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import entidades.Retiro;

public class ArregloRetiro {
	// declarar arreglo
				private ArrayList<Retiro> listaRetiros;
				
				// crear constructor
				public ArregloRetiro() {
					listaRetiros = new ArrayList<Retiro>();
					importarRetiro();
				}
				
				public void addRetiro(Retiro e) {

					listaRetiros.add(e);
					//exportarMatriculas();
				}
				
				public int tamanoListaRetiro() {

					return listaRetiros.size();
				}
				public void eliminarRetiro(Retiro r) {
					listaRetiros.remove(r);
					//exportarMatriculas();
				}
				
				public Retiro getRetiros(int i) {
					// retornar un objeto matricula
					return listaRetiros.get(i);
				}
		
			/*	public Retiro buscarAlumno(int codAlumno) {
					for (int i=0; i<tamanoListaMRetiro(); i++)
						if (getRetiros(i).getCodAlumno() == codAlumno)
							return getRetiros(i);
					return null;
				}*/
				public Retiro buscarRetiro(int codReti) {
					Retiro re;
					for (int i=0; i<tamanoListaRetiro(); i++){
						re = getRetiros(i);
						if (re.getNumRetiro() == codReti)
							return re;
					}
					return null;
				}
				public Retiro buscarMatricula(int codigoMatricula){
					for(int i=0; i<tamanoListaRetiro(); i++)
						if(getRetiros(i).getNumMatricula() == codigoMatricula)
							return getRetiros(i);
					return null;
				}
				

				public int generarCodigo() {
					if(listaRetiros.size()==0) {
						return 200001;
					}else {
						return listaRetiros.get(listaRetiros.size()-1).getNumRetiro()+1;
					}
				}
				// exportar 
				public void exportarRetiro() {
					
					PrintWriter pw;
					try {
						
						pw = new PrintWriter(new FileWriter("retiro.txt"));

						Retiro retiro;
						int codRetiro, codMatricula;
						String date, hrs;
					
						for (int i = 0; i < listaRetiros.size(); i++) {
							
							retiro= listaRetiros.get(i);
							
							codRetiro = retiro.getNumRetiro();
							codMatricula = retiro.getNumMatricula();
							date = retiro.getFecha();
							hrs = retiro.getHora();
							
							pw.println(codRetiro+","+codMatricula+","+date+","+hrs);
							
						}
						
						pw.close();
					}catch (IOException e) {
						
						e.printStackTrace();
					 }			
				}
				
				
				// importar 
				private void importarRetiro() {

					try {
						
						Retiro retiro;
						String linea, sep[];
						
						BufferedReader br = new BufferedReader(new FileReader("retiro.txt"));
						
						while ((linea = br.readLine()) != null) {					
							sep = linea.split(",");
							retiro= new Retiro(Integer.parseInt(sep[0]), Integer.parseInt(sep[1]),(sep[2]), sep[3]);		
							listaRetiros.add(retiro);
						}
						
						br.close();
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}


}
