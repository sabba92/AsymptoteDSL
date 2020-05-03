package atoms

import traits._

class Box extends TransformableObject {

  var p1: Point = Point(0, 0)
  var p2: Point = Point(1, 1)

  def from(p: (Double, Double)): Box = this.from(Point(p))
  def from(p: Point): Box = {
    this.p1 = p
    this.updateParam()
    this
  }

  def to(p: (Double, Double)): Box = this.to(Point(p))
  def to(p: Point): Box = {
    this.p2 = p
    this.updateParam()
    this
  }

  def updateParam(): Unit =
    super.updateParam("box(" concat p1.toAsyString concat ", " concat p2.toAsyString concat ")")

  override def color(c: String): Box = {
    super.color(c)
    this
  }
}