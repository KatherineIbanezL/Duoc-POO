
package bankeurope.cuentas;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }
    
    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso! \nSu nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Monto invalido.");
        }
    }
    
    @Override
    public void girar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso! \nSu saldo actual es: $" + saldo);
        }
    }
    
    @Override
    public double calcularInteres() {
        return saldo * 0.01;
    }
}
