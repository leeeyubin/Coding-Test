class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var currentPos = pos

        for (command in commands) {
            
            if (isOpening(currentPos, op_start, op_end)) {
                currentPos = op_end
            }

            when (command) {
                "next" -> {
                    currentPos = addSeconds(currentPos, 10)
                    if (getSeconds(video_len) - getSeconds(currentPos) < 10) {
                        currentPos = video_len
                    }
                }

                "prev" -> {
                    currentPos = subtractSeconds(currentPos, 10)
                    if (getSeconds(currentPos) < 0) {
                        currentPos = "00:00"
                    }
                }
            }

            if (isOpening(currentPos, op_start, op_end)) {
                currentPos = op_end
            }
        }

        return currentPos
    }

    private fun isOpening(time: String, opStart: String, opEnd: String): Boolean {
        val t = getSeconds(time)
        val start = getSeconds(opStart)
        val end = getSeconds(opEnd)
        return t in start..end
    }

    private fun getSeconds(time: String): Int {
        val (mm, ss) = time.split(":").map { it.toInt() }
        return mm * 60 + ss
    }

    private fun toTimeFormat(seconds: Int): String {
        val mm = seconds / 60
        val ss = seconds % 60
        return String.format("%02d:%02d", mm, ss)
    }

    private fun addSeconds(time: String, sec: Int): String {
        val newSec = getSeconds(time) + sec
        return toTimeFormat(newSec)
    }

    private fun subtractSeconds(time: String, sec: Int): String {
        val newSec = getSeconds(time) - sec
        return toTimeFormat(if (newSec < 0) 0 else newSec)
    }
}
