package org.grez.sudoku

import scala.util.Random

/**
 * Created by grez on 9/18/15.
 */
object SudokuPrinter {

  val spacer = "=" * 41
  val hr = "-" * 41


  def main(args: Array[String]) {
    val printedList = hideCells(testField, 100)

    printField(printedList)
  }

  def hideCells(field: List[List[Int]], hiddenCount: Int): List[List[Option[Int]]] = {
    val numbers = (for (i <- 1 to hiddenCount) yield Random.nextInt(81)).toList.distinct

    val result = for {i <- field.indices }
      yield {
        for {j <- field(i).indices} yield if (numbers.contains(i+(j*9))) None else Some(field(i)(j))
      }.toList

    result.toList

  }

  def printField(field: List[List[Option[Int]]]): Unit = {

    for (i <- field.indices) {
      if(i % 3 == 0) println(spacer) else println(hr)
      for (j <- field(i).indices){
        if(j % 3 == 0) print("|")
        print("|")
        print(s" ${field(i)(j).getOrElse(" ")} ")
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
