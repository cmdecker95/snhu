# SlideShow

A Java Swing slideshow application.

## Build & Run

### 1. Compile source into `bin/`

```bash
javac -d bin src/SlideShow.java
```

### 2. Copy image resources into `bin/`

```bash
cp -r src/resources bin/resources
```

### 3. Package `bin/` into a runnable JAR

```bash
jar cfe slide-show.jar SlideShow -C bin .
```

### 4. Run the JAR

```bash
java -jar slide-show.jar
```
