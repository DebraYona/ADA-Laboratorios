/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio5;

/**
 *
 * @author Laboratorio 05
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.swing.JOptionPane;

public class DarCambio {

    public static void main(String[] args) {

        Ventana ventana = new Ventana();
        ventana.setVisible(true);

        



        ventana.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                //ventana.jTextField1.setText("75");
                //ventana.jTextField2.setText("2.5");
                
                String recibido = ventana.jTextField1.getText();
                //System.out.println("r "+recibido);
                String monto = ventana.jTextField2.getText();
                //System.out.println("m "+monto);
                
                double drecibido = Double.parseDouble(recibido);
                double dmonto = Double.parseDouble(monto);

                int s[] = { 0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0};
                double v[] = {200,100,50,20,10,  5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01};
              
                Cambio moneda = new Cambio();
               

               
                double vuelto = drecibido - dmonto;
                double parteEntera, resultado;
                resultado=vuelto;
                parteEntera=Math.floor(resultado);
                resultado= (resultado-parteEntera)*Math.pow(10,2);
                resultado= Math.round(resultado);
                resultado=(resultado/Math.pow(10, 2))+parteEntera;
                vuelto =resultado;
                   
              
                
                moneda.Voraz(s, v, vuelto);

                String sol = "Dar cambio de "+vuelto+" soles\n";
                if (moneda.Solucion(s, v, vuelto)) {
                    System.out.println("ok");
                    for (int i = 0; i < s.length; i++) {
                        if (s[i] > 0) {
                            
                            sol += (s[i] + " monedas de " + v[i] + " soles\n");
                            //System.out.printf("%d monedas de %.2f soles\n", s[i], v[i]);
                        }
                    }
                    

                    JOptionPane.showMessageDialog(ventana, sol, "CAMBIO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //System.out.println("No hay solucion");
                }

            }
        });

    }
}
