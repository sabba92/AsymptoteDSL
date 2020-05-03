package complex

import atoms._
import traits._

import scala.language.postfixOps

class PetriAuto(p: List[String],
                t: List[String],
                i: Map[String, List[String]],
                o: Map[String, List[String]],
                m: List[(String, Int)],
                wi: List[(String, String, Int)],
                wo: List[(String, String, Int)]) extends Petri( i, o, m, wi, wo, 4, 2 ) {

  def addPlace(place: String): Set[String] = {
    this.places +=
      (place -> new Place(place, x, y, new Circle radius half centered(x, y)))
    this.addLabel(place, x, y - half)
    y -= this.block

    i.filter(t => t._2 contains place).keys.filter(!transitions.contains(_)) toSet
  }

  def addTransition(transition: String): Set[String] = {
    this.transitions += (transition ->
      new Transition(transition, x, y, new Box from(x - half / 4, y + half) to(x + half / 4, y - half) fill true))
    this.addLabel(transition, x + half / 4.0, y - half)
    y -= this.block

    o getOrElse(transition, Set()) toSet
  }

  var x: Double = 0
  var y: Double = 0

  var placesToAdd: Set[String] = Set.empty[String]
  // piazze collegate alle prime transizioni
  i.filter(t => t._2.contains(p head)).foreach { t => placesToAdd ++= t._2.toSet }

  do {
    y = (placesToAdd.count(_ => true) - 1) * this.block / 2.0

    var transToAdd: Set[String] = Set.empty[String]
    placesToAdd foreach {
      transToAdd ++= this.addPlace(_)
    }
    transToAdd --= transitions.keys.toSet
    x += this.space

    y = (transToAdd.count(_ => true) - 1) * this.block / 2.0

    transToAdd foreach {
      placesToAdd ++= this.addTransition(_)
    }
    placesToAdd --= places.keys.toSet[String]
    x += this.space
  } while (placesToAdd nonEmpty)

  this.addArrows(i, o)
  this.addMarkings(m)
}