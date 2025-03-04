import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = System.out.bufferedWriter()

    val n = bufferedReader.readLine().toInt()

    val list = BooleanArray(2_000_001)

    repeat(n) {
        list[bufferedReader.readLine().toInt() + 1_000_000] = true
    }

    val stringBuilder = StringBuilder()

    for(i in list.indices) {
        if(list[i]) {
            stringBuilder.append("${i-1_000_000}\n")
        }
    }

    bufferedWriter.write(stringBuilder.toString())

    bufferedReader.close()
    bufferedWriter.close()
}
