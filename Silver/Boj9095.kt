import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = bufferedReader.readLine().toInt()
    val inputList : ArrayList<Int> = ArrayList()
    val answerList : ArrayList<Int> = ArrayList()
    val dp: ArrayList<Int> = arrayListOf(0, 1, 2, 4)

    repeat(n) {
        inputList.add(bufferedReader.readLine().toInt())
    }

    val max = inputList.maxOrNull() ?: 0
    for (i in 4..max) {
        dp.add(dp[i - 1] + dp[i - 2] + dp[i - 3])
    }

    for (i in inputList) {
        answerList.add(dp[i])
    }

    for (i in answerList) {
        bufferedWriter.write("$i\n")
    }

    bufferedReader.close()
    bufferedWriter.close()
}
