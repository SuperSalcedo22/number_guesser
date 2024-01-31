# Number guessing game with gui
Basic project to build and consolidate java programming skills


## Terminal package
First iteration of the game using command line arguments 
- Scanner used to detect user input and handle any exceptions
- Array list used to store previous guesses and display them to the user

## gui package
Building upon the terminal version and creating a gui that removes the command line interface 
- Built using java swing as an introductory package to building gui's  

### Classes
3 separate classes used to make the gui
#### gameLogic
Adapting the terminal code to work within the gui
- Mixture of public and private variables to hide values from different classes
- Error handling wrong inputs by the user

#### customPanel
Building upon standard JPanels to reduce redundant repetitive code when creating new panels
- Learning to use JPanels, JLabels, JButtons and inputFields
- Private variables with getter and setter methods (in order to get used to this within java)
- Setter methods allow the panels to be edited from different scopes

#### gameGUI
Running the gui and guessing game
- Creating the JFrame for the gui and JPanels to run on
- Card layout used for seamless transition between JPanels

### Testing
Unit test methods were created for the gameLogic class to learn JUnit testing 
- Edge cases considered
- Full coverage of all methods were ensured

### Screenshots
- Preview layouts of gui

![alt text](https://github.com/SuperSalcedo22/number_guesser/blob/master/play_panel.png "Play Panel")
