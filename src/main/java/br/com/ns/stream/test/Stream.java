package br.com.ns.stream.test;

/**
 * @author almeida.fernando
 */
public interface Stream {

    public char getNext();
    
    public char getPrevious();
    
    public char getPrevious(Integer shift);

    public boolean hasNext();

}



