package utils

import java.io._
import sys.process._
import atoms.Point
import complex.AsymptoteImage
import traits.AsymptoteObject

import scala.language.postfixOps

class DSLTest(properties: List[AsymptoteObject],
              objects: List[AsymptoteObject],
              logoPoint: Point,
              filename: String) {

  val path: String = "src\\test\\scala\\examples\\"
  val filePath: String = path concat "files\\"
  val imgPath: String = path concat "images\\"
  val asyObj: AsymptoteImage =
    new AsymptoteImage withProp properties having objects logoOn logoPoint

  def toAsyFile: Unit = {
    val writer: PrintWriter = new PrintWriter(new File(filePath concat filename concat ".asy"))
    writer.write(asyObj toAsyString)
    writer.close()
    this.toImage
  }

  def toImage: Unit = {
    val outPath: String = imgPath concat filename
    val inPath: String = filePath concat filename concat ".asy"
    val rmExp: String = imgPath concat "*tex*"
    s"cmd /C asy -noV -o $outPath -f pdf $inPath" !;
    s"cmd /C del $rmExp" !
  }
}