/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.laboratorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tineo
 */
public class Principal {

    static ArrayList<Object[]> lista = new ArrayList<>();
    static MyMochila ventana = new MyMochila();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ventana.setVisible(true);

        ventana.getTxtCapacidad().setText("11");
        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (!ventana.getTxtPeso().getText().equals("")
                        && !ventana.getTxtValor().getText().equals("")
                        && !ventana.getTxtCapacidad().getText().equals("")) {

                    ventana.getjButton1().setEnabled(true);
                } else {
                    ventana.getjButton1().setEnabled(false);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (!ventana.getTxtPeso().getText().equals("")
                        && !ventana.getTxtValor().getText().equals("")
                        && !ventana.getTxtCapacidad().getText().equals("")) {
                    ventana.getjButton1().setEnabled(true);
                } else {
                    ventana.getjButton1().setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                if (!ventana.getTxtPeso().getText().equals("")
                        && !ventana.getTxtValor().getText().equals("")
                        && !ventana.getTxtCapacidad().getText().equals("")) {
                    ventana.getjButton1().setEnabled(true);

                    calcular();

                } else {
                    ventana.getjButton1().setEnabled(false);
                }

            }
        };

        ventana.getTxtPeso().getDocument().addDocumentListener(dl);
        ventana.getTxtValor().getDocument().addDocumentListener(dl);
        ventana.getTxtCapacidad().getDocument().addDocumentListener(dl);

        ventana.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lista.clear();

                DefaultTableModel tm = (DefaultTableModel) ventana.getTablaInicial().getModel();

                try {

                    for (int r = 0; r < tm.getRowCount(); r++) {

                        Object row[] = new Object[2];
                        for (int c = 0; c < tm.getColumnCount(); c++) {

                            row[c] = tm.getValueAt(r, c);

                        }

                        lista.add(row);

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                lista.add(new Object[]{ventana.getTxtPeso().getText(), ventana.getTxtValor().getText()});

                ventana.getTxtPeso().setText("");
                ventana.getTxtValor().setText("");

                Object[][] data = lista.toArray(new Object[1][lista.size()]);
                tm.setDataVector(data, new Object[]{"Peso", "Valor"});

                calcular();

            }

        });

        ventana.getTxtCapacidad().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        ventana.getjButton2().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lista.size() > 0) {
                    calcular();
                }
            }
        });

        ventana.getjButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int epeso[] = {1, 2, 5, 8, 10, 14, 18, 22}; //Pesos de los objetos
                int evalor[] = {1, 6, 10, 15,18, 25, 50, 70}; //Valores de los objetos

                ArrayList<Object[]> ejemplos = new ArrayList<Object[]>();

                try {

                    for (int r = 0; r < epeso.length; r++) {

                        Object row[] = new Object[2];
                        for (int c = 0; c < 2; c++) {

                            if (c == 0) {
                                row[0] = epeso[r];
                            }
                            if (c == 1) {
                                row[1] = evalor[r];
                            }

                        }

                        if (epeso[r] != 0) {
                            ejemplos.add(row);
                        }

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel tme = (DefaultTableModel) ventana.getTablaInicial().getModel();
                System.out.println("size: " + ejemplos.size());
                Object[][] sdata = ejemplos.toArray(new Object[1][ejemplos.size()]);
                tme.setDataVector(sdata, new Object[]{"Peso", "Valor"});
                
                ventana.getTxtCapacidad().setText("60");
                
                
                
                
                
                lista.clear();

                DefaultTableModel tm = (DefaultTableModel) ventana.getTablaInicial().getModel();

                try {

                    for (int r = 0; r < tm.getRowCount(); r++) {

                        Object row[] = new Object[2];
                        for (int c = 0; c < tm.getColumnCount(); c++) {

                            row[c] = tm.getValueAt(r, c);

                        }

                        lista.add(row);

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                
                
                calcular();

            }
        });

    }

    static void calcular() {

        int peso[] = new int[lista.size()];
        int valor[] = new int[lista.size()];

        for (int x = 0; x < lista.size(); x++) {
            peso[x] = Integer.parseInt(String.valueOf(lista.get(x)[0]));
            valor[x] = Integer.parseInt(String.valueOf(lista.get(x)[1]));

            System.out.println(String.valueOf(lista.get(x)[0]));
            System.out.println(String.valueOf(lista.get(x)[1]));
        }
        //int peso[] = {1, 2, 5, 6, 7}; //Pesos de los objetos
        //int valor[] = {1, 6, 18, 22, 28}; //Valores de los objetos
        //int capacidad = 11; // Capacidad de la mochila
        int capacidad = Integer.parseInt(ventana.getTxtCapacidad().getText());
        int valorMaximo; // Máximo valor de objetos elegidos
        int n = peso.length; // Número de objetos

        // Crea el objeto mochila
        Mochila miMochila = new Mochila(peso, valor, capacidad);

        //Calcula el valor máximo total de los objetos elegidos
        valorMaximo = miMochila.elegirObjetos();

        System.out.printf("Valor máximo total = %d\n\n", valorMaximo);

        System.out.printf("Tabla de valores máximos\n");
        System.out.printf("------------------------\n");
        System.out.printf("\t |");
        for (int j = 1;
                j
                <= capacidad;
                j++) {
            System.out.printf(
                    "\t%d", j);
        }
        System.out.println();
        for (int j = 1;
                j
                <= capacidad;
                j++) {
            System.out.print(
                    "-----");
        }
        System.out.println();

        for (int i = 1;
                i
                <= n;
                i++) {
            System.out.printf("\t%d|", i);
            for (int j = 1; j <= capacidad; j++) {
                System.out.printf("\t%d", miMochila.getV(i, j));
            }
            System.out.println();
        }

        // Hallar la secuencia de objetos elegidos
        miMochila.Componer();

        System.out.printf(
                "\nObjetos elegidos\n");
        System.out.printf(
                "----------------\n\n");

        int speso[] = new int[n];
        int svalor[] = new int[n];

        for (int i = 1, ix = 0; i <= n; i++) {
            if (miMochila.getElegido(i) == 1) {

                speso[ix] = miMochila.getPeso(i);
                svalor[ix] = miMochila.getValor(i);
                ix++;
                System.out.println("ix" + ix);

                System.out.printf("Objeto %d: \tPeso = %d, Valor =  % d\n\n ", i, miMochila.getPeso(i), miMochila.getValor(i));
            }

        }

        ArrayList<Object[]> solucion = new ArrayList<Object[]>();

        try {

            for (int r = 0; r < n; r++) {

                Object row[] = new Object[2];
                for (int c = 0; c < 2; c++) {

                    if (c == 0) {
                        row[0] = speso[r];
                    }
                    if (c == 1) {
                        row[1] = svalor[r];
                    }

                }

                if (speso[r] != 0) {
                    solucion.add(row);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        DefaultTableModel tme = (DefaultTableModel) ventana.getTablaElegidos().getModel();
        System.out.println("size: " + solucion.size());
        Object[][] sdata = solucion.toArray(new Object[1][solucion.size()]);
        tme.setDataVector(sdata, new Object[]{"Peso", "Valor"});

    }

}
