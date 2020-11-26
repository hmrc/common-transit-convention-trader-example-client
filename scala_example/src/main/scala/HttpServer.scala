import cats.effect.{ConcurrentEffect, ContextShift, ExitCode, IO, Timer}
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT
import service.ApplicationService

object HttpServer {
  def create()(implicit
      contextShift: ContextShift[IO],
      concurrentEffect: ConcurrentEffect[IO],
      timer: Timer[IO]
  ): IO[ExitCode] = {
    for {
      exitCode <-
        BlazeServerBuilder[IO]
          .bindHttp(8080, "0.0.0.0")
          .withHttpApp(new ApplicationService().routes.orNotFound)
          .serve
          .compile
          .lastOrError
    } yield exitCode
  }
}
