package roomscape.es.roomscape.negocio.escape_room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roomscape.es.roomscape.negocio.entity.EntityEscapeRoom;
import roomscape.es.roomscape.negocio.exceptions.list.EmptyListException;
import roomscape.es.roomscape.negocio.exceptions.list.NoRoomEscapesException;
import roomscape.es.roomscape.negocio.repository.RepositoryEscapeRoom;
import roomscape.es.roomscape.negocio.exceptions.validations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class SAEscapeRoomImp implements SAEscapeRoom {

    private static final Logger log = LoggerFactory.getLogger(SAEscapeRoomImp.class);

    @Autowired
    private RepositoryEscapeRoom repositoryEscapeRoom;

    @Override
    public TEscapeRoom crearEscapeRoom(TEscapeRoom tEscapeRoom) throws Exception {

        EntityEscapeRoom auxEscapeRoom = repositoryEscapeRoom.findEntityEscapeRoomByNombre(tEscapeRoom.getNombre());
        Optional<EntityEscapeRoom> optional = Optional.ofNullable(auxEscapeRoom);

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9á-üÁ-Ü-_. ]");

        ValidationException e = null;
        if (optional.isPresent() && optional.get().isActivo()) {
            e = new InvalidNameException();
        } else if (pattern.matcher(tEscapeRoom.getNombre()).find()) {
            e = new InvalidNameCharactersException();
        } else if (tEscapeRoom.getCapacidadPersonas() <= 0) {
            e = new InvalidCapacityException();
        } else if (tEscapeRoom.getDuracion() <= 0) {
            e = new InvalidDurationException();
        } else if (tEscapeRoom.getPrecio() < 0) {
            e = new InvalidPriceException();
        }

        if (Optional.ofNullable(e).isPresent()) {
            log.warn("El escape room: {} no ha superado las reglas de validación: {}",
                    tEscapeRoom.getNombre(),
                    e.getMessage());
            throw e;
        }

        EntityEscapeRoom entityEscapeRoom;

        if (optional.isPresent()) {
            entityEscapeRoom = optional.get();
            entityEscapeRoom.setActivo(true);
            entityEscapeRoom.setCapacidadPersonas(tEscapeRoom.getCapacidadPersonas());
            entityEscapeRoom.setDuracion(tEscapeRoom.getDuracion());
            entityEscapeRoom.setNombre(tEscapeRoom.getNombre());
            entityEscapeRoom.setPrecio(tEscapeRoom.getPrecio());
        } else {
            tEscapeRoom.setActivo(true);
            entityEscapeRoom = new EntityEscapeRoom(tEscapeRoom);
        }

        log.debug("El escape room: {} ha superado las reglas de validación", tEscapeRoom.getNombre());

        EntityEscapeRoom entityEscapeRoomSaved = repositoryEscapeRoom.save(entityEscapeRoom);

        return entityEscapeRoomSaved.toTransfer();
    }

    @Override
    public List<TEscapeRoom> listarEscapeRooms() throws Exception {
        List<EntityEscapeRoom> listaAux = repositoryEscapeRoom.findAll();

        if (listaAux.isEmpty()) {
            EmptyListException e = new NoRoomEscapesException();
            log.warn(e.getMessage());
            throw e;
        }

        List<TEscapeRoom> listaEscapeRooms = new ArrayList<>();
        listaAux.forEach(entityEscapeRoom -> listaEscapeRooms.add(entityEscapeRoom.toTransfer()));
        return listaEscapeRooms;
    }
}