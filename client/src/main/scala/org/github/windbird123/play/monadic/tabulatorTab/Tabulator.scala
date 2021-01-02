package org.github.windbird123.play.monadic.tabulatorTab

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
class Tabulator(id: String, options: js.Dictionary[Any]) extends js.Any {
    /** You can add a row to the table using the addRow function.
    The first argument should be a row data object. If you do not pass data for a column, it will be left empty. To create a blank row (ie for a user to fill in), pass an empty object to the function.
    The second argument is optional and determines whether the row is added to the top or bottom of the table. A value of true will add the row to the top of the table, a value of false will add the row to the bottom of the table. If the parameter is not set the row will be placed according to the addRowPos global option. */
    def addRow(): js.Promise[RowComponent] = js.native
    def addRow(data: js.UndefOr[scala.Nothing], addToTop: Boolean): js.Promise[RowComponent] = js.native
    def addRow(data: js.Object): js.Promise[RowComponent] = js.native
    def addRow(data: js.Object, addToTop: Boolean): js.Promise[RowComponent] = js.native

    def deleteRow(index: js.Array[js.Object]): Unit = js.native
    def deleteRow(index: js.Object): Unit = js.native
}
