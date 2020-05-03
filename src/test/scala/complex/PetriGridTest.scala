package complex

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class PetriGridTest extends AnyFunSuite {

  /*********************************************
    * P0 ---(5)--- T1 ---(2)--- P1
    *               |
    *               |
    *               |
    *              P2
    ********************************************/

  val petriG = new PetriGrid(Map("P0" -> (0, 4), "P1" -> (4, 4), "P2" -> (2, 0)),
    Map("T1" -> (2, 4)),
    Map("T1" -> List("P0")),
    Map("T1" -> List("P1", "P2")),
    List(("P0", 1)),
    List(("P0", "T1", 5)),
    List(("P1", "T1", 2)))

  test("PetriGrid.addPlace") {
    val nPlaces: Int = petriG.places.size
    val nTrans: Int = petriG.transitions.size
    petriG addPlace ("P3", (5, 5))
    assert((petriG.places size) === nPlaces + 1)
    assert((petriG.transitions size) === nTrans)
  }

  test("PetriGrid.addTransition") {
    val nPlaces: Int = petriG.places.size
    val nTrans: Int = petriG.transitions.size
    petriG addTransition ("T2", (3, 3))
    assert((petriG.places size) === nPlaces)
    assert((petriG.transitions size) === nTrans + 1)
  }
}