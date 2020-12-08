package org.github.windbird123.play.monadic.canvasTab

import org.scalajs.dom
import org.scalajs.dom.{Element, html}

import scala.scalajs.js

object DrawClock {
    def display(canvasE: Element): Unit = {
        val canvas = canvasE.asInstanceOf[html.Canvas]

//        canvas.width = canvas.parentElement.clientWidth
//        canvas.height = canvas.parentElement.clientHeight
        canvas.width = 300
        canvas.height = 200

        val renderer = canvas
            .getContext("2d")
            .asInstanceOf[dom.CanvasRenderingContext2D]

        val gradient = renderer.createLinearGradient(canvas.width / 2 - 100, 0, canvas.width / 2 + 100, 0)
        gradient.addColorStop(0, "red")
        gradient.addColorStop(0.5, "green")
        gradient.addColorStop(1, "blue")
        renderer.fillStyle = gradient

        renderer.textAlign = "center"
        renderer.textBaseline = "middle"

        def render =  {
            val date = new js.Date()
            renderer.clearRect(
                0,
                0,
                canvas.width,
                canvas.height
            )

            renderer.font = "75px sans-serif"
            renderer.fillText(
                Seq(
                    date.getHours(),
                    date.getMinutes(),
                    date.getSeconds()
                ).mkString(":"),
                canvas.width / 2,
                canvas.height / 2
            )
        }

        dom.window.setInterval(() => render, 1000)
    }
}
