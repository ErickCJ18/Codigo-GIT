package agenda;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactList;

    public Agenda() {
        this.contactList = new ArrayList<>();
    }

    public void addContact(Contacto contacto) {
        contactList.add(contacto);
    }

    public Contacto searchContact(String nombre) {
        for (Contacto contacto : contactList) {                 // Esto es un bucle for-each que itera sobre cada elemento de contactList. En este caso, el tipo de elemento es Contacto, de la clase Contacto.java,
            if (contacto.getNombre().equals(nombre)) {          // y el elemento (contacto) es una variable que tomará el valor de cada elemento en contactList en cada iteración. 
                return contacto;
            }
        }
        return null;        // Devuelve null si no se encuentra el contacto
    }

    public void deleteContact(Contacto contacto) {
        contactList.remove(contacto);
    }

    public void showContact() {
        for (Contacto contacto : contactList) {
            System.out.println(contacto);
        }
    }
}
