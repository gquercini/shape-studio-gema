# Shape Studio

Shape Studio is a Java application for modeling and manipulating geometric shapes such as points, segments, rectangles, triangles, and circles. The project demonstrates object-oriented programming concepts, geometric computations, and includes unit tests for all major classes.

## Features

- **Geometric Shapes:** Supports Point, Segment, Rectangle, Triangle, and Circle classes.
- **Transformations:** Move, scale, and rotate shapes.
- **Validation:** Ensures valid colors, border widths, and geometric constraints.
- **Unit Tests:** Comprehensive JUnit tests for all shape classes.
- **Maven Build:** Uses Maven for building, testing, and dependency management.

## Requirements

- Java 17 or higher (Java 24 recommended)
- Maven 3.x

## Project Structure

```
src/
  main/java/fr/gema/shapes/         # Shape classes and logic
  main/java/fr/gema/shapes/exceptions/ # Custom exceptions
  main/java/fr/gema/                # Main application entry point
  test/java/fr/gema/shapes/         # JUnit test classes
pom.xml                             # Maven configuration
```

## How to Build

From the project root, run:

```sh
mvn clean package
```

## How to Run

After building, run the main class:

```sh
mvn exec:java -Dexec.mainClass="fr.gema.Main"
```

Or, using the Java command:

```sh
java -cp target/classes fr.gema.Main
```

## How to Test

Run all unit tests with:

```sh
mvn test
```

## License

This project is for educational purposes.