import upickle.default.{ReadWriter => RW, macroRW}

case class Point(x: Double, y: Double)
object Point {
  implicit val rw: RW[Point] = macroRW
}