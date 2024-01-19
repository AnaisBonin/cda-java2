public enum Representation {
    X("X"), Y("Y"), EMPTY(" ");

    private final String value;

    private Representation(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
