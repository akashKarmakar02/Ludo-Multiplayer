package org.example.objects

import com.raylib.Jaylib.*
import com.raylib.Raylib.Color

class Cell(
    val x: Int,
    val y: Int,
    val value: Int,
) {
    private var _isSafe: Boolean = false
    private var color: Color = WHITE

    val isSafe: Boolean
        get() = _isSafe

    init {
        when (value) {
            4 -> {
                _isSafe = true
                color = YELLOW
            }
            17 -> {
                _isSafe = true
                color = DARKBLUE
            }
            30 -> {
                _isSafe = true
                color = RED
            }
            43 -> {
                _isSafe = true
                color = GREEN
            }
            in 53..57 -> {
                color = YELLOW
            }
            in 58..62 -> {
                color = DARKBLUE
            }
            in 63..67 -> {
                color = RED
            }
            in 68..73 -> {
                color = GREEN
            }
        }
    }

    fun draw() {
        DrawRectangle(
            x, y, 50, 50, color
        )
        DrawLine(
            x, y, x + 50, y, BLACK
        )
        DrawLine(
            x, y, x, y + 50, BLACK
        )
        DrawLine(
            x + 50, y, x + 50, y + 50, BLACK
        )
        DrawLine(
            x, y + 50, x + 50, y + 50, BLACK
        )
//        DrawText("$value", x, y, 10, BLACK)
    }

}