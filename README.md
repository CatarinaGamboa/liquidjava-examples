# LiquidJava Examples

Welcome to the LiquidJava examples repository! 

This collection demonstrates how to use LiquidJava, a powerful extension for Java that enables expressive type refinements through annotations. Whether you're new to LiquidJava or looking to deepen your understanding, these examples will help you explore its capabilities and learn how to enhance your Java code with sophisticated type checking.

For more information about LiquidJava, visit our [website](https://catarinagamboa.github.io/liquidjava.html)!

### Setup Instructions

#### Using Codespaces

- To use Codespaces, make sure you’re logged in to GitHub, click the button below, select `4-core`, and then press `Create codespace`. The codespace will open in your browser and with the LiquidJava extension installed.

   [![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/CatarinaGamboa/liquidjava-examples)

#### Using Dev Containers

- You can also use VS Code's Dev Containers. Make sure you have Docker and the Dev Containers extension installed in VS Code and use the "Remote-Containers: Open Folder in Container" command.

#### Local Setup

- Alternatively, you can use the extension locally in your VS Code, by pulling this repository and installing the extension from the marketplace, which is available [here](https://marketplace.visualstudio.com/items?itemName=AlcidesFonseca.liquid-java).
- Ensure the Red Hat extension for [Language Support for Java™](https://marketplace.visualstudio.com/items?itemName=redhat.java) is also installed and enabled.
- Make sure to have at least Java 20+ and Maven  3.6+ installed on your machine.
- Execute the following commands in your terminal:

```sh
git clone https://github.com/CatarinaGamboa/liquidjava-examples
cd liquidjava-examples/examples/demo
mvn clean install
```

### Using the Extension

1. When opening a Java project, the extension will automatically verify your LiquidJava annotations.
2. Errors will be reported in real-time and refinements will have syntax highlighting.
3. An item in the status bar at the bottom left of the editor indicates the extension's current state. You can check the extension logs by clicking on it.

### Examples
```
liquidjava-examples/
├── examples/                          
│   ├── demo/                           # Simple demo examples
│   │   ├── src/main/java/com/example   # Examples start with "Test*.java"
├── user_study_23/                      # Example projects used for user study of 2023
│   ├── part1-plainJava/                # Java projects without LiquidJava
│   ├── part3-liquidJava/               # Projects with LiquidJava annotations
│   └── part4/                          # Files to be annotated with LiquidJava
├── extension/                          # Contains the VSIX extension file
...
```
### 2022/23 User Study:
#### part1-plainJava
Contains Java projects without LiquidJava.
Open one of the folders on VS Code and find the error.

#### part3-liquidJava
Contains LiquidJava projects.

Open one of the folders on VS Code with the extension running. Uncomment the code in the Test file and find the error. You can open the folder through the terminal by going to the correct path and typing `code` or open through the VS Code GUI.

#### part4
Contains Java files to be annotated with LiquidJava.
- **Variable.java** - Add the annotation and check the correct and wrong assignment
- **TrafficLight.java** - Add the annotations on the fields and model the state using `@StateSet` and `@StateRefinement`. To check if the modelling is correct, uncomment the file `TestTLCorrect.java` (that should be correct) and then uncomment the file `TestTLWrong.java` that should present an error.
## Advanced Development

For extension development:
- Refer to the VS Code Extension API documentation
- Make changes to your code and test using the provided examples
- Use the debug console to troubleshoot any issues
