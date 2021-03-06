﻿# eSpeak NG Java Editor
__This is an eSpeakNG Editor rewritten in Java.__

* [Building](#building)
  * [espeak-ng](#espeak-ng)
  * [espeak-ng-jeditor](#espeak-ng-jeditor)
* [Running](#running)
* [Documentation](#documentation)
* [Licence](#licence)
* [TODOs](#todos)

![Screenshot](/docs/images/screenshot.png)

![Screenshot](/docs/images/screenshot1.png)

This editor is not production ready yet!
For latest development news look at [commits](https://github.com/valdisvi/espeak-ng-jeditor/commits/master).
For production purposes you can use older snapshot of [espeak-ng-editor](https://github.com/valdisvi/espeak-ng-espeakedit)!

## Building

### Building espeak-ng (optional)

_There library built in this project already, which is located in [lib](../../tree/master/lib) folder.
Following is description how to build library from eSpeakNG source files:_

_eSpeakNG Java Editor relies on libraries of eSpeakNG, which have to be recompiled with custom settings._
Clone [eSpeakNG](https://github.com/espeak-ng/espeak-ng/) project and [solve dependencies](https://github.com/espeak-ng/espeak-ng/#dependencies):

(To be sure) install additional packages:

```
sudo apt-get install libwxgtk3.0 libportaudio2 sox libwxgtk3.0-dev libportaudio-dev
```

When invoke building of `espeak-ng` project add additional `-fPIC` flags to compiler, e.g. by compiling in following way:


```
./autogen.sh
CFLAGS='-fPIC' ./configure --prefix=/usr
make -B
```

### espeak-ng-jeditor
Clone [espeak-ng-jeditor](https://github.com/valdisvi/espeak-ng-jeditor) project.
_Note that `espeak-ng` and `espeak-ng-jeditor` projects should be subfolders of common folder!_

Compile customized shared library by executing Bash script in `espeak-ng-jeditor` project folder:

```
./updateJNIchanges.sh
```
To rebuild Java classes, run Maven task:

```
mvn compile
```

## Running
* In IDE: select **MainWindow.java** class in **org.espeakng.jeditor.gui** package and run it as Java application.
* In terminal ececute command: `java -cp target/classes org.espeakng.jeditor.gui.MainWindow`

## Packaging
* To package editor in single *.jar file, execute command:
```
mvn clean compile assembly:single
```
* Then run archive located in `target` folder, by executing command:
```
java -jar eSpeakNG-jEditor.jar
```
(Note that libespeakservice.so file is copied to `../.lib` folder from *.jar file for execution.)

## Documentation

* [General Editor info](docs/editor.md)
* [User interface](docs/editor_if.md)
* [All other documents](docs/)
* [Documentation for new Changes](docs/Documentation.md)

## Licence

This software is licenced under [GNU Lesser General Public License](https://spdx.org/licenses/LGPL-3.0.html)

## TODOs
**Project design**
- [ ] Figure out proper way to save phoneme data using JNI
- [ ] Implement phoneme replay using JNI to espeak-ng API
- [ ] Improved coverage of automated unit tests(76.1% Completed)
- [ ] Autogenerated *.h file and Java proxy classes using [SWIG](http://www.swig.org/) or similar JNI integration library
- [ ] Construct all MainWindow Objects according to Object Oriented Principles
- [ ] Implement compile buttons using ESpeak API

**Editor GUI**

- [ ] Implement process Lexicon menu correctly


