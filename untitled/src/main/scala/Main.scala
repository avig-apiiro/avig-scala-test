

import sttp.client4.*
import sttp.client4.upicklejson.default.*
import upickle.default.*

object Main
{

    def getFacebookData(endpoint: String, accessToken: String): Unit = {
      val url = s"https://graph.facebook.com/v18.0/$endpoint"
      val backend = DefaultSyncBackend()

      case class MyRequest(field1: String, field2: Int)
      case class HttpBinResponse(origin: String, headers: Map[String, String])
      given ReadWriter[MyRequest] = macroRW[MyRequest]
      given ReadWriter[HttpBinResponse] = macroRW[HttpBinResponse]

      val request = basicRequest
        .post(uri"https://graph.facebook.com/v18.0/$endpoint")
        .body(asJson(MyRequest("test", 42)))
        .response(asJson[HttpBinResponse])

      val response = request.send(backend)
      response.body match {
        case Left(e)  => println(s"Got response exception:\n")
        case Right(r) => println(s"success?")
      }
    }

    def main(args: Array[String]): Unit = {
      val accessToken = "your_access_token"
      val result = getFacebookData("me?fields=id,name", accessToken)
      print(result)
    }
} 