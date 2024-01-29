import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListaTareas {

    private var listaTareas: MutableList<Tarea> = mutableListOf()
    private var ids = 1


    // Ejemplo fecha
    private val fechaHoraActual: LocalDateTime = LocalDateTime.now()
    // Formatear la fecha y hora para imprimir
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    private val fechaFormateada: String = fechaHoraActual.format(formatter)


    /**
     * Agrega una nueva tarea a la lista. Por defecto pendiente
     * @param descripcion Descripcion de la tarea en si
     */
    fun agregarTarea(descripcion: String){
        val tarea = Tarea(ids++, Estado.PENDIENTE, descripcion)
        listaTareas.add(tarea)
        println("Tarea con ID -${tarea.id}- y descripcion -${tarea.descripcion}- agregada correctamente.")
    }


    /**
     * Busca la tarea con el id deseado y si existe, elimina la tarea.
     * @param cod Id de la tarea a eliminar
     */
    fun eliminarTarea(cod: Int){
        val tarea = listaTareas.find { it.id == cod }
        if (tarea != null) {
            listaTareas.remove(tarea)
            println("Se ha eliminado la tarea con id $cod")
        } else{
            println("No se ha encontrado ninguna tarea con el id $cod")
        }
    }


    /**
     * Busca si existe la tarea con el ID deseado, y cambia su estado
     * @param cod Id de la tarea a buscar
     */
    fun cambiarEstado(cod: Int){
        val tarea = listaTareas.find { it.id == cod }
        if (tarea != null){
            tarea.realizarTarea()
            println("El estado de la tarea con ID $cod a cambiado a: ${tarea.estado}")
        }else{
            println("No hay ninguna tarea con esa ID!")
        }
    }

    /**
     * Muestra un listado de todas la tareas realizadas/por realizar. Incluye ID, Descripcion y estado
     */
    fun mostrarTodasTareas(){
        if (listaTareas.isNotEmpty()) {
            println("Lista completa de tareas: ")
            for (tarea in listaTareas) {
                if (tarea.estado == Estado.REALIZADA) {
                    println("ID: ${tarea.id} - Descripcion: ${tarea.descripcion} - Estado: ${tarea.estado} - Fecha realizacion: $fechaFormateada")
                } else {
                    println("ID: ${tarea.id} - Descripcion: ${tarea.descripcion} - Estado: ${tarea.estado}")
                }
            }
        }else println("No hay ninguna tarea.")
    }

    /**
     * Muestra un listado de las tareas pendientes. Incluye ID, Descripcion y estado
     */
    fun mostrarTareasPend(){
        if (listaTareas.isNotEmpty()) {
            println("Lista de tareas pendientes: ")
            for (tarea in listaTareas) {
                if (tarea.estado == Estado.PENDIENTE) {
                    println("ID: ${tarea.id} - Descripcion: ${tarea.descripcion} - Estado: ${tarea.estado}")
                }
            }
        }else println("No hay tareas pendientes.")
    }

    /**
     * Muestra un listado de las tares realizadas. Incluye ID, Descripcion, estado y su hora de realizacion
     * Se muestra usando filter y foreach esta vez, en vez de un bucle for in
     */
    fun mostrarTareasRealizadas(){
        if (listaTareas.isNotEmpty()) {
            println("Lista de tareas realizadas: ")
            listaTareas.filter { it.estado == Estado.REALIZADA }.forEach { tarea -> println("ID: ${tarea.id} - Descripcion: ${tarea.descripcion} - Estado: ${tarea.estado} - Fecha realizacion: $fechaFormateada") }
        }else println("No hay tareas realizadas.")
    }
}