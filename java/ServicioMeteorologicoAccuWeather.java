import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import AccuWeatherAPI;


public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
  private AccuWeatherAPI api;
  private Duration periodoDeValidez;
  private Map<String, RespuestaMeteorologica> ultimasRespuestas = new HashMap<>();

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
  }

  @Override
  public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
    if (!ultimasRespuestas.containsKey(direccion) || ultimasRespuestas.get(direccion).expiro()) {
      ultimasRespuestas.put(direccion,
          new RespuestaMeteorologica(consultarApi(direccion), proximaExpiracion()));
    }
    return ultimasRespuestas.get(direccion).getEstadoDelTiempo();
  }

  private EstadoDelTiempo consultarApi(String direccion) {
    Map<String, Object> datos = api.getWeather(direccion).get(0);
    int temperatura = (int) datos.get("Temperature");
    double probPrecipitacion = (double) datos.get("PrecipitationProbability");
    Humedad humedad = probPrecipitacion > 0.8 ? Humedad.LLUVIOSO : Humedad.SECO;
    return new EstadoDelTiempo(temperatura, humedad);
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(periodoDeValidez);
  }
}
