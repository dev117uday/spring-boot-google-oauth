# Spring Boot Google OAuth Template

All code written in this repo is me hacking together things i know from the internet. If you find this cord weird, yes it is, because it works for me and if the repo is public, still in use.

## Configuration

- create a file in `application.yml` in `src/main/resources` folder

```s
touch src/main/resources/application.yml
```

- Paste the following with correct info

```yml
app:
  cors:
    allowedOrigins: http://localhost:5000

  jwt:
    secret_key: <jwt secret key>

  datasource:
    main:
      driver-class-name: org.postgresql.Driver
      jdbc-url: jdbc:postgresql://<address>:<port>/<db name>
      username: <db user name>
      password: <db user password>
      pool-size: <pool size>
```
