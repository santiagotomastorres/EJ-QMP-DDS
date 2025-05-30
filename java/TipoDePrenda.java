public class TipoDePrenda {
  private Categoria categoria;
  private double temperaturaMaxima;

  public TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public boolean esAptaParaTemperatura(double temperatura) {
    return temperatura <= temperaturaMaxima;
  }

  // Tipos de prenda comunes
  public static final TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  public static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  public static final TipoDePrenda ZAPATO = new TipoDePrenda(Categoria.CALZADO);

  // Tipos de prenda para el ejemplo de uniforme

  public static final TipoDePrenda CHOMBA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);

}