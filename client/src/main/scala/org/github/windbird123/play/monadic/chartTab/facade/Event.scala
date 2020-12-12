package org.github.windbird123.play.monadic.chartTab.facade

import org.scalajs.dom.raw

import scala.scalajs.js

@js.native
trait PlotlyPoint extends js.Object {
  val curveNumber: Int    = js.native
  val pointNumber: Int    = js.native
  val x: js.Any           = js.native
  val y: js.Any           = js.native
  val z: js.Any           = js.native
  val lat: Double         = js.native
  val lon: Double         = js.native
  val data: js.Object     = js.native
  val fullData: js.Object = js.native
  val xaxis: js.Object    = js.native
  val yaxis: js.Object    = js.native
  val zaxis: js.Object    = js.native
}

@js.native
trait Event extends raw.Event {
  val points: js.Array[PlotlyPoint] = js.native
}

@js.native
trait ClickEvent extends Event {}

object ClickEvent {
  def apply(src: GraphDiv, fn: js.Function1[js.Dynamic, Unit]): Unit = src.on("plotly_click", fn)
}

@js.native
trait HoverEvent extends Event {}

object HoverEvent {
  def apply(src: GraphDiv, fn: js.Function1[js.Dynamic, Unit]): Unit = src.on("plotly_hover", fn)
}

@js.native
trait UnhoverEvent extends Event {}

object UnhoverEvent {
  def apply(src: GraphDiv, fn: js.Function1[js.Dynamic, Unit]): Unit = src.on("plotly_unhover", fn)
}

@js.native
trait SelectedEvent extends Event {}

object SelectedEvent {
  def apply(src: GraphDiv, fn: js.Function1[js.Dynamic, Unit]): Unit = src.on("plotly_selected", fn)
}
