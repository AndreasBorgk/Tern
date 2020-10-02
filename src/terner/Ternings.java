package terner;

public class Ternings {
    private final int MAX = 6;
    private int faceValue;

    public Ternings()
    {

    }

    public void roll()
    {
        faceValue = (int)(Math.random()* MAX +1);
    }

    public int getFaceValue()
    {
        return faceValue;
    }
}

