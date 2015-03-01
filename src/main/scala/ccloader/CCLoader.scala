package ccloader

import java.io.{File, FileInputStream}
import akka.actor.ActorSystem

case class Resource(url: String, date: String, content: Array[Byte])

object Main {
  def main(args: Array[String]): Unit = {
    val warcFile = args(0)
    implicit val system = ActorSystem("loader-system")

    val fis = new FileInputStream(new File(warcFile))
    val ccp = new CCParser(fis)
    new Thread(ccp).run()
  }
}
