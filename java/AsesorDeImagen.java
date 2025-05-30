public class AsesorDeImagen {
    private ServicioMeteorologico servicioMeteorologico;

    public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
      this.servicioMeteorologico = servicioMeteorologico;
    }

    public Optional<Atuendo> sugerirAtuendo(String direccion, Usuario usuario) {
      EstadoDelTiempo clima = servicioMeteorologico.obtenerCondicionesClimaticas(direccion);

      return usuario.generarSugerencias().stream()
          .filter(a -> a.aptaParaTemperatura(clima.getTemperatura()))
          .findFirst();
    }
  }

