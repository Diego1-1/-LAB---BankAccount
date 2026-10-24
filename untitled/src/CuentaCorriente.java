/* Cuenta Corriente.
 - No genera intereses (0.0%).
  - Permite sobregiro hasta un limite (por defecto $50,000).
  - Si el saldo queda negativo, cobra una comision sobre el monto sobregirado
    (por defecto 5%). */

public class CuentaCorriente extends CuentaBancaria {

    // Valores fijos y por defecto
    private static final double TASA_INTERES = 0.0;
    private static final double LIMITE_SOBREGIRO_DEFECTO = 50000;
    private static final double COMISION_SOBREGIRO_DEFECTO = 5.0;

    // Atributos adicionales
    private final double limiteSobregiro;
    private final double porcentajeComisionSobregiro;

    // Constructor principal: recibe el limite y el porcentaje de comision.
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, TASA_INTERES);
        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException("El limite de sobregiro no puede ser negativo.");
        }
        if (porcentajeComisionSobregiro < 0) {
            throw new IllegalArgumentException("El porcentaje de comision no puede ser negativo.");
        }
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    // Constructor secundario: usa los valores por defecto para limite y comision.
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, LIMITE_SOBREGIRO_DEFECTO, COMISION_SOBREGIRO_DEFECTO);
    }

    // Getters adicionales
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getPorcentajeComisionSobregiro() {
        return porcentajeComisionSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser positivo.");
            return;
        }

        // 1. Verificar que el monto no supere saldo + limite de sobregiro
        double disponible = getSaldo() + limiteSobregiro;
        if (monto > disponible) {
            System.out.println("Error: el monto " + formatear(monto)
                    + " supera el disponible con sobregiro (" + formatear(disponible)
                    + ") en la cuenta " + getNumeroCuenta());
            return;
        }

        // 2. Restar el monto del saldo
        setSaldo(getSaldo() - monto);
        System.out.println("Retiro exitoso de " + formatear(monto) + " en la cuenta " + getNumeroCuenta());

        // 3 y 4. Si el saldo queda negativo, calcular y cobrar la comision por sobregiro
        if (getSaldo() < 0) {
            double montoSobregirado = -getSaldo();
            double comision = montoSobregirado * porcentajeComisionSobregiro / 100;
            setSaldo(getSaldo() - comision);
            System.out.println("Monto sobregirado: " + formatear(montoSobregirado));
            System.out.println("Comision por sobregiro: " + formatear(comision));
        }

        // 5. Mostrar el nuevo saldo
        System.out.println("Nuevo saldo: " + formatear(getSaldo()));
    }

    // Sobrescritura para incluir el limite de sobregiro
    @Override
    public void mostrarInfo() {
        System.out.println("Tipo de cuenta: Corriente");
        super.mostrarInfo();
        System.out.println("Limite de sobregiro: " + formatear(limiteSobregiro));
        System.out.println("Comision por sobregiro: " + porcentajeComisionSobregiro + "%");
    }
}