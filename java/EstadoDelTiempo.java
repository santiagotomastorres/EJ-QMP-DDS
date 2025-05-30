public class EstadoDelTiempo {
  private int temperatura;
  private Humedad humedad;

  public EstadoDelTiempo(int temperatura, Humedad humedad) {
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public int getTemperatura() {
    return temperatura;
  }

  public Humedad getHumedad() {
    return humedad;
  }
}
