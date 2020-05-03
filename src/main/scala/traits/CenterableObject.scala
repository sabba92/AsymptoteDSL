package traits

import atoms.Point

trait CenterableObject extends DrawableObject {
  var center: Point = Point(0, 0)

  def centered(p: (Double, Double)): CenterableObject = this.centered(Point(p))
  def centered(p: Point): CenterableObject = ???
}
