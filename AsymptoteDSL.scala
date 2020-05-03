import java.io._

import atoms._
import complex._
import traits._

import scala.language.postfixOps
import sys.process._

object AsymptoteDSL extends App {
  val filename: String = "out.asy"
  val writer = new PrintWriter(new File(filename))

  val asyObj =
    new AsymptoteImage withProp List[AsymptoteObject](
      // put here properties
    ) having List[AsymptoteObject](
      // put here Asymptote objects
    ) logoOn (0, 0)

  writer.write(asyObj toAsyString)
  writer.close()

  s"cmd /C $filename" !
}