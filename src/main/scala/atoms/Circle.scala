package atoms

import traits._

class Circle extends CenterableObject with TransformableObject {
  var r: Double = 1

  override def centered(p: (Double, Double)): Circle = this.centered(Point(p))
  override def centered(p: Point): Circle = {
    this.center = p
    this.updateParam
    this
  }

  def radius(r: Double): Circle = {
    this.r = r
    this.updateParam
    this
  }

  def updateParam: Unit =
    super.updateParam("circle(" concat this.center.toAsyString concat ", " concat this.r.toString concat ")")
}