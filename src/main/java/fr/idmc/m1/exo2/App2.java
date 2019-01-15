package fr.idmc.m1.exo2;

import org.apache.commons.cli.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class App2
{
    public static final Logger LOG = Logger.getLogger(App2.class.getSimpleName());

    public static void main(String[] args)
    {
        Options options = new Options();
        options.addOption("f", "file", true, "csv file");
        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try
        {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("f"))
            {
                String filename = cmd.getOptionValue("f");
                if (!Files.exists(Paths.get(filename)))
                {
                    System.out.println(filename + ": No such file");
                    formatter.printHelp("App2", options);
                    System.exit(100);
                }
                try
                {
                    CSVParser parse = CSVParser.parse(Paths.get(cmd.getOptionValue("f")),
                                                      Charset.defaultCharset(),
                                                      CSVFormat.newFormat(';')
                                                          .withCommentMarker('#'));
                    parse.getRecords().forEach(r -> System.out.printf("App1 : %s %s%n", r.get(0), r.get(1)));
                    parse.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                formatter.printHelp("App2", options);
                System.exit(12);
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}

