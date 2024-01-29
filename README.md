# Number guessing game with GUI
Basic project to build and consolidate java programming skills


## Terminal package
First iteration of the game using command line arguments 
- Scanner used to detect user input and handle any exceptions
- Array list used to store previous guesses and display them to the user

## GUI package
Building upon the terminal version and creating a GUI that removes the command line interface 
- Built using java swing as an introductory package to building GUI's  

### Classes
3 separate classes used to make the GUI
#### gameLogic
Adapting the terminal code to work within the GUI
- Mixture of public and private variables to hide values from different classes
- Error handling wrong inputs by the user

#### customPanel
Building upon standard JPanels to reduce redundant repetitive code when creating new panels
- Learning to use JPanels, JLabels, JButtons and inputFields
- Private variables with getter and setter methods (in order to get used to this within java)
- Setter methods allow the panels to be edited from different scopes

#### gameGUI
Running the GUI and guessing game
- Creating the JFrame for the GUI and JPanels to run on
- Card layout used for seamless transition between JPanels

### Screenshots
- Preview layouts of GUI
