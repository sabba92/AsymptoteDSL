package utils

object Utils {
  implicit def coordsToString(x: Double, y: Double): String =
    "(" concat x.toString concat "," concat y.toString concat ")"

  implicit def coordsToString(t: (Double, Double)): String =
    "(" concat t._1.toString concat "," concat t._2.toString concat ")"
}
