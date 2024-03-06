package org.example.objects

import com.raylib.Jaylib.*
import com.raylib.Raylib.Color
import org.example.data.Ludo
import org.example.data.PiecePlace
import java.util.concurrent.CopyOnWriteArrayList

class Piece(
    cells: ArrayList<Cell>,
    personalCells: CopyOnWriteArrayList<Cell>,
    private val ludo: Ludo
) {
    private val color: Color = when(ludo) {
        Ludo.RED -> RED
        Ludo.BLUE -> DARKBLUE
        Ludo.YELLOW -> YELLOW
        Ludo.GREEN -> GREEN
    }

    private var isPlayable = false

    private val homePlaces = when(ludo) {
        Ludo.RED -> GameBoard.redBox.piecePlaces
        Ludo.BLUE -> GameBoard.blueBox.piecePlaces
        Ludo.YELLOW -> GameBoard.yellowBox.piecePlaces
        Ludo.GREEN -> GameBoard.greenBox.piecePlaces
    }

    private var homePlace: PiecePlace? = null

    init {
        getHomePlace()
    }


    private var path: Array<Cell> = when(ludo) {
        Ludo.YELLOW -> {
            val arr = cells.slice(3..51).toMutableList()
            arr += cells[0]
            arr += cells[1]
            arr.toTypedArray()
        }
        Ludo.RED -> {
            val arr = cells.slice(29..51).toMutableList()
            arr += cells.slice(0..27)
            arr.toTypedArray()
        }
        Ludo.BLUE -> {
            val arr = cells.slice(16..51).toMutableList()
            arr += cells.slice(0..14)
            arr.toTypedArray()
        }
        Ludo.GREEN -> {
            val arr = cells.slice(42..51).toMutableList()
            arr += cells.slice(0..40)
            arr.toTypedArray()
        }
    }

    private val personalPath = when(ludo) {
        Ludo.RED -> personalCells.slice(10..14).toTypedArray()
        Ludo.BLUE -> personalCells.slice(5..9).toTypedArray()
        Ludo.YELLOW -> personalCells.slice(0..4).toTypedArray()
        Ludo.GREEN -> personalCells.slice(15..19).toTypedArray()
    }
    private var index = 0

    private fun getHomePlace() {
        for (place in homePlaces) {
            if (place.piece == null) {
                homePlace = place
                place.piece = this
                return
            }
        }
    }

    fun draw() {
        if (!isPlayable) {
            if (homePlace != null) {
                DrawCircle(homePlace!!.x, homePlace!!.y - 19, 13F, Color(240, 240, 240, 255))
                DrawCircleLines(homePlace!!.x, homePlace!!.y - 19, 13F, BLACK)
                DrawTriangle(
                    Vector2(homePlace!!.x - 12F, homePlace!!.y - 13F),
                    Vector2(homePlace!!.x.toFloat(), homePlace!!.y + 9F),
                    Vector2(homePlace!!.x + 13F, homePlace!!.y - 17F),
                    Color(240, 240, 240, 255)
                )
                DrawLine(homePlace!!.x - 13, homePlace!!.y - 17, homePlace!!.x , homePlace!!.y + 9, BLACK)
                DrawLine(homePlace!!.x + 13, homePlace!!.y - 17, homePlace!!.x , homePlace!!.y + 9, BLACK)

                DrawCircle(homePlace!!.x, homePlace!!.y - 19, 8F, color)
                DrawCircleLines(homePlace!!.x, homePlace!!.y - 19, 8F, BLACK)
            }
        } else {
            DrawCircle(path[index].x + 25, path[index].y + 25 - 19, 13F, Color(240, 240, 240, 255))
            DrawCircleLines(path[index].x + 25, path[index].y + 25 - 19, 13F, BLACK)
            DrawTriangle(
                Vector2(path[index].x + 25F - 13F, path[index].y + 25F - 13F),
                Vector2(path[index].x.toFloat() + 25, path[index].y + 9F + 25),
                Vector2(path[index].x + 13F + 25, path[index].y - 17F + 25),
                Color(240, 240, 240, 255)
            )
            DrawLine(path[index].x + 25 - 13, path[index].y + 25 - 17, path[index].x + 25, path[index].y + 25 + 9, BLACK)
            DrawLine(path[index].x + 25 + 13, path[index].y + 25 - 17, path[index].x + 25, path[index].y + 25 + 9, BLACK)

            DrawCircle(path[index].x + 25, path[index].y + 25 - 19, 8F, color)
            DrawCircleLines(path[index].x + 25, path[index].y + 25 - 19, 8F, BLACK)
        }
    }

    private fun isPointInside(x: Int, y: Int): Boolean {
        val distance: Double = if (!isPlayable)
            ((x - this.homePlace!!.x) * (x - this.homePlace!!.x) + (y - this.homePlace!!.y) * (y - this.homePlace!!.y)).toDouble()
        else
            ((x - 25 - this.path[index].x) * (x - 25 - this.path[index].x) + (y - 25 - this.path[index].y) * (y - 25 - this.path[index].y)).toDouble()
        val radiusSquared = 25 * 25
        println(distance)
        return distance <= radiusSquared
    }

    fun update() {
        if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
            val mouseX = GetMouseX()
            val mouseY = GetMouseY()
            if (isPointInside(mouseX, mouseY)) {
                if (!isPlayable)
                    isPlayable = true
                else {
                    when(ludo) {
                        Ludo.RED -> {
                            when (path[index].value) {
                                28 -> {
                                    path = personalPath
                                    this.index = 0
                                }
                                67 -> {

                                }
                                else -> {
                                    this.index++
                                }
                            }
                        }
                        Ludo.BLUE -> {
                            when (path[index].value) {
                                15 -> {
                                    path = personalPath
                                    this.index = 0
                                }
                                62 -> {

                                }
                                else -> {
                                    this.index++
                                }
                            }
                        }
                        Ludo.YELLOW -> {
                            when (path[index].value) {
                                2 -> {
                                    path = personalPath
                                    this.index = 0
                                }
                                57 -> {

                                }
                                else -> {
                                    this.index++
                                }
                            }
                        }
                        Ludo.GREEN -> {
                            when (path[index].value) {
                                41 -> {
                                    path = personalPath
                                    this.index = 0
                                }
                                72 -> {

                                }
                                else -> {
                                    this.index++
                                }
                            }
                        }
                    }
                }

            }
        }
    }

}