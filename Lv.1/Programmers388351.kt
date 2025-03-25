class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0

        for (i in schedules.indices) {
            var isOnePersonPass: Int = 0
            var personday: Int = startday

            for (j in 0..6) {
                if (isPass(timelogs[i][j], schedules[i]) && isWeekend(personday)) {
                    isOnePersonPass++
                }
                personday++
            }
            if (isOnePersonPass == 5) answer++
        }

        return answer
    }

    private fun isPass(timelogs: Int, schedules: Int): Boolean {
        val actualMinute = (timelogs / 100) * 60 + (timelogs % 100)
        val scheduleMinute = (schedules / 100) * 60 + (schedules % 100)

        return actualMinute <= scheduleMinute + 10
    }

    private fun isWeekend(today: Int): Boolean {
        val value: Int = today % 7

        return (value != 6 && value != 0)
    }
}
