/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;


public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void depositar(int monto) {
        // Igual lógica que CuentaCorriente
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso! \nSu nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso! \nSu saldo actual es: $" + saldo);
        }
    }
}