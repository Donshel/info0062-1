# Object-oriented simulation of the [Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

Project realized as part of the course *Object-oriented programming* given by **Bernard Boigelot** to undergraduate engineering students at the [University of Liège](https://www.uliege.be/) during the academic year 2018-2019.

## Languages

This project has been developed using the object-oriented language [Java](https://www.java.com/en/).

Therefore, it is necessary to install a [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/index.html) to be able to run and compile this project. If you do so, don't forget to add the `bin` directory of your `jdk` installation to your computer environment path afterwards.

Following command lines have to be run in the `GameOfLife` directory.

### Compile

```bash
javac -d bin src/*.java
```

#### Produce documentation

```bash
javadoc -d javadoc src/*.java
```

### Run

```bash
java -cp bin GameOfLife args[]
```

Where `args[]` could be `12 8`. Check the documentation for further information.

## Authors

* **François Rozet** - [francois-rozet](https://github.com/francois-rozet)

## Score

This project received a score of 17/20.
