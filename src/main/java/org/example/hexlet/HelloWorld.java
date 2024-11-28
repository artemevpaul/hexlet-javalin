package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name == null) {
                ctx.result("Hello World");
            } else {
                ctx.result("Hello " + name);
            }
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            var id = ctx.pathParam("id");
            var postId =  ctx.pathParam("postId");
            ctx.result("User ID: " + id + " Post ID: " + postId);
        });
        app.start(7070); // Стартуем веб-сервер
    }
}