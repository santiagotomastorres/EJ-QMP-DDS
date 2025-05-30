import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class Iteracion4Test {


  // TipoDePrenda

  @Test
  public void prendaEsAptaParaTemperaturaInferior() {
    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR, 25.0);
    assertTrue(remera.esAptaParaTemperatura(20.0));
  }

  @Test
  public void prendaNoEsAptaParaTemperaturaSuperior() {
    TipoDePrenda campera = new TipoDePrenda(Categoria.PARTE_SUPERIOR, 15.0);
    assertFalse(campera.esAptaParaTemperatura(22.0));
  }


  // Atuendo

  @Test
  public void atuendoAptoSiTodasLasPrendasLoSon() {
    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR, 30);
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR, 35);
    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO, 40);

    Prenda p1 = new Prenda(remera, Material.ALGODON, new Color(0,0,0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda p2 = new Prenda(pantalon, Material.JEAN, new Color(0,0,0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda p3 = new Prenda(zapatillas, Material.CUERO, new Color(0,0,0), null, Trama.LISA, Formalidad.NEUTRA);

    Atuendo atuendo = new Atuendo(p1, p2, p3);
    assertTrue(atuendo.aptaParaTemperatura(25));
  }

  @Test
  public void atuendoNoAptoSiUnaPrendaNoLoEs() {
    TipoDePrenda campera = new TipoDePrenda(Categoria.PARTE_SUPERIOR, 10);
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR, 25);
    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO, 35);

    Prenda p1 = new Prenda(campera, Material.LANA, new Color(0,0,0), null, Trama.LISA, Formalidad.FORMAL);
    Prenda p2 = new Prenda(pantalon, Material.JEAN, new Color(0,0,0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda p3 = new Prenda(zapatillas, Material.CUERO, new Color(0,0,0), null, Trama.LISA, Formalidad.NEUTRA);

    Atuendo atuendo = new Atuendo(p1, p2, p3);
    assertFalse(atuendo.aptaParaTemperatura(20));
  }


  // RespuestaMeteorologica

  @Test
  public void respuestaNoExpiraSiTodaviaEsValida() {
    EstadoDelTiempo clima = new EstadoDelTiempo(25, Humedad.SECO);
    LocalDateTime futura = LocalDateTime.now().plusMinutes(30);

    RespuestaMeteorologica respuesta = new RespuestaMeteorologica(clima, futura);
    assertFalse(respuesta.expiro());
  }

  @Test
  public void respuestaExpiraSiYaPasoElTiempo() {
    EstadoDelTiempo clima = new EstadoDelTiempo(25, Humedad.SECO);
    LocalDateTime pasada = LocalDateTime.now().minusMinutes(5);

    RespuestaMeteorologica respuesta = new RespuestaMeteorologica(clima, pasada);
    assertTrue(respuesta.expiro());
  }


  // AsesorDeImagen

  @Test
  public void sugerirAtuendoFiltraPorTemperatura() {
    ServicioMeteorologico servicioMock = mock(ServicioMeteorologico.class);
    Usuario usuarioMock = mock(Usuario.class);
    Atuendo atuendoOk = mock(Atuendo.class);
    Atuendo atuendoNo = mock(Atuendo.class);

    when(servicioMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(new EstadoDelTiempo(20, Humedad.SECO));

    when(atuendoOk.aptaParaTemperatura(20)).thenReturn(true);
    when(atuendoNo.aptaParaTemperatura(20)).thenReturn(false);

    when(usuarioMock.generarSugerencias()).thenReturn(List.of(atuendoNo, atuendoOk));

    AsesorDeImagen asesor = new AsesorDeImagen(servicioMock);
    Optional<Atuendo> sugerencia = asesor.sugerirAtuendo("Buenos Aires", usuarioMock);

    assertTrue(sugerencia.isPresent());
    assertEquals(atuendoOk, sugerencia.get());
  }

  @Test
  public void sugerirAtuendoDevuelveVacioSiNingunoAplica() {
    ServicioMeteorologico servicioMock = mock(ServicioMeteorologico.class);
    Usuario usuarioMock = mock(Usuario.class);
    Atuendo atuendoNo = mock(Atuendo.class);

    when(servicioMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(new EstadoDelTiempo(32, Humedad.SECO));

    when(atuendoNo.aptaParaTemperatura(32)).thenReturn(false);

    when(usuarioMock.generarSugerencias()).thenReturn(List.of(atuendoNo));

    AsesorDeImagen asesor = new AsesorDeImagen(servicioMock);
    Optional<Atuendo> sugerencia = asesor.sugerirAtuendo("Buenos Aires", usuarioMock);

    assertTrue(sugerencia.isEmpty());
  }
}

