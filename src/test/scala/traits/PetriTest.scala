package traits
import complex._
import atoms._
import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class PetriTest extends AnyFunSuite {

  /*********************************************
    * P0 ---(5)--- T1 ---(2)--- P1
    *               |
    *               |
    *               |
    *              P2
    ********************************************/
  val petriA = new PetriAuto(List("P0", "P1", "P2"),
    List("T1"),
    Map("T1" -> List("P0")),
    Map("T1" -> List("P1", "P2")),
    List(("P0", 1)),
    List(("P0", "T1", 5)),
    List(("P1", "T1", 2)))

  val petriG = new PetriGrid(Map("P0" -> (0, 4), "P1" -> (4, 4), "P2" -> (2, 0)),
    Map("T1" -> (2, 4)),
    Map("T1" -> List("P0")),
    Map("T1" -> List("P1", "P2")),
    List(("P0", 1)),
    List(("P0", "T1", 5)),
    List(("P1", "T1", 2)))

  test("Petri.arrows_markings_labels_number") {
    // 3 arrows and 3 weights + 1 marking + 3 place names + 1 transition name
    val nItems: Int = 3 * 2 + 1 + 3 + 1
    assert((petriA.otherObj size) === nItems)
    assert((petriG.otherObj size) === nItems)
  }

  test("Petri.places_number") {
    assert((petriA.places size) === 3)
    assert((petriG.places size) === 3)
  }

  test("Petri.transitions_number") {
    assert((petriA.transitions size) === 1)
    assert((petriG.transitions size) === 1)
  }

  test("Petri.equality") {
    assert((petriA.otherObj size) === (petriG.otherObj size))
    assert((petriA.places size) === (petriG.places size))
    assert((petriA.transitions size) === (petriG.transitions size))
  }

  test("Petri.addMarkings") {
    val n: Int = petriA.otherObj.size
    petriA addMarkings List(("P1", 5))
    assert((petriA.otherObj size) === n + 5)
  }

  test("Petri.addArrows") {
    val n: Int = petriG.otherObj.size
    petriG addArrows (
      Map("T1" -> List("P1", "P2")),
      Map("T1" -> List("P0"))
    )
    assert((petriG.otherObj size) === n + 3 * 2)
  }
}