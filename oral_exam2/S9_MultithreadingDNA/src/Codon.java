/**
 * The Codon enumeration is used for the transcription from DNA to RNA
 */
public enum Codon {

    UUU("Phe", 'F'), UCU("Ser", 'S'), UAU("Tyr", 'Y'), UGU("Cys", 'C'),
    UUC("Phe", 'F'), UCC("Ser", 'S'), UAC("Tyr", 'Y'), UGC("Cys", 'C'),
    UUA("Leu", 'L'), UCA("Ser", 'S'), UAA("Stop", '*'), UGA("Stop", '*'),
    UUG("Leu", 'L'), UCG("Ser", 'S'), UAG("Stop", '*'), UGG("Trp", 'N'),

    CUU("Leu", 'L'), CCU("Pro", 'P'), CAU("His", 'H'), CGU("Arg", 'R'),
    CUC("Leu", 'L'), CCC("Pro", 'P'), CAC("His", 'H'), CGC("Arg", 'R'),
    CUA("Leu", 'L'), CCA("Pro", 'P'), CAA("Gln", 'Q'), CGA("Arg", 'R'),
    CUG("Leu", 'L'), CCG("Pro", 'P'), CAG("Gln", 'Q'), CGG("Arg", 'R'),

    AUU("Ile", 'I'), ACU("Thr", 'T'), AAU("Asn", 'N'), AGU("Ser", 'S'),
    AUC("Ile", 'I'), ACC("Thr", 'T'), AAC("Asn", 'N'), AGC("Ser", 'S'),
    AUA("Ile", 'I'), ACA("Thr", 'T'), AAA("Lys", 'K'), AGA("Arg", 'R'),
    AUG("Met", 'M'), ACG("Thr", 'T'), AAG("Lys", 'K'), AGG("Arg", 'R'),

    GUU("Val", 'V'), GCU("Ala", 'A'), GAU("Asp", 'D'), GGU("Gly", 'G'),
    GUC("Val", 'V'), GCC("Ala", 'A'), GAC("Asp", 'D'), GGC("Gly", 'G'),
    GUA("Val", 'V'), GCA("Ala", 'A'), GAA("Glu", 'E'), GGA("Gly", 'G'),
    GUG("Val", 'V'), GCG("Ala", 'A'), GAG("Glu", 'E'), GGG("Gly", 'G');

    /**
     * Genetic Code for the RNA sequence
     */
    private String geneticCode;
    /**
     * One Letter Code for RNA
     */
    private Character oneLetterCode;

    private Codon (String geneticCode, Character oneLetterCode) {

        this.geneticCode = geneticCode;
        this.oneLetterCode = oneLetterCode;

    }

    /**
     * @return Genetic Code
     */
    public String getGeneticCode() {
        return geneticCode;
    }

    /**
     * @return One Letter Code
     */
    public Character getOneLetterCode() {
        return oneLetterCode;
    }

    /**
     * This method is used to get the RNA based on the inputted DNA sequence
     * @param codon DNA
     * @return The Codon of the DNA
     */
    public static Codon getCodon(String codon) {
        codon = codon.toUpperCase();
        codon = codon.replace('T', 'U');
        return Codon.valueOf(codon);
    }

}
