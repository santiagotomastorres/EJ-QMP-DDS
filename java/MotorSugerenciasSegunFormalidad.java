import java.util.List;
import com.google.common.collect.Lists;

public class MotorSugerenciasSegunFormalidad implements MotorSugerencias {

  private List<Prenda> getPrendasValidas(Usuario usuario) {
    if (usuario.getEdad() <= 55) return usuario.getPrendas();
    return usuario.getPrendas().stream()
        .filter(p -> !p.esInformal())
        .toList();
  }

  @Override
  public List<Atuendo> generarSugerencias(Usuario usuario) {
    List<Prenda> prendasValidas = getPrendasValidas(usuario);
    List<Prenda> superiores = prendasValidas.stream().filter(Prenda::esSuperior).toList();
    List<Prenda> inferiores = prendasValidas.stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = prendasValidas.stream().filter(Prenda::esCalzado).toList();

    return Lists.cartesianProduct(superiores, inferiores, calzados).stream()
        .map(c -> new Atuendo(c.get(0), c.get(1), c.get(2)))
        .toList();
  }
}
