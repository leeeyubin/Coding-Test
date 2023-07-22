import java.util.*;
fun main(){
    val scanner = Scanner(System.`in`)
    val T = scanner.nextInt()
    var answer: IntArray = IntArray(T+1, { 0 })
    for(i in 1..T){
        var A = scanner.nextInt()
        var B = scanner.nextInt()
        answer[i] = A + B
    }

    for(i in 1..T){
        println(answer[i])
    }
}