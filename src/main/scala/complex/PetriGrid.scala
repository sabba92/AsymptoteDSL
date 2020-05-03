package complex

import atoms._
import traits._

import scala.language.postfixOps

class PetriGrid(p: Map[String, (Int, Int)],
                t: Map[String, (Int, Int)],
                i: Map[String, List[String]],
                o: Map[String, List[String]],
                m: List[(String, Int)],
                wi: List[(String, String, Int)],
                wo: List[(String, String, Int)]) extends Petri( i, o, m, wi, wo, 0.5, 2 ) {

  def addPlace(place: (String, (Int, Int))): Unit = {
    val x = place._2._1 * this.block + this.half
    val y = place._2._2 * this.block + this.half
    this.places +=
      (place._1 -> new Place(place._1, x, y, new Circle radius half centered(x, y)))
    this.addLabel(place._1, x, y - half)
  }

  def addTransition(transition: (String, (Int, Int))): Unit = {
    val x = transition._2._1 * this.block + this.half
    val y = transition._2._2 * this.block + this.half
    var b: TransformableObject = new Box from(-half / 4.0, half) to(half / 4.0, -half)
    var name = transition._1
    var offset = this.half
    var r: Boolean = false
    if (name.takeRight(1) == "_") {
      b = b rotate 90
      name = name dropRight 1
      offset /= 4.0
      r = true
    }

    this.transitions += (transition._1 ->
      new Transition(transition._1, x, y, b shift (x, y) fill true, r)
    )
    this.addLabel(name, x, y - offset)
  }

  p foreach this.addPlace
  t foreach this.addTransition

  this.addArrows(i, o)
  this.addMarkings(m)
}