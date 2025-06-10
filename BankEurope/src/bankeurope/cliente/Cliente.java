
package bankeurope.cliente;
import bankeurope.cuentas.CuentaBancaria;

public class Cliente implements InfoCliente{
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaBancaria cuentaBancaria;
    
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, CuentaBancaria cuentaBancaria){
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaBancaria= cuentaBancaria;
    }
    
    public String getRut() {
        return rut;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
   
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuentaBancaria;
    }
    
    @Override
    public void mostrarInfoCliente() {
        System.out.println("---DATOS DEL CLIENTE---");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio + ", " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("Numero de Cuenta: " + cuentaBancaria.getNumeroCuenta());
        System.out.println("Tipo de cuenta: " + cuentaBancaria.getClass().getSimpleName());
        System.out.println("Interés calculado: $" + cuentaBancaria.calcularInteres());
        System.out.println("Saldo: $" + cuentaBancaria.getSaldo());
    }
    
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

}
