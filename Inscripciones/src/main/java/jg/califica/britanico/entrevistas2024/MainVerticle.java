package jg.califica.britanico.entrevistas2024;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.common.template.TemplateEngine;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import io.vertx.pgclient.PgBuilder;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.SqlClient;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        TemplateEngine engine = ThymeleafTemplateEngine.create(vertx);
        TemplateHandler handler = TemplateHandler.create(engine);

        PgConnectOptions connectOptions = new PgConnectOptions()
                .setPort(5432)
                .setHost("localhost")
                .setDatabase("califica_britanico")
                .setUser("califica")
                .setPassword("Tarija00");

        // Pool options
        PoolOptions poolOptions = new PoolOptions()
                .setMaxSize(5);

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/static/*").handler(StaticHandler.create());

        router.route("/gestiones/json")
                .produces("application/json")
                .handler(ctx -> {
                    HttpServerResponse response = ctx.response();
                    response.putHeader("content-type", "application/json");

                    // Create the client pool
                    SqlClient client = PgBuilder
                            .client()
                            .with(poolOptions)
                            .connectingTo(connectOptions)
                            .using(vertx)
                            .build();

                    // A simple query
                    client
                            .query("SELECT * FROM colegio.gestion")
                            .execute()
                            .onComplete(ar -> {
                                if (ar.succeeded()) {

                                    RowSet<Row> result = ar.result();

                                    JsonArray data = new JsonArray();
                                    for (Row item : result) {
                                        data.add(item.toJson());
                                    }

                                    JsonObject json = new JsonObject()
                                            .put("gestiones", data).
                                            put("welcome", "Hola mundo....");
                                    response.end(json.encode());
                                } else {
                                    ar.cause().printStackTrace();
                                }
                                // Now close the pool
                                client.close();
                            });
                });

        router.route("/gestiones/list").handler(ctx -> {
            HttpServerResponse response = ctx.response();
            response.setChunked(true);

            // Create the client pool
            SqlClient client = PgBuilder
                    .client()
                    .with(poolOptions)
                    .connectingTo(connectOptions)
                    .using(vertx)
                    .build();

            // A simple query
            client
                    .query("SELECT * FROM colegio.gestion")
                    .execute()
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            response.setChunked(true);

                            RowSet<Row> result = ar.result();

                            JsonArray data = new JsonArray();
                            for (Row item : result) {
                                data.add(item.toJson());
                            }

                            JsonObject json = new JsonObject()
                                    .put("gestiones", data).
                                    put("welcome", "Hola mundo....");

                            // and now delegate to the engine to render it.
                            engine.render(json, "templates/index.html", res -> {
                                if (res.succeeded()) {
                                    ctx.response().end(res.result());
                                } else {
                                    ctx.fail(res.cause());
                                }
                            });
                        } else {
                            ar.cause().printStackTrace();
                        }
                        // Now close the pool
                        client.close();
                    });
        });

        Route route = router.route("/inscripcion/alumnos");

        route.handler(ctx -> {
            HttpServerResponse response = ctx.response();
            // enable chunked responses because we will be adding data as
            // we execute over other handlers. This is only required once and
            // only if several handlers do output.
            response.setChunked(true);

            response.write("route1\n");

            // Call the next matching route after a 5 second delay
            ctx.next();
        });

        route.handler(ctx -> {
            HttpServerResponse response = ctx.response();
            response.write("route2\n");

            // Call the next matching route after a 5 second delay
            ctx.next();
        });

        route.handler(ctx -> {
            HttpServerResponse response = ctx.response();
            response.write("route3");

            // Now end the response
            ctx.response().end();
        });

        server.requestHandler(router).listen(8080);
    }
}
