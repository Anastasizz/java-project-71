# Hexlet tests and linter status:

[![Actions Status](https://github.com/Anastasizz/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Anastasizz/java-project-71/actions)
[![Java CI](https://github.com/Anastasizz/java-project-71/actions/workflows/java_CI.yml/badge.svg)](https://github.com/Anastasizz/java-project-71/actions/workflows/java_CI.yml)

# Качество кода

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Anastasizz_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Anastasizz_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Anastasizz_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Anastasizz_java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Anastasizz_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Anastasizz_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Anastasizz_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Anastasizz_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Anastasizz_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Anastasizz_java-project-71)

# Вычислитель отличий

Утилита командной строки gendiff, определяющая разницу между двумя структурами данных.
Возможности утилиты:
- Поддержка входных форматов: yaml и json
- Генерация отчета в виде plain text, stylish и json

# Установка и сборка

```
git clone https://github.com/NastasiyaT/java-project-71.git
cd java-project-71/app
```

Сборка проекта с помощью Gradle<br>
`./gradlew build`

Генерация исполняемого дистрибутива<br>
`./gradlew installDist`

# Запуск

Синтаксис команды<br>
`gendiff [-f format] <filepath1> <filepath2>`

### Параметры:
- `<filepath1>` - путь к **первому файлу** для сравнения
- `<filepath2>` - путь ко **второму файлу**
- `--format` (или `-f`) - формат вывода:
    - `stylish` (по умолчанию)
    - `plain`
    - `json`

Пример вызова<br>
`./build/install/app/bin/app -f json file1.json file2.json`

Получение справки<br>
`./build/install/app/bin/app -help`

Версия<br>
`./build/install/app/bin/app -v`

# Demo

[asciinema diff simple JSON](https://asciinema.org/a/SpCpfHHUDeXh8d0uzIK4FONlx)<br>
[asciinema diff simple YAML](https://asciinema.org/a/WaqBkxdxpUYrBotc4OajQryHX)<br>
[asciinema diff complex JSON](https://asciinema.org/a/ANi7oXiY7kjzXpBYLECyxnw2V)<br>
[asciinema diff plain format](https://asciinema.org/a/pzuhasjFerCaE0I8Ys9jrMW7G)<br>
[asciinema diff json format](https://asciinema.org/a/7eqiIHUgSCTxfSeZbzWWX3K0j)<br>



