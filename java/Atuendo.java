import java.util.stream.Stream;

public class Atuendo {

  // Sugerencia es en sí misma un atuendo asi que entra acá

  private Prenda superior;
  private Prenda inferior;
  private Prenda calzado;

  public Atuendo(Prenda superior, Prenda inferior, Prenda calzado) {
    this.superior = superior;
    this.inferior = inferior;
    this.calzado = calzado;
  }

  public String describir() {
    return String.format("Superior: %s | Inferior: %s | Calzado: %s",
        superior.getDescripcion(),
        inferior.getDescripcion(),
        calzado.getDescripcion());
  }

  public boolean aptaParaTemperatura(double temperatura) {
    return Stream.of(superior, inferior, calzado)
        .allMatch(p -> p.esAptaParaTemperatura(temperatura));
  }
}

