import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private Integer edad;
  private List<Prenda> prendas = new ArrayList<>();
  private ProveedorDeMotor proveedor;

  public Usuario(int edad, ProveedorDeMotor proveedor) {
    this.edad = edad;
    this.proveedor = proveedor;
  }

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public int getEdad() {
    return edad;
  }

  public List<Atuendo> generarSugerencias() {
    return proveedor.getMotor().generarSugerencias(this);
  }
}

// Revisar lo del guardarropas que no estoy seguro si hay que hacer que un usuario tenga un guardarropas o como es eso