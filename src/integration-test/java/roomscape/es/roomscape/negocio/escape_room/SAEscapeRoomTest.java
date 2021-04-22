package roomscape.es.roomscape.negocio.escape_room;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SAEscapeRoomTest {

    @Autowired
    SAEscapeRoom saEscapeRoom;

    @Test
    @DisplayName("Comprobación de que los escape rooms se listan correctamente")
    public void listarEscapeRooms() {

        TEscapeRoom escapeRoom = new TEscapeRoom();
        escapeRoom.setActivo(true);
        escapeRoom.setCapacidadPersonas(10);
        escapeRoom.setDuracion(60);
        escapeRoom.setNombre("Escape Room");
        escapeRoom.setPrecio(25);

        try {
            saEscapeRoom.crearEscapeRoom(escapeRoom);
            List<TEscapeRoom> listaEscapeRooms = saEscapeRoom.listarEscapeRooms();
            Assertions.assertEquals(listaEscapeRooms.size(), 1);
        } catch (Exception e) {
            Assertions.assertNull(e);
        }
    }
}