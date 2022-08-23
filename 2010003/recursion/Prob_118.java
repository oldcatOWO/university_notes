public class Prob_118 {
  class Tablero {
    StringBuilder casillas;

    public Tablero(String estadoInicial) {
      casillas = new StringBuilder(estadoInicial);
    }

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
        if (casillas.charAt(indice) == fichaActual) {

        } else {

        }
      }

      return fichasTienenAdyacentes;
    }
  }

  public void solve() {

  }
}