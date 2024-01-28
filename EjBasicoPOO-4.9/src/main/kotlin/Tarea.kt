import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 *
 */
class Tarea (val id: Int, var estado: Estado, val descripcion: String ) {

    enum class Estado {PENDIENTE, REALIZADA}


    fun realizarTarea(){
        if (this.estado == Estado.PENDIENTE){
            estado = Estado.REALIZADA
        }
    }

//    override fun toString(): String {
//        if (estado == Estado.REALIZADA){
//            return "ID: ${this.id} ; Descripcion: $descripcion ; Estado: $estado ; Fecha realizacion: $fechaFormateada"
//        }
//        return "ID: $id ; Descripcion: $descripcion ; Estado: $estado"
//    }

}