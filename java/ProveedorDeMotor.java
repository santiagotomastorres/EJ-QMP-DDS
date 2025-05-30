public class ProveedorDeMotor {
  private static ProveedorDeMotor instance;
  private MotorSugerencias motorActual;

  private ProveedorDeMotor() {}

  public static ProveedorDeMotor getInstance() {
    if (instance == null) {
      instance = new ProveedorDeMotor();
    }
    return instance;
  }

  public void setMotor(MotorSugerencias motor) {
    this.motorActual = motor;
  }

  public MotorSugerencias getMotor() {
    return motorActual;
  }
}
