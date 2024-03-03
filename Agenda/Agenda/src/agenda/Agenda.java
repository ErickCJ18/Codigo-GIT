package agenda;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> listaContactos;

    public Agenda() {
        this.listaContactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void eliminarContacto(Contacto contacto) {
        listaContactos.remove(contacto);
    }

    public void mostrarTodosLosContactos() {
        for (Contacto contacto : listaContactos) {
            System.out.println(contacto);
        }
    }
}