import scala.collection.mutable.HashMap

class Matrix(val rows: Int,
             val cols: Int,
             entries: HashMap[Tuple2[Int, Int], Double]) {

  def shape(): Tuple2[Int, Int] = (rows, cols)


}
