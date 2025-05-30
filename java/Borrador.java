import java.util.Objects;

public class Borrador {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama = Trama.LISA; // valor por defecto
  private String descripcion;

  public Borrador(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda, "El tipo de prenda es obligatorio");
  }

  public void especificarMaterial(Material material) {
    this.material = Objects.requireNonNull(material, "El material es obligatorio");
  }

  public void especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "El color principal es obligatorio");
  }

  public void especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void especificarTrama(Trama trama) {
    this.trama = trama != null ? trama : Trama.LISA;
  }

  public Prenda crearPrenda() {
    if (tipoDePrenda == null || material == null || colorPrincipal == null) {
      throw new IllegalStateException("Faltan datos obligatorios para crear la prenda.");
    }
    return new Prenda(tipoDePrenda, material, colorPrincipal, colorSecundario, trama, descripcion);
  }
}
