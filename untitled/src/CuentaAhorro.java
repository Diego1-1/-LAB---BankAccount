public class CuentaAhorro extends CuentaBancaria{

    private final String fechaApertura;
    private static final double tasaInteres = 2.5;
    private static final double COMISIONRETIRO = 0;
    private static final double SALDOAPERTURA = 10000;

    public CuentaAhorro(String numeroCuenta, String titular, double saldo, String fechaApertura) {

        super(numeroCuenta, titular, saldo, tasaInteres);

        if (saldo < SALDOAPERTURA){
            throw new IllegalArgumentException("Saldo de apertura mínimo 10000");
        }
        if (saldo < 0){
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo"); //Lanza error porque no se puede abrir una cuenta en - 0
        }

        this.fechaApertura = fechaApertura;

    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo.");
            return;
        }

        if (this.getSaldo() >= monto){
            System.out.println("Retiro autorizado: " + monto);
            double nuevoSaldo = getSaldo() - monto;
            setSaldo(nuevoSaldo);
        }else{
            System.out.println("Saldo insuficiente. Ingrese un valor menor.");

        }
    }
    public void mostrarInfo(){
        System.out.println("Número de cuenta: " + this.getNumeroCuenta());
        System.out.println("Titular de cuenta: " + this.getTitular());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Tasa de interés: " + tasaInteres);
        System.out.println("Fecha de apertura: " + fechaApertura);
    }

}

