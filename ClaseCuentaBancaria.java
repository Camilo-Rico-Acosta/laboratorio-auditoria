public abstract class CuentaBancaria {

    private String titular;
    private double saldo;
    private int tipoCuenta;
    private double limiteSobregiro;

    public CuentaBancaria(String titular, double saldo, int tipoCuenta, double limiteSobregiro) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.limiteSobregiro = limiteSobregiro;
    }

    public String getTitular() {return titular;}
    public double getSaldo() {return saldo;}
    public int getTipoCuenta() {return tipoCuenta;}
    public double getLimiteSobregiro() {return limiteSobregiro;}

    public void setTitular(String titular) {this.titular = titular;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public void setTipoCuenta(int tipoCuenta) {this.tipoCuenta = tipoCuenta;}
    public void setLimiteSobregiro(double limiteSobregiro) {this.limiteSobregiro = limiteSobregiro;}

    public abstract void procesarRetiro(double monto);
    public abstract void aplicarComisionMensual();
}
