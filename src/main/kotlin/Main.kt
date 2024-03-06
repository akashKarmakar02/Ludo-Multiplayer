package org.example

import com.raylib.Jaylib.*
import org.example.logic.PieceHandler
import org.example.objects.GameBoard


fun main() {
    InitWindow(750, 900, "Ludo")

    val gameBoard = GameBoard()
    val pieceHandler = PieceHandler(gameBoard.cells, gameBoard.personalCells)

    while(!WindowShouldClose()) {
        BeginDrawing()

        gameBoard.draw()
        gameBoard.drawCell()
        pieceHandler.draw()
        pieceHandler.update()

        EndDrawing()
    }

    CloseWindow()
}