import javax.swing.*;

public class Main {

    static int fact_o = 0;
    static int ifact_o = 0;
    static int mcd_o = 0;
    static int imcd_o = 0;
    static int fib_o = 0;
    static int ifib_o = 0;


    /* Factorial Recusivo */
    static int factorial(int num){
        fact_o++; // (>)
        if(num > 0) {
            fact_o ++; // (*)
            fact_o ++; // (-)
            return num * factorial(num - 1);
        }
        return 1;
    }

    /* MCD Recusivo */
    static int mcd(int n, int m){
        int r = 0; mcd_o++; // (=)
        if(m == n ) r = n; mcd_o+=2; // (==) y (=)
        if(n>m) r = mcd(n-m, m); mcd_o+=2; // (>) y (-)
        if(n<m) r = mcd(n, m-n); mcd_o+=2; // (<) y (-)
        return r;
    }

    /* Fibonacci Recusivo */
    static int fibonacci(int n){
        int f = 0; fib_o++; // (=)
        if(n>=1){ f = n; fib_o+=2; } // (>=) y (=)
        if(n>1) {f = fibonacci(n-1) + fibonacci(n-2); fib_o+=5; }  // (>), (=), (-) , (+) y (-)

        return f;
    }

    /* Factorial Iterativo */
    static int iter_factorial( int n ){
        int producto = 1; ifact_o ++; //(=)
        for ( int j=1; j<=n; j++ ){
            producto *= j; ifact_o +=1;
        }
        return producto;
    }

    /* MCD Iterativo */
    static int iter_mcd( int m, int n ){
        int r, i;
        while(n!=0){
            r = m % n; ifact_o +=2; // (=) y (%)
            m = n; // (=)
            n = r; // (=)
        }
        return m;
    }
    /* Fibonacci Iterativo */
    static int iter_fibonacci(int n) {
        if (n <= 2) { ifib_o++; // (=)
            return 1;
        }
        int a = 1, b = 1, c;
        for (int i = 0; i < n - 2; ++i) {
            c = a + b; ifib_o+=2; // (=) y (+)
            b = a; ifib_o++; // (=)
            a = c; ifib_o++; // (=)
        }
        return a;
    }

    /* movimiento Hanoi */
    static void mover(int n, String origen, String aux, String destino) {
        if (n == 1) {
            JOptionPane.showMessageDialog(null,origen + " -> " + destino);
        } else {
            mover(n - 1, origen, destino, aux);
            JOptionPane.showMessageDialog(null,origen + " -> " + destino);
            mover(n - 1, aux, origen, destino);
        }
    }


    static void menu_fact(){
        int num;
        String value;

        do {
            value = JOptionPane.showInputDialog("Ingresa el Numero");
        }while (!(value.chars().allMatch( Character::isDigit ) && Integer.parseInt(value) >= 0)) ;
        num = Integer.parseInt(value);

        int fact = factorial(num);
        int ifact = iter_factorial(num);
        JOptionPane.showMessageDialog(null,num+"! = "+fact+"\n\n" +
                "Recursivo O(n) : "+ fact_o +"\n" +
                "Iterativo O(n) : "+ ifact_o +"\n"
        );

        fact_o = 0;
        ifact_o = 0;

        menu();
    }
    static void menu_mcd(){
        int num1, num2;
        String value;

        do {
            value = JOptionPane.showInputDialog("Ingresa el Numero M");
        }while (!(value.chars().allMatch( Character::isDigit )  && Integer.parseInt(value) >= 0));
        num1 = Integer.parseInt(value);

        do {
            value = JOptionPane.showInputDialog("Ingresa el Numero M");
        }while (!(value.chars().allMatch( Character::isDigit ) && Integer.parseInt(value) >= 0));
        num2 = Integer.parseInt(value);

        int max = mcd(num1, num2);
        int imax = iter_mcd(num1, num2);
        JOptionPane.showMessageDialog(null,"MCD("+num1+","+num2+")= "+max+"\n\n" +
                "Recursivo O(n) : "+ mcd_o +"\n" +
                "Iterativo O(n) : "+ imcd_o +"\n");

        mcd_o = 0;
        imcd_o = 0;

        menu();
    }

    static void menu_fib(){
        int num3;
        String value;
        do {
            value = JOptionPane.showInputDialog("Ingresa el Numero");
        }while (!(value.chars().allMatch( Character::isDigit ) && Integer.parseInt(value) >= 0) );
        num3 = Integer.parseInt(value);


        int fib = fibonacci(num3);
        int ifib = iter_fibonacci(num3);
        JOptionPane.showMessageDialog(null,"Fibonacci("+num3+") = "+fib+"\n\n" +
                "Recursivo O(n) : "+ fib_o +"\n" +
                "Iterativo O(n) : "+ ifib_o +"\n");

        fib_o = 0;
        ifib_o = 0;

        menu();
    }

    static void menu_hanoi(){

        int discos;
        String value;
        do {
            value = JOptionPane.showInputDialog("Ingresa el Numero de Discos");
        }while (!(value.chars().allMatch( Character::isDigit ) && Integer.parseInt(value) >= 0) );
        discos = Integer.parseInt(value);

        mover(discos, "A", "B", "C");



    }

    static void menu(){
        String value;

        int opc = 0;

        do {
            value = JOptionPane.showInputDialog("" +
                    "1> Calculo Factorial\n" +
                    "2> Calculo MCD\n" +
                    "3> Calculo Fibonacci\n"+
                    "4> Torre de Hanoi\n"
            );
            if(value == null) System.exit(0);
        }while (!(
                value.matches(".*\\d.*")
                        && Integer.parseInt(value) > 0
                        && Integer.parseInt(value) < 5));
        opc = Integer.parseInt(value);

        switch (opc){
            case 1: menu_fact(); break;
            case 2: menu_mcd(); break;
            case 3: menu_fib(); break;
            case 4: menu_hanoi(); break;
        }
    }


    public static void main(String[] args) {

        //System.out.println("Hello World!");

        menu();


    }
}
