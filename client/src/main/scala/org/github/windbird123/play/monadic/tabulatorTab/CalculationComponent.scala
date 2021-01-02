package org.github.windbird123.play.monadic.tabulatorTab

import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js

@js.native
trait CalculationComponent extends js.Object {
  def getCell(column: String): CellComponent      = js.native
  def getCell(column: HTMLElement): CellComponent = js.native

  /** The getCells function returns an array of CellComponent objects, one for each cell in the row.*/
  def getCells(): js.Array[CellComponent] = js.native

  /** The getData function returns the data object for the row.*/
  def getData(): js.Any = js.native

  /** The getElement function returns the DOM node for the row.*/
  def getElement(): HTMLElement = js.native
}
