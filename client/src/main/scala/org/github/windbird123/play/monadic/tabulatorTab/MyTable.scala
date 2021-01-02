package org.github.windbird123.play.monadic.tabulatorTab

import mhtml._
import org.scalajs.dom.document
import org.scalajs.dom.raw.{Event, HTMLElement}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("MyTable")
object MyTable {

  @JSExport
  def init(id: String, query: String): Unit = {
    var tabulator : Tabulator = null

    val rowToAdd =  js.Array(js.Dictionary[Any]("id" -> "3", "name" -> "windbird", "age" -> "22"))
    val content =
      <div>
        <button id="add-row" onclick={() => tabulator.addRow(rowToAdd, true); ()}>Add Blank Row to bottom</button>
        <div id="example-table"></div>
      </div>

    mount(document.getElementById(id), content)

    val f: js.Function2[Event, RowComponent, Unit] = (e: Event, row: RowComponent) =>
      println(row.getData().asInstanceOf[HTMLElement].id)

    val tableData = js.Array(js.Dictionary[Any]("id" -> "2", "name" -> "Oli Bob", "age" -> "12"))

    val settings: js.Dictionary[Any] = js.Dictionary[Any](
      "height" -> 205,
      "data"   -> tableData,
      "layout" -> "fitColumns",
      "columns" -> js.Array(
        js.Dictionary[Any]("title" -> "Name", "field" -> "name", "width"   -> 150),
        js.Dictionary[Any]("title" -> "Age", "field"  -> "age", "hozAlign" -> "left", "formatter" -> "progress")
      ),
      "rowClick" -> f
    )
    tabulator = new Tabulator("#example-table", settings)
  }
}
