class Matrix(val entries: List<List<Int>>) {

  private val indices: Set<MatrixCoordinate> =
    (0 until entries.size).flatMap { row ->
      (0 until entries[row].size).map { col ->
        MatrixCoordinate(row, col)
      }
    }.toSet()

  private fun isMaxInRow(coords: MatrixCoordinate) =
    entries[coords.row].max() == entries[coords.row][coords.col]

  private fun isMinInCol(coords: MatrixCoordinate) =
    entries.map { row ->
      row[coords.col]
    }.min() == entries[coords.row][coords.col]

  private fun isSaddlePoint(coords: MatrixCoordinate) =
    isMaxInRow(coords) and isMinInCol(coords)

  val saddlePoints: Set<MatrixCoordinate> =
    indices.filter(
      this::isSaddlePoint
    ).toSet()
}