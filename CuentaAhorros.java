public class CuentaAhorros extends CuentaBancaria {

    public CuentaAhorros(String titular, double saldo) {super(titular, saldo, 1, 0.0);}

    @Override public void procesarRetiro(double monto) {
        if (monto > 0 && getSaldo() >= monto) {
            setSaldo(getSaldo() - monto);
            System.out.println("Retiro realizado correctamente.");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    @Override public void aplicarComisionMensual() {
        double comision = 10;
        if (getSaldo() >= comision) {
            setSaldo(getSaldo() - comision);
            System.out.println("Comisión de ahorro aplicada: $" + comision);
        }
    }
}
