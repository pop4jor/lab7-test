
       post("/api/login") {
            // Принимаем JSON и автоматически конвертируем его в дата-класс LoginRequest
            val request = call.receive<LoginRequest>()
            
            // Бизнес-логика проверки пользователя через БД
            val authResponse = DatabaseFactory.authenticateUser(request)
            
            // Отправляем ответ клиенту в формате JSON со статусом HTTP
            if (authResponse.success) {
                call.respond(HttpStatusCode.OK, authResponse)
            } else {
                call.respond(HttpStatusCode.Unauthorized, authResponse)
            }
        }
