package laboratorio7;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ComparaOrden {

    static Ventana ventana = new Ventana();
    static ArrayList<Empresa[]> lista = new ArrayList<>();

    public static void main(String[] args) {
        ventana.setVisible(true);

        Empresa miEmpresa1 = new Empresa();
        Empresa miEmpresa2 = new Empresa();
        Empresa miEmpresa3 = new Empresa();

        System.out.println("\nMetodo de la Burbuja");
        System.out.println("--------------------------------");
        miEmpresa1.OrdenBurbuja();
        for (int i = 0; i < miEmpresa1.getNumeroDeEmpleados(); i++) {

            System.out.printf("%10d%10s%10.2f\n",
                    miEmpresa1.getCodigoDelEmpleado(i),
                    miEmpresa1.getNombreDelEmpleado(i),
                    miEmpresa1.getSueldoDelEmpleado(i));

        }

        ArrayList<Object[]> ejemplos = new ArrayList<Object[]>();

        DefaultTableModel tmb = (DefaultTableModel) ventana.getTablaBurbuja().getModel();
        try {

            for (int r = 0; r < miEmpresa1.getNumeroDeEmpleados(); r++) {

                Object row[] = new Object[3];
                for (int c = 0; c < 3; c++) {

                    if (c == 0) {
                        row[0] = miEmpresa1.getCodigoDelEmpleado(r);
                    }
                    if (c == 1) {
                        row[1] = miEmpresa1.getNombreDelEmpleado(r);
                    }
                    if (c == 2) {
                        row[2] = miEmpresa1.getSueldoDelEmpleado(r);
                    }

                }
                if (miEmpresa1.getCodigoDelEmpleado(r) != 0) {
                    ejemplos.add(row);

                }

                tmb.addRow(row);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.printf("Numero de comparaciones: %d\n",
                miEmpresa1.getComparaciones());

        ventana.getCompaBurbuja().setText(String.valueOf(miEmpresa1.getComparaciones()));
        System.out.printf("Numero de intercambios: %d\n",
                miEmpresa1.getIntercambios());
        ventana.getIteraburbuja().setText(String.valueOf(miEmpresa1.getIntercambios()));

        System.out.println("\nMetodo Insercion Directa");
        System.out.println("--------------------------");
        miEmpresa2.OrdenInsercionDirecta();

        System.out.println();
        for (int i = 0; i < miEmpresa2.getNumeroDeEmpleados(); i++) {
            System.out.printf("%10d%10s%10.2f\n",
                    miEmpresa2.getCodigoDelEmpleado(i),
                    miEmpresa2.getNombreDelEmpleado(i),
                    miEmpresa2.getSueldoDelEmpleado(i));
        }
        ArrayList<Object[]> ejemplos2 = new ArrayList<Object[]>();

        DefaultTableModel tmi = (DefaultTableModel) ventana.getTablaInsercion().getModel();
        try {

            for (int r = 0; r < miEmpresa2.getNumeroDeEmpleados(); r++) {

                Object row[] = new Object[3];
                for (int c = 0; c < 3; c++) {

                    if (c == 0) {
                        row[0] = miEmpresa2.getCodigoDelEmpleado(r);
                    }
                    if (c == 1) {
                        row[1] = miEmpresa2.getNombreDelEmpleado(r);
                    }
                    if (c == 2) {
                        row[2] = miEmpresa2.getSueldoDelEmpleado(r);
                    }

                }
                if (miEmpresa2.getCodigoDelEmpleado(r) != 0) {
                    ejemplos2.add(row);

                }
                tmi.addRow(row);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.printf("Numero de comparaciones: %d\n",
                miEmpresa2.getComparaciones());
        ventana.getCompaInsercion().setText(String.valueOf(miEmpresa2.getComparaciones()));
        System.out.printf("Numero de intercambios: %d\n",
                miEmpresa2.getIntercambios());
        ventana.getIteraInsercion().setText(String.valueOf(miEmpresa2.getIntercambios()));

        System.out.println("\nMetodo Seleccion Directa");
        System.out.println("--------------------------");
        miEmpresa3.OrdenSeleccionDirecta();

        System.out.println();
        for (int i = 0; i < miEmpresa3.getNumeroDeEmpleados(); i++) {
            System.out.printf("%10d%10s%10.2f\n",
                    miEmpresa3.getCodigoDelEmpleado(i),
                    miEmpresa3.getNombreDelEmpleado(i),
                    miEmpresa3.getSueldoDelEmpleado(i));
        }
        ArrayList<Object[]> ejemplos3 = new ArrayList<Object[]>();

        DefaultTableModel tms = (DefaultTableModel) ventana.getTablaSelecion().getModel();
        try {

            for (int r = 0; r < miEmpresa3.getNumeroDeEmpleados(); r++) {

                Object row[] = new Object[3];
                for (int c = 0; c < 3; c++) {

                    if (c == 0) {
                        row[0] = miEmpresa3.getCodigoDelEmpleado(r);
                    }
                    if (c == 1) {
                        row[1] = miEmpresa3.getNombreDelEmpleado(r);
                    }
                    if (c == 2) {
                        row[2] = miEmpresa3.getSueldoDelEmpleado(r);
                    }

                }
                if (miEmpresa1.getCodigoDelEmpleado(r) != 0) {
                    ejemplos3.add(row);
                    tms.addRow(row);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.printf("Numero de comparaciones: %d\n",
                miEmpresa3.getComparaciones());
        ventana.getCompaSeleccion().setText(String.valueOf(miEmpresa3.getComparaciones()));
        System.out.printf("Numero de intercambios: %d\n",
                miEmpresa3.getIntercambios());
        ventana.getIteraSeleccion().setText(String.valueOf(miEmpresa3.getIntercambios()));

        System.out.printf("Eficiencia segun comparaciones");
        if (miEmpresa1.getComparaciones() > miEmpresa2.getComparaciones()) {
            if (miEmpresa2.getComparaciones() > miEmpresa3.getComparaciones()) {
                System.out.printf("Numero de comparaciones: %d<%d<%d\n  ",
                        miEmpresa3.getComparaciones(), miEmpresa2.getComparaciones(), miEmpresa1.getComparaciones());
                ventana.getCompa1().setText(String.valueOf(miEmpresa3.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa2.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa1.getComparaciones()));


               

            } else {
                System.out.printf("Numero de comparaciones:%d< %d< %d \n ",
                        miEmpresa2.getComparaciones(), miEmpresa3.getComparaciones(), miEmpresa1.getComparaciones());
                 ventana.getCompa1().setText(String.valueOf(miEmpresa2.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa3.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa1.getComparaciones()));
            }
        } else {
            if (miEmpresa2.getComparaciones() > miEmpresa3.getComparaciones()) {
                if (miEmpresa1.getComparaciones() > miEmpresa3.getComparaciones()) {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa3.getComparaciones(), miEmpresa1.getComparaciones(), miEmpresa2.getComparaciones());
                     ventana.getCompa1().setText(String.valueOf(miEmpresa3.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa1.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa2.getComparaciones()));
                } else {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa1.getComparaciones(), miEmpresa3.getComparaciones(), miEmpresa2.getComparaciones());
                     ventana.getCompa1().setText(String.valueOf(miEmpresa1.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa3.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa2.getComparaciones()));
                }
            }
            if (miEmpresa3.getComparaciones() > miEmpresa1.getComparaciones()) {
                if (miEmpresa2.getComparaciones() > miEmpresa1.getComparaciones()) {
                    System.out.printf("Numero de comparaciones:%d< %d< %d \n ",
                            miEmpresa1.getComparaciones(), miEmpresa2.getComparaciones(), miEmpresa3.getComparaciones());
                     ventana.getCompa1().setText(String.valueOf(miEmpresa1.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa2.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa3.getComparaciones()));
                } else {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa2.getComparaciones(), miEmpresa1.getComparaciones(), miEmpresa3.getComparaciones());
                     ventana.getCompa1().setText(String.valueOf(miEmpresa2.getComparaciones()));
                ventana.getCompa2().setText(String.valueOf(miEmpresa1.getComparaciones()));
                ventana.getCompa3().setText(String.valueOf(miEmpresa3.getComparaciones()));
                }
            }
        }
        System.out.printf("Eficiencia segun iteraciones");
        if (miEmpresa1.getIntercambios() > miEmpresa2.getIntercambios()) {
            if (miEmpresa2.getIntercambios() > miEmpresa3.getIntercambios()) {
                System.out.printf("Numero de comparaciones: %d< %d< %d \n  ",
                        miEmpresa3.getIntercambios(), miEmpresa2.getIntercambios(), miEmpresa1.getIntercambios());
                 ventana.getInter1().setText(String.valueOf(miEmpresa3.getIntercambios()));
                ventana.getInter2().setText(String.valueOf(miEmpresa2.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa1.getIntercambios()));
            } else {
                System.out.printf("Numero de comparaciones:%d< %d< %d \n ",
                        miEmpresa2.getIntercambios(), miEmpresa3.getIntercambios(), miEmpresa1.getIntercambios());
                ventana.getInter1().setText(String.valueOf(miEmpresa2.getIntercambios()));
                ventana.getInter2().setText(String.valueOf(miEmpresa3.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa1.getIntercambios()));
            }
        } else {
            if (miEmpresa2.getIntercambios() > miEmpresa3.getIntercambios()) {
                if (miEmpresa1.getIntercambios() > miEmpresa3.getIntercambios()) {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa3.getIntercambios(), miEmpresa1.getIntercambios(), miEmpresa2.getIntercambios());
                    ventana.getInter1().setText(String.valueOf(miEmpresa3.getIntercambios()));
                 ventana.getInter2().setText(String.valueOf(miEmpresa1.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa2.getIntercambios()));
                } else {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa1.getIntercambios(), miEmpresa3.getIntercambios(), miEmpresa2.getIntercambios());
                    ventana.getInter1().setText(String.valueOf(miEmpresa1.getIntercambios()));
                 ventana.getInter2().setText(String.valueOf(miEmpresa3.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa2.getIntercambios()));
                }
            }
            if (miEmpresa3.getIntercambios() > miEmpresa1.getIntercambios()) {
                if (miEmpresa2.getIntercambios() > miEmpresa1.getIntercambios()) {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa1.getIntercambios(), miEmpresa2.getIntercambios(), miEmpresa3.getIntercambios());
                    ventana.getInter1().setText(String.valueOf(miEmpresa1.getIntercambios()));
                 ventana.getInter2().setText(String.valueOf(miEmpresa2.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa3.getIntercambios()));
                } else {
                    System.out.printf("Numero de comparaciones: %d< %d< %d \n ",
                            miEmpresa2.getIntercambios(), miEmpresa1.getIntercambios(), miEmpresa3.getIntercambios());
                    ventana.getInter1().setText(String.valueOf(miEmpresa2.getIntercambios()));
                 ventana.getInter2().setText(String.valueOf(miEmpresa1.getIntercambios()));
                ventana.getInter3().setText(String.valueOf(miEmpresa3.getIntercambios()));
                }
            }
        }
    }

}
