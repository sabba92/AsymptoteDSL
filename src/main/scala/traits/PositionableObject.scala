package traits

import atoms.Point

trait PositionableObject {
  val name: String
  val x: Double
  val y: Double
  val asy: AsymptoteObject

  def getPosition: Point = Point(this.x, this.y)

  def <(obj: PositionableObject, coord: String): Boolean = coord match {
    case "x" => this.x < obj.x
    case "y" => this.y < obj.y
  }
}

class Place(n: String, xpos: Double, ypos: Double, obj: AsymptoteObject) extends PositionableObject {
  val name: String = n
  val x: Double = xpos
  val y: Double = ypos
  val asy: AsymptoteObject = obj
}

class Transition(n: String, xpos: Double, ypos: Double, obj: AsymptoteObject, r: Boolean = false) extends PositionableObject {
  val name: String = n
  val x: Double = xpos
  val y: Double = ypos
  val asy: AsymptoteObject = obj
  var rotated: Boolean = r
}