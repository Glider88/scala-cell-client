import org.scalajs.dom
import org.scalajs.dom.html.Canvas
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import upickle.default.read

object Pedesis {
  @JSExport
  def main(args: Array[String]): Unit = println("MAIN()")

  @JSExportTopLevel("Pedesis")
  def run(): Unit = {
    dom.console.log("RUN()")

    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    canvas.height = 600
    canvas.width = 800
    dom.document.body.appendChild(canvas)
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    val echo = "ws://localhost:12346/ws"
    val socket = new dom.WebSocket(echo)
    socket.onmessage = {
      (e: dom.MessageEvent) => {
        val point = read[Point](e.data.toString)
        ctx.clearRect(0, 0, 800, 600)
        ctx.fillRect(point.x, point.y, 10, 10)
      }
    }

    socket.onopen = { (e: dom.Event) =>
      println("socket opened")
    }
  }
}
