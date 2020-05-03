package atoms

import traits.AsymptoteObject

class Dot extends AsymptoteObject {
  this.action = "dot"
  var p: Point = Point(0, 0)

  def in(p: (Double, Double)): Dot = this.in(Point(p))
  def in(p: Point): Dot = {
    this.p = p
    this.updateParam(this.p.toAsyString)
    this
  }
}