import java.util.List;
import com.google.common.collect.Lists;

public class MotorSugerenciasBasico implements MotorSugerencias {

  @Override
  public List<Atuendo> generarSugerencias(Usuario usuario) {
    List<Prenda> prendas = usuario.getPrendas();
    List<Prenda> superiores = prendas.stream().filter(Prenda::esSuperior).toList();
    List<Prenda> inferiores = prendas.stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = prendas.stream().filter(Prenda::esCalzado).toList();

    return Lists.cartesianProduct(superiores, inferiores, calzados).stream()
        .map(c -> new Atuendo(c.get(0), c.get(1), c.get(2)))
        .toList();
  }
}
