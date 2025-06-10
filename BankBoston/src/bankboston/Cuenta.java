
package bankboston;

public abstract class Cuenta {
    protected int numeroCuenta;
    protected int saldo;
    
    public Cuenta(int numeroCuenta){
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public abstract void depositar(int monto);
    public abstract void girar(int monto);
    
    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

}
