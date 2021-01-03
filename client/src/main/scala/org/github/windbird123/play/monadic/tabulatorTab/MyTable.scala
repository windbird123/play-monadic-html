package org.github.windbird123.play.monadic.tabulatorTab

import mhtml._
import org.scalajs.dom.{ document, window }
import org.scalajs.dom.raw.{ Event, HTMLElement }

import scala.scalajs.js
import scala.scalajs.js.annotation.{ JSExport, JSExportTopLevel }

@JSExportTopLevel("MyTable")
object MyTable {

  @JSExport
  def init(id: String, query: String): Unit = {
    var tabulator: Tabulator = null

    // 아래처럼 js.Array 로 js.Object 를 생성해도 되지만,
    // json string 을 그대로 넘겨도 된다 !!!!

//    val rowToAdd =  js.Array(js.Dictionary[Any]("id" -> "3", "name" -> "windbird", "age" -> "22"))
    val rowToAdd =
      s"""{
         |  "id": "3",
         |  "name": "windbird",
         |  "age": "22"
         |}
         |""".stripMargin.asInstanceOf[js.Object]

    val content =
      <div>
        <button id="add-row" onclick={() => tabulator.addRow(rowToAdd, true); ()}>Add windbird Row to top</button>
        <button id="del-row" onclick={() => tabulator.deleteRow("2".asInstanceOf[js.Object])}>Delete Row "Oli Bob"</button>
        <div id="example-table"></div>
      </div>

    mount(document.getElementById(id), content)

    val rowClickFunction: js.Function2[Event, RowComponent, Unit] = (e: Event, row: RowComponent) => {
      val name = row.getCell("name").getValue()
      println(name)
      row.getCells().foreach(cell => println(cell.getField() + ": " + cell.getValue()))
//      window.alert(row.getData().asInstanceOf[HTMLElement].id + " was clicked")
    }

    val cellEditedFunction: js.Function1[CellComponent, Unit] = (cell: CellComponent) => {
        println("TEST 333")
      val field = cell.getField()
      val oldValue = cell.getOldValue()
      val newValue = cell.getValue()
      println(s"field=[$field] was edited, old=[$oldValue], new=[$newValue]")
    }

    val tableData = js.Array(js.Dictionary[Any]("id" -> "2", "name" -> "Oli Bob", "age" -> "12"))

    val settings: js.Dictionary[Any] = js.Dictionary[Any](
      "height" -> 205,
      "data"   -> tableData,
      "layout" -> "fitColumns",
      "columns" -> js.Array(
        js.Dictionary[Any]("title" -> "Name", "field" -> "name", "width"   -> 150, "editor" -> "input"),
        js.Dictionary[Any]("title" -> "Age", "field"  -> "age", "hozAlign" -> "left", "formatter" -> "progress")
      ),
      "rowClick" -> rowClickFunction,
      "cellEdited" -> cellEditedFunction
    )
    tabulator = new Tabulator("#example-table", settings)
  }
}
