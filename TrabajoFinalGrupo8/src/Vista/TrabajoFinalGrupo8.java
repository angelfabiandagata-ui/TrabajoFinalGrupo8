package Vista;

import Modelo.Cliente;
import Modelo.Masajista;
import Modelo.Tratamiento;
import java.sql.Time;
import Modelo.Conexion;
import Modelo.SesionTurno;
import Persistencia.ClienteData;
import Persistencia.MasajistaData;
import Persistencia.SesionTurnoData;
import Persistencia.TratamientoData;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrabajoFinalGrupo8 {

    public static void main(String[] args) {

                System.out.println("Iniciando Programa");
      
menu pantalla = new menu();
        pantalla.setVisible(true);
//        
//        TratamientoData tData = new TratamientoData();
//        
        Tratamiento tratamiento1 = new Tratamiento();
      tratamiento1.setCodTratamiento(1);
    tratamiento1.setNombre("Masaje");
       tratamiento1.setDetalle("Renovacion total");
List<String> listaProductos = Arrays.asList("Aceite de Palta", "Crema de Almendras", "Exfoliante");
   tratamiento1.setProductos(listaProductos);
//        tratamiento1.setDuracion(Time.valueOf("00:50:00"));
//        tratamiento1.setEstado(true);
//        
//        
//        tData.agregarTratamiento(tratamiento1);
//        
//        if (tratamiento1.getCodTratamiento() > 0) {
//            System.out.println("Se guardo el Tratamiento Nro " + tratamiento1.getCodTratamiento());
//        } else {
//            System.out.println("Fallo al guardar el tratamiento");
//        }
//        
//        
//        System.out.println("Iniciando Programa");
////        
//        ClienteData cData = new ClienteData();
//        
//        Cliente cliente1 = new Cliente();
//        cliente1.setDni(47267078);
//        cliente1.setNombrecompleto("Lucas Serrano");
//        cliente1.setTelefono(2665068929L);
//        cliente1.setEdad(19);
//        cliente1.setAfeciones("Ninguhna");
//        cliente1.setEstado(true);
//        
//        
//        cData.guardarCliente(cliente1);
//        
//        if (cliente1.getCodCli() > 0) {
//            System.out.println("Se guardo el cliente con el ID: " + cliente1.getCodCli());
//        } else {
//            System.out.println("FAllo al guardar un cliente");
//        }
//       
//        System.out.println("Lista de clientes");
//        
//        List<Cliente> listaClentes = cData.listarClientesActivos();
//        
//        for (Cliente c : listaClentes) {
//            System.out.println("------------------");
//            System.out.println("Id: " + c.getCodCli());
//            System.out.println("Nombre Completo: " + c.getNombrecompleto());
//        }

//        MasajistaData msjData = new MasajistaData();
//        
//       Masajista msj1 = new Masajista();
//       msj1.setMatricula(1);
//       msj1.setNombreyapellido("Sergio Galleguillo");
//       msj1.setTelefono(2665098675L);
//       msj1.setEspecialidad("Masaje Sueco");
//       msj1.setEstado(true);
//       
//       msjData.agregarMasajista(msj1);

//        System.out.println("Lista de masajistas");
//        
//        List<Masajista> ListaMasajistas = msjData.listarMasajista();
//        
//        for (Masajista m : ListaMasajistas) {
//            System.out.println("------------------");
//            System.out.println("Matricula: " + m.getMatricula());
//            System.out.println("Nombre Completo: " + m.getNombreyapellido());
//            System.out.println("Especialidad: " + m.getEspecialidad());
//            
//        }
//msjData.bajaMasajista(1);
//msjData.altaMasajista(1);
//
//        Masajista m = msjData.buscarMasajistaPorMatricula(1);
//        System.out.println("Buscando masajista por matricula...");
//        System.out.println("----------------------------------------");
//        System.out.println("N. Matrucila: " + m.getMatricula());
//        System.out.println("Nombre Completo:  " + m.getNombreyapellido());
//        System.out.println("Especialidad: " + m.getEspecialidad());
//        System.out.println("Estado: " + m.getEstado());

    

    Conexion con = new Conexion();
    menu menu = new menu();
    
    
    
    // 1. Conéctate a la base de datos
        // (Asegúrate de tener el constructor sin parámetros con la conexión)
        SesionTurnoData sesionData = new SesionTurnoData();

        System.out.println("--- Probando ListarMasajitas ---");
        sesionData.ListarMasajitas();
        
        System.out.println("\n--- Probando ListarTratamientos ---");
        sesionData.ListarTratamientos();

        System.out.println("\n--- Probando ListarInstalaciones ---");
        sesionData.ListarInstalaciones();

        System.out.println("\n--- Probando AsignarMasajista ---");
        
        // 2. Prepara una sesión de prueba
        SesionTurno nuevaSesion = new SesionTurno();
        
        // Define un horario
        LocalDateTime inicio = LocalDateTime.of(2025, 11, 10, 15, 0, 0); // 10 de Nov, 3:00 PM
        LocalDateTime fin = LocalDateTime.of(2025, 11, 10, 16, 0, 0);   // 10 de Nov, 4:00 PM
        nuevaSesion.setFechaHoraInicio(inicio);
        nuevaSesion.setFechaHoraFin(fin);

        // Asigna un tratamiento (DEBE EXISTIR EN TU BD)
        // Supongamos que el tratamiento 1 requiere "Masaje Deportivo"
        Tratamiento t = new Tratamiento();
        t.setCodTratamiento(1); 
        nuevaSesion.setTratamiento(t);

        // 3. Llama al método
        sesionData.AsignarMasajistaSegunEspecialidad(nuevaSesion);
        
        // 4. Verifica el resultado
        if (nuevaSesion.getMasajista() != null) {
            System.out.println("Masajista encontrado: " + nuevaSesion.getMasajista().getNombreyapellido());
        } else {
            System.out.println("No se pudo encontrar masajista para ese horario.");
        }
    

    TratamientoData tData = new TratamientoData();
       

       tratamiento1.setCodTratamiento(1); // O deja que la BD lo genere (si es AUTO_INCREMENT)
       tratamiento1.setNombre("Masaje");
       tratamiento1.setDetalle("Renovacion total");
       //... (completa los otros datos si es necesario, especialmente 'especialidad')
       //... asumiré que 'especialidad' es un campo que falta en tu modelo
       tratamiento1.setEstado(true);
       
       tData.agregarTratamiento(tratamiento1);
       
       if (tratamiento1.getCodTratamiento() > 0) {
           System.out.println("Se guardo el Tratamiento Nro " + tratamiento1.getCodTratamiento());
       } else {
           System.out.println("Fallo al guardar el tratamiento");
       }
}}
