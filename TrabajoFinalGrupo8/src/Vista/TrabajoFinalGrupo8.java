package Vista;

import Modelo.Cliente;
import Modelo.Masajista;
import Modelo.conexion;
import Persistencia.ClienteData;
import Persistencia.MasajistaData;
import java.util.ArrayList;
import java.util.List;

public class TrabajoFinalGrupo8 {

    public static void main(String[] args) {

        System.out.println("Iniciando Programa");
//        
        ClienteData cData = new ClienteData();
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

        MasajistaData msjData = new MasajistaData();
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
msjData.altaMasajista(1);

        Masajista m = msjData.buscarMasajistaPorMatricula(1);
        System.out.println("Buscando masajista por matricula...");
        System.out.println("----------------------------------------");
        System.out.println("N. Matrucila: " + m.getMatricula());
        System.out.println("Nombre Completo:  " + m.getNombreyapellido());
        System.out.println("Especialidad: " + m.getEspecialidad());
        System.out.println("Estado: " + m.getEstado());

    }

    conexion con = new conexion("jdbc:mysql://localhost:3306/tpfinalgrupo8", "root", "");
}
