package org.github.windbird123.play.monadic.chartTab.facade

import org.scalajs.dom.html.Div
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}
import scala.scalajs.js.{Promise, |}

@js.native
trait GraphDiv extends Div {
  def on(`type`: String, fn: js.Function0[Unit] | js.Function1[js.Dynamic, Unit]): Unit = js.native
  val data: js.Array[js.Dictionary[Any]]                                                = js.native
  val layout: js.Dictionary[Any]                                                        = js.native
}

@js.native
@JSGlobal("Plotly")
object Plotly extends js.Object {
  def newPlot(
    gd: String | HTMLElement,
    data: js.UndefOr[js.Array[js.Dictionary[Any]]] = js.undefined,
    layout: js.UndefOr[js.Dictionary[Any]] = js.undefined,
    options: js.UndefOr[js.Dictionary[Any]] = js.undefined
  ): Promise[GraphDiv] = js.native
  def react(
    gd: String | HTMLElement,
    data: js.UndefOr[js.Array[js.Dictionary[Any]]] = js.undefined,
    layout: js.UndefOr[js.Dictionary[Any]] = js.undefined,
    options: js.UndefOr[js.Dictionary[Any]] = js.undefined
  ): Promise[GraphDiv] = js.native
  def plot(
    gd: String | HTMLElement,
    data: js.UndefOr[js.Array[js.Dictionary[Any]]] = js.undefined,
    layout: js.UndefOr[js.Dictionary[Any]] = js.undefined,
    options: js.UndefOr[js.Dictionary[Any]] = js.undefined
  ): Promise[GraphDiv] = js.native
  def restyle(
    gd: String | HTMLElement,
    astr: js.Dictionary[Any],
    traces: js.UndefOr[Int | js.Array[Int]] = js.undefined
  ): Promise[GraphDiv]                                                                     = js.native
  def relayout(graphDiv: String | GraphDiv, update: js.Dictionary[Any]): Promise[GraphDiv] = js.native
  def redraw(gd: String | GraphDiv): Promise[GraphDiv]                                     = js.native
  def update(
    gd: String | GraphDiv,
    traceUpdate: js.UndefOr[js.Dictionary[Any]] = js.undefined,
    layoutUpdate: js.UndefOr[js.Dictionary[Any]] = js.undefined,
    traces: js.UndefOr[Int | js.Array[Int]] = js.undefined
  ): Promise[GraphDiv] = js.native
  def addTraces(
    gd: String | GraphDiv,
    traces: js.UndefOr[Int | js.Array[Int]] = js.undefined,
    newIndices: js.UndefOr[Int | js.Array[Int]] = js.undefined
  ): Promise[GraphDiv]                                                                     = js.native
  def deleteTraces(gd: String | GraphDiv, indices: Int | js.Array[Int]): Promise[GraphDiv] = js.native
  def moveTraces(
    gd: String | GraphDiv,
    currentIndices: Int | js.Array[Int],
    newIndices: js.UndefOr[Int | js.Array[Int]] = js.undefined
  ): Promise[GraphDiv] = js.native
  def extendTraces(
    gd: String | GraphDiv,
    update: Int | js.Array[Int],
    indices: Int | js.Array[Int] /*, maxPoints*/
  ): Promise[GraphDiv] = js.native
  def prependTraces(
    gd: String | GraphDiv,
    update: Int | js.Array[Int],
    indices: Int | js.Array[Int] /*, maxPoints*/
  ): Promise[GraphDiv]                                                            = js.native
  def purge(gd: String | GraphDiv): GraphDiv                                      = js.native
  def toImage(gd: String | GraphDiv, opts: js.Dictionary[Any]): Promise[String]   = js.native
  def downloadImage(gd: String | GraphDiv, opts: js.Dictionary[Any]): Promise[_]  = js.native
  def animate(gd: String | GraphDiv, update: js.Object, options: js.Object): Unit = js.native

  @js.native
  @JSName("Plots")
  object Plots extends js.Object {
    def resize(gd: String | GraphDiv): Promise[GraphDiv] = js.native
  }
}
