package de.vickylaram.colorBalanceCalculator;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;
import de.vickylaram.colorBalanceCalculator.model.dna.DNASequence;
import de.vickylaram.colorBalanceCalculator.model.SequencingStatus;
import de.vickylaram.colorBalanceCalculator.model.laser.Laser;
import de.vickylaram.colorBalanceCalculator.model.laser.GreenLightLaser;
import de.vickylaram.colorBalanceCalculator.model.laser.RedLightLaser;
import org.apache.commons.cli.*;
import org.javatuples.Pair;

import de.vickylaram.colorBalanceCalculator.util.FileUtil;

import java.util.List;

/**
 * Main class
 *
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class Main {

    /**
     * Sets up and configures command-line interface (CLI) options for the application.
     *
     * @return An {@code Options} object configured with the command-line options for the application.
     */
    private static Options setupCLIOptions() {

        Options options = new Options();

        Option input_file_option = Option.builder("i").longOpt("input")
                .argName("input")
                .hasArg(true)
                .required(true)
                .desc("Input file").build();

        Option delimiter_option = Option.builder("d").longOpt("delimiter")
                .argName("delimiter")
                .hasArg(true)
                .required(false)
                .desc("Delimiter used in input file").build();

        options.addOption(input_file_option);
        options.addOption(delimiter_option);

        return options;
    }

    /**
     * Executes the sequencing process using two different lasers and prints the results.
     *
     * @param filePath  The path to the file containing the DNA sequences.
     * @param delimiter The delimiter used to separate elements in the DNA sequences.
     */
    private static void run(String filePath, String delimiter) {

        Pair<List<DNASequence>, Integer> sequences = FileUtil.readSequencesFromFile(filePath, delimiter);
        int maxIndexLength = sequences.getValue1();
        List<DNASequence> results = sequences.getValue0();

        if (maxIndexLength > 0) {

            try {

                Laser gl = new GreenLightLaser();
                Laser rl = new RedLightLaser();

                System.out.println("CYCLE | RED | GREEN");

                int greenLightUps = 0;
                int redLightUps = 0;

                SequencingStatus status = SequencingStatus.SUCCESS;

                // Iterate base-wise through all sequences
                for (int i = 0; i < maxIndexLength; i++) {

                    // For current position, iterate through all indexes
                    for (int j = 0; j < results.size(); j++) {

                        DNASequence seq = results.get(j);
                        DNABase base = seq.getFirstBase();

                        //Evaluate both outputs from boolean to integer and add result to counter of current cycle
                        greenLightUps += gl.readBase(base) ? 1 : 0;
                        redLightUps += rl.readBase(base) ? 1 : 0;

                        // Remove current base from sequence
                        seq.nextBase();

                    }
                    // If any of the two lasers stays dark for a cycle, the run is failed
                    if (greenLightUps == 0 || redLightUps == 0) {
                        status = SequencingStatus.FAILURE;
                    }
                    System.out.println(i + 1 + " | " + redLightUps + " | " + greenLightUps);
                    //Reset the values for next sequence position/next base
                    greenLightUps = 0;
                    redLightUps = 0;

                }
                System.out.println("Evaluation: " + status);

            } catch (IndexOutOfBoundsException ie) {
                throw new IllegalArgumentException("Indexes are not of equal length.");
            }
        }
    }

    public static void main(String[] args) {

        Options options = setupCLIOptions();

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String filePath = cmd.getOptionValue("input");
                String delimiter = " ";
                if (cmd.hasOption("delimiter")) {
                    delimiter = cmd.getOptionValue("delimiter");
                }
                run(filePath, delimiter);
            }
        } catch (ParseException e) {
            formatter.printHelp("utility-name", options);
        }
    }
}
