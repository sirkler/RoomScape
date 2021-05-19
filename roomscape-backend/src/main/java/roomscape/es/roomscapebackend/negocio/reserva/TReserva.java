package roomscape.es.roomscapebackend.negocio.reserva;

import lombok.Data;

import java.util.Calendar;

@Data
public class TReserva {
    private int id;
    private int participantes;
    private double precio;
    private int duracion;
    private String cliente;
    private boolean activo;
    private String nombreEscapeRoom;
    private Calendar fechaIni;
    private Calendar fechaFin;

}
