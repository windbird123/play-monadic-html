package org.github.windbird123.play.monadic.chartTab

import org.github.windbird123.play.monadic.chartTab.facade.Plotly
import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLDivElement

import scala.collection.mutable
import scala.scalajs.js

/////////////////////////////////////////////////////////////////////////////////////////
// 여기 예시처럼 facade 를 이용해 Plotly 라이브러리를 사용할 수 있지만,
// Plotly.newPlot javascript 를 그대로 사용할 수도 있다. (심지어 scala json string 을 그대로 넘기면서)
// Ractive Html 참고 !!!
/////////////////////////////////////////////////////////////////////////////////////////
object DrawChart {
  // https://plotly.com/javascript/getting-started/
  def plotLineChart() = {
    val lineDiv = document.getElementById("chart_line").asInstanceOf[HTMLDivElement]

    import js.JSConverters._
    val xy: js.Array[js.Dictionary[Any]] =
      mutable
        .Seq(
          mutable
            .Map[String, Any]("x" -> mutable.Seq(0, 1, 2, 3).toJSArray, "y" -> mutable.Seq(0, 1, 4, 9).toJSArray)
            .toJSDictionary
        )
        .toJSArray

    val layout: js.Dictionary[Any] = js.Dictionary("margin" -> js.Dictionary("t" -> 30))

    Plotly.newPlot(lineDiv, xy, layout)

    // 위의 Plotly 처럼 facade 를 만들어 할 수 있지만, 아래처럼 javascript method 를 직접 호출하는 것도 가능하다.
//    js.Dynamic.global.Plotly.newPlot(lineDiv, xy, layout)
  }

  // https://plotly.com/javascript/bar-charts/#basic-bar-chart
  def plotBarChart() = {
    val barDiv = document.getElementById("chart_bar").asInstanceOf[HTMLDivElement]
    val data: js.Array[js.Dictionary[Any]] =
      js.Array(
        js.Dictionary(
          "x"    -> js.Array("giraffes", "orangutans", "monkeys"),
          "y"    -> js.Array(20, 14, 23),
          "type" -> "bar"
        )
      )

    Plotly.newPlot(barDiv, data)
  }
}
