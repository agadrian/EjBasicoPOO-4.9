/**
 * Ejercicio 4.9¶
 * Realizar un programa para gestionar una Lista de tareas con POO.
 *
 * El programa debe mostrar un menú en el que se pueda agregar (por defecto una nueva tarea tendrá el estado pendiente), eliminar y cambiar el estado de una tarea. También será posible mostrar la lista de tareas (todas las tareas), mostrar la lista de tareas pendientes y la lista de tareas ya realizadas.
 *
 * Una tarea debe tener un identificador (podrá indicarlo o generarlo automáticamente), una descripción y un estado que indique si está pendiente o ya fue realizada (en este caso, deberá mostrar la fecha, con formato DD-MM-AAAA HH:MM:SS, en la que se marcó cómo realizada)
 *
 * Os muestro un ejemplo de cómo generar una fecha:
 *
 * import java.time.LocalDateTime
 * import java.time.format.DateTimeFormatter
 * fun main() {
 *     val fechaHoraActual: LocalDateTime = LocalDateTime.now()
 *     // Formatear la fecha y hora para imprimir
 *     val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
 *     val fechaFormateada: String = fechaHoraActual.format(formatter)
 *     println("Fecha y Hora Actual: $fechaFormateada")
 * }
 */

fun main() {

    var opc: Int
    val lista = ListaTareas()

    do {
        mostrarMenu()
        opc = pedirOpc(0,6)

        when (opc){
            1 -> {
                lista.agregarTarea(pedirDescripcion())
            }

            2 -> {
                lista.eliminarTarea(pedirID())
            }

            3 -> {
                lista.cambiarEstado(pedirID())
            }

            4 -> {
                lista.mostrarTodasTareas()
            }

            5 -> {
                lista.mostrarTareasPend()
            }

            6 -> {
                lista.mostrarTareasRealizadas()
            }

        }

    }while (opc != 0)

}

fun mostrarMenu(){
    println("\nMenu Tareas\n-----------")
    println("1.- Agregar tarea")
    println("2.- Eliminar tarea")
    println("3.- Cambiar estado tarea")
    println("4.- Mostrar todas las tareas")
    println("5.- Mostrar tareas pendientes")
    println("6.- Mostrar tareas realizadas")
    println("0.- Salir\n")
}


/**
 * Pide introducir una opcion y comprueba que este dentro de un rango dado
 * @param min Numero minimo del rango de opciones
 * @param max Numero maximo del rango de opciones
 * @return opcion - Int: Retorna la opcion elegida
 */
fun pedirOpc(min: Int, max: Int) : Int{
    var opcion: Int

    do {
        print("Seleccione la opcion (0 = SALIR) >> ")

        opcion = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("**OPCION NO VALIDA**")
            -1
        }

        if (opcion !in min..max) {
            println("OPCION NO VALIDA")
        }
    } while (opcion !in min..max)

    return opcion
}

/**
 * Pide una descripcion para añadir a la creacion de la tarea
 * @return Cadena de caracteres de la descripcion introducida
 */
fun pedirDescripcion(): String {
    println("Introduce la descripcion de la tarea: ")
    return readln()
}

/**
 * Pide la ID de la tarea y llama a otra funcion para validarla
 * @return Int del numero de la ID introducida
 */
fun pedirID(): Int{
    println("Introduce ID de la tarea: ")
    return pedirIntPositivo()
}

/**
 * Comprueba que el valor introducido es numerico y positivo. Sigue pidiendolo hasta ser valido.
 * @return El numero introducido valido
 */
fun pedirIntPositivo(): Int{
    var num: Int?

    do {
        val valor = readln()
        num = valor.toIntOrNull()

        if (num == null || num < 1) println("Debes introducir un numero entero positivo: ")

    }while (num == null || num < 1)
    return num
}