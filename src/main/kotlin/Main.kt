package org.example

import com.raylib.Jaylib.*
import com.raylib.Raylib.*
import org.example.objects.GameBoard


fun main() {
    InitWindow(750, 750, "Ludo")

    val gameBoard = GameBoard()

    while(!WindowShouldClose()) {
        BeginDrawing()

        gameBoard.draw()
        gameBoard.drawCell()


        EndDrawing()
    }

    CloseWindow()
}