package src_jcg284_shg64_hos7_wc523.lexer;

import src_jcg284_shg64_hos7_wc523.parser.sym;


/**
 * This class represents a lexical token.
 * 
 * A token of type STRING, KEY, ID, SYMBOL, or ERROR will have a 
 * String attribute. If the type is ERROR, the string will take the format
 * "error: <description>".
 * A token of type CHARACTER will always have a char attribute.
 * A token of type INT will always have an int attribute containing a
 * nonnegative integer.
 * */
public class Token {
    int type;
    Object attribute;
    int line;
    int column;

    /**
     * Constructor for a token carying a value.
     * @param tt The type of the token.
     * @param attr The value of the token.
     * @param l The zero-indexed line number on which the token starts.
     * @param c The zero-indexed column number on which the token starts.
     */
    Token(int tt, Object attr, int l, int c) {
        type = tt; attribute = attr; line = l + 1; column = c + 1;
    }

    public String getMessage() {
        String attr = getAttributeString();

        switch(type) {
            case sym.STRING_LITERAL:
                return "string " + attr;
            case sym.INTEGER_LITERAL:
                return "integer " + attr;
            case sym.CHARACTER_LITERAL:
                return "character " + attr;
            case sym.IDENTIFIER:
                return "id " + attr;
            default:
                return attr;
        }
    }

    /**
     * Converts the token, along with its associated location data, 
     * to a string.
     * @return The string representation of the token.
     */
    public String toString() {
        String s = String.format("%d:%d ", line, column);
        return s + getMessage();
    }

    /**
     * Getter of the attribute of the token.
     * @return The attribute of the token.
     */
    public Object getAttribute() {
        return attribute;
    }

    /**
     * Get the attribute of the token as a string.
     * @return The string representation of the token.
     */
    public String getAttributeString() {
        String attr;
        switch(type) {
            case sym.INTEGER_LITERAL:
                attr = Long.toUnsignedString((long)getAttribute());
                break;
            default:
                attr = getAttribute().toString();
        }
        switch(type) {
            case sym.STRING_LITERAL:
                return attr.replace("\\", "\\\\")
                           .replace("\n", "\\n")
                           .replace("\'", "\\'")
                           .replace("\"", "\\\"")
                           .replace("\t", "\\t");
            case sym.CHARACTER_LITERAL:
                return attr.replace("\\", "\\\\")
                           .replace("\n", "\\n")
                           .replace("\'", "\\'")
                           .replace("\"", "\\\"")
                           .replace("\t", "\\t");
            default:
                return attr;
        }
    }

     /**
     * Getter of the line number of the token.
     * @return The line number of the token.
     */
    public int getLine() {
        return line;
    }

     /**
     * Getter of the column number of the token.
     * @return The column number of the token.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns a boolean describing whether token represents a lexical error.
     * @return Boolean describing whether the token represents a lexical error.
     */
    public Boolean isError() {
        return type == sym.error;
    }
}