package org.example.objects

import com.raylib.Jaylib.*
import org.example.data.Ludo
import java.util.concurrent.CopyOnWriteArrayList

class GameBoard {

    val cells = ArrayList<Cell>()
    val personalCells = CopyOnWriteArrayList<Cell>()


    init {
        getCells()
    }

    private fun getCells() {
        val arr = IntArray(52) { it + 1 }

        for ((index, i) in (0 until 52).withIndex()) {
            val cell = when {
                i < 3 -> Cell(300 + i * 50, 75, arr[index])
                i < 8 -> Cell(400, 50 * (i - 2) + 75, arr[index])
                i < 13 -> Cell(400 + (i - 7) * 50, 375, arr[index])
                i < 16 -> Cell(700, 300 + (i - 13) * 50 + 75, arr[index])
                i < 21 -> Cell(700 - (i - 15) * 50, 475, arr[index])
                i < 26 -> Cell(400, 400 + (i - 20) * 50 + 75, arr[index])
                i < 29 -> Cell(400 - (i - 26) * 50, 775, arr[index])
                i < 34 -> Cell(300, 700 - (i - 28) * 50 + 75, arr[index])
                i < 39 -> Cell(300 - (i - 33) * 50, 475, arr[index])
                i < 42 -> Cell(0, 400 - (i - 39) * 50 + 75, arr[index])
                i < 47 -> Cell((i - 41) * 50, 375, arr[index])
                else -> Cell(300, 300 - (i - 46) * 50 + 75, arr[index])
            }
            cells.add(cell)
        }
        for (i in 53..72) {
            val cell = when {
                i < 58 -> Cell(350, (i - 52) * 50 + 75, i)
                i < 63 -> Cell(650 - (i - 58) * 50, 425, i)
                i < 68 -> Cell(350, 650 - (i - 63) * 50 + 75, i)
                else -> Cell((i - 67) * 50, 425, i)
            }
            personalCells.add(cell)
        }

    }

    fun draw() {
        greenBox.draw()
        yellowBox.draw()
        blueBox.draw()
        redBox.draw()
    }

    fun drawCell() {
        cells.map { it.draw() }
        personalCells.map { it.draw() }

        DrawTriangle(
            Vector2(300F, 300F + 75),
            Vector2(375F, 375F + 75),
            Vector2(450F, 300F + 75),
            YELLOW
        )
        DrawTriangleLines(
            Vector2(300F, 300F + 75),
            Vector2(375F, 375F + 75),
            Vector2(450F, 300F + 75),
            BLACK
        )

        DrawTriangle(
            Vector2(450F, 300F + 75),
            Vector2(375F, 375F + 75),
            Vector2(450F, 450F + 75),
            DARKBLUE
        )
        DrawTriangleLines(
            Vector2(450F, 300F + 75),
            Vector2(375F, 375F + 75),
            Vector2(450F, 450F + 75),
            BLACK
        )

        DrawTriangle(
            Vector2(450F, 450F + 75),
            Vector2(375F, 375F + 75),
            Vector2(300F, 450F + 75),
            RED
        )
        DrawTriangleLines(
            Vector2(450F, 450F + 75),
            Vector2(375F, 375F + 75),
            Vector2(300F, 450F + 75),
            BLACK
        )

        DrawTriangle(
            Vector2(300F, 450F + 75),
            Vector2(375F, 375F + 75),
            Vector2(300F, 300F + 75),
            GREEN
        )
        DrawTriangleLines(
            Vector2(300F, 450F + 75),
            Vector2(375F, 375F + 75),
            Vector2(300F, 300F + 75),
            BLACK
        )
    }

    companion object {
        val greenBox = Box(0, 75, Ludo.GREEN)
        val yellowBox = Box(450, 75, Ludo.YELLOW)
        val redBox = Box(0, 525, Ludo.RED)
        val blueBox = Box(450, 525, Ludo.BLUE)
    }

}