public class TestBanco {

    public static void main(String[] args) {

        // Crear las cuentas
        CuentaAhorro anaPerez = new CuentaAhorro("AH001", "Ana Perez", 50000.0, "2024-01-15");
        CuentaCorriente luisGomez = new CuentaCorriente("CC001", "Luis Gomez", 20000.0);
        CuentaEmpresarial techSolutions = new CuentaEmpresarial("EM001", "Tech Solutions", 200000.0, "Tech Solutions", "123456789-0");
        CuentaAhorro mariaLopez = new CuentaAhorro("AH002", "Maria Lopez", 15000.0, "2024-02-01");

        //Mostrar información inicial
        System.out.println("--- Información inicial ---");
        anaPerez.mostrarInfo();
        luisGomez.mostrarInfo();
        techSolutions.mostrarInfo();
        mariaLopez.mostrarInfo();

        //Operaciones
        System.out.println("\n--- Operaciones ---");

        System.out.println("Ana Perez deposita $10,000:");
        anaPerez.depositar(10000.0);
        System.out.println("Nuevo saldo: $" + String.format("%.2f", anaPerez.getSaldo()));

        System.out.println("\nLuis Gomez retira $25,000:");
        luisGomez.retirar(25000.0);
        System.out.println("Nuevo saldo: $" + String.format("%.2f", luisGomez.getSaldo()));

        System.out.println("\nTech Solutions retira $10,000:");
        techSolutions.retirar(10000.0);
        System.out.println("Nuevo saldo: $" + String.format("%.2f", techSolutions.getSaldo()));

        System.out.println("\nMaria Lopez intenta retirar $20,000:");
        mariaLopez.retirar(20000.0);

        //Aplicar intereses
        System.out.println("\n--- Aplicar intereses ---");
        anaPerez.aplicarInteres();
        luisGomez.aplicarInteres();
        techSolutions.aplicarInteres();
        mariaLopez.aplicarInteres();

        // Estado final
        System.out.println("\n--- Estado final ---");
        anaPerez.mostrarInfo();
        luisGomez.mostrarInfo();
        techSolutions.mostrarInfo();
        mariaLopez.mostrarInfo();

        // Resumen
        System.out.println("\n--- Resumen ---");
        int totalCuentas = 4;
        double saldoTotal = anaPerez.getSaldo() + luisGomez.getSaldo() +
                techSolutions.getSaldo() + mariaLopez.getSaldo();
        double promedio = saldoTotal / totalCuentas;

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Saldo total: $" + String.format("%.2f", saldoTotal));
        System.out.println("Promedio de saldo: $" + String.format("%.2f", promedio));

        // Cuenta con mayor saldo
        String numMayor = anaPerez.getNumeroCuenta();
        String titularMayor = anaPerez.getTitular();
        double saldoMayor = anaPerez.getSaldo();

        if (luisGomez.getSaldo() > saldoMayor) {
            numMayor = luisGomez.getNumeroCuenta();
            titularMayor = luisGomez.getTitular();
            saldoMayor = luisGomez.getSaldo();
        }
        if (techSolutions.getSaldo() > saldoMayor) {
            numMayor = techSolutions.getNumeroCuenta();
            titularMayor = techSolutions.getTitular();
            saldoMayor = techSolutions.getSaldo();
        }
        if (mariaLopez.getSaldo() > saldoMayor) {
            numMayor = mariaLopez.getNumeroCuenta();
            titularMayor = mariaLopez.getTitular();
            saldoMayor = mariaLopez.getSaldo();
        }

        System.out.println("Cuenta con mayor saldo: " + numMayor +
                " - " + titularMayor +
                " ($" + String.format("%.2f", saldoMayor) + ")");
    }
}

