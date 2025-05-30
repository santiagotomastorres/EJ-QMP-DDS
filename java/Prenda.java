import java.util.Objects;

public class Prenda {
  private TipoDePrenda tipo;
  private Material material;
  private Formalidad formalidad;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;
  private String descripcion;

  public Prenda(TipoDePrenda tipo, Material material, Color colorPrincipal, Color colorSecundario, Trama trama, String descripcion) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.descripcion;
  }

  public boolean esAptaParaTemperatura(double temperatura) {
    return tipo.esAptaParaTemperatura(temperatura);
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  public boolean esSuperior() {
    return this.getCategoria() == Categoria.PARTE_SUPERIOR;
  }

  public boolean esInferior() {
    return this.getCategoria() == Categoria.PARTE_INFERIOR;
  }

  public boolean esCalzado() {
    return this.getCategoria() == Categoria.CALZADO;
  }

  public boolean esInformal() {
    return formalidad == Formalidad.INFORMAL;
  }

  public boolean esFormal() {
    return formalidad == Formalidad.FORMAL;
  }

  public boolean esNeutra() {
    return formalidad == Formalidad.NEUTRA;
  }

  public TipoDePrenda getTipo() {
    return tipo;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {return colorSecundario;}

  public Trama getTrama() {return trama;}

  public String getDescripcion() {
    return descripcion;
  }

}




