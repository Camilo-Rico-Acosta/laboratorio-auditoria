public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(String titular, double saldo) {super(titular, saldo, 2, 500.0);}

    @Override public void procesarRetiro(double monto) {
        if (monto > 0 && getSaldo() + getLimiteSobregiro() >= monto) {
            setSaldo(getSaldo() - monto);
            System.out.println("Retiro realizado correctamente.");
        } else {
            System.out.println("Se excedió el límite de sobregiro.");
        }
    }

    @Override public void aplicarComisionMensual() {
        double comision = 15.0;
        setSaldo(getSaldo() - comision);
        System.out.println("Comisión de cuenta corriente aplicada: $" + comision);
    }
}
