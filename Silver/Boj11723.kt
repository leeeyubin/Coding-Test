import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.ByteArrayOutputStream

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val outStream = ByteArrayOutputStream()

    val s = BooleanArray(21)
    val m = reader.readLine().toInt()

    repeat(m) {
        val input = reader.readLine()
        val parts = input.split(" ")

        val order = parts[0]
        val number = if (parts.size == 2) parts[1].toInt() else 0

        when (order) {
            "add" -> s[number] = true
          
            "remove" -> s[number] = false
          
            "check" -> {
                if (s[number]) outStream.write("1\n".toByteArray())
                else outStream.write("0\n".toByteArray())
            }
            
            "toggle" -> s[number] = !s[number]
          
            "all" -> for (i in 1..20) s[i] = true
          
            "empty" -> for (i in 1..20) s[i] = false
        }
    }

    System.out.write(outStream.toByteArray())
}
