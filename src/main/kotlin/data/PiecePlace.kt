package org.example.data

import org.example.objects.Piece

data class PiecePlace(
    val x: Int,
    val y: Int,
    var piece: Piece?
)