package org.lya.sesion06;

public class MatrizEnterosCuadrada {

	private int[][] matriz;
	
	public MatrizEnterosCuadrada(int numeroFilasCol) {
		
		this.matriz = new int[numeroFilasCol][numeroFilasCol];
		
		for(int index = 0; index < numeroFilasCol; index++) {
			
			for(int index2 = 0; index2 < numeroFilasCol; index2++) {
				
				this.matriz[index][index2] = (int) Math.floor(Math.random()*50 + 1);
			}
		}
	}
	
	public MatrizEnterosCuadrada(int[][] m) {
		
		this.matriz = m;
	}
	
	public static void burbujaMejora(int[] array) {
		
		boolean cambiado = true;
		int i = 1;
		
		while(cambiado && (i < array.length)) {
			
			cambiado = false;
			
			for(int j = 0; j < array.length - i; j++) {
				
				if(array[j] > (array[j + 1])) {
					
					//Intercambio
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
					cambiado = true;
				}
			}
			
			i++;
		}
	}
	
	
	public String toString() {
		
		String cadena = "Matriz:";
		
		for(int index = 0; index < this.matriz.length; index++) {
			
			cadena += "\n";
			
			for(int index2 = 0; index2 < this.matriz[index].length; index2++) {
				
				if(index2 == this.matriz[index].length - 1) {
					cadena += this.matriz[index][index2];
				}else {
					cadena += this.matriz[index][index2] + "\t";
				}
				
			}
		}
		
		return cadena;
	}

	
	public MatrizEnterosCuadrada matrizOrdenadaPorFilas() {
		
		MatrizEnterosCuadrada nueva_matriz = new MatrizEnterosCuadrada(this.matriz.length);
		
		for(int index = 0; index < this.matriz.length; index++) {
			
			for(int index2 = 0; index2 < this.matriz[0].length; index2++) {
				
				nueva_matriz.matriz[index][index2] = this.matriz[index][index2];
			}
		}
		
		for(int index = 0; index < this.matriz.length; index++) {
			
			burbujaMejora(nueva_matriz.matriz[index]);
		}
		
		return nueva_matriz;
	}

	
	public int getNumeroDeFilas() {
		
		return this.matriz.length;
	}
	
	
	public int getNumeroDeColumnas() {
		
		return this.matriz[0].length;
	}
}

