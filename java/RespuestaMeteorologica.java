import java.time.LocalDateTime;

public class RespuestaMeteorologica {
  private EstadoDelTiempo estadoDelTiempo;
  private LocalDateTime expiracion;

  public RespuestaMeteorologica(EstadoDelTiempo estadoDelTiempo, LocalDateTime expiracion) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.expiracion = expiracion;
  }

  public boolean expiro() {
    return LocalDateTime.now().isAfter(expiracion);
  }

  public EstadoDelTiempo getEstadoDelTiempo() {
    return estadoDelTiempo;
  }
}
