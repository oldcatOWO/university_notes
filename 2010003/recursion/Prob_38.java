import java.util.ArrayList;
import java.util.List;

public class Prob_38 {
  public static void main(String[] args) {
    new Prob_38().solve();
  }

  public void solve() {
    System.out.println(obtenerConjuntoClausura(new int[] { 1, 2, 3, 4 }));
  }

  class Conjunto extends ArrayList<ArrayList<Integer>> {

  }

  class Grupo extends ArrayList<Integer> {
    public Grupo clon() {
      Grupo clon = new Grupo();

      for (Integer element : this) {
        clon.add(element);
      }

      return clon;
    }
  }

  public Conjunto obtenerConjuntoClausura(int[] secuencia) {
    // Construir los conjuntos por longitudes desde 1 a secuencia.length
    return construirConjuntos(secuencia, 1);
  }

  private Conjunto construirConjuntos(int[] secuencia, int longitudGrupo) {
    Conjunto set = new Conjunto();

    if (longitudGrupo <= secuencia.length) {
      Conjunto nuevoSet = new Conjunto();
      // Construir Grupos de tamanio igual a longitudGrupo
      construirGrupos(secuencia, longitudGrupo, 0, new Grupo(), nuevoSet);
      // Crear el siguiente conjunto de una longitud incrementada por 1
      construirConjuntos(secuencia, longitudGrupo + 1);
      set.addAll(nuevoSet);
      set.addAll(construirConjuntos(secuencia, longitudGrupo + 1));
    }

    return set;
  }

  private void construirGrupos(int[] secuencia, int longitudGrupo, int indiceSecuencia,
      Grupo grupo, Conjunto conjunto) {
    // Caso base un grupo tiene la misma longitud
    if (grupo.size() == longitudGrupo) {
      // Agregar el grupo de la longitud pedida
      conjunto.add(grupo);
    }
    // Caso Recursivo se comprueba si indiceSecuencia < secuencia.length
    // de ser asi se toma un elemento y tambien se avanza sin tomarlo
    else if (indiceSecuencia < secuencia.length) {
      // Se construye un nuevo grupo por cada elemento tomado
      Grupo grupoNuevo = grupo.clon();
      grupoNuevo.add(secuencia[indiceSecuencia]);
      construirGrupos(secuencia, longitudGrupo, indiceSecuencia + 1, grupoNuevo, conjunto);
      // Avanzar sin tomar el elemento
      construirGrupos(secuencia, longitudGrupo, indiceSecuencia + 1, grupo, conjunto);
    }
  }
}