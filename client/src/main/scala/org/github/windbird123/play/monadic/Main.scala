package org.github.windbird123.play.monadic

import org.github.windbird123.play.monadic.canvasTab.{DrawClock, DrawPyramid}
import org.github.windbird123.play.monadic.chartTab.DrawChart
import org.scalajs.dom.document

object Main {
  def main(args: Array[String]): Unit = {
    // canvas
    DrawClock.display(document.getElementById("canvas_clock"))
    DrawPyramid.display(document.getElementById("canvas_pyramid"))

    // Chart
    DrawChart.plotLineChart()
    DrawChart.plotBarChart()
  }
}
