
package bankeurope.cuentas;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected double saldo;

    public CuentaBancaria(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    
    public CuentaBancaria(int numeroCuenta) {
        this(numeroCuenta, 0.0);
    }
    
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
       
    public abstract void depositar(double monto);
    public abstract void girar(double monto);
    public abstract double calcularInteres();
    
    public void mostrarTipoCuentaEInteres() {
        System.out.println("Tipo de cuenta: " + this.getClass().getSimpleName());
        System.out.println("Interés calculado: " + calcularInteres());
    }
    
    public void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }
}