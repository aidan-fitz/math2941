import scala.collection.mutable.HashMap

class Matrix(val rows: Int,
             val cols: Int,
             entries: HashMap[Tuple2[Int, Int], Double]) {

  def shape: Tuple2[Int, Int] = (rows, cols)

  def shapeAsString: String = rows + "×" + cols

  /**
   * Returns the (i, j)th entry of this matrix.
   */
  def apply(i: Int, j: Int) = {
    // 0 <= i < rows && 0 <= j < cols
    if ((0 until rows contains i) && (0 until cols contains j)) {
      if (entries contains (i, j))
        entries(i, j)
      else 0
    }
    throw new IndexOutOfBoundsException("Index " + (i, j) + " is invalid for a " + shapeAsString + " matrix")
  }

  def isSquare: Boolean = (rows == cols)

}
