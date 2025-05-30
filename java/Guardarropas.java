import java.util.*;
import java.util.stream.*;
import com.google.common.collect.Lists;

public class Guardarropas {
  private List<Prenda> prendasSuperiores = new ArrayList<>();
  private List<Prenda> prendasInferiores = new ArrayList<>();
  private List<Prenda> calzados = new ArrayList<>();

  public void agregarPrenda(Prenda prenda) {
    switch (prenda.getCategoria()) {
      case PARTE_SUPERIOR -> prendasSuperiores.add(prenda);
      case PARTE_INFERIOR -> prendasInferiores.add(prenda);
      case CALZADO -> calzados.add(prenda);
      default -> {}
    }
  }

  public List<Atuendo> generarSugerencias() {
    return Sets.cartesianProduct(prendasSuperiores, prendasInferiores, calzados).stream()
        .map(lista -> new Atuendo(lista.get(0), lista.get(1), lista.get(2)))
        .collect(Collectors.toList());
  }
}

