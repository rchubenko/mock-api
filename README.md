# Mock API

Mock API — это сервис, разработанный на Java, предназначенный для эмуляции API эндпоинтов в процессе разработки и тестирования приложений. Он позволяет разработчикам создавать и тестировать взаимодействие с API без необходимости подключения к реальным сервисам.

## Начало работы

### Предварительные требования

- [Docker](https://www.docker.com/get-started): убедитесь, что Docker установлен и запущен на вашей системе.
- [Docker Compose](https://docs.docker.com/compose/install/): необходим для оркестрации контейнеров.

### Установка и запуск

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/rchubenko/mock-api.git
   cd mock-api
   ```

2. **Соберите проект с помощью Maven:**
   ```bash
   mvn clean package
   ```

3. **Создайте Docker-образ:**
   ```bash
   docker build -t mock-api .
   ```

4. **Запустите контейнер с помощью Docker Compose:**
   ```bash
   docker-compose up -d
   ```

   После выполнения этих шагов, сервис будет доступен по адресу `http://localhost:8080`.

## Конфигурация

Приложение использует следующие переменные окружения для настройки:

- `SPRING_DATA_MONGODB_URI`: иформация для подключения к mongodb (по умолчанию `mongodb://localhost:27017/mockserver`).
- `SERVER_PORT`: порт, на котором будет работать сервис (по умолчанию `8080`).

Эти переменные можно задать в файле `.env` в корневой директории проекта или непосредственно в файле `docker-compose.yml` в разделе `environment`.

Пример файла `.env`:

```env
SPRING_DATA_MONGODB_URI=mongodb://localhost:27017/mockserver
SERVER_PORT=8080
```
