
package modelo;

public class TarjetaB 
{
    private String codigo;
    private int totDinero;
    private int cantViajes;

    public TarjetaB(String codigo, int totDinero, int cantViajes) {
        this.codigo = codigo;
        this.totDinero = totDinero;
        this.cantViajes = cantViajes;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTotDinero() {
        return totDinero;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTotDinero(int totDinero) {
        this.totDinero = totDinero;
    }

    public void setCantViajes(int cantViajes) {
        this.cantViajes = cantViajes;
    }
    public String viajar(int pasaje)
    {
        if(totDinero>pasaje)
        {
            totDinero-=pasaje;
            cantViajes++;
            return "Viaje exitoso su saldo es de: "+totDinero;
        }
        else
            return "Dinero insuficiente para viajar";
    }
    public void cargarTarjeta(int montoCarga)
    {
        totDinero+=montoCarga;
    }
}
