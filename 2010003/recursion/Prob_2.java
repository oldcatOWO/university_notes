public class Prob_2 {
  public static void main(String[] args) {
    new Prob_2().solve();
  }

  public void solve() {
    Numero n2 = new Numero(2);
    Numero n33 = new Numero(33);
    Numero n17 = new Numero(17);
    Numero n24 = new Numero(82);

    System.out.println(n2 + (n2.esPrimo() ? " es primo " : " no es primo"));
    System.out.println(n33 + (n33.esPrimo() ? " es primo " : " no es primo"));
    System.out.println(n17 + (n17.esPrimo() ? " es primo " : " no es primo"));
    System.out.println(n24 + (n24.esPrimo() ? " es primo " : " no es primo"));
  }

  // Declaramos una clase Numero para resolver el problema
  class Numero {
    int numero;

    public Numero(int numero) {
      this.numero = numero;
    }

    /**
     * Metodo que invoca a un metodo interno recursivo enviando argumentos como el
     * valor de un divisor
     * en este caso 2, aplicando un algoritmo sencillo
     * 
     * @return
     */
    public boolean esPrimo() {
      return esPrimo(2);
    }

    /**
     * Metodo recursivo con parametro que toma un divisor
     * 
     * @param divisor
     * @return
     */
    private boolean esPrimo(int divisor) {
      // Declaramos la respuesta como verdadero hasta encontrar un divisor desde 2
      boolean es = true;

      // Caso recursivo: si divisor * divisor es menor que numero
      if (divisor * divisor < numero) {
        // Comprobar si numero es divisible por divisor
        if (numero % divisor == 0) {
          // No es primo
          es = false;
        } else {
          // Invocamos esPrimo pero con un divisor incrementado con el cual llegamos
          // a un Caso Base divisor * divisor = numero
          es = esPrimo(divisor + 1);
        }
      }

      return es;
    }

    /**
     * Este metodo lo que hace es representar como una cadena nuestro objecto de
     * tipo Numero
     */
    @Override
    public String toString() {
      return "Numero : " + numero;
    }
  }
}