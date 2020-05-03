package atoms

import traits._

class Ellipse extends CenterableObject with TransformableObject {
  var a: (Double, Double) = (1, 1)

  override def centered(p: (Double, Double)): Ellipse = this.centered(Point(p))
  override def centered(p: Point): Ellipse = {
    this.center = p
    this.updateParam
    this
  }

  def axes(a: (Double, Double)): Ellipse = {
    this.a = a
    this.updateParam
    this
  }

  def updateParam: Unit =
    super.updateParam("ellipse(" concat this.center.toAsyString concat ", "
                      concat this.a._1.toString concat "," concat this.a._2.toString concat ")")
}