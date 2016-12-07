
package laboratorio5;

import javax.swing.JOptionPane;



/**
 *
 * @author Debra
 */
public class Backtracking {
    private int suma[];
    private int valores[];
    private int tact;
    private int p;
    private int matriz [][];
    private int contador = 0;
    private int nivel =0;
    
    public Backtracking(int valores[],int suma){
        this.valores=new int [valores.length];
        this.suma=new int[valores.length];
        this.valores=valores;
        tact=0;
        p = suma;
           matriz = new int[valores.length*valores.length-1][valores.length];
            }
    public void hallarSubconjunto(){
        
        boolean fin = false;
       
        for(int i=0;i<suma.length;i++){
            suma[i]=-1;
        }
        
       do {            
            generar(nivel);
             if (solucion(nivel, p)){
                 fin=false;
                 mostrarSolucion();
             }
             else
                 if (criterio (nivel, p)){
                    nivel++;
                    }
                 else
                    while (!masHermanos(nivel)){
                        nivel = retroceder (nivel);
                        if(nivel==-1){
                            fin = true;
                            break;
                        
                    }}
        } while (fin==false);
        
        
    }

    public void generar(int nivel) {
      
     
        suma[nivel] = suma[nivel] + 1;
        if (suma[nivel] == 1)
            tact= tact + valores[nivel];



    }

    public boolean solucion(int nivel, int p) {
      /*  int n=suma.length;
        return (nivel==n-1&& tact ==p);*/
      	int n = suma.length;
    	int suma=0;
    	int band = 0;
    	boolean fin = false;
    	if(tact==p){
    		
    		for(int i =0; i<n;i++){		// BUSCANDO EL -1
        		if(this.suma[i]==-1){
        			band=1;
        		}
        	}
    		
    		if(band == 0){
    			for(int i =0; i<n;i++){		
            		matriz[contador][i]=this.suma[i];
            	}
        		contador++;
    		}
    	
    	}
    	
    	for(int i =0; i<n;i++){
    		suma=suma+this.suma[i];
    			
    	}
    	
    	if(suma==this.suma.length){
			fin = true;
		}
    	
    	return (nivel == n-1 && fin);    
    }

    public boolean criterio(int nivel, int p) {
        int n =suma.length;
        return (nivel<n-1 &&tact<=p);
    }

    public boolean masHermanos(int nivel) {
        return (suma[nivel]<1);
    }

    public int retroceder(int nivel) {
        tact -=valores[nivel]*suma[nivel];
        suma[nivel]=-1;
        nivel--;
        return nivel;
    }
    public void mostrarSolucion(){
      /*  String mensaje="";
        mensaje ="Valores:\n{";
        for(int i=0;i<valores.length; i++){
            mensaje += valores[i];
            if(i<valores.length-1)
                mensaje+=", ";
            else 
                mensaje +="}";
        }
        mensaje+="\n\nSolucion Backtraking:\n{";
        for (int i = 0; i < suma.length; i++) {
            mensaje+=suma[i];
            if(i<suma.length-1)
                mensaje+=",";
            else
                mensaje+="}";
        }
        mensaje+= "\n\nSubconjunto cuya suma es  "+p+ ":\n{";
        for (int i = 0;i< suma.length ; i++) {
           if (suma[i]==1){
             mensaje += valores[i];
             if (i<suma.length-1)
                mensaje += ", ";
             else
                 mensaje += "}\n";
              }
        }
        JOptionPane.showMessageDialog(null, mensaje,"algoritmos de retroceso (Bactracking)",
                JOptionPane.INFORMATION_MESSAGE);
              
    }*/
      int suma=0;
    	int band = 0;
    	
        for(int j=0; j<this.suma.length*this.suma.length-1;j++){
        	for ( int i=0; i<this.suma.length;i++){
        		
        		for(int k=0;k<this.suma.length;k++){ // Suma una fila de la matriz
        			suma=suma+matriz[j][k];
        		}	
        		if(suma!=0){
        			band=1;
        		}
            }
        	suma=0;
        }
    	if(band==0){
    		JOptionPane.showMessageDialog(null, "No hay solución");
    	}else{
    		String mensaje="";  
            mensaje = "Valores:\n {";  
            
            for (int i=0; i<valores.length; i++)          {              
            	mensaje += valores[i];              
            	if (i<valores.length-1)                  
            		mensaje += ", ";              
            	else                  
            		mensaje += "}";            
            	
            }  
            mensaje += "\n\nSolución Backtracking:\n "; 
          
                /*for (int i=0; i<s.length; i++)          {              
                	mensaje += s[i];              
                	if (i<s.length-1)                  
                		mensaje += ", ";              
                	else                  
                		mensaje += "}";            
                	
                }  */
               
                for(int j=0; j<this.suma.length*this.suma.length-1;j++){
                	for ( int i=0; i<this.suma.length;i++){
                		
                		for(int k=0;k<this.suma.length;k++){ // Suma una fila de la matriz
                			suma=suma+matriz[j][k];
                		}
                		
                		if(suma!=0){
                			mensaje += matriz[j][i];
                        	if (i<this.suma.length-1)                  
                        		mensaje += ", ";              
                        	else                  
                        		mensaje += " || ";
                		}
                    	    
                    }
                	suma=0;
                }
                
            
        
            mensaje += "\n\nSubconjunto cuya suma es "+ p + ":\n ";  
            
            for(int j=0; j<this.suma.length*this.suma.length-1;j++){
            	for ( int i=0; i<this.suma.length;i++){
            		
            		for(int k=0;k<this.suma.length;k++){ // Suma una fila de la matriz
            			suma=suma+matriz[j][k];
            		}
            		
            		if(suma!=0){
            			if(matriz[j][i]!=0){
            				mensaje += matriz[j][i]*valores[i];
            			}
            			
                    	if (i<this.suma.length-1){ 
                    		if(matriz[j][i]!=0){
                    			mensaje += ", ";
                    		}
                    	}
                    	else{                  
                    		mensaje += " || ";
                    	}
            		}
                	    
                }
            	suma=0;
            }
            
             
            JOptionPane.showMessageDialog(null, mensaje,                   
            		"Algoritmos de retroceso (Backtracking)",                  
            		JOptionPane.INFORMATION_MESSAGE);
    	}
}
}
