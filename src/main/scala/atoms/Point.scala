package atoms

import traits.{AsymptoteObject, TransformableObject}

trait Point extends TransformableObject {
  def x: Double
  def y: Double

  def +(coords: (Double, Double)): Point = Point(this.x + coords._1, this.y + coords._2)
  def -(coords: (Double, Double)): Point = Point(this.x - coords._1, this.y - coords._2)
  def *(f: Double): Point = Point(this.x * f, this.y * f)
  def +(point: Point): Point = this + (point.x, point.y)
  def -(point: Point): Point = this - (point.x, point.y)

  def mid(p: Point): Point = Point((this.x + p.x) / 2, (this.y + p.y) / 2)
}

object Point {
  def apply(x: Double, y: Double): Point = PointImpl(x, y)
  def apply(coords: (Double, Double)): Point = PointImpl(coords._1, coords._2)
}

case class PointImpl(a: Double, b: Double) extends Point {
  override def x: Double = a
  override def y: Double = b
  override def toAsyString: String = "(" concat x.toString concat "," concat y.toString concat ")"
}