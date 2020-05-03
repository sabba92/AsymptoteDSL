package examples

import atoms.{Point, Prop}
import complex._
import org.scalatest.funsuite.AnyFunSuite
import traits.AsymptoteObject
import utils._

import scala.language.postfixOps

class PetriExamples extends AnyFunSuite {
  val props: List[AsymptoteObject] = List(
    new Prop("size(20cm, 20cm);")
  )

  val petri1 = new PetriAuto(List("off", "idle", "soak", "rinse", "drain", "dry"),
    List("T0", "T1", "T2", "T3", "T4", "T5", "delicate", "fast", "gentle"),
    Map("T0" -> List("off"), "T1" -> List("idle"), "T2" -> List("soak"),
      "T3" -> List("rinse"), "T4" -> List("drain"), "T5" -> List("dry"),
      "delicate" -> List("idle"), "fast" -> List("soak"),
      "gentle" -> List("drain")),
    Map("T0" -> List("idle"), "T1" -> List("soak"), "T2" -> List("rinse"),
      "T3" -> List("drain"), "T4" -> List("dry"), "T5" -> List("idle"),
      "delicate" -> List("rinse"), "fast" -> List("drain"),
      "gentle" -> List("idle")),
    List(),
    List(),
    List())

  val petri2 = new PetriGrid(Map("off" -> (2, 8), "idle" -> (2, 6), "soak" -> (2, 4),
    "rinse" -> (2, 2), "drain" -> (2, 0), "dry" -> (6, 0)),
    Map("T0_" -> (2, 7), "T1_" -> (2, 5), "T2_" -> (2, 3), "T3_" -> (2, 1),
      "T4" -> (5, 0), "T5_" -> (6, 4), "delicate_" -> (0, 4),
      "fast_" -> (4, 2), "gentle_" -> (5, 2)),
    Map("T0_" -> List("off"), "T1_" -> List("idle"), "T2_" -> List("soak"),
      "T3_" -> List("rinse"), "T4" -> List("drain"), "T5_" -> List("dry"),
      "delicate_" -> List("idle"), "fast_" -> List("soak"),
      "gentle_" -> List("drain")),
    Map("T0_" -> List("idle"), "T1_" -> List("soak"), "T2_" -> List("rinse"),
      "T3_" -> List("drain"), "T4" -> List("dry"), "T5_" -> List("idle"),
      "delicate_" -> List("rinse"), "fast_" -> List("drain"),
      "gentle_" -> List("idle")),
    List(),
    List(),
    List())

  val petri3 = new PetriAuto(
    List("P0", "P1", "P2", "P3", "P4", "P5"),
    List("T1", "T2", "T3", "T4", "T5"),
    Map("T1" -> List("P0"), "T2" -> List("P1"), "T3" -> List("P1", "P2"),
      "T4" -> List("P2"), "T5" -> List("P0", "P4", "P5")),
    Map("T1" -> List("P1", "P2"), "T2" -> List("P3"), "T3" -> List("P3"),
      "T4" -> List("P3"), "T5" -> List("P1")),
    List(("P0", 1), ("P1", 3)),
    List(("P1", "T2", 5)),
    List(("P2", "T1", 2))
  )

  val petri4 = new PetriGrid(
    Map("P0" -> (0, 4), "P1" -> (4, 1), "P2" -> (4, 3), "P3" -> (8, 2),
      "P4" -> (0, 2), "P5" -> (0, 0)),
    Map("T1" -> (2, 3), "T2" -> (6, 0), "T3" -> (6, 2), "T4" -> (6, 4),
      "T5" -> (2, 1)),
    Map("T1" -> List("P0"), "T2" -> List("P1"), "T3" -> List("P1", "P2"),
      "T4" -> List("P2"), "T5" -> List("P0", "P4", "P5")),
    Map("T1" -> List("P1", "P2"), "T2" -> List("P3"), "T3" -> List("P3"),
      "T4" -> List("P3"), "T5" -> List("P1")),
    List(("P0", 1), ("P1", 3)),
    List(("P1", "T2", 5)),
    List(("P2", "T1", 2))
  )

  val petri5 = new PetriGrid(
    Map("P0" -> (0, 8), "P1" -> (3, 4), "P2" -> (1, 4), "P3" -> (2, 0), "P4" -> (2, 8), "P5" -> (4, 8)),
    Map("T1_" -> (1, 6), "T2_" -> (4, 2), "T3_" -> (2, 2), "T4_" -> (0, 2), "T5_" -> (3, 6)),
    Map("T1_" -> List("P0"), "T2_" -> List("P1"), "T3_" -> List("P1", "P2"), "T4_" -> List("P2"), "T5_" -> List("P0", "P4", "P5")),
    Map("T1_" -> List("P1", "P2"), "T2_" -> List("P3"), "T3_" -> List("P3"), "T4_" -> List("P3"), "T5_" -> List("P1")),
    List(("P0", 1), ("P1", 3)),
    List(("P1", "T2_", 5)),
    List(("P2", "T1_", 2))
  )

  val images: List[DSLTest] = List(
    new DSLTest(props, List(petri1), Point(30, -7.5), "petri1"),
    new DSLTest(props, List(petri2), Point(12, -2), "petri2"),
    new DSLTest(props, List(petri3), Point(16, -7), "petri3"),
    new DSLTest(props, List(petri4), Point(20, -1), "petri4"),
    new DSLTest(props, List(petri5), Point(7, -1), "petri5")
  )

  images foreach { i => i toAsyFile }
}
