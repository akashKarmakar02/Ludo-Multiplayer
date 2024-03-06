package org.example.logic

import org.example.data.Ludo
import org.example.objects.Cell
import org.example.objects.Piece
import java.util.concurrent.CopyOnWriteArrayList

class PieceHandler(
    private val cells: ArrayList<Cell>,
    private val personalCells: CopyOnWriteArrayList<Cell>
) {
    private val pieces: Array<Piece> = Array(16) {
        when (it % 4) {
            0 -> Piece(cells, personalCells, Ludo.YELLOW)
            1 -> Piece(cells, personalCells, Ludo.GREEN)
            2 -> Piece(cells, personalCells, Ludo.RED)
            3 -> Piece(cells, personalCells, Ludo.BLUE)
            else -> throw IllegalStateException("Invalid Ludo type")
        }
    }


    fun draw() {
        pieces.map { it.draw() }
    }

    fun update() {
        pieces.map { it.update() }
    }

}