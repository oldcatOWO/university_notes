import java.util.ArrayList;
import java.util.List;

public class Prob_16 {
  public static void main(String[] args) {
    new Prob_16().solve();
  }

  public void solve() {
    Numero n10 = new Numero(10);
    System.out.println("Los fragmentos de n=10 y b=3 son: " + n10.obtenerFragmentos(new Numero(3)));
  }

  // Declaramos la clase Numero
  class Numero {
    int numero;

    public Numero(int numero) {
      this.numero = numero;
    }

    /**
     * Metodo que obtiene los fragmentos de explotar el numbero con la bomba
     * Aplica recursividad al invocar al mismo metodo de los fragmentos resultantes
     * de la explosion
     * 
     * @param bomba
     * @return
     */
    public List<Numero> obtenerFragmentos(Numero bomba) {
      // Declaramos e inicializamos la lista de fragmentos
      List<Numero> fragmentos = new ArrayList<>();

      // Caso recursivo numero > bomba
      // Si este numero es mayor que la bomba explota en dos fragmentos n1 y n2
      if (this.esMayorQue(bomba)) {
        // Creamos los nuevos fragmentos
        Numero n1 = new Numero((numero / bomba.numero));
        Numero n2 = new Numero(numero - (numero / bomba.numero));
        // Agregamos los nuevos fragmentos a la lista
        fragmentos.add(n1);
        fragmentos.add(n2);
        // Agregamos (addAll) todos los fragmentos de n1 y n2 si estos pueden explotar
        // con la bomba, caso contrario solo seran vacios {} lo cual es un Caso base
        // numero < bomba
        fragmentos.addAll(n1.obtenerFragmentos(bomba));
        fragmentos.addAll(n2.obtenerFragmentos(bomba));
      }

      return fragmentos;
    }

    public boolean esMayorQue(Numero otro) {
      return numero > otro.numero;
    }

    /**
     * Metodo que retorna la representacion del objecto Numero en string
     */
    @Override
    public String toString() {
      return numero + "";
    }
  }
}