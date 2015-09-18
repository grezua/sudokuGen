package org.grez.sudoku

/**
 * Created by grez on 9/18/15.
 */
object SudokuPrinter {

  val spacer = "=" * 41
  val hr = "-" * 41


  def main(args: Array[String]) {
    printField(testField)
  }

  def printField(field: List[List[Int]]): Unit = {

    for (i <- field.indices) {
      if(i % 3 == 0) println(spacer) else println(hr)
      for (j <- field(i).indices){
        if(j % 3 == 0) print("|")
        print("|")
        print(s" ${field(i)(j)} ")
      }
      print("||")
      println()
    }
    println(spacer)
  }

  lazy val testField: List[List[Int]] = {
    val row = (1 to 9).toList
    row.map(_ => row)
  }

}
