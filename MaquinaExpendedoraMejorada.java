public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // contador vendidos
    private int vendidos;
    //maquina con premios
    private boolean premio;
    //maximo de billetes a la venta
    private int maxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioGanado, int maxDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        vendidos = 0;
        premio = premioGanado;
        maxBilletes = maxDeBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (vendidos < maxBilletes) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("ERROR: Máximo de billetes vendidos");
        }
    }

    /**
     * vaciar dinero maquina
     */
    public int vaciarDineroDeLaMaquina () {
        int valorADevolver = totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            valorADevolver = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        } else {
            valorADevolver = -1;
            System.out.println("No puede vaciar la máquina con operación en curso");
        }
        return valorADevolver;
    }

    /**
     * imprime la cantidad de billetes vendidos
     */
    public void imprimirVendidos() {
        System.out.println("# nº de billetes vendidos: " + vendidos);
    }

    /**
     * contadorde billetes
     */
    public int getNumeroBilletesVendidos() {
        return vendidos;
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;        
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (vendidos < maxBilletes) {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //contador billetes
                vendidos++;
                if (premio == true) {
                    double descuentoPremio = 0.10;
                    double descuentoTotal = 0;
                    descuentoTotal = ((precioBillete*descuentoPremio)/100);
                    System.out.println("¡PREMIO del 10%!: te regalamos " + descuentoTotal + " € para gastar en el bar del Tío Paco");
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " € mas!");
            }
        }
        else {
            System.out.println("ERROR: Máximo de billetes vendidos");        
        }    
    }
}

/**
 * Cancela la operacion de compra del cliente actual y le
 * devuelve al cliente el dinero que ha introducido hasta el momento
 */
public int cancelarOperacionYDevolverDinero() {
int cantidadDeDineroADevolver;
cantidadDeDineroADevolver = balanceClienteActual;
balanceClienteActual = 0;
return cantidadDeDineroADevolver;
} 
}
