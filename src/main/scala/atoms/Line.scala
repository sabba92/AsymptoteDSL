package atoms

import traits.DrawableObject

import scala.collection.mutable.ListBuffer

class Line extends DrawableObject {
  implicit def listToParams(l: ListBuffer[Point]): String = {
    var points = l(0).toAsyString
    l.tail.foreach(e => points = points concat " " concat this.connector concat " " concat e.toAsyString)
    points
  }

  val points: ListBuffer[Point] = ListBuffer.empty[Point]
  var connector: String = "--"

  def from(p: Point): Line = this.addPoint(p)
  def from(p: (Double, Double)): Line = this.from(Point(p))

  def to(p: Point): Line = this.addPoint(p)
  def to(p: (Double, Double)): Line = this.to(Point(p))

  def addPoint(p: Point): Line = {
    this.points += p
    this.updateParam(this.points)
    this
  }

  def curved: Line = {
    this.connector = ".."
    this.updateParam(this.points)
    this
  }
}