package org.example.objects

import com.raylib.Jaylib.*
import org.example.data.Ludo
import org.example.data.PiecePlace

class Box(
    private val x: Int,
    private val y: Int,
    ludo: Ludo
) {

    val piecePlaces = run {
        val place1 = PiecePlace(x + 110, y + 110, null)
        val place2 = PiecePlace(x + 190, y + 110, null)
        val place3 = PiecePlace(x + 110, y + 190, null)
        val place4 = PiecePlace(x + 190, y + 190, null)
        val arr = arrayListOf(place1, place2, place3, place4)
        arr
    }


    private val color = when(ludo) {
        Ludo.RED -> RED
        Ludo.BLUE -> DARKBLUE
        Ludo.YELLOW -> YELLOW
        Ludo.GREEN -> GREEN
    }

    fun draw() {
        DrawRectangle(x, y, 300, 300, color)
        DrawRectangle(x + 50, y + 50, 200, 200, WHITE)
        DrawRectangleLines(x + 50, y + 50, 200, 200, BLACK)
        DrawCircle(x + 110, y + 110, 24F, color)
        DrawCircleLines(x + 110, y + 110, 24F, BLACK)
        DrawCircle(x + 190, y + 110, 24F, color)
        DrawCircleLines(x + 190, y + 110, 24F, BLACK)
        DrawCircle(x + 110, y + 190, 24F, color)
        DrawCircleLines(x + 110, y + 190, 24F, BLACK)
        DrawCircle(x + 190, y + 190, 24F, color)
        DrawCircleLines(x + 190, y + 190, 24F, BLACK)
    }

}