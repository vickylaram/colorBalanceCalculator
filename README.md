# ReadMe

## How to build & execute 


Clone this repo first and after that, enter the project root directory.
This project uses Maven as a build management tool, so first make sure your machine has Maven installed.
Run ```mvn clean install``` to build the program with its dependencies. \
After a successful build you should find a
newly created directory ```/target``` containing a .jar file ```color-balance-calculator-1.0-SNAPSHOT.jar```.
The execution command is ```java -jar color-balance-calculator-1.0-SNAPSHOT.jar -i [PATH_TO_YOUR_FILE]``` with a file path
of your choice (absolute or relative; platform-independent). 


## Input formats

You can use any of the input formats provided in the example input files. The default delimiter is
space, but you can provide your own (comma or semicolon) by using -d flag when executing the program. Just make sure it's
consistent throughout your file. \
Also, please make sure to place only one index per line. If you like, you can add a number at the beginning
of the line for better overview, but this is completely optional. \
In case you don't have an input file ready, you can find three sample inputs.

## Background information

* NGS sequencing -> Illumina sequencing
*  **2-** and **4-channel** SBS 

https://www.illumina.com/science/technology/next-generation-sequencing/sequencing-technology/2-channel-sbs.html

https://www.pnas.org/doi/10.1073/pnas.0609513103

https://www.ecseq.com/support/ngs/do-you-have-two-colors-or-four-colors-in-Illumina
