# Тесты для сайта "github.com" с Allure отчетностью <br>


### Полезная информация.<br><br>

**Команды:** <br>
1. ```Gradle -> other -> downloadAllure``` - скачивает папку .allure. 
Необходима для создания отчетов. <br>
Выполняется в начале создания и запусков тестов.
2. ```Gradle -> Tasks -> build -> clean``` - Удаляет папку со старыми результатами запуска тестов.<br>
Выполнять перед запуском тестов.
3. ```Gradle -> other -> allureServe``` - Создает отчет запускает по адресу 127.0.0.1<br>
Выполнять после clean<br><br>

**Также Allure не работает с gradle 7.1**<br>
Нужно скачать:<br>
```gradle wrapper --gradle-version 6.8```<br>
После протестировать можно командой:<br>
```./gradlew clean test```
<br><br>

**При возникновении ошибки при использовании Allure вида:**<br>
```
AspectJ Internal Error: unable to add stackmap attributes. null

Expecting a stackmap frame at branch target 38
Exception Details:
  Location:
    com/github/allure/WebSteps.searchForRepository(Ljava/lang/String;)V @12: invokestatic
  Reason:
    Expected stackmap frame at this location.
  Bytecode:
    0000000: 2b4e b200 8d2a 2a2d b800 794d b800 7f2c
    0000010: b600 8312 03b8 0004 2bb9 0005 0200 b900
    0000020: 0601 00a7 0010 3a04 b800 7f19 04b6 0087
    0000030: 1904 bfb8 007f b600 8ab1               
  Exception Handler Table:
    bci [12, 38] => handler: 38
```
нужно добавить:<br>
```testImplementation('org.aspectj:aspectjweaver:1.9.7')```
