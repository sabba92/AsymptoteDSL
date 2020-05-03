package complex

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class PetriAutoTest extends AnyFunSuite {

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

  test("PetriAuto.addPlace") {
    val nPlaces: Int = petriA.places.size
    val nTrans: Int = petriA.transitions.size
    petriA addPlace ("P3")
    assert((petriA.places size) === nPlaces + 1)
    assert((petriA.transitions size) === nTrans)
  }

  test("PetriAuto.addTransition") {
    val nPlaces: Int = petriA.places.size
    val nTrans: Int = petriA.transitions.size
    petriA addTransition ("T2")
    assert((petriA.places size) === nPlaces)
    assert((petriA.transitions size) === nTrans + 1)
  }
}