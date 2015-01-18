// SimpleCalc.g
//
grammar SimpleCalc;

// Declare tokens used:
//
tokens {
    PLUS = '+';
    MINUS = '-';
    MULT = '*';
    DIV = '/';
}

// Create the top-level stuff so we can actually run the parser:
//
@members {
    public static void main(String[] args) throws Exception {
        SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRStringStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        SimpleCalcParser parser = new SimpleCalcParser(tokens);

        try {
            System.out.println(parser.eval());
        }
        catch ( RecognitionException ex ) {
            ex.printStackTrace();
        }
    }
}

// Parser rules:
//
eval returns [double value]:
    e = expr {
        $value = $e.value;
    };

expr returns [double value]:
    // An expression is a "term..."
    m1 = term {
        $value = $m1.value;
    }

    // Followed by zero or many of...
    (
        // Either "+ term"
        (
            PLUS m2 = term {
                $value += $m2.value;
            }
        )

        // Or "- term"
        | (
            MINUS m2 = term {
                $value -= $m2.value;
            }
        )
    )*;

term returns [double value]:
    // A term is a "factor..."
    m1 = factor {
        $value = $m1.value;
    }

    // Followed by zero or many of...
    (
        // Either "* factor"
        (
            MULT m2 = factor {
                $value *= $m2.value;
            }
        )

        // Or "/ factor"
        | (
            DIV m2 = factor {
                $value /= $m2.value;
            }
        )
    )*;

factor returns [double value]:
    // A factor is either a single number:
    (
        n = NUMBER {
            $value = Double.parseDouble($n.text);
        }
    )

    // Or it's a subexpression wrapped in brackets:
    | (
        '(' e = expr ')' {
            $value = $e.value;
        }
    );

// Lexer rules:
//
NUMBER:
    (DIGIT)+;

WHITESPACE:
    ('\t' | ' ' | '\r' | '\n'| '\u000C')+ {
        $channel = HIDDEN;
    };

fragment DIGIT:
    '0'..'9';