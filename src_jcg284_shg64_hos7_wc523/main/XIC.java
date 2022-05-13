package src_jcg284_shg64_hos7_wc523.main;

import src_jcg284_shg64_hos7_wc523.lexer.*;
import src_jcg284_shg64_hos7_wc523.optimizations.*;
import src_jcg284_shg64_hos7_wc523.parser.*;
import src_jcg284_shg64_hos7_wc523.parser.parser.SyntacticException;
import src_jcg284_shg64_hos7_wc523.ast.*;
import src_jcg284_shg64_hos7_wc523.cfg.*;
import src_jcg284_shg64_hos7_wc523.typechecker.*;
import src_jcg284_shg64_hos7_wc523.ir.*;
import src_jcg284_shg64_hos7_wc523.codeGen.*;

import polyglot.util.*;
import edu.cornell.cs.cs4120.util.*;
import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.interpret.*;

import org.apache.commons.cli.*;

import java.io.*;
import java.util.*;

class XIC {
  /**
   * Parse and execute the command xic [options] <sourcefiles>
   * 
   * For each file in <sourcefiles>, lex and parse the file. If a file contains
   * either a lexical or syntactic error, print a message of the form
   * <line>:<column> error:<error message> detailing where the error occurred and
   * what the nature of the error is, then move on to the next file.
   * 
   * If the --lex or -l flags are provided, then for each file in <sourcefiles>,
   * create a file with a .lexed extension containing the lexical representation
   * of the contents of <sourcefile>.
   * 
   * If the --parse or -p flags are provided, then for each file in <sourcefiles>,
   * craeate a file with a .parsed extension containing the S-Expression
   * representation of the contents of <sourcefile>.
   * 
   * If the --irgen flag is provided, then for each file in <sourcefiles>, create
   * a file with a .ir extension containing the S-Expression representation of the
   * intermediate representation of the contents of <sourcefile>.
   * 
   * If the --irrun flag is provided, then for each file in <sourcefiles>, create
   * a file with a .ir extension as specified when using the --irgen flag and
   * interpret the intermediate representation of the contents of <sourcefile>.
   * 
   * The option -D <filepath> specifies the filepath to put the .lexed files in.\
   * 
   * The option -sourcepath <filepath> specifies the filepath in which to find the
   * source files.
   * 
   * If the -O flag is provided, then do not run optimizations when generating IR
   * code for each file in <sourcefiles>.
   * 
   * If --help is invoked or no sourcefiles are given, print a synopsis of options
   * listing all possible options along with brief descriptions.
   */
  public static void main(String[] args) throws IOException {
    // IRExpr binopConst1 = new IRBinOp(IRBinOp.OpType.ADD, new IRConst(1), new IRConst(1));
    // IRExpr binopConst2 = new IRBinOp(IRBinOp.OpType.ADDm, new IRConst(1), new IRConst(1));
    IRExpr binopTemp1 = new IRBinOp(IRBinOp.OpType.ADD, new IRTemp("t0"), new IRTemp("t1"));
    IRExpr binopTemp2 = new IRBinOp(IRBinOp.OpType.ADD, new IRTemp("t1"), new IRTemp("t0"));
    // // System.out.println(binopConst1.equals(binopConst2));
    // // System.out.println(binopTemp1.equals(binopTemp2));
    // Map<IRExpr, Set<IRExpr>> testMap = new HashMap<>();
    // Set<IRExpr> testSet = new HashSet<>();
    // testSet.add(binopTemp1);
    // testMap.put(binopConst1, testSet);
    // testMap.put(binopConst2, )
    // System.out.println(binopTemp1.equals(binopTemp2));

    CommandLineParser parser = new DefaultParser();
    Options options = new Options();
    HelpFormatter formatter = new HelpFormatter();

    Option lex = Option.builder("l").longOpt("lex")
        .desc("Generate output from lexical analysis. " + "For each source file named filename.xi, a "
            + "diagnostic output file named filename.lexed " + "is generated to provide the result of "
            + "lexing the source file.")
        .build();
    Option parse = Option.builder("p").longOpt("parse")
        .desc("Generate output from syntactic analysis. " + "For each source file given as "
            + "path/to/file.xi in the command line, an " + "output file named path/to/file.parsed is "
            + "generated to provide the result of parsing " + "the source file.")
        .build();
    Option typecheck = Option.builder("t").longOpt("typecheck")
        .desc("Generate output from the semantic analysis. " + "For each source file given as "
            + "path/to/file.xi in the command line, an " + "output file named path/to/file.typed is "
            + "generated to provide the result of typechecking " + "the source file.")
        .build();
    Option irgen = Option.builder("irgen").longOpt("irgen")
        .desc("Generate output from the ir generator. " + "For each source file given as "
            + "path/to/file.xi in the command line, an " + "output file named path/to/file.ir is "
            + "generated to provide the ir representation of " + "the source file.")
        .build();
    Option irrun = Option.builder("irrun").longOpt("irrun").desc("Generate and interpret intermediate code.").build();

    options.addOption("h", "help", false, "Print this message");
    options.addOption(lex);
    options.addOption("D", true,
        "Specify where to place the generated " + "diagnostic files. If given, the compiler should place "
            + "generated diagnostic files (from the --lex option), in the "
            + "directory relative to this path. The default is the current " + "directory in which xic is run.");
    options.addOption("d", true,
        "Specify where to place the generated " + "assembly files. If given, the compiler should place "
            + "generated assembly files (from the --lex option), in the "
            + "directory relative to this path. The default is the current " + "directory in which xic is run.");
    options.addOption(parse);
    options.addOption("sourcepath", true,
        "Specify where to find input source files. If given, the "
            + "compiler should find given input source files in the directory "
            + "relative to this path. The default is the current directory in " + "which xic is run.");
    options.addOption(typecheck);
    options.addOption("libpath", true,
        "Specify where to find library interface files. If given, the "
            + "compiler should find library interface files in the directory "
            + "relative to this path. The default is the current directory in " + "which xic is run.");
    options.addOption(irgen);
    options.addOption(irrun);
    options.addOption("O", false,
        "Disable optimizations. If specified, " + "options such as constant folding should not be performed.");
    options.addOption("target", true, "Specify the operating system for which to generate code. "
        + "OS may be one of linux, windows, and macos. Defaults to linux.");

    //part 6 commands
    options.addOption("reportopts", "report-opts", false, "Outputs a list of optimizations supported");
    options.addOption("optir", "optir", true, "Report the intermediate code at the specified phase of optimization.");
    options.addOption("optcfg", "optcfg", true, "Report the intermediate code at the specified phase of optimization.");
    //we don't need some of these to actually do anything, but we need them here
    options.addOption("Ocf", false, "Enable Optimization Constant folding");
    options.addOption("Oreg", false, "Enable Optimization Register allocation");
    options.addOption("Omc", false, "Enable Optimization Move coalescing (and register allocation)");
    options.addOption("Ocse", false, "Enable Optimization Common subexpression elimination");
    options.addOption("Oalg", false, "Enable Optimization Algebraic optimizations (identities and reassociation)");
    options.addOption("Ocopy", false, "Enable Optimization Copy propagation");
    options.addOption("Odce", false, "Enable Optimization Dead code elimination");
    options.addOption("Oinl", false, "Enable Optimization Inlining");
    options.addOption("Osr", false, "Enable Optimization Strength reduction");
    options.addOption("Olu", false, "Enable Optimization Loop unrolling");
    options.addOption("Olicm", false, "Enable Optimization Loop-invariant code motion");

    try {
      CommandLine commandLine = parser.parse(options, args);

      // ensure target is linux
      if (commandLine.hasOption("target")) {
        String target = commandLine.getOptionValue("target");
        if (!target.equals("linux")) {
          System.out.println(target + " operating system not supported.");
          System.exit(0);
        }
      }

      // create source path
      String source = "";
      if (commandLine.hasOption("sourcepath")) {
        source = commandLine.getOptionValue("sourcepath") + "/";
      }

      // create diagnostic destination path
      String diagnosticDest = "";
      if (commandLine.hasOption("D")) {
        diagnosticDest = commandLine.getOptionValue("D") + "/";
      }

      // create assembly destination path
      String srcDest = "";
      if (commandLine.hasOption("d")) {
        srcDest = commandLine.getOptionValue("d") + "/";
      }

      // create lib path
      String libpath = "";
      if (commandLine.hasOption("libpath")) {
        libpath = commandLine.getOptionValue("libpath") + "/";
      }

      // Get list of source files
      List<String> files = commandLine.getArgList();
      if (commandLine.hasOption("h") || files.size() == 0) {
        formatter.printHelp("xic", options, true);
        System.exit(0);
      }

      //report-opts
      if (commandLine.hasOption("report-opts")) {
        System.out.println("% xic --report-opts \n cf \n reg \n mc \n cse \n copy \n dce \n%");
        System.exit(0);
      }

      boolean anyOptimization = false;
      Set<String> optimizations = new HashSet<>();
      if (commandLine.hasOption("Ocf")) {
        optimizations.add("cf");
        anyOptimization = true;
      }
      if (commandLine.hasOption("Oreg")) {
        optimizations.add("reg");
        anyOptimization = true;
      }
      if (commandLine.hasOption("Omc")){
        optimizations.add("reg");
        optimizations.add("mc");
        anyOptimization = true;
      }
      if (commandLine.hasOption("Ocse")){
        optimizations.add("cse");
        anyOptimization = true;
      }
      if (commandLine.hasOption("Ocopy")){
        optimizations.add("copy");
        anyOptimization = true;
      }
      if (commandLine.hasOption("Odce")){
        optimizations.add("dce");
        anyOptimization = true;
      }

      for (String file : files) {
        // Check file exists
        if (!(new File(source + file).exists())) {
          System.out.println("File " + source + file + " does not exist.");
          System.exit(0);
        }

        // Check file is an xi or xic file
        String fileRoot = file.substring(0, file.lastIndexOf("."));
        String outFileRoot = diagnosticDest + fileRoot;
        String extension = file.substring(file.lastIndexOf("."));
        if (!(extension.equals(".xi") || extension.equals(".ixi"))) {
          System.out.println("File " + file + " is not an accepted filetype.");
          System.exit(0);
        }

        // Create a lexer
        MyLexer lexer = new MyLexer(new InputStreamReader(new FileInputStream(source + file)));

        // If we need to print lexical diagnostics,
        // give the LexerWrapper an output file
        BufferedWriter lexout = null;
        if (commandLine.hasOption("l")) {
          String lexOutFile = outFileRoot + ".lexed";
          FileWriter out = new FileWriter(new File(lexOutFile));
          lexout = new BufferedWriter(out);
        }

        java_cup.runtime.Scanner lex_wrapper = new LexerWrapper(lexout, lexer, extension);

        // Create a parser
        parser p = new parser(lex_wrapper);

        // If the file parses correctly, check for the --parse and --lex flags
        // and produce their corresponding diagnostic files;
        // otherwise, print an error message
        try {
          // Attempt to parse the file into an AST.
          Node ast = p.parse().value();

          // If we need to print parser diagnostics, pretty print the ast.
          if (commandLine.hasOption("p")) {
            String parseOutFile = outFileRoot + ".parsed";
            OutputStream out = new FileOutputStream(new File(parseOutFile));
            CodeWriter writer = new OptimalCodeWriter(out, 80);
            SExpPrinter printer = new CodeWriterSExpPrinter(writer);

            ast.pprint(printer);
            printer.close();
          }

          // If file is an xi file, typecheck it.
          if (extension.equals(".xi")) {
            // Get an environment containing the method signatures.
            SignatureScanner sig = new SignatureScanner();
            ast.accept(sig);
            Context tlc = sig.getContext();

            // Create a typechecker with the method in the context and
            // run it on the ast.
            String filename = fileRoot.substring(fileRoot.lastIndexOf('/') + 1);
            TypeChecker typeChecker = new TypeChecker(tlc, filename, libpath);
            ast.accept(typeChecker);

            // Create an intermediate code generator and run it on the ast.
            IRGen irGen = new IRGen(tlc, filename);
            ast.accept(irGen);
            IRCompUnit highIR = (IRCompUnit) ast.ir;

            // Create an ir code lowerer and run it on the high level ir
            LowerIR irLowerer = new LowerIR(irGen.tempState);
            IRCompUnit lowIR = (IRCompUnit) irLowerer.visit(null, highIR);

            // Flattens out all extra sequences
            FlattenIR irFlattener = new FlattenIR();
            IRCompUnit flatIR = (IRCompUnit) irFlattener.visit(lowIR);

            IRCompUnit ir = flatIR;
            if (commandLine.hasOption("optir") && 
                Arrays.asList(commandLine.getOptionValues("optir")).contains("initial")
            ){
              String irOutFile = outFileRoot + "_initial.ir";
              FileWriter irOut = new FileWriter(new File(irOutFile));
              irOut.write(IRRun.prettyPrint(ir));
              irOut.close();
            }
            if (commandLine.hasOption("optcfg") && 
                Arrays.asList(commandLine.getOptionValues("optcfg")).contains("initial")
            ){
              for (IRFuncDecl f : ir.functions().values()){
                String cfgOutFile = outFileRoot + "_" + demangle(f) + "_initial.dot";
                IRCFG<AvailExprData> cfg = new IRCFG<AvailExprData>(f, "stmt", null);
                cfg.render(cfgOutFile);
              }
            }

            // Optimizations
            CodeGenerator codeGen = new CodeGenerator(outFileRoot);
            if (!commandLine.hasOption("O")) {
              if (!anyOptimization || optimizations.contains("cf")) {
                ConstantFold irFolder = new ConstantFold();
                ir = (IRCompUnit) irFolder.visit(ir);
              }
              if (!anyOptimization || optimizations.contains("cse")) {
                for (IRFuncDecl funcDecl : ir.functions().values()){
                  funcDecl = AvailExpr.optimize(funcDecl);
                  funcDecl = AvailExpr.optimize(funcDecl);
                  ir.appendFunc(funcDecl);
                }
              }
              codeGen = new CodeGenerator(outFileRoot, optimizations);
            }
            
            // Code generation
            codeGen.visit(ir);
            String asmOutFile = srcDest + fileRoot + ".s";
            FileWriter asmOut = new FileWriter(new File(asmOutFile));
            for (Assembly ins : ir.asm) {
              asmOut.write(ins.toString());
            }
            asmOut.close();

            // If we need to print semantic diagnostics, write a success
            // message to the typed file
            if (commandLine.hasOption("t")) {
              String typeOutFile = outFileRoot + ".typed";
              FileWriter typeOut = new FileWriter(new File(typeOutFile));
              typeOut.write("Valid Xi Program\n");
              typeOut.close();
            }

            if (commandLine.hasOption("irgen") || commandLine.hasOption("irrun")){
              String irOutFile = outFileRoot + ".ir";
              FileWriter irOut = new FileWriter(new File(irOutFile));
              irOut.write(IRRun.prettyPrint(ir));
              irOut.close();
            }
            if ((commandLine.hasOption("optir") && 
                Arrays.asList(commandLine.getOptionValues("optir")).contains("final"))
            ) {
              String irOutFile = outFileRoot + "_final.ir";
              FileWriter irOut = new FileWriter(new File(irOutFile));
              irOut.write(IRRun.prettyPrint(ir));
              irOut.close();
            }
            if (commandLine.hasOption("optcfg") &&
                Arrays.asList(commandLine.getOptionValues("optcfg")).contains("final")
            ) {
              for (IRFuncDecl f : ir.functions().values()){
                String cfgOutFile = outFileRoot + "_" + demangle(f) + "_final.dot";
                IRCFG<AvailExprData> cfg = new IRCFG<AvailExprData>(f, "stmt", null);
                cfg.render(cfgOutFile);
              }
            }
            if (commandLine.hasOption("irrun")) {
              IRSimulator sim = new IRSimulator(ir);
              sim.call("_Imain_paai", 0);
            }
          }

        } catch (LexicalError e) {
          // If a lexical error is found before a syntax error, halt the parser
          // and write the error to stdout.
          String message = e.getMessage();
          System.out.println(formatError("Lexical", source + file, e.line, e.column, message));

          // If we need to print parser diagnostics, write the lexical error.
          if (commandLine.hasOption("p")) {
            String parseOutFile = outFileRoot + ".parsed";
            Writer out = new FileWriter(new File(parseOutFile));
            out.write(message);
            out.close();
          }

          // If we need to print semantic diagnostics, write the lexical error.
          if (commandLine.hasOption("t")) {
            String typeOutFile = outFileRoot + ".typed";
            Writer out = new FileWriter(new File(typeOutFile));
            out.write(message);
            out.close();
          }

          // If we need to print IR diagnostics, write the lexical error.
          if (commandLine.hasOption("irgen") || commandLine.hasOption("irrun")) {
            String irOutFile = outFileRoot + ".ir";
            Writer out = new FileWriter(new File(irOutFile));
            out.write(message);
            out.close();
          }
        } catch (SyntacticException se) {
          // If a syntax error is found, halt the parser
          // and write the error to stdout
          String m = se.getMessage();
          System.out.println(formatError("Syntactic", source + file, se.line, se.column, m));

          // If we need to print parser diagnostics, write the syntax error.
          if (commandLine.hasOption("p")) {
            String parseOutFile = outFileRoot + ".parsed";
            Writer out = new FileWriter(new File(parseOutFile));
            out.write(m);
            out.close();
          }

          // If we need to print semantic diagnostics, write the syntax error.
          if (commandLine.hasOption("t")) {
            String typeOutFile = outFileRoot + ".typed";
            Writer out = new FileWriter(new File(typeOutFile));
            out.write(m);
            out.close();
          }

          // If we need to print IR diagnostics, write the syntax error.
          if (commandLine.hasOption("irgen") || commandLine.hasOption("irrun")) {
            String irOutFile = outFileRoot + ".ir";
            Writer out = new FileWriter(new File(irOutFile));
            out.write(m);
            out.close();
          }

          try {
            // If we need to print lexical diagnostics, resume consuming lexical
            // tokens.
            if (commandLine.hasOption("l")) {
              while (true) {
                java_cup.runtime.Symbol s = lex_wrapper.next_token();
                if (s.value == null || s.sym == sym.EOF)
                  break;
              }
            }
          } catch (LexicalError le) {
            // If a lexical error is found after a syntax error, just print the
            // lexical error to stdout and terminate.
            System.out.println(formatError("Lexical", source + file, le.line, le.column, le.msg));
          } catch (Exception e) {
            // Should never be reached.
            e.printStackTrace();
          }
        } catch (TypeException e) {
          // If a type exception is found print it to stdout.
          System.out.println(formatError("Semantic", source + file, e.line, e.column, e.msg));

          // If we need to print semantic diagnostics, write the error message
          // to a typed file.
          if (commandLine.hasOption("t")) {
            String typeOutFile = outFileRoot + ".typed";
            FileWriter typeOut = new FileWriter(new File(typeOutFile));
            typeOut.write(e.getMessage());
            typeOut.close();
          }

          // If we need to print IR diagnostics, write the lexical error.
          if (commandLine.hasOption("irgen") || commandLine.hasOption("irrun")) {
            String irOutFile = outFileRoot + ".ir";
            Writer out = new FileWriter(new File(irOutFile));
            out.write(e.getMessage());
            out.close();
          }
        } catch (Exception e) {
          // Should never be reached.
          e.printStackTrace();
        }
      }

    } catch (ParseException e) {
      // If the commandline input does not conform to the format
      // xic [options] <sourcefiles>, with all possible options given by the
      // method documentation print the help message and terminate.
      formatter.printHelp("xic", options, true);
      System.exit(0);
    }
  }

  private static String demangle(IRFuncDecl f) {
    int i = f.name().lastIndexOf('_');
    return f.name().substring(2, i);
  }

  public static String formatError(String k, String f, int l, int c, String m) {
    return String.format("%s error beginning at %s:%d:%d: %s", k, f, l, c, m);
  }
}