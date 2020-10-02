package terner;

public class Ternings {
    private final int MAX = 6;
    private int faceValue;

    public Ternings()
    {

    }

    public void roll()
    {
        faceValue = (int)(Math.random()* MAX +1); // Ruller et tilfældigt tal mellem 1 og 6
    }

    public int getFaceValue()
    {
        return faceValue;
    }
}

