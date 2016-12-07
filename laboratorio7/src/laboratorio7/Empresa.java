
package laboratorio7;


public class Empresa {

    private Empleado empleados[];
    private final int NUMERO_EMPLEADOS = 20;
    private int intercambios = 0;
    private int comparaciones = 0;
    

    public Empresa() {
        int codigos[] = {204, 305, 105, 204, 415, 106, 500, 100, 540, 420,
            100, 215, 340, 180, 600, 312, 147, 165, 510, 601};
        String nombres[] = {"Juan", "Ana", "Rosa", "Carlos", "Raúl",
            "Pedro", "Rosario", "Martha", "Saúl", "Karen", "Rosa", "Francis", "Ricardo",  "Luis", "Dámaris",
                "Diana", "Pablo","Marcelo", "Carolina", "Ingrid"};
        float sueldos[] = {1500, 800, 2000, 550, 1200, 3500, 1800, 900, 750, 4000,
            750, 1500, 1200, 3500, 4000, 1800, 950, 1400, 600, 5500};
        empleados = new Empleado[NUMERO_EMPLEADOS];
        for (int i = 0;
                i < empleados.length;
                i++) {
            empleados[i] = new Empleado(codigos[i], nombres[i], sueldos[i]);
        }
    }
   
   /* public Empleado getEmpleado(int i){
        Empleado e= new Empleado(0, "", 0);
        if(e.equals(getCodigoDelEmpleado(i))){
            return e;
        }
        
    }*/
    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public int getCodigoDelEmpleado(int i) {
        return empleados[i].getCodigoDelEmpleado();
    }

    public void setCodigoDelEmpleado(int codigo, int i) {
        empleados[i].setCodigoDelEmpleado(codigo);
    }
    

    
 public String getNombreDelEmpleado(int i) {
        return empleados[i].getNombreDelEmpleado();
    }

    public void setNombreDelEmpleado(String nombre, int i) {
        empleados[i].setNombreDelEmpleado(nombre);
    }

    public float getSueldoDelEmpleado(int i) {
        return empleados[i].getSueldoDelEmpleado();
    }

    public void setSueldoDelEmpleado(float sueldo, int i) {
        empleados[i].setSueldoDelEmpleado(sueldo);
    }

    public int getNumeroDeEmpleados() {
        return NUMERO_EMPLEADOS;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void OrdenBurbuja() {
        Empleado temp = new Empleado(0, "", 0);
        comparaciones = 0;
        intercambios = 0;
        for (int i = 1; i < empleados.length; i++) {
            for (int j = empleados.length - 1; j >= i; j--) {
                comparaciones++;
                if (empleados[j - 1].getCodigoDelEmpleado()
                        > empleados[j].getCodigoDelEmpleado()) {
                    temp.setCodigoDelEmpleado(empleados[j - 1].
                            getCodigoDelEmpleado());
                    empleados[j - 1].setCodigoDelEmpleado(empleados[j].
                            getCodigoDelEmpleado());
                    empleados[j].setCodigoDelEmpleado(temp.
                            getCodigoDelEmpleado());
                    temp.setNombreDelEmpleado(empleados[j - 1].getNombreDelEmpleado());
 empleados[j - 1].setNombreDelEmpleado(empleados[j].
                            getNombreDelEmpleado());
                    empleados[j].setNombreDelEmpleado(temp.
                            getNombreDelEmpleado());
                    temp.setSueldoDelEmpleado(empleados[j - 1].
                            getSueldoDelEmpleado());
                    empleados[j - 1].setSueldoDelEmpleado(empleados[j].
                            getSueldoDelEmpleado());
                    empleados[j].setSueldoDelEmpleado(temp.
                            getSueldoDelEmpleado());
                    intercambios++;
                }
            }
        }
    }
    public void OrdenSeleccionDirecta(){
        Empleado temp =new Empleado(0, "", 0);
        comparaciones  = 0;
        intercambios = 0;
        int ind=0;
        boolean cambio= false;
        Empleado menor =new Empleado(0, "", 0);
        for(int i=0; i<empleados.length; i++){
            comparaciones++;
            menor.setCodigoDelEmpleado(empleados[i].getCodigoDelEmpleado());
            menor.setNombreDelEmpleado(empleados[i].getNombreDelEmpleado());
            menor.setSueldoDelEmpleado(empleados[i].getSueldoDelEmpleado());
            for (int j = i; j < empleados.length; j++) {
                if(empleados[j].getCodigoDelEmpleado()<menor.getCodigoDelEmpleado()){
                     menor.setCodigoDelEmpleado(empleados[j].getCodigoDelEmpleado());
                     menor.setNombreDelEmpleado(empleados[j].getNombreDelEmpleado());
                     menor.setSueldoDelEmpleado(empleados[j].getSueldoDelEmpleado());     
                    ind =j;
                    cambio=true;
                }
            }
            if (cambio==true) {
                 temp.setCodigoDelEmpleado(menor.getCodigoDelEmpleado());
                 temp.setNombreDelEmpleado(menor.getNombreDelEmpleado());
                 temp.setSueldoDelEmpleado(menor.getSueldoDelEmpleado());
                 empleados[ind].setCodigoDelEmpleado(empleados[i].getCodigoDelEmpleado());
                 empleados[ind].setNombreDelEmpleado(empleados[i].getNombreDelEmpleado());
                 empleados[ind].setSueldoDelEmpleado(empleados[i].getSueldoDelEmpleado());
                  empleados[i].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
                 empleados[i].setNombreDelEmpleado(temp.getNombreDelEmpleado());
                 empleados[i].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
                
                intercambios++;
            }
            cambio=false;
            
        }
        
        
    }

    public void OrdenInsercionDirecta() {
        Empleado temp = new Empleado(0, "", 0);
        comparaciones = 0;
        intercambios = 0;
        int k;
        for (int i = 1; i < empleados.length; i++) {
            comparaciones++;
            temp.setCodigoDelEmpleado(empleados[i].getCodigoDelEmpleado());
            temp.setNombreDelEmpleado(empleados[i].getNombreDelEmpleado());
            temp.setSueldoDelEmpleado(empleados[i].getSueldoDelEmpleado());
            k = i - 1;
            while (k >= 0 && temp.getCodigoDelEmpleado() < empleados[k].getCodigoDelEmpleado()) {
                empleados[k + 1].setCodigoDelEmpleado(empleados[k].getCodigoDelEmpleado());
                empleados[k + 1].setNombreDelEmpleado(empleados[k].getNombreDelEmpleado());
                empleados[k + 1].setSueldoDelEmpleado(empleados[k].getSueldoDelEmpleado());
                k--;
                intercambios++;
            }
            empleados[k + 1].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
            empleados[k + 1].setNombreDelEmpleado(temp.getNombreDelEmpleado());
            empleados[k + 1].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
        }
    }

}
