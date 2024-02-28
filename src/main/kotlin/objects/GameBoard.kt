package org.example.objects

import com.raylib.Jaylib.*
import java.util.concurrent.CopyOnWriteArrayList

class GameBoard {

    private val cells = CopyOnWriteArrayList<Cell>()
    private val personalCells = CopyOnWriteArrayList<Cell>()

    init {
        getCells()
    }

    private fun getCells() {
        val arr = IntArray(52) { it + 1 }

        for ((index, i) in (0 until 52).withIndex()) {
            val cell = when {
                i < 3 -> Cell(300 + i * 50, 0, arr[index])
                i < 8 -> Cell(400, 50 * (i - 2), arr[index])
                i < 13 -> Cell(400 + (i - 7) * 50, 300, arr[index])
                i < 16 -> Cell(700, 300 + (i - 13) * 50, arr[index])
                i < 21 -> Cell(700 - (i - 15) * 50, 400, arr[index])
                i < 26 -> Cell(400, 400 + (i - 20) * 50, arr[index])
                i < 29 -> Cell(400 - (i - 26) * 50, 700, arr[index])
                i < 34 -> Cell(300, 700 - (i - 28) * 50, arr[index])
                i < 39 -> Cell(300 - (i - 33) * 50, 400, arr[index])
                i < 42 -> Cell(0, 400 - (i - 39) * 50, arr[index])
                i < 47 -> Cell((i - 41) * 50, 300, arr[index])
                else -> Cell(300, 300 - (i - 46) * 50, arr[index])
            }
            cells.add(cell)
        }
        for (i in 53..72) {
            val cell = when {
                i < 58 -> Cell(350, (i - 52) * 50, i)
                i < 63 -> Cell(650 - (i - 58) * 50, 350, i)
                i < 68 -> Cell(350, 650 - (i - 63) * 50, i)
                else -> Cell((i - 67) * 50, 350, i)
            }
            personalCells.add(cell)
        }
    }


    fun draw() {
        DrawRectangle(0, 0, 300, 300, GREEN)
        DrawRectangle(450, 0, 300, 300, YELLOW)
        DrawRectangle(0, 450, 300, 300, RED)
        DrawRectangle(450, 450, 300, 300, DARKBLUE)
    }

    fun drawCell() {
        cells.map { it.draw() }
        personalCells.map { it.draw() }
     }

}