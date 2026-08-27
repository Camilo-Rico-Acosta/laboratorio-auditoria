public class Main {
    public static void main(String[] args) {

        CuentaAhorros ahorro = new CuentaAhorros("Juan", 1000);
        CuentaCorriente corriente = new CuentaCorriente("Carlos", 300);

        try (RegistroAuditoriaBancaria auditoria = new RegistroAuditoriaBancaria()) {

            auditoria.registrar("Inicio de operaciones bancarias.");
            auditoria.registrar(
                "Cuenta de ahorro: " + ahorro.getTitular() +
                " - Saldo: $" + ahorro.getSaldo()
            );

            ahorro.procesarRetiro(200);
            auditoria.registrar(
                "Retiro realizado en cuenta de ahorro. Nuevo saldo: $" +
                ahorro.getSaldo()
            );

            corriente.procesarRetiro(600);
            auditoria.registrar(
                "Retiro realizado en cuenta corriente. Nuevo saldo: $" +
                corriente.getSaldo()
            );

        }
        System.out.println("El programa continua despues del try.");
    }
}