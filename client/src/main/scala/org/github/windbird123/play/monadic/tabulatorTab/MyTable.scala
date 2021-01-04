package org.github.windbird123.play.monadic.tabulatorTab

import mhtml._
import org.scalajs.dom.{ document, window }
import org.scalajs.dom.raw.{ Event, HTMLElement, HTMLInputElement }

import scala.scalajs.js
import scala.scalajs.js.annotation.{ JSExport, JSExportTopLevel }

@JSExportTopLevel("MyTable")
object MyTable {

  @JSExport
  def init(id: String, query: String): Unit = {
    var table: Tabulator = null

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

    def filterFunction(e: Event): Unit = {
      val keyword = e.target.asInstanceOf[HTMLInputElement].value
      if (keyword != null && keyword.nonEmpty) {
        table.setFilter("name", "keywords".asInstanceOf[js.Object], keyword)
      } else {
        table.clearFilter()
      }
    }

    val content =
      <div>
        <input type="text" onkeyup={(e: Event) => filterFunction(e)} onchange={(e: Event) => filterFunction(e)}></input>
        <button id="add-row" onclick={() => table.addRow(rowToAdd, true); ()}>Add windbird Row to top</button>
        <button id="del-row" onclick={() => table.deleteRow("2".asInstanceOf[js.Object])}>Delete Row "Oli Bob"</button>
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
      val row = cell.getRow()
      row.getCells().foreach(cell => println(cell.getField() + "=" + cell.getValue()))

      println("TEST 333")
      val field    = cell.getField()
      val oldValue = cell.getOldValue()
      val newValue = cell.getValue()
      println(s"field=[$field] was edited, old=[$oldValue], new=[$newValue]")
    }


    val urlGenerationFuntion: js.Function1[CellComponent, String] = (cell: CellComponent) => {
      val row = cell.getRow()
      val name = row.getCell("name").getValue()
      println(s"NAME for url: $name")
      s"http://www.naver.com"
    }

    val tableData = js.Array(js.Dictionary[Any]("id" -> "2", "name" -> "Oli Bob", "age" -> "12", "link" -> "go"))

    val settings: js.Dictionary[Any] = js.Dictionary[Any](
//      "height"                 -> 205,
      "pagination"             -> "local",
      "paginationSize"         -> 6,
      "paginationSizeSelector" -> js.Array(3, 6, 8, 10),
      "data"                   -> tableData,
      "layout"                 -> "fitColumns",
      "columns" -> js.Array(
        js.Dictionary[Any](
          "title"     -> "Name",
          "field"     -> "name",
          "width"     -> 150,
          "editor"    -> "input",
          "validator" -> "required"
        ),
        js.Dictionary[Any]("title" -> "Age", "field"  -> "age", "hozAlign"  -> "left", "formatter" -> "progress"),
        js.Dictionary[Any]("title" -> "Link", "field" -> "link", "hozAlign" -> "left", "formatter" -> "link",
          "formatterParams" -> js.Dictionary[Any](
            "label"-> "goto",   // label 대신에 labelField 를 사용해 row 마다 링크 이름을 변경 가능
            "url" -> urlGenerationFuntion,
            "target"-> "_blank"
          )
        )
      ),
      "rowClick"   -> rowClickFunction,
      "cellEdited" -> cellEditedFunction
    )

    table = new Tabulator("#example-table", settings)
  }
}
