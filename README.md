# liquidjava-examples
Examples to use with [LiquidJava](https://catarinagamboa.github.io/liquidjava.html)

## Examples
### part3-liquidJava
Contains LiquidJava projects.

Open one of the folders on VSCode with the extension running. Uncomment the code in the Test file and find the error. You can open the folder through the terminal by going to the correct path and typing `code` or open through the VSCode GUI.

### part3-plainJava
Contains Java projects without LiquidJava.
Open one of the folders on VSCode and find the error.

### part4
Contains Java files to be annotated with LiquidJava.
- **Variable.java** - Add the annotation and check the correct and wrong assignment
- **TrafficLight.java** - Add the annotations on the fields and model the state using `@StateSet` and `@StateRefinement`. To check if the modelling is correct, uncomment the file `TestTLCorrect.java` (that should be correct) and then uncomment the file `TestTLWrong.java` that should present an error.  


## Install Visual Studio Code Extension
1. Open the terminal on the extension folder
2. `code --install-extension liquid-java-0.0.X.vsix`, where X is the current version of the extension
3. Ensure that VSCode has the redhat extension for [Language support for Java ™](https://marketplace.visualstudio.com/items?itemName=redhat.java) installed and enabled (Java 11 is the minimum required for this extension to run).
4. Open Visual Studio Code and open a Java project (with src folder inside). If the project contains the liquidjava-api.jar then the extension will be activated, otherwise the LiquidJava verification is not applied.
5. The extension may take some time to be activated. While a small wheel in the bottom right of VSCode window is spinning the extension is being loaded.

## Download jars
`liquidjava-jars` folder contains the api and verifier jars.
