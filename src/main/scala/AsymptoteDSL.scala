import java.io._

import atoms._
import complex.{AsymptoteImage, PetriAuto, PetriGrid}
import traits.AsymptoteObject

import scala.language.postfixOps
import sys.process._

object AsymptoteDSL extends App {
  val filename: String = "out.asy"
  val writer = new PrintWriter(new File(filename))

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

  val asyObj =
    new AsymptoteImage withProp List[AsymptoteObject](
      new Prop("size(15cm);"),
      new Prop("settings.outformat = \"pdf\";"),
      //new Prop("size(21cm, 27cm);"), per petri
      //new Prop("size(60cm, 30cm);"),
    ) having List[AsymptoteObject](
      petriG
    ) logoOn (0.5, -1)

  writer.write(asyObj toAsyString)
  writer.close()

  s"cmd /C $filename" !
}