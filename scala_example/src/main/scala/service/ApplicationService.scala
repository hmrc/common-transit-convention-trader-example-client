package service

import cats.effect.IO
import cats.effect.IO.ioEffect
import io.circe.generic.codec.DerivedAsObjectCodec.deriveCodec
import org.http4s.HttpRoutes
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder
import org.http4s.dsl.Http4sDsl

class ApplicationService extends Http4sDsl[IO] {
  val routes = HttpRoutes.of[IO] {
    case GET -> Root / "health" =>
      Ok("""{"hello": "world"}""")
  }
}
