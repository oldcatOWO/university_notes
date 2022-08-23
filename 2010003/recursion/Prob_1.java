public class Prob_1 {
  public static void main(String[] args) {
    new Prob_1().solve();
  }

  public void solve() {
    System.out.println(potencia(2, 3)); // 8
    System.out.println(potencia(5, 2)); // 25
    System.out.println(potencia(10, 4)); // 10000
  }

  /**
   * Metodo que obtiene la potencia de a ^ b o (a * a * ... * a) b veces
   * de modo recursivo
   * 
   * @param a base
   * @param b exponente (CC: b > -1)
   * @return potencia de a elevado a la b
   */
  public int potencia(int a, int b) {
    // Declaramos potencia con valor inicial a 1
    int potencia = 1;

    // Caso Recursivo
    if (b > 0) {
      // Invocamos a potencia con b - 1 que nos permite llegar al Caso Base b = 0 y
      // frenar la recursion
      potencia = a * potencia(a, b - 1);
    }

    return potencia;
  }

  public int potenciaIterativa(int a, int b) {
    // Defina la potencia de a elevado a la b
    int potencia = 1;

    // Itera hasta que b = 0, si es zero la respuesta es 1
    while (b > 0) {
      // Multiplicamos potencia por a
      potencia *= a; // potencia = potencia * a
      // Decrementamos b por 1
      b--;
    }

    return potencia;
  }
}