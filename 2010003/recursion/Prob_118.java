import java.util.LinkedList;

public class Prob_118 {
  /**
   * Clase Tablero contiene las casillas con "X" y "O" fichas
   */
  class Tablero {
    StringBuilder casillas;

    /**
     * Clase Movimiento representa el intercambio de las casillas
     * donde se tiene un origen y un destino
     */
    class Movimiento {
      int origen;
      int destino;

      public Movimiento(int origen, int destino) {
        this.origen = origen + 1;
        this.destino = destino + 1;
      }

      @Override
      public String toString() {
        return "intercambiar " + origen + " con " + destino;
      }
    }

    public Tablero(String estadoInicial) {
      casillas = new StringBuilder(estadoInicial);
    }

    /**
     * ordena el tablero y devuelve los movimientos optimos
     * para colocar las fichas con sus adyacentes
     * 
     * @return
     */
    public LinkedList<Movimiento> ordernarTablero() {
      // sobrecarga del metodo con valores iniciales
      return ordernarTablero(0, 1, new LinkedList<>());
    }

    /**
     * devuelve los movimientos optimos para colocar las fichas de tal
     * forma que cada ficha tengo una ficha similar adyacente
     * 
     * @param origen
     * @param destino
     * @param movimientos
     * @return
     */
    private LinkedList<Movimiento> ordernarTablero(int origen, int destino, LinkedList<Movimiento> movimientos) {
      LinkedList<Movimiento> movimientosOptimos = null;
      if (!fichasTienenAdyacentes()) {
        if (destino < casillas.length()) {

          movimientos.addLast(new Movimiento(origen, destino));
          cambiarCasillas(origen, destino);
          LinkedList<Movimiento> movimientosCandidato = ordernarTablero(origen + 1, destino + 1, movimientos);
          movimientosOptimos = seleccionarMovimientosOptimos(movimientosOptimos, movimientosCandidato);

          cambiarCasillas(origen, destino);
          movimientos.removeLast();
          movimientosCandidato = ordernarTablero(origen + 1, destino + 1, movimientos);
          movimientosOptimos = seleccionarMovimientosOptimos(movimientosOptimos, movimientosCandidato);
        }
      } else {
        movimientosOptimos = new LinkedList<>(movimientos);
      }
      return movimientosOptimos;
    }

    /**
     * devuelve la lista de movimientos mas optimos, es decir el que tiene menor
     * numero de movimientos
     * 
     * @param movimientosA
     * @param movimientosB
     * @return
     */
    private LinkedList<Movimiento> seleccionarMovimientosOptimos(LinkedList<Movimiento> movimientosA,
        LinkedList<Movimiento> movimientosB) {
      LinkedList<Movimiento> movimientosOptimos = null;
      if (movimientosA != null || movimientosB != null) {
        if (movimientosA != null && movimientosB != null) {
          movimientosOptimos = new LinkedList<>(
              movimientosA.size() < movimientosB.size() ? movimientosA : movimientosB);
        } else {
          movimientosOptimos = new LinkedList<>(movimientosA == null ? movimientosB : movimientosA);
        }
      }
      return movimientosOptimos;
    }

    /**
     * Cambia (swap) los fichas de la casilla de origen y destino
     * 
     * @param origen
     * @param destino
     */
    private void cambiarCasillas(int origen, int destino) {
      char temporal = casillas.charAt(origen);
      casillas.setCharAt(origen, casillas.charAt(destino));
      casillas.setCharAt(destino, temporal);
    }

    /**
     * Valida si cada ficha tiene un ficha adyacente igual
     * 
     * @return
     */
    public boolean fichasTienenAdyacentes() {
      return fichasTienenAdyacentes(0, 0, casillas.charAt(0));
    }

    private boolean fichasTienenAdyacentes(int indice, int numeroDeFichasIguales, char fichaActual) {
      boolean fichasTienenAdyacentes = false;

      if (indice == casillas.length()) {
        if (numeroDeFichasIguales > 1) {
          fichasTienenAdyacentes = true;
        }
      } else {
        char fichaCasilla = casillas.charAt(indice);
        if (fichaCasilla == fichaActual) {
          fichasTienenAdyacentes = fichasTienenAdyacentes(indice + 1, numeroDeFichasIguales + 1, fichaActual);
        } else {
          if (numeroDeFichasIguales > 1) {
            fichasTienenAdyacentes = fichasTienenAdyacentes(indice + 1, 1, fichaCasilla);
          }
        }
      }

      return fichasTienenAdyacentes;
    }

    private void ordernarTableroLento(int origen, int destino, LinkedList<Movimiento> movimientos) {
      if (!fichasTienenAdyacentes()) {
        if (destino < casillas.length()) {
          movimientos.addLast(new Movimiento(origen, destino));
          cambiarCasillas(origen, destino);
          ordernarTableroLento(origen + 1, destino + 1, movimientos);
          cambiarCasillas(origen, destino);
          movimientos.removeLast();
          ordernarTableroLento(origen + 1, destino + 1, movimientos);
        }
      } else {
        System.out.println(casillas);
        System.out.println(movimientos);
      }
    }
  }

  public void testTableroFichasAdyacentes() {
    System.out.println(new Tablero("OOOOXXXXOOOXX").fichasTienenAdyacentes() + " = true");
    System.out.println(new Tablero("OOXXOXXOOO").fichasTienenAdyacentes() + " = false");
    System.out.println(new Tablero("XX").fichasTienenAdyacentes() + " = true");
    System.out.println(new Tablero("O").fichasTienenAdyacentes() + " = false");
  }

  public void testTableroOrdenarTablero() {
    System.out.println(new Tablero("XOXXOOOX").ordernarTablero()
        + " = [intercambiar 2 con 3, intercambiar 4 con 5, intercambiar 5 con 6, intercambiar 6 con 7]");
    System.out.println(new Tablero("OOXOXOO").ordernarTablero() + " = [intercambiar 4 con 5]");
    System.out.println(new Tablero("XXOOXXOOO").ordernarTablero() + " = []");
    System.out.println(new Tablero("OXOXOO").ordernarTablero() + " = [intercambiar 2 con 3");
  }

  public void solve() {
    // testTableroFichasAdyacentes();
    // testTableroOrdenarTablero();

    Tablero tablero = new Tablero("XOXXOOOX");
    System.out.println(tablero.ordernarTablero());
  }

  public static void main(String[] args) {
    new Prob_118().solve();
  }
}