package matrix

import scala.collection.mutable.HashMap
import scala.collection._

class Matrix[N <: AnyVal](val rows: Int, val cols: Int) {

  private var entries: HashMap[Tuple2[Int, Int], N] = new HashMap()

  def shape: Tuple2[Int, Int] = (rows, cols)

  def shapeAsString: String = rows + "×" + cols

  /**
   * Returns the (i, j)th entry of this matrix.
   */
  def apply(i: Int, j: Int) = {
    if (0 <= i && i < rows && 0 <= j && j < cols) {
      if (entries contains (i, j))
        entries(i, j)
      else 0
    }
    throw new IndexOutOfBoundsException("Index " + (i, j) + " is invalid for a " + shapeAsString + " matrix")
  }

  def isSquare: Boolean = (rows == cols)

}

abstract class MatrixIterator[N <: AnyVal](val m: Matrix[N]) extends AbstractIterator[N] {
  private var i: Int = 0
  private var j: Int = 0

  override def hasNext = (i >= m.rows && j >= m.cols)

  override def next = {
    // Moving horizontally
    val res = m(i, j)
    j += 1
    // then vertically
    // I'd love a way to signal the end of a row, but () (type Unit) won't work because it extends AnyRef, not AnyVal.
    if (j >= m.cols) {
      j = 0  // CR
      i += 1 // LF
    }
    res
  }
}
