
package main;
import bankeurope.cliente.Cliente;
import bankeurope.cuentas.CuentaBancaria;
import bankeurope.cuentas.CuentaCorriente;
import bankeurope.cuentas.CuentaAhorros;
import bankeurope.cuentas.CuentaDigital;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        int opcion;
        
        do {
            System.out.println("\n--- MENU BANK EUROPE ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {                   
                    System.out.print("Ingrese su RUT (con puntos y guion): ");
                    String rut = scanner.nextLine();
                    if (rut.length() < 11 || rut.length() > 12) {
                        System.out.println("RUT invalido.");
                        break;
                    }                   
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido Paterno: ");
                    String apellidoPaterno = scanner.nextLine();
                    System.out.print("Apellido Materno: ");
                    String apellidoMaterno = scanner.nextLine();
                    System.out.print("Domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Comuna: ");
                    String comuna = scanner.nextLine();
                    
                    System.out.print("Telefono (9 digitos): ");
                    String telefono = scanner.nextLine();
                    System.out.print("Numero de cuenta (9 digitos): ");
                    int numeroCuenta = scanner.nextInt();
                    scanner.nextLine();                   
                    System.out.println("Seleccione tipo de cuenta: ");
                    System.out.println("1. Cuenta corriente");
                    System.out.println("2. Cuenta de ahorro");
                    System.out.println("3. Cuenta digital");
                    int tipoCuenta = scanner.nextInt();
                    scanner.nextLine();

                    CuentaBancaria cuenta = switch (tipoCuenta) {
                        case 1 -> new CuentaCorriente(numeroCuenta);
                        case 2 -> new CuentaAhorros(numeroCuenta);
                        case 3 -> new CuentaDigital(numeroCuenta);
                        default -> null;
                    };
                    if (cuenta == null) {
                        System.out.println("Tipo de cuenta invalido.");
                        break;
                    }
                    
                    clientes.add(new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, cuenta));
                    System.out.println("Cliente registrado exitosamente.");
                }
                case 2 -> {
                    Cliente ct = verCliente(scanner, clientes);
                    if (ct != null) ct.mostrarInfoCliente();
                }
                case 3 -> {
                    Cliente ct = verCliente(scanner, clientes);
                    if (ct != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        int monto = scanner.nextInt();
                        scanner.nextLine();
                        ct.getCuenta().depositar(monto);
                    }
                }
                case 4 -> {
                    Cliente ct = verCliente(scanner, clientes);
                    if (ct != null) {
                        System.out.print("Ingrese monto a girar: ");
                        int monto = scanner.nextInt();
                        scanner.nextLine();
                        ct.getCuenta().girar(monto);
                    }
                }
                case 5 -> {
                    Cliente ct = verCliente(scanner, clientes);
                    if (ct != null) ct.getCuenta().consultarSaldo();
                }
                case 6 -> System.out.println("Cerrando aplicacion...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);
        
    }
    public static Cliente verCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = scanner.nextLine();
        for (Cliente ct : clientes) {
            if (ct.getRut().equals(rut)) {
                return ct;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }
    
}

