
package bankboston;

public class Cliente implements Mostrable{
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;
    
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, Cuenta cuenta){
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta= cuenta;
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

    public Cuenta getCuenta() {
        return cuenta;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("---DATOS DEL CLIENTE---");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio + ", " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("N° Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: $" + cuenta.getSaldo());
    }
    

}
