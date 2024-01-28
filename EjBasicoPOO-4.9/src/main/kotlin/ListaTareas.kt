class ListaTareas {

    var listaTareas: MutableList<Tarea> = mutableListOf()
    var ids = 1

    /**
     * Agrega una nueva tarea a la lista. Por defecto pendiente
     * @param descripcion Descripcion de la tarea en si
     */
    fun agregarTarea(descripcion: String){
        val tarea = Tarea(ids++, Tarea.Estado.PENDIENTE, descripcion)
        listaTareas.add(tarea)
        println("Tarea $tarea Agregada correctamente.")
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

    fun mostrarTodasTareas(){

    }


    fun mostrarTareasPend(){

    }

    fun mostrarTareasRealizadas(){

    }
}