import java.util.*
fun main(){
    val scanner = Scanner(System.`in`)
    val num1 = scanner.nextInt()
    val num2 = scanner.nextInt()
    val num3 = scanner.nextInt()

    if(num1 == num2 && num2 == num3 && num3 == num1){
        println(10000 + num1 * 1000)
    }else if(num1 == num2 || num2 == num3 || num3 == num1){
        if(num1 == num2)
            println(1000 + num1 * 100)
        if(num2 == num3)
            println(1000 + num2 * 100)
        if(num3 == num1)
            println(1000 + num3 * 100)
    }else{
        var max = 0
        if(num1 > max)
            max = num1
        if(num2 > max)
            max = num2
        if(num3 > max)
            max = num3
        println(max * 100)
    }
}
