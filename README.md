# Lighthouse-Project

This is the public repository of our 2017 programming course project at the CAU.
The game is a simple side scroller and is optimized for being displayed at the Lighthouse on campus.
The programming structure follows a basic MVC layout and renders a player and obstacle objects on the screen.
The model contains the game state and all the game logic, the controller is used to correspond with the model and to 
offer key events (such as key pressed, key released etc.). The view's sole purpose is to render the game, it gets all
objects from the model and simple displays them in a JFrame.
Each player / obstacle object is created using abstract coordinates (which are relative to the Lighthouse's 
native display of 14x28px). The collision check is done with a slightly modded version of Java's own Rectangle 
intersect method, also using those abstract coordinates only. 

The program is fully responsive and offers a freely scalable view and a view which can be scaled, but is locked
to a ratio of 2:1 to ensure the correct depiction of the game at every given point.

Programmed by Nils & myself.
Feel free to mod the code as you like, nobody saw it on the Lighthouse this year..
Maybe you can take our code for the next InfprogOO course in 2018 and invite us to your showcase,
we'd love to see our code performing live.. it is definitely capable of that, every simulation
passed without any problem at all :/

Cheers guys :)
