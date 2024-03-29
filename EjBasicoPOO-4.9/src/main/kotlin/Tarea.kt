import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 *Clase Tarea que crea las tareas con una id, descripcion y estado
 */
class Tarea (val id: Int, var estado: Estado, val descripcion: String ) {



    fun realizarTarea(){
        if (this.estado == Estado.PENDIENTE){
            estado = Estado.REALIZADA
        }else{
            estado = Estado.PENDIENTE
        }
    }

}