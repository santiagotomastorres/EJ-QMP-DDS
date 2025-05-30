public class SastreSanJuan implements Sastre {
  @Override
  public Prenda fabricarParteSuperior() {
    Borrador borrador = new Borrador(TipoDePrenda.CHOMBA);
    borrador.especificarColorPrincipal(new Color(0, 128, 0)); // verde
    borrador.especificarMaterial(Material.PIQUE);
    return borrador.crearPrenda();
  }

  @Override
  public Prenda fabricarParteInferior() {
    Borrador borrador = new Borrador(TipoDePrenda.PANTALON);
    borrador.especificarColorPrincipal(new Color(128, 128, 128)); // gris
    borrador.especificarMaterial(Material.ACETATO);
    return borrador.crearPrenda();
  }

  @Override
  public Prenda fabricarCalzado() {
    Borrador borrador = new Borrador(TipoDePrenda.ZAPATO);
    borrador.especificarColorPrincipal(new Color(255, 255, 255)); // blanco
    borrador.especificarMaterial(Material.CUERO);
    return borrador.crearPrenda();
  }
}
