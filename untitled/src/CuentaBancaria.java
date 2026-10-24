public abstract class CuentaBancaria {

    //Atributos:

    private final String numeroCuenta;
    private final String titular;
    private double saldo;
    private final double tasaInteres;
    //Constructor:

    public CuentaBancaria(String numeroCuenta, String titular, double saldo, double tasaInteres) {
        if (saldo < 0){
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo"); //Lanza error porque no se puede abrir una cuenta en - 0
        }
        if (tasaInteres < 0){
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tasaInteres = tasaInteres;
    }

    //Metodo:
    //Getters:
    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    //Acceso a las hijas para retirar saldo:

    protected void setSaldo(double saldo){
        this.saldo = saldo;
    }

    protected String formatear (double valor){
        return String.format("$%, .2f", valor);
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: ingrese un monto positivo");
            return;
        }

        saldo += monto;
        System.out.println("Monto despositado: " +formatear(monto));
        System.out.println("Nuevo saldo: " + formatear(saldo));
    }

    public abstract void retirar(double monto);

    //Metodo para Tasa de interés:
    public void aplicarInteres(){
        double interes = (saldo * tasaInteres) / 100;
        saldo += interes;
        System.out.println("Cuenta: " + numeroCuenta + "-Interés generado: " + formatear(interes)
                + " Nuevo saldo con interés: " + formatear(saldo));
    }
    //Metodo: mostrar info:

    public void mostrarInfo(){
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular de cuenta: " + titular);
        System.out.println("Saldo: " + formatear(saldo));
        System.out.println("Tasa de interés: " + tasaInteres);
    }

}
