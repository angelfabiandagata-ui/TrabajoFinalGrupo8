package Persistencia;

import Modelo.DiaDeSpa;
import Modelo.SesionTurno;
import java.util.ArrayList;
import java.util.List;

public class DiaDeSpaData {

    private List<DiaDeSpa> listaspa = new ArrayList<>();

    public void Crear(DiaDeSpa diadespa) {

        listaspa.add(diadespa);
        System.out.println("Se creo un dia de spa" + diadespa.getCodPack());

    }

    public void AsociarSesiones(DiaDeSpa diadespa) {
        System.out.println("Asociar sesiones al Dia de Spa " + diadespa.getCodPack());

        List<SesionTurno> sesioneslist = diadespa.getSesiones();
        if (sesioneslist == null || sesioneslist.isEmpty()) {
            System.out.println("No hay sesiones cargadas para este dia. ");
            return;

        }
        for (SesionTurno sesionTurno : sesioneslist) {
            System.out.println("Sesion " + sesionTurno.getCodSesion());
            System.out.println("Inicio " + sesionTurno.getFechaHoraInicio());
            System.out.println("Instalaciones: " + sesionTurno.getInstalacioneslist());
            
        }
    }

    public void CalcularMonto(DiaDeSpa diadespa) {
        double total= 0 ;
        List<SesionTurno> sesionTurnos = diadespa.getSesiones();
        if (sesionTurnos != null) {
            for (SesionTurno sesionconTurno : sesionTurnos) {
                total +=0; //no se que precio poner
                
            }
            
        }

    }

    public void ListarDias(DiaDeSpa diadespa) {

        System.out.println("Dias de spa");
        if (listaspa.isEmpty()) {
            System.out.println("Aun no hay dias de spa registrados. ");
            return;

        }
        for (DiaDeSpa diaDeSpa : listaspa) {
            System.out.println("Codigo: " + diaDeSpa.getCodPack());
            System.out.println("Cliente: " + diaDeSpa.getCliente());
            System.out.println("fecha y Hora: " + diaDeSpa.getFechaHora());
            System.out.println("Preferencia: " + diaDeSpa.getPreferencia());
            System.out.println("Monto: $" + diaDeSpa.getMonto());

        }

    }

    public void MostrarDetalle(DiaDeSpa diadespa) {
        System.out.println("Detalle del Dia de Spa " + diadespa.getCodPack());
        System.out.println("Cliente: " + diadespa.getCliente() + "Fecha y Hora: " + diadespa.getFechaHora() + "Preferencia: " + diadespa.getPreferencia() + "Monto total: " + diadespa.getMonto());

        if (diadespa.getSesiones() == null || diadespa.getSesiones().isEmpty()) {

        } else {
            for (SesionTurno sesiones : diadespa.getSesiones()) {
                System.out.println("Sesion " + sesiones.getCodSesion() + " Inicio: " + sesiones.getFechaHoraInicio() + "Instalaciones: " + sesiones.getInstalacioneslist());

            }
        }
    }
    
    public DiaDeSpa buscarPorCodigo(int codPack) {
    for (DiaDeSpa d : listaspa) {
        if (d.getCodPack() == codPack) {
            return d;
        }
    }
    return null;
}

public List<DiaDeSpa> buscarPorCliente(String cliente) {
    List<DiaDeSpa> encontrados = new ArrayList<>();
    for (DiaDeSpa d : listaspa) {
        if (d.getCliente() != null && d.getCliente().toLowerCase().contains(cliente.toLowerCase())) {
            encontrados.add(d);
        }
    }
    return encontrados;
}


}
