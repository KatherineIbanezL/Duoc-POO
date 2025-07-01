/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;


public class CuentaCredito extends Cuenta {
    private int limiteCredito = 1200000;

    public CuentaCredito(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso! \nSu nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Monto invalido.");
        }
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
        } else if (saldo - monto < -limiteCredito) {
            System.out.println("Excede el limite de credito.");
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso! \nSu saldo actual es: $" + saldo);
        }
    }
}
