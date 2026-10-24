public class CuentaEmpresarial extends CuentaBancaria {

    // Atributos adicionales
    private final String nombreEmpresa;
    private final String rut;
    private final double comisionRetiro;

    // Constantes de negocio (con las variables en minúsculas como pediste)
    private static final double tasa_interes_fija = 1.5; // 1.5% anual
    private static final double comision = 2000.0;
    private static final double saldo_minimo = 100000.0;

    // Constructor
    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String rut) {
        // Valida el saldo mínimo antes de invocar al padre
        super(numeroCuenta, titular, saldoInicial, tasa_interes_fija);

        if (saldoInicial < saldo_minimo) {
            throw new IllegalArgumentException("El saldo inicial para una cuenta empresarial debe ser de al menos " + formatear(saldo_minimo));
        }

        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.comisionRetiro = comision;
    }

    // Getters adicionales
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRut() {
        return rut;
    }

    public double getComisionRetiro() {
        return comisionRetiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo.");
            return;
        }

        // 1. Verificar que monto + comisionRetiro no supere el saldo disponible
        double totalRequerido = monto + comisionRetiro;
        if (totalRequerido > getSaldo()) {
            System.out.println("Error: Fondos insuficientes para cubrir el monto y la comisión de retiro.");
            return;
        }

        // 2 y 3. Restar el monto y la comisión del saldo usando setSaldo
        double nuevoSaldo = getSaldo() - totalRequerido;
        setSaldo(nuevoSaldo);

        // 4. Mostrar mensajes informativos solicitados
        System.out.println("Retiro exitoso");
        System.out.println("Comisión por retiro: " + formatear(comisionRetiro));
        System.out.println("Nuevo saldo: " + formatear(getSaldo()));
    }

    // Sobrescritura para incluir nombre de empresa y RUT
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nombre de la Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + rut);
        System.out.println("Comisión por Retiro: " + formatear(comisionRetiro));
    }


}
