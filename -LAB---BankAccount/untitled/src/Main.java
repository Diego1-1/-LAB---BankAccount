public class Main {
    public static void main(String[] args) {

        CuentaBancaria prueba1 = new CuentaBancaria("154115SFG", "Amanda", 259430, 2.3) {
            @Override
            public void retirar(double monto) {
                System.out.println("Retirar dinero de la cuenta: ");
            }
        };

        System.out.println("Mostrar información: ");

        prueba1.mostrarInfo();

        System.out.println("\n Deposito válido");

        prueba1.depositar(50000);

        System.out.println("\n Deposito inválido");

        prueba1.depositar(-20);

        System.out.println("\n Aplicar interés");

        prueba1.aplicarInteres();

    }
}